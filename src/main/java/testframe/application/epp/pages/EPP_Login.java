package testframe.application.epp.pages;
/**
 * PageName : EPP_LoginPage
 * 
 * @author Shilpa.Thangapalam
 */
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;

import testframe.application.common.CommonLibrary;
import testframe.common.reporting.HTMLReportHelper;

public class EPP_Login extends CommonLibrary {

	public EPP_Login(WebDriver driver) {
		super(driver);
		PageFactory.initElements(new AjaxElementLocatorFactory(driver, 50), this);
	}

	public String eppLoginPage = "EPP_LoginPage";
	

	By loginLogo = By.xpath("//h2[text()='Log in to your account']");
	By userID = By.xpath("//input[@id='usrName']");
	By password = By.xpath("//input[@id='usrPwd']");
	By loginButton = By.xpath("//button[text()='Log in']");
	By securityQuestLogo = By.xpath(" //h2[@id='securityQuestionsHeading']");
	
	
	public void launchApplication(String url) {
		boolean stepResult = false;
		try {
			goTo(url);
			isElementPresent(loginLogo);
			stepResult = true;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			if (stepResult == true) {
				System.out.println("Pass");
				new HTMLReportHelper().HtmlReportBody("Launch EPP - EPP application", "Launch Successfully","Passed", driver, "Y");
			} else {
				System.out.println("fail");
				new HTMLReportHelper().HtmlReportBody("Launch EPP - EPP application","Could not Launch Successfully", "Failed", driver, "Y");
			}
		}
	}

	public void loginEppApplication (String eppUserID, String eppPswd) {
		boolean stepResult = false;
		try {
			waitForPresenceOfElement(eppLoginPage, "Login Logo", loginLogo);
			isElementPresent(loginLogo);
			enterText(eppLoginPage, "EPPUserID", userID, eppUserID);
			enterText(eppLoginPage, "EPPPswd", password, eppPswd);
			clickOnElement(eppLoginPage, "LoginButton", loginButton);
			waitForPresenceOfElement(eppLoginPage, "SecurityQuestion", securityQuestLogo);
			stepResult = true;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			if (stepResult == true) {
				System.out.println("Pass");
				new HTMLReportHelper().HtmlReportBody("Login EPP - EPP application", "Login Successfully","Passed", driver, "Y");
			} else {
				System.out.println("fail");
				new HTMLReportHelper().HtmlReportBody("Login EPP - EPP application","Could not Login Successfully", "Failed", driver, "Y");
			}
		}

	}

	

}
