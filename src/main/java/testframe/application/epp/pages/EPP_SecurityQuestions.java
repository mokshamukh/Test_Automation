package testframe.application.epp.pages;

/**
 * PageName : EPP_SecurityQuestionsPage
 * 
 * @author Shilpa.Thangapalam
 */
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;

import testframe.application.common.CommonLibrary;
import testframe.common.reporting.HTMLReportHelper;

public class EPP_SecurityQuestions extends CommonLibrary {

	public EPP_SecurityQuestions(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
		PageFactory.initElements(new AjaxElementLocatorFactory(driver, 50), this);
	}

	public String eppSecurityPage = "EPP_SecurityPage";

	By securityQuest = By.xpath("//h2[@id='securityQuestionsHeading']");
	By firstSecurityQues = By.xpath("//p[@id='securityQuestionsSubHeading']//../div[1]//label");
	By secondSecurityQues = By.xpath("//p[@id='securityQuestionsSubHeading']//../div[2]//label");
	By firstSecurityAnswer = By.xpath("//p[@id='securityQuestionsSubHeading']//../div[1]//input[@id='newQuestionAns-0']");
	By secondSecurityAnswer = By
			.xpath("//p[@id='securityQuestionsSubHeading']//../div[2]//input[@id='newQuestionAns-1']");
	By submitButton = By.xpath("//button[@id='btnVerifySecurityQuestionsSubmit']");
	By cancelButton = By.xpath("//button[@id='btnVerifySecurityQuestionsCancel']");

	
	public void enterSecurityQuestions(String securityQuestionTD, String securityAnswerTD) {
		boolean stepResult = false;
		try {
			waitForPresenceOfElement(eppSecurityPage, "Security Question", securityQuest);
			isElementPresent(securityQuest);
			String secuirtyQues1 = getElementText(eppSecurityPage, "SecurityQuestion1", firstSecurityQues);
			String secuirtyQues2 = getElementText(eppSecurityPage, "SecurityQuestion2", secondSecurityQues);
			String[] securityQuestionTD_split = securityQuestionTD.trim().split("\\|");
			String[] securityAnswerTD_split = securityAnswerTD.trim().split("\\|");
			for (int i = 0; i < securityQuestionTD_split.length; i++) {
				waitElement(4000);
				if (securityQuestionTD_split[i].equals(secuirtyQues1)) {
					enterText(eppSecurityPage, "SecurityQuestion1", firstSecurityAnswer, securityAnswerTD_split[i]);
				}
				if (securityQuestionTD_split[i].equals(secuirtyQues2)) {
					enterText(eppSecurityPage, "SecurityQuestion2", secondSecurityAnswer, securityAnswerTD_split[i]);
				}
			}			clickOnElement(eppSecurityPage, "SecurityQuestions", submitButton);
			waitElement(5000);
			stepResult = true;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			if (stepResult == true) {
				System.out.println("Pass");
				new HTMLReportHelper().HtmlReportBody("Security_Questions EPP - EPP application", "Security Questions Answered Successfully","Passed", driver, "Y");
			} else {
				System.out.println("fail");
				new HTMLReportHelper().HtmlReportBody("Security_Questions EPP - EPP application","Could not Answer Security Questions Successfully", "Failed", driver, "Y");
			}
		}

	}

}
