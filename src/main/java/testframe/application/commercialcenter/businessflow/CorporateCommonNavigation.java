package testframe.application.commercialcenter.businessflow;

import java.util.List;
import java.util.Map;



public class CorporateCommonNavigation extends CorporateTest {
	
	
	public void batchTemplateCreationandSearch(List<Map<String, String>> tc_Test_Data,int iTDRow,String sSearchTemplateFlag) throws Exception {
		
		corporateACHBatchTemplate.createBatchTemplate(tc_Test_Data.get(iTDRow).get("ACHCompany"),tc_Test_Data.get(iTDRow).get("DebitORCredit"),tc_Test_Data.get(iTDRow).get("BatchType"));
		corporateACHBatchTemplate.enterACHBatchDetails(tc_Test_Data.get(iTDRow).get("TemplateName"),tc_Test_Data.get(iTDRow).get("CompanyDiscretionaryData"),
				tc_Test_Data.get(iTDRow).get("CompanyEntryDescription"),tc_Test_Data.get(iTDRow).get("OffsetAccount"),tc_Test_Data.get(iTDRow).get("Confidential"));
		//corporateACHBatchTemplate.searchPayee(tc_Test_Data.get(iTDRow).get("SearchPayeeName"),tc_Test_Data.get(iTDRow).get("Amount"));
		String[] multiPayee;
		if (!tc_Test_Data.get(iTDRow).get("SearchPayeeName").equals("")){
			 multiPayee = tc_Test_Data.get(iTDRow).get("SearchPayeeName").split("\\|\\|");
			for(int i=0;i<=multiPayee.length-1;i++){
					corporateACHBatchTemplate.searchPayee(multiPayee[i],tc_Test_Data.get(iTDRow).get("Amount").split("\\|\\|")[i]);
			}
		}else {
			 multiPayee = tc_Test_Data.get(iTDRow).get("CreatePayeeName").split("\\|\\|");
			for(int i=0;i<=multiPayee.length-1;i++){
			corporateACHBatchTemplate.createNewPayee(tc_Test_Data.get(iTDRow).get("CreatePayeeName").split("\\|\\|")[i], tc_Test_Data.get(iTDRow).get("CreatePayeeID").split("\\|\\|")[i],
					tc_Test_Data.get(iTDRow).get("CreateAccountNumber").split("\\|\\|")[i],tc_Test_Data.get(iTDRow).get("CreateBankID").split("\\|\\|")[i],
					tc_Test_Data.get(iTDRow).get("CreateBankName").split("\\|\\|")[i],tc_Test_Data.get(iTDRow).get("CreateDebitAuthType").split("\\|\\|")[i],
					tc_Test_Data.get(iTDRow).get("Amount").split("\\|\\|")[i],tc_Test_Data.get(iTDRow).get("CreateMixedDebitOrCredit").split("\\|\\|")[i],
					tc_Test_Data.get(iTDRow).get("Addenda").split("\\|\\|")[i],tc_Test_Data.get(iTDRow).get("SendRemittanceToPayee").split("\\|\\|")[i]);
		}
	}
		
		corporateACHBatchTemplate.saveBatchTemplate();
		if(sSearchTemplateFlag.equalsIgnoreCase("Y")) {
		corporateACHBatchTemplate.searchTemplate(tc_Test_Data.get(iTDRow).get("TemplateName"),tc_Test_Data.get(iTDRow).get("BatchType"));
	}
	
}
	
	public void multipleTemplateForFreeForm(List<Map<String, String>> tc_Test_Data,int iTDRow) throws Exception {

		String[] multiPayee;
		multiPayee = tc_Test_Data.get(iTDRow).get("Template1").split("\\|\\|");
		for(int i=0;i<=multiPayee.length-1;i++){
			corporateNewWireTransfer.createNewWireTransferUsingMultipleTemplates(tc_Test_Data.get(iTDRow).get("Template1").split("\\|\\|")[i],
					tc_Test_Data.get(iTDRow).get("Template2").split("\\|\\|")[i],tc_Test_Data.get(iTDRow).get("Template3").split("\\|\\|")[i],
					tc_Test_Data.get(iTDRow).get("Template4").split("\\|\\|")[i],tc_Test_Data.get(iTDRow).get("Template5").split("\\|\\|")[i],
					tc_Test_Data.get(iTDRow).get("PaymentDate").split("\\|\\|")[i]);
			corporateNewWireTransfer.reviewMultipleWireTransferDetails(tc_Test_Data.get(iTDRow).get("Template1").split("\\|\\|")[i],
					tc_Test_Data.get(iTDRow).get("DebitAccount1Review").split("\\|\\|")[i],tc_Test_Data.get(iTDRow).get("Amount1Review").split("\\|\\|")[i],
					tc_Test_Data.get(iTDRow).get("Template2").split("\\|\\|")[i],tc_Test_Data.get(iTDRow).get("DebitAccount2Review").split("\\|\\|")[i],
					tc_Test_Data.get(iTDRow).get("Amount2Review").split("\\|\\|")[i],tc_Test_Data.get(iTDRow).get("Template3").split("\\|\\|")[i],
					tc_Test_Data.get(iTDRow).get("DebitAccount3Review").split("\\|\\|")[i],tc_Test_Data.get(iTDRow).get("Amount3Review").split("\\|\\|")[i],
					tc_Test_Data.get(iTDRow).get("TotalAmount").split("\\|\\|")[i]);
		}
	}

	
	public void newAchPaymentWithTemplate(List<Map<String, String>> tc_Test_Data,int iTDRow) {
		try {
			corporateNewACHBatchTemplate.startAchPaymentWithTemplate(tc_Test_Data.get(iTDRow).get("ExistPaymentTemplate"));
			corporateNewACHBatchTemplate.enterACHPaymentDetails(tc_Test_Data.get(iTDRow).get("PaymentDate"),
					tc_Test_Data.get(iTDRow).get("CompanyDiscretionaryData"),tc_Test_Data.get(iTDRow).get("CompanyEntryDescription"),
					tc_Test_Data.get(iTDRow).get("OffsetAccount"),tc_Test_Data.get(iTDRow).get("PaymentAmount"),
					tc_Test_Data.get(iTDRow).get("CreateNewPayeeName"),tc_Test_Data.get(iTDRow).get("CreatePayeeID"),
					tc_Test_Data.get(iTDRow).get("CreateAccountNumber"),tc_Test_Data.get(iTDRow).get("CreateBankID"),
					tc_Test_Data.get(iTDRow).get("CreateBankName"),tc_Test_Data.get(iTDRow).get("CreateDebitAuthType"),
					tc_Test_Data.get(iTDRow).get("Amount"),tc_Test_Data.get(iTDRow).get("CreateMixedDebitOrCredit"),
					tc_Test_Data.get(iTDRow).get("Addenda"),
					tc_Test_Data.get(iTDRow).get("sendRemittanceToPayee"));
			corporateNewACHBatchTemplate.clickOnRequestBatchButton();
			corporateNewACHBatchTemplate.reviewAchBatchDetails(tc_Test_Data.get(iTDRow).get("CreatePayeeName"),
					tc_Test_Data.get(iTDRow).get("AmountReview"),tc_Test_Data.get(iTDRow).get("BatchType"));
			//corporateNewACHBatchTemplate.verifyPassword(cPassword);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public void editNewAchPaymentWithTemplate(List<Map<String, String>> tc_Test_Data,int iTDRow) {
       try {
    	   corporateNewACHBatchTemplate.editBatchTemplate(tc_Test_Data.get(iTDRow).get("PaymentDate"),tc_Test_Data.get(iTDRow).get("CompanyDiscretionaryData"),
					tc_Test_Data.get(iTDRow).get("CompanyEntryDescription"),tc_Test_Data.get(iTDRow).get("OffsetAccount"),
					tc_Test_Data.get(iTDRow).get("Amount"),tc_Test_Data.get(iTDRow).get("SearchPayeeName"),
					tc_Test_Data.get(iTDRow).get("Update_CreatePayeeName"),tc_Test_Data.get(iTDRow).get("Update_CreatePayeeID"),
					tc_Test_Data.get(iTDRow).get("Update_CreateAccountNumber"),tc_Test_Data.get(iTDRow).get("Update_CreateBankID"),
					tc_Test_Data.get(iTDRow).get("Update_CreateBankName"),tc_Test_Data.get(iTDRow).get("Update_CreateDebitAuthType"),
					tc_Test_Data.get(iTDRow).get("Update_CreateMixedDebitOrCredit"),tc_Test_Data.get(iTDRow).get("Update_Addenda"),
					tc_Test_Data.get(iTDRow).get("Update_SendRemittanceToPayee"));
			corporateNewACHBatchTemplate.clickOnRequestBatchButton();
			corporateNewACHBatchTemplate.reviewAchBatchDetails(tc_Test_Data.get(iTDRow).get("CreatePayeeName"),
					tc_Test_Data.get(iTDRow).get("AmountReview"),tc_Test_Data.get(iTDRow).get("BatchType"));
	} catch (Exception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	
	}
	
	public void createNewPayeeAndSearch(List<Map<String, String>> tc_Test_Data,int iTDRow) {
	       try {
	    	   corporateNewPayee.createNewPayeeAndSearch(tc_Test_Data.get(iTDRow).get("PayeeName"),tc_Test_Data.get(iTDRow).get("PayeeID"),
						tc_Test_Data.get(iTDRow).get("PayeeType"),tc_Test_Data.get(iTDRow).get("Address1"),
						tc_Test_Data.get(iTDRow).get("Address2"),tc_Test_Data.get(iTDRow).get("AccountNumber"),
						tc_Test_Data.get(iTDRow).get("TemplateInfo"),tc_Test_Data.get(iTDRow).get("BankId"),
						tc_Test_Data.get(iTDRow).get("BankName"),tc_Test_Data.get(iTDRow).get("DebitType"),
						tc_Test_Data.get(iTDRow).get("BeneBankIDType"),tc_Test_Data.get(iTDRow).get("BeneBankCountry"),
						tc_Test_Data.get(iTDRow).get("BeneBankID"),tc_Test_Data.get(iTDRow).get("BeneBankName"), 
						tc_Test_Data.get(iTDRow).get("BeneCountry"));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		}
	


}
