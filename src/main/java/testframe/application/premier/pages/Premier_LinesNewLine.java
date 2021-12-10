package testframe.application.premier.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;

import testframe.application.common.CommonLibrary;
import testframe.common.reporting.HTMLReportHelper;

/**
 * PageNage : PremierLinesNewLine
 * 
 * @author shilpa.thangapalam
 */

public class Premier_LinesNewLine extends CommonLibrary{

	Premier_PortfolioNew premierPortfolioNew;

	public Premier_LinesNewLine(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(new AjaxElementLocatorFactory(driver, 30), this);
		premierPortfolioNew = new Premier_PortfolioNew(driver);
	}

	public By searchTitle2 = By.xpath("//td[contains(text(),'Search')]");
	String search1 = "(//img[@title='Search'])[%s]";
	By newLineHeader = By.xpath("//td[text()='New Line']");
	By newLineTitle = By.xpath("//td[contains(text(),'Search')]");
	By portfolioNumber = By.xpath("//input[@name='Port']");
	By customerPageTitle =  By.xpath("//a[text()='Step 2 - Customer']");
	By custAddress = By.xpath("(//td[contains(text(),'Address:')])[1]/following-sibling::td//select[contains(@name,'RelatedToId')]");
	By nextBtn = By.xpath("//button[text()='Next']");
	By codesPageTitle =  By.xpath("//a[text()='Step 3 - Codes']");
	By financialStatNotify = By.xpath("(//select[contains(@name,'PropStmtNotifCode')])");
	By nextFinDate = By.xpath("(//input[contains(@name,'DateNextPropertyStmt')])");
	By nextReviewDate = By.xpath("(//input[contains(@name,'DateNextLineReview')])");
	By maximumCredit = By.xpath("(//input[contains(@name,'MaximumCredit')])");
	By maximumCreditCode = By.xpath("(//select[contains(@name,'MaximumCreditCode')])");
	By responsibilityCodeButton =  By.xpath("(//input[contains(@name,'ResponsibilityCode')])[3]");
	By finishButton = By.xpath("//button[@value='Finish']");
	By warningHeader = By.xpath("//tr[@class='captionBar']//td[@class='caption-text'][contains(text(),'Warning')]");
	By warningChkBox = By.xpath("(//input[contains(@name,'ResponsibilityCode')])[1]");
	By saveBtn = By.xpath("//*[@title='Save']");
	By linesInquiryTilte = By.xpath("//div[text()='Lines - Line Inquiry']");
	By searchLineNumber = By.xpath("//td[contains(text(),'Line Number:')]/following-sibling::td/input");
	By submitSearch = By.xpath("//button[text()='Submit']");
    By closeScreenImg = By.xpath("//img[contains(@title,'Close')]");
    By productList =  By.xpath("//select[contains(@name,'ProductNumber')]");
    By nextButton = By.xpath("//button[@value='Next']");
	
	
	
	String linesInquiryHeader = "//td[contains(@id,'%s')]";
	String custLineName = "//u[contains(text(),'%s')]";
	String custNameList =  "(//select[contains(@name,'RelatedToIdTMP')])[%s]";
	String relationshipList =  "(//select[contains(@name,'RelationshipCode')])[%s]";
	String eStatementList =  "(//select[contains(@name,'EmailAddrIndicator1')])[%s]";
	String responsibilityCodeList =  "//select[contains(@name,'ResponsibilityCode')]/option[contains(text(),'%s')]";


	public void newLine_CustomerScreen(String sLineName, String sLineRelationship, String sLineStatement, int CustomerCount) throws Exception{
		boolean stepResult = false;
		try {
			if(isElementPresent(customerPageTitle)) {
				selectElementByVisibleText("New Line Page", "Name Field", getDynamicElement("Name Field",custNameList,Integer.toString(CustomerCount)), sLineName);
				Thread.sleep(2000);
				selectElementByVisibleText("New Line Page", "Relationship Field", getDynamicElement("Relationship Field",relationshipList,Integer.toString(CustomerCount)), sLineRelationship);
				Thread.sleep(2000);
				selectElementByVisibleText("New Line Page", "eStatement Field", getDynamicElement("eStatement Field",eStatementList,Integer.toString(CustomerCount)), sLineStatement);
				Thread.sleep(2000);
			
				stepResult = true;
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (stepResult == true) {
				System.out.println("Pass");
				new HTMLReportHelper().HtmlReportBody("Enter Customer Details on New Line Account Customer Screen", "Customer Details entered on New Line Account Customer screen Successfully", "Passed",
						driver, "Y");
			} else {
				System.out.println("fail");
				new HTMLReportHelper().HtmlReportBody("Enter Customer Details on New Line Account Customer Screen", "Could not entered Customer details", "Failed",
						driver, "Y");
			}
		}
		
	}
	public void newLine_CustomerScreen_Search(String sSN,String sLineName, String sLineRelationship, String sLineStatement, int CustomerCount) throws Exception{
		boolean stepResult = false;
		try {
			if(isElementPresent(customerPageTitle)) {
				clickOnElement("New Line Page", "Search Icon", getDynamicElement("Search Icon",search1,Integer.toString(CustomerCount)));
				switchToWindowWithTitleContaining("Name Search");
				driver.switchTo().frame("bottom");
				new Premier_CustomerContact(driver).searchSSN(sSN);
				
				switchToWindowWithTitleContaining("Institution 01 - REPUBLIC BANK UAT");
				driver.switchTo().frame("Main");
				
				selectElementByVisibleText("New Line Page", "Relationship Field", getDynamicElement("Relationship Field",relationshipList,Integer.toString(CustomerCount)), sLineRelationship);
				Thread.sleep(2000);
				selectElementByVisibleText("New Line Page", "eStatement Field", getDynamicElement("eStatement Field",eStatementList,Integer.toString(CustomerCount)), sLineStatement);
				Thread.sleep(2000);
			
				stepResult = true;
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (stepResult == true) {
				System.out.println("Pass");
				new HTMLReportHelper().HtmlReportBody("Enter Customer Details on New Line Account Customer Screen", "Customer Details entered on New Line Account Customer screen Successfully", "Passed",
						driver, "Y");
			} else {
				System.out.println("fail");
				new HTMLReportHelper().HtmlReportBody("Enter Customer Details on New Line Account Customer Screen", "Could not entered Customer details", "Failed",
						driver, "Y");
			}
		}
		
	}
	
	public void newLine_CustomerProductDetails(String sProduct) throws Exception{
		boolean stepResult = false;
		try {
				if(isElementPresent(customerPageTitle)) {
					selectElementByVisibleText("New Loan Page", "Product Field", productList, sProduct);
					Thread.sleep(1000);
					clickOnElement("New Loan Page", "Next Button", nextButton);
					stepResult = true;
				}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (stepResult == true) {
				System.out.println("Pass");
				new HTMLReportHelper().HtmlReportBody("Enter Details on New Note Customer Screen", "Details entered on New Note Customer screen Successfully", "Passed",
						driver, "Y");
			} else {
				System.out.println("fail");
				new HTMLReportHelper().HtmlReportBody("Enter Details on New Note Account Customer Screen", "Could not entered details", "Failed",
						driver, "Y");
			}
		}}
	
	public void newLineAccount_CodesScreen(String sFinancialStatNotify, String sNextFinDate,String sNextReviewDate,
			String sMaximumCredit,String sMaximumCreditCode,String sResponsibilityCode) throws Exception {
		boolean stepResult = false;
		try {
			if(isElementPresent(codesPageTitle)) {
				if(!sFinancialStatNotify.equals("")) {
					selectElementByVisibleText("New Line Codes Page", "Financial Statement Notification Field", financialStatNotify, sFinancialStatNotify);
				}				
				if (!sNextFinDate.equals("")) {
					enterText("New Line Codes Page", "Date Next Financial Statement", nextFinDate, sNextFinDate);
				}
				if (!sNextReviewDate.equals("")) {
					enterText("New Line Codes Page", "Date Next Review", nextReviewDate, sNextReviewDate);
				}
				if (!sMaximumCredit.equals("")) {
					enterText("New Line Codes Page", "Maximum Credit", maximumCredit, sMaximumCredit);
				}
				if (!sMaximumCreditCode.equals("")) {
					selectElementByVisibleText("New Line Codes Page", "Maximum Credit Code", maximumCreditCode, sMaximumCreditCode);
				}
				if (!sResponsibilityCode.equals("")) {
					clickOnElement("New Line Codes Page", "Responsibility Code Button",responsibilityCodeButton);
					Thread.sleep(1000);
					clickOnElement("New Line Codes Page", "Responsibility Code list",getDynamicElement("Responsibility Code list",responsibilityCodeList,sResponsibilityCode));
				}
				stepResult = true;
			  }					
			}catch(Exception e) {
			e.printStackTrace();
		}finally {
			if (stepResult == true) {
				System.out.println("Pass");
				new HTMLReportHelper().HtmlReportBody("Enter details on Codes Screen", "Details Entered on Codes Screen Successfully", "Passed",driver, "Y");
			} else {
				System.out.println("fail");
				new HTMLReportHelper().HtmlReportBody("Enter details on Codes Screen", "Could not entered details on Codes Screen", "Failed",driver, "Y");
			}
			
		     }
		}
	
	
	public void newLinesFinishButton() throws Exception {
		boolean stepResult = false;
		try {
			clickOnElement("New Lines Page", "Finish Button", finishButton);
			waitElement(2000);
			if(isElementPresent(warningHeader)) {
				clickOnElement("New Lines Page", "Warning Checkbox", warningChkBox);
				clickOnElement("New Lines Page", "Save Button", saveBtn);
				waitElement(2000);
				validateTextContains("New Lines Page", "New Line Header", newLineHeader, "New Line");
			}else 
				if (isElementPresent(newLineTitle)) {
					validateTextContains("New Lines Page", "New Line Header", newLineHeader, "New Line");
				}
			driver.switchTo().defaultContent();
			switchToWindowWithTitleContaining("Institution 01 - REPUBLIC BANK UAT");
			stepResult = true;
		}
		catch(Exception e){
			e.printStackTrace();
		}finally {
			if (stepResult == true) {
				System.out.println("Pass");
				new HTMLReportHelper().HtmlReportBody("Click on Finish Button", "Clicked on Finish Button Successfully", "Passed",driver, "Y");
			} else {
				System.out.println("fail");
				new HTMLReportHelper().HtmlReportBody("Click on Finish Button", "Could not clicked on Finish Button", "Failed",driver, "Y");
			}	
		}
	}
	
	
	public void verifyLinesInquiry(String portfolioNo) throws Exception {
		boolean stepResult = false;
		try {
			driver.switchTo().frame("Main");
			if (isElementPresent(linesInquiryTilte)) {
				if (isElementPresent(newLineTitle)) {
					premierPortfolioNew.searchPortfolio(portfolioNo);
					stepResult = true;
				}
			}
		}catch(Exception e){
			e.printStackTrace();
		}finally {
			if (stepResult == true) {
				System.out.println("Pass");
				new HTMLReportHelper().HtmlReportBody("Search and New Line", "Customer Searched on New Line Page Successfully", "Passed",driver, "Y");
			} else {
				System.out.println("fail");
				new HTMLReportHelper().HtmlReportBody("Search and New Line", "Could not Searched Customer Details on New Line Page", "Failed",driver, "Y");
			}	
		}

	}
	
	public void searchLineNumber(String lineNumber) throws Exception{
		boolean stepResult = false;
		try {
			waitElement(3000);
				driver.switchTo().frame("Main");
				if (isElementPresent(newLineTitle)) {
					clickOnElement("Search Line Page", "Line Number", searchLineNumber);
					enterText("Search Portfolio Page", "Line Number", searchLineNumber, lineNumber);
					clickOnElement("Search Line Page", "Submit", submitSearch);
					stepResult = true;
				}	
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (stepResult == true) {
				System.out.println("Pass");
				new HTMLReportHelper().HtmlReportBody("Search Line No", "Search Line Number on Line Inquiry page Successfully", "Passed",
						driver, "Y");
			} else {
				System.out.println("fail");
				new HTMLReportHelper().HtmlReportBody("Search Line No", "Could not Search Line Number on Line Inquiry page Successfully", "Failed",
						driver, "Y");
			}
		}
	}
	
	public void validateDetailsInLineInquiry(String lineNumber,String sLineName) throws Exception {
		boolean stepResult = false;
		try {
				switchToWithinFrameWithName("bottom");
				if(isElementPresent(getDynamicElement("Line Number Header field", linesInquiryHeader, lineNumber))){ 				
					validateTextContains("Line Inquiry" , "Name Field", getDynamicElement("Name Field",custLineName,sLineName), sLineName);
					switchToDefaultContent();
					switchToWithinFrameWithName("Main");
					stepResult = true;
				  }				
			}catch(Exception e) {
				e.printStackTrace();
			}finally {
				if (stepResult==true){
					System.out.println("Pass");
					new HTMLReportHelper().HtmlReportBody("Line Details Validation", "Validated Line Details on Line Inquiry page Successfully", "Passed", driver, "Y");
				}
				else{
					System.out.println("fail");
					new HTMLReportHelper().HtmlReportBody("Line Details Validation", "Could not Validated Line Details on Line Inquiry page" , "Failed", driver, "Y");
				}
			}
	}
	
	public void closeScreen_Image() throws Exception {
        boolean stepResult = false;
        try {
               clickOnElement("Inquiry Page", "Close Button", closeScreenImg);
               Thread.sleep(5000);
               validateElementPresent("Inquiry Page", "Search Title", newLineTitle);
               driver.switchTo().defaultContent();
               switchToWindowWithTitleContaining("Institution 01 - REPUBLIC BANK UAT");
               stepResult = true;
        }
        catch(Exception e){
               e.printStackTrace();
        }finally {
               if (stepResult == true) {
                     System.out.println("Pass");
                     new HTMLReportHelper().HtmlReportBody("Click on Close Button", "Clicked on Close Button Successfully", "Passed",driver, "Y");
               } else {
                     System.out.println("fail");
                     new HTMLReportHelper().HtmlReportBody("Click on Close Button", "Could not clicked on Close Button", "Failed",driver, "Y");
               }      
        }
        
	}


}

