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
	By paymentTracking = By.xpath("//div[@class='mainMenu']//h2[text()='Payment Tracking']");
	By paymentCreation = By.xpath("//a[@class='linkMenu'][text()='Payment Creation']");
	By transactionInquiry = By.xpath("//a[@class='linkMenu'][text()='Transaction Inquiry']");
	By workSummary = By.xpath("//a[@class='linkMenu'][text()='Work Summary']");
	By paymentTemplates = By.xpath("//div[@id='headerBar']//table//td[contains(text(),'Payment Templates')]");
	By transInquiryHeader = By.xpath("//div[@id='headerBar']//table//td[contains(text(),'Transaction Inquiry')]");
	By workSummaryHeader = By.xpath("//div[@id='headerBar']//table//td[contains(text(),'Work Summary')]");



	public String menuOPtion = "//div[@class='mainMenu']//h2[text()='%s']";
	public String subMenuOption = "//a[@class='linkMenu'][text()='%s']";

	public void selectMenuOptions(String menuValue) throws Exception {
		if (System.getProperty("runStep")=="Y"){
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
					new HTMLReportHelper().HtmlReportBody("Click on '" + menuValue +"' menu", "Successfully clicked on '" + menuValue +"' menu", "Passed", driver, "N");
				} else {
					System.out.println("fail");
					new HTMLReportHelper().HtmlReportBody("Click on '" + menuValue +"' menu", "Could not clicked on '" + menuValue +"' menu", "Failed", driver, "N");
					System.setProperty("runStep","N");
				}
			}
		}
	}

	public void selectSubMenuOptions(String subMenuValue) throws Exception {
		if (System.getProperty("runStep")=="Y"){
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
					System.setProperty("runStep","N");
				}
			}
		}
	}

	public void selectManualPaymentOptions() throws Exception {
		if (System.getProperty("runStep")=="Y"){
			boolean stepResult = false;
			try {
				switchToWindowWithTitleContaining("Enterprise Payments Platform");
				driver.switchTo().frame("mainmenu");
				waitElement(3000);
				clickOnElement(eppMenuPage, "Manual Payment Menu Selected", manualPayments);
				stepResult = true;
			} catch (Exception e) {
				// TODO Auto-generated catch block   
				e.printStackTrace();
			} finally {
				if (stepResult == true) {
					System.out.println("Pass");
					new HTMLReportHelper().HtmlReportBody("Click on Manual Payments menu", "Successfully clicked on Manual Payments menu", "Passed", driver, "Y");
				} else {
					System.out.println("fail");
					new HTMLReportHelper().HtmlReportBody("Click on Manual Payments menu", "Could not clicked on Manual Payments menu", "Failed", driver, "N");
					System.setProperty("runStep","N");
				}
			}
		}
	}

	public void selectPaymentTrackingOptions() throws Exception {
		if (System.getProperty("runStep")=="Y"){
			boolean stepResult = false;
			try {
				switchToWindowWithTitleContaining("Enterprise Payments Platform");
				driver.switchTo().frame("mainmenu");
				waitElement(3000);
				clickOnElement(eppMenuPage, "Payment Tracking Menu Selected", paymentTracking);
				stepResult = true;
			} catch (Exception e) {
				// TODO Auto-generated catch block   
				e.printStackTrace();
			} finally {
				if (stepResult == true) {
					System.out.println("Pass");
					new HTMLReportHelper().HtmlReportBody("Payment Tracking menu", "Successfully clicked on Payment Tracking menu", "Passed", driver, "N");
				} else {
					System.out.println("fail");
					new HTMLReportHelper().HtmlReportBody("Payment Tracking menu", "Could not clicked on Payment Tracking menu", "Failed", driver, "N");
					System.setProperty("runStep","N");
				}
			}
		}
	}

	public void selectPaymentCreationSubMenu() throws Exception {
		if (System.getProperty("runStep")=="Y"){
			boolean stepResult = false;
			try {
				waitForPresenceOfElement(eppSubMenuPage, "Payment Creation Sub Menu", paymentCreation);
				clickOnElement(eppSubMenuPage, "Payment Creation Sub Menu Selected", paymentCreation);
				switchToWindowWithTitleContaining("Enterprise Payments Platform");
				driver.switchTo().frame("main");
				waitForPresenceOfElement(eppSubMenuPage, "Payment Template", paymentTemplates);
				stepResult = true;
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} finally {
				if (stepResult == true) {
					System.out.println("Pass");
					new HTMLReportHelper().HtmlReportBody("Click on Payment Creation sub menu" , "Successfully clicked on Payment Creation Sub-menu", "Passed", driver, "Y");
				} else {
					System.out.println("fail");
					new HTMLReportHelper().HtmlReportBody("Click on Payment Creation sub menu", "Could not clicked on Payment Creation Sub-menu", "Failed", driver, "Y");
					System.setProperty("runStep","N");
				}
			}
		}
	}

	public void selectTransactionInquirySubMenu() throws Exception {
		if (System.getProperty("runStep")=="Y"){
			boolean stepResult = false;
			try {
				waitElement(7000);
				clickOnElement(eppSubMenuPage, "Transaction Inquiry Sub Menu Selected", transactionInquiry);
				waitElement(5000);
				switchToWindowWithTitleContaining("Enterprise Payments Platform");
				driver.switchTo().frame("main");
				waitElement(7000);
				waitForPresenceOfElement(eppSubMenuPage, "Payment Template", transInquiryHeader);
				stepResult = true;
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} finally {
				if (stepResult == true) {
					System.out.println("Pass");
					new HTMLReportHelper().HtmlReportBody("Transaction Inquiry sub-menu" , "Successfully clicked on Transaction Inquiry Sub-menu", "Passed", driver, "Y");
				} else {
					System.out.println("fail");
					new HTMLReportHelper().HtmlReportBody("Transaction Inquiry sub-menu", "Could not clicked on Transaction Inquiry Sub-menu", "Failed", driver, "Y");
					System.setProperty("runStep","N");
				}
			}
		}
	}

	public void selectWorkSummarySubMenu() throws Exception {
		if (System.getProperty("runStep")=="Y"){
			boolean stepResult = false;
			try {
				clickOnElement(eppSubMenuPage, "Work Summary Sub Menu Selected", workSummary);
				switchToWindowWithTitleContaining("Enterprise Payments Platform");
				driver.switchTo().frame("main");
				waitForPresenceOfElement(eppSubMenuPage, "Payment Tracking", workSummaryHeader);
				stepResult = true;
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} finally {
				if (stepResult == true) {
					System.out.println("Pass");
					new HTMLReportHelper().HtmlReportBody("Click on Work Summary subMenuValue" , "Successfully clicked on Work Summary Submenu", "Passed", driver, "Y");
				} else {
					System.out.println("fail");
					new HTMLReportHelper().HtmlReportBody("Click on Work Summary subMenuValue", "Could not clicked on Work Summary Submenu", "Failed", driver, "Y");
					System.setProperty("runStep","N");
				}
			}
		}
	}
}
