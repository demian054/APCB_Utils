/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.apcb.utils.utils;

import com.apcb.utils.entities.Request;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import org.apache.log4j.Logger;

/**
 *
 * @author Demian
 */
public class HtmlTemplateReader {
    private final static Logger log = Logger.getLogger(HtmlTemplateReader.class);
    private static Gson gson = new Gson();
    private HashMap<String, String> sourcesFile;
    
    private String sectionTagIni        = "%%(";
    private String sectionTagIniClose   = "%%!(";
    private String sectionTagEnd        = ")%%";
    
    private String sectionValueTagIni        = "%(";
    private String sectionValueTagEnd        = ")%";
    
    private String sourseFiles;
    
    private SectionMatch sectionMatch;
    private String nameTemplate;


    private SectionMatch readJson(JsonElement jsonElement, String from, SectionMatch sectionMatch){
            //log.info(jsonElement.toString());
            //SectionMatch sectionMatchChild = new SectionMatch(from);
            if (jsonElement.isJsonArray()){
                //log.info("JsonArray");
                JsonArray jsonArray = jsonElement.getAsJsonArray(); 
                for (int i = 0; i < jsonArray.size(); i++) {
                    SectionMatch sectionMatchArrayLevel = new SectionMatch(sectionMatch.getName());
                    sectionMatchArrayLevel.setIndex(i);
                    sectionMatch.putChildens(readJson(jsonArray.get(i), from + "["+i+"]",sectionMatchArrayLevel));
                }
            } else if (jsonElement.isJsonObject()){
                //log.info("JsonObject");
                JsonObject jsonObject = jsonElement.getAsJsonObject(); //since you know it's a JsonObject
                Set<Map.Entry<String, JsonElement>> entries = jsonObject.entrySet();//will return members of your object
                for (Map.Entry<String, JsonElement> entry: entries) {
                    //log.info(entry.getKey());
                    sectionMatch.putChildens(readJson(jsonObject.get(entry.getKey()), from + "."+entry.getKey(), new SectionMatch(entry.getKey())));
                }
            } else if (jsonElement.isJsonNull()){
                log.info("JsonNull");
            } else if (jsonElement.isJsonPrimitive()){
                //log.info("JsonPrimitive");
                String jsonVal = jsonElement.getAsString(); 
                //from+= "."+entry.getKey(); 
                sectionMatch.setValue(jsonVal);
                log.info(from+"="+jsonVal);
            }
            
            return sectionMatch;
    }
     
    
    public HtmlTemplateReader(String nameTemplate, String sourseFiles) {
        this.nameTemplate = nameTemplate;
        this.sourseFiles = sourseFiles;
        sourcesFile = new HashMap<String, String>();
        loadFileTemplate("html");
        loadFileTemplate("css");    
    }
    
    public String process(Object dataInput){
        sectionMatch = readJson(new JsonParser().parse(gson.toJson(dataInput)), "", new SectionMatch(dataInput.getClass().getSimpleName()));
        return processIterate(sectionMatch,sourcesFile.get("html")); 
    }
    
  
    private String processIterate(SectionMatch sectionMatch, String  strHtmlSection ) {
  
            String strHtmlSectionToProcess = strHtmlSection;
            for (SectionMatch sectionMatchChild : sectionMatch.getSectionMatchMap()) {
                //log.info("sectionMatchChild.getName()" +sectionMatchChild.getName());
                if (sectionMatchChild.getValue()==null){
                    
                    if (sectionMatchChild.getIndex()!=null){
                        if (sectionMatchChild.getIndex()==0){
                            strHtmlSection = "";
                        }
                        strHtmlSectionToProcess = strHtmlSectionToProcess.replace("$(IterateNum)$",String.valueOf(sectionMatchChild.getIndex()+1));
                        
                        /*int tagIni =  strHtmlSection.indexOf(sectionTagIni+sectionMatchChild.getName()+sectionTagEnd)+(sectionTagIni+sectionMatchChild.getName()+sectionTagEnd).length();
                        int tagEnd =  strHtmlSection.indexOf(sectionTagIniClose+sectionMatchChild.getName()+sectionTagEnd);
                        String strHtmlSectionChildToReplace = strHtmlSection.substring(tagIni,tagEnd);*/
                        
                        /*log.info("strHtmlSectionProcess" +strHtmlSectionToProcess);
                        log.info("sectionMatchChild.getIndex()" +sectionMatchChild.getIndex());*/
                        strHtmlSection += processIterate(sectionMatchChild,  strHtmlSectionToProcess);
                        //log.info("strHtmlSectionProcess" +strHtmlSection);
                        //    strHtmlSection = strHtmlSection.replace(strHtmlSectionChildToReplace, processIterate(sectionMatchChild,  strHtmlSectionChildToReplace)); 
                    } else {
                        if (strHtmlSection.contains(sectionTagIni+sectionMatchChild.getName()+sectionTagEnd) 
                                    && strHtmlSection.contains(sectionTagIniClose+sectionMatchChild.getName()+sectionTagEnd)){
                           
                            int tagIni =  strHtmlSection.indexOf(sectionTagIni+sectionMatchChild.getName()+sectionTagEnd);
                            int tagEnd =  strHtmlSection.indexOf(sectionTagIniClose+sectionMatchChild.getName()+sectionTagEnd)+(sectionTagIniClose+sectionMatchChild.getName()+sectionTagEnd).length();
                            String strHtmlSectionChildToReplace = strHtmlSection.substring(tagIni,tagEnd);
                            strHtmlSection = strHtmlSection.replace(strHtmlSectionChildToReplace, processIterate(sectionMatchChild,  strHtmlSectionChildToReplace)); 
                        } 
                    }
                 } else {
                    //log.info("sectionMatchChild.getValue()" +sectionMatchChild.getValue());
                    if (strHtmlSection.contains(sectionValueTagIni+sectionMatchChild.getName()+sectionValueTagEnd)){
                        strHtmlSection = strHtmlSection.replace(sectionValueTagIni+sectionMatchChild.getName()+sectionValueTagEnd, sectionMatchChild.getValue());
                    }
                }
            }
            strHtmlSection = strHtmlSection.replace(sectionTagIni+sectionMatch.getName()+sectionTagEnd, "");
            strHtmlSection = strHtmlSection.replace(sectionTagIniClose+sectionMatch.getName()+sectionTagEnd, "");
        return strHtmlSection;
    }
  
  private String loadFileTemplate(String extencion){
        StringBuilder contentFile = new StringBuilder();
        try {
            BufferedReader bufferedReader = new BufferedReader(new FileReader(sourseFiles+nameTemplate+"."+extencion));
            String str;
            while ((str = bufferedReader.readLine()) != null) {
                contentFile.append(str);
            }
            bufferedReader.close(); 
            sourcesFile.put(extencion, contentFile.toString());
        } catch (Exception e) {
            log.error("can´t read Template "+extencion+" in "+sourseFiles+nameTemplate+"."+extencion, e);             
        }
        return contentFile.toString();
    }

    public HashMap<String, String> getSourcesFile() {
        return sourcesFile;
    }

    public void setSourcesFile(HashMap<String, String> sourcesFile) {
        this.sourcesFile = sourcesFile;
    }

    public String getNameTemplate() {
        return nameTemplate;
    }

    public void setNameTemplate(String nameTemplate) {
        this.nameTemplate = nameTemplate;
    }
  
  
  
   public class SectionMatch {
        String value;
        String name;
        Integer index;
        List<SectionMatch> SectionMatchMap;

        public SectionMatch(String from) { 
            String[] fromSeparated = from.split(".");
            if (fromSeparated.length>0){
                name = fromSeparated[fromSeparated.length-1];
            } else {
                name = from;
            }
        }
        public void putChildens(SectionMatch SectionMatch) {
            if (SectionMatchMap == null){
                SectionMatchMap = new ArrayList<SectionMatch>();
            }
            SectionMatchMap.add(SectionMatch);
        }

        public String getValue() {
            return value;
        }

        public void setValue(String value) {
            this.value = value;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public List<SectionMatch> getSectionMatchMap() {
            return SectionMatchMap;
        }

        public void setSectionMatchMap(List<SectionMatch> SectionMatchMap) {
            this.SectionMatchMap = SectionMatchMap;
        }

        public Integer getIndex() {
            return index;
        }

        public void setIndex(Integer index) {
            this.index = index;
        }
        
 
    }

    

}
