package testframe.application.commercialcenter.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import testframe.application.common.CommonLibrary;
import testframe.common.reporting.HTMLReportHelper;

/**
 * PageNage : CommercialCenter_Admin_EditUser
 * 
 * @author Ketki.Badalwar
 */


public class Admin_EditUser extends CommonLibrary {

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
	By editUserTitle = By.xpath("//h1[contains(text(),'Edit User')]");
	By encryptedPsw = By.xpath("//input[@id='pdfpassword']");
	By encryptedPsdTitle = By.xpath("//label[text()='Encrypted Report Password']");
	By psdValidationMsg = By.xpath("//span[text()='Your passwords did not match.']");
	By verifyUserID = By.xpath("//label[text()='User ID']/../b");
	By verifySuccessUpdateUserMessage = By.xpath("//div[text()='Successfully updated user information']");
	String verifyUser= "//span[contains(text(),'%s')]";

	public Admin_EditUser(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public void editUser(String userID,String editUserID, String userFirstName, String userLastName, String userEnableDate,
			String userEmailAddress, String comapanyResidesZip, String mothersName, String tempPsd,
			String reEnterTempPsd) throws Exception {
		if (System.getProperty("runStep")=="Y"){
			boolean stepResult = false;
			boolean flag = false;
			try {
				if (isElementPresent(editUserTitle)) {
					String userIDtext = getElementText("Edit User", "User ID", verifyUserID);
					if(userIDtext.equalsIgnoreCase(editUserID)){
						flag = true;
					}
					if (!userFirstName.equals("")) {
						clearAndType("Edit User", "First Name", firstName, userFirstName);
					}
					if (!userLastName.equals("")) {
						clearAndType("Edit User", "Last Name", lastName, userLastName);
					}
					if (!userEnableDate.equals("")) {
						clearAndType("Edit User", "Enable Date", enableDate, userEnableDate);
					}
					else{
						isElementPresent(enableDate);
					}
					if (!userEmailAddress.equals("")) {
						enterText("Edit User", "Email Adress", emailAdress, userEmailAddress);
						clickOnElement("Edit User", "TestButton", testButton);
						Thread.sleep(4000);
					}
					if (!comapanyResidesZip.equals("")) {
						waitForPresenceOfElement("Edit User", "Company Resides Zip Code", companyZipAdress);
						clearText("Edit User", "Company Resides Zip Code", companyZipAdress);
						enterText("Edit User", "Company Resides Zip Code", companyZipAdress, comapanyResidesZip);
					}
					if (!mothersName.equals("")) {
						clearAndType("Edit User", "Mother's Middle Name", mothersMiddleName, mothersName);
					}
					if (!tempPsd.equals("")) {
						clearAndType("Edit User", "Temporaray Password", tempPassword, tempPsd);
					}
					if (!reEnterTempPsd.equals("")) {
						clearAndType("Edit User", "Reenter Temporaray Password", reEnterPassword, reEnterTempPsd);
					}
					clickOnElement("Edit User", "Save Button", saveButton);
					Thread.sleep(2000);
					//clickOnElement("Edit User", "Encrypted Password Title", encryptedPsdTitle);
					//clickOnElement("Edit User", "Save Button", saveButton);
					Thread.sleep(2000);
					if(isElementPresent(psdValidationMsg)){
						clearAndType("Edit User", "Temporaray Password", tempPassword, tempPsd);
						clearAndType("Edit User", "Reenter Temporaray Password", reEnterPassword, reEnterTempPsd);
						clickOnElement("Edit User", "Save Button", saveButton);

					}
					if(isElementPresent(getDynamicElement("Edit User",verifyUser,userID))) 
						stepResult = true;

				}
			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				if (stepResult == true && flag== true)
					new HTMLReportHelper().HtmlReportBody("User Details Edit- Admin application", "Edit User Successfully", "Passed", driver, "Y");
				else
					new HTMLReportHelper().HtmlReportBody("User Details Edit- Admin application", "Could not edit user details", "Failed", driver, "Y");
				System.setProperty("runStep","N");
			}
		}

	}


}
