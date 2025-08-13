package com.fillFormFieldsWithXfa;

import java.io.ByteArrayInputStream;
import java.nio.charset.StandardCharsets;
import com.itextpdf.forms.PdfAcroForm;
import com.itextpdf.forms.xfa.XfaForm;
import com.itextpdf.kernel.pdf.PdfDocument;
import com.itextpdf.kernel.pdf.PdfReader;
import com.itextpdf.kernel.pdf.PdfWriter;
import com.itextpdf.kernel.pdf.StampingProperties;

public class FillFormFieldsWithXfa {
    public static void fillForm(String xfaString) throws Exception {
        String src = System.getProperty("user.dir") + "/src/main/resources/xfa_invoice_example.pdf";
        String dest = System.getProperty("user.dir") + "/src/main/resources/output/xfa_invoice_filled.pdf";

        PdfDocument pdfDoc = new PdfDocument(
                new PdfReader(src),
                new PdfWriter(dest),
                new StampingProperties().useAppendMode());
        PdfAcroForm form = PdfAcroForm.getAcroForm(pdfDoc, true);
        XfaForm xfa = form.getXfaForm();

        xfa.fillXfaForm(new ByteArrayInputStream(xfaString.getBytes(StandardCharsets.UTF_8)));
        xfa.write(pdfDoc);
        pdfDoc.close();
    }
}