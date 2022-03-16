package testframe.application.premier.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;

import testframe.application.common.CommonLibrary;
import testframe.common.reporting.HTMLReportHelper;
import testframe.common.utilities.DateTimeHelper;
import testframe.common.utilities.ExcelReader;

public class Premier_DepositAccounts extends CommonLibrary {
	public String sAccountNo, tempVar;

	public By searchTitle = By.xpath("//label[text()='Search']");
	public By searchTitle2 = By.xpath("//td[contains(text(),'Search')]");
	public By ssnSearch = By.xpath("//input[@name='TaxID']");
	public By submitSearch = By.xpath("//button[text()='Submit']");
	// public By nameLink =
	// By.xpath("(//a[contains(@id,'SearchType=Name')])[1]");
	public By nameLink = By.xpath("//a[starts-with(@onclick, 'ModalClose')]");
	public By addressLink = By.xpath("(//a[contains(@id,'SearchType=Address')])[1]");
	public By saveButton = By.xpath("//a[contains(@onclick,'Save')]");
	public By saveButton2 = By.xpath("//img[contains(@title,'Save')]");
	public By nextButton = By.xpath("//button[@value='Next']");
	public By finishButton = By.xpath("//button[@value='Finish']");
	public By accountSearch = By.xpath("//td[contains(text(),'Account Number:')]/following-sibling::td/input");
	public By closeScreenImg = By.xpath("//img[contains(@title,'Close')]");
	String search1 = "(//img[@title='Search'])[%s]";

	public By newDDHeader = By.xpath("//td[text()='New Demand Deposit']");
	public By customerPageTitle = By.xpath("//a[text()='Step 2 - Customer']");
	String accountNameList = "(//select[contains(@name,'RelatedToIdTMP')])[%s]";
	String relationshipList = "(//select[contains(@name,'RelationshipCode')])[%s]";
	String eStatementList = "(//select[contains(@name,'EmailAddrIndicator1')])[%s]";
	public By productList = By.xpath("//select[contains(@name,'ProductNumber')]");
	public By codesPageTitle = By.xpath("//a[text()='Step 3 - Codes']");
	public By nextAvailableLink = By.xpath("//u[text()='Next Available']");
	public By accountNumberTextbox = By.xpath(
			"//td[contains(text(),'Account Number:')]/following-sibling::td/input[contains(@id,'AccountNumber')]");
	public By initialDepositTextbox = By.xpath(
			"//td[contains(text(),'Initial Deposit:')]/following-sibling::td/input[contains(@id,'InitialDeposit')]");
	public By responsibilityCodeInput = By.xpath("(//input[contains(@name,'ResponsibilityCode')])[1]");
	public By responsibilityCodeButton = By.xpath("(//input[contains(@name,'ResponsibilityCode')])[3]");
	String responsibilityCodeList = "//select[contains(@name,'ResponsibilityCode')]/option[contains(text(),'%s')]";
	public By accountTitlePrintOptionList = By.xpath("//select[contains(@name,'AccountTitleOption')]");
	public By accountTitleTextbox = By
			.xpath("//td[contains(text(),'Account Title:')]/following-sibling::td/input[contains(@id,'AccountTitle')]");
	// public By depositInquiryHeader = By.xpath("//td[contains(text(),'Demand
	// Deposit')]");
	String depositInquiryHeader = "//td[contains(text(),'%s')]";
	public By productInquiryPage = By.xpath("//td[contains(text(),'Product:')]/following-sibling::td[1]");
	public By portfolioInquiryPage = By.xpath("//td[contains(text(),'Portfolio:')]/following-sibling::td[1]");
	String accountNameInquiryPage = "//td//u[contains(text(),'%s')]";
	String relationshipInquiryPage = "//td[contains(text(),'%s')]";
	String depositChangeHeader = "//a[contains(text(),'%s')]";
	public By warningTextbox = By.xpath("//td[contains(text(),'Warning:')]/following-sibling::td/input[contains(@name,'Warning')]");
	public By statusCodeInput = By.xpath("(//input[contains(@name,'/StatusCode')])[1]");
	public By statusCodeBtn = By.xpath("(//input[contains(@name,'/StatusCode')])[3]");
	String statusCodeDropDown = "//select[contains(@name,'StatusCode')]/option[contains(text(),'%s')]";
	public By statusCodeList = By.xpath("//td[contains(text(),'Status Code:')]/following-sibling::td/select[contains(@name,'/StatusCode')]");
	public By transactionRestrictionCodeInput = By.xpath("(//input[contains(@name,'TranRestrictionCode')])[1]");
	public By transactionRestrictionCodeButton = By.xpath("(//input[contains(@name,'TranRestrictionCode')])[3]");
	String transactionRestrictionCodeList = "//select[contains(@name,'TranRestrictionCode')]/option[contains(text(),'%s')]";
	public By statusDateInput = By.xpath("(//input[contains(@id,'StatusDate')])[1]");
	public By initialDepositInput = By.xpath("//input[contains(@id,'InitialDeposit')]");
	public By warningTellerAlert1Input = By.xpath("(//input[contains(@name,'TellerAlert1')])[2]");
	public By warningTellerAlert1Button = By.xpath("(//input[contains(@name,'TellerAlert1')])[3]");
	String warningTellerAlert1List = "//select[contains(@name,'TellerAlert1')]/option[contains(text(),'%s')]";
	public By warningTellerAlert2Input = By.xpath("(//input[contains(@name,'TellerAlert2')])[2]");
	public By warningTellerAlert2Button = By.xpath("(//input[contains(@name,'TellerAlert2')])[3]");
	String warningTellerAlert2List = "//select[contains(@name,'TellerAlert2')]/option[contains(text(),'%s')]";
	public By warningTellerAlert3Input = By.xpath("(//input[contains(@name,'TellerAlert3')])[2]");
	public By warningTellerAlert3Button = By.xpath("(//input[contains(@name,'TellerAlert3')])[3]");
	String warningTellerAlert3List = "//select[contains(@name,'TellerAlert3')]/option[contains(text(),'%s')]";
	public By statementCycleList = By.xpath("//td[contains(text(),'Statement Cycle:')]/following-sibling::td/select[contains(@name,'/StatementCycle')]");
	public By alternateCycleOptionList = By.xpath("//td[contains(text(),'Alternate Cycle Option:')]/following-sibling::td/select[contains(@name,'/AlternateCycleOption')]");
	public By alternateCycleTextInput = By.xpath("(//input[contains(@id,'AlternateCycle')])[1]");
	public By alternateCycleInput = By.xpath("(//input[contains(@id,'AlternateCycle')])[2]");
	public By alternateCycleBtn = By.xpath("(//input[contains(@id,'AlternateCycle')])[3]");
	String alternateCycleList = "(//select[contains(@id,'AlternateCycle')])[2]/option[contains(text(),'%s')]";
	public By notificationOptionList = By.xpath("//td[contains(text(),'Notification Option:')]/following-sibling::td/select[contains(@name,'NotificationCode')]");
	public By sStatementRequestCodeList = By.xpath("//td[contains(text(),'Statement Request Code:')]/following-sibling::td/select[contains(@name,'StatementRequestCode')]");
	public By suspendedInterestList = By.xpath("//td[contains(text(),'Interest Cycle:')]/following-sibling::td/select[contains(@name,'SuspendInterestCycle')]");
	public By suspendedDepositRateIndexInput = By.xpath("(//input[contains(@id,'SuspendDepRateCode')])[2]");
	public By suspendedDepositRateIndexTextInput = By.xpath("(//input[contains(@id,'SuspendDepRateCode')])[1]");
	public By suspendedDepositRateIndexBtn = By.xpath("(//input[contains(@id,'SuspendDepRateCode')])[3]");
	String suspendedDepositRateIndexList = "//select[contains(@id,'SuspendDepRateCode')]/option[contains(text(),'%s')]";
	public By suspendedStatementCycleList = By.xpath("//select[contains(@id,'SuspendStatementCycle')]");
	public By codesTab = By.xpath("//li//a[text()='Codes']");
	public By balanceTab = By.xpath("//li//a[text()='Balances']");
	public By statusCodeInquiryPage = By.xpath("//td[text()='Status Code:']/following-sibling::td[1]");
	public By initialDepositInquiryPage = By.xpath("//td[text()='Initial Deposit:']/following-sibling::td[1]");
	public By statusDateInquiryPage = By.xpath("//td[text()='Status Date:']/following-sibling::td[1]");
	public By statementCycleInquiryPage = By.xpath("//td[text()='Statement Cycle:']/following-sibling::td[1]");
	public By expandWarningInquiryPage = By.xpath("//img[@id='WarningsArrow']");
	public By warningInquiryPage = By.xpath("//table[@name='Warnings']//td[contains(text(),'Warning:')]");
	String warningtellerAlertInquiryPage = "//table[@name='Warnings']/tbody//td[contains(text(),'%s')]";
	public By transRestrictionCodeInquiryPage = By.xpath("//table[@name='Warnings']//td[contains(text(),'Transaction Restriction Code:')]");
	public By suspendFieldCheckBox = By.xpath("//tr[@class='dataRow']//td//u[contains(text(),'Suspend Fields will be Cleared')]/../..//input");
	public By fileMenu = By.xpath("//a[text()='File']");
	public By holdMenu = By.xpath("//a[contains(text(),'Hold')]");
	public By holdMenuBalances = By.xpath("(//a[contains(text(),'Hold')])[2]");
	public By holdTitle = By.xpath("//a[contains(text(),'Hold - ')]");
	public By holdReason = By.xpath("//input[contains(@id,'HoldReason')]");
	public By holdAMount = By.xpath("//input[contains(@id,'HoldAmount')]");
	public By holdExpDate = By.xpath("//input[contains(@id,'ExpirationDate')]");
	public By accountPledgedOnLoanSelect = By.xpath("//select[contains(@id,'PledgedCode')]");
	public By pledgedNoteNum = By.xpath("//input[contains(@id,'NoteNumber')]");
	public By maxPledge = By.xpath("//input[contains(@id,'MaximumPledgedAmount')]");
	public By holdDate = By.xpath("//input[contains(@id,'HoldDate')]");
	public By holdPendigStrtDate = By.xpath("//input[contains(@id,'PendingHoldDate')]");
	public By holdPendingAmt = By.xpath("//input[contains(@id,'PendingHoldAmount')]");
	public By holdAmtOption = By.xpath("//select[contains(@id,'HoldAmountOption')]");
	public By holdslabel = By.xpath("//td[text()='Holds']");
	public By holdExpand = By.xpath("//table[@name='Holds']//img[@class='csr-hand']");
	public By ticklerMenu = By.xpath("//a[contains(text(),'Tickler')]");
	public By ticklerTitle = By.xpath("//a[contains(text(),'Tickler - New')]");
	public By ticklerDecription = By.xpath("//input[contains(@id,'Description')]");
	public By ticklerAdditionalMsg = By.xpath("//input[contains(@id,'AdditionalMessage')]");
	public By ticklerNextDate = By.xpath("//input[contains(@id,'NextTicklerDate')]");
	public By ticklerFrequencyList = By.xpath("//select[contains(@id,'RecurringFrequency')]");
	public By ticklerExpDate = By.xpath("//input[contains(@id,'ExpirationDate')]");
	public By activityMenu = By.xpath("//a[text()='Activity']");
	public By ticklerlabel = By.xpath("//td[text()='Ticklers']");
	String verifyHoldData = "//table[@name='Holds']//td[contains(text(),'%s')]";
	String ticklerExpand = "//table[@name='Ticklers']//td[text()='%s']//..//img";
	// public By ticklerExpand =
	// By.xpath("//table[@name='Ticklers']//img[@class='csr-hand']");
	String verifyTicklerData = "//table[@name='Ticklers']//td[contains(text(),'%s')]";

	public By overdraftsMenu = By.xpath("//a[text()='Overdrafts']");
	public By overdraftsSectionLabel = By.xpath("(//a[text()='Overdrafts'])[2]");
	public By overdraftLimit = By.xpath("//input[contains(@id,'OverdraftLimit')]");
	public By overdraftLimitPriorityList = By.xpath("//select[contains(@id,'OverdraftLimitPriority')]");
	public By ddBaseAccount = By.xpath("//input[contains(@id,'BaseAccount')]");
	String warningsCheckbox = "(//table[@class='advisoryTable']//input[@type='checkbox'])[%s]";
	public By warningsCheckbox_1 = By.xpath("//table[@class='advisoryTable']//input[@type='checkbox']");
	public By overdraftslabel = By.xpath("//td[text()='Overdrafts']");
	String verifyOverdraftsData = "//table[@name='Overdrafts']//td[contains(text(),'%s')]";

	public By newStopPayAddImg = By.xpath("//img[@alt='New']");
	public By stopPayMenu = By.xpath("//a[contains(text(),'Stop Pay')]");
	public By transferMenu = By.xpath("//a[contains(text(),'Transfer')]");
	public By transferMenuActivity = By.xpath("(//a[contains(text(),'Transfer')])[2]");
	public By stopPaysMenuActivity = By.xpath("(//a[contains(text(),'Stop Pays')])[1]");
	public By transferTitle = By.xpath("//a[contains(text(),'Transfer - ')]");
	public By stopPaysTitle = By.xpath("//a[(text()='Stop Pay')]");
	public By beneficiaryMenu = By.xpath("//a[contains(text(),'Beneficiary')]");
	public By beneficiaryMenu2 = By.xpath("(//a[contains(text(),'Beneficiary')])[2]");
	public By analysisItemsMenu = By.xpath("//a[contains(text(),'Analysis Items')]");
	public By stopPayLabel = By.xpath("//a[text()='Stop Pay - New']");
	public By transferLabel = By.xpath("//a[contains(text(),'Transfer - New')]");
	public By beneficiaryLabel = By.xpath("//a[contains(text(),'Beneficiary - ')]");
	public By stopPayTypeInput = By.xpath("(//input[contains(@id,'ItemType')])[2]");
	public By stopPayTypeSelect = By.xpath("(//input[contains(@id,'ItemType')])[3]");
	String stopPayTypeList = "//select[contains(@id,'ItemType')]/option[contains(text(),'%s')]";
	public By stopPayItemDescription = By.xpath("//input[contains(@id,'ItemTypeDescription')]");
	public By stopPayDate = By.xpath("(//input[contains(@id,'StopItemDate')])[1]");
	public By stopPayItemDate = By.xpath("(//input[contains(@id,'ItemDate')])[2]");
	public By stopPayExpireDate = By.xpath("//input[contains(@id,'ExpirationDate')]");
	public By stopPayFromNum = By.xpath("//input[contains(@id,'FromNumber')]");
	public By stopPayThruNum = By.xpath("//input[contains(@id,'ThruNumber')]");
	public By stopPayFromAmt = By.xpath("//input[contains(@id,'FromAmount')]");
	public By stopPayThruAmt = By.xpath("//input[contains(@id,'ThruAmount')]");
	public By stopPayFromTransCode = By.xpath("//input[contains(@id,'FromTranCode')]");
	public By stopPayThruTransCode = By.xpath("//input[contains(@id,'ThruTranCode')]");
	public By stopPayACHCompanyID = By.xpath("//input[contains(@id,'AchCompanyId')]");
	public By stopPayPayee = By.xpath("//input[contains(@id,'Payee')]");
	public By stopPayPayeeReason = By.xpath("//input[contains(@id,'Reason')]");
	public By stopPayPayeeComments = By.xpath("//input[contains(@id,'Comments')]");
	public By stopPayInquirylabel = By.xpath("//td[text()='Stop Pays']");
	public By transferInquirylabel = By.xpath("//td[contains(text(),'Transfer To')]");
	public By beneficiaryInquirylabel = By.xpath("(//td[contains(text(),'Beneficiary Addenda')])[1]");
	String verifyStopPayData = "//table[@name='Stop Pays']//td[contains(text(),'%s')]";
	String expandStopPayInquiry = "//table[@name='Stop Pays']//td[contains(text(),'%1$s')]/following-sibling::td[text()='%2$s']//..//img";

	public By relationshipTab = By.xpath("//li//a[text()='Relationships']");
	public By searchIconName = By.xpath("(//img[@title='Search'])[1]");
	String relationshipAddName = "//u[text()='%s']/../../td/select[contains(@id,'RelationshipCode')]";
	String newName = "(//td[contains(text(),'Name:')]/following-sibling::td/select[contains(@name,'RelatedToIdTMP')])[%s]";
	String newEstatement = "(//td[contains(text(),'Name:')]/following-sibling::td/select[contains(@name,'EmailAddrIndicator1')])[%s]";
	String newNameInquiryPage = "//table[@name='Relationships']//u[text()='%s']";
	String updateName = "//b[text()='Name']/../../..//u[text()='%s']";
	String newNameRelationshipInquiryPage = "//table[@name='Relationships']//u[text()='%s']/../../td[10]";
	By warningHeader = By.xpath("//tr[@class='captionBar']//td[@class='caption-text'][contains(text(),'Warning')]");
	By warning1 = By.xpath("//td/u[contains(text(),'Note Date is in the Future')]");
	By warningCheckBox1 = By.xpath("//td/u[contains(text(),'Note Date is in the Future')]/../..//input");
	By warning2 = By.xpath("//td/u[contains(text(),'One Payment in Schedule with Payment Frequency')]");
	By warningCheckBox2 = By.xpath("//td/u[contains(text(),'One Payment in Schedule with Payment Frequency')]/../..//input");
	By warning3 = By.xpath("//td/u[contains(text(),'Branch Region Does Not Match Portfolio Branch Region')]");
	By warningCheckBox3 = By.xpath("//td/u[contains(text(),'Branch Region Does Not Match Portfolio Branch Region')]/../..//input");
	By warning4 = By.xpath("//td/u[contains(text(),'Verify Non-Accrual Late Charge Option')]");
	By warningCheckBox4 = By.xpath("//td/u[contains(text(),'Verify Non-Accrual Late Charge Option')]/../..//input");
	//By saveBtn = By.xpath("//*[@title='Save']");
	By maturityTab = By.xpath("//li/a[text()='Maturity']");
	By maturityLabel = By.xpath("//td/a[text()='Maturity']");
	By maturityDate = By.xpath("//input[contains(@id,'MaturityDate')]");
	By maturityTerm = By.xpath("(//input[contains(@id,'Term')])[1]");
	By maturityTermCodeList = By.xpath("//select[contains(@id,'TermCode')]");
	By maturityInitialDeposit = By.xpath("//input[contains(@id,'InitialDeposit')]");
	By maturityIssueDate = By.xpath("//input[contains(@id,'OrigIssueDate')]");
	By maturityContractDateList = By.xpath("//select[contains(@id,'ContractCode')]");
	By maturityRateDateList = By.xpath("//select[contains(@id,'MaturityRateCode')]");
	public By dateLastRolloverInput = By.xpath("//input[contains(@id,'IraDateLastRollover')]");
	public By iRAPlanInput = By.xpath("(//input[contains(@name,'IraTypeCode')])[1]");
	public By iRAPlanButton = By.xpath("(//input[contains(@name,'IraTypeCode')])[3]");
	String iRAPlanList = "//select[contains(@name,'IraTypeCode')]/option[contains(text(),'%s')]";
	public By iRAStatusCodeList = By.xpath("//select[contains(@id,'IraStatusCode')]");
	public By iRADefaultContributionCodeList = By.xpath("//select[contains(@id,'IraDefContributionCode')]");
	public By iRADefaultDistributionCodeList = By.xpath("//select[contains(@id,'IraDefDistributionCode')]");
	public By iRAPlanInquiryPage = By.xpath("//td[text()='IRA Plan:']/following-sibling::td[1]");
	public By iRAStatusCodeInquiryPage = By.xpath("//td[text()='IRA Status Code:']/following-sibling::td[1]");
	public By iRADefaultContributionCodeInquiryPage = By.xpath("//td[text()='IRA Default Contribution Code:']/following-sibling::td[1]");
	public By iRADefaultDistributionCodeInquiryPage = By.xpath("//td[text()='IRA Default Distribution Code:']/following-sibling::td[1]");
	String verifyMaturityData = "//table[@name='Maturity']//td[contains(text(),'%s')]";	
	String removeNameIcon = "//u[text()='%s']/../../td/img[contains(@title,'Delete')]";
	public By changeProductImg = By.xpath("//td[contains(text(),'Product:')]/../td/img");
	public By selectProductTitle = By.xpath("//a[text()='Step 1 - Select Product']");
	public By reviewDefaultsTitle = By.xpath("//a[text()='Step 2 - Review Defaults']");
	public By classCheckbox = By.xpath("//input[contains(@id,'ClassCode')]");
	public By checkAllLink = By.xpath("//td/u[text()='Check All']");	
	String changeProductField = "//td/u[text()='%s']";
	public By changePortfolioImg = By.xpath("//td[contains(text(),'Portfolio:')]/../td/img");
	public By changePortfolioTitle = By.xpath("//td[text()='Change Portfolio']");
	public By portfolioNoInput = By.xpath("//td[text()='Portfolio Number:']/../td/input");
	public By addChargeTitle = By.xpath("//a[text()='Add Charge']");
	public By selectChargeList = By.xpath("//select[@id='SelectChargeAnalysis']");
	public By recurringfrequencyList = By.xpath("//select[contains(@id,'RecurringFrequency')]");
	public By itemTypeList = By.xpath("//select[contains(@id,'ItemType')]");
	public By creditBackOverrideList = By.xpath("//select[contains(@id,'CreditBackOverride')]");
	public By perItemAmountInput = By.xpath("//input[contains(@id,'PerItemAmount')]");
	public By refreshOptionList = By.xpath("//select[contains(@id,'RefreshOption')]");
	public By transDateInput = By.xpath("//input[contains(@id,'TranDate')]");
	public By transQuantityInput = By.xpath("//input[contains(@id,'Quantity')]");
	public By transTotalAmountInput = By.xpath("//input[contains(@id,'TotalAmount')]");
	public By serviceChargeCycleList = By.xpath("//select[contains(@id,'ServiceChargeCycle')]");
	public By analysisHeaderBar = By.xpath("(//td/a[contains(text(),'Analysis')])[1]");
	String selectChargeInquiryPage = "//td[text()='Description']/../following-sibling::tr/td[text()='%s']";
	public By serviceChargeCycleInquiryPage = By.xpath("//td[text()='Service Charge Cycle:']/following-sibling::td[1]");
	public By branchRegionTextbox =  By.xpath("(//input[contains(@id,'BranchNumber')])[1]");
	public By branchRegionButton =  By.xpath("(//input[contains(@id,'BranchNumber')])[3]");
	String branchRegionList =  "//select[contains(@id,'BranchNumber')]/option[contains(text(),'%s')]";
	public By accountMethodList =  By.xpath("//select[contains(@id,'AccountingMethod')]");
	public By costCenterInput =  By.xpath("//input[contains(@id,'CostCenter')]");
	public By retentionCodeOverrideList =  By.xpath("//select[contains(@id,'RetentionCodeOverride')]");
	public By accountOpenMethodTextbox =  By.xpath("(//input[contains(@id,'AccountOpenMethod')])[1]");
	public By accountOpenMethodButton =  By.xpath("(//input[contains(@id,'AccountOpenMethod')])[3]");
	String accountOpenMethodList =  "//select[contains(@id,'AccountOpenMethod')]/option[contains(text(),'%s')]";
	public By branchRegionInquiryPage = By.xpath("//td[text()='Branch Region:']/following-sibling::td[1]");
	public By accountingMethodInquiryPage = By.xpath("//td[text()='Accounting Method:']/following-sibling::td[1]");
	public By costCenterInquiryPage = By.xpath("//td[text()='Cost Center:']/following-sibling::td[1]");
	public By retentionCodeOverrideInquiryPage = By.xpath("//td[text()='Retention Code Override:']/following-sibling::td[1]");
	public By accountOpenedMethodInquiryPage = By.xpath("//td[text()='Account Opened Method:']/following-sibling::td[1]");
	public By depositRateIndexTextbox =  By.xpath("(//input[contains(@id,'DepositRateCode')])[1]");
	public By depositRateIndexButton =  By.xpath("(//input[contains(@id,'DepositRateCode')])[3]");
	String depositRateIndexList =  "//select[contains(@id,'DepositRateCode')]/option[contains(text(),'%s')]";
	public By interestCycleList =  By.xpath("//select[contains(@id,'InterestCycle')]");
	public By depositRateIndexTextboxSavings =  By.xpath("(//input[contains(@id,'RateIndex')])[1]");
	public By depositRateIndexButtonSavings =  By.xpath("(//input[contains(@id,'RateIndex')])[3]");
	String depositRateIndexListSavings =  "//select[contains(@id,'RateIndex')]/option[contains(text(),'%s')]";
	public By interestCycleListSavings =  By.xpath("//select[contains(@id,'IntCycle')]");
	public By depositRateIndexInquiryPage = By.xpath("//td[text()='Deposit Rate Index:']/following-sibling::td[1]");
	public By interestCycleInquiryPage = By.xpath("//td[text()='Interest Cycle:']/following-sibling::td[1]");
	public By nextTransferDateInput = By.xpath("//input[contains(@id,'NextTransferDate')]");
	public By nextTransferAmountInput = By.xpath("//input[contains(@id,'NextTransferAmount')]");
	public By creditToTypeList = By.xpath("//select[contains(@id,'CreditToType')]");
	public By creditToAccountInput = By.xpath("//input[contains(@id,'CreditToAccount')]");
	public By expirationDateInput = By.xpath("//input[contains(@id,'ExpirationDate')]");
	public By transferFrequencyList = By.xpath("//select[contains(@id,'TransferFrequency')]");
	public By transferDayInput = By.xpath("//input[contains(@id,'TransferDay')]");
	public By transferCycleList = By.xpath("//select[contains(@id,'TransferCycle')]");
	public By notificationCodeList = By.xpath("//select[contains(@id,'NotificationCode')]");
	public By nextTransferDateInquiryPage = By.xpath("//td[text()='Next Transfer Date:']/following-sibling::td[1]");
	public By nextTransferAmountInquiryPage = By.xpath("//td[text()='Next Transfer Amount:']/following-sibling::td[1]");
	String creditToAccountNo = "//td[contains(text(),'%s')]";
	String stopPayeeName = "//td[contains(text(),'%s')]";
	String creditToAccountNoTransfer = "//input[contains(@value,'%s')]"; 
	public By expirationDateInquiryPage = By.xpath("//td[text()='Expiration Date:']/following-sibling::td[1]");
	public By transferFrequencyInquiryPage = By.xpath("//td[text()='Transfer Frequency:']/following-sibling::td[1]");
	public By transferDayInquiryPage = By.xpath("//td[text()='Transfer Day:']/following-sibling::td[1]");
	public By notificationCodeInquiryPage = By.xpath("//td[text()='Notification Code:']/following-sibling::td[1]");
	public By beneRelationsipInput = By.xpath("//input[contains(@id,'Relationship')]");
	public By benePercentInput = By.xpath("//input[contains(@id,'BeneficiaryPercentage')]");
	public By searchNameImg =  By.xpath("//img[@title='Search']");
	public By searchAddress =  By.xpath("//img[@title='Search For Address']");
	public By beneficiarySSNInquiryPage = By.xpath("//tr[contains(@name,'Beneficiary Addenda')]/../../following-sibling::table//td[text()='Tax Identification Number:']/following-sibling::td[1]");
	public By beneficiaryPercentInquiryPage = By.xpath("//td[text()='Beneficiary Percent:']/following-sibling::td[1]");
	public By beneficiaryRelationshipInquiryPage = By.xpath("//td[text()='Beneficiary Relationship:']/following-sibling::td[1]");
	String beneAddress = "//tr/td[text()='%s']";
	String removeHoldICon = "//a[contains(text(),'%s')]/../../td/img[@title='Delete']";
	String removeTransferICon = "//a[contains(text(),'%s')]/../../td/img[@title='Delete']";
	String removeStopPayICon = "//td[contains(text(),'%s')]/../td/img[@title='Delete']";
	
	public Premier_DepositAccounts(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(new AjaxElementLocatorFactory(driver, 30), this);
	}

	public void newDepositAccount_CustomerScreen(String sName, String sDepositRelationship, String sDepositStatement,
			int CustomerCount) throws Exception {
		if (System.getProperty("runStep") == "Y") {
			boolean stepResult = false;
			try {
				if (isElementPresent(customerPageTitle)) {
					selectElementByVisibleText("New Deposit Page", "Name Field",
							getDynamicElement("Name Field", accountNameList, Integer.toString(CustomerCount)), sName);
					Thread.sleep(2000);
					selectElementByVisibleText("New Deposit Page", "Relationship Field",
							getDynamicElement("Relationship Field", relationshipList, Integer.toString(CustomerCount)),
							sDepositRelationship);
					Thread.sleep(2000);
					selectElementByVisibleText("New Deposit Page", "eStatement Field",
							getDynamicElement("eStatement Field", eStatementList, Integer.toString(CustomerCount)),
							sDepositStatement);
					Thread.sleep(2000);
					stepResult = true;
				}
			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				if (stepResult == true) {
					System.out.println("Pass");
					new HTMLReportHelper().HtmlReportBody(
							"Enter Customer Details on New Deposit Account Customer Screen",
							"Customer Details entered on New Deposit Account Customer screen Successfully", "Passed",
							driver, "Y");
				} else {
					System.out.println("fail");
					new HTMLReportHelper().HtmlReportBody(
							"Enter Customer Details on New Deposit Account Customer Screen",
							"Could not entered Customer details", "Failed", driver, "Y");
					System.setProperty("runStep", "N");
				}
			}
		}
	}

	public void newDepositAccount_CustomerScreenSearch(String sSN, String sName, String sDepositRelationship,
			String sDepositStatement, int CustomerCount) throws Exception {
		if (System.getProperty("runStep") == "Y") {
			boolean stepResult = false;
			try {
				if (isElementPresent(customerPageTitle)) {
					clickOnElement("New Deposit Page", "Search Icon",
							getDynamicElement("Search Icon", search1, Integer.toString(CustomerCount)));
					switchToWindowWithTitleContaining("Name Search");
					driver.switchTo().frame("bottom");
					new Premier_CustomerContact(driver).searchSSN(sSN);

					switchToWindowWithTitleContaining("Institution");
					driver.switchTo().frame("Main");

					selectElementByVisibleText("New Deposit Page", "Relationship Field",
							getDynamicElement("Relationship Field", relationshipList, Integer.toString(CustomerCount)),
							sDepositRelationship);
					Thread.sleep(2000);
					selectElementByVisibleText("New Deposit Page", "eStatement Field",
							getDynamicElement("eStatement Field", eStatementList, Integer.toString(CustomerCount)),
							sDepositStatement);
					Thread.sleep(2000);
					stepResult = true;
				}
			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				if (stepResult == true) {
					System.out.println("Pass");
					new HTMLReportHelper().HtmlReportBody("Search Customer on New Deposit Account Customer Screen",
							"Customer Details Searched on New Deposit Account Customer screen Successfully", "Passed",
							driver, "Y");
				} else {
					System.out.println("fail");
					new HTMLReportHelper().HtmlReportBody("Search Customer on New Deposit Account Customer Screen",
							"Could not Searched Customer details", "Failed", driver, "Y");
					System.setProperty("runStep", "N");
				}
			}
		}
	}

	public void newDepositAccount_CustomerScreenDetails(String sProduct) throws Exception {
		if (System.getProperty("runStep") == "Y") {
			boolean stepResult = false;
			try {
				if (isElementPresent(customerPageTitle)) {
					selectElementByVisibleText("New Deposit Page", "Product Field", productList, sProduct);
					Thread.sleep(1000);
					clickOnElement("New Deposit Page", "Next Button", nextButton);
					stepResult = true;
				}
			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				if (stepResult == true) {
					System.out.println("Pass");
					new HTMLReportHelper().HtmlReportBody("Enter Details For New Deposit Account",
							"Details entered on New Deposit Account Successfully", "Passed", driver, "Y");
				} else {
					System.out.println("fail");
					new HTMLReportHelper().HtmlReportBody("Enter Details For New Deposit Account ",
							"Could not entered details", "Failed", driver, "Y");
					System.setProperty("runStep", "N");
				}
			}
		}
	}

	public void newDepositAccount_CodesScreen(String sDepositAccntNo, String sInitialDeposit,
			String sResponsibilityCode, String sAccountTitlePrintOption, String sAccountTitle, String excelFilePath,
			String sheetName, int rowNo) throws Exception {
		if (System.getProperty("runStep") == "Y") {
			boolean stepResult = false;
			try {
				if (isElementPresent(codesPageTitle)) {

					if (!sDepositAccntNo.equals("")) {
						enterText("New Deposit Account Page", "Account Number", accountNumberTextbox, sDepositAccntNo);
					}
					if (!sInitialDeposit.equals("")) {
						enterText("New Deposit Account Page", "Initial Deposit Type", initialDepositTextbox,
								sInitialDeposit);
					}
					if (!sResponsibilityCode.equals("")) {
						clickOnElement("New Deposit Account Page", "Responsibility Code Button",
								responsibilityCodeButton);
						Thread.sleep(1000);
						clickOnElement("New Deposit Account Page", "Responsibility Code list", getDynamicElement(
								"Responsibility Code list", responsibilityCodeList, sResponsibilityCode));
					}
					if (!sAccountTitlePrintOption.equals("")) {
						selectElementByVisibleText("New Deposit Account Page", "Account Title Print Option Field",
								accountTitlePrintOptionList, sAccountTitlePrintOption);
					}
					if (!sAccountTitle.equals("")) {
						enterText("New Deposit Account Page", "Account Title Code", accountTitleTextbox, sAccountTitle);
					}
					waitElement(5000);
					stepResult = true;
				}
			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				if (stepResult == true) {
					System.out.println("Pass");
					new HTMLReportHelper().HtmlReportBody("Enter details on Codes Screen",
							"Details Entered on Codes Screen Successfully", "Passed", driver, "Y");
				} else {
					System.out.println("fail");
					new HTMLReportHelper().HtmlReportBody("Enter details on Codes Screen",
							"Could not entered details on Codes Screen", "Failed", driver, "Y");
					System.setProperty("runStep", "N");
				}
			}
		}
	}

	public void depositFinishButton() throws Exception {
		if (System.getProperty("runStep") == "Y") {
			boolean stepResult = false;
			try {
				clickOnElement("New Deposit Page", "Finish Button", finishButton);
				Thread.sleep(5000);
				validateElementPresent("New Deposit Page", "Search Title", searchTitle2);
				driver.switchTo().defaultContent();
				// switchToWindowWithTitleContaining("Institution");
				stepResult = true;

			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				if (stepResult == true) {
					System.out.println("Pass");
					new HTMLReportHelper().HtmlReportBody("Click on Finish Button",
							"Clicked on Finish Button Successfully", "Passed", driver, "Y");
				} else {
					System.out.println("fail");
					new HTMLReportHelper().HtmlReportBody("Click on Finish Button",
							"Could not clicked on Finish Button", "Failed", driver, "Y");
					System.setProperty("runStep", "N");
				}
			}
		}
	}

	public void searchAccount(String accountNo) throws Exception {
		if (System.getProperty("runStep") == "Y") {
			boolean stepResult = false;
			try {
				waitElement(6000);
				driver.switchTo().frame("Main");
				if (isElementPresent(searchTitle2)) {
					clickOnElement("Search Account Page", "Account Number", accountSearch);
					enterText("Search Account Page", "Account Number", accountSearch, accountNo);
					clickOnElement("Search Account Page", "Submit", submitSearch);
					stepResult = true;
				}
			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				if (stepResult == true) {
					System.out.println("Pass");
					new HTMLReportHelper().HtmlReportBody("Search Account",
							"Search Account on Account page Successfully", "Passed", driver, "Y");
				} else {
					System.out.println("fail");
					new HTMLReportHelper().HtmlReportBody("Search Account",
							"Could not Search Account on Account page Successfully", "Failed", driver, "Y");
					System.setProperty("runStep", "N");
				}
			}
		}
	}

	public void validateAccountDetails(String sAccountNumber, String customerName, String sCustomerRelationship,
			String sProduct) throws Exception {

		boolean stepResult = false;
		try {
			switchToWithinFrameWithName("bottom");
			if (isElementPresent(
					getDynamicElement("Account Number Header field", depositInquiryHeader, sAccountNumber))) {
				validateTextContains("Account Inquiry", "Name field",
						getDynamicElement("Name field", accountNameInquiryPage, customerName), customerName);
				validateTextContains("Account Inquiry", "Relationship field",
						getDynamicElement("Relationship field", relationshipInquiryPage, sCustomerRelationship),
						sCustomerRelationship);
				// validateTextContains("Account Inquiry" , "Product field",
				// productInquiryPage, sProduct);
				switchToDefaultContent();
				driver.switchTo().frame("Main");
				stepResult = true;

			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (stepResult == true) {
				System.out.println("Pass");
				new HTMLReportHelper().HtmlReportBody("Account Details Validation",
						"Validated Customer Details on Customer Inquiry page Successfully", "Passed", driver, "Y");
			} else {
				System.out.println("fail");
				new HTMLReportHelper().HtmlReportBody("Customer Details Validation",
						"Could not Validated Customer Details on Customer Inquiry page", "Failed", driver, "Y");

			}

		}
	}

	public void closeScreen_Image() throws Exception {
		if (System.getProperty("runStep") == "Y") {
			boolean stepResult = false;
			try {
				clickOnElement("Inquiry Page", "Close Button", closeScreenImg);
				Thread.sleep(5000);
				validateElementPresent("Inquiry Page", "Search Title", searchTitle2);
				driver.switchTo().defaultContent();
				switchToWindowWithTitleContaining("Institution");
				stepResult = true;

			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				if (stepResult == true) {
					System.out.println("Pass");
					new HTMLReportHelper().HtmlReportBody("Click on Close Button",
							"Clicked on Close Button Successfully", "Passed", driver, "Y");
				} else {
					System.out.println("fail");
					new HTMLReportHelper().HtmlReportBody("Click on Close Button", "Could not clicked on Close Button",
							"Failed", driver, "Y");
					System.setProperty("runStep", "N");
				}
			}
		}
	}

	public void saveButton() throws Exception {
		if (System.getProperty("runStep") == "Y") {
			boolean stepResult = false;
			try {
				clickOnElement("Change Page", "Save Button", saveButton2);
				Thread.sleep(1000);
				if (isElementPresentZeroWait(suspendFieldCheckBox)) {
					clickOnElement("Change Page", "	Suspend Fields will be Cleared CheckBox", suspendFieldCheckBox);
					clickOnElement("Change Page", "Save Button", saveButton2);
				}

				if (isElementPresentZeroWait(warningsCheckbox_1)) {
					int count = getElementCount("Change Page", "Warning Checkboxs", warningsCheckbox_1);
					for (int i = 1; i <= count; i++) {
						clickOnElement("Change Page", "Warning CheckBox",
								getDynamicElement("Warning CheckBox", warningsCheckbox, Integer.toString(i)));
					}
					clickOnElement("Change Page", "Save Button", saveButton2);
					Thread.sleep(1500);
				}

				validateElementPresent("Inquiry Page", "Search Title", searchTitle2);
				driver.switchTo().defaultContent();
				switchToWindowWithTitleContaining("Institution");
				stepResult = true;

			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				if (stepResult == true) {
					System.out.println("Pass");
					new HTMLReportHelper().HtmlReportBody("Click on Save Button", "Clicked on Save Button Successfully",
							"Passed", driver, "Y");
				} else {
					System.out.println("fail");
					new HTMLReportHelper().HtmlReportBody("Click on Save Button", "Could not clicked on Save Button",
							"Failed", driver, "Y");
					System.setProperty("runStep", "N");
				}
			}
		}
	}

	public void changeAccountCodeDetails(String sAccountNumber, String sAccountWarning, String sAccountStatusCode,
			String sAccntsTransRestrictionCode, String statementCycle, String sAlternateCycleOption,
			String sAlternateCycle, String sNotificationOption,String sStatementRequestCode, String sSuspendedStatementCycle,
			String sSuspendedInterestList, String sSuspendedDepositRateIndex,String sWarningTellerAlert1,String sWarningTellerAlert2,String sWarningTellerAlert3,String sStatusDate,String sInitialDeposit) throws Exception {
		if (System.getProperty("runStep") == "Y") {
			boolean stepResult = false;
			try {
				if (isElementPresent(getDynamicElement("Account Number Header field", depositChangeHeader, sAccountNumber))) {
					if (!sAccountWarning.equals("")) {
						clearAndType("Change Account Page", "Warning field", warningTextbox, sAccountWarning);
					}
					if (!sWarningTellerAlert1.equals("")) {
						clickOnElement("Change Account Page", "Warning Teller Alert 1 Input",warningTellerAlert1Input);
						Thread.sleep(1000);
						clickOnElement("Change Account Page", "Warning Teller Alert 1 Button",warningTellerAlert1Button);
						Thread.sleep(1000);
						clickOnElement("Change Account Page", "Warning Teller Alert 1 list",
								getDynamicElement("Warning Teller Alert 1 list", warningTellerAlert1List,sWarningTellerAlert1));
					}
					if (!sWarningTellerAlert2.equals("")) {
						clickOnElement("Change Account Page", "Warning Teller Alert 2 Input",warningTellerAlert2Input);
						Thread.sleep(1000);
						clickOnElement("Change Account Page", "Warning Teller Alert 2 Button",warningTellerAlert2Button);
						Thread.sleep(1000);
						clickOnElement("Change Account Page", "Warning Teller Alert 2 list",
								getDynamicElement("Warning Teller Alert 2 list", warningTellerAlert2List,sWarningTellerAlert2));
					}
					if (!sWarningTellerAlert3.equals("")) {
						clickOnElement("Change Account Page", "Warning Teller Alert 3 Input",warningTellerAlert3Input);
						Thread.sleep(1000);
						clickOnElement("Change Account Page", "Warning Teller Alert 3 Button",warningTellerAlert3Button);
						Thread.sleep(1000);
						clickOnElement("Change Account Page", "Warning Teller Alert 3 list",
								getDynamicElement("Warning Teller Alert 3 list", warningTellerAlert3List,sWarningTellerAlert3));
					}
					if (!sAccountStatusCode.equals("")) {
						if (isElementPresentZeroWait(statusCodeList)) {
							selectElementByVisibleText("Change Account Page", "Status Code Field", statusCodeList,sAccountStatusCode);
						}else {
							if (isElementPresentZeroWait(statusCodeInput))
								clickOnElement("Change Account Page", "Status Code Input",statusCodeInput);
						Thread.sleep(1000);
						clickOnElement("Change Account Page", "Status Code Button",statusCodeBtn);
						Thread.sleep(1000);
						clickOnElement("Change Account Page", "Status Code list",getDynamicElement("Status Code list", statusCodeDropDown,sAccountStatusCode));
						}
					}
					if (!sStatusDate.equals("")) {
						clearAndType("Change Account Page", "Status Date Field", statusDateInput, sStatusDate);
					}
					if (!sInitialDeposit.equals("")) {
						clearAndType("Change Account Page", "Initial Deposit Field", initialDepositInput,sInitialDeposit);
					}
					if (!sAccntsTransRestrictionCode.equals("")) {
						clickOnElement("Change Account Page", "Trans Restriction Code Input",transactionRestrictionCodeInput);
						Thread.sleep(1000);
						clickOnElement("Change Account Page", "Trans Restriction Code Button",transactionRestrictionCodeButton);
						Thread.sleep(1000);
						clickOnElement("Change Account Page", "Trans Restriction Code list",
								getDynamicElement("Trans Restriction Code list", transactionRestrictionCodeList,sAccntsTransRestrictionCode));
					}
					if (!statementCycle.equals("")) {
						selectElementByVisibleText("Change Account Page", "statement Cycle Field", statementCycleList,
								statementCycle);
					}

					if (!sAlternateCycleOption.equals("")) {
						selectElementByVisibleText("Change Account Page", "Alternate Cycle Option Field",
								alternateCycleOptionList, sAlternateCycleOption);
					}

					if (!sAlternateCycle.equals("")) {
						if (isElementPresentZeroWait(alternateCycleTextInput)) {
							clickOnElement("Change Account Page", "Alternate Cycle Input", alternateCycleTextInput);
						}
						//clickOnElement("Change Account Page", "Alternate Cycle Input", alternateCycleInput);
						Thread.sleep(1000);
						clickOnElement("Change Account Page", "Alternate Cycle Button", alternateCycleBtn);
						Thread.sleep(1000);
						clickOnElement("Change Account Page", "Alternate Cycle list",
								getDynamicElement("Alternate Cycle list", alternateCycleList, sAlternateCycle));
					}

					if (!sNotificationOption.equals("")) {
						selectElementByVisibleText("Change Account Page", "Notification Option Field",
								notificationOptionList, sNotificationOption);
					}
					
					if (!sStatementRequestCode.equals("")) {
						selectElementByVisibleText("Change Account Page", "Statement Request Code Field",
								sStatementRequestCodeList, sStatementRequestCode);
					}
					
					if (!sSuspendedStatementCycle.equals("")) {
						selectElementByVisibleText("Change Account Page", "Suspended Statement Cycle Field",
								suspendedStatementCycleList, sSuspendedStatementCycle);
					}

					if (!sSuspendedInterestList.equals("")) {
						selectElementByVisibleText("Change Account Page", "Suspended Interest Field",
								suspendedInterestList, sSuspendedInterestList);
					}

					if (!sSuspendedDepositRateIndex.equals("")) {
						if (isElementPresentZeroWait(suspendedDepositRateIndexTextInput)) {
							clickOnElement("Change Account Page", "Suspended Deposit Rate Index Input",
									suspendedDepositRateIndexTextInput);
						}
						clickOnElement("Change Account Page", "Suspended Deposit Rate Index Input",
								suspendedDepositRateIndexInput);
						// Thread.sleep(1000);
						clickOnElement("Change Account Page", "Suspended Deposit Rate Index Button",
								suspendedDepositRateIndexBtn);
						// Thread.sleep(1000);
						clickOnElement("Change Account Page", "Suspended Deposit Rate Index list",
								getDynamicElement("Suspended Deposit Rate Index list", suspendedDepositRateIndexList,
										sSuspendedDepositRateIndex));
					}

					stepResult = true;

				}
			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				if (stepResult == true) {
					System.out.println("Pass");
					new HTMLReportHelper().HtmlReportBody("Change Account Details",
							"Account Details changed Successfully", "Passed", driver, "Y");
				} else {
					System.out.println("fail");
					new HTMLReportHelper().HtmlReportBody("Change Account Details", "Could not change account Details",
							"Failed", driver, "Y");
					System.setProperty("runStep", "N");
				}
			}
		}
	}

	public void validateAccountDetailsAfterChange(String sAccountNumber, String sAccountWarning,
			String sAccountStatusCode, String sAccntsTransRestrictionCode, String statementCycle,String sWarningTellerAlert1,String sWarningTellerAlert2,String sWarningTellerAlert3,String sStatusDate,String sInitialDeposit) throws Exception {
		boolean stepResult = false;
		try {
			waitElement(1000);
			clickOnElement("Account Inquiry Page", "Codes Tab Field", codesTab);
			switchToWithinFrameWithName("bottom");
			if (isElementPresent(getDynamicElement("Account Number Header field", depositInquiryHeader, sAccountNumber))) {
				clickOnElement("Account Inquiry Page", "Expand Icon for Warning Field", expandWarningInquiryPage);
				if (!statementCycle.equals(""))
					validateTextContains("Account Inquiry", "Statement Cycle field", statementCycleInquiryPage,
							statementCycle);
				if (!sAccountStatusCode.equals(""))
					if (sAccountStatusCode.contains("]")){
						String[] sAccountStatusCode_split = sAccountStatusCode.split("]");
						sAccountStatusCode=sAccountStatusCode_split[1].trim();
					}
					validateTextContains("Account Inquiry", "Status Code field", statusCodeInquiryPage,sAccountStatusCode);
				if (!sAccountWarning.equals("")) {
					validateTextContains("Account Inquiry", "Warning field", warningInquiryPage, sAccountWarning);
				}
				if (!sWarningTellerAlert1.equals("")) {
					sWarningTellerAlert1 = ((sWarningTellerAlert1.split("\\["))[0]).trim();
					validateTextContains("Account Inquiry", "Warning Teller Alert 1 field", getDynamicElement("Warning Teller Alert 1 field", warningtellerAlertInquiryPage, sWarningTellerAlert1), sWarningTellerAlert1);
				}
				if (!sWarningTellerAlert2.equals("")) {
					sWarningTellerAlert2 = ((sWarningTellerAlert2.split("\\["))[0]).trim();
					validateTextContains("Account Inquiry", "Warning Teller Alert 2 field", getDynamicElement("Warning Teller Alert 2 field", warningtellerAlertInquiryPage, sWarningTellerAlert2), sWarningTellerAlert2);
				}
				if (!sWarningTellerAlert3.equals("")) {
					sWarningTellerAlert3 = ((sWarningTellerAlert3.split("\\["))[0]).trim();
					validateTextContains("Account Inquiry", "Warning Teller Alert 3 field", getDynamicElement("Warning Teller Alert 3 field", warningtellerAlertInquiryPage, sWarningTellerAlert3), sWarningTellerAlert3);
				}
				if (!sAccntsTransRestrictionCode.equals("")) {
					sAccntsTransRestrictionCode = ((sAccntsTransRestrictionCode.split("\\["))[0]).trim();
					validateTextContains("Account Inquiry", "Trans Restriction Code field",transRestrictionCodeInquiryPage, sAccntsTransRestrictionCode);
				}
				if (!sStatusDate.equals("")) {
					sStatusDate = new DateTimeHelper().getDateTime(sStatusDate,"MM/dd/yyyy","MMM dd, yyyy");
					validateTextContains("Account Inquiry", "Status Date field", statusDateInquiryPage, sStatusDate);
				}
				if (!sInitialDeposit.equals("")) {
					validateTextContains("Account Inquiry", "Initial Deposit field", initialDepositInquiryPage, sInitialDeposit);
				}
				switchToDefaultContent();
				driver.switchTo().frame("Main");
				stepResult = true;

			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (stepResult == true) {
				System.out.println("Pass");
				new HTMLReportHelper().HtmlReportBody("Account Details Validation",
						"Validated Account Details on Account Inquiry page Successfully", "Passed", driver, "Y");
			} else {
				System.out.println("fail");
				new HTMLReportHelper().HtmlReportBody("Account Details Validation",
						"Could not Validated Account Details on Account Inquiry page", "Failed", driver, "Y");
			}
		}
	}

	public void changeAccountHold(String sAccountNumber, String sHoldReason, String sHoldAmount, String sExpirationDate,
			String sAccountPledgedOnLoan, String sPledgedNoteNum, String sMaximumPledge, String sHoldDate,
			String sPendingStartDate, String sPendingAmount, String sHoldAmountOption) throws Exception {
		if (System.getProperty("runStep") == "Y") {
			boolean stepResult = false;
			try {
				if (isElementPresent(
						getDynamicElement("Account Number Header field", depositChangeHeader, sAccountNumber))) {
					mouseHoverCickOnElement("Change Account Page", "Hold Menu Field", fileMenu, holdMenu);
					if (isElementPresent(holdTitle)) {

						if (!sHoldReason.equals("")) {
							enterText("Change Account Page", "Hold Reason field", holdReason, sHoldReason);
						}

						if (!sHoldAmount.equals("")) {
							enterText("Change Account Page", "Hold Amount field", holdAMount, sHoldAmount);
						}

						if (!sExpirationDate.equals("")) {
							enterText("Change Account Page", "Expiration Date field", holdExpDate, sExpirationDate);
						}

						if (!sAccountPledgedOnLoan.equals("")) {
							selectElementByVisibleText("Change Account Page", "Account Pledged on Loan Field",
									accountPledgedOnLoanSelect, sAccountPledgedOnLoan);
						}

						if (!sPledgedNoteNum.equals("")) {
							enterText("Change Account Page", "Pledged Note Number field", pledgedNoteNum,
									sPledgedNoteNum);
						}

						if (!sMaximumPledge.equals("")) {
							enterText("Change Account Page", "Maximum Pledge field", maxPledge, sMaximumPledge);
						}

						if (!sHoldDate.equals("")) {
							enterText("Change Account Page", "Hold Date field", holdDate, sHoldDate);
						}

						if (!sPendingStartDate.equals("")) {
							enterText("Change Account Page", "Pendig Start Date field", holdPendigStrtDate,
									sPendingStartDate);
						}

						if (!sPendingAmount.equals("")) {
							enterText("Change Account Page", "Pending Amount field", holdPendingAmt, sPendingAmount);
						}

						if (!sHoldAmountOption.equals("")) {
							selectElementByVisibleText("Change Account Page", "Hold Amount Option Field", holdAmtOption,
									sHoldAmountOption);
						}
						stepResult = true;
					}
				}
			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				if (stepResult == true) {
					System.out.println("Pass");
					new HTMLReportHelper().HtmlReportBody("Change Account - Hold Details",
							"Account - Hold Details changed Successfully", "Passed", driver, "Y");
				} else {
					System.out.println("fail");
					new HTMLReportHelper().HtmlReportBody("Change Account - Hold Details",
							"Could not change account - Hold Details", "Failed", driver, "Y");
					System.setProperty("runStep", "N");
				}
			}
		}
	}

	public void validateAccountHoldDetailsAfterChange(String sAccountNumber, String sVerifyHoldAmount,
			String sVerifyHoldReason, String sVerifyExpirationDate, String sVerifyHoldDate, String sVerifyPendingAmount)
					throws Exception {
		boolean stepResult = false;
		try {
			waitElement(1000);
			switchToWithinFrameWithName("bottom");
			if (isElementPresent(
					getDynamicElement("Account Number Header field", depositInquiryHeader, sAccountNumber))) {
				if (isElementPresent(holdslabel)) {
					clickOnElement("Change Account Page", "Hold Expand Button", holdExpand);

					if (!sVerifyHoldAmount.equals(""))
						validateElementPresent("Account Inquiry", "Hold Amount field",
								getDynamicElement("Hold Amount field", verifyHoldData, sVerifyHoldAmount));

					if (!sVerifyHoldReason.equals(""))
						validateElementPresent("Account Inquiry", "Hold Reason field",
								getDynamicElement("Hold Amount field", verifyHoldData, sVerifyHoldReason));

					if (!sVerifyExpirationDate.equals(""))
						validateElementPresent("Account Inquiry", "Hold Expiration Date field",
								getDynamicElement("Hold Amount field", verifyHoldData, sVerifyExpirationDate));

					if (!sVerifyHoldDate.equals(""))
						validateElementPresent("Account Inquiry", "Hold Date field",
								getDynamicElement("Hold Amount field", verifyHoldData, sVerifyHoldDate));

					if (!sVerifyPendingAmount.equals(""))
						validateElementPresent("Account Inquiry", "Hold Pending Amount",
								getDynamicElement("Hold Amount field", verifyHoldData, sVerifyPendingAmount));

					stepResult = true;
				}
				switchToDefaultContent();
				driver.switchTo().frame("Main");

			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (stepResult == true) {
				System.out.println("Pass");
				new HTMLReportHelper().HtmlReportBody("Account Details - Hold Validation",
						"Validated Account Details - Hold on Account Inquiry page Successfully", "Passed", driver, "Y");
			} else {
				System.out.println("fail");
				new HTMLReportHelper().HtmlReportBody("Account Details - Hold Validation",
						"Could not Validated Account Details - Hold on Account Inquiry page", "Failed", driver, "Y");
			}
		}
	}

	public void changeAccountTickler(String sAccountNumber, String sTicklerDecription, String sTicklerAdditionalMsg,
			String sTicklerNextDate, String sTicklerFrequencyList, String sTicklerExpDate) throws Exception {
		if (System.getProperty("runStep") == "Y") {
			boolean stepResult = false;
			try {
				if (isElementPresent(
						getDynamicElement("Account Number Header field", depositChangeHeader, sAccountNumber))) {
					mouseHoverCickOnElement("Change Account Page", "Tickler Menu Field", fileMenu, ticklerMenu);
					if (isElementPresent(ticklerTitle)) {

						if (!sTicklerDecription.equals("")) {
							clearAndType("Change Account Page", "Tickler Description field", ticklerDecription,
									sTicklerDecription);
						}

						if (!sTicklerAdditionalMsg.equals("")) {
							clearAndType("Change Account Page", "Tickler Additional Message field",
									ticklerAdditionalMsg, sTicklerAdditionalMsg);
						}

						if (!sTicklerNextDate.equals("")) {
							clearAndType("Change Account Page", "Tickler Next Date field", ticklerNextDate,
									sTicklerNextDate);
						}

						if (!sTicklerFrequencyList.equals("")) {
							selectElementByVisibleText("Change Account Page", "Tickler Frequency Field",
									ticklerFrequencyList, sTicklerFrequencyList);
						}

						if (!sTicklerExpDate.equals("")) {
							clearAndType("Change Account Page", "Tickler Expiration Date field", ticklerExpDate,
									sTicklerExpDate);
						}

						stepResult = true;
					}
				}
			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				if (stepResult == true) {
					System.out.println("Pass");
					new HTMLReportHelper().HtmlReportBody("Change Account - Tickler Details",
							"Account Details - Tickler changed Successfully", "Passed", driver, "Y");
				} else {
					System.out.println("fail");
					new HTMLReportHelper().HtmlReportBody("Change Account - Tickler Details",
							"Could not change account Details- Tickler", "Failed", driver, "Y");
					System.setProperty("runStep", "N");
				}
			}
		}
	}

	public void validateAccountTickerDetailsAfterChange(String sAccountNumber, String sVerifyTicklerDescription,
			String sVerifyTicklerDate, String sVerifyTicklerFrequency, String sVerifyTicklerExpDate) throws Exception {
		boolean stepResult = false;
		try {

			mouseHoverCickOnElement("Account Inquiry Page", "Tickler Menu Field", activityMenu, ticklerMenu);
			waitElement(1000);
			switchToWithinFrameWithName("bottom");
			if (isElementPresent(
					getDynamicElement("Account Number Header field", depositInquiryHeader, sAccountNumber))) {
				if (isElementPresent(ticklerlabel)) {
					getDynamicElementClick("Change Account Page", "Tickler Expand Button", ticklerExpand,
							sVerifyTicklerDescription);

					if (!sVerifyTicklerDescription.equals(""))
						validateElementPresent("Account Inquiry", "Tickler Description field", getDynamicElement(
								"Tickler Description field", verifyTicklerData, sVerifyTicklerDescription));

					if (!sVerifyTicklerDate.equals(""))
						validateElementPresent("Account Inquiry", "Tickler Next Date field",
								getDynamicElement("Tickler Next Date field", verifyTicklerData, sVerifyTicklerDate));

					if (!sVerifyTicklerExpDate.equals(""))
						validateElementPresent("Account Inquiry", "Tickler Expiration Date field", getDynamicElement(
								"Tickler Expiration Date field", verifyTicklerData, sVerifyTicklerExpDate));

					if (!sVerifyTicklerFrequency.equals(""))
						validateElementPresent("Account Inquiry", "Tickler Frequency field", getDynamicElement(
								"Tickler Frequency field", verifyTicklerData, sVerifyTicklerFrequency));

					stepResult = true;
				}
				switchToDefaultContent();
				driver.switchTo().frame("Main");

			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (stepResult == true) {
				System.out.println("Pass");
				new HTMLReportHelper().HtmlReportBody("Account Details - Tickler Validation",
						"Validated Account Details - Tickler on Account Inquiry page Successfully", "Passed", driver,
						"Y");
			} else {
				System.out.println("fail");
				new HTMLReportHelper().HtmlReportBody("Account Details - Tickler Validation",
						"Could not Validated Account Details - Tickler on Account Inquiry page", "Failed", driver, "Y");
			}
		}
	}

	public void changeAccountOverDrafts(String sAccountNumber, String sODLimit, String sOverdraftLimitPriority,
			String sDDBaseAccount) throws Exception {
		if (System.getProperty("runStep") == "Y") {
			boolean stepResult = false;
			try {
				if (isElementPresent(
						getDynamicElement("Account Number Header field", depositChangeHeader, sAccountNumber))) {
					mouseHoverCickOnElement("Change Account Page", "Overdrafts Menu Field", activityMenu,
							overdraftsMenu);
					if (isElementPresent(overdraftsSectionLabel)) {

						if (!sODLimit.equals("")) {
							clearAndType("Change Account Page", "Overdrafts Limit field", overdraftLimit, sODLimit);
						}

						if (!sOverdraftLimitPriority.equals("")) {
							selectElementByVisibleText("Change Account Page", "Overdraft Limit Priority Field",
									overdraftLimitPriorityList, sOverdraftLimitPriority);
						}

						if (!sDDBaseAccount.equals("")) {
							clearAndType("Change Account Page", "Demand Deposit Base Account field", ddBaseAccount,
									sDDBaseAccount);
						}

						stepResult = true;
					}
				}
			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				if (stepResult == true) {
					System.out.println("Pass");
					new HTMLReportHelper().HtmlReportBody("Change Account - Overdrafts Details",
							"Account Details - Overdrafts changed Successfully", "Passed", driver, "Y");
				} else {
					System.out.println("fail");
					new HTMLReportHelper().HtmlReportBody("Change Account - Overdrafts Details",
							"Could not change account Details- Overdrafts", "Failed", driver, "Y");
					System.setProperty("runStep", "N");
				}
			}
		}
	}

	public void validateAccountODDetailsAfterChange(String sAccountNumber, String sVerifyODLimit,
			String sVerifyODLimitPriority) throws Exception {
		boolean stepResult = false;
		try {

			mouseHoverCickOnElement("Change Account Page", "Overdrafts Menu Field", activityMenu, overdraftsMenu);
			waitElement(1000);
			switchToWithinFrameWithName("bottom");
			if (isElementPresent(
					getDynamicElement("Account Number Header field", depositInquiryHeader, sAccountNumber))) {
				if (isElementPresent(overdraftslabel)) {
					// clickOnElement("Change Account Page", "Tickler Expand
					// Button",ticklerExpand);

					if (!sVerifyODLimit.equals(""))
						validateElementPresent("Account Inquiry", "Overdrafts Limit field", getDynamicElement(
								"Overdrafts Limit field field", verifyOverdraftsData, sVerifyODLimit));

					if (!sVerifyODLimitPriority.equals(""))
						validateElementPresent("Account Inquiry", "Overdrafts Limit Priority field", getDynamicElement(
								"Overdrafts Limit Priority field", verifyOverdraftsData, sVerifyODLimitPriority));

					stepResult = true;
				}
				switchToDefaultContent();
				driver.switchTo().frame("Main");

			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (stepResult == true) {
				System.out.println("Pass");
				new HTMLReportHelper().HtmlReportBody("Account Details - Overdrafts Validation",
						"Validated Account Details - Overdrafts on Account Inquiry page Successfully", "Passed", driver,
						"Y");
			} else {
				System.out.println("fail");
				new HTMLReportHelper().HtmlReportBody("Account Details - Overdrafts Validation",
						"Could not Validated Account Details - Overdrafts on Account Inquiry page", "Failed", driver,
						"Y");
			}
		}
	}

	public void changeAccountStopPay(String sAccountNumber, String sStopPayType, String sStopPayDate,
			String sStopPayExpireDate, String sStopPayItemDate, String sStopPayFromNum, String sStopPayThruNum,
			String sStopPayFromAmt, String sStopPayThruAmt, String sStopPayFromTransCode, String sStopPayThruTransCode,
			String sStopPayACHCompanyID, String sStopPayPayee, String sStopPayPayeeReason, String sStopPayPayeeComments)
					throws Exception {
		if (System.getProperty("runStep") == "Y") {
			boolean stepResult = false;
			try {
				if (isElementPresent(
						getDynamicElement("Account Number Header field", depositChangeHeader, sAccountNumber))) {
					mouseHoverCickOnElement("Change Account Page", "Stop Pay Menu Field", fileMenu, stopPayMenu);
					if (isElementPresent(stopPayLabel)) {

						if (!sStopPayType.equals("")) {
							clickOnElement("Change Account Page", "Stop Pay Type input field", stopPayTypeInput);
							Thread.sleep(1000);
							clickOnElement("Change Account Page", "Stop Pay Type Dropdown Btn field",
									stopPayTypeSelect);
							Thread.sleep(1000);
							clickOnElement("Change Account Page", "Stop Pay Type Option list",
									getDynamicElement("Stop Pay Type Option list", stopPayTypeList, sStopPayType));
							Thread.sleep(1000);
							clickOnElement("Change Account Page", "Stop Pay Description field", stopPayItemDescription);
						}

						if (!sStopPayDate.equals("")) {
							clearAndType("Change Account Page", "Stop Pay Date field", stopPayDate, sStopPayDate);
						}

						if (!sStopPayExpireDate.equals("")) {
							clearAndType("Change Account Page", "Stop Pay Expiration Date field", stopPayExpireDate,
									sStopPayExpireDate);
						}

						if (!sStopPayItemDate.equals("")) {
							clearAndType("Change Account Page", "Stop Pay Item Date field", stopPayItemDate,
									sStopPayItemDate);
						}

						if (!sStopPayFromNum.equals("")) {
							clearAndType("Change Account Page", "Stop Pay Number From field", stopPayFromNum,
									sStopPayFromNum);
						}

						if (!sStopPayThruNum.equals("")) {
							clearAndType("Change Account Page", "Stop Pay Number Through field", stopPayThruNum,
									sStopPayThruNum);
						}

						if (!sStopPayFromAmt.equals("")) {
							clearAndType("Change Account Page", "Stop Pay Amount From field", stopPayFromAmt,
									sStopPayFromAmt);
						}

						if (!sStopPayThruAmt.equals("")) {
							clearAndType("Change Account Page", "Stop Pay Amount Through field", stopPayThruAmt,
									sStopPayThruAmt);
						}

						if (!sStopPayFromTransCode.equals("")) {
							clearAndType("Change Account Page", "Stop Pay Transaction Code From field",
									stopPayFromTransCode, sStopPayFromTransCode);
						}

						if (!sStopPayThruTransCode.equals("")) {
							clearAndType("Change Account Page", "Stop Pay Transaction Code Through field",
									stopPayThruTransCode, sStopPayThruTransCode);
						}

						if (!sStopPayACHCompanyID.equals("")) {
							clearAndType("Change Account Page", "Stop Pay ACH Company ID field", stopPayACHCompanyID,
									sStopPayACHCompanyID);
						}

						if (!sStopPayPayee.equals("")) {
							clearAndType("Change Account Page", "Stop Pay Payee field", stopPayPayee, sStopPayPayee);
						}

						if (!sStopPayPayeeReason.equals("")) {
							clearAndType("Change Account Page", "Stop Pay Payee Reason field", stopPayPayeeReason,
									sStopPayPayeeReason);
						}

						if (!sStopPayPayeeComments.equals("")) {
							clearAndType("Change Account Page", "Stop Pay Payee Comments field", stopPayPayeeComments,
									sStopPayPayeeComments);
						}

						stepResult = true;
					}
				}
			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				if (stepResult == true) {
					System.out.println("Pass");
					new HTMLReportHelper().HtmlReportBody("Change Account - Stop Pay Details",
							"Account Details - Stop Pay changed Successfully", "Passed", driver, "Y");
				} else {
					System.out.println("fail");
					new HTMLReportHelper().HtmlReportBody("Change Account - Stop Pay Details",
							"Could not change account Details- Stop Pay", "Failed", driver, "Y");
					System.setProperty("runStep", "N");
				}
			}
		}
	}

	public void validateAccountStopPayAfterChange(String sAccountNumber, String sStopPayType, String sStopPayItemDate,
			String sStopPayFromNum, String sStopPayThruNum, String sStopPayFromAmt, String sStopPayThruAmt,
			String sStopPayACHCompanyID, String sStopPayPayee, String sStopPayPayeeReason, String sStopPayDate,
			String sStopPayExpireDate) throws Exception {
		boolean stepResult = false;
		try {

			mouseHoverCickOnElement("Change Account Page", "Overdrafts Menu Field", activityMenu, stopPayMenu);
			waitElement(1000);
			switchToWithinFrameWithName("bottom");
			if (isElementPresent(
					getDynamicElement("Account Number Header field", depositInquiryHeader, sAccountNumber))) {
				if (isElementPresent(stopPayInquirylabel)) {

					expandStopPayInquiry = String.format(expandStopPayInquiry, sStopPayType, sStopPayItemDate);
					clickOnElement("Change Account Page", "Stop Pay Expand Button",
							getDynamicElement("Stop Pay Expand field", expandStopPayInquiry, ""));

					if (!sStopPayType.equals(""))
						validateElementPresent("Account Inquiry", "Stop Pay Type field",
								getDynamicElement("Stop Pay Type field", verifyStopPayData, sStopPayType));

					if (!sStopPayItemDate.equals(""))
						validateElementPresent("Account Inquiry", "Stop Pay Item Date field",
								getDynamicElement("Stop Pay Item Date field", verifyStopPayData, sStopPayItemDate));

					if (!sStopPayFromNum.equals(""))
						validateElementPresent("Account Inquiry", "Stop Pay From Number field",
								getDynamicElement("Stop Pay From Number field", verifyStopPayData, sStopPayFromNum));

					if (!sStopPayThruNum.equals(""))
						validateElementPresent("Account Inquiry", "Stop Pay Through Number field",
								getDynamicElement("Stop Pay Through Number field", verifyStopPayData, sStopPayThruNum));

					if (!sStopPayFromAmt.equals(""))
						validateElementPresent("Account Inquiry", "Stop Pay From Amount field",
								getDynamicElement("Stop Pay From Amount field", verifyStopPayData, sStopPayFromAmt));

					if (!sStopPayThruAmt.equals(""))
						validateElementPresent("Account Inquiry", "Stop Pay Through Amount field",
								getDynamicElement("Stop Pay Through Amount field", verifyStopPayData, sStopPayThruAmt));

					if (!sStopPayACHCompanyID.equals(""))
						validateElementPresent("Account Inquiry", "Stop Pay ACH Comapny ID field", getDynamicElement(
								"Stop Pay ACH Comapny ID field", verifyStopPayData, sStopPayACHCompanyID));

					if (!sStopPayPayee.equals(""))
						validateElementPresent("Account Inquiry", "Stop Pay Payee field",
								getDynamicElement("Stop Pay Payee field", verifyStopPayData, sStopPayPayee));

					/*
					 * if (!sStopPayPayeeReason.equals(""))
					 * validateElementPresent("Account Inquiry" ,
					 * "Stop Pay Payee Reason field",
					 * getDynamicElement("Stop Pay Payee Reason field"
					 * ,verifyStopPayData,sStopPayPayeeReason));
					 */

					if (!sStopPayDate.equals(""))
						validateElementPresent("Account Inquiry", "Stop Pay Date field",
								getDynamicElement("Stop Pay Date field", verifyStopPayData, sStopPayDate));

					if (!sStopPayExpireDate.equals(""))
						validateElementPresent("Account Inquiry", "Stop Pay Expiration Date field", getDynamicElement(
								"Stop Pay Expiration Date field", verifyStopPayData, sStopPayExpireDate));

					stepResult = true;
				}
				switchToDefaultContent();
				driver.switchTo().frame("Main");

			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (stepResult == true) {
				System.out.println("Pass");
				new HTMLReportHelper().HtmlReportBody("Account Details - Stop Pay Validation",
						"Validated Account Details - Stop Pay on Account Inquiry page Successfully", "Passed", driver,
						"Y");
			} else {
				System.out.println("fail");
				new HTMLReportHelper().HtmlReportBody("Account Details - Stop Pay  Validation",
						"Could not Validated Account Details - Stop Pay on Account Inquiry page", "Failed", driver,
						"Y");
			}
		}
	}

	public void submitButton() throws Exception {
		if (System.getProperty("runStep") == "Y") {
			boolean stepResult = false;
			try {
				clickOnElement("Change Page", "Submit Button", submitSearch);
				Thread.sleep(1000);
				stepResult = true;

			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				if (stepResult == true) {
					System.out.println("Pass");
					new HTMLReportHelper().HtmlReportBody("Click on Submit Button",
							"Clicked on Submit Button Successfully", "Passed", driver, "Y");
				} else {
					System.out.println("fail");
					new HTMLReportHelper().HtmlReportBody("Click on Submit Button",
							"Could not clicked on Submit Button", "Failed", driver, "Y");
					System.setProperty("runStep", "N");
				}
			}
		}
	}

	public void changeAccountDetails_UpdateAddRelationship(String sAccountNumber, String sUpdateName,
			String sUpdateRelationship, String sName, String sSN, String sRelationship, String sEStatement)
					throws Exception {
		if (System.getProperty("runStep") == "Y") {
			boolean stepResult = false;
			try {
				clickOnElement("Change Account Page", "Relationship Tab Field", relationshipTab);
				waitElement(2000);

				if (!sName.equals(""))  {
					clickOnElement("Change Account Page", "Search Icon", searchIconName);
					switchToWindowWithTitleContaining("Name Search");
					driver.switchTo().frame("bottom");
					searchSSN(sSN);
					waitElement(1500);
					switchToWindowWithTitleContaining("Institution");
					driver.switchTo().frame("Main");


					selectElementByVisibleText("Change Account Page", "Add Relationship Field",
							getDynamicElement("Add Relationship list", relationshipAddName, sName), sRelationship);
					waitElement(1500);


					tempVar = getVisibleSelectedText("Change Account Page", "Account info Name Field",
							getDynamicElement("Relationship list", newName, Integer.toString(2)));
					if (tempVar.equals("(None)")) {
						selectElementByVisibleText("Change Account Page", "Account info Name Field",
								getDynamicElement("Account info Name Field", newName, Integer.toString(2)), sName);
						waitElement(1000);
						selectElementByVisibleText("Change Account Page", "Mailing info Name Field",
								getDynamicElement("Mailing info Name Field", newName, Integer.toString(5)), sName);
						waitElement(1000);
						if (!sEStatement.equals("")) {
							selectElementByVisibleText("Change Account Page", "Mailing info E Statement Field",
									getDynamicElement("Mailing info E Statement Field", newEstatement,
											Integer.toString(2)),
									sEStatement);
						}
					} else {
						selectElementByVisibleText("Change Account Page", "Account info Name Field",
								getDynamicElement("Account info Name Field", newName, Integer.toString(3)), sName);
						waitElement(1000);
						selectElementByVisibleText("Change Account Page", "Mailing info Name Field",
								getDynamicElement("Mailing info Name Field", newName, Integer.toString(6)), sName);
						waitElement(1000);
						if (!sEStatement.equals("")) {
							selectElementByVisibleText("Change Account Page", "Mailing info E Statement Field",
									getDynamicElement("Mailing info E Statement Field", newEstatement,
											Integer.toString(3)),
									sEStatement);
						}
					}



				}

				if (isElementPresent(getDynamicElement("Relationship Name", updateName, sUpdateName))) {
					selectElementByVisibleText("Change Account Page", "Update Relationship Field",
							getDynamicElement("Update Relationship list", relationshipAddName, sUpdateName),
							sUpdateRelationship);
					waitElement(1000);
				}

				clickOnElement("Change Page", "Save Button", saveButton2);
				Thread.sleep(2000);
				/*
				 * if(isElementPresent(warningHeader)) { if
				 * (isElementPresentZeroWait(warning2)) {
				 * clickOnElement("New Loan Page", "Warning 2 Checkbox",
				 * warningCheckBox2); } if
				 * (isElementPresentZeroWait(warning1)) {
				 * clickOnElement("New Loan Page", "Warning 1 Checkbox",
				 * warningCheckBox1); } if
				 * (isElementPresentZeroWait(warning3)) {
				 * clickOnElement("New Loan Page", "Warning 3 Checkbox",
				 * warningCheckBox3); } clickOnElement("New Loan Page",
				 * "Save Button", saveBtn); waitElement(2000); }
				 */

				if (isElementPresentZeroWait(warningsCheckbox_1)) {
					int count = getElementCount("Change Page", "Warning Checkboxs", warningsCheckbox_1);
					for (int i = 1; i <= count; i++) {
						clickOnElement("Change Page", "Warning CheckBox",
								getDynamicElement("Warning CheckBox", warningsCheckbox, Integer.toString(i)));
					}
					clickOnElement("Change Page", "Save Button", saveButton2);
					Thread.sleep(1500);
				}
				validateElementPresent("Change Account Page", "Search Title", searchTitle2);
				switchToWindowWithTitleContaining("Institution");
				stepResult = true;
			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				if (stepResult == true) {
					System.out.println("Pass");
					new HTMLReportHelper().HtmlReportBody("Change Account-Add/Update Relationship Details",
							"Relationship Add/Update Successfully", "Passed", driver, "Y");
				} else {
					System.out.println("fail");
					new HTMLReportHelper().HtmlReportBody("Change Account-Add/Update Relationship Details",
							"Could not Add/Update Relationship Details", "Failed", driver, "Y");
					System.setProperty("runStep", "N");
				}
			}
		}
	}

	public void validateAccountDetailsAfterChange_AddRelationship(String sAccountNumber, String sUpdateName,
			String sName, String sSN, String sUpdateRelationship, String sEStatement) throws Exception {
		boolean stepResult = false;
		try {
			waitElement(1000);
			clickOnElement("Account Inquiry Page", "Relationship Tab Field", relationshipTab);
			switchToWithinFrameWithName("bottom");

			if (!sName.equals(""))
				validateElementPresent("Account Inquiry Page", "New Relationship Name Field",
						getDynamicElement("New Relationship Name Field", newNameInquiryPage, sName));

			if (!sUpdateName.equals("")) {
				validateElementPresent("Account Inquiry Page", "Update Relationship Name Field",
						getDynamicElement("Update Relationship Name Field", newNameInquiryPage, sUpdateName));
				validateTextContains("Account Inquiry", "Update Relationship field",
						getDynamicElement("Update Relationship Field", newNameRelationshipInquiryPage, sUpdateName),
						sUpdateRelationship);

			}
			stepResult = true;
			switchToDefaultContent();
			driver.switchTo().frame("Main");
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (stepResult == true) {
				System.out.println("Pass");
				new HTMLReportHelper().HtmlReportBody("Relationship Details Validation",
						"Validated Relationship Details on Inquiry page Successfully", "Passed", driver, "Y");
			} else {
				System.out.println("fail");
				new HTMLReportHelper().HtmlReportBody("Relationship Details Validation",
						"Could not Validated Relationship Details on Inquiry page", "Failed", driver, "Y");
			}
		}
	}

	public void changeAccountDetails_UpdateRelationship(String sAccountNumber, String sName, String sRelationship)
			throws Exception {
		if (System.getProperty("runStep") == "Y") {
			boolean stepResult = false;
			try {
				clickOnElement("Change Account Page", "Relationship Tab Field", relationshipTab);
				waitElement(2000);
				if (isElementPresent(getDynamicElement("Relationship Name", updateName, sName))) {
					selectElementByVisibleText("Change Account Page", "Relationship Field",
							getDynamicElement("Relationship list", relationshipAddName, sName), sRelationship);
					waitElement(2000);

					clickOnElement("Change Page", "Save Button", saveButton2);
					Thread.sleep(2000);
					/*
					 * if(isElementPresent(warningHeader)) { if
					 * (isElementPresentZeroWait(warning2)) {
					 * clickOnElement("New Loan Page", "Warning 2 Checkbox",
					 * warningCheckBox2); } if
					 * (isElementPresentZeroWait(warning1)) {
					 * clickOnElement("New Loan Page", "Warning 1 Checkbox",
					 * warningCheckBox1); } if
					 * (isElementPresentZeroWait(warning3)) {
					 * clickOnElement("New Loan Page", "Warning 3 Checkbox",
					 * warningCheckBox3); } clickOnElement("New Loan Page",
					 * "Save Button", saveBtn); waitElement(2000); }
					 */
					if (isElementPresentZeroWait(warningsCheckbox_1)) {
						int count = getElementCount("Change Page", "Warning Checkboxs", warningsCheckbox_1);
						for (int i = 1; i <= count; i++) {
							clickOnElement("Change Page", "Warning CheckBox",
									getDynamicElement("Warning CheckBox", warningsCheckbox, Integer.toString(i)));
						}
						clickOnElement("Change Page", "Save Button", saveButton2);
						Thread.sleep(1500);
					}

					validateElementPresent("New Loan Page", "Search Title", searchTitle2);
					switchToWindowWithTitleContaining("Institution");
					stepResult = true;
				}
			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				if (stepResult == true) {
					System.out.println("Pass");
					new HTMLReportHelper().HtmlReportBody("Change Account-Update Relationship Details",
							"Relationship details Updated Successfully", "Passed", driver, "Y");
				} else {
					System.out.println("fail");
					new HTMLReportHelper().HtmlReportBody("Change Account-Update Relationship Details",
							"Could not Update Relationship Details", "Failed", driver, "Y");
					System.setProperty("runStep", "N");
				}
			}
		}
	}

	public void validateAccountDetailsAfterChange_UpdateRelationship(String sAccountNumber, String sName,
			String sRelationship) throws Exception {
		boolean stepResult = false;
		try {
			waitElement(1000);
			clickOnElement("Account Inquiry Page", "Relationship Tab Field", relationshipTab);
			switchToWithinFrameWithName("bottom");
			if (isElementPresent(getDynamicElement("New Relationship Name", newNameInquiryPage, sName))) {
				validateTextContains("Account Inquiry", "Relationship field",
						getDynamicElement("New Relationship Name", newNameRelationshipInquiryPage, sName),
						sRelationship);
				stepResult = true;
			}
			switchToDefaultContent();
			driver.switchTo().frame("Main");
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (stepResult == true) {
				System.out.println("Pass");
				new HTMLReportHelper().HtmlReportBody("Relationship Details Validation",
						"Validated Relationship Details on Inquiry page Successfully", "Passed", driver, "Y");
			} else {
				System.out.println("fail");
				new HTMLReportHelper().HtmlReportBody("Relationship Details Validation",
						"Could not Validated Relationship Details on Inquiry page", "Failed", driver, "Y");
			}
		}
	}

	public void searchSSN(String sSN) throws Exception {
		if (System.getProperty("runStep") == "Y") {

			boolean stepResult = false;
			try {
				Thread.sleep(7000);
				if (isElementPresent(searchTitle)) {
					clickOnElement("Add Name Page", "Tax Identification", ssnSearch);
					enterText("Add Name Page", "Tax Identification", ssnSearch, sSN);
					clickOnElement("Add Name Page", "Submit", submitSearch);
					Thread.sleep(3000);
					if (isElementPresent(nameLink)) {
						clickAfterWaitForElementToBeClickable("Add Name Page", "Name link", nameLink);
						//clickOnEnterELementUsingJS(findElement(nameLink));
						Thread.sleep(4000);
					}
					stepResult = true;
				}

			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				if (stepResult == true) {
					System.out.println("Pass");
					new HTMLReportHelper().HtmlReportBody("Search SSN", "Search SSN on Contact page Successfully",
							"Passed", driver, "N");
				} else {
					System.out.println("fail");
					new HTMLReportHelper().HtmlReportBody("Search SSN",
							"Could not Search SSN on Contact page Successfully", "Failed", driver, "N");
					System.setProperty("runStep", "N");
				}
			}
		}

	}
	
	public void changeAccountDetails_RemoveRelationship(String sAccountNumber,String sName) throws Exception {
		if (System.getProperty("runStep")=="Y"){
			boolean stepResult = false;
			try {			
				clickOnElement("Change Account Page", "Relationship Tab Field",relationshipTab);
				waitElement(1500);
				if (isElementPresent(getDynamicElement("Relationship Name",updateName,sName))) {					
					if (isElementPresentZeroWait((getDynamicElement("Remove Name Icon",removeNameIcon,sName)))) {
						clickOnElement("Change Account Page", "Remove Name Icon", (getDynamicElement("Remove Name Icon",removeNameIcon,sName)));
						waitElement(1500);
					}
					for (int i = 2; i<=6;i++) {
						tempVar = getVisibleSelectedText("Change Account Page", "Account info Name Field", getDynamicElement("Relationship list",newName,Integer.toString(i)));
						if (tempVar.equals(sName)) {
							selectElementByVisibleText("Change Account Page", "Account info Name Field", getDynamicElement("Account info Name Field",newName,Integer.toString(i)), "(None)");
							waitElement(1000);
						}
					}
					
					if (isElementPresentZeroWait((getDynamicElement("Remove Name Icon",removeNameIcon,sName)))) {
						clickOnElement("Change Account Page", "Remove Name Icon", (getDynamicElement("Remove Name Icon",removeNameIcon,sName)));
						waitElement(1500);
					}

					clickOnElement("Change Page", "Save Button", saveButton2);
					Thread.sleep(2000);
					if (isElementPresentZeroWait(warningsCheckbox_1)) {
						int count = getElementCount("Change Page", "Warning Checkboxs", warningsCheckbox_1);
						for (int i = 1; i <= count; i++) {
							clickOnElement("Change Page", "Warning CheckBox",
									getDynamicElement("Warning CheckBox", warningsCheckbox, Integer.toString(i)));
						}
						clickOnElement("Change Page", "Save Button", saveButton2);
						Thread.sleep(1500);
					}
					validateElementPresent("New Loan Page", "Search Title", searchTitle2);
					switchToWindowWithTitleContaining("Institution");
					stepResult = true;				
				}
			}catch(Exception e) {
				e.printStackTrace();
			}finally {
				if (stepResult==true){
					System.out.println("Pass");
					new HTMLReportHelper().HtmlReportBody("Change Account-Remove Relationship Details", "Relationship details removed Successfully", "Passed", driver, "Y");
				}
				else{
					System.out.println("fail");
					new HTMLReportHelper().HtmlReportBody("Change Account-Remove Relationship Details", "Could not remove Relationship Details" , "Failed", driver, "Y");
					System.setProperty("runStep","N");
				}
			}
		}
	}

	public void validateAccountDetailsAfterChange_RemoveRelationship(String sAccountNumber,String sName) throws Exception {
		boolean stepResult = false;
		try {
			waitElement(2000);
			clickOnElement("Account Inquiry Page", "Relationship Tab Field",relationshipTab);	
			switchToWithinFrameWithName("bottom");			
			if (!sName.equals("")) {
				validateElementIsNotPresent("Account Inquiry Page","Remove Relationship Name",getDynamicElement("Remove Relationship Name",newNameInquiryPage,sName));
				stepResult = true;
			}
			switchToDefaultContent();
			driver.switchTo().frame("Main");									
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			if (stepResult==true){
				System.out.println("Pass");
				new HTMLReportHelper().HtmlReportBody("Relationship Details Validation", "Validated Relationship Details on Inquiry page Successfully", "Passed", driver, "Y");
			}
			else{
				System.out.println("fail");
				new HTMLReportHelper().HtmlReportBody("Relationship Details Validation", "Could not Validated Relationship Details on Inquiry page" , "Failed", driver, "Y");
			}
		}}

	public void changeAccountMaturityDetails(String sAccountNumber, String sMaturityDate, String sMaturityTerm,
			String sMaturityTermCode, String sMaturityInitialDeposit, String sMaturityIssueDate,
			String sMaturityContractCode, String sMaturityRateMethod) throws Exception {
		if (System.getProperty("runStep") == "Y") {
			boolean stepResult = false;
			try {
				if (isElementPresent(
						getDynamicElement("Account Number Header field", depositChangeHeader, sAccountNumber))) {
					clickOnElement("Change Account Page", "Maturity Tab", maturityTab);
					 if (isElementPresent(maturityLabel)){

						if (!sMaturityDate.equals("")) {
							clearAndType("Change Account Page", "Maturity Date", maturityDate, sMaturityDate);
						}
						if (!sMaturityTerm.equals("")) {
							clearAndType("Change Account Page", "Maturity Term", maturityTerm, sMaturityTerm);
						}
						if (!sMaturityTermCode.equals("")) {
							selectElementByVisibleText("Change Account Page", "Maturity Term Code", maturityTermCodeList,
									sMaturityTermCode);
						}
						if (!sMaturityInitialDeposit.equals("")) {
							clearAndType("Change Account Page", "Maturity Initial Deposit", maturityInitialDeposit, sMaturityInitialDeposit);
						}
						if (!sMaturityIssueDate.equals("")) {
							clearAndType("Change Account Page", "Maturity Issue Date", maturityIssueDate, sMaturityIssueDate);
						}
						if (!sMaturityContractCode.equals("")) {
							selectElementByVisibleText("Change Account Page", "Maturity Contract Date", maturityContractDateList,
									sMaturityContractCode);
						}
						if (!sMaturityRateMethod.equals("")) {
							selectElementByVisibleText("Change Account Page", "Maturity Rate Date", maturityRateDateList,
									sMaturityRateMethod);
						}
						
						stepResult = true;
					 }

				}
			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				if (stepResult == true) {
					System.out.println("Pass");
					new HTMLReportHelper().HtmlReportBody("Change Account Details - Maturity",
							"Account Details - Maturity changed Successfully", "Passed", driver, "Y");
				} else {
					System.out.println("fail");
					new HTMLReportHelper().HtmlReportBody("Change Account Details - Maturity", "Could not change account Details - Maturity",
							"Failed", driver, "Y");
					System.setProperty("runStep", "N");
				}
			}
		}
	}
	
	
	public void validateAccountDetailsMaturityAfterChange(String sAccountNumber, String sMaturityDate, String sMaturityTerm,
			String sMaturityTermCode, String sMaturityInitialDeposit, String sMaturityIssueDate,
			String sMaturityContractCode, String sMaturityRateMethod) throws Exception {
		boolean stepResult = false;
		try {
			waitElement(1000);
			clickOnElement("Account Inquiry Page", "Maturity Tab Field", maturityTab);
			switchToWithinFrameWithName("bottom");
			if (isElementPresent(getDynamicElement("Account Number Header field", depositInquiryHeader, sAccountNumber))) {
				if (!sMaturityDate.equals(""))
					validateElementPresent("Account Inquiry", "Maturity Date",
							getDynamicElement("Maturity Date", verifyMaturityData, sMaturityDate));
				if (!sMaturityTerm.equals(""))
					validateElementPresent("Account Inquiry", "Maturity Term Code",
							getDynamicElement("Maturity Term Code", verifyMaturityData, sMaturityTerm+" "+sMaturityTermCode));
				if (!sMaturityInitialDeposit.equals(""))
					validateElementPresent("Account Inquiry", "Maturity Initial Deposit",
							getDynamicElement("Maturity Initial Deposit", verifyMaturityData, sMaturityInitialDeposit));
				if (!sMaturityIssueDate.equals(""))
					validateElementPresent("Account Inquiry", "Maturity Issue Date",
							getDynamicElement("Maturity Issue Date", verifyMaturityData, sMaturityIssueDate));
				if (!sMaturityContractCode.equals(""))
					validateElementPresent("Account Inquiry", "Maturity Contract Code",
							getDynamicElement("Maturity Contract Code", verifyMaturityData, sMaturityContractCode));
				if (!sMaturityRateMethod.equals(""))
					validateElementPresent("Account Inquiry", "Maturity Rate Method",
							getDynamicElement("Maturity Rate Method", verifyMaturityData, sMaturityRateMethod));
				
				switchToDefaultContent();
				driver.switchTo().frame("Main");
				stepResult = true;

			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (stepResult == true) {
				System.out.println("Pass");
				new HTMLReportHelper().HtmlReportBody("Account Details - Maturity Validation",
						"Validated Account Details - Maturity on Account Inquiry page Successfully", "Passed", driver, "Y");
			} else {
				System.out.println("fail");
				new HTMLReportHelper().HtmlReportBody("Account Details - Maturity Validation",
						"Could not Validated Account Details - Maturity on Account Inquiry page", "Failed", driver, "Y");
			}
		}
	}
	
	public void changeAccountIRADetails(String sAccountNumber, String sDateLastRollover, String sIRAPlan,
			String sIRAStatusCode, String sIRADefaultContributionCode, String sIRADefaultDistributionCode) throws Exception {
		if (System.getProperty("runStep") == "Y") {
			boolean stepResult = false;
			try {
				if (isElementPresent(getDynamicElement("Account Number Header field", depositChangeHeader, sAccountNumber))) {

					if (!sDateLastRollover.equals("")) {
						enterText("Change Account Page", "Date Last Rollover field", dateLastRolloverInput, sDateLastRollover);
					}
					if (!sIRAPlan.equals("")) {
						clickOnElement("Change Account Page", "IRA Plan Input",iRAPlanInput);
						Thread.sleep(1000);
						clickOnElement("Change Account Page", "IRA Plan Button",iRAPlanButton);
						Thread.sleep(1000);
						clickOnElement("Change Account Page", "IRA Plan list",getDynamicElement("IRA Plan list", iRAPlanList,sIRAPlan));
					}
					if (!sIRAStatusCode.equals("")) {
						selectElementByVisibleText("Change Account Page", "IRA Status Code Field", iRAStatusCodeList,sIRAStatusCode);
					}
					if (!sIRADefaultContributionCode.equals("")) {
						selectElementByVisibleText("Change Account Page", "IRA Default Contribution Code Field", iRADefaultContributionCodeList, sIRADefaultContributionCode);
					}
					if (!sIRADefaultDistributionCode.equals("")) {
						selectElementByVisibleText("Change Account Page", "IRA Default Distribution Code Field", iRADefaultDistributionCodeList, sIRADefaultDistributionCode);
					}
					stepResult = true;
				}
			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				if (stepResult == true) {
					System.out.println("Pass");
					new HTMLReportHelper().HtmlReportBody("Change Account Details",
							"Account Details changed Successfully", "Passed", driver, "Y");
				} else {
					System.out.println("fail");
					new HTMLReportHelper().HtmlReportBody("Change Account Details", "Could not change account Details",
							"Failed", driver, "Y");
					System.setProperty("runStep", "N");
				}
			}
		}
	}
	
	public void validateAccountDetailsIRAafterChange(String sAccountNumber, String sIRAPlan,
			String sIRAStatusCode, String sIRADefaultContributionCode, String sIRADefaultDistributionCode) throws Exception {
		boolean stepResult = false;
		try {
			waitElement(1000);
			clickOnElement("Account Inquiry Page", "Codes Tab Field", codesTab);
			switchToWithinFrameWithName("bottom");
			if (isElementPresent(getDynamicElement("Account Number Header field", depositInquiryHeader, sAccountNumber))) {
				clickOnElement("Account Inquiry Page", "Expand Icon for Warning Field", expandWarningInquiryPage);			
				if (!sIRAPlan.equals("")) {
					if (sIRAPlan.contains("[")){
						String[] sIRAPlan_split = sIRAPlan.split("\\[");
						sIRAPlan=sIRAPlan_split[0].trim();
					}
					validateTextContains("Account Inquiry", "IRA Plan field", iRAPlanInquiryPage,sIRAPlan);
				}
				if (!sIRAStatusCode.equals("")) {
					validateTextContains("Account Inquiry", "IRA Status Code field", iRAStatusCodeInquiryPage,sIRAStatusCode);
				}
				if (!sIRADefaultContributionCode.equals("")) {
					validateTextContains("Account Inquiry", "IRA Default Contribution Code field", iRADefaultContributionCodeInquiryPage, sIRADefaultContributionCode);
				}
				if (!sIRADefaultDistributionCode.equals("")) {
					validateTextContains("Account Inquiry", "IRA Default Distribution Code field", iRADefaultDistributionCodeInquiryPage, sIRADefaultDistributionCode);
				}
				switchToDefaultContent();
				driver.switchTo().frame("Main");
				stepResult = true;

			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (stepResult == true) {
				System.out.println("Pass");
				new HTMLReportHelper().HtmlReportBody("Account Details Validation",
						"Validated Account Details on Account Inquiry page Successfully", "Passed", driver, "Y");
			} else {
				System.out.println("fail");
				new HTMLReportHelper().HtmlReportBody("Account Details Validation",
						"Could not Validated Account Details on Account Inquiry page", "Failed", driver, "Y");
			}
		}
	}
	
	public void changeAccountProduct(String sAccountNumber, String sChangeProduct) throws Exception {
		if (System.getProperty("runStep") == "Y") {
			boolean stepResult = false;
			try {
				if (isElementPresent(getDynamicElement("Account Number Header field", depositChangeHeader, sAccountNumber))) {

					if (!sChangeProduct.equals("")) {
						if (sChangeProduct.contains("[")){
							String[] sIRAPlan_split = sChangeProduct.split("\\[");
							sChangeProduct=sIRAPlan_split[0].trim();
						}
						clickOnElement("Change Account Page", "Change Product Image Field", changeProductImg);
						waitElement(3000);
						if (isElementPresent(selectProductTitle)) {
							clickOnElement("Change Account Page", "Product Description Field", getDynamicElement("Product field", changeProductField, sChangeProduct));
							waitElement(3000);
						}
						if (isElementPresent(reviewDefaultsTitle)) {
							//clickOnElement("Change Account Page", "Class CheckBox Field", classCheckbox);
							clickOnElement("Change Account Page", "Check All Checkbox Link Field", checkAllLink);							
							clickOnElement("Change Account Page", "Finish Button Field", finishButton);
							waitElement(3000);
						}
					}				
					stepResult = true;
				}
			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				if (stepResult == true) {
					System.out.println("Pass");
					new HTMLReportHelper().HtmlReportBody("Change Account Details","Account Details changed Successfully", "Passed", driver, "Y");
				} else {
					System.out.println("fail");
					new HTMLReportHelper().HtmlReportBody("Change Account Details", "Could not change account Details","Failed", driver, "Y");
					System.setProperty("runStep", "N");
				}
			}
		}
	}
	
	public void validateAccountProductAfterChange(String sAccountNumber, String sChangeProduct) throws Exception {
		boolean stepResult = false;
		try {
			waitElement(1000);
			//clickOnElement("Account Inquiry Page", "Codes Tab Field", codesTab);
			switchToWithinFrameWithName("bottom");
			if (isElementPresent(getDynamicElement("Account Number Header field", depositInquiryHeader, sAccountNumber))) {
				clickOnElement("Account Inquiry Page", "Expand Icon for Warning Field", expandWarningInquiryPage);
				if (!sChangeProduct.equals(""))
					if (sChangeProduct.contains("[")){
						String[] sIRAPlan_split = sChangeProduct.split("\\[");
						sChangeProduct=sIRAPlan_split[0].trim();
					}
					validateTextContains("Account Inquiry", "Product field", productInquiryPage,sChangeProduct);
				switchToDefaultContent();
				driver.switchTo().frame("Main");
				stepResult = true;
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (stepResult == true) {
				System.out.println("Pass");
				new HTMLReportHelper().HtmlReportBody("Account Details Validation","Validated Account Details on Account Inquiry page Successfully", "Passed", driver, "Y");
			} else {
				System.out.println("fail");
				new HTMLReportHelper().HtmlReportBody("Account Details Validation","Could not Validated Account Details on Account Inquiry page", "Failed", driver, "Y");
			}
		}
	}
	
	public void changeAccountPortfolio(String sAccountNumber, String sChangePortfolio) throws Exception {
		if (System.getProperty("runStep") == "Y") {
			boolean stepResult = false;
			try {
				if (isElementPresent(getDynamicElement("Account Number Header field", depositChangeHeader, sAccountNumber))) {
					if (!sChangePortfolio.equals("")) {
						clickOnElement("Change Account Page", "Change Portfolio Image Field", changePortfolioImg);
						waitElement(3000);
						if (isElementPresent(changePortfolioTitle)) {
							enterText("Change Account Page", "Enter Portfolio field", portfolioNoInput, sChangePortfolio);
							clickOnElement("Change Account Page", "Submit Button Field", submitSearch);
							waitElement(3000);
						}
					}
					stepResult = true;
				}
			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				if (stepResult == true) {
					System.out.println("Pass");
					new HTMLReportHelper().HtmlReportBody("Change Account Details","Account Details changed Successfully", "Passed", driver, "Y");
				} else {
					System.out.println("fail");
					new HTMLReportHelper().HtmlReportBody("Change Account Details", "Could not change account Details","Failed", driver, "Y");
					System.setProperty("runStep", "N");
				}
			}
		}
	}
	
	public void validateAccountPortfolioAfterChange(String sAccountNumber, String sChangePortfolio) throws Exception {
		boolean stepResult = false;
		try {
			waitElement(1000);
			//clickOnElement("Account Inquiry Page", "Codes Tab Field", codesTab);
			switchToWithinFrameWithName("bottom");
			if (isElementPresent(getDynamicElement("Account Number Header field", depositInquiryHeader, sAccountNumber))) {
				clickOnElement("Account Inquiry Page", "Expand Icon for Warning Field", expandWarningInquiryPage);
				if (!sChangePortfolio.equals(""))
					validateTextContains("Account Inquiry", "Product field", portfolioInquiryPage,sChangePortfolio);
				switchToDefaultContent();
				driver.switchTo().frame("Main");
				stepResult = true;
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (stepResult == true) {
				System.out.println("Pass");
				new HTMLReportHelper().HtmlReportBody("Account Details Validation","Validated Account Details on Account Inquiry page Successfully", "Passed", driver, "Y");
			} else {
				System.out.println("fail");
				new HTMLReportHelper().HtmlReportBody("Account Details Validation","Could not Validated Account Details on Account Inquiry page", "Failed", driver, "Y");
			}
		}
	}
	
	public void changeAccountAnalysisItem(String sAccountNumber, String sSelectCharge, String sRecurringFrequency,
			String sItemType, String sCreditBackOverride, String sPerItemAmount, String sRefreshOption,
			String sTransDate, String sTransQuantity, String sTransAmount, String sServiceChargeCycle)throws Exception {
		if (System.getProperty("runStep") == "Y") {
			boolean stepResult = false;
			try {
				if (isElementPresent(getDynamicElement("Account Number Header field", depositChangeHeader, sAccountNumber))) {
					mouseHoverCickOnElement("Change Account Page", "Analysis Items Menu Field", fileMenu, analysisItemsMenu);
					
					switchToWindowWithTitleContaining("Add Charge");
					driver.switchTo().frame("bottom");
					if (isElementPresent(addChargeTitle)) {
						selectElementByVisibleText("Change Account Page", "Select Charge Field",selectChargeList,sSelectCharge);
						clickOnElement("Change Account Page", "Submit Button Field", submitSearch);
					}
					switchToWindowWithTitleContaining("Institution");
					driver.switchTo().frame("Main");
					
					if (isElementPresent(analysisHeaderBar)) {
						if (!sRecurringFrequency.equals("")) {
							selectElementByVisibleText("Change Account Page", "Recurring Frequency field", recurringfrequencyList, sRecurringFrequency);
						}
						if (!sItemType.equals("")) {
							selectElementByVisibleText("Change Account Page", "Item Type field", itemTypeList,sItemType);
						}
						if (!sCreditBackOverride.equals("")) {
							selectElementByVisibleText("Change Account Page", "Credit Back Override field", creditBackOverrideList, sCreditBackOverride);
						}

						if (!sPerItemAmount.equals("")) {
							clearAndType("Change Account Page", "Per Item Amount field", perItemAmountInput, sPerItemAmount);
						}

						if (!sRefreshOption.equals("")) {
							selectElementByVisibleText("Change Account Page", "Refresh Option field", refreshOptionList,sRefreshOption);
						}

						if (!sTransDate.equals("")) {
							clearAndType("Change Account Page", "Trans Date field", transDateInput, sTransDate);
						}

						if (!sTransQuantity.equals("")) {
							clearAndType("Change Account Page", "Trans Quantity field", transQuantityInput,sTransQuantity);
						}

						if (!sTransAmount.equals("")) {
							clearAndType("Change Account Page", "Trans Amount field", transTotalAmountInput,sTransAmount);
						}
						if (!sServiceChargeCycle.equals("")) {
							clickOnElement("Account Inquiry Page", "Balances Tab Field", balanceTab);
							waitElement(5000);
							selectElementByVisibleText("Change Account Page", "Service Charge Cycle field", serviceChargeCycleList,sServiceChargeCycle);
						}
						stepResult = true;
					}
				}
			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				if (stepResult == true) {
					System.out.println("Pass");
					new HTMLReportHelper().HtmlReportBody("Change Account - Analysis Items Details",
							"Account Details - Analysis Items changed Successfully", "Passed", driver, "Y");
				} else {
					System.out.println("fail");
					new HTMLReportHelper().HtmlReportBody("Change Account - Analysis Items Details",
							"Could not change account Details- Analysis Items", "Failed", driver, "Y");
					System.setProperty("runStep", "N");
				}
			}
		}
	}
	
	public void validateAccountAnalysisItemAfterChange(String sAccountNumber, String sSelectCharge) throws Exception {
		boolean stepResult = false;
		try {
			mouseHoverCickOnElement("Change Account Page", "Overdrafts Menu Field", activityMenu, analysisItemsMenu);
			waitElement(1000);
			switchToWithinFrameWithName("bottom");
			if (isElementPresent(getDynamicElement("Account Number Header field", depositInquiryHeader, sAccountNumber))) {
				if (isElementPresent(getDynamicElement("Analysis Item - Charge field", selectChargeInquiryPage, sSelectCharge))) {
					stepResult = true;
				}
				switchToDefaultContent();
				driver.switchTo().frame("Main");

			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (stepResult == true) {
				System.out.println("Pass");
				new HTMLReportHelper().HtmlReportBody("Account Details - Analysis Items Validation",
						"Validated Account Details - Analysis Items on Account Inquiry page Successfully", "Passed", driver,"Y");
			} else {
				System.out.println("fail");
				new HTMLReportHelper().HtmlReportBody("Account Details - Analysis Items  Validation",
						"Could not Validated Account Details - Analysis Items on Account Inquiry page", "Failed", driver,"Y");
			}
		}
	}
	
	public void validateAccountAnalysisItemServiceChargeAfterChange(String sAccountNumber, String sSelectCharge,String sServiceChargeCycle) throws Exception {
		boolean stepResult = false;
		try {
			//mouseHoverCickOnElement("Change Account Page", "Overdrafts Menu Field", activityMenu, analysisItemsMenu);
			waitElement(1000);
			switchToWithinFrameWithName("bottom");
			if (isElementPresent(getDynamicElement("Account Number Header field", depositInquiryHeader, sAccountNumber))) {
				if (!sServiceChargeCycle.equals("")) {
					validateTextContains("Account Inquiry", "Service Charge Cycle field", serviceChargeCycleInquiryPage,sServiceChargeCycle);
				}
				if (isElementPresent(getDynamicElement("Analysis Item - Charge field", selectChargeInquiryPage, sSelectCharge))) {
					stepResult = true;
				}
				switchToDefaultContent();
				driver.switchTo().frame("Main");
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (stepResult == true) {
				System.out.println("Pass");
				new HTMLReportHelper().HtmlReportBody("Account Details - Analysis Items Validation",
						"Validated Account Details - Analysis Items on Account Inquiry page Successfully", "Passed", driver,"Y");
			} else {
				System.out.println("fail");
				new HTMLReportHelper().HtmlReportBody("Account Details - Analysis Items  Validation",
						"Could not Validated Account Details - Analysis Items on Account Inquiry page", "Failed", driver,"Y");
			}
		}
	}
	
	public void changeAccountCodeDetails2(String sAccountNumber, String sBranchRegion, String sAccountingMethod,
			String sCostCenter, String sAccountOpenedMethod, String sRetentionCodeOverride) throws Exception {
		if (System.getProperty("runStep") == "Y") {
			boolean stepResult = false;
			try {
				if (isElementPresent(getDynamicElement("Account Number Header field", depositChangeHeader, sAccountNumber))) {
					if (!sBranchRegion.equals("")) {
						clickOnElement("Change Account Page", "Branch Region Input",branchRegionTextbox);
						Thread.sleep(1000);
						clickOnElement("Change Account Page", "Branch Region Button",branchRegionButton);
						Thread.sleep(1000);
						clickOnElement("Change Account Page", "Branch Region list",getDynamicElement("Branch Region list", branchRegionList,sBranchRegion));
					}
					if (!sAccountingMethod.equals("")) {
						selectElementByVisibleText("Change Account Page", "Accounting Method Field", accountMethodList,sAccountingMethod);
					}
					if (!sCostCenter.equals("")) {
						clearAndType("Change Account Page", "Cost Center Field", costCenterInput,sCostCenter);
					}
					if (!sAccountOpenedMethod.equals("")) {
						clickOnElement("Change Account Page", "Account Opened Method Input",accountOpenMethodTextbox);
						Thread.sleep(1000);
						clickOnElement("Change Account Page", "Account Opened Method Button",accountOpenMethodButton);
						Thread.sleep(1000);
						clickOnElement("Change Account Page", "Account Opened Method list",getDynamicElement("Account Opened Method list", accountOpenMethodList,sAccountOpenedMethod));
					}
					if (!sRetentionCodeOverride.equals("")) {
						selectElementByVisibleText("Change Account Page", "Retention Code Override Field", retentionCodeOverrideList,sRetentionCodeOverride);
					}
					stepResult = true;

				}
			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				if (stepResult == true) {
					System.out.println("Pass");
					new HTMLReportHelper().HtmlReportBody("Change Account Details","Account Details changed Successfully", "Passed", driver, "Y");
				} else {
					System.out.println("fail");
					new HTMLReportHelper().HtmlReportBody("Change Account Details", "Could not change account Details","Failed", driver, "Y");
					System.setProperty("runStep", "N");
				}
			}
		}
	}
	
	public void validateAccountDetailsAfterChange2(String sAccountNumber, String sBranchRegion, String sAccountingMethod,
			String sCostCenter, String sAccountOpenedMethod, String sRetentionCodeOverride) throws Exception {
		boolean stepResult = false;
		try {
			waitElement(1000);
			clickOnElement("Account Inquiry Page", "Codes Tab Field", codesTab);
			switchToWithinFrameWithName("bottom");
			if (isElementPresent(getDynamicElement("Account Number Header field", depositInquiryHeader, sAccountNumber))) {
				clickOnElement("Account Inquiry Page", "Expand Icon for Warning Field", expandWarningInquiryPage);
				if (!sBranchRegion.equals("")) {
					if (sBranchRegion.contains("[")){
						String[] sBranchRegion_split = sBranchRegion.split("\\[");
						sBranchRegion=sBranchRegion_split[0].trim();
					}
					validateTextContains("Account Inquiry", "Branch Region field", branchRegionInquiryPage,sBranchRegion);
				}
				if (!sAccountingMethod.equals("")) {
					validateTextContains("Account Inquiry", "Accounting Method field", accountingMethodInquiryPage, sAccountingMethod);
				}
				if (!sCostCenter.equals("")) {
					validateTextContains("Account Inquiry", "Cost Center field", costCenterInquiryPage, sCostCenter);
				}
				if (!sAccountOpenedMethod.equals("")) {
					if (sAccountOpenedMethod.contains("[")){
						String[] sAccountOpenedMethod_split = sAccountOpenedMethod.split("\\[");
						sAccountOpenedMethod=sAccountOpenedMethod_split[0].trim();
					}
					validateTextContains("Account Inquiry", "Account Opened Method field", accountOpenedMethodInquiryPage, sAccountOpenedMethod);
				}
				if (!sRetentionCodeOverride.equals("")) {
					validateTextContains("Account Inquiry", "Retention Code Override field", retentionCodeOverrideInquiryPage, sRetentionCodeOverride);
				}
				switchToDefaultContent();
				driver.switchTo().frame("Main");
				stepResult = true;

			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (stepResult == true) {
				System.out.println("Pass");
				new HTMLReportHelper().HtmlReportBody("Account Details Validation","Validated Account Details on Account Inquiry page Successfully", "Passed", driver, "Y");
			} else {
				System.out.println("fail");
				new HTMLReportHelper().HtmlReportBody("Account Details Validation","Could not Validated Account Details on Account Inquiry page", "Failed", driver, "Y");
			}
		}
	}
	
	public void changeAccountBalanceDetails(String sAccountNumber, String sDepositRateIndex, String sInterestCycle)throws Exception {
		if (System.getProperty("runStep") == "Y") {
			boolean stepResult = false;
			try {
				if (isElementPresent(getDynamicElement("Account Number Header field", depositChangeHeader, sAccountNumber))) {
					clickOnElement("Account Inquiry Page", "Balances Tab Field", balanceTab);
					waitElement(5000);
						if (!sDepositRateIndex.equals("")) {	
							clickOnElement("Change Account Page", "Deposit Rate Index Input",depositRateIndexTextbox);
							Thread.sleep(1000);
							clickOnElement("Change Account Page", "Deposit Rate Index Button",depositRateIndexButton);
							Thread.sleep(1000);
							clickOnElement("Change Account Page", "Deposit Rate Index list",getDynamicElement("Deposit Rate Index list", depositRateIndexList,sDepositRateIndex));
						}
						if (!sInterestCycle.equals("")) {	
							selectElementByVisibleText("Change Account Page", "Interest Cycle Field", interestCycleList,sInterestCycle);
						}
						stepResult = true;
					}
			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				if (stepResult == true) {
					System.out.println("Pass");
					new HTMLReportHelper().HtmlReportBody("Change Account - Balance Details","Account Details - Balance details changed Successfully", "Passed", driver, "Y");
				} else {
					System.out.println("fail");
					new HTMLReportHelper().HtmlReportBody("Change Account - Balance Details","Could not change account Details- Balance details", "Failed", driver, "Y");
					System.setProperty("runStep", "N");
				}
			}
		}
	}
	
	public void changeAccountBalanceDetailsSavings(String sAccountNumber, String sDepositRateIndex, String sInterestCycle)throws Exception {
		if (System.getProperty("runStep") == "Y") {
			boolean stepResult = false;
			try {
				if (isElementPresent(getDynamicElement("Account Number Header field", depositChangeHeader, sAccountNumber))) {
					clickOnElement("Account Inquiry Page", "Balances Tab Field", balanceTab);
					waitElement(5000);
						if (!sDepositRateIndex.equals("")) {	
							clickOnElement("Change Account Page", "Deposit Rate Index Input",depositRateIndexTextboxSavings);
							Thread.sleep(1000);
							clickOnElement("Change Account Page", "Deposit Rate Index Button",depositRateIndexButtonSavings);
							Thread.sleep(1000);
							clickOnElement("Change Account Page", "Deposit Rate Index list",getDynamicElement("Deposit Rate Index list", depositRateIndexListSavings,sDepositRateIndex));
						}
						if (!sInterestCycle.equals("")) {	
							selectElementByVisibleText("Change Account Page", "Interest Cycle Field", interestCycleListSavings,sInterestCycle);
						}
						stepResult = true;
					}
			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				if (stepResult == true) {
					System.out.println("Pass");
					new HTMLReportHelper().HtmlReportBody("Change Account - Balance Details","Account Details - Balance details changed Successfully", "Passed", driver, "Y");
				} else {
					System.out.println("fail");
					new HTMLReportHelper().HtmlReportBody("Change Account - Balance Details","Could not change account Details- Balance details", "Failed", driver, "Y");
					System.setProperty("runStep", "N");
				}
			}
		}
	}
	
	public void validateAccountBalanceDetailsAfterChange(String sAccountNumber, String sDepositRateIndex, String sInterestCycle) throws Exception {
		boolean stepResult = false;
		try {
			waitElement(1000);
			switchToWithinFrameWithName("bottom");
			if (isElementPresent(getDynamicElement("Account Number Header field", depositInquiryHeader, sAccountNumber))) {
				if (!sDepositRateIndex.equals("")) {
					if (sDepositRateIndex.contains("[")){
						String[] sDepositRateIndex_split = sDepositRateIndex.split("\\[");
						sDepositRateIndex=sDepositRateIndex_split[0].trim();
					}
					validateTextContains("Account Inquiry", "Deposit Rate Index field", depositRateIndexInquiryPage,sDepositRateIndex);
				}
				if (!sInterestCycle.equals("")) {
					validateTextContains("Account Inquiry", "Interest Cycle field", interestCycleInquiryPage,sInterestCycle);
				}
				stepResult = true;
				switchToDefaultContent();
				driver.switchTo().frame("Main");
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (stepResult == true) {
				System.out.println("Pass");
				new HTMLReportHelper().HtmlReportBody("Account Details - Balance Tab Validation","Validated Account Details - Balance Tab on Account Inquiry page Successfully", "Passed", driver,"Y");
			} else {
				System.out.println("fail");
				new HTMLReportHelper().HtmlReportBody("Account Details - Balance Tab  Validation","Could not Validated Account Details - Balance Tab on Account Inquiry page", "Failed", driver,"Y");
			}
		}
	}

	public void changeAccountTransfer(String sAccountNumber, String sNextTransferDate, String sNextTransferAmount,
			String sCredittoAccountType, String sCredittoAccount, String sExpirationDate, String sTransferFrequency,
			String sTransferDay, String sTransferCycle, String sNotificationCode)throws Exception {
		if (System.getProperty("runStep") == "Y") {
			boolean stepResult = false;
			try {
				if (isElementPresent(getDynamicElement("Account Number Header field", depositChangeHeader, sAccountNumber))) {
					mouseHoverCickOnElement("Change Account Page", "Transfer Menu Field", fileMenu, transferMenu);
					if (isElementPresent(transferLabel)) {
						if (!sNextTransferDate.equals("")) {
							clearAndType("Change Account Page", "Next Transfer Date field", nextTransferDateInput, sNextTransferDate);
						}

						if (!sNextTransferAmount.equals("")) {
							clearAndType("Change Account Page", "Next Transfer Amount field", nextTransferAmountInput,sNextTransferAmount);
						}

						if (!sCredittoAccountType.equals("")) {
							selectElementByVisibleText("Change Account Page", "Credit to Account Type field", creditToTypeList,sCredittoAccountType);
						}

						if (!sCredittoAccount.equals("")) {
							clearAndType("Change Account Page", "Credit to Account field", creditToAccountInput,sCredittoAccount);
						}

						if (!sExpirationDate.equals("")) {
							clearAndType("Change Account Page", "Expiration Date field", expirationDateInput,sExpirationDate);
						}

						if (!sTransferFrequency.equals("")) {
							selectElementByVisibleText("Change Account Page", "Transfer Frequency field", transferFrequencyList,sTransferFrequency);
						}

						if (!sTransferDay.equals("")) {
							clearAndType("Change Account Page", "Transfer Day field", transferDayInput,sTransferDay);
						}

						if (!sTransferCycle.equals("")) {
							selectElementByVisibleText("Change Account Page", "Transfer Cycle field", transferCycleList, sTransferCycle);
						}

						if (!sNotificationCode.equals("")) {
							selectElementByVisibleText("Change Account Page", "Notification Code field", notificationCodeList, sNotificationCode);
						}
						stepResult = true;
					}
				}
			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				if (stepResult == true) {
					System.out.println("Pass");
					new HTMLReportHelper().HtmlReportBody("Change Account - Transfer Details","Account Details - Transfer changed Successfully", "Passed", driver, "Y");
				} else {
					System.out.println("fail");
					new HTMLReportHelper().HtmlReportBody("Change Account - Transfer Details","Could not change account Details- Transfer", "Failed", driver, "Y");
					System.setProperty("runStep", "N");
				}
			}
		}
	}
	
	public void validateAccountTransferAfterChange(String sAccountNumber, String sNextTransferDate, String sNextTransferAmount,
			String sCredittoAccountType, String sCredittoAccount, String sExpirationDate, String sTransferFrequency,
			String sTransferDay, String sTransferCycle, String sNotificationCode) throws Exception {
		boolean stepResult = false;
		try {
			mouseHoverCickOnElement("Change Account Page", "Transfer Menu Field", activityMenu, transferMenu);
			waitElement(1000);
			switchToWithinFrameWithName("bottom");
			if (isElementPresent(getDynamicElement("Account Number Header field", depositInquiryHeader, sAccountNumber))) {
				if (isElementPresent(transferInquirylabel)) {

					if (!sNextTransferDate.equals(""))
						validateTextContains("Account Inquiry", "Next Transfer Date field", nextTransferDateInquiryPage,sNextTransferDate);
					
					if (!sNextTransferAmount.equals(""))
						validateTextContains("Account Inquiry", "Next Transfer Amount field", nextTransferAmountInquiryPage,sNextTransferAmount);
					
					if (!sCredittoAccount.equals(""))
						validateElementPresent("Account Inquiry", "Credit to Account field",
								getDynamicElement("Credit to Account field", creditToAccountNo, sCredittoAccount));

					if (!sExpirationDate.equals(""))
						validateTextContains("Account Inquiry", "Expiration Date field", expirationDateInquiryPage,sExpirationDate);
					
					if (!sTransferFrequency.equals(""))
						validateTextContains("Account Inquiry", "Transfer Frequency field", transferFrequencyInquiryPage,sTransferFrequency);
					
					if (!sTransferDay.equals(""))
						validateTextContains("Account Inquiry", "Transfer Day field", transferDayInquiryPage,sTransferDay);
					
					if (!sNotificationCode.equals(""))
						validateTextContains("Account Inquiry", "Notification Code field", notificationCodeInquiryPage,sNotificationCode);
					
					stepResult = true;
				}
				switchToDefaultContent();
				driver.switchTo().frame("Main");
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (stepResult == true) {
				System.out.println("Pass");
				new HTMLReportHelper().HtmlReportBody("Account Details -Transfer Validation","Validated Account Details - Transfer on Account Inquiry page Successfully", "Passed", driver,"Y");
			} else {
				System.out.println("fail");
				new HTMLReportHelper().HtmlReportBody("Account Details - Transfer  Validation","Could not Validated Account Details - Transfer on Account Inquiry page", "Failed", driver,"Y");
			}
		}
	}
	
	public void changeAccountAddBeneficiary(String sAccountNumber, String sBeneficiarySSN, String sBeneficiaryAddress,
			String sBeneficiaryRelationship, String sBeneficiaryPercent)throws Exception {
		if (System.getProperty("runStep") == "Y") {
			boolean stepResult = false;
			try {
				if (isElementPresent(getDynamicElement("Account Number Header field", depositChangeHeader, sAccountNumber))) {
					mouseHoverCickOnElement("Change Account Page", "Beneficiary Menu Field", fileMenu, beneficiaryMenu);
					if (isElementPresent(beneficiaryLabel)) {
						if (!sBeneficiarySSN.equals("")) {
								clickOnElement("Change Account Page", "Search Name", searchNameImg);
								Thread.sleep(4000);
								switchToWindowWithTitleContaining("Name Search");
								Thread.sleep(4000);
								driver.switchTo().frame("bottom");
								new Premier_CustomerContact(driver).searchSSN(sBeneficiarySSN);
								Thread.sleep(4000);
								switchToWindowWithTitleContaining("Institution");
								driver.switchTo().frame("Main");
						}
						if (!sBeneficiaryAddress.equals("")) {
							clickOnElement("Change Account Page", "Search Address", searchAddress);
							Thread.sleep(4000);
							switchToWindowWithTitleContaining("Address Search");
							Thread.sleep(4000);
							driver.switchTo().frame("bottom");
							new Premier_CustomerAddress(driver).searchAddress(sBeneficiaryAddress);
							Thread.sleep(4000);
							switchToWindowWithTitleContaining("Institution");
							driver.switchTo().frame("Main");
						}
						if (!sBeneficiaryRelationship.equals("")) {
							clearAndType("Change Account Page", "Beneficiary Relationship field", beneRelationsipInput,sBeneficiaryRelationship);
						}
						if (!sBeneficiaryPercent.equals("")) {
							clearAndType("Change Account Page", "Beneficiary Percent field", benePercentInput,sBeneficiaryPercent);
						}
						stepResult = true;
					}
				}
			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				if (stepResult == true) {
					System.out.println("Pass");
					new HTMLReportHelper().HtmlReportBody("Change Account - Beneficiary Details","Account Details - Beneficiary changed Successfully", "Passed", driver, "Y");
				} else {
					System.out.println("fail");
					new HTMLReportHelper().HtmlReportBody("Change Account - Beneficiary Details","Could not change account Details- Beneficiary", "Failed", driver, "Y");
					System.setProperty("runStep", "N");
				}
			}
		}
	}
	
	public void validateAccountAddBeneficiaryAfterChange(String sAccountNumber, String sBeneficiarySSN, String sBeneficiaryAddress,
			String sBeneficiaryRelationship, String sBeneficiaryPercent) throws Exception {
		boolean stepResult = false;
		try {
			clickOnElement("Account Inquiry Page", "Relationship Tab Field",relationshipTab);
			waitElement(1000);
			switchToWithinFrameWithName("bottom");
			if (isElementPresent(getDynamicElement("Account Number Header field", depositInquiryHeader, sAccountNumber))) {
				if (isElementPresent(beneficiaryInquirylabel)) {

					if (!sBeneficiarySSN.equals(""))
						validateTextContains("Account Inquiry", "Beneficiary SSN field", beneficiarySSNInquiryPage,sBeneficiarySSN);
					
					if (!sBeneficiaryAddress.equals(""))
						validateElementPresent("Account Inquiry", "Beneficiary Address field",
								getDynamicElement("Beneficiary Address field", beneAddress, sBeneficiaryAddress));
					
					if (!sBeneficiaryRelationship.equals(""))
						validateTextContains("Account Inquiry", "Beneficiary Relationship field", beneficiaryRelationshipInquiryPage,sBeneficiaryRelationship);
					
					if (!sBeneficiaryPercent.equals(""))
						validateTextContains("Account Inquiry", "Beneficiary Percent field", beneficiaryPercentInquiryPage,sBeneficiaryPercent);
					
					stepResult = true;
				}
				switchToDefaultContent();
				driver.switchTo().frame("Main");
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (stepResult == true) {
				System.out.println("Pass");
				new HTMLReportHelper().HtmlReportBody("Account Details -Beneficiary Validation","Validated Account Details - Beneficiary on Account Inquiry page Successfully", "Passed", driver,"Y");
			} else {
				System.out.println("fail");
				new HTMLReportHelper().HtmlReportBody("Account Details - Beneficiary  Validation","Could not Validated Account Details - Beneficiary on Account Inquiry page", "Failed", driver,"Y");
			}
		}
	}
	
	public void changeAccountUpdateBeneficiary(String sAccountNumber, String sBeneficiarySSN, String sBeneficiaryAddress,
			String sBeneficiaryRelationship, String sBeneficiaryPercent)throws Exception {
		if (System.getProperty("runStep") == "Y") {
			boolean stepResult = false;
			try {
				if (isElementPresent(getDynamicElement("Account Number Header field", depositChangeHeader, sAccountNumber))) {
					mouseHoverCickOnElement("Change Account Page", "Beneficiary Menu Field", relationshipTab, beneficiaryMenu2);
					if (isElementPresent(beneficiaryLabel)) {
						new HTMLReportHelper().HtmlReportBody("Change Account - Beneficiary Details","Account Details - Beneficiary details page", "Passed", driver, "Y");
						if (!sBeneficiarySSN.equals("")) {
								clickOnElement("Change Account Page", "Search Name", searchNameImg);
								Thread.sleep(4000);
								switchToWindowWithTitleContaining("Name Search");
								Thread.sleep(4000);
								driver.switchTo().frame("bottom");
								new Premier_CustomerContact(driver).searchSSN(sBeneficiarySSN);
								Thread.sleep(4000);
								switchToWindowWithTitleContaining("Institution");
								driver.switchTo().frame("Main");
						}
						if (!sBeneficiaryAddress.equals("")) {
							clickOnElement("Change Account Page", "Search Address", searchAddress);
							Thread.sleep(4000);
							switchToWindowWithTitleContaining("Address Search");
							Thread.sleep(4000);
							driver.switchTo().frame("bottom");
							new Premier_CustomerAddress(driver).searchAddress(sBeneficiaryAddress);
							Thread.sleep(4000);
							switchToWindowWithTitleContaining("Institution");
							driver.switchTo().frame("Main");
						}
						if (!sBeneficiaryRelationship.equals("")) {
							clearAndType("Change Account Page", "Beneficiary Relationship field", beneRelationsipInput,sBeneficiaryRelationship);
						}
						if (!sBeneficiaryPercent.equals("")) {
							clearAndType("Change Account Page", "Beneficiary Percent field", benePercentInput,sBeneficiaryPercent);
						}
						stepResult = true;
					}
				}
			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				if (stepResult == true) {
					System.out.println("Pass");
					new HTMLReportHelper().HtmlReportBody("Change Account - Beneficiary Details","Account Details - Beneficiary changed Successfully", "Passed", driver, "Y");
				} else {
					System.out.println("fail");
					new HTMLReportHelper().HtmlReportBody("Change Account - Beneficiary Details","Could not change account Details- Beneficiary", "Failed", driver, "Y");
					System.setProperty("runStep", "N");
				}
			}
		}
	}
	
	public void removeAccountHold(String sAccountNumber,String sHoldReason) throws Exception {
		if (System.getProperty("runStep") == "Y") {
			boolean stepResult = false;
			try {
				if (isElementPresent(getDynamicElement("Account Number Header field", depositChangeHeader, sAccountNumber))) {
					mouseHoverCickOnElement("Change Account Page", "Hold Menu Field", balanceTab, holdMenuBalances);
					if (isElementPresent(holdTitle)) {
						if (!sHoldReason.equals("")) {
							clickOnElement("Change Account Page", "Remove Hold Icon", getDynamicElement("Remove Hold Icon field", removeHoldICon, sHoldReason));
						}
						driver.switchTo().alert().accept();
						waitElement(3000);
						driver.switchTo().defaultContent();
						driver.switchTo().frame("Main");
						stepResult = true;
					}
				}
			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				if (stepResult == true) {
					System.out.println("Pass");
					new HTMLReportHelper().HtmlReportBody("Remove Account - Hold Details","Account - Hold Details Remove Successfully", "Passed", driver, "Y");
				} else {
					System.out.println("fail");
					new HTMLReportHelper().HtmlReportBody("Remove Account - Hold Details","Could not Remove account - Hold Details", "Failed", driver, "Y");
					System.setProperty("runStep", "N");
				}
			}
		}
	}
	
	public void validateAccountHoldDetailsAfterRemove(String sAccountNumber, String sVerifyHoldReason) throws Exception {
		boolean stepResult = false;
		try {
			waitElement(1000);
			switchToWithinFrameWithName("bottom");
			if (isElementPresent(getDynamicElement("Account Number Header field", depositInquiryHeader, sAccountNumber))) {
				waitElement(2000);
					if (!sVerifyHoldReason.equals("")) {
						if (isElementPresentZeroWait(getDynamicElement("Hold Reason field", verifyHoldData, sVerifyHoldReason))) {
							stepResult = false;
						}else {
							stepResult = true;
						}	
					}	
				switchToDefaultContent();
				driver.switchTo().frame("Main");
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (stepResult == true) {
				System.out.println("Pass");
				new HTMLReportHelper().HtmlReportBody("Account Details - Hold Validation",
						"Validated Account Details - Hold info removed from Account Inquiry page Successfully", "Passed", driver, "Y");
			} else {
				System.out.println("fail");
				new HTMLReportHelper().HtmlReportBody("Account Details - Hold Validation",
						"Could not Validated Account Details - removed Hold info from Account Inquiry page", "Failed", driver, "Y");
			}
		}
	}
	
	public void removeAccountTransfer(String sAccountNumber,String sCredittoAccountType,String sCredittoAccount) throws Exception {
		if (System.getProperty("runStep") == "Y") {
			boolean stepResult = false;
			try {
				if (isElementPresent(getDynamicElement("Account Number Header field", depositChangeHeader, sAccountNumber))) {
					mouseHoverCickOnElement("Change Account Page", "Transfer Menu Field", activityMenu, transferMenuActivity);
					if (isElementPresent(transferTitle)) {
						if (!sCredittoAccount.equals("")) {
							clickOnElement("Change Account Page", "Remove Transfer Icon", getDynamicElement("Remove Transfer Icon field", removeTransferICon, sCredittoAccount));
						}
						driver.switchTo().alert().accept();
						waitElement(3000);
						driver.switchTo().defaultContent();
						driver.switchTo().frame("Main");
						stepResult = true;
					}
				}
			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				if (stepResult == true) {
					System.out.println("Pass");
					new HTMLReportHelper().HtmlReportBody("Remove Account - Transfer Details","Account - Transfer Details Remove Successfully", "Passed", driver, "Y");
				} else {
					System.out.println("fail");
					new HTMLReportHelper().HtmlReportBody("Remove Account - Transfer Details","Could not Remove account - Transfer Details", "Failed", driver, "Y");
					System.setProperty("runStep", "N");
				}
			}
		}
	}
	
	public void validateAccountTransferDetailsAfterRemove(String sAccountNumber,String sCredittoAccountType, String sCredittoAccount) throws Exception {
		boolean stepResult = false;
		try {
			mouseHoverOnElement("Change Account Page", "Activity Menu Field", activityMenu);
			waitElement(1000);
			if(isElementPresentZeroWait(transferMenu)) {
				mouseHoverCickOnElement("Change Account Page", "Transfer Menu Field", activityMenu, transferMenu);
				waitElement(1000);
				switchToWithinFrameWithName("bottom");
				if (isElementPresent(getDynamicElement("Account Number Header field", depositInquiryHeader, sAccountNumber))) {
						if(isElementNotPresentZeroWait(getDynamicElement("Credit to Account field", creditToAccountNoTransfer, sCredittoAccount))){
							stepResult = false;
						}else {
							stepResult = true;
						}
				}
			}else {
				stepResult = true;
			}
				switchToDefaultContent();
				driver.switchTo().frame("Main");
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (stepResult == true) {
				System.out.println("Pass");
				new HTMLReportHelper().HtmlReportBody("Account Details - Transfer Validation",
						"Validated Account Details - Transfer info removed from Account Inquiry page Successfully", "Passed", driver, "Y");
			} else {
				System.out.println("fail");
				new HTMLReportHelper().HtmlReportBody("Account Details - Transfer Validation",
						"Could not Validated Account Details - removed Transfer info from Account Inquiry page", "Failed", driver, "Y");
			}
		}
	}
	
	public void removeAccountStopPays(String sAccountNumber,String sStopPayPayee) throws Exception {
		if (System.getProperty("runStep") == "Y") {
			boolean stepResult = false;
			try {
				if (isElementPresent(getDynamicElement("Account Number Header field", depositChangeHeader, sAccountNumber))) {
					mouseHoverCickOnElement("Change Account Page", "Transfer Menu Field", activityMenu, stopPaysMenuActivity);
					if (isElementPresent(stopPaysTitle)) {
						if (!sStopPayPayee.equals("")) {
							clickOnElement("Change Account Page", "Remove Stop Pay Icon", getDynamicElement("Remove Stop Pay Icon field", removeStopPayICon, sStopPayPayee));
						}
						//driver.switchTo().alert().accept();
						//waitElement(3000);
						//driver.switchTo().defaultContent();
						//driver.switchTo().frame("Main");
						stepResult = true;
					}
				}
			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				if (stepResult == true) {
					System.out.println("Pass");
					new HTMLReportHelper().HtmlReportBody("Remove Account - Stop Pay Details","Account - Stop Pay Details Remove Successfully", "Passed", driver, "Y");
				} else {
					System.out.println("fail");
					new HTMLReportHelper().HtmlReportBody("Remove Account - Stop Pay Details","Could not Remove account - Stop Pay Details", "Failed", driver, "Y");
					System.setProperty("runStep", "N");
				}
			}
		}
	}
	
	public void validateAccountStopPayDetailsAfterRemove(String sAccountNumber,String sStopPayPayee) throws Exception {
		boolean stepResult = false;
		try {
			mouseHoverOnElement("Change Account Page", "Activity Menu Field", activityMenu);
			waitElement(1000);
			if(isElementPresentZeroWait(stopPaysMenuActivity)) {
				mouseHoverCickOnElement("Change Account Page", "Transfer Menu Field", activityMenu, stopPaysMenuActivity);
				waitElement(1000);
				switchToWithinFrameWithName("bottom");
				if (isElementPresent(getDynamicElement("Account Number Header field", depositInquiryHeader, sAccountNumber))) {
						if(isElementNotPresentZeroWait(getDynamicElement("Stop Pay Payee Name field", stopPayeeName, sStopPayPayee))){
							stepResult = false;
						}else {
							stepResult = true;
						}
				}
			}else {
				stepResult = true;
			}
				switchToDefaultContent();
				driver.switchTo().frame("Main");
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (stepResult == true) {
				System.out.println("Pass");
				new HTMLReportHelper().HtmlReportBody("Account Details - Stop Pay Validation",
						"Validated Account Details - Stop Pay info removed from Account Inquiry page Successfully", "Passed", driver, "Y");
			} else {
				System.out.println("fail");
				new HTMLReportHelper().HtmlReportBody("Account Details - Stop Pay Validation",
						"Could not Validated Account Details - removed Stop Pay info from Account Inquiry page", "Failed", driver, "Y");
			}
		}
	}
}
