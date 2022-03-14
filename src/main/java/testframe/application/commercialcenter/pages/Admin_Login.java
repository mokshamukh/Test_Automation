package testframe.application.commercialcenter.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import testframe.application.common.CommonLibrary;
import testframe.common.reporting.HTMLReportHelper;

/**
 * PageNage : CommercialCenter_AdminLoginPage
 * 
 * @author Ketki.Badalwar
 */

public class Admin_Login extends CommonLibrary {

	public String adminLoginPage;

	public By companyID = By.xpath("//input[@id='company']");
	public By userID = By.xpath("//input[@id='user']");
	public By loginButton = By.xpath("//button[@id='login']");
	public By img = By.xpath("//div[@class='block authimage left']");
	public By verifyCompanyID = By.xpath("//label[text()='Company ID']/parent::li/b");
	public By verifyUserID = By.xpath("//label[text()='User ID']/parent::li/b");
	public By password = By.xpath("//input[@id='passwordPrompt']");
	public By cancelButton = By.xpath("//button[@id='login']");
	public By forgotPasswordButton = By.xpath("//button[@id='forgot']");
	public By welcomeRepublicHeader =  By.xpath("//h1[text()='Welcome to Republic Bank CERT']"); 
	public By dashboardIcon = By.xpath("//li/a/span[text()='Dashboard']");

	String pageMenuOptions = "//li/a/span[text()='%s']";


	public Admin_Login(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public void launchApplication(String url) throws Exception{
		if (System.getProperty("runStep")=="Y"){	
			boolean stepResult = false;
			try {
				goTo(url);
				if (isElementPresent(welcomeRepublicHeader))
					stepResult = true;
			}catch (Exception e) {
				e.printStackTrace();
			}
			finally {
				if (stepResult==true){
					System.out.println("Pass");
					new HTMLReportHelper().HtmlReportBody("Launch application", "Launch successfully", "Passed", driver, "Y");
				}
				else{
					System.out.println("fail");
					new HTMLReportHelper().HtmlReportBody("Launch application", "Could not launch successfully", "Failed", driver, "Y");
					System.setProperty("runStep","N");
				}
			}
		}

	}

	public void logInToApplication( String admCompanyID, String admUserID, String psd) throws Exception {
		if (System.getProperty("runStep")=="Y"){
			boolean stepResult = false;
			try {

				//goTo(url);

				enterText("Admin Login Page", "CompanyID", companyID, admCompanyID);
				enterText("Admin Login Page", "UserID", userID, admUserID);
				clickOnElement("Admin Login Page", "Login Button", loginButton);
				if(isElementPresent(img)){ 
					validateTextEquals("Admin Login Page", "CompanyID", verifyCompanyID, admCompanyID);
					validateTextEquals("Admin Login Page", "User ID", verifyUserID, admUserID);
					enterText("Admin Login Page", "Password", password, psd);
					clickOnElement("Admin Login Page", "Login Button", loginButton);
					if (isElementPresent(dashboardIcon))
						stepResult = true;
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
			finally {
				if (stepResult==true){
					System.out.println("Pass");
					new HTMLReportHelper().HtmlReportBody("Login application", "Login successfully", "Passed", driver, "Y");
				}
				else{
					System.out.println("fail");
					new HTMLReportHelper().HtmlReportBody("Login application", "Could not login successfully", "Failed", driver, "Y");
					System.setProperty("runStep","N");
				}
			}
		}

	}

}
