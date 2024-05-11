package com.example.duantn.dto;


import com.itextpdf.kernel.geom.PageSize;
import com.itextpdf.kernel.pdf.PdfDocument;
import com.itextpdf.kernel.pdf.PdfWriter;
import com.itextpdf.layout.Document;
import com.itextpdf.layout.element.Paragraph;

import java.io.*;
import java.util.Date;

public class TestCreatePDF {
    public static void main(String[] args) throws FileNotFoundException {
//            OutputStream file = null;
//            try {
//                file = new FileOutputStream(new File("Contacts_2.pdf"));
//
//                // Create a new Document object
//                Document document = new Document();
//
//                // You need PdfWriter to generate PDF document
//                PdfWriter.getInstance(document, file);
//
//                // Opening document for writing PDF
//                document.open();
//
//                // Writing content
//                document.add(new Paragraph("Hello World, Creating PDF document in Java is easy"));
//                document.add(new Paragraph("You are customer: hoanhihi12345 # 2345433"));
//                document.add(new Paragraph(new Date(new java.util.Date().getTime()).toString()));
//
//                // Add meta data information to PDF file
//                document.addCreationDate();
//                document.addAuthor("Javarevisited");
//                document.addTitle("How to create PDF document in Java");
//                document.addCreator("Thanks to iText, writing into PDF is easy");
//
//
//                // close the document
//                document.close();
//
//                System.out.println("Your PDF File is succesfully created");
//
//            } catch (Exception e) {
//                e.printStackTrace();
//            } finally {
//
//                // closing FileOutputStream
//                try {
//                    if (file != null) {
//                        file.close();
//                    }
//                } catch (IOException io) {/*Failed to close*/
//
//                }
//
//            }

        String path="invoice.pdf";
        PdfWriter pdfWriter = new PdfWriter(path);
        PdfDocument pdfDocument = new PdfDocument(pdfWriter);
        pdfDocument.setDefaultPageSize(PageSize.A4);
        Document document = new Document(pdfDocument);

        document.add(new Paragraph("Hello code "));
        document.close();
        System.out.println("Your PDF File is succesfully created");
    }
}
