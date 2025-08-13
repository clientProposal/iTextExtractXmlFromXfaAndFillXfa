package com.poc;
import com.fillFormFieldsWithXfa.FillFormFieldsWithXfa;
import com.createXmlToFillXfa.CreateXmlToFillXfa;
import com.itextpdf.licensing.base.LicenseKey;
import java.io.File;
import com.extractXmlFromXfa.ExtractXmlFromXfa;

public class App {
    public static void main(String[] args) throws Exception {
        String pathLicenceKey = System.getProperty("user.dir") + "/itextkey.json";
        LicenseKey.loadLicenseFile(new File(pathLicenceKey));
        ExtractXmlFromXfa.getXmlFromPdfXfa();
        FillFormFieldsWithXfa.fillForm(CreateXmlToFillXfa.makeXmlString());
    }
}
