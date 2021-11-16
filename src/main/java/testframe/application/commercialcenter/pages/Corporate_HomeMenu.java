package testframe.application.commercialcenter.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import testframe.application.common.CommonLibrary;
import testframe.common.reporting.HTMLReportHelper;

/**
 * PageNage : CommercialCenter_Corporate_HomeMenu
 * 
 * @author Ketki.Badalwar
 */

public class Corporate_HomeMenu extends CommonLibrary {

	By homeMenuIcon = By.xpath("//a[@title='Menu']");
	String menuOpt = "//a[@title='%s']";
	String subMenuBar = "//span[text()='%s']";
	String subOpt = "//li/a[text()='%s']";
	By corpRepublicBankLogo = By.xpath("//img[@class='main-logo']");

	public Corporate_HomeMenu(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public void clickOnMenu(String corpMenu) throws Exception {
		boolean stepResult = false;
		try {
			Thread.sleep(4000);
			if (isElementPresent(corpRepublicBankLogo)) {
				clickOnElement("Corporate Home Page", "Menu Bar", homeMenuIcon);
				getDynamicElementClick("Corporate Home Page", "Menu Bar", menuOpt, corpMenu);
				stepResult = true;
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (stepResult == true) {
				System.out.println("Pass - Menu");
				new HTMLReportHelper().HtmlReportBody("Home Menu CC- Corporate application",
						"click on menu Successfully", "Passed", driver, "Y");
			} else {
				System.out.println("fail");
				new HTMLReportHelper().HtmlReportBody("Home Menu CC- Corporate application",
						"Could not click on menu Successfully", "Failed", driver, "Y");
			}
		}
	}

	public void clickOnSubMenuBar(String subMenuValue, String subOption) throws Exception {
		boolean stepResult = false;
		try {
			Thread.sleep(4000);
			getDynamicElementClick("Home Page", "Sub Menu Bar", subMenuBar, subMenuValue);
			if (!subOption.equals("")) {
				getDynamicElementClick("Home Page", "Sub Menu Bar", subMenuBar, subOption);
				Thread.sleep(4000);
			}
			stepResult = true;
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (stepResult == true) {
				System.out.println("Pass - submenu bar");
				new HTMLReportHelper().HtmlReportBody("Home Menu CC- Corporate application",
						"click on sub menu Successfully", "Passed", driver, "Y");
			} else {
				System.out.println("fail");
				new HTMLReportHelper().HtmlReportBody("Home Menu CC- Corporate application",
						"Could not click on sub menu Successfully", "Failed", driver, "Y");
			}
		}
	}

}
