package testframe.application.epp.pages;
/**
 * PageName : EPP_Templates
 * 
 * @author Shilpa.Thangapalam
 */

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;

import testframe.application.common.CommonLibrary;
import testframe.common.reporting.HTMLReportHelper;

public class EPP_Templates extends CommonLibrary{

	public EPP_Templates(WebDriver driver) {
		super(driver);
		PageFactory.initElements(new AjaxElementLocatorFactory(driver, 50), this);
	}
	
	public String eppPoolOptions = "EPP_Templates";
	public String poolTemplateOptions = "//a[text()='%s']";
	public String blockName = "//div[@id='headerBar']//table//td[contains(text(),'%s')]";
	
	
	 By manualPayment = By.xpath("//h2[text()='Manual Payments']");
	 By paymentTemplate = By.xpath("//div[@id='headerBar']//table//td[contains(text(),'Payment Template')]");
	 By workSummary = By.xpath("//div[@id='headerBar']//table//td[contains(text(),'Work Summary')]");
	 By outgoingFRB = By.xpath("//a[text()='Outgoing High Value Bank Payment (FRB)']");
	 By paymentCreationVerificationOption = By.xpath("//a[text()='Payment Creation Verification']");
	 By paymentRepair = By.xpath("//a[text()='Payment Repair']");
	 By paymentRepairVerification = By.xpath("//a[text()='Payment Repair Verification']");
	
	
	
	public void selectTemplate(String blockHeaderName,String poolValue) throws Exception {
		boolean stepResult = false;
		try {
			switchToWindowWithTitleContaining("Enterprise Payments Platform");
			driver.switchTo().frame("main");
			getDynamicElement("Template",blockName,blockHeaderName); 
			waitForPresenceOfElement(eppPoolOptions, "Template", getDynamicElement("Template",poolTemplateOptions, poolValue));
			getDynamicElementClick(eppPoolOptions, "Template", poolTemplateOptions, poolValue);
			stepResult = true;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			if (stepResult == true) {
				System.out.println("Pass");
				new HTMLReportHelper().HtmlReportBody("Template option '" + poolValue +"' template", "Successfully clicked on '" + poolValue +"' template", "Passed", driver, "Y");
			} else {
				System.out.println("fail");
				new HTMLReportHelper().HtmlReportBody("Template option '" + poolValue +"' template", "Could not clicked on '" + poolValue +"' template", "Failed", driver, "Y");
			}
		}
	}

	public void verifyPaymentCreationPool() throws Exception {
		boolean stepResult = false;
		try {
			switchToWindowWithTitleContaining("Enterprise Payments Platform");
			driver.switchTo().frame("main");
			isElementPresent(paymentTemplate);
			stepResult = true;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			if (stepResult == true) {
				System.out.println("Pass");
				new HTMLReportHelper().HtmlReportBody("Pool option Payment Creation template", "Successfully clicked on Payment Creation template", "Passed", driver, "Y");
			} else {
				System.out.println("fail");
				new HTMLReportHelper().HtmlReportBody("Pool option Payment Creation template", "Could not clicked on Payment Creation template", "Failed", driver, "Y");
			}
		}
	}
	
	public void verifyWorkSummaryPool() throws Exception {
		boolean stepResult = false;
		try {
			switchToWindowWithTitleContaining("Enterprise Payments Platform");
			driver.switchTo().frame("main");
			isElementPresent(workSummary);
			stepResult = true;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			if (stepResult == true) {
				System.out.println("Pass");
				new HTMLReportHelper().HtmlReportBody("Pool option Work Summary template", "Successfully clicked on Work Summary template", "Passed", driver, "Y");
			} else {
				System.out.println("fail");
				new HTMLReportHelper().HtmlReportBody("Pool option Work Summary template", "Could not clicked on Work Summary template", "Failed", driver, "Y");
			}
		}
	}
	
	public void selectOutgoingHVBankPaymentFRBOption() throws Exception {
		boolean stepResult = false;
		try {
			waitForPresenceOfElement(eppPoolOptions, "Pool Value", outgoingFRB);
			clickOnElement(eppPoolOptions, "Pool Value", outgoingFRB);
			stepResult = true;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			if (stepResult == true) {
				System.out.println("Pass");
				new HTMLReportHelper().HtmlReportBody("Pool option Outgoing High Value Bank Payment (FRB) template", "Successfully clicked on Outgoing High Value Bank Payment (FRB) template", "Passed", driver, "Y");
			} else {
				System.out.println("fail");
				new HTMLReportHelper().HtmlReportBody("Pool option Outgoing High Value Bank Payment (FRB) template", "Could not clicked on Outgoing High Value Bank Payment (FRB) template", "Failed", driver, "Y");
			}
		}
	}
	
	public void selectPaymentCreationVerificationOption() throws Exception {
		boolean stepResult = false;
		try {
			waitForPresenceOfElement(eppPoolOptions, "Pool Value", paymentCreationVerificationOption);
			clickOnElement(eppPoolOptions, "Pool Value", paymentCreationVerificationOption);
			stepResult = true;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			if (stepResult == true) {
				System.out.println("Pass");
				new HTMLReportHelper().HtmlReportBody("Pool option Payment Creation Verification Option", "Successfully clicked on Payment Creation Verification Option", "Passed", driver, "Y");
			} else {
				System.out.println("fail");
				new HTMLReportHelper().HtmlReportBody("Pool option Payment Creation Verification Option", "Could not clicked on Payment Creation Verification Option", "Failed", driver, "Y");
			}
		}
	}
	
	public void selectPaymentRepairOption() throws Exception {
		boolean stepResult = false;
		try {
			waitForPresenceOfElement(eppPoolOptions, "Pool Value", paymentRepair);
			clickOnElement(eppPoolOptions, "Pool Value", paymentRepair);
			stepResult = true;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			if (stepResult == true) {
				System.out.println("Pass");
				new HTMLReportHelper().HtmlReportBody("Pool option Payment Repair", "Successfully clicked on Payment Repair", "Passed", driver, "Y");
			} else {
				System.out.println("fail");
				new HTMLReportHelper().HtmlReportBody("Pool option Payment Repair", "Could not clicked on Payment Repair", "Failed", driver, "Y");
			}
		}
	}
	
	public void selectPaymentRepairVerificationOption() throws Exception {
		boolean stepResult = false;
		try {
			waitForPresenceOfElement(eppPoolOptions, "Pool Value", paymentRepairVerification);
			clickOnElement(eppPoolOptions, "Pool Value", paymentRepairVerification);
			stepResult = true;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			if (stepResult == true) {
				System.out.println("Pass");
				new HTMLReportHelper().HtmlReportBody("Pool option Payment Repair Verification", "Successfully clicked on Payment Repair Verification", "Passed", driver, "Y");
			} else {
				System.out.println("fail");
				new HTMLReportHelper().HtmlReportBody("Pool option Payment Repair Verification", "Could not clicked on Payment Repair Verification", "Failed", driver, "Y");
			}
		}
	}
}
