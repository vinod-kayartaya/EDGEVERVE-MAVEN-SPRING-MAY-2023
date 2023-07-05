package com.infosys.utils;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;

import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;
import com.itextpdf.tool.xml.XMLWorkerHelper;

public class PdfGenerator {
	public static byte[] generatePdfReport(String content) throws DocumentException {
        Document document = new Document();
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        PdfWriter.getInstance(document, byteArrayOutputStream);

        document.open();
        document.add(new Paragraph(content));
        document.close();

        return byteArrayOutputStream.toByteArray();
    }
	
	public static byte[] generatePdfReportFromHtml(String htmlContent) throws DocumentException, IOException {
        Document document = new Document();
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();

        // Create a PdfWriter instance
        PdfWriter writer = PdfWriter.getInstance(document, byteArrayOutputStream);
        writer.setCloseStream(false); // Avoid closing the stream prematurely

        document.open();

        // Parse and convert HTML to PDF
        ByteArrayInputStream inputStream = new ByteArrayInputStream(htmlContent.getBytes());
        XMLWorkerHelper.getInstance().parseXHtml(writer, document, inputStream);

        document.close();
        writer.close();

        return byteArrayOutputStream.toByteArray();
    }
}
