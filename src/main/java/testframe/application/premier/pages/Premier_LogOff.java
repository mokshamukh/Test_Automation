package testframe.application.premier.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import testframe.application.common.CommonLibrary;
import testframe.common.reporting.HTMLReportHelper;

/**
 * 
 * 
 * @author Ketki.Badalwar
 */

public class Premier_LogOff extends CommonLibrary {

	public By securityControl =  By.xpath("//a[text()='Security Control']");

	public By logoff = By.xpath("//a[text()='Log Out']");
	public By myGroupPageHeader = By.xpath("//h2[text()='My Groups']");

	public Premier_LogOff(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public void logoffApplication() throws Exception{
		boolean stepResult = false;
		try {
		clickOnElement("Home Page", "Security Control Option", securityControl);
		clickOnElement("Home Page", "Log Off link", logoff);
			if (isElementPresent(myGroupPageHeader))
			stepResult = true;
		}catch (Exception e) {
		e.printStackTrace();
		}
		finally {
			if (stepResult==true){
			System.out.println("Pass");
			new HTMLReportHelper().HtmlReportBody("LogOff Premier application", "LogOff Successfully", "Passed", driver, "Y");
			}
			else{
			System.out.println("fail");
			new HTMLReportHelper().HtmlReportBody("LogOff Premier application", "Could not LogOff Successfully", "Failed", driver, "Y");
			}
		}}

}
