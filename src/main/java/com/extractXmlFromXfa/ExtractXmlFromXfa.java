package com.extractXmlFromXfa;

import java.io.ByteArrayOutputStream;
import java.io.FileOutputStream;

import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import com.itextpdf.forms.PdfAcroForm;
import com.itextpdf.forms.xfa.XfaForm;
import com.itextpdf.kernel.pdf.PdfDocument;
import com.itextpdf.kernel.pdf.PdfReader;
import com.itextpdf.kernel.pdf.PdfWriter;

public class ExtractXmlFromXfa {
    static String xmlOutput = System.getProperty("user.dir") + "/src/main/resources/output/xfa_example.xml"; 
    static String src = System.getProperty("user.dir") + "/src/main/resources/xfa_invoice_example.pdf"; 
    // static String xmlOutput = System.getProperty("user.dir") + "/src/main/resources/output/xfa_example_ADS_provisional.xml"; // to delete
    // static String src = System.getProperty("user.dir") + "/src/main/resources/ADS-provisional.pdf"; // to delete


        public static void getXmlFromPdfXfa() {
        try {
            PdfDocument pdfDoc = new PdfDocument(new PdfReader(src), new PdfWriter(new ByteArrayOutputStream()));
            PdfAcroForm form = PdfAcroForm.getAcroForm(pdfDoc, false);
            XfaForm xfa = form.getXfaForm();
            org.w3c.dom.Document domDocument = xfa.getDomDocument();
            Transformer transformer = TransformerFactory.newInstance().newTransformer();
            transformer.setOutputProperty(OutputKeys.INDENT, "yes");
            transformer.transform(
                new DOMSource(domDocument), 
                new StreamResult(new FileOutputStream(xmlOutput)));
            pdfDoc.close();
        } catch (Exception e) {
            System.err.println(e);
        }
    }
}
