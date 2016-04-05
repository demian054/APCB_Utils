/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.apcb.utils.utils;

import com.apcb.utils.entities.Request;
import com.apcb.utils.paymentHandler.entities.APCB_PayMain;
import com.apcb.utils.ticketsHandler.entities.APCB_Travel;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Rectangle;
import com.itextpdf.text.pdf.PdfWriter;
import com.itextpdf.tool.xml.XMLWorker;
import com.itextpdf.tool.xml.XMLWorkerFontProvider;
import com.itextpdf.tool.xml.XMLWorkerHelper;
import com.itextpdf.tool.xml.css.CssFile;
import com.itextpdf.tool.xml.css.StyleAttrCSSResolver;
import com.itextpdf.tool.xml.html.CssAppliers;
import com.itextpdf.tool.xml.html.CssAppliersImpl;
import com.itextpdf.tool.xml.html.Tags;
import com.itextpdf.tool.xml.parser.XMLParser;
import com.itextpdf.tool.xml.pipeline.css.CSSResolver;
import com.itextpdf.tool.xml.pipeline.css.CssResolverPipeline;
import com.itextpdf.tool.xml.pipeline.end.PdfWriterPipeline;
import com.itextpdf.tool.xml.pipeline.html.AbstractImageProvider;
import com.itextpdf.tool.xml.pipeline.html.HtmlPipeline;
import com.itextpdf.tool.xml.pipeline.html.HtmlPipelineContext;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintWriter;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 *
 * @author Demian
 */
public class PdfCreator {
    private static Logger log = LogManager.getLogger(PdfCreator.class);
    
    public static String createPdfVoucher(APCB_PayMain aPCB_PayMain, PropertiesReader prop) throws Exception {
       
        String vaouche = aPCB_PayMain.getVoucher();
        vaouche = vaouche.replace("&lt;", "<");
        vaouche = vaouche.replace("&gt;", ">");
        vaouche = vaouche.replace("&quot;", "\"");
        vaouche = vaouche.replace("&#39;", "'");
        vaouche = vaouche.replace("&amp;#211;", "O");

        StringBuilder fileName = new StringBuilder();
        fileName.append(prop.getProperty("VauchersPath",false));
        fileName.append(prop.getProperty("Target",false)).append("_");
        fileName.append(aPCB_PayMain.getApproval()).append("_");
        fileName.append(aPCB_PayMain.getCardNumber()).append("_");
        fileName.append(aPCB_PayMain.getCardHolderID());
        
        Document document = new Document(new Rectangle(200, 315), 30f, 30f, 30f, 30f);
        String pdfFileName = createPdf(fileName.toString(), vaouche, document);
        return pdfFileName;
    }
    
    public static String createPdfTicket(Request request, PropertiesReader prop, String fileName) throws Exception {
        String ticketsPath = prop.getProperty("ServerHTMLPath",false)+prop.getProperty("TicketsPath",false);
        String TicketsTemplatePath = prop.getProperty("ServerHTMLPath",false)+prop.getProperty("TicketsTemplatePath",false);
        String TicketsTemplateName = prop.getProperty("TicketsTemplateName",false);
        
        int ticketsWidthPage = 230;
         if (prop.getProperty("TicketsWidthPage",false)!=null){
            try {
                ticketsWidthPage = Integer.valueOf(prop.getProperty("TicketsWidthPage",false));
            } catch (Exception e) {
                log.error("Error to parse TicketsWidthPage error in value "+prop.getProperty("TicketsWidthPage",false),e);
            }
        }
        
        int ticketsHeightPage = 800;
        if (prop.getProperty("TicketsHeightPage",false)!=null){
            try {
                ticketsHeightPage = Integer.valueOf(prop.getProperty("TicketsHeightPage",false));
            } catch (Exception e) {
                log.error("Error to parse TicketsHeightPage error in value "+prop.getProperty("TicketsHeightPage",false),e);
            }
        }

        HtmlTemplateReader htmlTemplateReader = new HtmlTemplateReader(TicketsTemplateName, TicketsTemplatePath);
 
        Document document = new Document(new Rectangle(ticketsWidthPage, ticketsHeightPage), 30f, 30f, 30f, 30f);
        String pdfFileName = PdfCreator.createPdfWStyles(
                ticketsPath+fileName, 
                htmlTemplateReader.process(request), 
                document, 
                htmlTemplateReader.getSourcesFile().get("css"),
                prop.getProperty("ServerHTMLPath",false)+prop.getProperty("ImagesSourcesPath",false)
        );        

        return pdfFileName;
    }
    public static String createPdf(String fileName, String innerHTML) throws Exception {
        Document document = new Document();
        String pdfFileName = createPdf(fileName, innerHTML, document);
        return pdfFileName;
    }
    
    public static String createPdf(String fileName, String innerHTML, Document document) throws Exception {
        
        log.info("Creando HTML nombre: "+fileName);
        File fileHTML = new File(fileName);
        fileHTML.getParentFile().mkdirs();
        PrintWriter writerHTML = new PrintWriter(fileHTML, "UTF-8");
        writerHTML.println(innerHTML);
        writerHTML.flush();
        writerHTML.close();
        log.info("Creado HTML ruta: "+fileHTML.getAbsolutePath());
        
        log.info("Creando PDF nombre: "+fileName+".pdf");
        File filePDF = new File(fileName+".pdf");
        
        filePDF.getParentFile().mkdirs();
        PdfWriter writer = PdfWriter.getInstance(document, new FileOutputStream(fileName+".pdf"));
        writer.setInitialLeading(12);
        document.open();
        XMLWorkerHelper.getInstance().parseXHtml(writer, document, new FileInputStream(fileHTML));
        document.close();

        log.info("Creado PDF ruta: "+filePDF.getAbsolutePath());
        log.info("filePDF.getName() "+filePDF.getName());
        return filePDF.getName();
    }

    public static String createPdfWStyles(String fileName, String innerHTML, Document document, String CSS, String imagesSourcesPath) throws IOException, DocumentException {
        
        log.info("Creando HTML nombre: "+fileName);
        File fileHTML = new File(fileName);
        fileHTML.getParentFile().mkdirs();
        PrintWriter writerHTML = new PrintWriter(fileHTML, "UTF-8");
        writerHTML.println(innerHTML);
        writerHTML.flush();
        writerHTML.close();
        log.info("Creado HTML ruta: "+fileHTML.getAbsolutePath());
        
        log.info("Creando PDF nombre: "+fileName+".pdf");
        File filePDF = new File(fileName+".pdf");
        
        //File file = new File(fileName);
        filePDF.getParentFile().mkdirs();
      
        PdfWriter writer = PdfWriter.getInstance(document, new FileOutputStream(fileName+".pdf"));
        document.open();
        
        CSSResolver cssResolver = new StyleAttrCSSResolver();
        CssFile cssFile = XMLWorkerHelper.getCSS(new ByteArrayInputStream(CSS.getBytes()));
        cssResolver.addCss(cssFile);
 
        // HTML
        HtmlPipelineContext htmlContext = new HtmlPipelineContext(null);
        htmlContext.setTagFactory(Tags.getHtmlTagProcessorFactory());
        
        htmlContext.setImageProvider(new AbstractImageProvider() {
            @Override
            public String getImageRootPath() {
                return imagesSourcesPath;
            }
        });
 
        // Pipelines
        PdfWriterPipeline pdf = new PdfWriterPipeline(document, writer);
        HtmlPipeline html = new HtmlPipeline(htmlContext, pdf);
        CssResolverPipeline css = new CssResolverPipeline(cssResolver, html);
 
        // XML Worker
        XMLWorker worker = new XMLWorker(css, true);
        XMLParser p = new XMLParser(worker);
        p.parse(new ByteArrayInputStream(innerHTML.getBytes()));
 
        document.close();
        log.info("Creado PDF ruta: "+filePDF.getAbsolutePath());
        log.info("filePDF.getName() "+filePDF.getName());
        return filePDF.getName();
    }
    
}
