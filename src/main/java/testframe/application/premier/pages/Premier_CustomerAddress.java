package testframe.application.premier.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;

import testframe.application.common.CommonLibrary;
import testframe.common.reporting.HTMLReportHelper;

/**
 * PageNage : Premier_CustomerAddress
 * 
 * @author Ketki.Badalwar
 */


public class Premier_CustomerAddress extends CommonLibrary {

	public By addressTitle = By.xpath("//label[text()='Step 1 - Address']");
	public By address1 = By.xpath("(//label[text()='Address 1:'])[1]/../following-sibling::td/input");
	public By address2 = By.xpath("(//label[text()='Address 2:'])[1]/../following-sibling::td/input");
	public By zipCode = By.xpath("(//label[text()='City State Zip:'])[1]/../following-sibling::td//input");
	public By nextButton = By.xpath("//button[@id='NextButton']");
	public By duplicateTitle = By.xpath("//label[text()='Step 2 - Duplicate']");
	public By bulidRelationshipTitle = By.xpath("//label[text()='Step 3 - Build Relationships']");
	public By plusIcon = By.xpath("//img[@title='Add Name']");
	public By searchTitle = By.xpath("//label[text()='Search']");
	public By ssnSearch = By.xpath("//input[@name='TaxID']");
	public By submitSearch = By.xpath("//button[text()='Submit']");
	public By nameLink = By.xpath("//a[contains(@onclick,'ModalClose()')]");
	public By relationship = By.xpath("//select[contains(@id,'RelationshipCode')]");
	public By finishButton = By.xpath("//button[@name='SubmitButton']");
	public By iframeVal = By.xpath("//iframe[@id='bottom']");
	public By branchRegionVal = By.xpath("(//label[text()='Branch Region:'])[1]/../following-sibling::td//input[contains(@class,'EllipseText')]");
	public By msg = By.xpath("//*[text()='The record was updated successfully.']");
	
	public Premier_CustomerAddress(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(new AjaxElementLocatorFactory(driver, 30), this);

	}

	public void createNewAddress(String address1Val, String address2Val, String zipcodeVal, String sSSN,String realationshipVal,String branchRegion) throws Exception {
		boolean stepResult = false;
		try {
			switchToWithinFrameWithName("Main");
			enterAddress(address1Val, address2Val, zipcodeVal,branchRegion);
			Thread.sleep(2000);
			if (isElementPresent(duplicateTitle)) {
				clickOnElement("New Address Page", "next button", nextButton);
			}
			createBuildRelationship(sSSN, realationshipVal);
			Thread.sleep(2000);
			isElementPresent(msg);
			switchToDefaultContent();
			stepResult = true;
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (stepResult == true) {
				System.out.println("Pass");
				new HTMLReportHelper().HtmlReportBody("New Address Page", "Create New Address page Successfully",
						"Passed", driver, "Y");
			} else {
				System.out.println("fail");
				new HTMLReportHelper().HtmlReportBody("New Address Page", "Create New Address page Successfully",
						"Failed", driver, "Y");
			}
		}
	}

	public void enterAddress(String address1Val, String address2Val, String zipcodeVal,String branchRegion) throws Exception {
		boolean stepResult = false;
		try {
			Thread.sleep(4000);
			if (isElementPresent(addressTitle)) {
				if (!address1.equals("")) {
					enterText("New Address Page", "Address 1", address1, address1Val);
				}
				if (!address2.equals("")) {
					enterText("New Address Page", "Address 2", address2, address2Val);
				}
				if (!zipCode.equals("")) {
					enterText("New Address Page", "zip code", zipCode, zipcodeVal);
				}
				clickOnElement("New Name Page", "Branch Region Button",branchRegionVal);
				enterText("New Name Page", "Branch Region Button", branchRegionVal, branchRegion);
				clickOnElement("New Name Page", "Next Button", nextButton);
				clickOnElement("New Address Page", "next button", nextButton);
			}
			stepResult = true;
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (stepResult == true) {
				System.out.println("Pass");
				new HTMLReportHelper().HtmlReportBody("New Address Page", "Create Address page Successfully", "Passed",
						driver, "Y");
			} else {
				System.out.println("fail");
				new HTMLReportHelper().HtmlReportBody("New Address Page", "Create Address page Successfully", "Failed",
						driver, "Y");
			}
		}

	}

	public void createBuildRelationship(String sSN, String realationshipVal) throws Exception {
		boolean stepResult = false;
		try {
			Thread.sleep(4000);
			if (isElementPresent(bulidRelationshipTitle)) {
				clickOnElement("New Address Page", "Build relationship button", plusIcon);
				Thread.sleep(7000);
				switchToWindowWithTitleContaining("Add Name");
				driver.switchTo().frame("bottom");
				if (isElementPresent(searchTitle)) {
					clickOnElement("Add Name Page", "Tax Identification", ssnSearch);
					enterText("Add Name Page", "Tax Identification", ssnSearch, sSN.substring(4));
					clickOnElement("Add Name Page", "Submit", submitSearch);
					clickOnElement("Add Name Page", "Name link", nameLink);
					switchToWindowWithTitleContaining("Institution 01 - REPUBLIC BANK UAT");
					switchToWithinFrameWithName("Main");
				}
				selectElementByVisibleText("New Address Page", "Select Group", relationship, realationshipVal);
				clickOnElement("New Address Page", "Finish Button", finishButton);
			}
			stepResult = true;
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (stepResult == true) {
				System.out.println("Pass");
				new HTMLReportHelper().HtmlReportBody("New Address Page", "Create Address page Successfully", "Passed",
						driver, "Y");
			} else {
				System.out.println("fail");
				new HTMLReportHelper().HtmlReportBody("New Address Page", "Could not Create Address page Successfully", "Failed",
						driver, "Y");
			}
		}

	}

}
