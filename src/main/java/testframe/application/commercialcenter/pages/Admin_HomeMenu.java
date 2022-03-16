package testframe.application.commercialcenter.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import testframe.application.common.CommonLibrary;
import testframe.common.reporting.HTMLReportHelper;

/**
 * PageNage : CommercialCenter_Admin_HomeMenu
 * 
 * @author Ketki.Badalwar
 */

public class Admin_HomeMenu extends CommonLibrary{

	public String adminHomePage;
	By verifyAccInfoTitle = By.xpath("//span[text()='Account Information']");
	By administration = By.xpath("//li/a/span[text()='Administration']");
	By searchCompanies = By.xpath("//li/a[text()='Search Companies']");
	By searchUsers = By.xpath("//li/a[text()='Search Users']");
	String menuBar = "//li/a/span[text()='%s']";
	String subMenuBar = "//li/a[text()='%s']";

	public Admin_HomeMenu(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public void clickOnMenuBar() throws Exception{
		if (System.getProperty("runStep")=="Y"){	
			boolean stepResult = false;
			try {
				Thread.sleep(4000);
				if(isElementPresent(verifyAccInfoTitle)){
					//getDynamicElementClick("Home Page", "Menu Bar" , menuBar, value);
					clickOnElement("Home Page", "Menu Bar", administration);
					stepResult = true;
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
			if (stepResult==true){
				System.out.println("Pass");
				new HTMLReportHelper().HtmlReportBody("Click on menu", "Successfully clicked on administration menu", "Passed", driver, "Y");
			}
			else{
				System.out.println("fail");
				new HTMLReportHelper().HtmlReportBody("Click on menu", "Could not clicked on administration menu", "Failed", driver, "Y");
				System.setProperty("runStep","N");
			}
		}
	}

	public void clickOnSubMenuBar() throws Exception{
		if (System.getProperty("runStep")=="Y"){	
			boolean stepResult = false;
			try {
				//getDynamicElementClick("Home Page", "Sub Menu Bar", subMenuBar, value);
				clickOnElement("Home Page", "Sub Menu Bar", searchCompanies);
				stepResult = true;
			} catch (Exception e) {
				e.printStackTrace();
			}
			finally {
				if (stepResult==true){
					System.out.println("Pass");
					new HTMLReportHelper().HtmlReportBody("Click on sub-menu", "Successfully clicked on search companies sub-menu", "Passed", driver, "Y");
				}
				else{
					System.out.println("fail");
					new HTMLReportHelper().HtmlReportBody("Click on sub-menu", "Could not clicked on search companies sub-menu", "Failed", driver, "Y");
					System.setProperty("runStep","N");
				}
			}
		}
	}

	public void clickOnSearchUsers() throws Exception{
		if (System.getProperty("runStep")=="Y"){	
			boolean stepResult = false;
			try {
				//getDynamicElementClick("Home Page", "Sub Menu Bar", subMenuBar, value);
				clickOnElement("Home Page", "Sub Menu Bar", searchUsers);
				stepResult = true;
			} catch (Exception e) {
				e.printStackTrace();
			}
			finally {
				if (stepResult==true){
					System.out.println("Pass");
					new HTMLReportHelper().HtmlReportBody("Click on sub-menu", "Successfully clicked on search companies sub-menu", "Passed", driver, "Y");
				}
				else{
					System.out.println("fail");
					new HTMLReportHelper().HtmlReportBody("Click on sub-menu", "Could not clicked on search companies sub-menu", "Failed", driver, "Y");
					System.setProperty("runStep","N");
				}
			}
		}
	}
}
