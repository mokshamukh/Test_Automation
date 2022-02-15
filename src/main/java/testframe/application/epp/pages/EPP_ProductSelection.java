package testframe.application.epp.pages;
/**
 * PageName : EPP_ProductSelection
 * 
 * @author Shilpa.Thangapalam
 */

import org.openqa.selenium.By;
/**
 * PageName : EPP_ProductSelectionPage
 * 
 * @author shilpa.thangapalam
 */
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;

import testframe.application.common.CommonLibrary;
import testframe.common.reporting.HTMLReportHelper;

public class EPP_ProductSelection extends CommonLibrary{

	public EPP_ProductSelection(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
		PageFactory.initElements(new AjaxElementLocatorFactory(driver, 50), this);
	}

	public String eppproductSelectionPage ="EPP_ProductSelection";
	public String eppdisclaimerPage = "EPP_DisclaimerPage";

	By imgProduct = By.xpath("//img[@class='product_logo'][@title='Enterprise Payments Platform']");
	By accessWarning = By.xpath("//div[contains(text(),'Unauthorized Access Warning')]");
	By disclaimerBox = By.xpath("//div[@class='legalDisclaimerBox']");
	By disclaimerContinueBtn = By.xpath("//div[@id='img_button_continue']");



	public void selectProductEPP() throws Exception {
		if (System.getProperty("runStep")=="Y"){
			boolean stepResult = false;
			try {
				waitForPresenceOfElement(eppproductSelectionPage, "EPP Product Selected", imgProduct);
				clickOnElement(eppproductSelectionPage, "EPP Product Selected", imgProduct);
				waitElement(10000);
				switchToWindowWithTitleContaining("Unauthorized Access Warning");
				waitElement(1500);
				if(isElementPresentZeroWait(disclaimerBox)) {
					clickOnElement(eppdisclaimerPage, "Disclaimer", disclaimerContinueBtn);
					waitElement(1500);
					stepResult = true;
				}
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} finally {
				if (stepResult == true) {
					System.out.println("Pass");
					new HTMLReportHelper().HtmlReportBody("Select EPP product", "Product Selected Successfully","Passed", driver, "Y");
				} else {
					System.out.println("fail");
					new HTMLReportHelper().HtmlReportBody("Select EPP product","Could not Select Product Successfully", "Failed", driver, "Y");
					System.setProperty("runStep","N");
				}
			}
		}

	}

}
