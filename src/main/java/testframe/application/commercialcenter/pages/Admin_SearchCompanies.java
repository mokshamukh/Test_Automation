package testframe.application.commercialcenter.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import testframe.application.common.CommonLibrary;
import testframe.common.reporting.HTMLReportHelper;

/**
 * PageNage : CommercialCenter_Admin_SearchCompanies
 * 
 * @author Ketki.Badalwar,Moksha.Mukh
 */

public class Admin_SearchCompanies extends CommonLibrary{

	public String adminSearchCompanies;
	By companyID = By.xpath("//input[@id='companyCode']");
	By companyName = By.xpath("//input[@id='companyName']");
	By accountNumber = By.xpath("//input[@id='accountNumber']");
	By marketSegment = By.xpath("//label[text()='Market Segment']/../input[@class='autocomplete ac_input']");
	By label = By.xpath("//label[text()='Label']/../input[@class='autocomplete ac_input']");
	By showLabel = By.xpath("//input[@id='showLabels']");
	By searchCompanyButton = By.xpath("//button[@id='searchCompany']");
	By createCompanyButton = By.xpath("//button[@id='createCompany']");
	By searchCompanyTitle = By.xpath("//h1[text()='Search Companies']");
	By noResultCompany = By.xpath("//div[text()='No Results']");



	String validateCompanyName = "//h1[contains(text(),'Company Details : %s')]";

	public Admin_SearchCompanies(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public void clickCreateCompany() throws Exception{
		if (System.getProperty("runStep")=="Y"){	
			boolean stepResult = false;
			try {
				if (isElementPresent(searchCompanyTitle)){
					clickOnElement("Admin Search Companies Page", "Create Company Button", createCompanyButton);
					stepResult = true;
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
			finally {
				if (stepResult==true){
					System.out.println("Pass");
					new HTMLReportHelper().HtmlReportBody("Create a company button click", "Clicked on create company button successfully", "Passed", driver, "Y");
				}
				else{
					System.out.println("fail");
					new HTMLReportHelper().HtmlReportBody("Create a company button click", "Could not click on create company button", "Failed", driver, "Y");
					System.setProperty("runStep","N");
				}
			}
		}

	}




	public void searchCompany(String sCompanyId,String accountNum, String sCompanyName,String marketSeg,String labelVal,String showLabels) throws Exception {
		if (System.getProperty("runStep")=="Y"){	
			boolean stepResult = false;
			try {
				if (isElementPresent(searchCompanyTitle)){
					if (!sCompanyId.equals("")) {
						enterText("Admin Search Companies Page", "Company ID", companyID, sCompanyId);
					}
					if (!sCompanyName.equals("")) {
						enterText("Admin Search Companies Page", "Company Name", companyName, sCompanyName);
					}
					if (!accountNum.equals("")) {
						enterText("Admin Search Companies Page", "Account Number", accountNumber, accountNum);
					}
					if(!marketSeg.equals("")){
						clearText("Admin Search Companies Page", "Market Segment", marketSegment);
						enterText("Admin Search Companies Page", "Market Segment", marketSegment, marketSeg);
					}
					if(!labelVal.equals("")){
						enterText("Admin Search Companies Page", "Label", label, labelVal);
					}
					if(showLabels.equals("Checked")){
						clickOnElement("Admin Search Companies Page", "Click Show Lables", showLabel);
					}
					clickOnElement("Admin Search Companies Page", "Search Companies Button", searchCompanyButton);
					stepResult = true;
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
			finally {
				if (stepResult==true){
					System.out.println("Pass");
					new HTMLReportHelper().HtmlReportBody("Search companies", "Search company successfully", "Passed", driver, "Y");
				}
				else{
					System.out.println("fail");
					new HTMLReportHelper().HtmlReportBody("Search companies", "Could not search company", "Failed", driver, "Y");
					System.setProperty("runStep","N");
				}
			}
		}

	}

	public void noResults() throws Exception{
		if (System.getProperty("runStep")=="Y"){	
			boolean stepResult = false;
			try {
				if(isElementPresent(noResultCompany)){
					stepResult = true;
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
			finally {
				if (stepResult==true){
					System.out.println("Pass");
					new HTMLReportHelper().HtmlReportBody("Admin search company", "No result found", "Passed", driver, "Y");
				}
				else{
					System.out.println("fail");
					new HTMLReportHelper().HtmlReportBody("Admin search company", "Could not see no result found", "Failed", driver, "Y");
					System.setProperty("runStep","N");
				}
			}		}
	}


	/*public void validateSearchCompany(String validateValue){
		boolean stepResult = false;
		try {
			if(isElementPresent(getDynamicElement("Company Name",validateCompanyName,validateValue))){
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
	}*/

}
