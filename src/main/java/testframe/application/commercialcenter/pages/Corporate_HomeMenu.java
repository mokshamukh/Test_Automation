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
	By paymentMenu = By.xpath("//a[@title='Payments']");
	String subMenuBar = "//span[text()='%s']";
	By accountTransferField = By.xpath("//span[text()='Account Transfer']");
	By paymentActivityField = By.xpath("//span[text()='Payment Activity']");
	By currentPaymentActivityField = By.xpath("//span[text()='Current']");
	By futurePaymentActivityField = By.xpath("//span[text()='Future']");
	By repeatingPaymentActivity = By.xpath("//span[text()='Repeating']");
	By aCHPaymentsField = By.xpath("//span[text()='ACH Payments']");
	By wireTransfers = By.xpath("//span[text()='Wire Transfers']");
	By newWireTransfer = By.xpath("//span[text()='New Wire Transfer']");
	By manageWireTemplate = By.xpath("//span[text()='Manage Wire Templates']");
	By payees = By.xpath("//span[text()='Payees']");
	By newPayee = By.xpath("//span[text()='New Payee']");
	By managePayees = By.xpath("//span[text()='Manage Payees']");
	
	
	String subOpt = "//li/a[text()='%s']";
	By corpRepublicBankLogo = By.xpath("//img[@class='main-logo']");
	By newAchBatchTemplateField = By.xpath("//span[text()='New ACH Batch']");
	By aCHBatchTemplate = By.xpath("//span[text()='ACH Batch Templates']");

	public Corporate_HomeMenu(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

/*	public void clickOnMenu(String corpMenu) {
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
	}*/
	
	public void clickOnPaymentMenu() throws Exception {
		boolean stepResult = false;
		try {
			if (isElementPresent(corpRepublicBankLogo)) {
				clickOnElement("Corporate Home Page", "Menu Bar", homeMenuIcon);
				clickOnElement("Corporate Home Page", "Menu Bar", paymentMenu);
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

	/*public void clickOnSubMenuBar(String subMenuValue, String subOption) {
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
	}*/
	
	public void clickOnAccountTransfer() throws Exception {
		boolean stepResult = false;
		try {
			clickOnElement("Home Page", "Accout Transfer", accountTransferField);
			stepResult = true;
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (stepResult == true) {
				System.out.println("Pass - submenu bar");
				new HTMLReportHelper().HtmlReportBody("Home Menu CC- Corporate application",
						"click on account Transfer Successfully", "Passed", driver, "Y");
			} else {
				System.out.println("fail");
				new HTMLReportHelper().HtmlReportBody("Home Menu CC- Corporate application",
						"Could not click on account Transfer Successfully", "Failed", driver, "Y");
			}
		}
	}
	
	public void clickOnPaymentActivity() throws Exception {
		boolean stepResult = false;
		try {
			Thread.sleep(1000);
			clickOnElement("Home Page", "Payment Activity", paymentActivityField);
			stepResult = true;
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (stepResult == true) {
				System.out.println("Pass - submenu bar");
				new HTMLReportHelper().HtmlReportBody("Home Menu CC- Corporate application",
						"click on payment activity Successfully", "Passed", driver, "Y");
			} else {
				System.out.println("fail");
				new HTMLReportHelper().HtmlReportBody("Home Menu CC- Corporate application",
						"Could not click on payment activity Successfully", "Failed", driver, "Y");
			}
		}
	}

	public void clickOnCurrentPaymentActivity() throws Exception {
		boolean stepResult = false;
		try {
			Thread.sleep(4000);
			clickOnElement("Home Page", "Current Payment Activity", currentPaymentActivityField);
			stepResult = true;
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (stepResult == true) {
				System.out.println("Pass - submenu bar");
				new HTMLReportHelper().HtmlReportBody("Home Menu CC- Corporate application",
						"click on current payment activity Successfully", "Passed", driver, "Y");
			} else {
				System.out.println("fail");
				new HTMLReportHelper().HtmlReportBody("Home Menu CC- Corporate application",
						"Could not click on current payment activity Successfully", "Failed", driver, "Y");
			}
		}
	}

	public void clickOnfuturePaymentActivity() throws Exception {
		boolean stepResult = false;
		try {
			Thread.sleep(1000);
			clickOnElement("Home Page", "Future Payment Activity", futurePaymentActivityField);
			stepResult = true;
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (stepResult == true) {
				System.out.println("Pass - submenu bar");
				new HTMLReportHelper().HtmlReportBody("Home Menu CC- Corporate application",
						"click on future payment activity Successfully", "Passed", driver, "Y");
			} else {
				System.out.println("fail");
				new HTMLReportHelper().HtmlReportBody("Home Menu CC- Corporate application",
						"Could not click on future payment activity Successfully", "Failed", driver, "Y");
			}
		}
	}
	
	
	public void clickOnAchPayments() throws Exception {
		boolean stepResult = false;
		try {
			Thread.sleep(4000);
			clickOnElement("Home Page", "ACH Payments", aCHPaymentsField);
			stepResult = true;
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (stepResult == true) {
				System.out.println("Pass - submenu bar");
				new HTMLReportHelper().HtmlReportBody("Home Menu CC- Corporate application",
						"click on ach payment Successfully", "Passed", driver, "Y");
			} else {
				System.out.println("fail");
				new HTMLReportHelper().HtmlReportBody("Home Menu CC- Corporate application",
						"Could not click on ach payment Successfully", "Failed", driver, "Y");
			}
		}
	}
	
	public void clickOnAchBacthTemplate() throws Exception {
		boolean stepResult = false;
		try {
			Thread.sleep(4000);
			clickOnElement("Home Page", "ACH Batch Template", aCHBatchTemplate);
			stepResult = true;
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (stepResult == true) {
				System.out.println("Pass - submenu bar");
				new HTMLReportHelper().HtmlReportBody("Home Menu CC- Corporate application",
						"click on Ach batch template Successfully", "Passed", driver, "Y");
			} else {
				System.out.println("fail");
				new HTMLReportHelper().HtmlReportBody("Home Menu CC- Corporate application",
						"Could not click on Ach batch template Successfully", "Failed", driver, "Y");
			}
		}
	}
	
	public void clickOnNewAchBacth() throws Exception {
		boolean stepResult = false;
		try {
			Thread.sleep(4000);
			clickOnElement("Home Page", "New ACH Batch Template", newAchBatchTemplateField);
			stepResult = true;
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (stepResult == true) {
				System.out.println("Pass - submenu bar");
				new HTMLReportHelper().HtmlReportBody("Home Menu CC- Corporate application",
						"click on new ACH batch template Successfully", "Passed", driver, "Y");
			} else {
				System.out.println("fail");
				new HTMLReportHelper().HtmlReportBody("Home Menu CC- Corporate application",
						"Could not click on new ACH batch template Successfully", "Failed", driver, "Y");
			}
		}
	}
	
	
	public void clickOnRecurringPaymentActivity() throws Exception {
		boolean stepResult = false;
		try {
			Thread.sleep(4000);
			clickOnElement("Home Page", "Future Payment Activity", repeatingPaymentActivity);
			stepResult = true;
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (stepResult == true) {
				System.out.println("Pass - submenu bar");
				new HTMLReportHelper().HtmlReportBody("Home Menu CC- Corporate application",
						"click on Recurring payment activity Successfully", "Passed", driver, "Y");
			} else {
				System.out.println("fail");
				new HTMLReportHelper().HtmlReportBody("Home Menu CC- Corporate application",
						"Could not click on Recurring payment activity Successfully", "Failed", driver, "Y");
			}
		}
	}
	
	public void clickOnWireTransfers() throws Exception {
		boolean stepResult = false;
		try {
			Thread.sleep(4000);
			clickOnElement("Home Page", "Wire Transfers", wireTransfers);
			stepResult = true;
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (stepResult == true) {
				System.out.println("Pass - submenu bar");
				new HTMLReportHelper().HtmlReportBody("Home Menu CC- Corporate application",
						"click on Wire Transfers Successfully", "Passed", driver, "Y");
			} else {
				System.out.println("fail");
				new HTMLReportHelper().HtmlReportBody("Home Menu CC- Corporate application",
						"Could not click on Wire Transfers Successfully", "Failed", driver, "Y");
			}
		}
	}
	
	
	public void clickOnNewWireTransfer() throws Exception {
		boolean stepResult = false;
		try {
			Thread.sleep(4000);
			clickOnElement("Home Page", "New Wire Transfer", newWireTransfer);
			stepResult = true;
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (stepResult == true) {
				System.out.println("Pass - submenu bar");
				new HTMLReportHelper().HtmlReportBody("Home Menu CC- Corporate application",
						"click on New Wire Transfer Successfully", "Passed", driver, "Y");
			} else {
				System.out.println("fail");
				new HTMLReportHelper().HtmlReportBody("Home Menu CC- Corporate application",
						"Could not click on New Wire Transfer Successfully", "Failed", driver, "Y");
			}
		}
	}
	
	
	public void clickOnManageWireTemplates() throws Exception {
		boolean stepResult = false;
		try {
			Thread.sleep(4000);
			clickOnElement("Home Page", "Manage Wire Templates", manageWireTemplate);
			stepResult = true;
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (stepResult == true) {
				System.out.println("Pass - submenu bar");
				new HTMLReportHelper().HtmlReportBody("Home Menu CC- Corporate application",
						"click on Manage Wire Templates Successfully", "Passed", driver, "Y");
			} else {
				System.out.println("fail");
				new HTMLReportHelper().HtmlReportBody("Home Menu CC- Corporate application",
						"Could not click on Manage Wire Templates Successfully", "Failed", driver, "Y");
			}
		}
	
	}
		

	public void clickOnPayees() throws Exception {
		boolean stepResult = false;
		try {
			Thread.sleep(4000);
			clickOnElement("Home Page", "Payees", payees);
			stepResult = true;
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (stepResult == true) {
				System.out.println("Pass - submenu bar");
				new HTMLReportHelper().HtmlReportBody("Home Menu CC- Corporate application",
						"click on Payees Successfully", "Passed", driver, "Y");
			} else {
				System.out.println("fail");
				new HTMLReportHelper().HtmlReportBody("Home Menu CC- Corporate application",
						"Could not click on Payees Successfully", "Failed", driver, "Y");
			}
		}
	}
		
	public void clickOnNewPayee() throws Exception {
		boolean stepResult = false;
		try {
			Thread.sleep(4000);
			clickOnElement("Home Page", "New Payee", newPayee);
			stepResult = true;
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (stepResult == true) {
				System.out.println("Pass - submenu bar");
				new HTMLReportHelper().HtmlReportBody("Home Menu CC- Corporate application",
						"click on New Payee Successfully", "Passed", driver, "Y");
			} else {
				System.out.println("fail");
				new HTMLReportHelper().HtmlReportBody("Home Menu CC- Corporate application",
						"Could not click on New Payee Successfully", "Failed", driver, "Y");
			}
		}
	}
		
	
	public void clickOnManagePayees() throws Exception {
		boolean stepResult = false;
		try {
			Thread.sleep(4000);
			clickOnElement("Home Page", "Manage Payees", managePayees);
			stepResult = true;
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (stepResult == true) {
				System.out.println("Pass - submenu bar");
				new HTMLReportHelper().HtmlReportBody("Home Menu CC- Corporate application",
						"click on Manage Payees Successfully", "Passed", driver, "Y");
			} else {
				System.out.println("fail");
				new HTMLReportHelper().HtmlReportBody("Home Menu CC- Corporate application",
						"Could not click on Manage Payees Successfully", "Failed", driver, "Y");
			}
		}
	}
	
}
