package testframe.application.epp.pages;
/**
 * PageName : EPP_PaymentDetails
 * 
 * @author Shilpa.Thangapalam
 */

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;

import testframe.application.common.CommonLibrary;
import testframe.common.reporting.HTMLReportHelper;

public class EPP_PaymentDetails extends CommonLibrary {

	EPP_CreatePayment eppCreatePayment;
	EPP_ActionPrompts eppActionPrompts;
	
	public EPP_PaymentDetails(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
		PageFactory.initElements(new AjaxElementLocatorFactory(driver, 50), this);
		eppCreatePayment = new EPP_CreatePayment(driver);
		eppActionPrompts = new EPP_ActionPrompts(driver);
	}
	
	public String eppPaymentDetails = "EPP_PaymentDetails";
	String approveTransID;
	String approveDuplicateTransID;
	String approveRepairTransID;
	String rejectRepairTransID;
	String approveRecallTransID;
	
	By paymentTitle = By.xpath("//div[@id='headerBar']//td[contains(text(),'Payment Details')]");
	By transactionStatus = By.xpath("//div[@id='Refresh_PaymentDetailsHeader5']//td[contains(text(),'Completed')]");
	By internalFilterTransStatus = By.xpath("//div[@id='Refresh_PaymentDetailsHeader5']//td[contains(text(),'Internal Filter')]");
	By businessFilterTransStatus = By.xpath("//div[@id='Refresh_PaymentDetailsHeader5']//td[contains(text(),'BusinessInterventionFilter')]");
	By bypassON = By.xpath("//div[@id='Refresh_UserResponse']//..//td[contains(text(),'Bypass Flag is currently ON')]");
    By transactionId = By.xpath("//div[@id='Refresh_PaymentDetailsHeader5']//td//span[contains(text(),'Transaction ID')]//..//..//td[@class='valueCell'][1]");
    By selectAmount = By.xpath("//select[@name='AmountCCY']");
    By refTransID = By.xpath("//div[@class='lightShadedBackground']//..//..//input[@name='ReferenceValue']");
    By displayMsg = By.xpath("//div[@id='Refresh_UserResponse']//..//div//p[contains(.,'Cancel requested while in Repair')]");
    By internalFilterDisplayMsg = By.xpath("//div[@id='Refresh_UserResponse']//..//div//p[contains(.,'This payment is stopped by the following Internal Filter')]");
    By dupTransStatus = By.xpath("//div[@id='Refresh_PaymentDetailsHeader5']//td[contains(text(),'Duplicate Content')]");
    By selectCancelPaymentAction = By.xpath("//select[@id='ActionSelect']//option[@value][contains(.,'Cancel Payment')]");// selectByValue(	//*[@value='CancelPayment'])
	By paymentActionButton = By.xpath("//select[@id='ActionSelect']");
	By executeButton = By.xpath("//div[@id='img_button_execute']");	
    By actionSuccessfull = By.xpath("//div[@id='Refresh_UserResponse']//td[@id='userResponseInfoTD']");
	By repairStatus = By.xpath("//div[@id='Refresh_PaymentDetailsHeader5']//td//span[contains(text(),'Status')]//..//..//td[contains(text(),'Repair')]");
	By approveRepairPayment = By.xpath("//select[@id='ActionSelect']//option[@value][contains(.,'Approve Payment Action')]");
	By rejectRepairPayment = By.xpath("//select[@id='ActionSelect']//option[@value][contains(.,'Reject Payment Action')]");
	By internalFilterStatus = By.xpath("//div[@id='Refresh_PaymentDetailsHeader5']//td//span[contains(text(),'Status')]//..//..//td[contains(text(),'Internal Filter')]");
	By businessFilterStage = By.xpath("//div[@id='Refresh_PaymentDetailsHeader5']//td//span[contains(text(),'Stage')]//..//..//td[contains(text(),'BusinessInterventionFilter')]");
	By transIdSaved = By.xpath("//div[@id='Refresh_UserResponse']//td[@id='userResponseInfoTD']//a[1]");
	By internalTransId =By.xpath("//div[@id='Refresh_AllInternalFilterPayments']//a[@class='linkGeneral']");
	By businessTransID = By.xpath("//div[@id='Refresh_OperatorNotification']//a[@class='linkGeneral']");
	By cancelDuplicateReqBanner = By.xpath("//div[contains(@id,'Refresh_PaymentDetails')]//p[contains(.,'Cancel requested while in Duplicate Content: (HV001) Amend Amount/Currency. testing')]");
	By stageDetails = By.xpath("//div[@id='Refresh_PaymentDetailsHeader5']//td//span[contains(text(),'Stage')]//..//..//td[contains(text(),'Complete')]");
	By cancelRepairBanner = By.xpath("//div[contains(@id,'Refresh_PaymentDetails')]//p[contains(.,'Cancel requested while in Repair')]");
	By cancelInternalFilterBanner = By.xpath("//div[contains(@id,'Refresh_PaymentDetails')]//p[contains(.,'Cancel requested while in Internal Filter')]");
	By paymentSentRepairBanner = By.xpath("//div[@id='Refresh_PaymentDetailsBanner']//p[contains(text(),'Payment sent to repair from Duplicate Content')]");
	By futureTransStatus = By.xpath("//div[@id='Refresh_PaymentDetailsHeader5']//td[contains(text(),'FutureWarehouse')]");
	By recallBannerMsg = By.xpath("//p[contains(text(),' This transaction has been submitted for approval following recalled  with Reason:')]");
	By recallTransStatus = By.xpath("//div[@id='Refresh_PaymentDetailsHeader5']//td[contains(text(),'Awaiting Approval')]");
	
	public void verifyCompletedPaymentTransaction() throws Exception {
		 boolean stepResult = false;
		try {
			waitElement(3000);
			if(isElementPresent(paymentTitle)) {
				validateTextContains(eppPaymentDetails,  "Transaction Status", transactionStatus, "Completed");
				validateElementPresent(eppPaymentDetails, "Transaction Status", transactionStatus);
				String transactionIDStatus = getElementText(eppPaymentDetails, "Transaction ID", transactionId);
				approveTransID = eppCreatePayment.getTransactionID();
				if(transactionIDStatus.equalsIgnoreCase(approveTransID)) {
					System.out.println("Pass");
					stepResult = true;
				}else {
					System.out.println("fail");
				}
			}
			scrollToElement(transactionStatus);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			if (stepResult == true) {
				System.out.println("Pass");
				new HTMLReportHelper().HtmlReportBody("Payment Details EPP - EPP application", "Transaction verified Successfully","Passed", driver, "Y");
			} else {
				System.out.println("fail");
				new HTMLReportHelper().HtmlReportBody("Payment Details EPP - EPP application","Could not verify Transaction Successfully", "Failed", driver, "Y");
			}
		}

		}
	
	public void submitActionOnTransactionWithApproval() throws Exception {
		 boolean stepResult = false;
			try {
				waitElement(3000);
				waitForPresenceOfElement(eppPaymentDetails, "Payment Title", paymentTitle);
				if(isElementPresent(displayMsg)) {
					validateElementPresent(eppPaymentDetails, "Transaction Status", dupTransStatus);
					validateTextContains(eppPaymentDetails,  "Transaction Status", dupTransStatus, "Duplicate Content");
					String duplicatetransID = getElementText(eppPaymentDetails, "Transaction ID", transactionId);
					approveDuplicateTransID = eppActionPrompts.getTransactionIDOnAction();
					if(duplicatetransID.equalsIgnoreCase(approveDuplicateTransID)) {
						System.out.println("Pass");
						stepResult = true;
					}else {
						System.out.println("fail");
					}
					driver.findElement(By.xpath("//select[@id='ActionSelect']//option[contains(.,'Approve Payment Action')]")).click();
					//selectElementByVisibleText(eppPaymentDetails, "Select Action on Duplicate Transaction ID", selectCancelPaymentAction, approvalAction);
				    waitElement(2000);
				    //ApprovePayment
				    clickOnElement(eppPaymentDetails, "Execute Button", executeButton);
				}
				validateElementPresent(eppPaymentDetails, "Action Successfull Message", actionSuccessfull);
				waitElement(2000);
				clickOnElement(eppPaymentDetails, "Action Successfull Message", actionSuccessfull);
				 waitElement(1000);
				if(isElementPresent(cancelDuplicateReqBanner)) {
					validateElementPresent(eppPaymentDetails, "Status Message", stageDetails);
				}
				stepResult = true;
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} finally {
				if (stepResult == true) {
					System.out.println("Pass");
					new HTMLReportHelper().HtmlReportBody("Payment Details EPP - EPP application", "Repair Transaction Status verified Successfully","Passed", driver, "Y");
				} else {
					System.out.println("fail");
					new HTMLReportHelper().HtmlReportBody("Payment Details EPP - EPP application","Could not verify Repair Transaction Status Successfully", "Failed", driver, "Y");
				}
			}
	}
	
	
	public void approveRepairPayment() throws Exception {
		 boolean stepResult = false;
			try {
				waitElement(3000);
				waitForPresenceOfElement(eppPaymentDetails, "Payment Title", paymentTitle);
				if(isElementPresent(displayMsg)) {
					validateElementPresent(eppPaymentDetails, "Transaction Status", repairStatus);
					String repairtransID = getElementText(eppPaymentDetails, "Transaction ID", transactionId);
					approveRepairTransID = eppActionPrompts.getTransactionIDOnAction();
					if(repairtransID.equalsIgnoreCase(approveRepairTransID)) {
						System.out.println("Pass");
						stepResult = true;
					}else {
						System.out.println("fail");
					}
					driver.findElement(By.xpath("//select[@id='ActionSelect']//option[contains(.,'Approve Payment Action')]")).click();
					//selectElementByVisibleText(eppPaymentDetails, "Select Action on Duplicate Transaction ID", approveRepairPayment, "Approve Payment Action");
				    clickOnElement(eppPaymentDetails, "Execute Button", executeButton);
				}
				validateElementPresent(eppPaymentDetails, "Action Successfull Message", actionSuccessfull);
				waitElement(2000);
				clickOnElement(eppPaymentDetails, "Clicked on Transaction ID", transIdSaved);
				waitElement(1000);
				if(isElementPresent(cancelRepairBanner)) {
				validateElementPresent(eppPaymentDetails, "Status Message", stageDetails);
				}
				stepResult = true;
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} finally {
				if (stepResult == true) {
					System.out.println("Pass");
					new HTMLReportHelper().HtmlReportBody("Payment Details EPP - EPP application", "Transaction verified Successfully","Passed", driver, "Y");
				} else {
					System.out.println("fail");
					new HTMLReportHelper().HtmlReportBody("Payment Details EPP - EPP application","Could not verify Transaction Successfully", "Failed", driver, "Y");
				}
			}
	}
	

	public void verifyFutureDatedPaymentTransaction() throws Exception {
		 boolean stepResult = false;
		try {
			waitElement(3000);
			waitForPresenceOfElement(eppPaymentDetails, "Payment Saved with Transaction", transIdSaved);
			clickOnElement(eppPaymentDetails, "Payment Saved with Transaction ID", transIdSaved);
			if(isElementPresent(paymentTitle)) {
				validateTextContains(eppPaymentDetails,  "Transaction Status", futureTransStatus, "FutureWarehouse");
				validateElementPresent(eppPaymentDetails, "Transaction Status", futureTransStatus);
				String transactionIDStatus = getElementText(eppPaymentDetails, "Transaction ID", transactionId);
				approveTransID = eppCreatePayment.getTransactionID();
				if(transactionIDStatus.equalsIgnoreCase(approveTransID)) {
					System.out.println("Pass");
					stepResult = true;
				}else {
					System.out.println("fail");
				}
			}
			stepResult = true;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			if (stepResult == true) {
				System.out.println("Pass");
				new HTMLReportHelper().HtmlReportBody("Payment Details EPP - EPP application", "Future Dated Transaction Status verified Successfully","Passed", driver, "Y");
			} else {
				System.out.println("fail");
				new HTMLReportHelper().HtmlReportBody("Payment Details EPP - EPP application","Could not verify Future Dated Transaction Status Successfully", "Failed", driver, "Y");
			}
		}

		}
	
	
	public void verifyRepairPaymentTransStatus() throws Exception {
		 boolean stepResult = false;
		try {
			waitElement(3000);
			waitForPresenceOfElement(eppPaymentDetails, "Payment Saved with Transaction", transIdSaved);
			clickOnElement(eppPaymentDetails, "Payment Saved with Transaction ID", transIdSaved);
			if(isElementPresent(paymentTitle)) {
				validateTextContains(eppPaymentDetails,  "Transaction Status", repairStatus, "Repair");
				validateElementPresent(eppPaymentDetails, "Transaction Status", repairStatus);
				String transactionIDStatus = getElementText(eppPaymentDetails, "Transaction ID", transactionId);
				approveTransID = eppCreatePayment.getTransactionID();
				if(transactionIDStatus.equalsIgnoreCase(approveTransID)) {
					System.out.println("Pass");
					stepResult = true;
				}else {
					System.out.println("fail");
				}
				stepResult = true;
			}
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			if (stepResult == true) {
				System.out.println("Pass");
				new HTMLReportHelper().HtmlReportBody("Payment Details EPP - EPP application", "Repair Transaction Status verified Successfully","Passed", driver, "Y");
			} else {
				System.out.println("fail");
				new HTMLReportHelper().HtmlReportBody("Payment Details EPP - EPP application","Could not verify Repair Transaction Status Successfully", "Failed", driver, "Y");
			}
		}

		}
	
	public void verifyInternalFilterPaymentTransStatus() throws Exception {
		 boolean stepResult = false;
		try {
			waitElement(3000);
			waitForPresenceOfElement(eppPaymentDetails, "Payment Saved with Transaction", transIdSaved);
			clickOnElement(eppPaymentDetails, "Payment Saved with Transaction ID", transIdSaved);
			if(isElementPresent(paymentTitle)) {
				validateTextContains(eppPaymentDetails,  "Transaction Status", internalFilterStatus, "Internal Filter");
				validateElementPresent(eppPaymentDetails, "Transaction Status", internalFilterStatus);
				String transactionIDStatus = getElementText(eppPaymentDetails, "Transaction ID", transactionId);
				approveTransID = eppCreatePayment.getTransactionID();
				if(transactionIDStatus.equalsIgnoreCase(approveTransID)) {
					System.out.println("Pass");
					stepResult = true;
				}else {
					System.out.println("fail");
				}
				stepResult = true;
			}
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			if (stepResult == true) {
				System.out.println("Pass");
				new HTMLReportHelper().HtmlReportBody("Payment Details EPP - EPP application", "Internal Filter Transaction Status verified Successfully","Passed", driver, "Y");
			} else {
				System.out.println("fail");
				new HTMLReportHelper().HtmlReportBody("Payment Details EPP - EPP application","Could not verify Internal Filter Transaction Status Successfully", "Failed", driver, "Y");
			}
		 }

	}
	
	 public void selectReleaseFromInternalFilterPayment() throws Exception {
	    	boolean stepResult = false;
	    	try {
				waitForPresenceOfElement(eppPaymentDetails, "Internal Filter Transaction ID", internalTransId);
				clickOnElement(eppPaymentDetails, "Internal Filter Transaction ID", internalTransId);
				waitForPresenceOfElement(eppPaymentDetails, "Internal Filter Transaction ID", paymentTitle);
				if(isElementPresent(internalFilterTransStatus)) {
					driver.findElement(By.xpath("//select[@id='ActionSelect']//option[contains(.,'Release From Internal Filter')]")).click();
				    waitElement(2000);
				    clickOnElement(eppPaymentDetails, "Execute Button", executeButton);
				}
				stepResult = true;
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} finally {
				if (stepResult == true) {
					System.out.println("Pass");
				    new HTMLReportHelper().HtmlReportBody("Release From Internal Filter  - EPP application", "Release From  Internal Filter Selected Successfully","Passed", driver, "Y");
				} else {
					System.out.println("fail");
					new HTMLReportHelper().HtmlReportBody("Release From Internal Filter - EPP application","Could not Select Release From Internal Filter Successfully", "Failed", driver, "Y");
				}
			}
	}
	 
	 public void selectCancelPaymentForInternalFilter() throws Exception {
	    	boolean stepResult = false;
	    	try {
				waitForPresenceOfElement(eppPaymentDetails, "Internal Filter Transaction ID", internalTransId);
				clickOnElement(eppPaymentDetails, "Internal Filter Transaction ID", internalTransId);
				waitForPresenceOfElement(eppPaymentDetails, "Internal Filter Transaction ID", paymentTitle);
				if(isElementPresent(internalFilterTransStatus)) {
					driver.findElement(By.xpath("//select[@id='ActionSelect']//option[contains(.,'Cancel Payment')]")).click();
				    waitElement(2000);
				    clickOnElement(eppPaymentDetails, "Execute Button", executeButton);
				}
				stepResult = true;
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} finally {
				if (stepResult == true) {
					System.out.println("Pass");
				    new HTMLReportHelper().HtmlReportBody("Release From Internal Filter  - EPP application", "Cancel Payment for Internal Filter Selected Successfully","Passed", driver, "Y");
				} else {
					System.out.println("fail");
					new HTMLReportHelper().HtmlReportBody("Release From Internal Filter - EPP application","Could not Select Cancel Payment for Internal Filter Successfully", "Failed", driver, "Y");
				}
			}
	}
	 
	 public void approveInternalFilterPayment() throws Exception {
		 boolean stepResult = false;
			try {
				waitElement(3000);
				waitForPresenceOfElement(eppPaymentDetails, "Payment Title", internalFilterStatus);
				if(isElementPresent(internalFilterDisplayMsg)) {
					validateElementPresent(eppPaymentDetails, "Internal Filter Transaction Status", internalFilterStatus);
					String repairtransID = getElementText(eppPaymentDetails, "Transaction ID", transactionId);
					approveRepairTransID = eppActionPrompts.getTransactionIDOnAction();
					if(repairtransID.equalsIgnoreCase(approveRepairTransID)) {
						System.out.println("Pass");
						stepResult = true;
					}else {
						System.out.println("fail");
					}
					driver.findElement(By.xpath("//select[@id='ActionSelect']//option[contains(.,'Approve Payment Action')]")).click();
					//selectElementByVisibleText(eppPaymentDetails, "Select Action on Duplicate Transaction ID", approveRepairPayment, "Approve Payment Action");
				    clickOnElement(eppPaymentDetails, "Execute Button", executeButton);
				}
				validateElementPresent(eppPaymentDetails, "Action Successfull Message", actionSuccessfull);
				waitElement(2000);
				clickOnElement(eppPaymentDetails, "Clicked on Transaction ID", transIdSaved);
				waitElement(1000);
				if(isElementPresent(cancelInternalFilterBanner)) {
				validateElementPresent(eppPaymentDetails, "Status Message", stageDetails);
				}
				stepResult = true;
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} finally {
				if (stepResult == true) {
					System.out.println("Pass");
					new HTMLReportHelper().HtmlReportBody("Payment Details EPP - EPP application", "Transaction verified Successfully","Passed", driver, "Y");
				} else {
					System.out.println("fail");
					new HTMLReportHelper().HtmlReportBody("Payment Details EPP - EPP application","Could not verify Transaction Successfully", "Failed", driver, "Y");
				}
			}
	}
	 
	 public void selectReleaseFromBusinessFilterPayment() throws Exception {
	    	boolean stepResult = false;
	    	try {
				waitForPresenceOfElement(eppPaymentDetails, "Business Filter Transaction ID", businessTransID);
				clickOnElement(eppPaymentDetails, "Business Filter Transaction ID", businessTransID);
				waitForPresenceOfElement(eppPaymentDetails, "Business Filter Transaction ID", paymentTitle);
				if(isElementPresent(businessFilterTransStatus)) {
					driver.findElement(By.xpath("//select[@id='ActionSelect']//option[contains(.,'Release From Business Intervention')]")).click();
				    waitElement(2000);
				    clickOnElement(eppPaymentDetails, "Execute Button", executeButton);
				}
				stepResult = true;
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} finally {
				if (stepResult == true) {
					System.out.println("Pass");
				    new HTMLReportHelper().HtmlReportBody("Release From Business Intervention Filter  - EPP application", "Release From  Business Intervention Filter Selected Successfully","Passed", driver, "Y");
				} else {
					System.out.println("fail");
					new HTMLReportHelper().HtmlReportBody("Release From Business Intervention Filter - EPP application","Could not Select Release From Business Intervention Filter Successfully", "Failed", driver, "Y");
				}
			}
	}
	 
	 public void verifyBusinessFilterPaymentTransStatus() throws Exception {
		 boolean stepResult = false;
		try {
			waitElement(3000);
			waitForPresenceOfElement(eppPaymentDetails, "Payment Saved with Transaction", transIdSaved);
			clickOnElement(eppPaymentDetails, "Payment Saved with Transaction ID", transIdSaved);
			if(isElementPresent(paymentTitle)) {
				validateTextContains(eppPaymentDetails,  "Transaction Status", businessFilterStage, "BusinessInterventionFilter");
				validateElementPresent(eppPaymentDetails, "Transaction Status", businessFilterStage);
				String transactionIDStatus = getElementText(eppPaymentDetails, "Transaction ID", transactionId);
				approveTransID = eppCreatePayment.getTransactionID();
				if(transactionIDStatus.equalsIgnoreCase(approveTransID)) {
					System.out.println("Pass");
					stepResult = true;
				}else {
					System.out.println("fail");
				}
				stepResult = true;
			}
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			if (stepResult == true) {
				System.out.println("Pass");
				new HTMLReportHelper().HtmlReportBody("Payment Details EPP - EPP application", "Business Filter Transaction Status verified Successfully","Passed", driver, "Y");
			} else {
				System.out.println("fail");
				new HTMLReportHelper().HtmlReportBody("Payment Details EPP - EPP application","Could not verify Business Filter Transaction Status Successfully", "Failed", driver, "Y");
			}
		 }

	}

	 
	 public void selectRecallPayment() throws Exception {
		 boolean stepResult = false;
		try {
			if(isElementPresent(paymentTitle)) {
			validateTextContains(eppPaymentDetails,  "Transaction Status", transactionStatus, "Completed");
			driver.findElement(By.xpath("//select[@id='ActionSelect']//option[contains(.,'Recall Payment')]")).click();
			clickOnElement(eppPaymentDetails, "Execute Button", executeButton);
			stepResult = true;
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			if (stepResult == true) {
				System.out.println("Pass");
				new HTMLReportHelper().HtmlReportBody("Payment Details EPP - EPP application", "Recall Payment Transaction is selected Successfully","Passed", driver, "Y");
			} else {
				System.out.println("fail");
				new HTMLReportHelper().HtmlReportBody("Payment Details EPP - EPP application","Could not select Recall Payment Transaction Successfully", "Failed", driver, "Y");
			}
		 }

	}
	 
	 
	 public void approveRecallPaymentTransaction() throws Exception {
		 boolean stepResult = false;
			try {
				waitElement(3000);
				waitForPresenceOfElement(eppPaymentDetails, "Payment Title", paymentTitle);
				if(isElementPresent(recallBannerMsg)) {
					validateElementPresent(eppPaymentDetails, "Recall Transaction Status", recallTransStatus);
					String recalltransID = getElementText(eppPaymentDetails, "Transaction ID", transactionId);
					approveRecallTransID = eppActionPrompts.getTransactionIDOnAction();
					if(recalltransID.equalsIgnoreCase(approveRecallTransID)) {
						System.out.println("Pass");
						stepResult = true;
					}else {
						System.out.println("fail");
					}
					driver.findElement(By.xpath("//select[@id='ActionSelect']//option[contains(.,'Approve Payment Action')]")).click();
				    clickOnElement(eppPaymentDetails, "Execute Button", executeButton);
				}
				validateElementPresent(eppPaymentDetails, "Action Successfull Message", actionSuccessfull);
				waitElement(2000);
				clickOnElement(eppPaymentDetails, "Clicked on Transaction ID", transIdSaved);
				waitElement(3000);
				if(isElementPresent(paymentTitle)) {
				validateElementPresent(eppPaymentDetails, "Transaction Status Message", transactionStatus);
				}
				stepResult = true;
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} finally {
				if (stepResult == true) {
					System.out.println("Pass");
					new HTMLReportHelper().HtmlReportBody("Payment Details EPP - EPP application", "Completed Transaction Status verified Successfully","Passed", driver, "Y");
				} else {
					System.out.println("fail");
					new HTMLReportHelper().HtmlReportBody("Payment Details EPP - EPP application","Could not verify Transaction Status Successfully", "Failed", driver, "Y");
				}
			}
	}
	 
		}
	

