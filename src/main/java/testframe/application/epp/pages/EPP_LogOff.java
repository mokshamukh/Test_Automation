package testframe.application.epp.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;

import testframe.application.common.CommonLibrary;
import testframe.common.reporting.HTMLReportHelper;

public class EPP_LogOff extends CommonLibrary{

	public EPP_LogOff(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
		PageFactory.initElements(new AjaxElementLocatorFactory(driver, 50), this);
	}

	public String eppLogOff = "EPPlogoutPage";


	By logoutButton = By.xpath("//a[text()='power_settings_new']");


	public void logOffEPPApplication() throws Exception {
		if (System.getProperty("runStep")=="Y"){
			boolean stepResult = false;
			try {
				switchToWindowWithTitleContaining("Authentication Gateway");
				driver.switchTo().defaultContent();
				waitElement(3000);
				waitForPresenceOfElement(eppLogOff, "Logout Page", logoutButton);
				clickOnElement(eppLogOff, "Logout Page", logoutButton);
				waitElement(6000);
				stepResult = true;
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} finally {
				if (stepResult == true) {
					System.out.println("Pass");
					new HTMLReportHelper().HtmlReportBody("LogOff EPP application", "LogOff Successfully",
							"Passed", driver, "Y");
				} else {
					System.out.println("fail");
					new HTMLReportHelper().HtmlReportBody("LogOff EPP application","Could not LogOff Successfully", "Failed", driver, "Y");
					System.setProperty("runStep","N");
				}
			}
		}
	}

}
