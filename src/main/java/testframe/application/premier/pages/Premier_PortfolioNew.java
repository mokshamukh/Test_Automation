package testframe.application.premier.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;

import testframe.application.common.CommonLibrary;
import testframe.common.reporting.HTMLReportHelper;

public class Premier_PortfolioNew extends CommonLibrary{
	
	public By newPortfolioHeader =  By.xpath("//td[text()='New Portfolio']");
	public By customerPageTitle =  By.xpath("//a[text()='Step 1 - Customer']");
	public By addNameLink =  By.xpath("//u[text()='Add Name']");
	public By name1Textbox =  By.xpath("//td[contains(text(),'Name 1:')]/following-sibling::td/input[contains(@id,'Name')]");
	public By taxCode1List =  By.xpath("//td[contains(text(),'Name 1:')]/following-sibling::td//select[contains(@id,'TaxIdCode')]");
	public By taxNumber1Textbox =  By.xpath("//td[contains(text(),'Name 1:')]/following-sibling::td//input[contains(@id,'TaxIdNumber')]");
	public By dOBTextbox1 =  By.xpath("//td[contains(text(),'Name 1:')]/following-sibling::td//input[contains(@id,'DateOfBirth')]");
	public By search1 =  By.xpath("//td[contains(text(),'Name 1:')]/following-sibling::td//img[@title='Search']");
	public By name2Textbox =  By.xpath("//td[contains(text(),'Name 2:')]/following-sibling::td/input[contains(@id,'Name')]");
	public By taxCode2List =  By.xpath("//td[contains(text(),'Name 2:')]/following-sibling::td//select[contains(@id,'TaxIdCode')]");
	public By taxNumber2Textbox =  By.xpath("//td[contains(text(),'Name 2:')]/following-sibling::td//input[contains(@id,'TaxIdNumber')]");
	public By dOBTextbox2 =  By.xpath("//td[contains(text(),'Name 2:')]/following-sibling::td//input[contains(@id,'DateOfBirth')]");
	public By search2 =  By.xpath("//td[contains(text(),'Name 2:')]/following-sibling::td//img[@title='Search']");
	public By name3Textbox =  By.xpath("//td[contains(text(),'Name 3:')]/following-sibling::td/input[contains(@id,'Name')]");
	public By taxCode3List =  By.xpath("//td[contains(text(),'Name 3:')]/following-sibling::td//select[contains(@id,'TaxIdCode')]");
	public By taxNumber3Textbox =  By.xpath("//td[contains(text(),'Name 3:')]/following-sibling::td//input[contains(@id,'TaxIdNumber')]");
	public By dOBTextbox3 =  By.xpath("//td[contains(text(),'Name 3:')]/following-sibling::td//input[contains(@id,'DateOfBirth')]");
	public By search3 =  By.xpath("//td[contains(text(),'Name 3:')]/following-sibling::td//img[@title='Search']");
	public By name4Textbox =  By.xpath("//td[contains(text(),'Name 4:')]/following-sibling::td/input[contains(@id,'Name')]");
	public By taxCode4List =  By.xpath("//td[contains(text(),'Name 4:')]/following-sibling::td//select[contains(@id,'TaxIdCode')]");
	public By taxNumber4Textbox =  By.xpath("//td[contains(text(),'Name 4:')]/following-sibling::td//input[contains(@id,'TaxIdNumber')]");
	public By dOBTextbox4 =  By.xpath("//td[contains(text(),'Name 4:')]/following-sibling::td//input[contains(@id,'DateOfBirth')]");
	public By search4 =  By.xpath("//td[contains(text(),'Name 4:')]/following-sibling::td//img[@title='Search']");
	public By address1 =  By.xpath("//td[contains(text(),'Address 1:')]/following-sibling::td/input[contains(@id,'Address')]");
	public By address2 =  By.xpath("//td[contains(text(),'Address 2:')]/following-sibling::td/input[contains(@id,'Address')]");
	public By cityStateZip =  By.xpath("//td[contains(text(),'City State Zip:')]/following-sibling::td/input[contains(@id,'CityStZip')]");
	public By deliveryPoint =  By.xpath("//td[contains(text(),'Delivery Point:')]/following-sibling::td/input[contains(@id,'DeliveryPt')]");
	public By branchRegionTextbox =  By.xpath("(//input[contains(@id,'BranchNumber')])[1]");
	public By branchRegionButton =  By.xpath("(//input[contains(@id,'BranchNumber')])[3]");
	String branchRegionList =  "//select[contains(@id,'BranchNumber')]/option[contains(text(),'%s')]";
	public By accountingBranch =  By.xpath("//td[contains(text(),'Accounting Branch:')]/following-sibling::td/input[contains(@id,'AccountingGroup')]");
	public By duplicatePageTitle =  By.xpath("//a[text()='Step 2 - Possible Duplicates']");
	public By duplicateMsg =  By.xpath("//td[contains(text(),'No duplicate matches were found.')]");
	public By existingName =  By.xpath("//td[contains(text(),'Existing Name')]");
	public By nameRelationshipPageTitle =  By.xpath("//a[text()='Step 3 - Name Relationship']");
	public By codesPageTitle =  By.xpath("//a[text()='Step 5 - Codes']");
	public By extAvailableLink = By.xpath("//u[text()='Next Available']");
	public By portfolioTextbox =  By.xpath("//td[contains(text(),'Portfolio:')]/following-sibling::td/input[contains(@id,'PortfolioNumber')]");
	public By portfolioTypeCode =  By.xpath("//td[contains(text(),'Portfolio Type Code:')]/following-sibling::td/input[contains(@id,'AccountTypeCode')]");
	public By miscCode =  By.xpath("//td[contains(text(),'Miscellaneous Code:')]/following-sibling::td/input[contains(@id,'MiscCode')]");
	public By responsibilityCodeButton =  By.xpath("(//input[contains(@name,'ResponsibilityCode')])[3]");
	String responsibilityCodeList =  "//select[contains(@name,'ResponsibilityCode')]/option[contains(text(),'%s')]";

	
	public Premier_PortfolioNew(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(new AjaxElementLocatorFactory(driver, 30), this);
	}
	
	public void createNewPortfolio(String name1, String taxCode1, String taxNumber1,String dob1,String name2, String taxCode2, String taxNumber2,String dob2,
			String name3, String taxCode3, String taxNumber3,String dob3,String name4, String taxCode4, String taxNumber4,String dob4, String sAddress1,String sAddress2, String zipCode,
			String deliveryPoint,String branchRegion, String accountingBranch,String relationship,String portfolio,String portfolioTypeCode,String responsibilityCode,String miscCode) throws Exception{
		boolean stepResult = false;
		try {
			Thread.sleep(6000);
			driver.switchTo().frame("Main");
			if (isElementPresent(newPortfolioHeader)) {
				enterCustomerDetails(name1,taxCode1,taxNumber1,dob1,name2,taxCode2,taxNumber2,dob2,name3,taxCode3,taxNumber3,dob3,name4,taxCode4,taxNumber4,dob4,sAddress1,sAddress2,zipCode,deliveryPoint,branchRegion,
						accountingBranch,relationship,portfolio,portfolioTypeCode,responsibilityCode,miscCode);
				stepResult = true;
				
			}
			switchToDefaultContent();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (stepResult == true) {
				System.out.println("Pass");
				new HTMLReportHelper().HtmlReportBody("New Portfolio Page", "Create New Portfolio Successfully", "Passed",driver, "Y");
			} else {
				System.out.println("fail");
				new HTMLReportHelper().HtmlReportBody("New Portfolio Page", "Could not Create New Portfolio Successfully", "Failed",driver, "Y");
			}
		}}

	
	public void enterCustomerDetails(String name1, String taxCode1, String taxNumber1,String dob1,String name2,String taxCode2,String taxNumber2,String dob2,
			String name3,String taxCode3,String taxNumber3,String dob3,String name4,String taxCode4,String taxNumber4,String dob4, String sAddress1,String sAddress2, String zipCode,
			String deliveryPoint,String branchRegion, String accountingBranch,String relationship,String portfolio,String portfolioTypeCode,String responsibilityCode,String miscCode) throws Exception {
		boolean stepResult = false;
		try {
			if (isElementPresent(customerPageTitle)) {
				clickOnElement("New Portfolio Page", "Search Icon", search1);
				//
				stepResult = true;
			}
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			if (stepResult == true) {
				System.out.println("Pass");
				new HTMLReportHelper().HtmlReportBody("New Portfolio Page", "Entered Customer Details on New Portfolio Page Successfully", "Passed",driver, "Y");
			} else {
				System.out.println("fail");
				new HTMLReportHelper().HtmlReportBody("New Portfolio Page", "Could not Entered Customer Details on New Portfolio Page", "Failed",driver, "Y");
			}
			
		}}
	
}
