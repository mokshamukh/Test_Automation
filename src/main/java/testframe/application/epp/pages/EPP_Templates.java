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
	
	public String eppTemplates = "EPP_Templates";
	
	
	By manualPayment = By.xpath("//h2[text()='Manual Payments']");
	//By paymentCreation = By.xpath("//a[@class='linkMenu'][text()='Payment Creation']");
	//By outgoingFRB = By.xpath("//a[text()='Outgoing High Value Bank Payment (FRB)']");
	
	public String paymentTemplateOptions = "//a[text()='%s']";
	public String templateLabel = "//div[@id='headerBar']//table//td[contains(text(),'%s')]";
	
	
	public void selectPaymentTemplate(String templateHeader,String value) {
		boolean stepResult = false;
		try {
			switchToWindowWithTitleContaining("Enterprise Payments Platform");
			driver.switchTo().frame("main");
			getDynamicElement("Template",templateLabel,templateHeader); 
			waitForPresenceOfElement(eppTemplates, "Payment_Template", getDynamicElement("Payment Template",paymentTemplateOptions, value));
			getDynamicElementClick(eppTemplates, "Payment Template", paymentTemplateOptions, value);
			stepResult = true;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			if (stepResult == true) {
				System.out.println("Pass");
				new HTMLReportHelper().HtmlReportBody("Template option '" + value +"' template", "Successfully clicked on '" + value +"' template", "Passed", driver, "Y");
			} else {
				System.out.println("fail");
				new HTMLReportHelper().HtmlReportBody("Template option '" + value +"' template", "Could not clicked on '" + value +"' template", "Failed", driver, "Y");
			}
		}
	}

	
}
