package testframe.application.commercialcenter.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import testframe.application.common.CommonLibrary;
import testframe.common.reporting.HTMLReportHelper;

/**
 * PageNage : CommercialCenter_Corporate_LogOff
 * 
 * @author Ketki.Badalwar
 */

public class Corporate_LogOff extends CommonLibrary {

	public String CorporateLoginPage;

	public By logoff = By.xpath("//button[text()='Logout']");
	public By logOffMessage = By.xpath("//div[contains(text(),'You have been logged out of online banking')]");
	public By user = By.xpath("//div[@class='d-none d-sm-inline']");

	public Corporate_LogOff(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public void logoffApplication() {
		boolean stepResult = false;
		try {
			clickOnElement("Corporate Page", "User button", user);
			clickOnElement("Corporate Page", "Log Off button", logoff);
			if (isElementPresent(logOffMessage))
				stepResult = true;
			//driver.close();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (stepResult == true) {
				System.out.println("Pass -- logoff");
				new HTMLReportHelper().HtmlReportBody("LogOff CC- Corporate application", "LogOff Successfully",
						"Passed", driver, "Y");
			} else {
				System.out.println("fail");
				new HTMLReportHelper().HtmlReportBody("LogOff CC- Corporate application",
						"Could not LogOff Successfully", "Failed", driver, "Y");
			}
		}

	}

}
