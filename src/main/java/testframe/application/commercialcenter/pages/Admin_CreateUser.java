package testframe.application.commercialcenter.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import testframe.application.common.CommonLibrary;

/**
 * PageNage : CommercialCenter_Admin_CreateUser
 * 
 * @author Ketki.Badalwar
 */


public class Admin_CreateUser extends CommonLibrary{

	By userID = By.xpath("//input[@id='userId']");
	By firstName = By.xpath("//input[@id='profile.firstname']");
	By lastName = By.xpath("//input[@id='profile.lastname']");
	By administrativeUser = By.xpath("//input[@id='profile.isadmin1']");
	By lockProfileFields = By.xpath("//input[@id='profile.lockProfileFields1']");
	By enableDate = By.xpath("//input[@name='datepicker_profile.enableDate']");
	By emailAdress = By.xpath("//input[@id='emailAddress']");
	By companyZipAdress = By.xpath("//input[@id='details.detailsNameToValuecompanyZipCode']");
	By mothersMiddleName = By.xpath("//input[@id='details.detailsNameToValuemothersMiddleName']");
	By tempPassword = By.xpath("//input[@id='password']");
	By reEnterPassword = By.xpath("//input[@id='reenterPassword']");
	By saveButton = By.xpath("//button[@id='saveButton']");
	By cancelButton = By.xpath("//button[@id='cancelButton']");
	By testButton = By.xpath("//button[@id='testEmailButton']");
	By createUserTitle = By.xpath("//h1[contains(text(),'Create User')]");
	By encryptedPsw = By.xpath("//input[@id='pdfpassword']");
	By encryptedPsdTitle = By.xpath("//label[text()='Encrypted Report Password']");
	By psdValidationMsg = By.xpath("//span[text()='Your passwords did not match.']");
	
	public Admin_CreateUser(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	

	public void enterUserDetails(String newUserID, String userFirstName, String userLastName, String userEnableDate,
			String userEmailAddress, String comapanyResidesZip, String mothersName, String tempPsd,
			String reEnterTempPsd) {
		boolean stepResult = false;
		try {
			if (isElementPresent(createUserTitle)) {
				if (!newUserID.equals("")) {
					enterText("Create User", "User ID", userID, newUserID);
				}
				if (!userFirstName.equals("")) {
					enterText("Create User", "First Name", firstName, userFirstName);
				}
				if (!userLastName.equals("")) {
					enterText("Create User", "Last Name", lastName, userLastName);
				}
				if (!userEnableDate.equals("")) {
					enterText("Create User", "Enable Date", enableDate, userEnableDate);
				}
				else{
					isElementPresent(enableDate);
				}
				if (!userEmailAddress.equals("")) {
					enterText("Create User", "Email Adress", emailAdress, userEmailAddress);
					clickOnElement("Create User", "TestButton", testButton);
					Thread.sleep(4000);
				}
				if (!comapanyResidesZip.equals("")) {
					waitForPresenceOfElement("Create User", "Company Resides Zip Code", companyZipAdress);
					clearText("Create User", "Company Resides Zip Code", companyZipAdress);
					enterText("Create User", "Company Resides Zip Code", companyZipAdress, comapanyResidesZip);
				}
				if (!mothersName.equals("")) {
					enterText("Create User", "Mother's Middle Name", mothersMiddleName, mothersName);
				}
				if (!tempPsd.equals("")) {
					enterText("Create User", "Temporaray Password", tempPassword, tempPsd);
				}
				if (!reEnterTempPsd.equals("")) {
					enterText("Create User", "Reenter Temporaray Password", reEnterPassword, reEnterTempPsd);
				}
				clickOnElement("Create User", "Save Button", saveButton);
				Thread.sleep(2000);
				clickOnElement("Create User", "Encrypted Password Title", encryptedPsdTitle);
				clickOnElement("Create User", "Save Button", saveButton);
				Thread.sleep(2000);
				if(isElementPresent(psdValidationMsg)){
					enterText("Create User", "Temporaray Password", tempPassword, tempPsd);
					enterText("Create User", "Reenter Temporaray Password", reEnterPassword, reEnterTempPsd);
					clickOnElement("Create User", "Save Button", saveButton);
				}
				stepResult = true;
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (stepResult == true)
				System.out.println("Pass -- createuser");
			else
				System.out.println("fail");
		}

	}
	
	
}
