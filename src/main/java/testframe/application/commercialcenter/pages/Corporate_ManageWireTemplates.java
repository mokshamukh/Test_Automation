package testframe.application.commercialcenter.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import testframe.application.common.CommonLibrary;

/**
 * PageNage : Corporate_ManageWireTemplates
 * 
 * @author shilpa.thangapalam
 */

public class Corporate_ManageWireTemplates extends CommonLibrary{

	public Corporate_ManageWireTemplates(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	
	
	By manageWireTemplatesHeader = By.xpath("//h1[text()='Manage Wire Templates']");
	By createTempalte = By.xpath("//button[contains(@aria-label,'To create a new template')]");
	By startWireTransfer = By.xpath("//h3[@id='selectWireHeading']");
	By selectPayeeButton =By.xpath("//label[text()='Select Payee']//..//div[contains(@class,'ui-state')]");
	

}
