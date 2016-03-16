/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.apcb.utils.utils;

import com.apcb.utils.paymentHandler.entities.APCB_PayMain;
import com.apcb.utils.ticketsHandler.entities.APCB_Travel;
import com.itextpdf.text.Document;
import com.itextpdf.text.Rectangle;
import com.itextpdf.text.pdf.PdfWriter;
import com.itextpdf.tool.xml.XMLWorkerHelper;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.PrintWriter;
import org.apache.log4j.Logger;

/**
 *
 * @author Demian
 */
public class PdfCreator {
    private final static Logger log = Logger.getLogger(PdfCreator.class);
    
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
    
    public static String createPdfTicket(APCB_Travel travel, PropertiesReader prop) throws Exception {

        StringBuilder fileName = new StringBuilder();
        fileName.append(prop.getProperty("TicketsPath",false));
        fileName.append(prop.getProperty("Target",false)).append("_");
        if (prop.getProperty("Simulate",false).equalsIgnoreCase("true")){
            fileName.append("Simulate_");
        }
        fileName.append(travel.getTicketNumber());
        
        Document document = new Document(new Rectangle(200, 315), 30f, 30f, 30f, 30f);

        String pdfFileName = createPdf(fileName.toString(), travel.getTicket(), document);
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
        /*File fileGarbage = new File(fileName.toString());
        fileGarbage.delete();*/
        log.info("Creado PDF ruta: "+filePDF.getAbsolutePath());
        log.info("filePDF.getName() "+filePDF.getName());
        return filePDF.getName();
    }

    
}
