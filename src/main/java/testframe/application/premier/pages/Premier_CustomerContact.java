package testframe.application.premier.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;

import testframe.application.common.CommonLibrary;
import testframe.common.reporting.HTMLReportHelper;

public class Premier_CustomerContact extends CommonLibrary{

	public By searchTitle = By.xpath("//label[text()='Search']");
	public By ssnSearch = By.xpath("//input[@name='TaxID']");
	public By submitSearch = By.xpath("//button[text()='Submit']");
	public By nameLink = By.xpath("(//a[contains(@id,'SearchType=Name')])[1]");
	public By saveButton = By.xpath("//a[contains(@onclick,'Save')]");
	//below xpath are not used yet
	public By reasonButton =  By.xpath("//button[contains(@id,'ContactPurposeCode_b')]");
	String reasonList =  "//select[contains(@id,'ContactPurposeCode_d')]/option[contains(text(),'%s')]";
	public By methodButton =  By.xpath("//button[contains(@id,'ContactMethod_b')]");
	String methodList =  "//select[contains(@id,'ContactMethod_d')]/option[contains(text(),'%s')]";
	public By responsibilityCodeButton =  By.xpath("//button[contains(@id,'ResponsibilityCode_b')]");
	String responsibilityCodeList =  "//select[contains(@id,'ResponsibilityCode_d')]/option[contains(text(),'%s')]";
	public By miscellaneousCodeButton =  By.xpath("//button[contains(@id,'MiscCode_b')]");
	String miscellaneousCodeList =  "//select[contains(@id,'MiscCode_d')]/option[contains(text(),'%s')]";
	public By nextTicklerDate =  By.xpath("//input[contains(@name,'NextTicklerDate')]");
	public By statusDate =  By.xpath("//input[contains(@name,'StatusDate')]");
	public By statusCodeButton =  By.xpath("//button[contains(@id,'ContactStatus_b')]");
	String statusCodeList =  "//select[contains(@id,'ContactStatus_d')]/option[contains(text(),'%s')]";
	public By assignedToButton =  By.xpath("//button[contains(@id,'AssignedToRespCode_b')]");
	String assignedToList =  "//select[contains(@id,'AssignedToRespCode_d')]/option[contains(text(),'%s')]";
	public By followUp =  By.xpath("//input[contains(@name,'ContactFollowUp')]");
	public By responseButton =  By.xpath("//button[contains(@id,'ContactResponse_b')]");
	String responseList =  "//select[contains(@id,'ContactResponse_d')]/option[contains(text(),'%s')]";
	public By actionCodeButton =  By.xpath("//button[contains(@id,'ContactActionCode_b')]");
	String actionCodeList =  "//select[contains(@id,'ContactActionCode_d')]/option[contains(text(),'%s')]";
	public By expirationDateButton =  By.xpath("//input[contains(@name,'ExpirationDate')]");

	public Premier_CustomerContact(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(new AjaxElementLocatorFactory(driver, 30), this);
	}

	public void createNewContact(String sSN) throws Exception{
		if (System.getProperty("runStep")=="Y"){
			boolean stepResult = false;
			try {
				Thread.sleep(2000);
				driver.switchTo().frame("Main");
				searchSSN(sSN);
				Thread.sleep(2000);
				clickOnElement("New Contact Page", "Save Button", saveButton);
				Thread.sleep(2000);
				switchToWindowWithTitleContaining("Institution");
				stepResult = true;
			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				if (stepResult == true) {
					System.out.println("Pass");
					new HTMLReportHelper().HtmlReportBody("Create New Contact", "Create Contact page Successfully", "Passed",
							driver, "Y");
				} else {
					System.out.println("fail");
					new HTMLReportHelper().HtmlReportBody("Create New Contact", "Could not Create Contact page Successfully", "Failed",
							driver, "Y");
					System.setProperty("runStep","N");
				}
			}
		}

	}

	public void searchSSN(String sSN) throws Exception{
		if (System.getProperty("runStep")=="Y"){
			
			boolean stepResult = false;
			try {
				Thread.sleep(7000);
				if (isElementPresent(searchTitle)) {
					clickOnElement("Add Name Page", "Tax Identification", ssnSearch);
					enterText("Add Name Page", "Tax Identification", ssnSearch, sSN);
					clickOnElement("Add Name Page", "Submit", submitSearch);
					Thread.sleep(3000);
					if(isElementPresent(nameLink)){
						clickOnElement("Add Name Page", "Name link", nameLink);
						
						Thread.sleep(4000);
						}
					stepResult = true;
				}

			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				if (stepResult == true) {
					System.out.println("Pass");
					new HTMLReportHelper().HtmlReportBody("Search SSN", "Search SSN on Contact page Successfully", "Passed",
							driver, "N");
				} else {
					System.out.println("fail");
					new HTMLReportHelper().HtmlReportBody("Search SSN", "Could not Search SSN on Contact page Successfully", "Failed",
							driver, "N");
					System.setProperty("runStep","N");
				}
			}
		}

	}

}
