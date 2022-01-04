package testframe.application.commercialcenter.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import testframe.application.common.CommonLibrary;

/**
 * PageNage : CommercialCenter_Admin_CloneUser
 * 
 * @author Ketki.Badalwar
 */


public class Admin_CloneUser extends CommonLibrary{

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
	By createUserTitle = By.xpath("//h1[contains(text(),'Clone User')]");
	By encryptedPsw = By.xpath("//input[@id='pdfpassword']");
	By encryptedPsdTitle = By.xpath("//label[text()='Encrypted Report Password']");
	By psdValidationMsg = By.xpath("//span[text()='Your passwords did not match.']");
	
	public Admin_CloneUser(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	

	public void cloneUserDetails(String cloneUserID, String cloneFirstName, String cloneLastName, String cloneEnableDate,
			String cloneEmailAddress, String cloneComapanyResidesZip, String cloneMothersName, String cloneTempPsd,
			String cloneReEnterTempPsd) {
		boolean stepResult = false;
		try {
			if (isElementPresent(createUserTitle)) {
				if (!cloneUserID.equals("")) {
					enterText("Create User", "User ID", userID, cloneUserID);
				}
				if (!cloneFirstName.equals("")) {
					enterText("Create User", "First Name", firstName, cloneFirstName);
				}
				if (!cloneLastName.equals("")) {
					enterText("Create User", "Last Name", lastName, cloneLastName);
				}
				if (!cloneEnableDate.equals("")) {
					enterText("Create User", "Enable Date", enableDate, cloneEnableDate);
				}
				else{
					isElementPresent(enableDate);
				}
				if (!cloneEmailAddress.equals("")) {
					clearText("Create User", "Email Adress", emailAdress);
					enterText("Create User", "Email Adress", emailAdress, cloneEmailAddress);
					clickOnElement("Create User", "TestButton", testButton);
					Thread.sleep(4000);
				}
				if (!cloneComapanyResidesZip.equals("")) {
					waitForPresenceOfElement("Create User", "Company Resides Zip Code", companyZipAdress);
					clearText("Create User", "Company Resides Zip Code", companyZipAdress);
					enterText("Create User", "Company Resides Zip Code", companyZipAdress, cloneComapanyResidesZip);
				}
				if (!cloneMothersName.equals("")) {
					enterText("Create User", "Mother's Middle Name", mothersMiddleName, cloneMothersName);
				}
				if (!cloneTempPsd.equals("")) {
					enterText("Create User", "Temporaray Password", tempPassword, cloneTempPsd);
				}
				if (!cloneReEnterTempPsd.equals("")) {
					enterText("Create User", "Reenter Temporaray Password", reEnterPassword, cloneReEnterTempPsd);
				}
				clickOnElement("Create User", "Save Button", saveButton);
				Thread.sleep(2000);
				clickOnElement("Create User", "Encrypted Password Title", encryptedPsdTitle);
				clickOnElement("Create User", "Save Button", saveButton);
				Thread.sleep(2000);
				if(isElementPresent(psdValidationMsg)){
					enterText("Create User", "Temporaray Password", tempPassword, cloneTempPsd);
					enterText("Create User", "Reenter Temporaray Password", reEnterPassword, cloneReEnterTempPsd);
					clickOnElement("Create User", "Save Button", saveButton);
				}
				stepResult = true;
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (stepResult == true)
				System.out.println("Pass - Clone");
			else
				System.out.println("fail");
		}

	}
	
	
}
