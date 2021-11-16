package testframe.common.reporting;


import java.io.IOException;

import org.openqa.selenium.WebDriver;

import testframe.application.common.ApplicationBase;

public class ReportHelper extends ApplicationBase {
	
	String sFromPath,sToPath,sSummaryReportToPath,sTCid_Iteration,sTCid_Application,sToApplicationFolder,strApplication,strModule
		,strSummaryReportName;
	String[] sTCid_Application_split,sTCid_Iteration_split,sFromPath_split;
	static String sTestcaseID,sIteration,sModule;
	static String sSummaryReportPath,sApplication="";
	static int iSummary_testDetailsRowNum,iSummary_VerificationRowNum;
	
	public void createUpdateSummaryReport() throws IOException{
		
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
		strApplication = sTCid_Application_split[1];
		strModule = sTCid_Application_split[2];

		if(!strApplication.equals(sApplication)){
			copySummaryToTestReports(strApplication);
			sApplication=strApplication;
			sModule=strModule;
			er.setValueInSpecificColumnRow(sSummaryReportPath, "Summary", 1, 10, strApplication);
			er.setValueInSpecificColumnRow(sSummaryReportPath, "Summary", 2, 10, strModule);
		}
	}
	
	public void setSummaryReportPath(String sSummaryReportPath){
		this.sSummaryReportPath = sSummaryReportPath;
	}
	
	public void copySummaryToTestReports(String strApplication) throws IOException{
		sFromPath = pr.pathToSummaryReportTemplateFromFrameworkPropFile();
		sFromPath_split = sFromPath.split("\\|\\|");
		strSummaryReportName = sFromPath_split[sFromPath_split.length-1];
		
		sToPath = pr.pathToAppReportFolderFromFrameworkPropFile();
		
		sToApplicationFolder = sToPath+"/"+strApplication;
		fi.checkAndCreateFolder(sToApplicationFolder);
		
		sSummaryReportToPath = sToApplicationFolder+"/" +  System.getProperty("current.date.time");
		fi.checkAndCreateFolder(sSummaryReportToPath);
		
		er.copyFileToFolder(sFromPath, sSummaryReportToPath);
		setSummaryReportPath(sSummaryReportToPath+"/" + strSummaryReportName);
		iSummary_testDetailsRowNum = 1;
		iSummary_VerificationRowNum = 1;
	}
	
	public void writeToSummaryReportVerificationTab(String sStepDescription,String sActualResultDescription,String result,String sScreeshotPath ) throws IOException, Exception{
		er.setValueInColumnforRow(sSummaryReportPath, "VerificationDetail", "TestScriptName", iSummary_VerificationRowNum, sTestcaseID+" Iteration - "+sIteration);
		er.setValueInColumnforRow(sSummaryReportPath, "VerificationDetail", "StepName", iSummary_VerificationRowNum, sStepDescription);
		er.setValueInColumnforRow(sSummaryReportPath, "VerificationDetail", "Result", iSummary_VerificationRowNum, result);
		er.setValueInColumnforRow(sSummaryReportPath, "VerificationDetail", "StepDescription", iSummary_VerificationRowNum, sActualResultDescription);
		er.setValueInColumnforRow(sSummaryReportPath, "VerificationDetail", "ScreenShotLink", iSummary_VerificationRowNum, sScreeshotPath);
		iSummary_VerificationRowNum= iSummary_VerificationRowNum+1;
	}
	
	public void writeToSummaryReportTestDetailsTab(String result,String sStart,String sEnd,String sTotalTime,String sTotalPassed,String sTotalFailed, String sTotalPassFail,String sPDFFilePath) throws IOException, Exception{
		er.setValueInColumnforRow(sSummaryReportPath, "TestsDetail", "TestExecuted", iSummary_testDetailsRowNum, sTestcaseID+" Iteration - "+sIteration);
		er.setValueInColumnforRow(sSummaryReportPath, "TestsDetail", "ExecutionResult", iSummary_testDetailsRowNum,result);
		er.setValueInColumnforRow(sSummaryReportPath, "TestsDetail", "StartTime", iSummary_testDetailsRowNum,sStart);
		er.setValueInColumnforRow(sSummaryReportPath, "TestsDetail", "EndTime", iSummary_testDetailsRowNum,sEnd);
		er.setValueInColumnforRow(sSummaryReportPath, "TestsDetail", "ExecutionTime", iSummary_testDetailsRowNum,sTotalTime);
		er.setValueInColumnforRow(sSummaryReportPath, "TestsDetail", "Passed", iSummary_testDetailsRowNum,sTotalPassed);
		er.setValueInColumnforRow(sSummaryReportPath, "TestsDetail", "Failed", iSummary_testDetailsRowNum,sTotalFailed);
		er.setValueInColumnforRow(sSummaryReportPath, "TestsDetail", "BaselineChecks", iSummary_testDetailsRowNum,sTotalPassFail);
		er.setValueInColumnforRow(sSummaryReportPath, "TestsDetail", "Module", iSummary_testDetailsRowNum,sModule);
		er.setValueInColumnforRow(sSummaryReportPath, "TestsDetail", "ReportLink", iSummary_testDetailsRowNum,sPDFFilePath);
		iSummary_testDetailsRowNum =iSummary_testDetailsRowNum+1;
		
		er.setValueInSpecificColumnRow(sSummaryReportPath, "Summary", 2, 4, sStart);
		er.setValueInSpecificColumnRow(sSummaryReportPath, "Summary", 4, 4, sEnd);
		er.setValueInSpecificColumnRow(sSummaryReportPath, "Summary", 6, 4, sTotalTime);
	}
	
}
