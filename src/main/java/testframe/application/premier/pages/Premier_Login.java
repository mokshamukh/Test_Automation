package testframe.application.premier.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import testframe.application.common.CommonLibrary;
import testframe.common.reporting.HTMLReportHelper;
import testframe.common.utilities.PropertyReader;

/**
 * 
 * 
 * @author Ketki.Badalwar
 */

public class Premier_Login extends CommonLibrary {

	public String adminLoginPage;

	public By group = By.xpath("//select[@id='Group']");
	public By myGroupPageHeader = By.xpath("//h2[text()='My Groups']");
	public By submitButton = By.xpath("//input[@name='Submit']");
	public By userID = By.xpath("//input[@id='PrincipalID']");
	public By password = By.xpath("//input[@id='PrincipalPWD']");
	public By institution = By.xpath("//input[@id='OrgID']");
	public By loginButton = By.xpath("//input[@id='submitButton']");
	public By loginPageHeader =  By.xpath("//h2[text()='Log In']"); 
	public By homePageHeader =  By.xpath("//div[text()='Home Page']");

	String pageMenuOptions = "//li/a/span[text()='%s']";

	public Premier_Login(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public void launchApplication(String url) throws Exception{
		if (System.getProperty("runStep")=="Y"){
			boolean stepResult = false;
			try {
				goTo(url);
				if (isElementPresent(loginPageHeader) || isElementPresent(myGroupPageHeader))
					stepResult = true;
			}catch (Exception e) {
				e.printStackTrace();
			}
			finally {
				if (stepResult==true){
					System.out.println("Pass");
					new HTMLReportHelper().HtmlReportBody("Launch Premier application", "Launch Successfully", "Passed", driver, "Y");
				}
				else{
					System.out.println("fail");
					new HTMLReportHelper().HtmlReportBody("Launch Premier application", "Could not Launch Successfully", "Failed", driver, "Y");
					System.setProperty("runStep","N");
				}
			}
		}

	}

	public void selectGroup(String sGroup, String sEnvironment) throws Exception{
		if (System.getProperty("runStep")=="Y"){
			if (sEnvironment.equals("cert")) {
				boolean stepResult = false;
				try {
					selectElementByVisibleText("Group Page","Select Group",group,sGroup);
					clickOnElement("Group Page", "Submit Button", submitButton);
					stepResult = true;
				}catch (Exception e) {
					e.printStackTrace();
				}
				finally {
					if (stepResult==true){
						System.out.println("Pass");
						new HTMLReportHelper().HtmlReportBody("Select Group", "Group selected successfully", "Passed", driver, "Y");
					}
					else{
						System.out.println("fail");
						new HTMLReportHelper().HtmlReportBody("Select Group", "Could not select the group", "Failed", driver, "Y");
						System.setProperty("runStep","N");
					}
				}
			}
		}
	}

	public void logInToApplication( String sUserID, String psd,String sInstitution) throws Exception {
		if (System.getProperty("runStep")=="Y"){
			boolean stepResult = false;
			try {

				if (isElementPresent(loginPageHeader)){
					enterText("Login Page", "User", userID, sUserID);
					enterText("Login Page", "Password", password, psd);
					clearAndType("Login Page", "Institution", institution, sInstitution);
					clickOnElement("Login Page", "Submit Button", loginButton);
					stepResult=true;	
				}

			} catch (Exception e) {
				e.printStackTrace();
			}
			finally {
				if (stepResult==true){
					System.out.println("Pass");
					new HTMLReportHelper().HtmlReportBody("Login Premier application", "Login Successfully", "Passed", driver, "Y");
				}
				else{
					System.out.println("fail");
					new HTMLReportHelper().HtmlReportBody("Login Premier application", "Could not Login Successfully", "Failed", driver, "Y");
					System.setProperty("runStep","N");
				}
			}
		}
	}

}
