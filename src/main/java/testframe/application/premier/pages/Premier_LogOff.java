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

	public String adminLoginPage;

	public By logoff = By.xpath("//a[text()='Log Off']");
	public By logOffMessage =  By.xpath("//h1[text()='You are now logged off']"); 

	public Premier_LogOff(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public void logoffApplication(){
		boolean stepResult = false;
		try {
			clickOnElement("Admin Page", "Log Off button", logoff);
			if (isElementPresent(logOffMessage))
				stepResult = true;
		}catch (Exception e) {
			e.printStackTrace();
		}
		finally {
			if (stepResult==true){
				System.out.println("Pass");
				new HTMLReportHelper().HtmlReportBody("LogOff CC- Admin application", "LogOff Successfully", "Passed", driver, "Y");
			}
			else{
				System.out.println("fail");
				new HTMLReportHelper().HtmlReportBody("LogOff CC- Admin application", "Could not LogOff Successfully", "Failed", driver, "Y");
			}
		}

	}

	

}
