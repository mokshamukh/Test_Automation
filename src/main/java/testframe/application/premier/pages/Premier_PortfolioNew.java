package testframe.application.premier.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;

import testframe.application.common.CommonLibrary;
import testframe.common.reporting.HTMLReportHelper;
import testframe.common.utilities.ExcelReader;

public class Premier_PortfolioNew extends CommonLibrary{
	public String sPortfolioNo;
	
	public By newPortfolioHeader =  By.xpath("//td[text()='New Portfolio']");
	public By customerPageTitle =  By.xpath("//a[text()='Step 1 - Customer']");
	public By addNameLink =  By.xpath("//u[text()='Add Name']");
	//public By name1Textbox =  By.xpath("//td[contains(text(),'Name 1:')]/following-sibling::td/input[contains(@id,'Name')]");
	//public By taxCode1List =  By.xpath("//td[contains(text(),'Name 1:')]/following-sibling::td//select[contains(@id,'TaxIdCode')]");
	//public By taxNumber1Textbox =  By.xpath("//td[contains(text(),'Name 1:')]/following-sibling::td//input[contains(@id,'TaxIdNumber')]");
	//public By dOBTextbox1 =  By.xpath("//td[contains(text(),'Name 1:')]/following-sibling::td//input[contains(@id,'DateOfBirth')]");
	//public By search1 =  By.xpath("//td[contains(text(),'Name 1:')]/following-sibling::td//img[@title='Search']");
	String name1Textbox =  "//td[contains(text(),'Name %s:')]/following-sibling::td/input[contains(@id,'Name')]";
	String taxCode1List =  "//td[contains(text(),'Name %s:')]/following-sibling::td//select[contains(@id,'TaxIdCode')]";
	String taxNumber1Textbox =  "//td[contains(text(),'Name %s:')]/following-sibling::td//input[contains(@id,'TaxIdNumber')]";
	String dOBTextbox1 =  "//td[contains(text(),'Name %s:')]/following-sibling::td//input[contains(@id,'DateOfBirth')]";	
	String search1 = "//td[contains(text(),'Name %s:')]/following-sibling::td//img[@title='Search']";
	public By address1 =  By.xpath("//td[contains(text(),'Address 1:')]/following-sibling::td/input[contains(@id,'Address')]");
	public By address2 =  By.xpath("//td[contains(text(),'Address 2:')]/following-sibling::td/input[contains(@id,'Address')]");
	public By cityStateZip =  By.xpath("//td[contains(text(),'City State Zip:')]/following-sibling::td/input[contains(@id,'CityStZip')]");
	public By searchAddress =  By.xpath("//td[contains(text(),'Address 1:')]/following-sibling::td//img[@title='Search']");
	public By deliveryPoint =  By.xpath("//td[contains(text(),'Delivery Point:')]/following-sibling::td/input[contains(@id,'DeliveryPt')]");
	public By branchRegionTextbox =  By.xpath("(//input[contains(@id,'BranchNumber')])[1]");
	public By branchRegionButton =  By.xpath("(//input[contains(@id,'BranchNumber')])[3]");
	String branchRegionList =  "//select[contains(@id,'BranchNumber')]/option[contains(text(),'%s')]";
	public By accountingBranch =  By.xpath("//td[contains(text(),'Accounting Branch:')]/following-sibling::td/input[contains(@id,'AccountingGroup')]");
	public By duplicatePageTitle =  By.xpath("//a[text()='Step 2 - Possible Duplicates']");
	public By duplicateMsg =  By.xpath("//td[contains(text(),'No duplicate matches were found.')]");
	public By duplicateMsgNameAddress =  By.xpath("(//td[contains(text(),'No duplicate matches were found.')])[1]");
	public By existingNameRadioButton =  By.xpath("(//td[contains(text(),'Existing Name')]/following-sibling::td/input[contains(@id,'RelatedToIdRadio')])[1]");
	public By nameRelationshipPageTitle =  By.xpath("//a[text()='Step 3 - Name Relationship']");
	String name_NameRelationshipPage =  "//td/b[text()='Name']/../../following-sibling::tr//u[contains(text(),'%s')]";
	public By relationshipListFirst =  By.xpath("(//select[contains(@id,'RelationshipCode')])[1]");
	String relationshipList =  "(//select[contains(@id,'RelationshipCode')])[%s]";
	public By addressPageTitle =  By.xpath("//a[text()='Step 4 - Address']");
	public By codesPageTitle =  By.xpath("//a[text()='Step 5 - Codes']");
	public By nextAvailableLink = By.xpath("//u[text()='Next Available']");
	public By portfolioTextbox =  By.xpath("//td[contains(text(),'Portfolio:')]/following-sibling::td/input[contains(@id,'PortfolioNumber')]");
	public By portfolioTypeCode =  By.xpath("//td[contains(text(),'Portfolio Type Code:')]/following-sibling::td/input[contains(@id,'AccountTypeCode')]");
	public By miscCode =  By.xpath("//td[contains(text(),'Miscellaneous Code:')]/following-sibling::td/input[contains(@id,'MiscCode')]");
	public By responsibilityCodeInput =  By.xpath("(//input[contains(@name,'ResponsibilityCode')])[1]");
	public By responsibilityCodeButton =  By.xpath("(//input[contains(@name,'ResponsibilityCode')])[3]");
	String responsibilityCodeList =  "//select[contains(@name,'ResponsibilityCode')]/option[contains(text(),'%s')]";
	public By nextButton = By.xpath("//button[@value='Next']");
	public By finishButton = By.xpath("//button[@value='Finish']");
	String portfolioNameFormatCodeList =  "(//td[contains(text(),'Name Format Code')])[%s]/following-sibling::td/select";
	String portfolioAddPhoneLink =  "(//u[contains(text(),'Add Phone')])[%s]";
	String portfolioPhoneNumberTextBox =  "(//input[contains(@id,'PhoneNumber')])[%s]";
	String portfolioAddEmailLink =  "(//u[contains(text(),'Add E-Mail')])[%s]";
	String portfolioEMailTextBox =  "(//input[contains(@id,'ContactInfo')])[%s]";
	public By searchTitle = By.xpath("//label[text()='Search']");
	public By searchTitle2 = By.xpath("//td[contains(text(),'Search')]");
	public By addressSearch = By.xpath("//input[@name='Address']");
	public By streetSearch = By.xpath("//input[@name='StreetName']");
	public By addressIDSearch = By.xpath("//input[@name='AddressID']");
	public By submitSearch = By.xpath("//button[text()='Submit']");
	public By addressLink = By.xpath("(//a[contains(@id,'SearchType=Address')])[1]");
	//Change Portfolio xpaths are below
	public By portfolioSearch = By.xpath("//td[contains(text(),'Portfolio Number:')]/following-sibling::td/input");
	public By codesTab = By.xpath("//li//a[text()='Codes']");
	public By relationshipTab = By.xpath("//li//a[text()='Relationships']");
	public By newNameLink = By.xpath("//u[text()='New Name']");
	String accountNameList =  "(//select[contains(@name,'RelatedToIdTMP')])[%s]";
	public By saveButton2 = By.xpath("//img[contains(@title,'Save')]");
	
	
	public Premier_PortfolioNew(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(new AjaxElementLocatorFactory(driver, 30), this);
	}
	
	public void portfolioSearchCustomer(String sSN, int CustomerCount) throws Exception {
		boolean stepResult = false;
		try {
			if (CustomerCount==1) {
				driver.switchTo().frame("Main");
			}
			if (isElementPresent(newPortfolioHeader)) {
				if (isElementPresent(customerPageTitle)) {
					clickOnElement("New Portfolio Page", "Search Icon", getDynamicElement("Search Icon",search1,Integer.toString(CustomerCount)));
					switchToWindowWithTitleContaining("Name Search");
					driver.switchTo().frame("bottom");
					new Premier_CustomerContact(driver).searchSSN(sSN);
					
					switchToWindowWithTitleContaining("Institution");
					driver.switchTo().frame("Main");
					stepResult = true;
				}
			}
			
		}catch(Exception e){
			e.printStackTrace();
		}finally {
			if (stepResult == true) {
				System.out.println("Pass");
				new HTMLReportHelper().HtmlReportBody("Search and Select Customer", "Customer Searched on New Portfolio Page Successfully", "Passed",driver, "Y");
			} else {
				System.out.println("fail");
				new HTMLReportHelper().HtmlReportBody("Search and Select Customer", "Could not Searched Customer Details on New Portfolio Page", "Failed",driver, "Y");
			}	
		}}
	public void portfolioSearchAddress(String Address1) throws Exception {
		boolean stepResult = false;
		try {
			if (!customerPageTitle.equals("")) {
				clickOnElement("New Portfolio Page", "Search Icon", searchAddress);
				switchToWindowWithTitleContaining("Address Search");
				driver.switchTo().frame("bottom");
				searchAddress(Address1);
				switchToWindowWithTitleContaining("Institution");
				driver.switchTo().frame("Main");
				stepResult = true;
			}
		}catch(Exception e){
			e.printStackTrace();
		}finally {
			if (stepResult == true) {
				System.out.println("Pass");
				new HTMLReportHelper().HtmlReportBody("Search and Select Address", "Address Searched on New Portfolio Page Successfully", "Passed",driver, "Y");
			} else {
				System.out.println("fail");
				new HTMLReportHelper().HtmlReportBody("Search and Select Address", "Could not Searched Address Details on New Portfolio Page", "Failed",driver, "Y");
			}	
		}}
	public void searchAddress(String Address1) throws Exception {
		boolean stepResult = false;
		try {
			waitElement(4000);
			if (isElementPresent(searchTitle)) {
				clickOnElement("Add Address Page", "Address 1", addressSearch);
				enterText("Add Address Page", "Address 1", addressSearch, Address1);
				clickOnElement("Add Address Page", "Submit", submitSearch);
				waitElement(4000);
				if(isElementPresent(addressLink)){
				clickOnElement("Add Address Page", "Address link", addressLink);
				}
				stepResult = true;
			}
		}catch(Exception e){
			e.printStackTrace();
		}finally {
			if (stepResult == true) {
				System.out.println("Pass");
				new HTMLReportHelper().HtmlReportBody("Search Address", "Address Searched on New Portfolio Page Successfully", "Passed",driver, "Y");
			} else {
				System.out.println("fail");
				new HTMLReportHelper().HtmlReportBody("Search Address", "Could not Searched Address Details on New Portfolio Page", "Failed",driver, "Y");
			}	
		}}
	
	public void portfolioCustomerName(String name1, String taxCode1, String taxNumber1,String dob1, int CustomerCount) throws Exception {
		boolean stepResult = false;
		try {
			if (CustomerCount==1) {
				driver.switchTo().frame("Main");
			}
			
			if (isElementPresent(customerPageTitle)) {
				if (!name1.equals("")) {
					enterText("New Portfolio Page", "Name Field", getDynamicElement("Name Field",name1Textbox,Integer.toString(CustomerCount)), name1);
				}
				if (!taxCode1.equals("")) {
					selectElementByVisibleText("New Portfolio Page", "Tax Code Field", getDynamicElement("Tax Code Field",taxCode1List,Integer.toString(CustomerCount)), taxCode1);
				}
				if (!taxNumber1.equals("")) {
					enterText("New Portfolio Page", "Tax Number Field", getDynamicElement("Tax Number Field",taxNumber1Textbox,Integer.toString(CustomerCount)), taxNumber1);
				}
				if (!dob1.equals("")) {
					enterText("New Portfolio Page", "DOB Field", getDynamicElement("DOB Field",dOBTextbox1,Integer.toString(CustomerCount)), dob1);
				}
					stepResult = true;
			}
			}catch(Exception e) {
			e.printStackTrace();
		}finally {
			if (stepResult == true) {
				System.out.println("Pass");
				new HTMLReportHelper().HtmlReportBody("Enter Customer Name on New Portfolio Page", "Customer Name Entered on New Portfolio Page Successfully", "Passed",driver, "Y");
			} else {
				System.out.println("fail");
				new HTMLReportHelper().HtmlReportBody("Enter Customer Name on New Portfolio Page", "Could not Entered Customer Name on New Portfolio Page", "Failed",driver, "Y");
			}
			
		}}
	public void portfolioCustomerAddress(String sAddress1,String sAddress2, String zipCode) throws Exception {
		boolean stepResult = false;
		try {
			if (!sAddress1.equals("")) {
				enterText("New Portfolio Page", "Address 1 Field", address1, sAddress1);
			}
			if (!sAddress2.equals("")) {
				enterText("New Portfolio Page", "Address 2 Field", address2, sAddress2);
			}
			if (!zipCode.equals("")) {
				enterText("New Portfolio Page", "ZipCode Field", cityStateZip, zipCode);
			}

				stepResult = true;
			}catch(Exception e) {
			e.printStackTrace();
		}finally {
			if (stepResult == true) {
				System.out.println("Pass");
				new HTMLReportHelper().HtmlReportBody("Enter Customer Address on New Portfolio Page", "Customer Address Entered on New Portfolio Page Successfully", "Passed",driver, "Y");
			} else {
				System.out.println("fail");
				new HTMLReportHelper().HtmlReportBody("Enter Customer Address on New Portfolio Page", "Could not Entered Customer Address on New Portfolio Page", "Failed",driver, "Y");
			}
			
		}}
	public void portfolioCustomerDetails(String sdeliveryPoint,String branchRegion, String sAccountingBranch) throws Exception {
		boolean stepResult = false;
		try {
				if (!sdeliveryPoint.equals("")) {
					enterText("New Portfolio Page", "Delivery Point", deliveryPoint, sdeliveryPoint);
				}
				if (!branchRegion.equals("")) {
					clickOnElement("New Portfolio Page", "Branch Region Input Field",branchRegionTextbox);
					Thread.sleep(1000);
					clickOnElement("New Portfolio Page", "Branch Region Button",branchRegionButton);
					Thread.sleep(1000);
					clickOnElement("New Portfolio Page", "Branch Region list",getDynamicElement("Branch Region list",branchRegionList,branchRegion));
				}
				if (!sAccountingBranch.equals("")) {
					clearAndType("New Portfolio Page", "Accounting Branch", accountingBranch, sAccountingBranch);
				}
				clickOnElement("New Portfolio Page", "Next Button", nextButton);
				stepResult = true;
			}catch(Exception e) {
			e.printStackTrace();
		}finally {
			if (stepResult == true) {
				System.out.println("Pass");
				new HTMLReportHelper().HtmlReportBody("Enter Customer Details on New Portfolio Page", "Customer Details Entered on New Portfolio Page Successfully", "Passed",driver, "Y");
			} else {
				System.out.println("fail");
				new HTMLReportHelper().HtmlReportBody("Enter Customer Details on New Portfolio Page", "Could not Entered Customer Details on New Portfolio Page", "Failed",driver, "Y");
			}
			
		}}
	public void portfolioNew_PossibleDuplicate() throws Exception {
		boolean stepResult = false;
		try {
			if(isElementPresent(duplicatePageTitle)) {
				clickOnElement("New Portfolio Page", "Existing Name Radio Button Button", existingNameRadioButton);			
				clickOnElement("New Portfolio Page", "Next Button", nextButton);
				stepResult = true;
			}					
			}catch(Exception e) {
			e.printStackTrace();
		}finally {
			if (stepResult == true) {
				System.out.println("Pass");
				new HTMLReportHelper().HtmlReportBody("Verify Possible Duplicates Screen", "Possible Duplicates Screen displayed Successfully", "Passed",driver, "Y");
			} else {
				System.out.println("fail");
				new HTMLReportHelper().HtmlReportBody("Verify Possible Duplicates Screen", "Could not displayed Possible Duplicates Screen", "Failed",driver, "Y");
			}
			
		}}
	public void portfolioNew_PossibleDuplicate_NewCustomer() throws Exception {
		boolean stepResult = false;
		try {
			if(isElementPresent(duplicatePageTitle)) {
				if (isElementPresent(duplicateMsgNameAddress)) {
					clickOnElement("New Portfolio Page", "Next Button", nextButton);
					stepResult = true;
				}
				
			}					
			}catch(Exception e) {
			e.printStackTrace();
		}finally {
			if (stepResult == true) {
				System.out.println("Pass");
				new HTMLReportHelper().HtmlReportBody("Verify Possible Duplicates Screen", "Possible Duplicates Screen displayed Successfully", "Passed",driver, "Y");
			} else {
				System.out.println("fail");
				new HTMLReportHelper().HtmlReportBody("Verify Possible Duplicates Screen", "Could not displayed Possible Duplicates Screen", "Failed",driver, "Y");
			}
			
		}}
	public void portfolioNew_NameScreen(String sRelationship, int CustomerCount) throws Exception {
		boolean stepResult = false;
		try {
			if(isElementPresent(nameRelationshipPageTitle)) {
				selectElementByVisibleText("New Portfolio Page", "Relationship Field", getDynamicElement("Relationship Field",relationshipList,Integer.toString(CustomerCount)), sRelationship);
				Thread.sleep(1000);
				//clickOnElement("New Portfolio Page", "Next Button", nextButton);
				stepResult = true;
			}					
			}catch(Exception e) {
			e.printStackTrace();
		}finally {
			if (stepResult == true) {
				System.out.println("Pass");
				new HTMLReportHelper().HtmlReportBody("Verify Names Screen", "Names Screen displayed Successfully", "Passed",driver, "Y");
			} else {
				System.out.println("fail");
				new HTMLReportHelper().HtmlReportBody("Verify Names Screen", "Could not displayed Names Screen", "Failed",driver, "Y");
			}
			
		}}
	public void portfolioNew_NameScreenMultipleCust(String sRelationship,String nameFormatCode,String sPhoneNumber,String sEmail, int CustomerCount) throws Exception {
		boolean stepResult = false;
		try {
			if(isElementPresent(nameRelationshipPageTitle)) {
				if (!sRelationship.equals("")) {
				selectElementByVisibleText("New Portfolio Page", "Relationship Field", getDynamicElement("Relationship Field",relationshipList,Integer.toString(CustomerCount)), sRelationship);
				}
				Thread.sleep(2000);
				if (!nameFormatCode.equals("")) {
				selectElementByVisibleText("New Portfolio Page", "Name Format Field", getDynamicElement("Name Format Field",portfolioNameFormatCodeList,Integer.toString(CustomerCount)), nameFormatCode);
				}
				Thread.sleep(1000);
				if (!sPhoneNumber.equals("")) {
				clickOnElement("New Portfolio Page", "Add Phone Number Link", getDynamicElement("Add Phone Number Link",portfolioAddPhoneLink,Integer.toString(CustomerCount)));
				clickAfterWaitForElementToBeClickable("New Portfolio Page - Name Screen", "Phone Number TextBox", getDynamicElement("Phone Number",portfolioPhoneNumberTextBox,Integer.toString(CustomerCount)));
				enterText("New Portfolio Page - Name Screen", "Phone Number TextBox", getDynamicElement("Phone Number",portfolioPhoneNumberTextBox,Integer.toString(CustomerCount)), sPhoneNumber);
				}
				Thread.sleep(1000);
				if (!sEmail.equals("")) {
				clickOnElement("New Portfolio Page", "Add Email Link", getDynamicElement("Add Email Link",portfolioAddEmailLink,Integer.toString(CustomerCount)));
				clickAfterWaitForElementToBeClickable("New Portfolio Page - Name Screen", "Email TextBox", getDynamicElement("Phone Number",portfolioEMailTextBox,Integer.toString(CustomerCount)));
				enterText("New Portfolio Page - Name Screen", "Email TextBox", getDynamicElement("Email Textbox",portfolioEMailTextBox,Integer.toString(CustomerCount)), sEmail);
				}
				stepResult = true;
			}					
			}catch(Exception e) {
			e.printStackTrace();
		}finally {
			if (stepResult == true) {
				System.out.println("Pass");
				new HTMLReportHelper().HtmlReportBody("Enter details on Names Screen", "Details Entered on Names Screen Successfully", "Passed",driver, "Y");
			} else {
				System.out.println("fail");
				new HTMLReportHelper().HtmlReportBody("Enter details on Names Screen", "Could not enter details on Names Screen", "Failed",driver, "Y");
			}
			
		}}
	public void portfolioNew_CodesScreen(String sPortfolioTypeCode, String sResponsibilityCode,String sMiscellaneousCode,String excelFilePath, String sheetName, int rowNo) throws Exception {
		boolean stepResult = false;
		try {
			if(isElementPresent(codesPageTitle)) {
				clickOnElement("New Portfolio Page", "Next Available Link",nextAvailableLink);
				Thread.sleep(4000);
				sPortfolioNo=getElementAttribute("New Portfolio Page", "Portfolio No",  portfolioTextbox,"value");
				if(sPortfolioNo != "")
					new ExcelReader().setValueInColumnforRow(excelFilePath,  sheetName.toUpperCase(), "Portfolio_No", rowNo, sPortfolioNo);				
				
				if (!sPortfolioTypeCode.equals("")) {
					enterText("New Portfolio Page", "Portfolio Type", portfolioTypeCode, sPortfolioTypeCode);
				}
				if (!sResponsibilityCode.equals("")) {
					clickOnElement("New Portfolio Page", "Responsibility Code Button",responsibilityCodeButton);
					Thread.sleep(1000);
					clickOnElement("New Portfolio Page", "Responsibility Code list",getDynamicElement("Responsibility Code list",responsibilityCodeList,sResponsibilityCode));
				}
				if (!sMiscellaneousCode.equals("")) {
					enterText("New Portfolio Page", "Miscellaneous Code", miscCode, sMiscellaneousCode);
				}
				//clickOnElement("New Portfolio Page", "Finish Button", finishButton);
				//Thread.sleep(2000);
				//driver.switchTo().defaultContent();
				//switchToWindowWithTitleContaining("Institution");
				stepResult = true;
			}					
			}catch(Exception e) {
			e.printStackTrace();
		}finally {
			if (stepResult == true) {
				System.out.println("Pass");
				new HTMLReportHelper().HtmlReportBody("Enter details on Codes Screen", "Details Entered on Codes Screen Successfully", "Passed",driver, "Y");
			} else {
				System.out.println("fail");
				new HTMLReportHelper().HtmlReportBody("Enter details on Codes Screen", "Could not entered details on Codes Screen", "Failed",driver, "Y");
			}
			
		}}

	public void clickAddNameLink() throws Exception {
		boolean stepResult = false;
		try {
			if (isElementPresent(customerPageTitle)) {
				clickOnElement("New Portfolio Page", "Add Name Link", addNameLink);
				stepResult = true;
			}
		}catch(Exception e){
			e.printStackTrace();
		}finally {
			if (stepResult == true) {
				System.out.println("Pass");
				new HTMLReportHelper().HtmlReportBody("Click on Add Name Link", "Clicked on Add Name Link on New Portfolio Page Successfully", "Passed",driver, "Y");
			} else {
				System.out.println("fail");
				new HTMLReportHelper().HtmlReportBody("Click on Add Name Link", "Could not clicked on Add Name Link on New Portfolio Page", "Failed",driver, "Y");
			}	
		}}
	public void clickOnNextButton() throws Exception {
		boolean stepResult = false;
		try {
			clickOnElement("New Portfolio Page", "Next Button", nextButton);
				stepResult = true;
			
		}catch(Exception e){
			e.printStackTrace();
		}finally {
			if (stepResult == true) {
				System.out.println("Pass");
				new HTMLReportHelper().HtmlReportBody("Click on Next Button", "Clicked on Next Button Successfully", "Passed",driver, "Y");
			} else {
				System.out.println("fail");
				new HTMLReportHelper().HtmlReportBody("Click on Next Button", "Could not clicked on Next Button", "Failed",driver, "Y");
			}	
		}}

	public void portfolioNew_AddressScreen() throws Exception {
		boolean stepResult = false;
		try {
			if(isElementPresent(addressPageTitle)) {
					clickOnElement("New Portfolio Page", "Next Button", nextButton);
					stepResult = true;	
			} 
			else 
				if(isElementPresent(codesPageTitle)) {
					stepResult = true;	
			}		
						
			}catch(Exception e) {
			e.printStackTrace();
		}finally {
			if (stepResult == true) {
				System.out.println("Pass");
				new HTMLReportHelper().HtmlReportBody("Verify Address Screen", "Address Screen displayed Successfully", "Passed",driver, "Y");
			} else {
				System.out.println("fail");
				new HTMLReportHelper().HtmlReportBody("Verify Address Screen", "Could not displayed Address Screen", "Failed",driver, "Y");
			}
			
		}}
	public void portfolioFinishButton() throws Exception {
		boolean stepResult = false;
		try {
			clickOnElement("New Portfolio Page", "Finish Button", finishButton);
			Thread.sleep(5000);
			validateElementPresent("New Portfolio Page", "Customer Page Title", customerPageTitle);
			driver.switchTo().defaultContent();
			switchToWindowWithTitleContaining("Institution");
			stepResult = true;
			
		}catch(Exception e){
			e.printStackTrace();
		}finally {
			if (stepResult == true) {
				System.out.println("Pass");
				new HTMLReportHelper().HtmlReportBody("Click on Finish Button", "Clicked on Finish Button Successfully", "Passed",driver, "Y");
			} else {
				System.out.println("fail");
				new HTMLReportHelper().HtmlReportBody("Click on Finish Button", "Could not clicked on Finish Button", "Failed",driver, "Y");
			}	
		}}
	public void searchPortfolio(String portfolioNo) throws Exception{
		boolean stepResult = false;
		try {
			Thread.sleep(4000);
				driver.switchTo().frame("Main");
				if (isElementPresent(searchTitle2)) {
					clickOnElement("Search Portfolio Page", "Portfolio Number", portfolioSearch);
					enterText("Search Portfolio Page", "Portfolio Number", portfolioSearch, portfolioNo);
					clickOnElement("Search Portfolio Page", "Submit", submitSearch);
					stepResult = true;
				}	
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (stepResult == true) {
				System.out.println("Pass");
				new HTMLReportHelper().HtmlReportBody("Search Portfolio", "Search Portfolio on Portfolio page Successfully", "Passed",
						driver, "Y");
			} else {
				System.out.println("fail");
				new HTMLReportHelper().HtmlReportBody("Search Portfolio", "Could not Search Portfolio on Portfolio page Successfully", "Failed",
						driver, "Y");
			}
		}}
	public void changePortfolioDetails(String sPortfolioBranchRegion,String sPortfolioResponsibilityCode, String sPortfolioRelationship) throws Exception{
		boolean stepResult = false;
		try {
			Thread.sleep(4000);
				if (isElementPresent(codesTab)) {
					if(!sPortfolioBranchRegion.equals("")) {
							clickOnElement("Change Portfolio Page", "Branch Region Input Field",branchRegionTextbox);
							Thread.sleep(1000);
						clickOnElement("Change Portfolio Page", "Branch Region Button",branchRegionButton);
						Thread.sleep(1000);
						clickOnElement("Change Portfolio Page", "Branch Region list",getDynamicElement("Branch Region list",branchRegionList,sPortfolioBranchRegion));
					}
					if(!sPortfolioResponsibilityCode.equals("")) {
						clickOnElement("Change Portfolio Page", "Responsibility Code Input Field",responsibilityCodeInput);
						Thread.sleep(1000);
						clickOnElement("Change Portfolio Page", "Responsibility Code Button",responsibilityCodeButton);
						Thread.sleep(1000);
						clickOnElement("Change Portfolio Page", "Responsibility Code list",getDynamicElement("Responsibility Code list",responsibilityCodeList,sPortfolioResponsibilityCode));
					}
					clickOnElement("Change Portfolio Page", "Relationship Tab",relationshipTab);
					Thread.sleep(5000);
					if(!sPortfolioRelationship.equals("")) {
						selectElementByVisibleText("Change Portfolio Page", "Relationship Field", relationshipListFirst, sPortfolioRelationship);
					}
					stepResult = true;
				}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (stepResult == true) {
				System.out.println("Pass");
				new HTMLReportHelper().HtmlReportBody("Change Portfolio Details", "Portfolio details Changed Successfully", "Passed",
						driver, "Y");
			} else {
				System.out.println("fail");
				new HTMLReportHelper().HtmlReportBody("Change Portfolio Details", "Could not change portfolio details", "Failed",
						driver, "Y");
			}
		}}
	public void addCustomer(String sSN,String sName,String sRelationship, int CustomerCount) throws Exception{
		boolean stepResult = false;
		try {
				if (isElementPresent(relationshipTab)) {
					clickOnElement("Change Portfolio Page", "Add Name", newNameLink);
					Thread.sleep(4000);
					switchToWindowWithTitleContaining("Name Search");
					Thread.sleep(4000);
					driver.switchTo().frame("bottom");
					new Premier_CustomerContact(driver).searchSSN(sSN);
					Thread.sleep(4000);
					switchToWindowWithTitleContaining("Institution");
					driver.switchTo().frame("Main");
					
					if(!sRelationship.equals("")) {
					selectElementByVisibleText("Change Portfolio Page", "Relationship Field", getDynamicElement("Relationship Field",relationshipList,Integer.toString(CustomerCount)), sRelationship);					
					}
					Thread.sleep(2000);
					if(!sName.equals("")) {
					selectElementByVisibleText("Change Portfolio Page", "Name Field", getDynamicElement("Name Field",accountNameList,Integer.toString(CustomerCount)), sName);
					}
					Thread.sleep(2000);
					stepResult = true;
				}	
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (stepResult == true) {
				System.out.println("Pass");
				new HTMLReportHelper().HtmlReportBody("Add Customer", "Customer Added Successfully", "Passed",
						driver, "Y");
			} else {
				System.out.println("fail");
				new HTMLReportHelper().HtmlReportBody("Add Customer", "Could not add Customer", "Failed",
						driver, "Y");
			}
		}}
	public void portfolioSaveButton() throws Exception {
		boolean stepResult = false;
		try {
			clickOnElement("New Contact Page", "Save Button", saveButton2);
			Thread.sleep(2000);
			driver.switchTo().defaultContent();
			switchToWindowWithTitleContaining("Institution");
			stepResult = true;
			
		}catch(Exception e){
			e.printStackTrace();
		}finally {
			if (stepResult == true) {
				System.out.println("Pass");
				new HTMLReportHelper().HtmlReportBody("Click on Save Button", "Clicked on Save Button Successfully", "Passed",driver, "Y");
			} else {
				System.out.println("fail");
				new HTMLReportHelper().HtmlReportBody("Click on Save Button", "Could not clicked on Save Button", "Failed",driver, "Y");
			}	
		}}
	
}