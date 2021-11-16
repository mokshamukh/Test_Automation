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


public class Premier_CustomerNewName extends CommonLibrary {

	public By nameTitle = By.xpath("//label[text()='Step 1 - Name']");
	public By nameTextbox = By.xpath("(//label[text()='Name:'])[1]/../following-sibling::td/input");
	public By lastNameTextbox = By.xpath("(//label[text()='Last Name:'])[1]/../following-sibling::td/input");
	public By firstNametextbox = By.xpath("(//label[text()='First Name:'])[1]/../following-sibling::td/input");
	public By dateOfBirth = By.xpath("(//label[text()='Date of Birth:'])[1]/../following-sibling::td/div/input");
	public By taxIDNum = By.xpath("(//label[text()='Tax ID Number:'])[1]/../following-sibling::td/input");
	public By nextButton = By.xpath("//button[@id='NextButton']");
	public By frame = By.xpath("//iframe[@id='Main']");
	public By finishButton = By.xpath("//button[@name='SubmitButton']");
	public By branchRegionButton = By.xpath("(//label[text()='Branch Region:'])[1]/../following-sibling::td//button");
	public By branchRegionVal = By.xpath("(//label[text()='Branch Region:'])[1]/../following-sibling::td//input[contains(@class,'EllipseText')]");
	public By codeLabel = By.xpath("//label[text()='Step 4 - Codes']");
	public By duplicateLabel = By.xpath("//label[text()='Step 2 - Duplicate']");
	public By contactMethodsLabel = By.xpath("//label[text()='Step 3 - Contact Methods']");
	public By buildRelationshipLabel = By.xpath("//label[text()='Step 5 - Build Relationships']");
	public By phoneNumLink = By.xpath("//a[@id='lnkPhone']");
	public By emailLink = By.xpath("//a[@id='lnkEmail']");
	public By phoneNumVal = By.xpath("(//input[contains(@name,'PhoneNumber')])[1]");
	public By emailVal = By.xpath("(//input[contains(@name,'ContactInfo')])[1]");
	public By phoneDescript = By.xpath("(//input[contains(@name,'PhoneDescription')])[1]");
	public By msg = By.xpath("//*[text()='The record was updated successfully.']");

	public Premier_CustomerNewName(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(new AjaxElementLocatorFactory(driver, 30), this);

	}

	public void createNewName(String name, String firstName, String lastName, String dob, String taxID,String phoneNumber,
			String branchRegion,String email) throws Exception {
		boolean stepResult = false;
		try {
			Thread.sleep(6000);
				driver.switchTo().frame("Main");
				enterCustomerName(name,firstName, lastName,dob,taxID);
				enterDuplicate();
				enterContactMethod(phoneNumber, email);
				enterCodeLable(branchRegion);
				isElementPresent(buildRelationshipLabel);
				clickOnElement("New Name Page", "Finish Button", finishButton);
				Thread.sleep(2000);
				isElementPresent(msg);
				switchToWindowWithTitleContaining("Institution 01 - REPUBLIC BANK UAT");
				//driver.switchTo().defaultContent();
			stepResult = true;
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (stepResult == true) {
				System.out.println("Pass");
				new HTMLReportHelper().HtmlReportBody("New Name Page", "Create name Successfully", "Passed", driver,
						"Y");
			} else {
				System.out.println("fail");
				new HTMLReportHelper().HtmlReportBody("New Name Page", "Could not create name.", "Failed", driver, "Y");
			}
		}

		
	}
	
	public void enterCustomerName(String name, String firstName, String lastName, String dob, String taxID) throws Exception{
		boolean stepResult = false;
		try {
			Thread.sleep(4000);
			if (isElementPresent(nameTitle)) {
					if (!name.equals("")) {
						enterText("New Name Page", "Name field", nameTextbox, name);
					}
					validateElementExist("New Name Page", "First Name", firstNametextbox, firstName);
					validateElementExist("New Name Page", "Last Name", lastNameTextbox, lastName);
					if (!dob.equals("")) {
						enterText("New Name Page", "Date of Birth", dateOfBirth, dob);
					}
					if (!taxID.equals("")) {
						enterText("New Name Page", "Tax Identification", taxIDNum, taxID.substring(4));
					}
					clickOnElement("New Name Page", "Next Button", nextButton);
				
			}
			stepResult = true;
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (stepResult == true) {
				System.out.println("Pass");
				new HTMLReportHelper().HtmlReportBody("New Name Page", "Create name page Successfully", "Passed", driver, "Y");
			} else {
				System.out.println("fail");
				new HTMLReportHelper().HtmlReportBody("New Name Page", "Create name page Successfully", "Failed", driver, "Y");
			}
		}
	}
	
	public void enterDuplicate() throws Exception{
		boolean stepResult = false;
		try {
			if (isElementPresent(duplicateLabel)) {
				Thread.sleep(2000);
				clickOnElement("New Name Page", "Next Button", nextButton);
			}
			stepResult = true;
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (stepResult == true) {
				System.out.println("Pass");
				new HTMLReportHelper().HtmlReportBody("New Name Page", "Create Duplicate page Successfully", "Passed", driver, "Y");
			} else {
				System.out.println("fail");
				new HTMLReportHelper().HtmlReportBody("New Name Page", "Create Duplicate page Successfully", "Failed", driver, "Y");
			}
		}
	}
	
	public void enterContactMethod(String phoneNumber,String email) throws Exception{
		boolean stepResult = false;
		try {
			if (isElementPresent(contactMethodsLabel)) {
				Thread.sleep(2000);
				/*clickOnElement("New Name Page", "Phone Number", phoneNumLink);
				clickOnElement("New Name Page", "Phone Number", phoneNumVal);
				enterText("New Name Page", "Phone Number", phoneNumVal, phoneNumber.substring(10));
				Thread.sleep(2000);
				clickOnElement("New Name Page", "Email link", emailLink);
				clickOnElement("New Name Page", "Email", emailVal);
				enterText("New Name Page", "Email", emailVal, email);
				Thread.sleep(2000);
				clickOnElement("New Name Page", "Next Button", nextButton);*/
				clickOnElement("New Name Page", "Phone Number", phoneNumLink);
				WebDriverWait wait1 = new WebDriverWait(driver, 20);
				WebElement element1 = wait1.until(ExpectedConditions.elementToBeClickable(phoneNumVal));
				element1.click();
				enterText("New Name Page", "Phone Number", phoneNumVal, phoneNumber.substring(10));
				Thread.sleep(2000);
				clickOnElement("New Name Page", "Email link", emailLink);
				WebElement element2 = wait1.until(ExpectedConditions.elementToBeClickable(emailVal));
				element2.click();
				enterText("New Name Page", "Phone Number", emailVal, email);
				Thread.sleep(2000);
				clickOnElement("New Name Page", "Next Button", nextButton);
			}
			stepResult = true;
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (stepResult == true) {
				System.out.println("Pass");
				new HTMLReportHelper().HtmlReportBody("New Name Page", "Create Contact method page Successfully", "Passed", driver, "Y");
			} else {
				System.out.println("fail");
				new HTMLReportHelper().HtmlReportBody("New Name Page", "Create Contact method page Successfully", "Failed", driver, "Y");
			}
		
	}}

	public void enterCodeLable(String branchRegion) throws Exception{
		boolean stepResult = false;
		try {
			if (isElementPresent(codeLabel)) {
				Thread.sleep(2000);
				clickOnElement("New Name Page", "Branch Region Button",branchRegionVal);
				enterText("New Name Page", "Branch Region Button", branchRegionVal, branchRegion);
				clickOnElement("New Name Page", "Next Button", nextButton);
			}
			
			stepResult = true;
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (stepResult == true) {
				System.out.println("Pass");
				new HTMLReportHelper().HtmlReportBody("New Name Page", "Create Code lable page Successfully", "Passed", driver, "Y");
			} else {
				System.out.println("fail");
				new HTMLReportHelper().HtmlReportBody("New Name Page", "Create Code lable page Successfully", "Failed", driver, "Y");
			}
		
	}
		
	}
	
	
}
