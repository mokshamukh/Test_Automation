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
	By accountMenu = By.xpath("//a[@title='Accounts']");
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
	By transactionSearch = By.xpath("//span[text()='Transaction Search']");
	By balances = By.xpath("//span[text()='Balances']");


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
				new HTMLReportHelper().HtmlReportBody("click on menu CC- Corporate application",
						"click on menu Successfully", "Passed", driver, "Y");
			} else {
				System.out.println("fail");
				new HTMLReportHelper().HtmlReportBody("click on menu CC- Corporate application",
						"Could not click on menu Successfully", "Failed", driver, "Y");
			}
		}
	}*/

	public void clickOnPaymentMenu() throws Exception {
		if (System.getProperty("runStep")=="Y"){	
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
					new HTMLReportHelper().HtmlReportBody("Click on menu ","Clicked on menu successfully", "Passed", driver, "Y");
				} else {
					System.out.println("fail");
					new HTMLReportHelper().HtmlReportBody("Click on menu ","Could not click on menu successfully", "Failed", driver, "Y");
					System.setProperty("runStep","N");
				}
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
				new HTMLReportHelper().HtmlReportBody("click on menu CC- Corporate application",
						"click on sub menu Successfully", "Passed", driver, "Y");
			} else {
				System.out.println("fail");
				new HTMLReportHelper().HtmlReportBody("click on menu CC- Corporate application",
						"Could not click on sub menu Successfully", "Failed", driver, "Y");
			}
		}
	}*/

	public void clickOnAccountTransfer() throws Exception {
		if (System.getProperty("runStep")=="Y"){	
			boolean stepResult = false;
			try {
				clickOnElement("Home Page", "Accout Transfer", accountTransferField);
				stepResult = true;
			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				if (stepResult == true) {
					System.out.println("Pass - submenu bar");
					new HTMLReportHelper().HtmlReportBody("Click on menu","Clicked on account transfer successfully", "Passed", driver, "Y");
				} else {
					System.out.println("fail");
					new HTMLReportHelper().HtmlReportBody("Click on menu","Could not click on account transfer successfully", "Failed", driver, "Y");
					System.setProperty("runStep","N");
				}
			}
		}
	}

	public void clickOnPaymentActivity() throws Exception {
		if (System.getProperty("runStep")=="Y"){	
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
					new HTMLReportHelper().HtmlReportBody("Click on menu",
							"Click on payment activity successfully", "Passed", driver, "Y");
				} else {
					System.out.println("fail");
					new HTMLReportHelper().HtmlReportBody("Click on menu",
							"Could not click on payment activity successfully", "Failed", driver, "Y");
					System.setProperty("runStep","N");
				}
			}
		}
	}

	public void clickOnCurrentPaymentActivity() throws Exception {
		if (System.getProperty("runStep")=="Y"){	
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
					new HTMLReportHelper().HtmlReportBody("Click on menu",
							"Clicked on current payment activity successfully", "Passed", driver, "Y");
				} else {
					System.out.println("fail");
					new HTMLReportHelper().HtmlReportBody("Click on menu",
							"Could not click on current payment activity successfully", "Failed", driver, "Y");
					System.setProperty("runStep","N");
				}
			}
		}
	}

	public void clickOnfuturePaymentActivity() throws Exception {
		if (System.getProperty("runStep")=="Y"){	
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
					new HTMLReportHelper().HtmlReportBody("Click on menu",
							"Clicked on future payment activity successfully", "Passed", driver, "Y");
				} else {
					System.out.println("fail");
					new HTMLReportHelper().HtmlReportBody("Click on menu",
							"Could not click on future payment activity successfully", "Failed", driver, "Y");
					System.setProperty("runStep","N");
				}
			}
		}
	}


	public void clickOnAchPayments() throws Exception {
		if (System.getProperty("runStep")=="Y"){	
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
					new HTMLReportHelper().HtmlReportBody("Click on menu",
							"Clicked on ach payment successfully", "Passed", driver, "Y");
				} else {
					System.out.println("fail");
					new HTMLReportHelper().HtmlReportBody("Click on menu",
							"Could not click on ach payment successfully", "Failed", driver, "Y");
					System.setProperty("runStep","N");
				}
			}
		}
	}

	public void clickOnAchBacthTemplate() throws Exception {
		if (System.getProperty("runStep")=="Y"){	
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
					new HTMLReportHelper().HtmlReportBody("Click on menu",
							"Clicked on ach batch template successfully", "Passed", driver, "Y");
				} else {
					System.out.println("fail");
					new HTMLReportHelper().HtmlReportBody("Click on menu CC- Corporate application",
							"Could not click on ach batch template successfully", "Failed", driver, "Y");
					System.setProperty("runStep","N");
				}
			}
		}
	}

	public void clickOnNewAchBacth() throws Exception {
		if (System.getProperty("runStep")=="Y"){	
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
					new HTMLReportHelper().HtmlReportBody("Click on menu",
							"Clicked on new ach batch template successfully", "Passed", driver, "Y");
				} else {
					System.out.println("fail");
					new HTMLReportHelper().HtmlReportBody("Click on menu",
							"Could not click on new ach batch template successfully", "Failed", driver, "Y");
					System.setProperty("runStep","N");
				}
			}
		}
	}


	public void clickOnRecurringPaymentActivity() throws Exception {
		if (System.getProperty("runStep")=="Y"){	
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
					new HTMLReportHelper().HtmlReportBody("Click on menu",
							"Clicked on recurring payment activity successfully", "Passed", driver, "Y");
				} else {
					System.out.println("fail");
					new HTMLReportHelper().HtmlReportBody("Click on menu",
							"Could not click on recurring payment activity successfully", "Failed", driver, "Y");
					System.setProperty("runStep","N");
				}
			}
		}
	}

	public void clickOnWireTransfers() throws Exception {
		if (System.getProperty("runStep")=="Y"){	
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
					new HTMLReportHelper().HtmlReportBody("Click on menu",
							"Clicked on wire transfers successfully", "Passed", driver, "Y");
				} else {
					System.out.println("fail");
					new HTMLReportHelper().HtmlReportBody("Click on menu CC- Corporate application",
							"Could not click on wire transfers successfully", "Failed", driver, "Y");
					System.setProperty("runStep","N");
				}
			}
		}
	}


	public void clickOnNewWireTransfer() throws Exception {
		if (System.getProperty("runStep")=="Y"){	
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
					new HTMLReportHelper().HtmlReportBody("Click on menu",
							"Clicked on new wire transfer successfully", "Passed", driver, "Y");
				} else {
					System.out.println("fail");
					new HTMLReportHelper().HtmlReportBody("Click on menu",
							"Could not click on new wire transfer successfully", "Failed", driver, "Y");
					System.setProperty("runStep","N");
				}
			}
		}
	}


	public void clickOnManageWireTemplates() throws Exception {
		if (System.getProperty("runStep")=="Y"){	
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
					new HTMLReportHelper().HtmlReportBody("Click on menu",
							"Clicked on manage wire templates successfully", "Passed", driver, "Y");
				} else {
					System.out.println("fail");
					new HTMLReportHelper().HtmlReportBody("Click on menu",
							"Could not click on manage wire templates successfully", "Failed", driver, "Y");
					System.setProperty("runStep","N");
				}
			}
		}

	}


	public void clickOnPayees() throws Exception {
		if (System.getProperty("runStep")=="Y"){	
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
					new HTMLReportHelper().HtmlReportBody("Click on menu",
							"Clicked on payees successfully", "Passed", driver, "Y");
				} else {
					System.out.println("fail");
					new HTMLReportHelper().HtmlReportBody("Click on menu",
							"Could not click on payees successfully", "Failed", driver, "Y");
					System.setProperty("runStep","N");
				}
			}
		}
	}

	public void clickOnNewPayee() throws Exception {
		if (System.getProperty("runStep")=="Y"){	
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
					new HTMLReportHelper().HtmlReportBody("Click on menu",
							"Clicked on new payee successfully", "Passed", driver, "Y");
				} else {
					System.out.println("fail");
					new HTMLReportHelper().HtmlReportBody("Click on menu",
							"Could not click on new payee successfully", "Failed", driver, "Y");
					System.setProperty("runStep","N");
				}
			}
		}
	}


	public void clickOnManagePayees() throws Exception {
		if (System.getProperty("runStep")=="Y"){	
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
					new HTMLReportHelper().HtmlReportBody("Click on menu",
							"Clicked on manage payees successfully", "Passed", driver, "Y");
				} else {
					System.out.println("fail");
					new HTMLReportHelper().HtmlReportBody("Click on menu",
							"Could not click on manage payees successfully", "Failed", driver, "Y");
					System.setProperty("runStep","N");
				}
			}
		}
	}

	
	public void clickOnAccountsMenu() throws Exception {
		if (System.getProperty("runStep")=="Y"){	
			boolean stepResult = false;
			try {
				Thread.sleep(4000);
				clickOnElement("Corporate Home Page", "Menu Bar", homeMenuIcon);
				clickOnElement("Home Page", "Accounts", accountMenu);
				
				stepResult = true;
			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				if (stepResult == true) {
					System.out.println("Pass - submenu bar");
					new HTMLReportHelper().HtmlReportBody("Click on menu",
							"Clicked on acounts menu successfully", "Passed", driver, "Y");
				} else {
					System.out.println("fail");
					new HTMLReportHelper().HtmlReportBody("Click on menu",
							"Could not click on account menu successfully", "Failed", driver, "Y");
					System.setProperty("runStep","N");
				}
			}
		}
	}


	public void clickOnBalancesMenu() throws Exception {
		if (System.getProperty("runStep")=="Y"){	
			boolean stepResult = false;
			try {
				waitForPresenceOfElement("Home Page", "Balances", balances);
				clickOnElement("Home Page", "Balances", balances);
				waitElement(2000);
				stepResult = true;
			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				if (stepResult == true) {
					System.out.println("Pass - submenu bar");
					new HTMLReportHelper().HtmlReportBody("Click on menu",
							"Clicked on balance menu successfully", "Passed", driver, "Y");
				} else {
					System.out.println("fail");
					new HTMLReportHelper().HtmlReportBody("Click on menu",
							"Could not click on balance menu successfully", "Failed", driver, "Y");
					System.setProperty("runStep","N");
				}
			}
		}
	}

	
	public void clickOnTransactionSearchMenu() throws Exception {
		if (System.getProperty("runStep")=="Y"){	
			boolean stepResult = false;
			try {
				Thread.sleep(4000);
				clickOnElement("Home Page", "Transaction search", transactionSearch);
				
				stepResult = true;
			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				if (stepResult == true) {
					System.out.println("Pass - submenu bar");
					new HTMLReportHelper().HtmlReportBody("Click on menu",
							"Clicked on transaction search menu successfully", "Passed", driver, "Y");
				} else {
					System.out.println("fail");
					new HTMLReportHelper().HtmlReportBody("Click on menu",
							"Could not click on balance menu successfully", "Failed", driver, "Y");
					System.setProperty("runStep","N");
				}
			}
		}
	}
	
	
}
