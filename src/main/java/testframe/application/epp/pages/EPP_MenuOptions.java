package testframe.application.epp.pages;
/**
 * PageName : EPP_MenuOptions
 * 
 * @author Shilpa.Thangapalam
 */

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;

import testframe.application.common.CommonLibrary;
import testframe.common.reporting.HTMLReportHelper;

public class EPP_MenuOptions extends CommonLibrary{

	protected WebDriver driver;
	
	public EPP_MenuOptions(WebDriver driver) {
		super(driver);
		this.driver = driver;
		// TODO Auto-generated constructor stub
		PageFactory.initElements(new AjaxElementLocatorFactory(driver, 50), this);
	}
	public String eppMenuPage= "Epp_MenuPage";
	public String eppSubMenuPage = "EPP_SubMenuPage";
	
	By epp_label = By.xpath("//div[@class='customerLogoDiv']");
	By manualPayments = By.xpath("//div[@class='mainMenu']//h2[text()='Manual Payments']");
	
	
	public String menuOPtion = "//div[@class='mainMenu']//h2[text()='%s']";
	public String subMenuOption = "//a[@class='linkMenu'][text()='%s']";
	
	public void selectMenuOptions(String menuValue) {
	boolean stepResult = false;
	try {
		switchToWindowWithTitleContaining("Enterprise Payments Platform");
		driver.switchTo().frame("mainmenu");
		waitElement(3000);
		getDynamicElementClick(eppMenuPage, "Menu Selected", menuOPtion, menuValue);
		stepResult = true;
	} catch (Exception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	} finally {
		if (stepResult == true) {
			System.out.println("Pass");
			new HTMLReportHelper().HtmlReportBody("Click on '" + menuValue +"' menu", "Successfully clicked on '" + menuValue +"' menu", "Passed", driver, "Y");
		} else {
			System.out.println("fail");
			new HTMLReportHelper().HtmlReportBody("Click on '" + menuValue +"' menu", "Could not clicked on '" + menuValue +"' menu", "Failed", driver, "Y");
		}
	}
}
	
	public void selectSubMenuOptions(String subMenuValue) {
		boolean stepResult = false;
		try {
			getDynamicElementClick(eppSubMenuPage, "Sub Menu Selected", subMenuOption, subMenuValue);
			stepResult = true;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			if (stepResult == true) {
				System.out.println("Pass");
				new HTMLReportHelper().HtmlReportBody("Click on '" + subMenuValue +"' Submenu", "Successfully clicked on '" + subMenuValue +"' Submenu", "Passed", driver, "Y");
			} else {
				System.out.println("fail");
				new HTMLReportHelper().HtmlReportBody("Click on '" + subMenuValue +"' Submenu", "Could not clicked on '" + subMenuValue +"' Submenu", "Failed", driver, "Y");
			}
		}
	}
	
 }
