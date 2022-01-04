package testframe.application.premier.businessflow;

import java.util.List;
import java.util.Map;

import testframe.common.utilities.DateTimeHelper;

public class PremierCommonNavigation extends PremierTest{
	
	
	
	public void customerInquiry(String strLastName, String TaxID,String strName, String strPhoneNum, String strEmail, 
			String strAddress1,String strAddress2,String strZipCode,String sSSNRelationship,String sBeneficialOnwerName) throws Exception{
		Thread.sleep(3000);
		premierHomeMenuPage.customerInquiry();
		premierCustomerInquiryPage.searchCustomer(strLastName, TaxID);
		premierCustomerInquiryPage.seeAdditionalAddresses();
		premierCustomerInquiryPage.customerExpand();
		premierCustomerInquiryPage.validateCustomerDetails(strName,TaxID,strPhoneNum,strEmail,strAddress1,strAddress2,strZipCode,sSSNRelationship,sBeneficialOnwerName);
	}
	
	public void customerCreationAndInquire(List<Map<String, String>> mTC_Test_Data,int iTestDataRow,String sCustomerInquireFlag) throws Exception{
		premierHomeMenuPage.customerMenu();
		strName  = mTC_Test_Data.get(iTestDataRow).get("Name_Name");
		strName_Split = strName.split("\\|\\|");
		for (int i = 0; i<=strName_Split.length-1;i++) {
			
			sName = strName_Split[i];
			sFName = (mTC_Test_Data.get(iTestDataRow).get("Name_FirstName").split("\\|\\|"))[i];
			sLName = (mTC_Test_Data.get(iTestDataRow).get("Name_LastName").split("\\|\\|"))[i];
			sDOB = (mTC_Test_Data.get(iTestDataRow).get("Name_DOB").split("\\|\\|"))[i];
			sTaxIDCode = (mTC_Test_Data.get(iTestDataRow).get("Name_TaxIDCode").split("\\|\\|"))[i];
			sTaxIdentification = (mTC_Test_Data.get(iTestDataRow).get("Name_TaxIdentification").split("\\|\\|"))[i];

			if ((mTC_Test_Data.get(iTestDataRow).get("Name_Alt_Name")).contains("||") && strName.contains("||")) {
				sAltName = (mTC_Test_Data.get(iTestDataRow).get("Name_Alt_Name").split("\\|\\|"))[i];
			}else{
				sAltName = mTC_Test_Data.get(iTestDataRow).get("Name_Alt_Name");
			}

			if ((mTC_Test_Data.get(iTestDataRow).get("Name_Alt_FirstName")).contains("||") && strName.contains("||")) {
				sAltFirstName = (mTC_Test_Data.get(iTestDataRow).get("Name_Alt_FirstName").split("\\|\\|"))[i];
			}else{
				sAltFirstName = mTC_Test_Data.get(iTestDataRow).get("Name_Alt_FirstName");
			}

			if ((mTC_Test_Data.get(iTestDataRow).get("Name_Alt_LastName")).contains("||") && strName.contains("||")) {
				sAltLastName = (mTC_Test_Data.get(iTestDataRow).get("Name_Alt_LastName").split("\\|\\|"))[i];
			}else{
				sAltLastName = mTC_Test_Data.get(iTestDataRow).get("Name_Alt_LastName");
			}
			if ((mTC_Test_Data.get(iTestDataRow).get("Name_PhoneNumber")).contains("||") && strName.contains("||")) {
				sPhoneNumber = (mTC_Test_Data.get(iTestDataRow).get("Name_PhoneNumber").split("\\|\\|"))[i];
			}else{
				sPhoneNumber = mTC_Test_Data.get(iTestDataRow).get("Name_PhoneNumber");
			}
			if ((mTC_Test_Data.get(iTestDataRow).get("Name_Email")).contains("||") && strName.contains("||")) {
				sEmail = (mTC_Test_Data.get(iTestDataRow).get("Name_Email").split("\\|\\|"))[i];
			}else{
				sEmail = mTC_Test_Data.get(iTestDataRow).get("Name_Email");
			}
			if ((mTC_Test_Data.get(iTestDataRow).get("Name_Gender")).contains("||") && strName.contains("||")) {
				sGender = (mTC_Test_Data.get(iTestDataRow).get("Name_Gender").split("\\|\\|"))[i];
			}else{
				sGender = mTC_Test_Data.get(iTestDataRow).get("Name_Gender");
			}
			if ((mTC_Test_Data.get(iTestDataRow).get("Address_Address1")).contains("||") && strName.contains("||")) {
				sAddress1 = (mTC_Test_Data.get(iTestDataRow).get("Address_Address1").split("\\|\\|"))[i];
			}else{
				sAddress1 = mTC_Test_Data.get(iTestDataRow).get("Address_Address1");
			}
			if ((mTC_Test_Data.get(iTestDataRow).get("Address_Address2")).contains("||") && strName.contains("||")) {
				sAddress2 = (mTC_Test_Data.get(iTestDataRow).get("Address_Address2").split("\\|\\|"))[i];
			}else{
				sAddress2 = mTC_Test_Data.get(iTestDataRow).get("Address_Address2");
			}
			if ((mTC_Test_Data.get(iTestDataRow).get("Address_Zipcode")).contains("||") && strName.contains("||")) {
				sZipCode = (mTC_Test_Data.get(iTestDataRow).get("Address_Zipcode").split("\\|\\|"))[i];
			}else{
				sZipCode = mTC_Test_Data.get(iTestDataRow).get("Address_Zipcode");
			}
			
			if ((mTC_Test_Data.get(iTestDataRow).get("Name_NameFormatCode")).contains("||") && strName.contains("||")) {
				sName_NameFormatCode = (mTC_Test_Data.get(iTestDataRow).get("Name_NameFormatCode").split("\\|\\|"))[i];
			}else{
				sName_NameFormatCode = mTC_Test_Data.get(iTestDataRow).get("Name_NameFormatCode");
			}

			if ((mTC_Test_Data.get(iTestDataRow).get("Name_WithholdingCode")).contains("||") && strName.contains("||")) {
				sName_WithholdingCode = (mTC_Test_Data.get(iTestDataRow).get("Name_WithholdingCode").split("\\|\\|"))[i];
			}else{
				sName_WithholdingCode = mTC_Test_Data.get(iTestDataRow).get("Name_WithholdingCode");
			}

			if ((mTC_Test_Data.get(iTestDataRow).get("Name_Alt_NameFormatCode")).contains("||") && strName.contains("||")) {
				sName_Alt_NameFormatCode = (mTC_Test_Data.get(iTestDataRow).get("Name_Alt_NameFormatCode").split("\\|\\|"))[i];
			}else{
				sName_Alt_NameFormatCode = mTC_Test_Data.get(iTestDataRow).get("Name_Alt_NameFormatCode");
			}

			if ((mTC_Test_Data.get(iTestDataRow).get("Name_WebAddress")).contains("||") && strName.contains("||")) {
				sName_WebAddress = (mTC_Test_Data.get(iTestDataRow).get("Name_WebAddress").split("\\|\\|"))[i];
			}else{
				sName_WebAddress = mTC_Test_Data.get(iTestDataRow).get("Name_WebAddress");
			}

			if ((mTC_Test_Data.get(iTestDataRow).get("Name_RiskRanking")).contains("||") && strName.contains("||")) {
				sName_RiskRanking = (mTC_Test_Data.get(iTestDataRow).get("Name_RiskRanking").split("\\|\\|"))[i];
			}else{
				sName_RiskRanking = mTC_Test_Data.get(iTestDataRow).get("Name_RiskRanking");
			}


			if ((mTC_Test_Data.get(iTestDataRow).get("Name_CreditScore")).contains("||") && strName.contains("||")) {
				sName_CreditScore = (mTC_Test_Data.get(iTestDataRow).get("Name_CreditScore").split("\\|\\|"))[i];
			}else{
				sName_CreditScore = mTC_Test_Data.get(iTestDataRow).get("Name_CreditScore");
			}

			if ((mTC_Test_Data.get(iTestDataRow).get("Name_NAICSCodes_EconomicSector")).contains("||") && strName.contains("||")) {
				sName_NAICSCodes_EconomicSector = (mTC_Test_Data.get(iTestDataRow).get("Name_NAICSCodes_EconomicSector").split("\\|\\|"))[i];
			}else{
				sName_NAICSCodes_EconomicSector = mTC_Test_Data.get(iTestDataRow).get("Name_NAICSCodes_EconomicSector");
			}


			if ((mTC_Test_Data.get(iTestDataRow).get("Name_CustomerType")).contains("||") && strName.contains("||")) {
				sName_CustomerType = (mTC_Test_Data.get(iTestDataRow).get("Name_CustomerType").split("\\|\\|"))[i];
			}else{
				sName_CustomerType = mTC_Test_Data.get(iTestDataRow).get("Name_CustomerType");
			}


			if ((mTC_Test_Data.get(iTestDataRow).get("Name_BranchRegion")).contains("||") && strName.contains("||")) {
				sName_BranchRegion = (mTC_Test_Data.get(iTestDataRow).get("Name_BranchRegion").split("\\|\\|"))[i];
			}else{
				sName_BranchRegion = mTC_Test_Data.get(iTestDataRow).get("Name_BranchRegion");
			}


			if ((mTC_Test_Data.get(iTestDataRow).get("Name_BuildRelationship_SSN")).contains("||") && strName.contains("||")) {
				sName_BuildRelationship_SSN = (mTC_Test_Data.get(iTestDataRow).get("Name_BuildRelationship_SSN").split("\\|\\|"))[i];
			}else{
				sName_BuildRelationship_SSN = mTC_Test_Data.get(iTestDataRow).get("Name_BuildRelationship_SSN");
			}


			if ((mTC_Test_Data.get(iTestDataRow).get("Name_Build_Relationship")).contains("||") && strName.contains("||")) {
				sName_Build_Relationship = (mTC_Test_Data.get(iTestDataRow).get("Name_Build_Relationship").split("\\|\\|"))[i];
			}else{
				sName_Build_Relationship = mTC_Test_Data.get(iTestDataRow).get("Name_Build_Relationship");
			}


			if ((mTC_Test_Data.get(iTestDataRow).get("Name_BeneficialOwnerName")).contains("||") && strName.contains("||")) {
				sName_BeneficialOwnerName = (mTC_Test_Data.get(iTestDataRow).get("Name_BeneficialOwnerName").split("\\|\\|"))[i];
			}else{
				sName_BeneficialOwnerName = mTC_Test_Data.get(iTestDataRow).get("Name_BeneficialOwnerName");
			}


			if ((mTC_Test_Data.get(iTestDataRow).get("Name_Beneficial_Relationship")).contains("||") && strName.contains("||")) {
				sName_Beneficial_Relationship = (mTC_Test_Data.get(iTestDataRow).get("Name_Beneficial_Relationship").split("\\|\\|"))[i];
			}else{
				sName_Beneficial_Relationship = mTC_Test_Data.get(iTestDataRow).get("Name_Beneficial_Relationship");
			}

			if ((mTC_Test_Data.get(iTestDataRow).get("Name_Beneficial_Percent")).contains("||") && strName.contains("||")) {
				sName_Beneficial_Percent = (mTC_Test_Data.get(iTestDataRow).get("Name_Beneficial_Percent").split("\\|\\|"))[i];
			}else{
				sName_Beneficial_Percent = mTC_Test_Data.get(iTestDataRow).get("Name_Beneficial_Percent");
			}

			if ((mTC_Test_Data.get(iTestDataRow).get("Address_BuildRelationship")).contains("||") && strName.contains("||")) {
				sAddress_BuildRelationship = (mTC_Test_Data.get(iTestDataRow).get("Address_BuildRelationship").split("\\|\\|"))[i];
			}else{
				sAddress_BuildRelationship = mTC_Test_Data.get(iTestDataRow).get("Address_BuildRelationship");
			}
			
			if ((mTC_Test_Data.get(iTestDataRow).get("Name_AddPhoneType")).contains("||") && strName.contains("||")) {
				sName_AddPhoneType = (mTC_Test_Data.get(iTestDataRow).get("Name_AddPhoneType").split("\\|\\|"))[i];
			}else{
				sName_AddPhoneType = mTC_Test_Data.get(iTestDataRow).get("Name_AddPhoneType");
			}
			
			if ((mTC_Test_Data.get(iTestDataRow).get("Name_AddEmailType")).contains("||") && strName.contains("||")) {
				sName_AddEmailType = (mTC_Test_Data.get(iTestDataRow).get("Name_AddEmailType").split("\\|\\|"))[i];
			}else{
				sName_AddEmailType = mTC_Test_Data.get(iTestDataRow).get("Name_AddEmailType");
			}
			
			if (i==0)
				premierHomeMenuPage.goToNames();
			premierHomeMenuPage.goToNewName();
			
			premierCustomerNewName.enterCustomerName(sName, sFName, sLName, sName_NameFormatCode, sDOB, sTaxIDCode, sTaxIdentification, sName_WithholdingCode, sAltName, sAltFirstName, sAltLastName, sAlt_MiddleInitial, sName_Alt_NameFormatCode);
			premierCustomerNewName.enterDuplicate();
			premierCustomerNewName.enterContactMethod(sPhoneNumber, sEmail, sName_WebAddress,sName_AddPhoneType,sName_AddEmailType);
			premierCustomerNewName.enterCodeLable(sGender, sName_RiskRanking, sName_CreditScore, sName_NAICSCodes_EconomicSector, sName_CustomerType, sName_BranchRegion);
			//premierCustomerNewName.enterBuildRelationship(sName_BuildRelationship_SSN, sName_Build_Relationship, sName_BeneficialOwnerName, sName_Beneficial_Relationship, sName_Beneficial_Percent, "", "", "", "", "", "", "");
			premierCustomerNewName.buildRelationship(sName_BuildRelationship_SSN, sName_Build_Relationship);
			premierCustomerNewName.addDetailsOfBeneficiary(sName_BeneficialOwnerName, sName_Beneficial_Relationship, sName_Beneficial_Percent);
			premierCustomerNewName.finsihName();
			//premierHomeMenuPage.clickNewContact();
			if (i==0)
				premierHomeMenuPage.goToContact();
			premierHomeMenuPage.goTokNewContact();
			
			premierCustomerContact.createNewContact(sTaxIdentification);
			//premierHomeMenuPage.clickNewAddress();
			if (i==0)
				premierHomeMenuPage.goToAddress();
			premierHomeMenuPage.goToNewAddress();					
			/*premierCustomerAddress.createNewAddress(sAddress1, sAddress2, sZipCode, sTaxIdentification, mTC_Test_Data.get(iTestDataRow).get("Address_BuildRelationship"),mTC_Test_Data.get(iTestDataRow).get("Name_BranchRegion"));*/
			
			premierCustomerAddress.enterAddress(sAddress1, sAddress2, sZipCode, sName_BranchRegion);
			premierCustomerAddress.duplicateAddress();
			premierCustomerAddress.createBuildRelationship(sTaxIdentification, sAddress_BuildRelationship);
			if (sCustomerInquireFlag.equalsIgnoreCase("Y")){
				new PremierCommonNavigation().customerInquiry(sLName, sTaxIdentification, sName, "", "", sAddress1, sAddress2, sZipCode,sName_Build_Relationship,sName_BeneficialOwnerName);
			}	
		}

		
	}
	public void portfolioCreationAndInquire(List<Map<String, String>> tc_Test_Data,int iTDRow,String testdataFile_Path,String sTestCase,String sPortflioInquireFlag) throws Exception{
		premierHomeMenuPage.portfolioMenu();
		premierHomeMenuPage.portfolioNew();
		Thread.sleep(6000);
		String strPortfolioTaxNumber  = tc_Test_Data.get(iTDRow).get("Portfolio_TaxNumber1");
		String[] strPortfolioTaxNumber_Split = strPortfolioTaxNumber.split("\\|\\|"); 
		iPortfolioCustomerCount = strPortfolioTaxNumber_Split.length;
		for (int i = 0; i<iPortfolioCustomerCount;i++) {
			sTaxIdentification = (tc_Test_Data.get(iTDRow).get("Portfolio_TaxNumber1").split("\\|\\|"))[i];
			if (i>2) {
				premierPortfolioNew.clickAddNameLink();
			}
			premierPortfolioNew.portfolioSearchCustomer(sTaxIdentification,i+1);
		}
		if (!tc_Test_Data.get(iTDRow).get("Portfolio_Address1").equals("")) {
			premierPortfolioNew.portfolioSearchAddress(tc_Test_Data.get(iTDRow).get("Portfolio_Address1"));
		}
		premierPortfolioNew.portfolioCustomerDetails(tc_Test_Data.get(iTDRow).get("Portfolio_DeliveryPoint"),tc_Test_Data.get(iTDRow).get("Portfolio_BranchRegion"),tc_Test_Data.get(iTDRow).get("Portfolio_AccountingBranch"));
		//premierPortfolioNew.portfolioNew_PossibleDuplicate();
		for (int i = 0; i<iPortfolioCustomerCount;i++) {	
			if(tc_Test_Data.get(iTDRow).get("Portfolio_Relationship").contains("||")) {
				sPortfolioRelationship = (tc_Test_Data.get(iTDRow).get("Portfolio_Relationship").split("\\|\\|"))[i];
			}else {
				sPortfolioRelationship = tc_Test_Data.get(iTDRow).get("Portfolio_Relationship");
			}
			premierPortfolioNew.portfolioNew_NameScreen(sPortfolioRelationship,i+1);
		}
		premierPortfolioNew.clickOnNextButton();
		premierPortfolioNew.portfolioNew_CodesScreen(tc_Test_Data.get(iTDRow).get("Portfolio_PortfolioTypeCode"),tc_Test_Data.get(iTDRow).get("Portfolio_ResponsibilityCode"),tc_Test_Data.get(iTDRow).get("Portfolio_MiscellaneousCode"),testdataFile_Path, sTestCase, iTDRow+1);
		premierPortfolioNew.portfolioFinishButton();
		if (sPortflioInquireFlag.equalsIgnoreCase("Y")){
			//need to create 
			//new PremierCommonNavigation().portfolioInquiry(sLName, sTaxIdentification, sName, "", "", sAddress1, sAddress2, sZipCode);
		}
	}
	
	public void portfolioCreationWithCustomer(List<Map<String, String>> tc_Test_Data,int iTDRow,String testdataFile_Path,String sTestCase,String sPortflioInquireFlag) throws Exception{
		premierHomeMenuPage.portfolioMenu();
		premierHomeMenuPage.portfolioNew();
		Thread.sleep(6000);
		String strPortfolioCustName  = tc_Test_Data.get(iTDRow).get("Portfolio_Name1");
		String[] strPortfolioCustName_Split = strPortfolioCustName.split("\\|\\|"); 
		iPortfolioCustomerCount = strPortfolioCustName_Split.length;
		for (int i = 0; i<iPortfolioCustomerCount;i++) {
			sName = strPortfolioCustName_Split[i];
			sTaxIDCode = (tc_Test_Data.get(iTDRow).get("Portfolio_TaxCode1").split("\\|\\|"))[i];
			sTaxIdentification = (tc_Test_Data.get(iTDRow).get("Portfolio_TaxNumber1").split("\\|\\|"))[i];
			sDOB = (tc_Test_Data.get(iTDRow).get("Portfolio_DOB1").split("\\|\\|"))[i];
			if (i>2) {
				premierPortfolioNew.clickAddNameLink();
			}
			premierPortfolioNew.portfolioCustomerName(sName,sTaxIDCode,sTaxIdentification,sDOB,i+1);
		}
		premierPortfolioNew.portfolioCustomerAddress(tc_Test_Data.get(iTDRow).get("Portfolio_Address1"),tc_Test_Data.get(iTDRow).get("Portfolio_Address2"),tc_Test_Data.get(iTDRow).get("Portfolio_CityStateZip"));
		premierPortfolioNew.portfolioCustomerDetails(tc_Test_Data.get(iTDRow).get("Portfolio_DeliveryPoint"),tc_Test_Data.get(iTDRow).get("Portfolio_BranchRegion"),tc_Test_Data.get(iTDRow).get("Portfolio_AccountingBranch"));
		premierPortfolioNew.portfolioNew_PossibleDuplicate_NewCustomer();
		
		for (int i = 0; i<iPortfolioCustomerCount;i++) {
			if(tc_Test_Data.get(iTDRow).get("Portfolio_Relationship").contains("||")) {
				sPortfolioRelationship = (tc_Test_Data.get(iTDRow).get("Portfolio_Relationship").split("\\|\\|"))[i];
			}else {
				sPortfolioRelationship = tc_Test_Data.get(iTDRow).get("Portfolio_Relationship");
			}
			if(tc_Test_Data.get(iTDRow).get("Portfolio_NameFormatCode").contains("||")) {
				sPortfolioNameFormatCode = (tc_Test_Data.get(iTDRow).get("Portfolio_NameFormatCode").split("\\|\\|"))[i];
			}else {
				sPortfolioNameFormatCode = tc_Test_Data.get(iTDRow).get("Portfolio_NameFormatCode");
			}
			if(tc_Test_Data.get(iTDRow).get("Portfolio_PhoneNumber").contains("||")) {
				sPhoneNumber = (tc_Test_Data.get(iTDRow).get("Portfolio_PhoneNumber").split("\\|\\|"))[i];
			}else {
				sPhoneNumber = tc_Test_Data.get(iTDRow).get("Portfolio_PhoneNumber");
			}
			if(tc_Test_Data.get(iTDRow).get("Portfolio_Email").contains("||")) {
				sEmail = (tc_Test_Data.get(iTDRow).get("Portfolio_Email").split("\\|\\|"))[i];
			}else {
				sEmail = tc_Test_Data.get(iTDRow).get("Portfolio_Email");
			}
			premierPortfolioNew.portfolioNew_NameScreenMultipleCust(sPortfolioRelationship,sPortfolioNameFormatCode,sPhoneNumber,sEmail,i+1);
		}
		premierPortfolioNew.clickOnNextButton();
		premierPortfolioNew.portfolioNew_AddressScreen();
		premierPortfolioNew.portfolioNew_CodesScreen(tc_Test_Data.get(iTDRow).get("Portfolio_PortfolioTypeCode"),tc_Test_Data.get(iTDRow).get("Portfolio_ResponsibilityCode"),tc_Test_Data.get(iTDRow).get("Portfolio_MiscellaneousCode"),testdataFile_Path, sTestCase, iTDRow+1);
		premierPortfolioNew.portfolioFinishButton();
	}
	public void demandDepositAccountCreationAndInquire(List<Map<String, String>> tc_Test_Data,int iTDRow,String sTestCase,String sDepositInquireFlag) throws Exception{
		premierHomeMenuPage.depositsMenu();
		premierHomeMenuPage.demandDepositsSubMenu();
		premierHomeMenuPage.newDemandDeposits();
		premierPortfolioNew.searchPortfolio(tc_Test_Data.get(iTDRow).get("Portfolio_No"));								
		String strPortfolioCustName  = tc_Test_Data.get(iTDRow).get("Deposit_Name");
		String[] strPortfolioCustName_Split = strPortfolioCustName.split("\\|\\|"); 
		iPortfolioCustomerCount = strPortfolioCustName_Split.length;
		for (int i = 0; i<iPortfolioCustomerCount;i++) {
			sName = (tc_Test_Data.get(iTDRow).get("Deposit_Name").split("\\|\\|"))[i];
			sTaxIdentification = (tc_Test_Data.get(iTDRow).get("Deposit_SearchSSN").split("\\|\\|"))[i];
			sDepositRelationship = (tc_Test_Data.get(iTDRow).get("Deposit_Relationship").split("\\|\\|"))[i];
			sDepositStatement = (tc_Test_Data.get(iTDRow).get("Deposit_eStatement").split("\\|\\|"))[i];
			premierDepositAccounts.newDepositAccount_CustomerScreenSearch(sTaxIdentification,sName,sDepositRelationship,sDepositStatement,i+1);
		}
		premierDepositAccounts.newDepositAccount_CustomerScreenDetails(tc_Test_Data.get(iTDRow).get("Deposit_Product"));
		premierDepositAccounts.newDepositAccount_CodesScreen(tc_Test_Data.get(iTDRow).get("Deposit_AccountNumber"),tc_Test_Data.get(iTDRow).get("Deposit_InitialDeposit"),tc_Test_Data.get(iTDRow).get("Deposit_ResponsibilityCode"),tc_Test_Data.get(iTDRow).get("Deposit_AccountTitlePrintOption"),tc_Test_Data.get(iTDRow).get("Deposit_AccountTitle"),testdataFile_Path, sTestCase, iTDRow+1);
		premierDepositAccounts.depositFinishButton();//need to update
		
		if(sDepositInquireFlag.equalsIgnoreCase("Y")){
			premierHomeMenuPage.accountInquiryDemandDeposits();
			premierDepositAccounts.searchAccount(tc_Test_Data.get(iTDRow).get("Deposit_AccountNumber"));	
			
			strPortfolioCustName  = tc_Test_Data.get(iTDRow).get("Deposit_Name");
			strPortfolioCustName_Split = strPortfolioCustName.split("\\|\\|"); 
			iPortfolioCustomerCount = strPortfolioCustName_Split.length;
			for (int i = 0; i<iPortfolioCustomerCount;i++) {
				sName = (tc_Test_Data.get(iTDRow).get("Deposit_Name").split("\\|\\|"))[i];
				sDepositRelationship = (tc_Test_Data.get(iTDRow).get("Deposit_Relationship").split("\\|\\|"))[i];
				premierDepositAccounts.validateAccountDetails(tc_Test_Data.get(iTDRow).get("Deposit_AccountNumber"),sName,sDepositRelationship,tc_Test_Data.get(iTDRow).get("Deposit_Product"));
			}
			premierDepositAccounts.closeScreen_Image();
		}
	}
	public void savingAccountCreationAndInquire(List<Map<String, String>> tc_Test_Data,int iTDRow,String sTestCase,String sDepositInquireFlag) throws Exception{
		premierHomeMenuPage.depositsMenu();
		premierHomeMenuPage.savingsDepositsSubMenu();
		premierHomeMenuPage.newAccountSavings();
		premierPortfolioNew.searchPortfolio(tc_Test_Data.get(iTDRow).get("Portfolio_No"));								
		String strPortfolioCustName  = tc_Test_Data.get(iTDRow).get("Deposit_Name");
		String[] strPortfolioCustName_Split = strPortfolioCustName.split("\\|\\|"); 
		iPortfolioCustomerCount = strPortfolioCustName_Split.length;
		for (int i = 0; i<iPortfolioCustomerCount;i++) {
			sName = (tc_Test_Data.get(iTDRow).get("Deposit_Name").split("\\|\\|"))[i];
			sTaxIdentification = (tc_Test_Data.get(iTDRow).get("Deposit_SearchSSN").split("\\|\\|"))[i];
			sDepositRelationship = (tc_Test_Data.get(iTDRow).get("Deposit_Relationship").split("\\|\\|"))[i];
			sDepositStatement = (tc_Test_Data.get(iTDRow).get("Deposit_eStatement").split("\\|\\|"))[i];
			premierDepositAccounts.newDepositAccount_CustomerScreenSearch(sTaxIdentification,sName,sDepositRelationship,sDepositStatement,i+1);
		}
		premierDepositAccounts.newDepositAccount_CustomerScreenDetails(tc_Test_Data.get(iTDRow).get("Deposit_Product"));
		premierDepositAccounts.newDepositAccount_CodesScreen(tc_Test_Data.get(iTDRow).get("Deposit_AccountNumber"),tc_Test_Data.get(iTDRow).get("Deposit_InitialDeposit"),tc_Test_Data.get(iTDRow).get("Deposit_ResponsibilityCode"),tc_Test_Data.get(iTDRow).get("Deposit_AccountTitlePrintOption"),tc_Test_Data.get(iTDRow).get("Deposit_AccountTitle"),testdataFile_Path, sTestCase, iTDRow+1);
		premierDepositAccounts.depositFinishButton();//need to update
		
		if(sDepositInquireFlag.equalsIgnoreCase("Y")){
			premierHomeMenuPage.accountInquirySavings();
			premierDepositAccounts.searchAccount(tc_Test_Data.get(iTDRow).get("Deposit_AccountNumber"));	
			
			strPortfolioCustName  = tc_Test_Data.get(iTDRow).get("Deposit_Name");
			strPortfolioCustName_Split = strPortfolioCustName.split("\\|\\|"); 
			iPortfolioCustomerCount = strPortfolioCustName_Split.length;
			for (int i = 0; i<iPortfolioCustomerCount;i++) {
				sName = (tc_Test_Data.get(iTDRow).get("Deposit_Name").split("\\|\\|"))[i];
				sDepositRelationship = (tc_Test_Data.get(iTDRow).get("Deposit_Relationship").split("\\|\\|"))[i];
				premierDepositAccounts.validateAccountDetails(tc_Test_Data.get(iTDRow).get("Deposit_AccountNumber"),sName,sDepositRelationship,tc_Test_Data.get(iTDRow).get("Deposit_Product"));
			}
			premierDepositAccounts.closeScreen_Image();
		}	
		
	}
	public void certificateAccountCreationAndInquire(List<Map<String, String>> tc_Test_Data,int iTDRow,String sTestCase,String sDepositInquireFlag) throws Exception{
		premierHomeMenuPage.depositsMenu();
		premierHomeMenuPage.certificatesDepositsSubMenu();
		premierHomeMenuPage.newAccountCertificates();
		premierPortfolioNew.searchPortfolio(tc_Test_Data.get(iTDRow).get("Portfolio_No"));								
		String strPortfolioCustName  = tc_Test_Data.get(iTDRow).get("Deposit_Name");
		String[] strPortfolioCustName_Split = strPortfolioCustName.split("\\|\\|"); 
		iPortfolioCustomerCount = strPortfolioCustName_Split.length;
		for (int i = 0; i<iPortfolioCustomerCount;i++) {
			sName = (tc_Test_Data.get(iTDRow).get("Deposit_Name").split("\\|\\|"))[i];
			sTaxIdentification = (tc_Test_Data.get(iTDRow).get("Deposit_SearchSSN").split("\\|\\|"))[i];
			sDepositRelationship = (tc_Test_Data.get(iTDRow).get("Deposit_Relationship").split("\\|\\|"))[i];
			sDepositStatement = (tc_Test_Data.get(iTDRow).get("Deposit_eStatement").split("\\|\\|"))[i];
			premierDepositAccounts.newDepositAccount_CustomerScreenSearch(sTaxIdentification,sName,sDepositRelationship,sDepositStatement,i+1);
		}
		premierDepositAccounts.newDepositAccount_CustomerScreenDetails(tc_Test_Data.get(iTDRow).get("Deposit_Product"));
		premierDepositAccounts.newDepositAccount_CodesScreen(tc_Test_Data.get(iTDRow).get("Deposit_AccountNumber"),tc_Test_Data.get(iTDRow).get("Deposit_InitialDeposit"),tc_Test_Data.get(iTDRow).get("Deposit_ResponsibilityCode"),tc_Test_Data.get(iTDRow).get("Deposit_AccountTitlePrintOption"),tc_Test_Data.get(iTDRow).get("Deposit_AccountTitle"),testdataFile_Path, sTestCase, iTDRow+1);
		premierDepositAccounts.depositFinishButton();//need to update
		if(sDepositInquireFlag.equalsIgnoreCase("Y")){
			premierHomeMenuPage.accountInquiryCertificates();
			premierDepositAccounts.searchAccount(tc_Test_Data.get(iTDRow).get("Deposit_AccountNumber"));					
			strPortfolioCustName  = tc_Test_Data.get(iTDRow).get("Deposit_Name");
			strPortfolioCustName_Split = strPortfolioCustName.split("\\|\\|"); 
			iPortfolioCustomerCount = strPortfolioCustName_Split.length;
			for (int i = 0; i<iPortfolioCustomerCount;i++) {
				sName = (tc_Test_Data.get(iTDRow).get("Deposit_Name").split("\\|\\|"))[i];
				sDepositRelationship = (tc_Test_Data.get(iTDRow).get("Deposit_Relationship").split("\\|\\|"))[i];
				premierDepositAccounts.validateAccountDetails(tc_Test_Data.get(iTDRow).get("Deposit_AccountNumber"),sName,sDepositRelationship,tc_Test_Data.get(iTDRow).get("Deposit_Product"));
			}
			premierDepositAccounts.closeScreen_Image();
		}	
		
	}
	
	public void loanCreationAndInquire(List<Map<String, String>> tc_Test_Data,int iTDRow,String sTestCase,String sLoanInquireFlag) throws Exception{
		premierHomeMenuPage.selectLinesMenu();
		premierHomeMenuPage.selectNewLine();
		premierPortfolioNew.searchPortfolio(tc_Test_Data.get(iTDRow).get("Portfolio_No"));
		 String strPortfolioCustName  = tc_Test_Data.get(iTDRow).get("Line_Name");
         String[] strPortfolioCustName_Split = strPortfolioCustName.split("\\|\\|");
         iPortfolioCustomerCount = strPortfolioCustName_Split.length;
         for (int i = 0; i<iPortfolioCustomerCount;i++) {
        	 sLineName = (tc_Test_Data.get(iTDRow).get("Line_Name").split("\\|\\|"))[i];
        	 sTaxIdentification = (tc_Test_Data.get(iTDRow).get("Line_SearchSSN").split("\\|\\|"))[i];
             String sLineRelationship = (tc_Test_Data.get(iTDRow).get("Line_Relationship").split("\\|\\|"))[i];
             String sLineStatement = (tc_Test_Data.get(iTDRow).get("Line_eStatement").split("\\|\\|"))[i];
             premierLinesNewLine.newLine_CustomerScreen_Search(sTaxIdentification,sLineName,sLineRelationship,sLineStatement,i+1);
         }
         premierPortfolioNew.clickOnNextButton();
         premierLinesNewLine.newLineAccount_CodesScreen(tc_Test_Data.get(iTDRow).get("Line_FinancialStatementNotify"),
        		 tc_Test_Data.get(iTDRow).get("Line_NextFinDate"),tc_Test_Data.get(iTDRow).get("Line_NextReviewDate"),
        		 tc_Test_Data.get(iTDRow).get("Line_MaximumCredit"),tc_Test_Data.get(iTDRow).get("Line_MaximumCreditCode"),
        		 tc_Test_Data.get(iTDRow).get("Line_ResponsibiliytCode"));
         premierLinesNewLine.newLinesFinishButton();
         premierHomeMenuPage.selectLineInquiry();
         premierLinesNewLine.searchLineNumber(tc_Test_Data.get(iTDRow).get("Portfolio_No"));
         //strPortfolioCustName  = tc_Test_Data.get(iTDRow).get("Line_Name");
         //strPortfolioCustName_Split = strPortfolioCustName.split("\\|\\|"); 
        // iPortfolioCustomerCount = strPortfolioCustName_Split.length;
         for (int i = 0; i<iPortfolioCustomerCount;i++) {
        	 sLineName = (tc_Test_Data.get(iTDRow).get("Line_Name").split("\\|\\|"))[i];
        	 premierLinesNewLine.validateDetailsInLineInquiry(tc_Test_Data.get(iTDRow).get("Portfolio_No"), sLineName);
         }
         premierLinesNewLine.closeScreen_Image();
         
         premierHomeMenuPage.selectLoansMenu();
         premierHomeMenuPage.selectNewNote();
         premierLinesNewLine.searchLineNumber(tc_Test_Data.get(iTDRow).get("Portfolio_No"));
         //strPortfolioCustName  = tc_Test_Data.get(iTDRow).get("Line_Name");
         //strPortfolioCustName_Split = strPortfolioCustName.split("\\|\\|"); 
         //iPortfolioCustomerCount = strPortfolioCustName_Split.length;
         for (int i = 0; i<iPortfolioCustomerCount;i++) {
        	 sLineName = (tc_Test_Data.get(iTDRow).get("Line_Name").split("\\|\\|"))[i];
        	 sTaxIdentification = (tc_Test_Data.get(iTDRow).get("Line_SearchSSN").split("\\|\\|"))[i];
             String sLineRelationship = (tc_Test_Data.get(iTDRow).get("Line_Relationship").split("\\|\\|"))[i];
             String sLineStatement = (tc_Test_Data.get(iTDRow).get("Line_eStatement").split("\\|\\|"))[i];
             premierLinesNewLine.newLine_CustomerScreen_Search(sTaxIdentification,sLineName,sLineRelationship,sLineStatement,i+1);
         }
         premierLinesNewLine.newLine_CustomerProductDetails(tc_Test_Data.get(iTDRow).get("Loan_Product"));
         premierLoansNewNote.newNoteLoanAcc_CodesScreen(tc_Test_Data.get(iTDRow).get("Loan_NoteNumber"), tc_Test_Data.get(iTDRow).get("Loan_CashProceeds"), tc_Test_Data.get(iTDRow).get("Loan_MaximumCredit"),tc_Test_Data.get(iTDRow).get("Loan_MaximumCreditCode"), tc_Test_Data.get(iTDRow).get("Loan_NoteDate"), tc_Test_Data.get(iTDRow).get("Loan_ContractDate"), tc_Test_Data.get(iTDRow).get("Loan_AccountOpenedMethod"), tc_Test_Data.get(iTDRow).get("Loan_OriginalCreditScore"),tc_Test_Data.get(iTDRow).get("Loan_PaymentReserveOption"), tc_Test_Data.get(iTDRow).get("Loan_OriginalPaymentReserve"), tc_Test_Data.get(iTDRow).get("Loan_InternalPaymentOption"),tc_Test_Data.get(iTDRow).get("Loan_ResponsibilityCode"));
         premierLoansNewNote.newNoteLoan_PaymentScreen(tc_Test_Data.get(iTDRow).get("Loans_InterestMethod"), tc_Test_Data.get(iTDRow).get("Loans_FirstPaymentDate"), tc_Test_Data.get(iTDRow).get("Loans_PaymentFrequency"),tc_Test_Data.get(iTDRow).get("Loans_FirstInterestPaymentDate"), tc_Test_Data.get(iTDRow).get("Loans_InterestPaymentFrequency"), tc_Test_Data.get(iTDRow).get("Loans_PurposeCode"), tc_Test_Data.get(iTDRow).get("Loans_PaymentCode"), tc_Test_Data.get(iTDRow).get("Loans_ChargeAccount"),tc_Test_Data.get(iTDRow).get("Loans_Rate"), tc_Test_Data.get(iTDRow).get("Loans_RateAdjuster1"), tc_Test_Data.get(iTDRow).get("Loans_RateAdjuster2"),tc_Test_Data.get(iTDRow).get("Loans_PercentofPrimeCode"), tc_Test_Data.get(iTDRow).get("Loans_TotalInterest"));
         premierLoansNewNote.newNoteLoan_InsuranceScreen(tc_Test_Data.get(iTDRow).get("Loans_Insurance_Plan"), tc_Test_Data.get(iTDRow).get("Loans_Insurance_Premium"), tc_Test_Data.get(iTDRow).get("Loans_Insurance_LineLifeInsuranceOption"),tc_Test_Data.get(iTDRow).get("Loans_Insurance_SimpleInsuranceBillingDay"));
         premierLoansNewNote.newNoteLoan_ScheduleScreen(tc_Test_Data.get(iTDRow).get("Loan_Schedule_StartDate"), tc_Test_Data.get(iTDRow).get("Loan_Schedule_Frequency"), tc_Test_Data.get(iTDRow).get("Loan_Schedule_Number"),tc_Test_Data.get(iTDRow).get("Loan_Schedule_PIAmount"), tc_Test_Data.get(iTDRow).get("Loan_Schedule_Escrow"), tc_Test_Data.get(iTDRow).get("Loan_Schedule_Rate"), tc_Test_Data.get(iTDRow).get("Loan_Schedule_SuppressPaymentChangeNotice"), tc_Test_Data.get(iTDRow).get("Loan_Schedule_OtherEscrow"));
         premierLoansNewNote.loanFinishButton();
         if(sLoanInquireFlag.equalsIgnoreCase("Y")){
	         premierHomeMenuPage.loanAccountInquiry();
	         premierDepositAccounts.searchAccount(tc_Test_Data.get(iTDRow).get("Loan_NoteNumber"));
	         for (int i = 0; i<iPortfolioCustomerCount;i++) {
	        	 sLineName = (tc_Test_Data.get(iTDRow).get("Line_Name").split("\\|\\|"))[i];
	        	 premierLoansNewNote.validateDetailsInLoansInquiry(tc_Test_Data.get(iTDRow).get("Loan_NoteNumber"), sLineName);
	         }
	         premierLinesNewLine.closeScreen_Image();
         }
	}
	
	
	public void safeDepositBoxCreationAndInquire(List<Map<String, String>> tc_Test_Data,int iTDRow,String sTestCase,String sSDBInquireFlag) throws Exception{
		premierHomeMenuPage.goToSafeDepositBox();
		premierHomeMenuPage.goToNewAccountSafeDepositBox();
		
		premierPortfolioNew.searchPortfolio(tc_Test_Data.get(iTDRow).get("Portfolio_No"));								
		
		String PortfolioCustName  = tc_Test_Data.get(iTDRow).get("SDB_Name");
		String[] PortfolioCustName_Split = PortfolioCustName.split("\\|\\|"); 
		iPortfolioCustomerCount = PortfolioCustName_Split.length;
		for (int i = 0; i<iPortfolioCustomerCount;i++) {
			sName = (tc_Test_Data.get(iTDRow).get("SDB_Name").split("\\|\\|"))[i];
			sSDBRelationship = (tc_Test_Data.get(iTDRow).get("SDB_Relationship").split("\\|\\|"))[i];
			sTaxIdentification = (tc_Test_Data.get(iTDRow).get("SDB_SearchSSN").split("\\|\\|"))[i];
			premierSafeDepositBox.newSDBAccount_CustomerScreenSearch(sTaxIdentification,sName,sSDBRelationship,i+1);
		}
		premierSafeDepositBox.newSDB_CustomerProductDetails(tc_Test_Data.get(iTDRow).get("SDB_Product"));
		//premierSafeDepositBox.clickOnNext();
		premierSafeDepositBox.newSDBAccount_CodesScreen(tc_Test_Data.get(iTDRow).get("SDB_AccountNumber"),
				tc_Test_Data.get(iTDRow).get("SDB_RentCode"),testdataFile_Path, sTestCase, iTDRow+1);
		premierSafeDepositBox.newSDBAccount_PaymentScreen(tc_Test_Data.get(iTDRow).get("SDB_BillingMethod"),
				tc_Test_Data.get(iTDRow).get("SDB_ChargeAccount"),tc_Test_Data.get(iTDRow).get("SDB_BillingFrequency"),
				tc_Test_Data.get(iTDRow).get("SDB_LastBillingDate"),testdataFile_Path, sTestCase, iTDRow+1);
		premierSafeDepositBox.sdbFinishButton();
		if(sSDBInquireFlag.equalsIgnoreCase("Y")){ 
			premierHomeMenuPage.accountInquirySDB();
			premierSafeDepositBox.searchAccount(tc_Test_Data.get(iTDRow).get("SDB_AccountNumber"));	
			for (int i = 0; i<iPortfolioCustomerCount;i++) {
				sName = (tc_Test_Data.get(iTDRow).get("SDB_Name").split("\\|\\|"))[i];
				sSDBRelationship = (tc_Test_Data.get(iTDRow).get("SDB_Relationship").split("\\|\\|"))[i];
				//new DateTimeHelper().getDateTime(tc_Test_Data.get(iTDRow).get("SDB_LastBillingDate"),"MM/dd/yyyy","MMM dd, yyyy");
				premierSafeDepositBox.validateAccountDetails(tc_Test_Data.get(iTDRow).get("SDB_AccountNumber"),sName,
						sSDBRelationship,new DateTimeHelper().getDateTime(tc_Test_Data.get(iTDRow).get("SDB_LastBillingDate"),"MM/dd/yyyy","MMM dd, yyyy"),
						tc_Test_Data.get(iTDRow).get("SDB_BillingFrequency"),tc_Test_Data.get(iTDRow).get("SDB_BillingMethod"));
			}
			premierSafeDepositBox.closeScreen_Image();
		}

	}
	
}

