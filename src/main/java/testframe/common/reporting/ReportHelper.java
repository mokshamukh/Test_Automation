package testframe.common.reporting;


import java.io.IOException;



import testframe.application.common.ApplicationBase;

public class ReportHelper extends ApplicationBase {
	
	String sFromPath,sToPath,sSummaryReportToPath,sTCid_Iteration,sTCid_Application,sToApplicationFolder;
	String[] sTCid_Application_split,sTCid_Iteration_split;
	String sTestcaseID,sIteration;
	static String sSummaryReportPath,sApplication;
	static int iSummary_testDetailsRowNum,iSummary_VerificationRowNum;
	
	public void writeToSummaryReport(String sCreateFlag) throws IOException{
		
		sTCid_Iteration = System.getProperty("testcaseid.iteration");
		sTCid_Application = System.getProperty("testcaseid.app.module.submod.testdesc");
		
		sTCid_Iteration_split = sTCid_Iteration.split("\\|\\|");
		//String sTestcaseId=sTCid_Iteration_split[0];
		sIteration=sTCid_Iteration_split[1];

		if (sIteration.equals("0"))
			sIteration="1";
		else
			sIteration = Integer.toString(Integer.parseInt(sIteration) +1);

		sTCid_Application_split= sTCid_Application.split("\\|\\|");
		sTestcaseID = sTCid_Application_split[0];
		sApplication = sTCid_Application_split[1];

		
		
		if(sCreateFlag.equalsIgnoreCase("Y")){
			createSummaryReport(sApplication);
		}
		else
		{
			updateSummaryReport();
		}
	}
	
	public void setSummaryReportPath(String sSummaryReportPath){
		this.sSummaryReportPath = sSummaryReportPath;
	}
	
	public void createSummaryReport(String strApplication) throws IOException{
		sFromPath = pr.pathToSummaryReportTemplateFromFrameworkPropFile();
		sToPath = pr.pathToAppReportFolderFromFrameworkPropFile();
		
				
		sToApplicationFolder = sToPath+"/"+strApplication;
		fi.checkAndCreateFolder(sToApplicationFolder);
		
		sSummaryReportToPath = sToApplicationFolder+"/" +  System.getProperty("current.date.time");
		fi.checkAndCreateFolder(sSummaryReportToPath);
		
		er.copyExcelFile(sFromPath, sSummaryReportToPath);
		setSummaryReportPath(sSummaryReportToPath);
		iSummary_testDetailsRowNum = 1;
		iSummary_VerificationRowNum = 1;
	}
	
	public void updateSummaryReport(){
		
	}
	
	public void writeToSummaryReportVerificationTab(){
		
	}
	
	public void writeToSummaryReportTestDetailsTab(){
		
	}
	
	
	
}
