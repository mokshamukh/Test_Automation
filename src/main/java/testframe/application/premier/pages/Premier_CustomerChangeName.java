package testframe.application.premier.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import testframe.application.common.CommonLibrary;
import testframe.common.reporting.HTMLReportHelper;

/**
 * PageNage : Premier_CustomerNewName
 * 
 * @author Ketki.Badalwar
 */


public class Premier_CustomerChangeName extends CommonLibrary {


	public By changeNameTitle = By.xpath("//div[text()='Customer - Names - Change Name']");
	public By nameSearchChange =  By.xpath("//input[@name='SoundexName']");
	public By ssnSearchChange =  By.xpath("//input[@name='TaxID']");
	public By submitSearch =  By.xpath("//button[text()='Submit']");
	public By nameTextbox = By.xpath("(//label[text()='Name:'])[1]/../following-sibling::td/input");
	public By lastNameTextbox = By.xpath("(//label[text()='Last Name:'])[1]/../following-sibling::td/input");
	public By contactDetailsTab =  By.xpath("//a[contains(text(),'Contact Methods')]");
	public By contactDetailsTabTitle = By.xpath("//label[contains(text(),'Contact Methods')]");
	public By relationshipsTab =  By.xpath("//a[contains(text(),'Relationships')]");
	public By relationshipsTitle = By.xpath("//label[contains(text(),'Relationships')]");
	public By beneficiaryOwnerTitle = By.xpath("//label[contains(text(),'Beneficial Ownership')]");
	public By saveButton = By.xpath("//a[text()=' Save']");
	public By searchLabel = By.xpath("//label[text()='Search']");
	public By addNameImage = By.xpath("//img[@title='Add Name']");
	public By lastRelationship = By.xpath("//table[@id='Rel_Name']//tr[last()]/td[6]/select[contains(@id,'RelationshipCode')]");
	public By addBeneficiaryLink = By.xpath("//a[text()='Add Beneficial Owner']");
	public By lastBeneficialOwnerName =By.xpath("//table[@id='Rel_Beneficial']//tr[last()-1]/td[2]//select[contains(@id,'RelatedToId')]");
	public By lastBeneficialRelationship =By.xpath("//table[@id='Rel_Beneficial']//tr[last()-1]/td[4]//select[contains(@id,'RelationshipCode')]");
	public By lastBeneficialPercent =By.xpath("//table[@id='Rel_Beneficial']//tr[last()-1]/td[6]//input[contains(@id,'RelationshipPercent')]");
	public By lastDeleteBeneficiary = By.xpath("//table[@id='Rel_Beneficial']//tr[last()-1]/td[12]/img[@alt='Delete']");
	public By selectPhoneType = By.xpath("//select[@id='ddPhone']");
	public By selectEmailType = By.xpath("//select[@id='ddEmail']");
	public By phoneNumLink = By.xpath("//a[@id='lnkPhone']");
	public By emailLink = By.xpath("//a[@id='lnkEmail']");
	public By webAddresslink = By.xpath("//a[@id='lnkWeb']");
	String sPhoneNumValue = "(//input[contains(@name,'PhoneNumber')])[%s]";
	String sEmailValue = "(//input[contains(@name,'ContactInfo')])[%s]";
	String sWebAddressValue = "(//input[contains(@name,'ContactInfo')])[%s]";
	public By lastPhoneNumValue =By.xpath("//table[@id='mcPhoneNumbers']//tr[last()-1]/td[6]/input[contains(@name,'PhoneNumber')]");
	public By lastemailidValue =By.xpath("//table[@id='mcEmailAddress']//tr[last()-1]/td[6]/input[contains(@name,'ContactInfo')]");
	public By allRelationshipNameCheckBoc =By.xpath("//input[contains(@type,'checkbox') and contains(@name,'Name')]");
	
	//below xpaths are not used yet in scripts
	public By nameTitle = By.xpath("//label[text()='Step 1 - Name']");
	public By firstNametextbox = By.xpath("(//label[text()='First Name:'])[1]/../following-sibling::td/input");
	public By nameFormatCodeCombobox = By.xpath("(//label[text()='Name Format Code:'])[1]/../following-sibling::td/select");
	public By dateOfBirth = By.xpath("(//label[text()='Date of Birth:'])[1]/../following-sibling::td/div/input");
	public By taxIDCodeList = By.xpath("(//label[text()='Tax ID Code:'])[1]/../following-sibling::td/select");
	public By taxIDNum = By.xpath("(//label[text()='Tax ID Number:'])[1]/../following-sibling::td/input");
	public By withholdingCodeCombobox = By.xpath("//label[text()='Withholding Code:']/../following-sibling::td/select");
	public By altNameTextbox = By.xpath("(//label[text()='Name:'])[2]/../following-sibling::td/input");
	public By altLastNameTextbox = By.xpath("(//label[text()='Last Name:'])[2]/../following-sibling::td/input");
	public By altFirstNametextbox = By.xpath("(//label[text()='First Name:'])[2]/../following-sibling::td/input");
	public By altNameFormatCodeCombobox = By.xpath("(//label[text()='Name Format Code:'])[2]/../following-sibling::td/select");
	public By frame = By.xpath("//iframe[@id='Main']");
	public By finishButton = By.xpath("//button[@name='SubmitButton']");
	public By branchRegionButton = By.xpath("//button[contains(@id,'BranchNumber_b')]");
	public By branchRegionVal = By.xpath("(//label[text()='Branch Region:'])[1]/../following-sibling::td//input[contains(@class,'EllipseText')]");
	String BranchRegionCombobox =  "//select[contains(@id,'BranchNumber_d')]/option[contains(text(),'%s')]";	
	public By codeLabel = By.xpath("//label[text()='Step 4 - Codes']");
	public By duplicateLabel = By.xpath("//label[text()='Step 2 - Duplicate']");
	public By duplicateMsg = By.xpath("//label[text()='No Possible Name Duplicates']");
	public By contactMethodsLabel = By.xpath("//label[text()='Step 3 - Contact Methods']");
	public By buildRelationshipLabel = By.xpath("//label[text()='Step 5 - Build Relationships']");
	
	public By SearchTitle = By.xpath("//label[text()='Search']");
	public By BuildRelationshipSSN = By.xpath("//label[text()='Tax Identification:']/../following-sibling::td//input[@id='TaxID']");
	public By SubmitButton_SearchScreen = By.xpath("//button[text()='Submit']");
	public By NameList = By.xpath("//label[text()='Name List']");
	public By SearchResult = By.xpath("//a[contains(@id,'SearchType=Name')]");
	public By RelationshipName =By.xpath("(//table[@id='Rel_Name']//select[contains(@id,'RelationshipCode')])[1]");
	public By addAddressImage = By.xpath("//img[@title='Add Address']");
	
	public By phoneNumVal = By.xpath("(//input[contains(@name,'PhoneNumber')])[1]");
	public By emailVal = By.xpath("(//input[contains(@name,'ContactInfo')])[1]");
	public By webAddressVal = By.xpath("(//input[contains(@name,'ContactInfo')])[2]");
	public By genderCombobox = By.xpath("//label[text()='Gender:']/../following-sibling::td/select");
	public By riskRankingInput = By.xpath("//input[contains(@id,'RiskRanking_l')]");
	public By riskRankingButton = By.xpath("//button[contains(@id,'RiskRanking_b')]");
	String riskRankingCombobox =  "//select[contains(@id,'RiskRanking_d')]/option[contains(text(),'%s')]";
	public By creditScoreTextbox = By.xpath("//label[text()='Credit Score:']/../following-sibling::td/input");
	public By nAICSCodesButton = By.xpath("//button[contains(@id,'naics_b')]");
	public By nAICSCodes_EconomicSector = By.xpath("//select[@id='economicSector']");
	public By nAICSCodesSubmitButton = By.xpath("//button[text()='Submit']");
	public By customerTypeCombobox = By.xpath("//label[text()='Customer Type:']/../following-sibling::td/select");
	public By phoneDescript = By.xpath("(//input[contains(@name,'PhoneDescription')])[1]");
	public By msg = By.xpath("//*[text()='The record was updated successfully.']");
	public By BeneOwnerName = By.xpath("(//select[contains(@id,'RelatedToId')])[1]");
	public By BeneRelationship = By.xpath("(//table[@id='Rel_Beneficial']//select[contains(@id,'RelationshipCode')])[1]");
	public By BenePercent = By.xpath("(//input[contains(@id,'RelationshipPercent')])[1]");
	public By RelationshipName2 =By.xpath("(//table[@id='Rel_Name']//select[contains(@id,'RelationshipCode')])[3]");
	public By BeneOwnerName2 = By.xpath("(//select[contains(@id,'RelatedToId')])[2]");
	public By BeneRelationship2 = By.xpath("(//table[@id='Rel_Beneficial']//select[contains(@id,'RelationshipCode')])[2]");
	public By BenePercent2 = By.xpath("(//input[contains(@id,'RelationshipPercent')])[2]");
	//below xpaths are not used yet in scripts
	public By middleInitialTextBox = By.xpath("(//label[text()='Middle Initial:'])[1]/../following-sibling::td/input");
	public By generationCodeButton = By.xpath("//label[text()='Generation Code:']/../following-sibling::td//button");
	String generationCodeList = "//Select[contains(@id,'GenerationCode')]/option[contains(text(),%s')]";
	public By suspectExemptionCombo = By.xpath("(//label[text()='Suspect Exemption:'])[1]/../following-sibling::td/select");
	public By iDTypeButton = By.xpath("(//button[contains(@id,'IdentType_b')])[1]");
	String idTypeList = "//select[contains(@id,'IdentType_d')]/option[contains(text(),'%s')]";
	public By issuedByButton = By.xpath("(//button[contains(@id,'IdentIssuedBy_b')])[1]");
	String issuedByList = "//select[contains(@id,'IdentIssuedBy_d')]/option[contains(text(),'%s')]";
	public By valueTextBox = By.xpath("(//input[contains(@id,'IdentValue')])[1]");
	public By issueDateTextbox = By.xpath("(//input[contains(@id,'IdentDate')])[1]");
	public By expirationDateTextbox = By.xpath("(//input[contains(@id,'IdentExpireDate')])[1]");
	public By iRSName = By.xpath("(//label[text()='IRS Name:'])[1]/../following-sibling::td/input");
	public By iRSPayeeNameControlTextbox = By.xpath("(//label[text()='IRS Payee Name Control:'])[1]/../following-sibling::td/input");
	public By iRS_1B_NoticeTextBox = By.xpath("(//label[text()='IRS 1st B Notice:'])[1]/../following-sibling::td/div/input");
	public By iRS_2B_NoticeTextBox = By.xpath("(//label[text()='IRS 2nd B Notice:'])[1]/../following-sibling::td/div/input");
	public By exemptPayeeCodeTextbox = By.xpath("(//input[contains(@id,'ExemptPayeeCode')])[2]");
	public By exemptPayeeCodeButton = By.xpath("//button[contains(@id,'ExemptPayeeCode')]");
	String exemptPayeeCodeList = "//Select[contains(@id,'ExemptPayeeCode_d')]/option[contains(text(),'%s')]";
	public By taxIDVerificationAttempts = By.xpath("(//label[text()='Tax ID Verification Attempts:'])[1]/../following-sibling::td/input");
	public By taxIDVerificationDate = By.xpath("(//label[text()='Tax ID Verification Date:'])[1]/../following-sibling::td/div/input");
	public By taxIDMatchingCodeList = By.xpath("(//label[text()='Tax ID Matching Code:'])[1]/../following-sibling::td/select");
	public By fATCAExemptReportingCodeButton = By.xpath("//button[contains(@id,'FatcaExemptRptCode_b')]");
	String fATCAExemptReportingCodeList = "//Select[contains(@id,'FatcaExemptRptCode_d')]/option[contains(text(),'%s')]";
	public By alt_middleInitialTextBox = By.xpath("(//label[text()='Middle Initial:'])[2]/../following-sibling::td/input");
	public By languagePreferenceIndicatorSelect = By.xpath("(//label[text()='Language Preference Indicator:'])[1]/../following-sibling::td/select");
	public By disclosureOptionTextBox = By.xpath("//label[text()='Disclosure Option:']/../following-sibling::td/input");
	public By disclosureDateTextBox = By.xpath("//label[text()='Disclosure Date:']/../following-sibling::td/div/input");
	public By responsibilityCodeButton = By.xpath("//button[contains(@id,'ResponsibilityCode_b')]");
	String responsibilityCodeList = "//select[contains(@id,'ResponsibilityCode_d')]/option[contains(text(),'%s')]";
	public By referralResponsibilityCodeButton = By.xpath("//button[contains(@id,'ReferralRespCode_b')]");
	String referralResponsibilityCodeList = "//select[contains(@id,'ReferralRespCode_d')]/option[contains(text(),'%s')]";
	public By accountingBranchButton = By.xpath("//button[contains(@id,'AccountingGroup_b')]");
	String accountingBranchList = "//select[contains(@id,'AccountingGroup_d')]/option[contains(text(),'%s')]";
	public By nameRetentionCodeList = By.xpath("//label[text()='Name Retention Code:']/../following-sibling::td/select");
	public By residencyStatusButton = By.xpath("//button[contains(@id,'ResidencyStatus_b')]");
	String residencyStatusList = "//select[contains(@id,'ResidencyStatus_d')]/option[contains(text(),'%s')]";
	public By openMethodTextbox = By.xpath("//input[contains(@id,'CustomerOpenMethod_l')]");
	public By openMethodButton = By.xpath("//button[contains(@id,'CustomerOpenMethod_b')]");
	String openMethodList = "//select[contains(@id,'CustomerOpenMethod_d')]/option[contains(text(),'%s')]";
	public By creationDateTextbox = By.xpath("//label[text()='Creation Date:']/../following-sibling::td/div/input");
	public By dateDeceasedTextbox = By.xpath("//label[text()='Date Deceased:']/../following-sibling::td/div/input");
	public By foreignCodeList = By.xpath("//label[text()='Foreign Code:']/../following-sibling::td/select");
	public By w8FormTypeList = By.xpath("//label[text()='W-8 Form Type:']/../following-sibling::td/select");
	public By certificationDateTextBox = By.xpath("//label[text()='Certification Date:']/../following-sibling::td/div/input");
	public By expirationDateTextBox = By.xpath("//label[text()='Expiration Date']/../following-sibling::td/div/input");
	public By taxRateList = By.xpath("//label[text()='Tax Rate:']/../following-sibling::td/select");
	public By incomeCodeTextbox = By.xpath("//input[contains(@id,'CustomerOpenMethod_l')]");
	public By incomeCodeButton = By.xpath("//button[contains(@id,'CustomerOpenMethod_b')]");
	String incomeCodeList = "//select[contains(@id,'CustomerOpenMethod_d')]/option[contains(text(),'%s')]";
	public By chapter3StatusCodeTextbox = By.xpath("//input[contains(@id,'ForeignIncomeCode_l')]");
	public By chapter3StatusCodeButton = By.xpath("//button[contains(@id,'ForeignIncomeCode_b')]");
	String chapter3StatusCodeList = "//select[contains(@id,'ForeignIncomeCode_d')]/option[contains(text(),'%s')]";
	public By chapter4StatusCodeTextbox = By.xpath("//input[contains(@id,'ForeignChapter3Status_l')]");
	public By chapter4StatusCodeButton = By.xpath("//button[contains(@id,'ForeignChapter3Status_b')]");
	String chapter4StatusCodeList = "//select[contains(@id,'ForeignChapter3Status_d')]/option[contains(text(),'%s')]";
	public By exemptionCodeTextbox = By.xpath("//input[contains(@id,'ForeignExemptionCode_l')]");
	public By exemptionCodeButton = By.xpath("//button[contains(@id,'ForeignExemptionCode_b')]");
	String exemptionCodeList = "//select[contains(@id,'ForeignExemptionCode_d')]/option[contains(text(),'%s')]";
	public By provinceCodeButton = By.xpath("//button[contains(@id,'ForeignProvinceCode_b')]");
	String provinceCodeList = "//select[contains(@id,'ForeignProvinceCode_d')]/option[contains(text(),'%s')]";
	public By countryResidenceCodeButton = By.xpath("//button[contains(@id,'ForeignCountryRes_b')]");
	String countryResidenceCodeList = "//select[contains(@id,'ForeignCountryRes_d')]/option[contains(text(),'%s')]";
	public By countryTaxCodeButton = By.xpath("//button[contains(@id,'ForeignCountryTax_b')]");
	String countryTaxCodeList = "//select[contains(@id,'ForeignCountryTax_d')]/option[contains(text(),'%s')]";
	public By globalIntermediaryIdentificationNumber = By.xpath("//label[text()='Global Intermediary Identification Number:']/../following-sibling::td/input");
	public By postalCode = By.xpath("//label[text()='Postal Code:']/../following-sibling::td/input");
	public By foreignTaxIdentificationNumber = By.xpath("//label[text()='Foreign Tax Identification Number:']/../following-sibling::td/input");
	public By withholdingType = By.xpath("//label[text()='Withholding Type:']/../following-sibling::td/select");
	public By beneDescriptionList = By.xpath("(//select[contains(@id,'ControlDescription')])[1]");
	public By beneReciprocalRelationshipList = By.xpath("(//select[contains(@id,'BeneficiaryReciprocalRel')])[1]");

	public Premier_CustomerChangeName(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(new AjaxElementLocatorFactory(driver, 30), this);

	}
	
	public void searchCustomer(String sName, String sSSN) throws Exception{
		boolean stepResult = false;
		try {
			if (isElementPresent(changeNameTitle)){
				switchToFrameWithName("Main");
				if (!sName.equals(""))
					enterText("Change Name - Search Page", "Name", nameSearchChange, sName);
				if (!sSSN.equals(""))
					enterText("Change Name - Search Page", "Tax Identification", ssnSearchChange, sSSN);
				clickOnElement("Change Name - Search Page", "Submit", submitSearch);
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
			}
		}

	}


	public void updateNameDetails(String name,String lastName) throws Exception {
		boolean stepResult = false;
		try {
			if (isElementPresent(changeNameTitle)){
				driver.switchTo().frame("Main");
				
				clearText("Change Name Page", "First Name field", firstNametextbox);
				//clearText("Change Name Page", "First Name field", nameTextbox);
				if(!lastName.equals("")){
					clearAndType("Change Name Page", "Last Name field", lastNameTextbox, lastName);
					clearAndType("Change Name Page", "Last Name field", lastNameTextbox, lastName);
				}
				Thread.sleep(3000);
				if(!name.equals("")){
					clearAndType("Change Name Page", "Name field", nameTextbox, name);
					clearAndType("Change Name Page", "Name field", nameTextbox, name);
				}
				
				
				stepResult = true;
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (stepResult == true) {
				System.out.println("Pass");
				new HTMLReportHelper().HtmlReportBody("Change Name Details", "Change name Successfully", "Passed", driver, "Y");
			} else {
				System.out.println("fail");
				new HTMLReportHelper().HtmlReportBody("Change Name Details", "Could not change name", "Failed", driver, "Y");
			}
		}
	}

	public void goToContactMethodTab() throws Exception {
		boolean stepResult = false;
		try {
			clickOnElement("Change Name - Contact Methods Page", "Contact Methods", contactDetailsTab);
			stepResult = true;

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (stepResult == true) {
				System.out.println("Pass");
				new HTMLReportHelper().HtmlReportBody("Click on Contact Methods", "Click on Contact Methods Successfully", "Passed", driver, "Y");
			} else {
				System.out.println("fail");
				new HTMLReportHelper().HtmlReportBody("Click on Contact Methods", "Could not click on Contact Methods", "Failed", driver, "Y");
			}
		}
	}

	public void updateContactMethods(String phoneNumber,String email,String webAddress) throws Exception {
		boolean stepResult = false;
		try {
			if (isElementPresent(contactDetailsTabTitle)){
				if(!phoneNumber.equals("")){
					clickAfterWaitForElementToBeClickable("Change Name - Contact Methods Page", "Phone Number", phoneNumVal);
					clearAndType("Change Name - Contact Methods Page", "Phone Number", phoneNumVal, phoneNumber);
				}
				if(!email.equals("")){
					clickAfterWaitForElementToBeClickable("Change Name - Contact Methods Page", "Email", emailVal);
					clearAndType("Change Name - Contact Methods Page", "Email address", emailVal, email);
				}
				if(!webAddress.equals("")){
					clickAfterWaitForElementToBeClickable("Change Name - Contact Methods Page", "Web Address", webAddressVal);
					clearAndType("Change Name - Contact Methods Page", "Web Address", webAddressVal, webAddress);
				}
				stepResult = true;
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (stepResult == true) {
				System.out.println("Pass");
				new HTMLReportHelper().HtmlReportBody("Update Contact Methods Details", "Change contact methods Successfully", "Passed", driver, "Y");
			} else {
				System.out.println("fail");
				new HTMLReportHelper().HtmlReportBody("Update Contact Methods Details", "Could not change contact methods", "Failed", driver, "Y");
			}
		}
	}

	public void addPhoneNumber(String phoneType, String phoneNumber) throws Exception {
		boolean stepResult = false;
		try {
			if (isElementPresent(contactDetailsTabTitle)){
				if(!phoneNumber.equals("")){
					selectElementByVisibleText("Change Name - Contact Methods Page", "Phone Type", selectPhoneType, phoneType);
					clickOnElement("Change Name - Contact Methods Page", "Add Phone link", phoneNumLink);
					Thread.sleep(4000);
					clickAfterWaitForElementToBeClickable("Change Name - Contact Methods Page", "Phone Number", lastPhoneNumValue);
					enterText("Change Name - Contact Methods Page", "Phone Number", lastPhoneNumValue, phoneNumber);
				}
				stepResult = true;
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (stepResult == true) {
				System.out.println("Pass");
				new HTMLReportHelper().HtmlReportBody("Add a phone number", "Phone Number added Successfully", "Passed", driver, "Y");
			} else {
				System.out.println("fail");
				new HTMLReportHelper().HtmlReportBody("Add a phone number", "Could not add Phone Number", "Failed", driver, "Y");
			}
		}
	}

	public void addEmail(String emailType, String mailid) throws Exception {
		boolean stepResult = false;
		try {
			if (isElementPresent(contactDetailsTabTitle)){
				if(!mailid.equals("")){
					selectElementByVisibleText("Change Name - Contact Methods Page", "Mail Type", selectEmailType, emailType);
					clickOnElement("Change Name - Contact Methods Page", "Add Email link", emailLink);
					Thread.sleep(4000);
					clickAfterWaitForElementToBeClickable("Change Name - Contact Methods Page", "Email Address", lastemailidValue);
					enterText("Change Name - Contact Methods Page", "Email Address", lastemailidValue, mailid);
				}
				stepResult = true;
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (stepResult == true) {
				System.out.println("Pass");
				new HTMLReportHelper().HtmlReportBody("Add a E-mail Address", "E-mail Addressr added Successfully", "Passed", driver, "Y");
			} else {
				System.out.println("fail");
				new HTMLReportHelper().HtmlReportBody("Add a E-mail Address", "Could not add E-mail Address", "Failed", driver, "Y");
			}
		}
	}
	
	public void goToRelationshipsTab() throws Exception {
		boolean stepResult = false;
		try {
			clickOnElement("Change Name - Relationships Page", "Relationships", relationshipsTab);
			stepResult = true;

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (stepResult == true) {
				System.out.println("Pass");
				new HTMLReportHelper().HtmlReportBody("Click on Relationships", "Click on Relationships Successfully", "Passed", driver, "Y");
			} else {
				System.out.println("fail");
				new HTMLReportHelper().HtmlReportBody("Click on Relationships", "Could not click on Relationships", "Failed", driver, "Y");
			}
		}
	}



	public void buildRelationship(String buildRelationship_SSN,String build_Relationship) throws Exception {
		boolean stepResult = false;
		try {
			if(isElementPresent(relationshipsTitle)){
				Thread.sleep(3000);
				if (!buildRelationship_SSN.equals("")) {
					clickOnElement("Change Name - Relationship Page", "Add Name Image",addNameImage);
					switchToWindowWithTitleContaining("Add Name");
					driver.switchTo().frame("bottom");
					if (isElementPresent(SearchTitle)) {
						enterText("Change Name - Search Page", "Enter SSN Field", BuildRelationshipSSN, buildRelationship_SSN);
						clickOnElement("Change Name - Search Page", "Submit Button",SubmitButton_SearchScreen);
						//waitForPresenceOfElement("Change Name - Search Page", "Searched Name List", NameList);
						if (isElementPresent(NameList)){
							clickOnElement("Change Name - Search Page", "Searched Result Link",SearchResult);
							stepResult = true;
						}
						switchToWindowWithTitleContaining("Institution 01 - REPUBLIC BANK UAT");
						driver.switchTo().frame("Main");
					}
					Thread.sleep(3000);
					if (!build_Relationship.equals("")) {
						stepResult = false;
						selectElementByVisibleText("Change Name - Relationship Page", "Relationship field", lastRelationship, build_Relationship);
						stepResult = true;
					}
				}
				//stepResult = true;
			}
		}catch(Exception e){
			e.printStackTrace();
		}finally {
			if (stepResult == true) {
				System.out.println("Pass");
				new HTMLReportHelper().HtmlReportBody("Add a Relationship", "Relationship added Successfully", "Passed", driver, "Y");
			} else {
				System.out.println("fail");
				new HTMLReportHelper().HtmlReportBody("Add a Relationship", "Could not add Relationship", "Failed", driver, "Y");
			}

		}
	}

	public void addDetailsOfBeneficiary(String beneficialOwnerName,String beneficial_Relationship,String beneficial_Percent) throws Exception {
		boolean stepResult = false;
		try {
			if(isElementPresent(beneficiaryOwnerTitle)){
				Thread.sleep(3000);
				if (!beneficialOwnerName.equals("")) {
					selectElementByVisibleText("Change Name - Relationship Page", "Beneficial Owner Name field", lastBeneficialOwnerName, beneficialOwnerName);
				}
				if (!beneficial_Relationship.equals("")) {
					selectElementByVisibleText("Change Name - Relationship Page", "Beneficial Relationship field", lastBeneficialRelationship, beneficial_Relationship);
				}
				if (!beneficial_Percent.equals("")) {
					enterText("Change Name - Relationship Page", "Beneficial Percent Field", lastBeneficialPercent, beneficial_Percent);
				}
				stepResult = true;
			}
		}catch(Exception e){
			e.printStackTrace();
		}finally {
			if (stepResult == true) {
				System.out.println("Pass");
				new HTMLReportHelper().HtmlReportBody("Add a Beneficial Ownership", "Beneficial Ownership added Successfully", "Passed", driver, "Y");
			} else {
				System.out.println("fail");
				new HTMLReportHelper().HtmlReportBody("Add a Beneficial Ownership", "Could not add Beneficial Ownership", "Failed", driver, "Y");
			}

		}
	}

	public void saveDetails() throws Exception {
		boolean stepResult = false;
		try {
			clickOnElement("Change Name Page", "Save", saveButton);
			
			if (isOptionalElementPresent(allRelationshipNameCheckBoc)){
				clickOnElement("Change Name Page", "All relationships will reflect name changes Check Box", allRelationshipNameCheckBoc);
				clickOnElement("Change Name Page", "Save", saveButton);
				
			}
			if (isElementPresent(searchLabel)){
				switchToWindowWithTitleContaining("Institution 01 - REPUBLIC BANK UAT");
				switchToDefaultContent();
				stepResult = true;
				
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (stepResult == true) {
				System.out.println("Pass");
				new HTMLReportHelper().HtmlReportBody("Save Change Name Details", "Change Name details saved Successfully", "Passed", driver, "Y");
			} else {
				System.out.println("fail");
				new HTMLReportHelper().HtmlReportBody("Save Change Name Details", "Could not saved Change Name details", "Failed", driver, "Y");
			}
		}
	}

	public void deleteLastBeneficiary() throws Exception {
		boolean stepResult = false;
		try {
			
			if (isElementPresent(beneficiaryOwnerTitle)){
				clickOnElement("Change Name - Relationships Page", "Delete image", lastDeleteBeneficiary);
				stepResult = true;
				
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (stepResult == true) {
				System.out.println("Pass");
				new HTMLReportHelper().HtmlReportBody("Delete Beneficiary", "Beneficiary deleted Successfully", "Passed", driver, "Y");
			} else {
				System.out.println("fail");
				new HTMLReportHelper().HtmlReportBody("Delete Beneficiary", "Could not delete the Beneficiary", "Failed", driver, "Y");
			}
		}
	}

	
	public void clickAddBeneficiary() throws Exception {
		boolean stepResult = false;
		try {
			
			if (isElementPresent(beneficiaryOwnerTitle)){
				clickOnElement("Change Name - Relationships Page", "Add Beneficial Owner Link", addBeneficiaryLink);
				stepResult = true;
				
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (stepResult == true) {
				System.out.println("Pass");
				new HTMLReportHelper().HtmlReportBody("Click Add Beneficial Owner", "Clicked on Add Beneficial Owner Successfully", "Passed", driver, "Y");
			} else {
				System.out.println("fail");
				new HTMLReportHelper().HtmlReportBody("Click Add Beneficial Owner", "Could not Click on Add Beneficial Owner", "Failed", driver, "Y");
			}
		}
	}



}


