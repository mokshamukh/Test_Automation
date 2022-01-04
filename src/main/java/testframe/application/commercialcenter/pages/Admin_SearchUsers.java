package testframe.application.commercialcenter.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import testframe.application.common.CommonLibrary;
import testframe.common.reporting.HTMLReportHelper;


/**
 * PageNage : CommercialCenter_Admin_SearchUsers
 * 
 * @author Ketki.Badalwar
 */

public class Admin_SearchUsers extends CommonLibrary{

	public String adminSearchUsers;
	By searchUserTitle = By.xpath("//h1[text()='Search Users']");
	By userID = By.xpath("//input[@id='userUsername']");
	By destination = By.xpath("//input[@id='destination']");
	By username = By.xpath("//input[@id='userName']");
	By label = By.xpath("//label[text()='Label']/../input[@class='autocomplete ac_input']");
	By showLabel = By.xpath("//input[@id='showLabels']");
	By searchUsersButton = By.xpath("//span[text()='Search Users']");
	By userActionButton = By.xpath("//span[text()='Actions']");
	By userEditButton = By.xpath("//span[text()='Edit']");
	By userCloneButton = By.xpath("//span[text()='Clone User']");
	
	
	public Admin_SearchUsers(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public void searchUser(String userId,String userDestination, String userName,String labelVal,String showLabels) throws Exception {
		boolean stepResult = false;
		try {
			if (isElementPresent(searchUserTitle)) {
				if (!userId.equals("")) {
					enterText("Admin Search User Page", "User ID", userID, userId);
				}
				if (!userDestination.equals("")) {
					enterText("Admin Search User Page", "Destination", destination, userDestination);
				}
				if (!userName.equals("")) {
					enterText("Admin Search User Page", "User Name", username, userName);
				}
				if(!labelVal.equals("")){
					enterText("Admin Search User Page", "Label", label, labelVal);
				}
				if(showLabels.equals("Checked")){
					clickOnElement("Admin Search User Page", "Click Show Lables", showLabel);
				}
				clickOnElement("Admin Search User Page", "Search Companies Button", searchUsersButton);
				stepResult = true;
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (stepResult == true){
				System.out.println("Pass -- search");
				new HTMLReportHelper().HtmlReportBody("Search User CC- Admin application", "User searched Successfully", "Passed", driver, "Y");
			}else{
				System.out.println("fail");
				new HTMLReportHelper().HtmlReportBody("Saerch User CC- Admin application", "Could not search user Successfully", "Passed", driver, "Y");
				}
			
		}
		
	}
	 
	
	public void clickActionButton() throws Exception {
		boolean stepResult = false;
		try {
			if (isElementPresent(userActionButton)) {
				clickOnElement("Admin Search User Page", "Actions Button", userActionButton);
				Thread.sleep(2000);
				stepResult = true;
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (stepResult == true){
				System.out.println("Pass");
				System.out.println("Pass -- search");
				new HTMLReportHelper().HtmlReportBody("Search User CC- Admin application", "click action Successfully", "Passed", driver, "Y");
			}else{
				System.out.println("fail");
				new HTMLReportHelper().HtmlReportBody("Saerch User CC- Admin application", "Could not click action Successfully", "Passed", driver, "Y");
				}
		}
	}
	
	
	public void clickEditButton() throws Exception{
		boolean stepResult = false;
		try {
			waitForPresenceOfElement("Admin Search User Page", "Edit Button", userEditButton);
			clickOnElement("Admin Search User Page", "Edit Button", userEditButton);
			Thread.sleep(2000);
			stepResult = true;
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		finally {
			if (stepResult==true){
				System.out.println("Pass");
				new HTMLReportHelper().HtmlReportBody("Search User CC- Admin application", "click edit Successfully", "Passed", driver, "Y");
			}else{
				System.out.println("fail");
				new HTMLReportHelper().HtmlReportBody("Saerch User CC- Admin application", "Could not click edit Successfully", "Passed", driver, "Y");
				}
			
		}
	}
	

	public void clickCloneButton() throws Exception{
		boolean stepResult = false;
		try {
			waitForPresenceOfElement("Admin Search User Page", "Clone Button", userCloneButton);
			clickOnElement("Admin Search User Page", "Clone Button", userCloneButton);
			Thread.sleep(2000);
			stepResult = true;
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		finally {
			if (stepResult==true){
				System.out.println("Pass");
				new HTMLReportHelper().HtmlReportBody("Search User CC- Admin application", "click clone Successfully", "Passed", driver, "Y");
			}else{
				System.out.println("fail");
				new HTMLReportHelper().HtmlReportBody("Saerch User CC- Admin application", "Could not click clone Successfully", "Passed", driver, "Y");
				}
		}
	}
	
	
}
