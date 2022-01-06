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
	public By linesMenu = By.xpath("//a[text()='Lines']");
	public By newLine = By.xpath("//a[text()='New Line']");
	public By lineInquiry = By.xpath("//a[text()='Line Inquiry']");
	public By loansMenu = By.xpath("//a[text()='Loans']");
	public By newNote = By.xpath("//a[text()='New Note']");
	public By accountInquiryLoans =  By.xpath("//a[text()='Loans']/../ul//a[(text()='Account Inquiry')]");
	public By changeAccountLoans =  By.xpath("//a[text()='Loans']/following-sibling::ul/li/a[contains(text(),'Change Account')]");
	public By changeAddress = By.xpath("//a[text()='Change Address']");
	public By changeAddressTitle= By.xpath("//div[text()='Customer - Address - Change Address']");		
	public By safeDepositBox = By.xpath("//a[text()='Safe Deposit Box']");
	public By newAccountSafeDepositBox = By.xpath("//a[text()='Safe Deposit Box']/following-sibling::ul/li/a[contains(text(),'New Account')]");
	public By accountInquirySDBDeposits = By.xpath("//a[text()='Safe Deposit Box']/following-sibling::ul/li/a[contains(text(),'Account Inquiry')]");
	public By changeAccountSDB =  By.xpath("//a[text()='Safe Deposit Box']/following-sibling::ul/li/a[contains(text(),'Change Account')]");
	public By collateralMenu = By.xpath("//a[text()='Collateral']");
	public By newCollateral = By.xpath("//a[text()='New Collateral']");

	public Premier_HomeMenu(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public void customerMenu() throws Exception{
		if (System.getProperty("runStep")=="Y"){
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
					System.setProperty("runStep","N");
				}
			}
		}

	}

	public void customerInquiry() throws Exception{
		if (System.getProperty("runStep")=="Y"){
			boolean stepResult = false;
			try {
				//if (isElementPresent(homePageHeader) || isElementPresent(changeNameTitle) || isElementPresent(newAddresTitle) || isElementPresent(changeAddressTitle)){
				clickOnElement("Home Page", "Customer Inquiry", customerInquiry);
				stepResult = true;
				//}	
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
					System.setProperty("runStep","N");
				}
			}
		}

	}

	public void clickNewName() throws Exception{
		if (System.getProperty("runStep")=="Y"){
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
					System.setProperty("runStep","N");
				}
			}
		}

	} 

	public void goToNames() throws Exception{
		if (System.getProperty("runStep")=="Y"){
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
					System.setProperty("runStep","N");
				}
			}
		}

	}

	public void goToNewName() throws Exception{
		if (System.getProperty("runStep")=="Y"){
			boolean stepResult = false;
			try {
				if (isElementPresent(customerHeader)){
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
					System.setProperty("runStep","N");
				}
			}
		}

	}

	public void clickNewAddress() throws Exception{
		if (System.getProperty("runStep")=="Y"){
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
					System.setProperty("runStep","N");
				}
			}
		}

	} 

	public void goToAddress() throws Exception{
		if (System.getProperty("runStep")=="Y"){
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
					System.setProperty("runStep","N");
				}
			}
		}

	}

	public void goToNewAddress() throws Exception{
		if (System.getProperty("runStep")=="Y"){
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
					System.setProperty("runStep","N");
				}
			}

		}
	}

	public void clickNewContact() throws Exception{
		if (System.getProperty("runStep")=="Y"){
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
					System.setProperty("runStep","N");
				}
			}
		}

	}

	public void goToContact() throws Exception{
		if (System.getProperty("runStep")=="Y"){
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
					System.setProperty("runStep","N");
				}
			}
		}

	}

	public void goTokNewContact() throws Exception{
		if (System.getProperty("runStep")=="Y"){
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
					System.setProperty("runStep","N");
				}
			}
		}
	}

	public void portfolioMenu() throws Exception{
		if (System.getProperty("runStep")=="Y"){
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
					System.setProperty("runStep","N");
				}
			}
		}
	}
	public void portfolioNew() throws Exception{
		if (System.getProperty("runStep")=="Y"){
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
					System.setProperty("runStep","N");
				}
			}
		}
	}

	public void portfolioChange() throws Exception{
		if (System.getProperty("runStep")=="Y"){
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
					System.setProperty("runStep","N");
				}
			}
		}
	}

	public void changeName() throws Exception{
		if (System.getProperty("runStep")=="Y"){
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
					System.setProperty("runStep","N");
				}
			}
		}
	}

	// below methods are for the Demand Deposit Account
	public void depositsMenu() throws Exception{
		if (System.getProperty("runStep")=="Y"){
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
					System.setProperty("runStep","N");
				}
			}
		}
	}

	public void demandDepositsSubMenu() throws Exception{
		if (System.getProperty("runStep")=="Y"){
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
					System.setProperty("runStep","N");
				}
			}
		}
	}

	public void newDemandDeposits() throws Exception{
		if (System.getProperty("runStep")=="Y"){
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
					System.setProperty("runStep","N");
				}
			}
		}
	}

	public void accountInquiryDemandDeposits() throws Exception{
		if (System.getProperty("runStep")=="Y"){
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
					System.setProperty("runStep","N");
				}
			}
		}
	}
	public void changeAccountDemandDeposits() throws Exception{
		if (System.getProperty("runStep")=="Y"){
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
					System.setProperty("runStep","N");
				}
			}
		}
	}


	// below methods are for the Saving Deposit Account
	public void savingsDepositsSubMenu() throws Exception{
		if (System.getProperty("runStep")=="Y"){

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
					System.setProperty("runStep","N");
				}
			}
		}
	}

	public void newAccountSavings() throws Exception{
		if (System.getProperty("runStep")=="Y"){
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
					System.setProperty("runStep","N");
				}
			}
		}
	}

	public void accountInquirySavings() throws Exception{
		if (System.getProperty("runStep")=="Y"){
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
					System.setProperty("runStep","N");
				}
			}
		}
	}
	public void changeAccountSavings() throws Exception{
		if (System.getProperty("runStep")=="Y"){
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
					System.setProperty("runStep","N");
				}
			}
		}
	}
	// below methods are for the Certificate Deposit Account
	public void certificatesDepositsSubMenu() throws Exception{
		if (System.getProperty("runStep")=="Y"){

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
					System.setProperty("runStep","N");
				}
			}
		}
	}

	public void newAccountCertificates() throws Exception{
		if (System.getProperty("runStep")=="Y"){
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
					System.setProperty("runStep","N");
				}
			}
		}
	}

	public void accountInquiryCertificates() throws Exception{
		if (System.getProperty("runStep")=="Y"){
			boolean stepResult = false;
			try {
				if (isElementPresent(certificatesDepositsSubMenu)){
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
					System.setProperty("runStep","N");
				}
			}
		}
	}
	public void changeAccountCertificates() throws Exception{
		if (System.getProperty("runStep")=="Y"){
			boolean stepResult = false;
			try {
				if (isElementPresent(certificatesDepositsSubMenu)){
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
					System.setProperty("runStep","N");
				}
			}
		}
	}

	public void selectLinesMenu() throws Exception{
		if (System.getProperty("runStep")=="Y"){
			boolean stepResult = false;
			try {
				if (isElementPresent(linesMenu)){
					clickOnElement("Home Menu Page", "Lines field", linesMenu);
					stepResult = true;
				}	
			}catch (Exception e) {
				e.printStackTrace();
			}
			finally {
				if (stepResult==true){
					System.out.println("Pass");
					new HTMLReportHelper().HtmlReportBody("Select New Line from Menu", "Menu New Line selected Successfully", "Passed", driver, "Y");
				}
				else{
					System.out.println("fail");
					new HTMLReportHelper().HtmlReportBody("Select New Line from Menu", "Could not select Menu New Line.", "Failed", driver, "Y");
					System.setProperty("runStep","N");
				}
			}
		}
	} 

	public void selectNewLine() throws Exception{
		if (System.getProperty("runStep")=="Y"){
			boolean stepResult = false;
			try {
				if (isElementPresent(linesMenu)){
					clickOnElement("Home Menu Page", "New Line field", newLine);
					stepResult = true;
				}	
			}catch (Exception e) {
				e.printStackTrace();
			}
			finally {
				if (stepResult==true){
					System.out.println("Pass");
					new HTMLReportHelper().HtmlReportBody("Select New Line from Menu", "Menu New Line selected Successfully", "Passed", driver, "Y");
				}
				else{
					System.out.println("fail");
					new HTMLReportHelper().HtmlReportBody("Select New Line from Menu", "Could not select Menu New Line.", "Failed", driver, "Y");
					System.setProperty("runStep","N");
				}
			}
		}
	} 

	public void selectLineInquiry() throws Exception{
		if (System.getProperty("runStep")=="Y"){
			boolean stepResult = false;
			try {
				if (isElementPresent(linesMenu)){
					clickOnElement("Home Menu Page", "Line Inquiry field", lineInquiry);
					stepResult = true;
				}	
			}catch (Exception e) {
				e.printStackTrace();
			}
			finally {
				if (stepResult==true){
					System.out.println("Pass");
					new HTMLReportHelper().HtmlReportBody("Select Line Inquiry from Menu", "Menu Line Inquiry selected Successfully", "Passed", driver, "Y");
				}
				else{
					System.out.println("fail");
					new HTMLReportHelper().HtmlReportBody("Select New Line Inquiry from Menu", "Could not select Menu Line Inquiry.", "Failed", driver, "Y");
					System.setProperty("runStep","N");
				}
			}
		}
	} 

	public void selectLoansMenu() throws Exception{
		if (System.getProperty("runStep")=="Y"){
			boolean stepResult = false;
			try {
				if (isElementPresent(loansMenu)){
					clickOnElement("Home Menu Page", "Loans field", loansMenu);
					stepResult = true;
				}	
			}catch (Exception e) {
				e.printStackTrace();
			}
			finally {
				if (stepResult==true){
					System.out.println("Pass");
					new HTMLReportHelper().HtmlReportBody("Select Loans from Menu", "Menu Loans selected Successfully", "Passed", driver, "Y");
				}
				else{
					System.out.println("fail");
					new HTMLReportHelper().HtmlReportBody("Select Loans from Menu", "Could not select Menu Loans.", "Failed", driver, "Y");
					System.setProperty("runStep","N");
				}
			}
		}
	} 

	public void selectNewNote() throws Exception{
		if (System.getProperty("runStep")=="Y"){
			boolean stepResult = false;
			try {
				if (isElementPresent(loansMenu)){
					clickOnElement("Home Menu Page", "New Note field", newNote);
					stepResult = true;
				}	
			}catch (Exception e) {
				e.printStackTrace();
			}
			finally {
				if (stepResult==true){
					System.out.println("Pass");
					new HTMLReportHelper().HtmlReportBody("Select New Note from Menu", "Menu New Note selected Successfully", "Passed", driver, "Y");
				}
				else{
					System.out.println("fail");
					new HTMLReportHelper().HtmlReportBody("Select New Note from Menu", "Could not select Menu New Note.", "Failed", driver, "Y");
					System.setProperty("runStep","N");
				}
			}
		}
	}
	public void loanAccountInquiry() throws Exception{
		if (System.getProperty("runStep")=="Y"){
			boolean stepResult = false;
			try {
				if (isElementPresent(loansMenu)){
					clickOnElement("Home Menu Page", "Loan Account Inquiry field", accountInquiryLoans);
					stepResult = true;
				}	
			}catch (Exception e) {
				e.printStackTrace();
			}
			finally {
				if (stepResult==true){
					System.out.println("Pass");
					new HTMLReportHelper().HtmlReportBody("Select Account Inquiry from Menu", "Account Inquiry selected Successfully", "Passed", driver, "Y");
				}
				else{
					System.out.println("fail");
					new HTMLReportHelper().HtmlReportBody("Select Account Inquiry from Menu", "Could not select Account Inquiry.", "Failed", driver, "Y");
					System.setProperty("runStep","N");
				}
			}
		}

	}


	public void goToChangeAddress() throws Exception{
		if (System.getProperty("runStep")=="Y"){
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
					new HTMLReportHelper().HtmlReportBody("Select Change Address from Menu", "Could not select Menu Change Address", "Failed", driver, "Y");
					System.setProperty("runStep","N");
				}
			}
		}

	}

	public void goToSafeDepositBox() throws Exception{
		if (System.getProperty("runStep")=="Y"){
			boolean stepResult = false;
			try {
				clickOnElement("Home Menu Page", "Safe Deposit Box link", safeDepositBox);
				stepResult = true;
			}catch (Exception e) {
				e.printStackTrace();
			}
			finally {
				if (stepResult==true){
					System.out.println("Pass");
					new HTMLReportHelper().HtmlReportBody("Safe Deposit Box from Menu", "Safe Deposit Box clicked Successfully", "Passed", driver, "Y");
				}
				else{
					System.out.println("fail");
					new HTMLReportHelper().HtmlReportBody("Safe Deposit Box from Menu", "Could not click on Safe Deposit Box", "Failed", driver, "Y");
					System.setProperty("runStep","N");
				}
			}
		}

	}


	public void goToNewAccountSafeDepositBox() throws Exception{
		if (System.getProperty("runStep")=="Y"){
			boolean stepResult = false;
			try {
				clickOnElement("New Account - Safe Deposit Box", "New Account - Safe Deposit Box link", newAccountSafeDepositBox);
				stepResult = true;
			}catch (Exception e) {
				e.printStackTrace();
			}
			finally {
				if (stepResult==true){
					System.out.println("Pass");
					new HTMLReportHelper().HtmlReportBody("New Account - Safe Deposit Box from Menu", "New Account - Safe Deposit Box clicked Successfully", "Passed", driver, "Y");
				}
				else{
					System.out.println("fail");
					new HTMLReportHelper().HtmlReportBody("New Account - Safe Deposit Box from Menu", "Could not click on New Account - Safe Deposit Box", "Failed", driver, "Y");
					System.setProperty("runStep","N");
				}
			}
		}

	}

	public void changeAccountLoans() throws Exception{
		if (System.getProperty("runStep")=="Y"){
			boolean stepResult = false;
			try {
				if (isElementPresent(loansMenu)){
					clickOnElement("Home Page", "Change Account Loans",changeAccountLoans );
					stepResult = true;
				}	
			}catch (Exception e) {
				e.printStackTrace();
			}
			finally {
				if (stepResult==true){
					System.out.println("Pass");
					new HTMLReportHelper().HtmlReportBody("Select Change Account from Loans Menu", "Change Account from Loans menu selected Successfully", "Passed", driver, "Y");
				}
				else{
					System.out.println("fail");
					new HTMLReportHelper().HtmlReportBody("Select Change Account from Loans Menu", "Could not select Change Account from Loans menu", "Failed", driver, "Y");
					System.setProperty("runStep","N");
				}
			}
		}
	}

	public void accountInquirySDB() throws Exception{
		if (System.getProperty("runStep")=="Y"){
			boolean stepResult = false;
			try {
				if (isElementPresent(safeDepositBox)){
					clickOnElement("Home Page", "Account Inquiry Safe Deposits Box",accountInquirySDBDeposits );
					stepResult = true;
				}	
			}catch (Exception e) {
				e.printStackTrace();
			}
			finally {
				if (stepResult==true){
					System.out.println("Pass");
					new HTMLReportHelper().HtmlReportBody("Select Account Inquiry from Safe Deposit Box Menu", "Account Inquiry from Safe Deposit Box menu selected Successfully", "Passed", driver, "Y");
				}
				else{
					System.out.println("fail");
					new HTMLReportHelper().HtmlReportBody("Select Account Inquiry from Safe Deposit Box Menu", "Could not select Account Inquiry from Safe Deposit Box menu", "Failed", driver, "Y");
					System.setProperty("runStep","N");
				}
			}
		}
	}

	public void goToChangeSDBAccount() throws Exception{
		if (System.getProperty("runStep")=="Y"){
			boolean stepResult = false;
			try {
				if (isElementPresent(safeDepositBox)){
					clickOnElement("Home Page", "Change Account Safe Deposit Box",changeAccountSDB );
					stepResult = true;
				}	
			}catch (Exception e) {
				e.printStackTrace();
			}
			finally {
				if (stepResult==true){
					System.out.println("Pass");
					new HTMLReportHelper().HtmlReportBody("Select Change Account from Safe Deposit Box Menu", "Change Account from Safe Deposit Box menu selected Successfully", "Passed", driver, "Y");
				}
				else{
					System.out.println("fail");
					new HTMLReportHelper().HtmlReportBody("Select Change Account from Safe Deposit Box Menu", "Could not select Change Account from  menu", "Failed", driver, "Y");
					System.setProperty("runStep","N");
				}
			}
		}
	}

	public void selectCollateralMenu() throws Exception{
		if (System.getProperty("runStep")=="Y"){
			boolean stepResult = false;
			try {
				if (isElementPresent(collateralMenu)){
					clickOnElement("Home Menu Page", "Collateral field", collateralMenu);
					stepResult = true;
				}	
			}catch (Exception e) {
				e.printStackTrace();
			}
			finally {
				if (stepResult==true){
					System.out.println("Pass");
					new HTMLReportHelper().HtmlReportBody("Select Collateral from Menu", "Menu Collateral selected Successfully", "Passed", driver, "Y");
				}
				else{
					System.out.println("fail");
					new HTMLReportHelper().HtmlReportBody("Select Collateral from Menu", "Could not select Menu Collateral.", "Failed", driver, "Y");
					System.setProperty("runStep","N");
				}
			}
		}
	} 
	public void newCollateralSubMenu() throws Exception{
		if (System.getProperty("runStep")=="Y"){
			boolean stepResult = false;
			try {
				if (isElementPresent(collateralMenu)){
					clickOnElement("Home Menu Page", "New Collateral SubMenu", newCollateral);
					stepResult = true;
				}	
			}catch (Exception e) {
				e.printStackTrace();
			}
			finally {
				if (stepResult==true){
					System.out.println("Pass");
					new HTMLReportHelper().HtmlReportBody("Select New Collateral from Menu", "SubMenu New Collateral selected Successfully", "Passed", driver, "Y");
				}
				else{
					System.out.println("fail");
					new HTMLReportHelper().HtmlReportBody("Select New Collateral from Menu", "Could not select SubMenu New Collateral.", "Failed", driver, "Y");
					System.setProperty("runStep","N");
				}

			}
		}
	} 
}