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
	public String poolTemplateOptions = "//a[text()='%s']";
	public String blockName = "//div[@id='headerBar']//table//td[contains(text(),'%s')]";
	
	
	 By manualPayment = By.xpath("//h2[text()='Manual Payments']");
	//By paymentCreation = By.xpath("//a[@class='linkMenu'][text()='Payment Creation']");
	//By outgoingFRB = By.xpath("//a[text()='Outgoing High Value Bank Payment (FRB)']");
	
	
	
	public void selectTemplate(String blockHeaderName,String poolValue) {
		boolean stepResult = false;
		try {
			switchToWindowWithTitleContaining("Enterprise Payments Platform");
			driver.switchTo().frame("main");
			getDynamicElement("Template",blockName,blockHeaderName); 
			waitForPresenceOfElement(eppTemplates, "Template", getDynamicElement("Template",poolTemplateOptions, poolValue));
			getDynamicElementClick(eppTemplates, "Template", poolTemplateOptions, poolValue);
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

	
}
