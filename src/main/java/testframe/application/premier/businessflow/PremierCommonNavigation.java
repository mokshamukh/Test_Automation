package testframe.application.premier.businessflow;

import java.util.List;
import java.util.Map;

public class PremierCommonNavigation extends PremierTest{

	
	 
	public void customerInquiry(String strLastName, String TaxID,String strName, String strPhoneNum, String strEmail, 
			String strAddress1,String strAddress2,String strZipCode) throws Exception{
		premierHomeMenuPage.customerInquiry();
		premierCustomerInquiryPage.searchCustomer(strLastName, TaxID);
		premierCustomerInquiryPage.seeAdditionalAddresses();
		premierCustomerInquiryPage.customerExpand();
		premierCustomerInquiryPage.validateCustomerDetails(strName,TaxID,strPhoneNum,strEmail,strAddress1,strAddress2,strZipCode);
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

			if ((mTC_Test_Data.get(iTestDataRow).get("Name_Alt_Name")).contains("||")) {
				sAltName = (mTC_Test_Data.get(iTestDataRow).get("Name_Alt_Name").split("\\|\\|"))[i];
			}else{
				sAltName = mTC_Test_Data.get(iTestDataRow).get("Name_Alt_Name");
			}

			if ((mTC_Test_Data.get(iTestDataRow).get("Name_Alt_FirstName")).contains("||")) {
				sAltFirstName = (mTC_Test_Data.get(iTestDataRow).get("Name_Alt_FirstName").split("\\|\\|"))[i];
			}else{
				sAltFirstName = mTC_Test_Data.get(iTestDataRow).get("Name_Alt_FirstName");
			}

			if ((mTC_Test_Data.get(iTestDataRow).get("Name_Alt_LastName")).contains("||")) {
				sAltLastName = (mTC_Test_Data.get(iTestDataRow).get("Name_Alt_LastName").split("\\|\\|"))[i];
			}else{
				sAltLastName = mTC_Test_Data.get(iTestDataRow).get("Name_Alt_LastName");
			}
			if ((mTC_Test_Data.get(iTestDataRow).get("Name_PhoneNumber")).contains("||")) {
				sPhoneNumber = (mTC_Test_Data.get(iTestDataRow).get("Name_PhoneNumber").split("\\|\\|"))[i];
			}else{
				sPhoneNumber = mTC_Test_Data.get(iTestDataRow).get("Name_PhoneNumber");
			}
			if ((mTC_Test_Data.get(iTestDataRow).get("Name_Email")).contains("||")) {
				sEmail = (mTC_Test_Data.get(iTestDataRow).get("Name_Email").split("\\|\\|"))[i];
			}else{
				sEmail = mTC_Test_Data.get(iTestDataRow).get("Name_Email");
			}
			if ((mTC_Test_Data.get(iTestDataRow).get("Name_Gender")).contains("||")) {
				sGender = (mTC_Test_Data.get(iTestDataRow).get("Name_Gender").split("\\|\\|"))[i];
			}else{
				sGender = mTC_Test_Data.get(iTestDataRow).get("Name_Gender");
			}
			if ((mTC_Test_Data.get(iTestDataRow).get("Address_Address1")).contains("||")) {
				sAddress1 = (mTC_Test_Data.get(iTestDataRow).get("Address_Address1").split("\\|\\|"))[i];
			}else{
				sAddress1 = mTC_Test_Data.get(iTestDataRow).get("Address_Address1");
			}
			if ((mTC_Test_Data.get(iTestDataRow).get("Address_Address2")).contains("||")) {
				sAddress2 = (mTC_Test_Data.get(iTestDataRow).get("Address_Address2").split("\\|\\|"))[i];
			}else{
				sAddress2 = mTC_Test_Data.get(iTestDataRow).get("Address_Address2");
			}
			if ((mTC_Test_Data.get(iTestDataRow).get("Address_Zipcode")).contains("||")) {
				sZipCode = (mTC_Test_Data.get(iTestDataRow).get("Address_Zipcode").split("\\|\\|"))[i];
			}else{
				sZipCode = mTC_Test_Data.get(iTestDataRow).get("Address_Zipcode");
			}
			
			if ((mTC_Test_Data.get(iTestDataRow).get("Name_NameFormatCode")).contains("||")) {
				sName_NameFormatCode = (mTC_Test_Data.get(iTestDataRow).get("Name_NameFormatCode").split("\\|\\|"))[i];
			}else{
				sName_NameFormatCode = mTC_Test_Data.get(iTestDataRow).get("Name_NameFormatCode");
			}

			if ((mTC_Test_Data.get(iTestDataRow).get("Name_WithholdingCode")).contains("||")) {
				sName_WithholdingCode = (mTC_Test_Data.get(iTestDataRow).get("Name_WithholdingCode").split("\\|\\|"))[i];
			}else{
				sName_WithholdingCode = mTC_Test_Data.get(iTestDataRow).get("Name_WithholdingCode");
			}

			if ((mTC_Test_Data.get(iTestDataRow).get("Name_Alt_NameFormatCode")).contains("||")) {
				sName_Alt_NameFormatCode = (mTC_Test_Data.get(iTestDataRow).get("Name_Alt_NameFormatCode").split("\\|\\|"))[i];
			}else{
				sName_Alt_NameFormatCode = mTC_Test_Data.get(iTestDataRow).get("Name_Alt_NameFormatCode");
			}

			if ((mTC_Test_Data.get(iTestDataRow).get("Name_WebAddress")).contains("||")) {
				sName_WebAddress = (mTC_Test_Data.get(iTestDataRow).get("Name_WebAddress").split("\\|\\|"))[i];
			}else{
				sName_WebAddress = mTC_Test_Data.get(iTestDataRow).get("Name_WebAddress");
			}

			if ((mTC_Test_Data.get(iTestDataRow).get("Name_RiskRanking")).contains("||")) {
				sName_RiskRanking = (mTC_Test_Data.get(iTestDataRow).get("Name_RiskRanking").split("\\|\\|"))[i];
			}else{
				sName_RiskRanking = mTC_Test_Data.get(iTestDataRow).get("Name_RiskRanking");
			}


			if ((mTC_Test_Data.get(iTestDataRow).get("Name_CreditScore")).contains("||")) {
				sName_CreditScore = (mTC_Test_Data.get(iTestDataRow).get("Name_CreditScore").split("\\|\\|"))[i];
			}else{
				sName_CreditScore = mTC_Test_Data.get(iTestDataRow).get("Name_CreditScore");
			}

			if ((mTC_Test_Data.get(iTestDataRow).get("Name_NAICSCodes_EconomicSector")).contains("||")) {
				sName_NAICSCodes_EconomicSector = (mTC_Test_Data.get(iTestDataRow).get("Name_NAICSCodes_EconomicSector").split("\\|\\|"))[i];
			}else{
				sName_NAICSCodes_EconomicSector = mTC_Test_Data.get(iTestDataRow).get("Name_NAICSCodes_EconomicSector");
			}


			if ((mTC_Test_Data.get(iTestDataRow).get("Name_CustomerType")).contains("||")) {
				sName_CustomerType = (mTC_Test_Data.get(iTestDataRow).get("Name_CustomerType").split("\\|\\|"))[i];
			}else{
				sName_CustomerType = mTC_Test_Data.get(iTestDataRow).get("Name_CustomerType");
			}


			if ((mTC_Test_Data.get(iTestDataRow).get("Name_BranchRegion")).contains("||")) {
				sName_BranchRegion = (mTC_Test_Data.get(iTestDataRow).get("Name_BranchRegion").split("\\|\\|"))[i];
			}else{
				sName_BranchRegion = mTC_Test_Data.get(iTestDataRow).get("Name_BranchRegion");
			}


			if ((mTC_Test_Data.get(iTestDataRow).get("Name_BuildRelationship_SSN")).contains("||")) {
				sName_BuildRelationship_SSN = (mTC_Test_Data.get(iTestDataRow).get("Name_BuildRelationship_SSN").split("\\|\\|"))[i];
			}else{
				sName_BuildRelationship_SSN = mTC_Test_Data.get(iTestDataRow).get("Name_BuildRelationship_SSN");
			}


			if ((mTC_Test_Data.get(iTestDataRow).get("Name_Build_Relationship")).contains("||")) {
				sName_Build_Relationship = (mTC_Test_Data.get(iTestDataRow).get("Name_Build_Relationship").split("\\|\\|"))[i];
			}else{
				sName_Build_Relationship = mTC_Test_Data.get(iTestDataRow).get("Name_Build_Relationship");
			}


			if ((mTC_Test_Data.get(iTestDataRow).get("Name_BeneficialOwnerName")).contains("||")) {
				sName_BeneficialOwnerName = (mTC_Test_Data.get(iTestDataRow).get("Name_BeneficialOwnerName").split("\\|\\|"))[i];
			}else{
				sName_BeneficialOwnerName = mTC_Test_Data.get(iTestDataRow).get("Name_BeneficialOwnerName");
			}


			if ((mTC_Test_Data.get(iTestDataRow).get("Name_Beneficial_Relationship")).contains("||")) {
				sName_Beneficial_Relationship = (mTC_Test_Data.get(iTestDataRow).get("Name_Beneficial_Relationship").split("\\|\\|"))[i];
			}else{
				sName_Beneficial_Relationship = mTC_Test_Data.get(iTestDataRow).get("Name_Beneficial_Relationship");
			}

			if ((mTC_Test_Data.get(iTestDataRow).get("Name_Beneficial_Percent")).contains("||")) {
				sName_Beneficial_Percent = (mTC_Test_Data.get(iTestDataRow).get("Name_Beneficial_Percent").split("\\|\\|"))[i];
			}else{
				sName_Beneficial_Percent = mTC_Test_Data.get(iTestDataRow).get("Name_Beneficial_Percent");
			}

			if ((mTC_Test_Data.get(iTestDataRow).get("Address_BuildRelationship")).contains("||")) {
				sAddress_BuildRelationship = (mTC_Test_Data.get(iTestDataRow).get("Address_BuildRelationship").split("\\|\\|"))[i];
			}else{
				sAddress_BuildRelationship = mTC_Test_Data.get(iTestDataRow).get("Address_BuildRelationship");
			}
			
			if ((mTC_Test_Data.get(iTestDataRow).get("Name_AddPhoneType")).contains("||")) {
				sName_AddPhoneType = (mTC_Test_Data.get(iTestDataRow).get("Name_AddPhoneType").split("\\|\\|"))[i];
			}else{
				sName_AddPhoneType = mTC_Test_Data.get(iTestDataRow).get("Name_AddPhoneType");
			}
			
			if ((mTC_Test_Data.get(iTestDataRow).get("Name_AddEmailType")).contains("||")) {
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
				new PremierCommonNavigation().customerInquiry(sLName, sTaxIdentification, sName, "", "", sAddress1, sAddress2, sZipCode);
			}	
		}

		
	}
}

