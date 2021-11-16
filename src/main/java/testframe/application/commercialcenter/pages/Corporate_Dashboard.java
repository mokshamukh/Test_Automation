package testframe.application.commercialcenter.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import testframe.application.common.CommonLibrary;
import testframe.common.reporting.HTMLReportHelper;

/**
 * PageNage : CommercialCenter_Corporate_Dashboard
 * 
 * @author Ketki.Badalwar
 */

public class Corporate_Dashboard extends CommonLibrary{
	
	By approvalTitle = By.xpath("//h3[text()='Approvals']");
	String approvalTypeAccordion = "//a[contains(@aria-label,'%s')]/i";
	
	public Corporate_Dashboard(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	//value = ACH,Wires,Account Transfers
	public void selectApprovals(String ApprovalTypes) throws Exception{
		boolean stepResult = false;
		try {
			Thread.sleep(4000);
			if (isElementPresent(approvalTitle)) {
				clickOnElement("Corporate Dashboard Page", "Approval Title", approvalTitle);
				getDynamicElementClick("Corporate Dashboard Page", "Approval Type", approvalTypeAccordion, ApprovalTypes);
				stepResult = true;
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (stepResult == true) {
				System.out.println("Pass - approval type");
				new HTMLReportHelper().HtmlReportBody("Dashboard CC- Corporate application",
						"click on approval type Successfully", "Passed", driver, "Y");
			} else {
				System.out.println("fail");
				new HTMLReportHelper().HtmlReportBody("Dashboard CC- Corporate application",
						"Could not click on approval type Successfully", "Failed", driver, "Y");
			}
		}
	
		
	}

}
