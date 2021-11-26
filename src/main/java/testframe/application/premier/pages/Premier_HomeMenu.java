package testframe.application.premier.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import testframe.application.common.CommonLibrary;
import testframe.common.reporting.HTMLReportHelper;

/**
 * 
 * 
 * @author Ketki.Badalwar
 */

public class Premier_HomeMenu extends CommonLibrary {

	public String homePage = "Home Page";

	public By homePageHeader =  By.xpath("//div[text()='Home Page']");
	public By customerMenu =  By.xpath("//a[@data-key='Customer']");
	public By customerInquiry =  By.xpath("//a[text()='Customer Inquiry']");
	public By customerInquiryHeader =  By.xpath("//div[text()='Customer - Customer Inquiry']");
	public By nameSearch =  By.xpath("//input[@name='Sound']");
	public By ssnSearch =  By.xpath("//input[@name='TaxID']");
	public By submitSearch =  By.xpath("//button[@name='Submit']");
	public By name = By.xpath("//a[text()='Names']");
	public By newName =  By.xpath("//a[text()='New Name']");
	public By address = By.xpath("//a[text()='Address']");
	public By newAddress = By.xpath("//a[text()='New Address']");
	public By customerHeader = By.xpath("(//a[text()='Customer'])[2]");
	public By contacts = By.xpath("//a[text()='Contacts']");
	public By newContact = By.xpath("//a[text()='New Name Contact']");
	public By portfolioMenu =  By.xpath("(//a[text()='Portfolio'])[2]");
	public By newPortfolio =  By.xpath("//a[text()='New Portfolio']");
	public By changeNameMenu =  By.xpath("//a[text()='Change Name']");
	public By changeNameTitle = By.xpath("//div[text()='Customer - Names - Change Name']");
	
	

	public Premier_HomeMenu(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public void customerMenu() throws Exception{
		boolean stepResult = false;
		try {
			if (isElementPresent(homePageHeader)){
				clickOnElement("Home Page", "Customer Menu ",customerMenu );
				stepResult = true;
			}	
		}catch (Exception e) {
			e.printStackTrace();
		}
		finally {
			if (stepResult==true){
				System.out.println("Pass");
				new HTMLReportHelper().HtmlReportBody("Select Customer from Menu", "Customer from menu selected Successfully", "Passed", driver, "Y");
			}
			else{
				System.out.println("fail");
				new HTMLReportHelper().HtmlReportBody("Select Customer from Menu", "Could not select Customer from menu", "Failed", driver, "Y");
			}
		}

	}
	
	public void customerInquiry() throws Exception{
		boolean stepResult = false;
		try {
			if (isElementPresent(homePageHeader) || isElementPresent(changeNameTitle)){
				clickOnElement("Home Page", "Customer Inquiry", customerInquiry);
				stepResult = true;
			}	
		}catch (Exception e) {
			e.printStackTrace();
		}
		finally {
			if (stepResult==true){
				System.out.println("Pass");
				new HTMLReportHelper().HtmlReportBody("Home Menu Page", "Customer Inquiry from customer menu selected Successfully", "Passed", driver, "Y");
			}
			else{
				System.out.println("fail");
				new HTMLReportHelper().HtmlReportBody("Home Menu Page", "Could not select Customer Inquiry from customer menu" , "Failed", driver, "Y");
			}
		}

	}
	
	public void clickNewName() throws Exception{
		boolean stepResult = false;
		try {
			if (isElementPresent(homePageHeader)){
				clickOnElement("Home Menu Page", "name field", name);
				clickOnElement("Home Menu Page", "new name field", newName);
				stepResult = true;
			}	
		}catch (Exception e) {
			e.printStackTrace();
		}
		finally {
			if (stepResult==true){
				System.out.println("Pass");
				new HTMLReportHelper().HtmlReportBody("Select New Name from Menu", "Menu New Name selected Successfully", "Passed", driver, "Y");
			}
			else{
				System.out.println("fail");
				new HTMLReportHelper().HtmlReportBody("Select New Name from Menu", "Could not select Menu New Name.", "Failed", driver, "Y");
			}
		}
		
	} 
	
	public void clickNewAddress() throws Exception{
		boolean stepResult = false;
		try {
			if (isElementPresent(customerHeader)){
				clickOnElement("Home Menu Page", "Address field", address);
				clickOnElement("Home Menu Page", "new address field", newAddress);
				stepResult = true;
			}	
		}catch (Exception e) {
			e.printStackTrace();
		}
		finally {
			if (stepResult==true){
				System.out.println("Pass");
				new HTMLReportHelper().HtmlReportBody("Select New Address from Menu", "Menu New Address selected Successfully", "Passed", driver, "Y");
			}
			else{
				System.out.println("fail");
				new HTMLReportHelper().HtmlReportBody("Select New Address from Menu", "Could not select Menu New Address.", "Failed", driver, "Y");
			}
		}
		
	} 
	
	public void clickNewContact() throws Exception{
		boolean stepResult = false;
		try {
			if (isElementPresent(customerHeader)){
				clickOnElement("Home Menu Page", "Contacts field", contacts);
				clickOnElement("Home Menu Page", "new contact field", newContact);
				stepResult = true;
			}	
		}catch (Exception e) {
			e.printStackTrace();
		}
		finally {
			if (stepResult==true){
				System.out.println("Pass");
				new HTMLReportHelper().HtmlReportBody("Select New Conatct from Menu", "Menu New contact selected Successfully", "Passed", driver, "Y");
			}
			else{
				System.out.println("fail");
				new HTMLReportHelper().HtmlReportBody("Select New Contact from Menu", "Could not select Menu New Contact.", "Failed", driver, "Y");
			}
		}
		
	} 
	public void portfolioMenu() throws Exception{
		boolean stepResult = false;
		try {
			if (isElementPresent(homePageHeader)){
				clickOnElement("Home Page", "Portfolio Menu ",portfolioMenu );
				stepResult = true;
			}	
		}catch (Exception e) {
			e.printStackTrace();
		}
		finally {
			if (stepResult==true){
				System.out.println("Pass");
				new HTMLReportHelper().HtmlReportBody("Select Portfolio from Menu", "Portfolio from menu selected Successfully", "Passed", driver, "Y");
			}
			else{
				System.out.println("fail");
				new HTMLReportHelper().HtmlReportBody("Select Portfolio from Menu", "Could not select Portfolio from menu", "Failed", driver, "Y");
			}
		}

	}
	public void portfolioNew() throws Exception{
		boolean stepResult = false;
		try {
			if (isElementPresent(homePageHeader)){
				clickOnElement("Home Page", "New Portfolio", newPortfolio);
				stepResult = true;
			}	
		}catch (Exception e) {
			e.printStackTrace();
		}
		finally {
			if (stepResult==true){
				System.out.println("Pass");
				new HTMLReportHelper().HtmlReportBody("Select New Portfolio from Menu", "New Portfolio from Portfolio menu selected Successfully", "Passed", driver, "Y");
			}
			else{
				System.out.println("fail");
				new HTMLReportHelper().HtmlReportBody("Select New Portfolio from Menu", "Could not select New Portfolio from Portfolio menu" , "Failed", driver, "Y");
			}
		}

	}
	
	public void changeName() throws Exception{
		boolean stepResult = false;
		try {
			Thread.sleep(2000);
			if (isElementPresent(customerHeader)){
				clickOnElement("Home Page", "Change Name ",changeNameMenu );
				stepResult = true;
			}	
		}catch (Exception e) {
			e.printStackTrace();
		}
		finally {
			if (stepResult==true){
				System.out.println("Pass");
				new HTMLReportHelper().HtmlReportBody("Select Change Name from Menu", "Change name from menu selected Successfully", "Passed", driver, "Y");
			}
			else{
				System.out.println("fail");
				new HTMLReportHelper().HtmlReportBody("Select Change Name from Menu", "Could not select Change name from menu", "Failed", driver, "Y");
			}
		}

	}
}