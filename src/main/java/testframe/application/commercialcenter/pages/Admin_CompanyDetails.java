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

public class Admin_CompanyDetails extends CommonLibrary{

	public String adminSearchCompanies;
	
	
	By companyID = By.xpath("//input[@id='companyCode']");
	By companyName = By.xpath("//input[@id='companyName']");
	By searchCompanyButton = By.xpath("//button[@id='searchCompany']");
	By createCompanyButton = By.xpath("//button[@id='createCompany']");
	By searchCompanyTitle = By.xpath("//h1[text()='Search Companies']");
	By searchCompanies = By.xpath("//a[@id='menu-SEARCHCOMPANIES']");
	
	//By actions = By.xpath("//button/span[contains(text(),'Actions')]");
	By editCompany = By.xpath("//button/span[contains(text(),'Edit Company')]");
	By deleteCompany = By.xpath("//button/span[contains(text(),'Delete Company')]");
	By companyActionButton = By.xpath("//button[contains(@class,'companyActions')]/span[text()='Actions']");
	By addCompanyUser = By.xpath("//button[contains(@class,'addUser')]");
	
	
	
	
	String validateCompanyName = "//h1[contains(text(),'Company Details : %s')]";
	
	public Admin_CompanyDetails(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	
	
	public void validateSearchCompany(String validateValue){
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
	}
	
	public void searchCompaniesSideLink(){
		boolean stepResult = false;
		try {
			clickOnElement("Company Details", "Search Companies Link", searchCompanies);
			stepResult = true;
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

	public void actionClick(){
		boolean stepResult = false;
		try {
			clickOnElement("Company Details", "Action click", companyActionButton);
			stepResult = true;
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
	
	public void editCompany(){
		boolean stepResult = false;
		try {
			clickOnElement("Company Details", "Edit Company click", editCompany);
			stepResult = true;
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
	
	
	public void deleteCompany(){
		boolean stepResult = false;
		try {
			clickOnElement("Company Details", "Delete Company click", deleteCompany);
			stepResult = true;
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
	
	public void addCompanyUser(){
		boolean stepResult = false;
		try {
			clickOnElement("Company Details", "Actions Button", companyActionButton);
			Thread.sleep(2000);
			clickOnElement("Company Details", "Add User", addCompanyUser);
			stepResult = true;
			
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
