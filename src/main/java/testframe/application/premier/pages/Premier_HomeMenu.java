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
	public By changePortfolio =  By.xpath("//a[text()='Change Portfolio']");
	public By changeNameMenu =  By.xpath("//a[text()='Change Name']");
	public By changeNameTitle = By.xpath("//div[text()='Customer - Names - Change Name']");
	public By depositsMenu =  By.xpath("//a[text()='Deposits']");
	public By demandDepositsSubMenu =  By.xpath("//a[text()='Demand Deposits']");
	public By newDemandDeposits =  By.xpath("//a[text()='Demand Deposits']/following-sibling::ul/li/a[contains(text(),'New Account')]");
	public By accountInquiryDemandDeposits =  By.xpath("//a[text()='Demand Deposits']/following-sibling::ul/li/a[contains(text(),'Account Inquiry')]");
	public By changeAccountDemandDeposits =  By.xpath("//a[text()='Demand Deposits']/following-sibling::ul/li/a[contains(text(),'Change Account')]");
	public By savingsDepositsSubMenu =  By.xpath("//a[text()='Savings']");
	public By newAccountSaving =  By.xpath("//a[text()='Savings']/following-sibling::ul/li/a[contains(text(),'New Account')]");
	public By accountInquirySavings =  By.xpath("//a[text()='Savings']/following-sibling::ul/li/a[contains(text(),'Account Inquiry')]");
	public By changeAccountSavings =  By.xpath("//a[text()='Savings']/following-sibling::ul/li/a[contains(text(),'Change Account')]");
	public By certificatesDepositsSubMenu =  By.xpath("//a[text()='Certificates']");
	public By newAccountCertificates =  By.xpath("//a[text()='Certificates']/following-sibling::ul/li/a[contains(text(),'New Account')]");
	public By accountInquiryCertificates =  By.xpath("//a[text()='Certificates']/following-sibling::ul/li/a[contains(text(),'Account Inquiry')]");
	public By changeAccountCertificates =  By.xpath("//a[text()='Certificates']/following-sibling::ul/li/a[contains(text(),'Change Account')]");
	public By newAddresTitle = By.xpath("//div[text()='Customer - Address - New Address']");
	public By changeAddress = By.xpath("//a[text()='Change Address']");
	public By changeAddressTitle= By.xpath("//div[text()='Customer - Address - Change Address']");		
			

	
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
			if (isElementPresent(homePageHeader) || isElementPresent(changeNameTitle) || isElementPresent(newAddresTitle) || isElementPresent(changeAddressTitle)){
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
	
	public void goToNames() throws Exception{
		boolean stepResult = false;
		try {
			if (isElementPresent(homePageHeader)|| isElementPresent(customerInquiryHeader)){
				clickOnElement("Home Menu Page", "name field", name);
				//clickOnElement("Home Menu Page", "new name field", newName);
				stepResult = true;
			}	
		}catch (Exception e) {
			e.printStackTrace();
		}
		finally {
			if (stepResult==true){
				System.out.println("Pass");
				new HTMLReportHelper().HtmlReportBody("Select Names from Menu", "Menu Name selected Successfully", "Passed", driver, "Y");
			}
			else{
				System.out.println("fail");
				new HTMLReportHelper().HtmlReportBody("Select Names from Menu", "Could not select Menu Names", "Failed", driver, "Y");
			}
		}
		
	}
	
	public void goToNewName() throws Exception{
		boolean stepResult = false;
		try {
			if (isElementPresent(homePageHeader)|| isElementPresent(customerInquiryHeader)){
				//clickOnElement("Home Menu Page", "name field", name);
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
				new HTMLReportHelper().HtmlReportBody("Select New Name from Menu", "Could not select Menu New Name", "Failed", driver, "Y");
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
	
	public void goToAddress() throws Exception{
		boolean stepResult = false;
		try {
			if (isElementPresent(customerHeader)){
				clickOnElement("Home Menu Page", "Address field", address);
				//clickOnElement("Home Menu Page", "new address field", newAddress);
				stepResult = true;
			}	
		}catch (Exception e) {
			e.printStackTrace();
		}
		finally {
			if (stepResult==true){
				System.out.println("Pass");
				new HTMLReportHelper().HtmlReportBody("Select Address from Menu", "Menu Address selected Successfully", "Passed", driver, "Y");
			}
			else{
				System.out.println("fail");
				new HTMLReportHelper().HtmlReportBody("Select Address from Menu", "Could not select Menu Address.", "Failed", driver, "Y");
			}
		}
		
	}
	
	public void goToNewAddress() throws Exception{
		boolean stepResult = false;
		try {
			if (isElementPresent(customerHeader)){
				//clickOnElement("Home Menu Page", "Address field", address);
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
	
	public void goToContact() throws Exception{
		boolean stepResult = false;
		try {
			if (isElementPresent(customerHeader)){
				clickOnElement("Home Menu Page", "Contacts field", contacts);
				//clickOnElement("Home Menu Page", "new contact field", newContact);
				stepResult = true;
			}	
		}catch (Exception e) {
			e.printStackTrace();
		}
		finally {
			if (stepResult==true){
				System.out.println("Pass");
				new HTMLReportHelper().HtmlReportBody("Select Conatct from Menu", "Menu contact selected Successfully", "Passed", driver, "Y");
			}
			else{
				System.out.println("fail");
				new HTMLReportHelper().HtmlReportBody("Select Contact from Menu", "Could not select Menu Contact.", "Failed", driver, "Y");
			}
		}
		
	}
	
	public void goTokNewContact() throws Exception{
		boolean stepResult = false;
		try {
			if (isElementPresent(customerHeader)){
				//clickOnElement("Home Menu Page", "Contacts field", contacts);
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
			if (isElementPresent(portfolioMenu)){
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
		}}
	public void portfolioNew() throws Exception{
		boolean stepResult = false;
		try {
			if (isElementPresent(portfolioMenu)){
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
		}}
	public void portfolioChange() throws Exception{
		boolean stepResult = false;
		try {
			if (isElementPresent(portfolioMenu)){
				clickOnElement("Home Page", "New Portfolio", changePortfolio);
				stepResult = true;
			}	
		}catch (Exception e) {
			e.printStackTrace();
		}
		finally {
			if (stepResult==true){
				System.out.println("Pass");
				new HTMLReportHelper().HtmlReportBody("Select Change Portfolio from Menu", "Change Portfolio from Portfolio menu selected Successfully", "Passed", driver, "Y");
			}
			else{
				System.out.println("fail");
				new HTMLReportHelper().HtmlReportBody("Select Change Portfolio from Menu", "Could not select Change Portfolio from Portfolio menu" , "Failed", driver, "Y");
			}
		}}
	
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
		}}
	// below methods are for the Demand Deposit Account
	public void depositsMenu() throws Exception{
		boolean stepResult = false;
		try {
			if (isElementPresent(depositsMenu)){
				clickOnElement("Home Page", "Deposits Menu ",depositsMenu );
				stepResult = true;
			}	
		}catch (Exception e) {
			e.printStackTrace();
		}
		finally {
			if (stepResult==true){
				System.out.println("Pass");
				new HTMLReportHelper().HtmlReportBody("Select Deposits from Menu", "Deposits from menu selected Successfully", "Passed", driver, "Y");
			}
			else{
				System.out.println("fail");
				new HTMLReportHelper().HtmlReportBody("Select Deposits from Menu", "Could not select Deposits from menu", "Failed", driver, "Y");
			}
		}}
	
	public void demandDepositsSubMenu() throws Exception{
		boolean stepResult = false;
		try {
			if (isElementPresent(depositsMenu)){
				clickOnElement("Home Page", "Demand Deposits Sub Menu ",demandDepositsSubMenu );
				stepResult = true;
			}	
		}catch (Exception e) {
			e.printStackTrace();
		}
		finally {
			if (stepResult==true){
				System.out.println("Pass");
				new HTMLReportHelper().HtmlReportBody("Select Demand Deposits from Menu", "Demand Deposits from menu selected Successfully", "Passed", driver, "Y");
			}
			else{
				System.out.println("fail");
				new HTMLReportHelper().HtmlReportBody("Select Demand Deposits from Menu", "Could not select Demand Deposits from menu", "Failed", driver, "Y");
			}
		}}

	public void newDemandDeposits() throws Exception{
		boolean stepResult = false;
		try {
			if (isElementPresent(depositsMenu)){
				clickOnElement("Home Page", "New Demand Deposits",newDemandDeposits );
				stepResult = true;
			}	
		}catch (Exception e) {
			e.printStackTrace();
		}
		finally {
			if (stepResult==true){
				System.out.println("Pass");
				new HTMLReportHelper().HtmlReportBody("Select New Demand Deposits from Menu", "New Demand Deposits from menu selected Successfully", "Passed", driver, "Y");
			}
			else{
				System.out.println("fail");
				new HTMLReportHelper().HtmlReportBody("Select New Demand Deposits from Menu", "Could not select New Demand Deposits from menu", "Failed", driver, "Y");
			}
		}}
	
	public void accountInquiryDemandDeposits() throws Exception{
		boolean stepResult = false;
		try {
			if (isElementPresent(demandDepositsSubMenu)){
				clickOnElement("Home Page", "Account Inquiry Demand Deposits",accountInquiryDemandDeposits );
				stepResult = true;
			}	
		}catch (Exception e) {
			e.printStackTrace();
		}
		finally {
			if (stepResult==true){
				System.out.println("Pass");
				new HTMLReportHelper().HtmlReportBody("Select Account Inquiry from Demand Deposits Menu", "Account Inquiry from Demand Deposits menu selected Successfully", "Passed", driver, "Y");
			}
			else{
				System.out.println("fail");
				new HTMLReportHelper().HtmlReportBody("Select Account Inquiry from Demand Deposits Menu", "Could not select Account Inquiry from Demand Deposits menu", "Failed", driver, "Y");
			}
		}}
	public void changeAccountDemandDeposits() throws Exception{
		boolean stepResult = false;
		try {
			if (isElementPresent(demandDepositsSubMenu)){
				clickOnElement("Home Page", "Change Account Demand Deposits",changeAccountDemandDeposits );
				stepResult = true;
			}	
		}catch (Exception e) {
			e.printStackTrace();
		}
		finally {
			if (stepResult==true){
				System.out.println("Pass");
				new HTMLReportHelper().HtmlReportBody("Select Change Account from Demand Deposits Menu", "Change Account from Demand Deposits menu selected Successfully", "Passed", driver, "Y");
			}
			else{
				System.out.println("fail");
				new HTMLReportHelper().HtmlReportBody("Select Change Account from Demand Deposits Menu", "Could not select Change Account from Demand Deposits menu", "Failed", driver, "Y");
			}
		}}
	
	// below methods are for the Saving Deposit Account
	public void savingsDepositsSubMenu() throws Exception{
		boolean stepResult = false;
		try {
			if (isElementPresent(depositsMenu)){
				clickOnElement("Home Page", "Saving Deposits Sub Menu ",savingsDepositsSubMenu );
				stepResult = true;
			}	
		}catch (Exception e) {
			e.printStackTrace();
		}
		finally {
			if (stepResult==true){
				System.out.println("Pass");
				new HTMLReportHelper().HtmlReportBody("Select Saving Deposits from Menu", "Saving Deposits from menu selected Successfully", "Passed", driver, "Y");
			}
			else{
				System.out.println("fail");
				new HTMLReportHelper().HtmlReportBody("Select Saving Deposits from Menu", "Could not select Saving Deposits from menu", "Failed", driver, "Y");
			}
		}}
	
	public void newAccountSavings() throws Exception{
		boolean stepResult = false;
		try {
			if (isElementPresent(depositsMenu)){
				clickOnElement("Home Page", "New Account - Saving",newAccountSaving );
				stepResult = true;
			}	
		}catch (Exception e) {
			e.printStackTrace();
		}
		finally {
			if (stepResult==true){
				System.out.println("Pass");
				new HTMLReportHelper().HtmlReportBody("Select New Account from Saving Deposits", "New Account from Saving selected Successfully", "Passed", driver, "Y");
			}
			else{
				System.out.println("fail");
				new HTMLReportHelper().HtmlReportBody("Select New Account from Saving Deposits", "Could not select New Account from Saving menu", "Failed", driver, "Y");
			}
		}}
	
	public void accountInquirySavings() throws Exception{
		boolean stepResult = false;
		try {
			if (isElementPresent(savingsDepositsSubMenu)){
				clickOnElement("Home Page", "Account Inquiry Savings",accountInquirySavings );
				stepResult = true;
			}	
		}catch (Exception e) {
			e.printStackTrace();
		}
		finally {
			if (stepResult==true){
				System.out.println("Pass");
				new HTMLReportHelper().HtmlReportBody("Select Account Inquiry from Savings Menu", "Account Inquiry from Savings menu selected Successfully", "Passed", driver, "Y");
			}
			else{
				System.out.println("fail");
				new HTMLReportHelper().HtmlReportBody("Select Account Inquiry from Savings Menu", "Could not select Account Inquiry from Savings menu", "Failed", driver, "Y");
			}
		}}
	public void changeAccountSavings() throws Exception{
		boolean stepResult = false;
		try {
			if (isElementPresent(savingsDepositsSubMenu)){
				clickOnElement("Home Page", "Change Account Savings",changeAccountSavings );
				stepResult = true;
			}	
		}catch (Exception e) {
			e.printStackTrace();
		}
		finally {
			if (stepResult==true){
				System.out.println("Pass");
				new HTMLReportHelper().HtmlReportBody("Select Change Account from Savings Menu", "Change Account from Savings menu selected Successfully", "Passed", driver, "Y");
			}
			else{
				System.out.println("fail");
				new HTMLReportHelper().HtmlReportBody("Select Change Account from Savings Menu", "Could not select Change Account from Savings menu", "Failed", driver, "Y");
			}
		}}
	// below methods are for the Certificate Deposit Account
	public void certificatesDepositsSubMenu() throws Exception{
		boolean stepResult = false;
		try {
			if (isElementPresent(depositsMenu)){
				clickOnElement("Home Page", "Certificates Deposits Sub Menu ",certificatesDepositsSubMenu );
				stepResult = true;
			}	
		}catch (Exception e) {
			e.printStackTrace();
		}
		finally {
			if (stepResult==true){
				System.out.println("Pass");
				new HTMLReportHelper().HtmlReportBody("Select Certificates Deposits from Menu", "Certificates Deposits from menu selected Successfully", "Passed", driver, "Y");
			}
			else{
				System.out.println("fail");
				new HTMLReportHelper().HtmlReportBody("Select Certificates Deposits from Menu", "Could not select Certificates Deposits from menu", "Failed", driver, "Y");
			}
		}}
	
	public void newAccountCertificates() throws Exception{
		boolean stepResult = false;
		try {
			if (isElementPresent(depositsMenu)){
				clickOnElement("Home Page", "New Account - Certificates",newAccountCertificates );
				stepResult = true;
			}	
		}catch (Exception e) {
			e.printStackTrace();
		}
		finally {
			if (stepResult==true){
				System.out.println("Pass");
				new HTMLReportHelper().HtmlReportBody("Select New Account from Certificates Deposits", "New Account from Certificates selected Successfully", "Passed", driver, "Y");
			}
			else{
				System.out.println("fail");
				new HTMLReportHelper().HtmlReportBody("Select New Account from Certificates Deposits", "Could not select New Account from Certificates menu", "Failed", driver, "Y");
			}
		}}
	
	public void accountInquiryCertificates() throws Exception{
		boolean stepResult = false;
		try {
			if (isElementPresent(savingsDepositsSubMenu)){
				clickOnElement("Home Page", "Account Inquiry Certificates",accountInquiryCertificates );
				stepResult = true;
			}	
		}catch (Exception e) {
			e.printStackTrace();
		}
		finally {
			if (stepResult==true){
				System.out.println("Pass");
				new HTMLReportHelper().HtmlReportBody("Select Account Inquiry from Certificates Menu", "Account Inquiry from Certificates menu selected Successfully", "Passed", driver, "Y");
			}
			else{
				System.out.println("fail");
				new HTMLReportHelper().HtmlReportBody("Select Account Inquiry from Certificates Menu", "Could not select Account Inquiry from Certificates menu", "Failed", driver, "Y");
			}
		}}
	public void changeAccountCertificates() throws Exception{
		boolean stepResult = false;
		try {
			if (isElementPresent(savingsDepositsSubMenu)){
				clickOnElement("Home Page", "Change Account Certificates",changeAccountCertificates );
				stepResult = true;
			}	
		}catch (Exception e) {
			e.printStackTrace();
		}
		finally {
			if (stepResult==true){
				System.out.println("Pass");
				new HTMLReportHelper().HtmlReportBody("Select Change Account from Certificates Menu", "Change Account from Certificates menu selected Successfully", "Passed", driver, "Y");
			}
			else{
				System.out.println("fail");
				new HTMLReportHelper().HtmlReportBody("Select Change Account from Certificates Menu", "Could not select Change Account from Certificates menu", "Failed", driver, "Y");
			}
		}}
	
	
	public void goToChangeAddress() throws Exception{
		boolean stepResult = false;
		try {
			if (isElementPresent(customerHeader)){
				clickOnElement("Home Menu Page", "Change Address field", changeAddress);
				stepResult = true;
			}	
		}catch (Exception e) {
			e.printStackTrace();
		}
		finally {
			if (stepResult==true){
				System.out.println("Pass");
				new HTMLReportHelper().HtmlReportBody("Select Change Address from Menu", "Menu Change Address selected Successfully", "Passed", driver, "Y");
			}
			else{
				System.out.println("fail");
				new HTMLReportHelper().HtmlReportBody("SelectChange Address from Menu", "Could not select Menu Change Address", "Failed", driver, "Y");
			}
		}
		
	}
}