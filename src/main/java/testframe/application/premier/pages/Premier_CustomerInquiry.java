package testframe.application.premier.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import testframe.application.common.CommonLibrary;
import testframe.common.reporting.HTMLReportHelper;
import testframe.common.utilities.DateTimeHelper;
import testframe.common.utilities.ExcelReader;

/**
 * 
 * 
 * @author Moksha.Mukh
 */

public class Premier_CustomerInquiry extends CommonLibrary {

	public String homePage = "Customer Inquiry page";
	String sName,sFName,sLName,sTaxID,sDOB,sEmail,sPhonenumber,sAddress1,sAddress2,sZipcode,sRelationship;
	String[] sName_split; 

	public By customerInquiryHeader =  By.xpath("//div[text()='Customer - Customer Inquiry']");
	public By nameSearch =  By.xpath("//input[@name='Sound']");
	public By ssnSearch =  By.xpath("//input[@name='TaxID']");
	public By submitSearch =  By.xpath("//button[@name='Submit']");
	public By customerAnalysisHeader =  By.xpath("//td[@id='Customer AnalysisText']");
	public By seeAdditionalAddress =  By.xpath("//u[text()='See Additional Addresses']");
	public By summaryHeader =  By.xpath("//td[@id='SummaryText']");
	public By customerInfoExpand =  By.xpath("//td[contains(@id,'Customer')]");
	public By nameExpand =  By.xpath("//img[@class='csr-hand']");
	public By name =  By.xpath("(//td[@class=' tc-usr-information txt-left'])[2]");
	public By taxIdentification =  By.xpath("(//td[@class=' tc-usr-information txt-right'])[1]");
	public By dob =  By.xpath("(//td[@class=' tc-usr-information txt-right'])[2]");
	public By email =  By.xpath("(//td[@class=' tc-usr-information txt-right'])[4]");
	public By phonenumber =  By.xpath("(//td[@class=' tc-usr-information txt-right'])[3]");
	//public By address1 =  By.xpath("(//td[@class=' tc-usr-information txt-left'])[11]");
	//public By address2 =  By.xpath("(//td[@class=' tc-usr-information txt-left'])[12]");
	//public By zipcode =  By.xpath("(//td[@class=' tc-usr-information txt-left'])[13]");
	public By address1 =  By.xpath("(//td[@class=' tc-usr-information txt-left'])[4]");
	public By address2 =  By.xpath("(//td[@class=' tc-usr-information txt-left'])[6]");
	public By zipcode =  By.xpath("(//td[@class=' tc-usr-information txt-left'])[8]");
	String sDelimiter;
	String sInquireData = "//td[text()='%s']";
	String sInquireLinkData = "//u[text()='%s']";

	public By relationship =  By.xpath("(//td[@class=' tc-usr-information txt-left'])[14]");

	public Premier_CustomerInquiry(WebDriver driver) throws Exception {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}


	public void searchCustomer(String sName, String sSSN) throws Exception{
		if (System.getProperty("runStep")=="Y"){
			boolean stepResult = false;
			try {
				if (isElementPresent(customerInquiryHeader)){
					switchToFrameWithName("Main");
					enterText("Customer Inquiry Page", "Tax Identification", ssnSearch, sSSN);
					clickOnElement("Customer Inquiry", "Submit", submitSearch);
					stepResult = true;
					switchToDefaultContent();
				}	
			}catch (Exception e) {
				e.printStackTrace();
			}
			finally {
				if (stepResult==true){
					System.out.println("Pass");
					new HTMLReportHelper().HtmlReportBody("Search a customer", "Search customer Successfully", "Passed", driver, "Y");
				}
				else{
					System.out.println("fail");
					new HTMLReportHelper().HtmlReportBody("Search a customer", "Could not search the Customer" , "Failed", driver, "Y");
					System.setProperty("runStep","N");
				}
			}
		}
	}


	public void seeAdditionalAddresses() throws Exception{
		if (System.getProperty("runStep")=="Y"){
			boolean stepResult = false;
			try {

				if (isElementPresent(customerInquiryHeader)){
					//enterText("Customer Inquiry Page", "Name", nameSearch, sName);
					switchToWithinFrameWithName("Main");
					switchToWithinFrameWithName("bottom");
					waitForPresenceOfElement("Customer Inquiry page", "Customer Analaysis Header", customerAnalysisHeader);
					clickOnElement("Customer Inquiry", "See Additional Addresses", seeAdditionalAddress);
					switchToDefaultContent();
					stepResult = true;
				}	
			}catch (Exception e) {
				e.printStackTrace();
			}
			finally {
				if (stepResult==true){
					System.out.println("Pass");
					new HTMLReportHelper().HtmlReportBody("Click on See Additional Addresses", "See Additional Addresses click Successfully", "Passed", driver, "Y");
				}
				else{
					System.out.println("fail");
					new HTMLReportHelper().HtmlReportBody("Click on See Additional Addresses", "Could not click See Additional Addresses" , "Failed", driver, "Y");
					System.setProperty("runStep","N");
				}
			}
		}

	}

	public void customerExpand() throws Exception{
		if (System.getProperty("runStep")=="Y"){
			boolean stepResult = false;
			try {
				if (isElementPresent(customerInquiryHeader)){
					switchToWithinFrameWithName("Main");
					switchToWithinFrameWithName("bottom");
					//enterText("Customer Inquiry Page", "Name", nameSearch, sName);
					waitForPresenceOfElement("Customer Inquiry page", "Summary Header", summaryHeader);
					clickOnElement("Customer Inquiry Page", "Customer Expand", customerInfoExpand);
					clickOnElement("Customer Inquiry Page", "Name Expand", nameExpand);
					switchToDefaultContent();
					stepResult = true;
				}	
			}catch (Exception e) {
				e.printStackTrace();
			}
			finally {
				if (stepResult==true){
					System.out.println("Pass");
					new HTMLReportHelper().HtmlReportBody("Expand Customer details", "Expand customer Successfully", "Passed", driver, "Y");
				}
				else{
					System.out.println("fail");
					new HTMLReportHelper().HtmlReportBody("Expand Customer details", "Could not Expand customer" , "Failed", driver, "Y");
					System.setProperty("runStep","N");
				}
			}
		}
	}


	public void getCustomer(String excelFilePath, String sheetName,int rowNo) throws Exception{
		if (System.getProperty("runStep")=="Y"){
			boolean stepResult = false;
			try {
				if (isElementPresent(customerInquiryHeader)){
					switchToWithinFrameWithName("Main");
					switchToWithinFrameWithName("bottom");
					//enterText("Customer Inquiry Page", "Name", nameSearch, sName);
					sName=getElementText("Customer Inquiry", "Name",  name);
					if(sName != ""){
						new ExcelReader().setValueInColumnforRow(excelFilePath,  sheetName, "Name", rowNo, sName);
						sName_split= sName.split(" ");
						new ExcelReader().setValueInColumnforRow(excelFilePath,  sheetName, "FirstName", rowNo, sName_split[0]);
						if (sName_split.length > 1)
							new ExcelReader().setValueInColumnforRow(excelFilePath,  sheetName, "LastName", rowNo, sName_split[(sName_split.length)-1]);
					}	
					sTaxID=getElementText("Customer Inquiry", "Tax Identification",  taxIdentification);
					if(sTaxID != "")
						new ExcelReader().setValueInColumnforRow(excelFilePath,  sheetName, "TaxIdentification", rowNo, sTaxID);
					sDOB=getElementText("Customer Inquiry", "Date of birth",  dob);
					if(sDOB != ""){
						sDOB = new DateTimeHelper().getDateTime(sDOB,"MMM dd, yyyy","MM/dd/yyyy");
						new ExcelReader().setValueInColumnforRow(excelFilePath,  sheetName, "DOB", rowNo, sDOB);
					}
					sEmail=getElementText("Customer Inquiry", "Email",  email);
					if(sEmail != "")
						new ExcelReader().setValueInColumnforRow(excelFilePath,  sheetName, "Email", rowNo, sEmail);
					sPhonenumber=getElementText("Customer Inquiry", "Phone Number",  phonenumber);
					if(sPhonenumber != "")
						new ExcelReader().setValueInColumnforRow(excelFilePath,  sheetName, "PhoneNumber", rowNo, sPhonenumber);
					sAddress1=getElementText("Customer Inquiry", "Address1",  address1);
					if(sAddress1 != "")
						new ExcelReader().setValueInColumnforRow(excelFilePath,  sheetName, "Address1", rowNo, sAddress1);
					sAddress2=getElementText("Customer Inquiry", "Address2",  address2);
					if(sAddress2 != "")
						new ExcelReader().setValueInColumnforRow(excelFilePath,  sheetName, "Address2", rowNo, sAddress2);
					sZipcode=getElementText("Customer Inquiry", "City State Zip",  zipcode);
					if(sZipcode != "")
						new ExcelReader().setValueInColumnforRow(excelFilePath,  sheetName, "Zipcode", rowNo, sZipcode);
					sRelationship=getElementText("Customer Inquiry", "Relationship",  relationship);
					if(sRelationship != "")
						new ExcelReader().setValueInColumnforRow(excelFilePath,  sheetName, "Relationship", rowNo, sRelationship);


					switchToDefaultContent();
					stepResult = true;
				}	
			}catch (Exception e) {
				e.printStackTrace();
			}
			finally {
				if (stepResult==true){
					System.out.println("Pass");
					new HTMLReportHelper().HtmlReportBody("Get customer details", "Customer details captured Successfully", "Passed", driver, "Y");
				}
				else{
					System.out.println("fail");
					new HTMLReportHelper().HtmlReportBody("Get customer details", "Could not capture the Customer details" , "Failed", driver, "Y");
					System.setProperty("runStep","N");
				}
			}
		}
	}

	public void validateCustomerDetails(String customerName, String sSN, String phoneNumber, String eMailID,String sAddress1,String sAddress2,String zipCode,String sSSNRelationship,String sBeneficialOnwerName) throws Exception {
		boolean stepResult = false;
		try {
			if (isElementPresent(customerInquiryHeader)){
				switchToWithinFrameWithName("Main");
				switchToWithinFrameWithName("bottom");
				if (!(customerName.equals("")))
					validateTextEquals("Customer Inquiry" , "Name", name, customerName);
				if (!(sSN.equals("")))
					validateTextContains("Customer Inquiry" , "SSN", taxIdentification, sSN);
				if (!(phoneNumber.equals(""))){
					if(phoneNumber.contains("||") || phoneNumber.contains(",")){
						if (phoneNumber.contains("||"))
							sDelimiter="\\|\\|";
						else if(phoneNumber.contains(","))
							sDelimiter=",";
						for (int i=0; i<phoneNumber.split(sDelimiter).length;i++){
							validateTextContains("Customer Inquiry" , "Phone Number", phonenumber, phoneNumber.split(sDelimiter)[i]);
						}
					}
					else
						validateTextContains("Customer Inquiry" , "Phone Number", phonenumber, phoneNumber);
				}
				if (!(eMailID.equals(""))){
					if(eMailID.contains("||") || eMailID.contains(",")){
						if (eMailID.contains("||"))
							sDelimiter="\\|\\|";
						else if(eMailID.contains(","))
							sDelimiter=",";
						for (int i=0; i<eMailID.split(sDelimiter).length;i++){
							validateTextContains("Customer Inquiry" , "Relationship Type", email, eMailID.split(sDelimiter)[i]);
						}	
					}
					else
						validateTextContains("Customer Inquiry" , "Email ID",email , eMailID);
				}	
				if (!(sAddress1.equals("")))
					validateTextEquals("Customer Inquiry" , "Address 1", getDynamicElement("Customer Inquiry",sInquireLinkData,sAddress1), sAddress1);
				if (!(sAddress2.equals("")))
					validateTextEquals("Customer Inquiry" , "Address 2", getDynamicElement("Customer Inquiry",sInquireData,sAddress2), sAddress2);
				if (!(zipCode.equals("")))
					validateTextEquals("Customer Inquiry" , "Zip Code", getDynamicElement("Customer Inquiry",sInquireData,zipCode), zipCode);
				if (!(sSSNRelationship.equals(""))){
					if(sSSNRelationship.contains("||") || sSSNRelationship.contains(",")){
						if (sSSNRelationship.contains("||"))
							sDelimiter="\\|\\|";
						else if(sSSNRelationship.contains(","))
							sDelimiter=",";
						for (int i=0; i<sSSNRelationship.split(sDelimiter).length;i++){
							validateTextEquals("Customer Inquiry" , "Relationship Type", getDynamicElement("Customer Inquiry",sInquireData,sSSNRelationship.split(sDelimiter)[i]), sSSNRelationship.split(sDelimiter)[i]);
						}	
					}
					else	
						validateTextEquals("Customer Inquiry" , "Relationship Type", getDynamicElement("Customer Inquiry",sInquireData,sSSNRelationship), sSSNRelationship);
				}
				if (!(sBeneficialOnwerName.equals(""))){
					if(sBeneficialOnwerName.contains("||") || sBeneficialOnwerName.contains(",")){
						if (sBeneficialOnwerName.contains("||"))
							sDelimiter="\\|\\|";
						else if(sBeneficialOnwerName.contains(","))
							sDelimiter=",";
						for (int i=0; i<sBeneficialOnwerName.split(sDelimiter).length;i++){
							validateTextEquals("Customer Inquiry" , "Beneficial Owner Name", getDynamicElement("Customer Inquiry",sInquireLinkData,sBeneficialOnwerName.split(sDelimiter)[i]), sBeneficialOnwerName.split(sDelimiter)[i]);
						}	
					}
					else
						validateTextEquals("Customer Inquiry" , "Beneficial Owner Name", getDynamicElement("Customer Inquiry",sInquireLinkData,sBeneficialOnwerName), sBeneficialOnwerName);
				}
				switchToDefaultContent();
				stepResult = true;

			}
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			if (stepResult==true){
				System.out.println("Pass");
				new HTMLReportHelper().HtmlReportBody("Customer Details Validation", "Validated Customer Details on Customer Inquiry page Successfully", "Passed", driver, "Y");
			}
			else{
				switchToDefaultContent();
				System.out.println("fail");
				new HTMLReportHelper().HtmlReportBody("Customer Details Validation", "Could not Validated Customer Details on Customer Inquiry page" , "Failed", driver, "Y");
			}
		}}

}
