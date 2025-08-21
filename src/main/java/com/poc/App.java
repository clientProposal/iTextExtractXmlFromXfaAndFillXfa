package com.poc;
import com.itextpdf.forms.PdfAcroForm;
import com.itextpdf.forms.xfa.XfaForm;
import com.itextpdf.kernel.pdf.PdfDocument;
import com.itextpdf.kernel.pdf.PdfReader;
import com.itextpdf.kernel.pdf.PdfWriter;
// import com.fillFormFieldsWithXfa.FillFormFieldsWithXfa;
// import com.createXmlToFillXfa.CreateXmlToFillXfa;
import com.itextpdf.licensing.base.LicenseKey;
import java.io.File;
// import com.extractXmlFromXfa.ExtractXmlFromXfa;
import java.io.FileInputStream;
import com.itextpdf.tool.xml.xtra.xfa.XFAFlattener;
import java.io.FileInputStream;
import java.io.FileOutputStream;

public class App {
    public static void main(String[] args) throws Exception {
        String pathLicenceKey = System.getProperty("user.dir") + "/itextkey.json";
        LicenseKey.loadLicenseFile(new File(pathLicenceKey));
        // ExtractXmlFromXfa.getXmlFromPdfXfa();
        // FillFormFieldsWithXfa.fillForm(CreateXmlToFillXfa.makeXmlString());
FileInputStream input = new FileInputStream(System.getProperty("user.dir") + "/src/main/resources/xfa_invoice_filled.pdf");
FileOutputStream output = new FileOutputStream(System.getProperty("user.dir") + "/src/main/resources/output/xfa_invoice_filled_and_flattened.pdf");
        XFAFlattener flattener = new XFAFlattener();
        flattener.flatten(input, output);
        input.close();
        output.close();

    }
}
