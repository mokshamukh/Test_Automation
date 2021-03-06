package testframe.application.epp.pages;
/**
 * PageName : EPP_DuplicatePayments
 * 
 * @author Shilpa.Thangapalam
 */

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;

import testframe.application.common.CommonLibrary;
import testframe.common.reporting.HTMLReportHelper;

public class EPP_DuplicatePayments extends CommonLibrary {

	public EPP_DuplicatePayments(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
		PageFactory.initElements(new AjaxElementLocatorFactory(driver, 50), this);
	}


	public String eppDuplicatePayments = "EPP_DuplicatePayments";

	//frame name = mainfooter
	By duplicateTransID = By.xpath("//form[@name='duplicateCheckForm']//a[@class='linkGeneral']");
	String dupTransID = "//form[@name='duplicateCheckForm']//a[contains(text(),'%s')]";
	By paymentTitle = By.xpath("//div[@id='headerBar']//td[contains(text(),'Payment Details')]");
	By transactionStatus = By.xpath("//div[@id='Refresh_PaymentDetailsHeader5']//td[contains(text(),'Duplicate Content')]");
	By selectCancelPaymentAction = By.xpath("//select[@id='ActionSelect'][contains(.,'')]");
	By selectReleasePayment = By.xpath("//select[@id='ActionSelect']//option[@value][contains(.,'Release From Duplicate Hold')]");
	By selectRepairPayment = By.xpath("//select[@id='ActionSelect']//option[@value][contains(.,'Repair Payment')]");
	By paymentActionButton = By.xpath("//select[@id='ActionSelect']");
	//select[@id='ActionSelect']//option[@value][contains(.,'Cancel Payment')]
	By executeButton = By.xpath("//div[@id='img_button_execute']");	


	public void selectCancelDuplicatePayment(String sTransID) throws Exception {
		if (System.getProperty("runStep")=="Y"){
			boolean stepResult = false;
			try {
				if(!sTransID.equals("")){
					waitForPresenceOfElement(eppDuplicatePayments, "Duplicate Transaction ID", getDynamicElement("Duplicate Transaction ID", dupTransID, sTransID));
					getDynamicElementClick(eppDuplicatePayments, "Duplicate Transaction ID", dupTransID, sTransID);
				}
				else{
					waitForPresenceOfElement(eppDuplicatePayments, "Duplicate Transaction ID", duplicateTransID);
					clickOnElement(eppDuplicatePayments, "Duplicate Transaction ID", duplicateTransID);
				}
				waitForPresenceOfElement(eppDuplicatePayments, "Duplicate Transaction ID", paymentTitle);
				if(isElementPresent(transactionStatus)) {
					driver.findElement(By.xpath("//select[@id='ActionSelect']//option[contains(.,'Cancel Payment')]")).click();
					//selectElementByVisibleText(eppDuplicatePayments, "Select Action on Duplicate Transaction ID", selectCancelPaymentAction, "Cancel Payment");
					waitElement(2000);
					clickOnElement(eppDuplicatePayments, "Execute Button", executeButton);
				}
				stepResult = true;
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} finally {
				if (stepResult == true) {
					System.out.println("Pass");
					new HTMLReportHelper().HtmlReportBody("Cancel Duplicate", "Cancel Payment Selected Successfully","Passed", driver, "Y");
				} else {
					System.out.println("fail");
					new HTMLReportHelper().HtmlReportBody("Cancel Duplicate","Could not Select Cancel Payment Successfully", "Failed", driver, "Y");
					System.setProperty("runStep","N");
				}
			}
		}
	}

	public void selectReleaseHoldPayment(String sTransID) throws Exception {
		if (System.getProperty("runStep")=="Y"){
			boolean stepResult = false;
			try {
				if(!sTransID.equals("")){
					waitForPresenceOfElement(eppDuplicatePayments, "Duplicate Transaction ID", getDynamicElement("Duplicate Transaction ID", dupTransID, sTransID));
					getDynamicElementClick(eppDuplicatePayments, "Duplicate Transaction ID", dupTransID, sTransID);
				}
				else{
					waitForPresenceOfElement(eppDuplicatePayments, "Duplicate Transaction ID", duplicateTransID);
					clickOnElement(eppDuplicatePayments, "Duplicate Transaction ID", duplicateTransID);
				}	
				waitForPresenceOfElement(eppDuplicatePayments, "Duplicate Transaction ID", paymentTitle);
				if(isElementPresent(transactionStatus)) {
					driver.findElement(By.xpath("//select[@id='ActionSelect']//option[contains(.,'Release From Duplicate Hold')]")).click();
					//selectElementByVisibleText(eppDuplicatePayments, "Select Action on Duplicate Transaction ID", selectReleasePayment, "Release From Duplicate Hold");
					waitElement(2000);
					clickOnElement(eppDuplicatePayments, "Execute Button", executeButton);
				}
				stepResult = true;
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} finally {
				if (stepResult == true) {
					System.out.println("Pass");
					new HTMLReportHelper().HtmlReportBody("Release from Hold", "Release From Duplicate Hold Selected Successfully","Passed", driver, "Y");
				} else {
					System.out.println("fail");
					new HTMLReportHelper().HtmlReportBody("Release from Hold","Could not Select Release From Duplicate Hold Successfully", "Failed", driver, "Y");
					System.setProperty("runStep","N");
				}
			}
		}
	}


	public void selectRepairPayment(String strTransIDVal) throws Exception {
		if (System.getProperty("runStep")=="Y"){
			boolean stepResult = false;
			try {
				if(!strTransIDVal.equals("")){

					waitForPresenceOfElement(eppDuplicatePayments, "Duplicate Transaction ID", getDynamicElement("Duplicate Transaction ID",dupTransID,strTransIDVal));
					clickOnElement(eppDuplicatePayments, "Duplicate Transaction ID", getDynamicElement("Duplicate Transaction ID",dupTransID,strTransIDVal));
				}else{
					waitForPresenceOfElement(eppDuplicatePayments, "Duplicate Transaction ID", duplicateTransID);
					clickOnElement(eppDuplicatePayments, "Duplicate Transaction ID", duplicateTransID);
				}
				waitForPresenceOfElement(eppDuplicatePayments, "Duplicate Transaction ID", paymentTitle);
				if(isElementPresent(transactionStatus)) {
					driver.findElement(By.xpath("//select[@id='ActionSelect']//option[contains(.,'Repair Payment')]")).click();
					//selectElementByVisibleText(eppDuplicatePayments, "Select Action on Duplicate Transaction ID", selectRepairPayment, "Repair Payment");
					clickOnElement(eppDuplicatePayments, "Execute Button", executeButton);
				}
				stepResult = true;
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} finally {
				if (stepResult == true) {
					System.out.println("Pass");
					new HTMLReportHelper().HtmlReportBody("Repair Payment", "Repair Payment Selected Successfully","Passed", driver, "Y");
				} else {
					System.out.println("fail");
					new HTMLReportHelper().HtmlReportBody("Repair Payment","Could not Select Repair Payment Successfully", "Failed", driver, "Y");
					System.setProperty("runStep","N");
				}
			}
		}
	}


}
