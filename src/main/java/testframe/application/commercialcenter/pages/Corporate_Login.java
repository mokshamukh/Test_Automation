package testframe.application.commercialcenter.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import testframe.application.common.CommonLibrary;
import testframe.common.reporting.HTMLReportHelper;

/**
 * PageNage : CommercialCenter_Corporate_Login
 * 
 * @author Ketki.Badalwar
 */

public class Corporate_Login extends CommonLibrary {

	By companyID = By.xpath("//input[@id='companyId']");
	By userID = By.xpath("//input[@id='userId']");
	By loginButton = By.xpath("//button[text()='Login']");
	By img = By.xpath("//div[@class='verification-image-container']");
	By password = By.xpath("//input[@id='password']");
	By cancelButton = By.xpath("//a[text()='Cancel']");
	By forgotPasswordButton = By.xpath("//a[text()='Forgot Password?']");
	String pageMenuOptions = "//a[@title='%s']";
	By corpRepublicBankLogo = By.xpath("//img[@class='company-image']");
	By dashboardTitle = By.xpath("//a[@title='Dashboard']");


	public Corporate_Login(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public void launchApplication(String url) throws Exception {
		if (System.getProperty("runStep")=="Y"){	
			boolean stepResult = false;
			try {
				goTo(url);
				if (isElementPresent(corpRepublicBankLogo))
					stepResult = true;
			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				if (stepResult == true){
					System.out.println("Pass");
					new HTMLReportHelper().HtmlReportBody("Launch CC- Corporate application", "Launch Successfully", "Passed", driver, "Y");}
				else{
					System.out.println("fail");
					new HTMLReportHelper().HtmlReportBody("Launch CC- Corporate application", "Could not Launch Successfully", "Failed", driver, "Y");}
				System.setProperty("runStep","N");
			}
		}

	}

	public void logInToApplication(String corpCompanyID, String corpUserID, String psd) throws Exception {
		if (System.getProperty("runStep")=="Y"){	
			boolean stepResult = false;
			try {
				isElementPresent(corpRepublicBankLogo);
				enterText("Corporate Login Page", "CompanyID", companyID, corpCompanyID);
				enterText("Corporate Login Page", "UserID", userID, corpUserID);
				clickOnElement("Corporate Login Page", "Login Button", loginButton);
				if (isElementPresent(img)) {
					enterText("Corporate Login Page", "Password", password, psd);
					clickOnElement("Corporate Login Page", "Login Button", loginButton);
					if (isElementPresent(dashboardTitle))
						stepResult = true;
				}
			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				if (stepResult==true){
					System.out.println("Pass");
					new HTMLReportHelper().HtmlReportBody("Login CC- Corporate application", "Login Successfully", "Passed", driver, "Y");
				}
				else{
					System.out.println("fail");
					new HTMLReportHelper().HtmlReportBody("Login CC- Corporate application", "Could not Login Successfully", "Failed", driver, "Y");
					System.setProperty("runStep","N");
				}
			}
		}

	}

}
