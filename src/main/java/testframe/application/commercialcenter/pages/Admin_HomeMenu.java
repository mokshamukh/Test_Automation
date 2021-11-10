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
	String menuBar = "//li/a/span[text()='%s']";
	String subMenuBar = "//li/a[text()='%s']";
	
	public Admin_HomeMenu(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public void clickOnMenuBar(String value){
		boolean stepResult = false;
		try {
			Thread.sleep(4000);
			if(isElementPresent(verifyAccInfoTitle)){
				getDynamicElementClick("Home Page", "Menu Bar" , menuBar, value);
				stepResult = true;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		if (stepResult==true){
			System.out.println("Pass");
			new HTMLReportHelper().HtmlReportBody("Click on '" + value +"' menu", "Successfully clicked on '" + value +"' menu", "Passed", driver, "Y");
		}
		else{
			System.out.println("fail");
			new HTMLReportHelper().HtmlReportBody("Click on '" + value +"' menu", "Could not clicked on '" + value +"' menu", "Failed", driver, "Y");
		}
	}
	
	public void clickOnSubMenuBar(String value){
		boolean stepResult = false;
		try {
			getDynamicElementClick("Home Page", "Sub Menu Bar", subMenuBar, value);
			stepResult = true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		finally {
			if (stepResult==true){
				System.out.println("Pass");
				new HTMLReportHelper().HtmlReportBody("Click on '" + value +"' sub-menu", "Successfully clicked on '" + value +"' sub-menu", "Passed", driver, "Y");
			}
			else{
				System.out.println("fail");
				new HTMLReportHelper().HtmlReportBody("Click on '" + value +"' sub-menu", "Could not clicked on '" + value +"' sub-menu", "Failed", driver, "Y");
			}
		}
	}
}
