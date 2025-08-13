package com.createXmlToFillXfa;

public class CreateXmlToFillXfa {
        public static String makeXmlString() {
        String start =
            "<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n" +
            "<xfa:datasets xmlns:xfa=\"http://www.xfa.org/schema/xfa-data/1.0/\">\n" +
            "    <xfa:data>\n" +
            "        <iText_XFAInvoice>\n" +
            "            <CustomerDetails>\n" +
            "                <TextField_CompanyName>Apryse</TextField_CompanyName>\n" +
            "                <TextField_ContactPerson>Jo Geoghegan</TextField_ContactPerson>\n" +
            "                <TextField_email>josephine.geoghegan@apryse.com</TextField_email>\n" +
            "                <NumericField_TelephoneNumber>+34 658196129</NumericField_TelephoneNumber>\n" +
            "            </CustomerDetails>\n" +
            "           <Subform_pdfHTMLDescription xfa:dataNode=\"dataGroup\"/>\n";
        String end =
            "        </iText_XFAInvoice>\n" +
            "    </xfa:data>\n" +
            "</xfa:datasets>";
        for (int i = 0; i <= 5; i++) {
            start += "            <Subform_Order>\n";
            start += "                <NumericField_NrLicenses>" + 1.00000000 + "</NumericField_NrLicenses>\n";
            start += "                <TextField_CompanyName>Company " + (i+1) + "</TextField_CompanyName>\n";
            start += "                <RadioButtonList_Language>"+ ((i % 2) + 1) + "</RadioButtonList_Language>\n";
            start += "                <DropDownList_Type>"+ ((i % 2) + 1) + "</DropDownList_Type>\n";
            start += "                <DropDownList_ServerDesktop>"+ ((i % 2) + 1) + "</DropDownList_ServerDesktop>\n";
            start += "                <TextField_DeveloperAlias>Developer" + ((i % 2) + 1) + "</TextField_DeveloperAlias>\n";
            start += "            </Subform_Order>\n";
        }
        start += end;
        return start;
    }
    
}
