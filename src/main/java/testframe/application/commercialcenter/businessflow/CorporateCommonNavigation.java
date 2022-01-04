package testframe.application.commercialcenter.businessflow;

import java.util.List;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import testframe.application.common.CommonLibrary;



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
					tc_Test_Data.get(iTDRow).get("Amount").split("\\|\\|")[i],tc_Test_Data.get(iTDRow).get("Addenda").split("\\|\\|")[i],
					tc_Test_Data.get(iTDRow).get("sendRemittanceToPayee").split("\\|\\|")[i]);
		}
	}
		
		corporateACHBatchTemplate.saveBatchTemplate();
		if(sSearchTemplateFlag.equalsIgnoreCase("Y")) {
		corporateACHBatchTemplate.searchTemplate(tc_Test_Data.get(iTDRow).get("TemplateName"),tc_Test_Data.get(iTDRow).get("BatchType"));
	}
	
}
	
	
	public void newAchPaymentWithTemplate(List<Map<String, String>> tc_Test_Data,int iTDRow) {
		try {
			corporateNewACHBatchTemplate.startAchPaymentWithTemplate(tc_Test_Data.get(iTDRow).get("ExistPaymentTemplate"));
			corporateNewACHBatchTemplate.enterACHPaymentDetails(tc_Test_Data.get(iTDRow).get("PaymentDate"),tc_Test_Data.get(iTDRow).get("CompanyDiscretionaryData"),
					tc_Test_Data.get(iTDRow).get("CompanyEntryDescription"),tc_Test_Data.get(iTDRow).get("OffsetAccount"),
					tc_Test_Data.get(iTDRow).get("CreateNewPayeeName"),tc_Test_Data.get(iTDRow).get("CreatePayeeID"),
					tc_Test_Data.get(iTDRow).get("CreateAccountNumber"),tc_Test_Data.get(iTDRow).get("CreateBankID"),
					tc_Test_Data.get(iTDRow).get("CreateBankName"),tc_Test_Data.get(iTDRow).get("CreateDebitAuthType"),
					tc_Test_Data.get(iTDRow).get("Amount"),tc_Test_Data.get(iTDRow).get("Addenda"),
					tc_Test_Data.get(iTDRow).get("sendRemittanceToPayee"));
			corporateNewACHBatchTemplate.reviewAchBatchDetails(tc_Test_Data.get(iTDRow).get("PayeeName"), tc_Test_Data.get(iTDRow).get("Amount"));
			corporateNewACHBatchTemplate.verifyPassword(cPassword);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
	
	
}
