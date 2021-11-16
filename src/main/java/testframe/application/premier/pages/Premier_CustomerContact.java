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
	public By nameLink = By.xpath("(//a[contains(@onclick,'HourglassWork')])[1]");
	public By saveButton = By.xpath("//a[contains(@onclick,'Save')]");

	public Premier_CustomerContact(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(new AjaxElementLocatorFactory(driver, 30), this);
	}
	
	public void createNewContact(String sSN) throws Exception{
		boolean stepResult = false;
		try {
			Thread.sleep(4000);
				driver.switchTo().frame("Main");
				searchSSN(sSN);
				clickOnElement("New Contact Page", "Save Button", saveButton);
				Thread.sleep(2000);
				switchToWindowWithTitleContaining("Institution 01 - REPUBLIC BANK UAT");
			stepResult = true;
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (stepResult == true) {
				System.out.println("Pass");
				new HTMLReportHelper().HtmlReportBody("New Contact Page", "Create Contact page Successfully", "Passed",
						driver, "Y");
			} else {
				System.out.println("fail");
				new HTMLReportHelper().HtmlReportBody("New Contact Page", "Create Contact page Successfully", "Failed",
						driver, "Y");
			}
		}
		
	}

	public void searchSSN(String sSN) throws Exception{
		boolean stepResult = false;
		try {
			Thread.sleep(4000);
				if (isElementPresent(searchTitle)) {
					clickOnElement("Add Name Page", "Tax Identification", ssnSearch);
					enterText("Add Name Page", "Tax Identification", ssnSearch, sSN.substring(4));
					clickOnElement("Add Name Page", "Submit", submitSearch);
					if(isElementPresent(nameLink)){
					clickOnElement("Add Name Page", "Name link", nameLink);}
				}
			stepResult = true;
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (stepResult == true) {
				System.out.println("Pass");
				new HTMLReportHelper().HtmlReportBody("New Contact Page", "Search Contact page Successfully", "Passed",
						driver, "Y");
			} else {
				System.out.println("fail");
				new HTMLReportHelper().HtmlReportBody("New Contact Page", "Could not Search Contact page Successfully", "Failed",
						driver, "Y");
			}
		}

	}
	
}
