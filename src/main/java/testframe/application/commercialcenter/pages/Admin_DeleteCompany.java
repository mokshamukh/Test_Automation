package testframe.application.commercialcenter.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import testframe.application.common.CommonLibrary;

/**
 * PageNage : CommercialCenter_Admin_SearchCompanies
 * 
 * @author Moksha.Mukh
 */

public class Admin_DeleteCompany extends CommonLibrary{

	By removeCompanyTitle =  By.xpath("//span[text()='Remove Company']");
	By yes = By.xpath("//input[@id='companyCode']");
	
	public Admin_DeleteCompany(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	public void deleteCompany(){
		boolean stepResult = false;
		try {
			if (isElementPresent(removeCompanyTitle)){
			
			//clickOnElement("Admin Remove Company", "Yes Button", yes);
				stepResult = true;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		finally {
			if (stepResult==true)
				System.out.println("Pass");
			else
				System.out.println("fail");
		}
		
	}
	
	
	

}
