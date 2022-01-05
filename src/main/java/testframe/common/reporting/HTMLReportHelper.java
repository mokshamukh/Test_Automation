package testframe.common.reporting;

import java.awt.image.BufferedImage;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.text.ParseException;
import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.imageio.ImageIO;

import org.apache.commons.codec.binary.Base64;
import org.apache.commons.io.FileUtils;
import org.apache.commons.io.output.ByteArrayOutputStream;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import com.itextpdf.html2pdf.ConverterProperties;
import com.itextpdf.html2pdf.HtmlConverter;

import ru.yandex.qatools.ashot.AShot;
import ru.yandex.qatools.ashot.Screenshot;
import ru.yandex.qatools.ashot.shooting.ShootingStrategies;
import testframe.common.utilities.DateTimeHelper;
import testframe.common.utilities.ExcelReader;

public class HTMLReportHelper {	
	static int VPNbr;
	static String  strHTMLFileData,shtmlfilePath,spdffilePath, sScreenShotFolderpath
	,sMasterFilePath,sSummaryReportPath,sExecutionStart;
	String Base64StringofScreenshot,sBase64StringScreenshot,color,strScreenShotFilePath,strScreenshot;
	String sScreenShotPath;
	Date d1 = null;
	Date d2 = null;
	static Date sTime,eTime;
	String tTimeTaken,strStartTime,strEndTime;
	String strScreenshot_split[],sScreenshot_Path="";

	ExcelReader er = new ExcelReader();
	
	@Test
	public void covertHTMLToPDF() throws FileNotFoundException, IOException{
		ConverterProperties converterProperties = new ConverterProperties();
		HtmlConverter.convertToPdf(new FileInputStream("C:\\Users\\F9Z2G8A\\OneDrive - Fiserv Corp\\Desktop\\Republic UAT\\TestAutomation\\git\\workspace\\Test_Automation\\testreport\\application\\CommercialCenter\\01-04-2022-09-56-09\\CC_ADMIN_TC005_CommercialCenter_Admin_01042022-220846.html"), 
				new FileOutputStream("C:\\Users\\F9Z2G8A\\OneDrive - Fiserv Corp\\Desktop\\Republic UAT\\TestAutomation\\git\\workspace\\Test_Automation\\testreport\\application\\CommercialCenter\\01-04-2022-09-56-09\\CC_ADMIN_TC005_CommercialCenter_Admin_01042022-220846_Passed.pdf"), converterProperties);
		System.out.println( "PDF Created!" );
	}

	public void setHTMLReportFilePath(String sfilePath){
		shtmlfilePath = sfilePath;
		spdffilePath =shtmlfilePath.replace(".html", ".pdf");
	}

	public void setScreenShotFolder(String sScreenShotFolderpath){
		this.sScreenShotFolderpath = sScreenShotFolderpath;
	}

	public void setMasterFilePath(String sMasterFilePath){
		this.sMasterFilePath = sMasterFilePath;
	}



	public void setExecutionStart(String sExecutionStart){
		this.sExecutionStart = sExecutionStart;
	}

	public void HTMLReportHeader(String Module, String TestCaseID, String TestDescription) throws Exception{
		
		VPNbr =1;
		strHTMLFileData="";
		sTime= new DateTimeHelper().Now("yyyy/MM/dd HH:mm:ss");
		
		new ReportHelper().createUpdateSummaryReport(sTime);
		
		strHTMLFileData = strHTMLFileData + "<html>" + "\r\n"+ "\t";
		strHTMLFileData = strHTMLFileData +  "\t" + "<head><title>Automation Test Report</title>" + "\r\n";//</head>" + "\r\n";
		//strHTMLFileData = strHTMLFileData +"<style>" + "\r\n" + "@media print" +  "\r\n" + "{ tr.page-break  { display: block; page-break-before: always; } "
		strHTMLFileData = strHTMLFileData +"<style>" +  "\r\n" +  " .pagebreak { page-break-after: always; }"
				//+"\r\n" + "table { page-break-inside:auto }"
				//+ "\r\n" +  "tr    { page-break-inside:avoid; page-break-after:auto }"
				//+ "\r\n" +  "td    { page-break-inside:avoid; page-break-after:auto }"
				//+ "\r\n" +  "thead { display:table-header-group }"
				//+ "\r\n" +  " tfoot { display:table-footer-group }"
				//+ "\r\n" + "}" 
				+ "\r\n" +  ".zoomA {"
				+ "\r\n" +  "	  width: 600px;"
				+ "\r\n" +  "	  height: auto;"
				/* ease | ease-in | ease-out | linear */
				+ "\r\n" +  "	  transition: transform ease-in-out 0.3s;"
				+ "\r\n" +  "	}"
				+ "\r\n" +  "	.zoomA:hover {"
				+ "\r\n" +  "	  transform: scale(1.8);"
				+ "\r\n" +  "	}"
				+ "\r\n" + "</style>"
				+ "\r\n" + "</head>" + "\r\n";
		strHTMLFileData = strHTMLFileData + "\t" +"<body width=1100px heigth=768px bgcolor=#E6E6FA>" + "\r\n"+ "\t";			  
		//Start of first table
		strHTMLFileData = strHTMLFileData +  "\t" + "<table align=center width=700px heigth=400px cellspacing=1 cellpading=2 Border=1 bordercolor=#000000>"+ "\r\n"+ "\t";
		strHTMLFileData = strHTMLFileData + "<tr bgcolor=#FF8C00 height=30px>" + "\r\n";
		strHTMLFileData = strHTMLFileData + "\t"+ "\t" +"<td colspan=5 align=center><font face=Arial size=3><b>" + "Execution Summary" + "</b></font></td>" + "\r\n"+ "\t" + "</tr>" + "\r\n"+ "\t";  
		strHTMLFileData = strHTMLFileData + "<tr bgcolor=#FFFFFF height=20px>" + "\r\n";
		strHTMLFileData = strHTMLFileData + "\t"+ "\t" +"<td align=left width=180px><font face=Arial size=2><b> " + "Script ID: </b>" + TestCaseID  +"</font></td>" + "\r\n"; 
		strHTMLFileData = strHTMLFileData + "\t"+ "\t" +"<td align=left width=180px><font face=Arial size=2><b> " + "Script Description:</b> " + TestDescription + "</font></td>" + "\r\n"; 
		strHTMLFileData = strHTMLFileData + "\t"+ "\t" +"<td align=left width=163px><font face=Arial size=2><b> " + "Start Time:</b> STIME </font></td>" + "\r\n" ;
		strHTMLFileData = strHTMLFileData + "\t"+ "\t" +"<td align=left width=162px><font face=Arial size=2><b>" + "End Time:</b> ETIME </font></td>" + "\r\n" ;
		strHTMLFileData = strHTMLFileData + "\t"+ "\t" +"<td align=left width=162px><font face=Arial size=2><b>" + "Total Execution Time:</b> TTIME " + " Seconds"  +" </font></td>" + "\r\n"+ "\t" + "</tr>" + "\r\n"+ "\t"; 		  				
		strHTMLFileData = strHTMLFileData + "<tr bgcolor=#FFFFFF height=20px>" + "\r\n";
		strHTMLFileData = strHTMLFileData + "\t"+ "\t" +"<td bgcolor=#FFFFFF align=Left width=180px><font face=Arial size=2><b> " + "Execution Result:</b> RVTEQ</font></td>" + "\r\n";
		strHTMLFileData = strHTMLFileData + "\t"+ "\t" +"<td align=left width=163px><font face=Arial size=2><b> " + "Module: </b>"+Module +"</font></td>" + "\r\n";
		strHTMLFileData = strHTMLFileData + "\t"+ "\t" +"<td align=Left width=162px><font face=Arial size=2><b>" + "Passed Checkpoints:</b> PVPPVP1" + "</font></td>" + "\r\n";
		strHTMLFileData = strHTMLFileData + "\t"+ "\t" +"<td align=Left width=162px><font face=Arial size=2><b>" + "Failed Checkpoints:</b> FVPFVP1" + "</font></td>" + "\r\n" + "\t" + "</tr>" + "\r\n"+ "\t";
		strHTMLFileData = strHTMLFileData + "</table>" + "\r\n"+ "<br><br>" + "\r\n";
		strHTMLFileData = strHTMLFileData +  "\t" + "<table align=center width=650px heigth=400px cellspacing=2 cellpading=2 Border=0 bordercolor=#000000>"+ "\r\n"+ "\t";
		strHTMLFileData = strHTMLFileData + "<tr bgcolor=#808080 height=30px>" + "\r\n";
		strHTMLFileData = strHTMLFileData + "\t"+ "\t" +"<td align=left width=80px><font face=Arial size=2 color=white><b> " + "S.No." +"</b></font></td>" + "\r\n";
		strHTMLFileData = strHTMLFileData + "\t"+ "\t" +"<td align=left width=235px><font face=Arial size=2 color=white><b> " + "Step Description" +"</b></font></td>" + "\r\n";
		strHTMLFileData = strHTMLFileData + "\t"+ "\t" +"<td align=left width=235px><font face=Arial size=2 color=white><b>" + "Actual Result" + "</b></font></td>" + "\r\n" ;
		strHTMLFileData = strHTMLFileData + "\t"+ "\t" +"<td align=left width=100px><font face=Arial size=2 color=white><b>" + "Status" + "</b></font></td>" + "\r\n"+ "\t" + "</tr>"  + "\r\n"+ "\t" ;
	}

	//public void HtmlReportBody(String pstrStep,String pstrDetails,String result,WebDriver driver,String ScreenshotPath ){
	public void HtmlReportBody(String sStepDescription,String sActualResultDescription,String result,WebDriver driver,String sTakeScreenshot ) throws Exception{

		strScreenShotFilePath = sScreenShotFolderpath;
		if (result.equalsIgnoreCase("passed")){
			color = "#228B22";
		}
		else{
			color ="#FF0000";
		}
		if (sTakeScreenshot.equalsIgnoreCase("Y") || sTakeScreenshot.equalsIgnoreCase("YES")){
			//sBase64StringScreenshot = getScreenshot(driver);
			strScreenshot = getCompleteScreenShot(driver);
			strScreenshot_split = strScreenshot.split("\\|\\|");
			sBase64StringScreenshot = strScreenshot_split[0];
			sScreenshot_Path = strScreenshot_split[1];
		}
		if (VPNbr >1){
			strHTMLFileData = strHTMLFileData + "\r\n"+"<table align=center width=650px heigth=400px cellspacing=2 cellpading=2 Border=0 bordercolor=#000000>"+ "\r\n" +"\t" ;
		}

		strHTMLFileData = strHTMLFileData + "<tr bgcolor=" + color + " height=30px>" + "\r\n";  
		strHTMLFileData = strHTMLFileData + "\t"+ "\t" +"<td align=Left width=80px><font face=Arial size=2 color=white>" +"Check" + VPNbr +"</font></td>" +"\r\n" ; 
		strHTMLFileData = strHTMLFileData + "\t"+ "\t" +"<td align=left width=235px><font face=Arial size=2 color=white>" + sStepDescription +"</font></td>" + "\r\n" ; 
		strHTMLFileData = strHTMLFileData + "\t"+ "\t" +"<td align=left width=235px><font face=Arial size=2 color=white>" + sActualResultDescription + "</font></td>" + "\r\n";  
		strHTMLFileData = strHTMLFileData + "\t"+ "\t" +"<td align=Left width=100px><font face=Arial size=2 color=white>" + result.toUpperCase() + "</font></td>" + "\r\n" + "\t" + "</tr>" + "\r\n" + "\t"; 
		//strHTMLFileData = strHTMLFileData + "<tr><td colspan=4 align=center><br></td></tr>" + "\r\n" + "\t"; 
		if (sTakeScreenshot.equalsIgnoreCase("Y") || sTakeScreenshot.equalsIgnoreCase("YES"))
			strHTMLFileData = strHTMLFileData + "<tr>" + "\r\n" + "\t"+ "\t" +"<td colspan=4 align=center><img width=600px heigth=600px src ='"+ sBase64StringScreenshot + "'"+" class='zoomA'/></td>" + "\r\n" + "\t" + "</tr>" + "\r\n" + "\t"; 
		
		strHTMLFileData = strHTMLFileData + "<tr><td colspan=4 align=center><br><br></td></tr>" + "\r\n" + "\t" ;
		if (VPNbr >1){
			strHTMLFileData = strHTMLFileData + "\t"+"<div class='pagebreak'> </div>"+ "\r\n" +"\t" ;
		}
		strHTMLFileData = strHTMLFileData + "\r\n"+"</table>"+ "\r\n" +"\t" ;
		VPNbr = VPNbr+1;

		new ReportHelper().writeToSummaryReportVerificationTab(sStepDescription, sActualResultDescription, result.toUpperCase(), sScreenshot_Path);
	}

	public void HtmlReportFooter() throws Exception{
		//strHTMLFileData = strHTMLFileData + "\r\n" + "\t" + "</table>" + "\r\n" + "<center><p><font face=Arial size=1>CONFIDENTIAL - LIMITED: Distribution restricted to clients of Fiserv Products.</font></p></center>" + "\r\n"+"'";
		strHTMLFileData = strHTMLFileData + "\r\n" + "\t" +  "\r\n" + "<center><p><font face=Arial size=1>CONFIDENTIAL - LIMITED: Distribution restricted to clients of Fiserv Products.</font></p></center>" + "\r\n"+"'";
		strHTMLFileData = strHTMLFileData + "</body>" + "\r\n";
		strHTMLFileData = strHTMLFileData + "</html>" + "\r\n"; 
		eTime= new DateTimeHelper().Now("yyyy/MM/dd HH:mm:ss");
		new ReportHelper().setExecutionEndtDateTime(eTime);
		d1 = sTime;
		d2 = eTime;
		long diff = d2.getTime() - d1.getTime();
		long diffSeconds = diff / 1000 % 60;
		long diffMinutes = diff / (60 * 1000) % 60;
		long diffHours = diff / (60 * 60 * 1000) % 24;
		long diffDays = diff / (24 * 60 * 60 * 1000);


		/*seconddiff= datediff("s",sTime,eTime)
				daydiff=int(seconddiff / (24*60*60))
				seconddiff=seconddiff-(daydiff*24*60*60)
				hourdiff=int(seconddiff/(60*60))
				seconddiff=seconddiff-(hourdiff*60*60)
				mindiff=int(seconddiff/(60))
				seconddiff=seconddiff-(mindiff*60)*/
		tTimeTaken = diffDays + ":"+diffHours+":"+diffMinutes+":"+diffSeconds ;
		strStartTime= new DateTimeHelper().getDateTime(sTime,"yyyy/MM/dd HH:mm:ss");
		strEndTime= new DateTimeHelper().getDateTime(eTime,"yyyy/MM/dd HH:mm:ss");
		int totalPassed = getCount(strHTMLFileData,"<font face=Arial size=2 color=white>PASSED");
		int totalFailed = getCount(strHTMLFileData,"<font face=Arial size=2 color=white>FAILED");
		strHTMLFileData = strHTMLFileData.replace("STIME",strStartTime);
		strHTMLFileData = strHTMLFileData.replace("ETIME",strEndTime);
		strHTMLFileData = strHTMLFileData.replace("TTIME",tTimeTaken);
		strHTMLFileData = strHTMLFileData.replace("PVPPVP1",Integer.toString(totalPassed));
		strHTMLFileData = strHTMLFileData.replace("FVPFVP1",Integer.toString(totalFailed));
		String appendValue="";
		if (totalFailed>0){
			strHTMLFileData = strHTMLFileData.replace("RVTEQ","<b style='color:#FB584B'>Failed</b>");	
			appendValue ="Failed";
			spdffilePath = spdffilePath.replace(".pdf", "_Failed.pdf");
		}
		else if (totalPassed>0){
			strHTMLFileData = strHTMLFileData.replace("RVTEQ","<b style='color:#28CC6A'>Passed</b>");		
			appendValue = "Passed";
			spdffilePath = spdffilePath.replace(".pdf", "_Passed.pdf");
		}else{
			strHTMLFileData = strHTMLFileData.replace("RVTEQ","<b style='color:#696A69'>No Execution</p>");		
			appendValue = "' _Done";
		}
		BufferedWriter bw = new BufferedWriter(new FileWriter(shtmlfilePath));
		bw.write(strHTMLFileData);
		bw.close();
		ConverterProperties converterProperties = new ConverterProperties();
		HtmlConverter.convertToPdf(new FileInputStream(shtmlfilePath), 
				new FileOutputStream(spdffilePath), converterProperties);
		System.out.println( "PDF Created!" );
		storeResultToMasterFile(appendValue,sExecutionStart,strEndTime);
		
		new ReportHelper().writeToSummaryReportTestDetailsTab(appendValue, strStartTime, strEndTime, tTimeTaken.toString(), Integer.toString(totalPassed), Integer.toString(totalFailed), Integer.toString(totalPassed+totalFailed), spdffilePath);

	}

	public String getScreenshot(WebDriver driver){


		try {

			sScreenShotPath = sScreenShotFolderpath +"/"+ new DateTimeHelper().CurrentDateTime("yyyyMMddHHmmss")+".png";
			File src = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
			FileUtils.copyFile(src, new	File(sScreenShotPath));
			byte[] fileContent = FileUtils.readFileToByteArray(src);
			Base64StringofScreenshot = "data:image/png;base64,"+Base64.encodeBase64String(fileContent);



		} catch(Exception e){
			System.out.println("Capture failed :" +e.getMessage());
		}
		return Base64StringofScreenshot+"||"+ sScreenShotPath;
	}

	public String getCompleteScreenShot(WebDriver driver){
		ByteArrayOutputStream baos = new ByteArrayOutputStream();
		try {
			sScreenShotPath = sScreenShotFolderpath +"/"+ new DateTimeHelper().CurrentDateTime("yyyyMMddHHmmss")+".png";
			Screenshot s=new AShot().shootingStrategy(ShootingStrategies.viewportPasting(1000)).takeScreenshot(driver);
			//byte[] fileContent = FileUtils.readFileToByteArray(s);
			BufferedImage originalImage = s.getImage();
			ImageIO.write(originalImage, "png", baos);
			baos.flush();
			ImageIO.write(s.getImage(),"PNG",new File(sScreenShotPath));
			Base64StringofScreenshot = "data:image/png;base64,"+Base64.encodeBase64String(baos.toByteArray());
		}catch(Exception e){
			System.out.println("Capture failed :" +e.getMessage());
		}
		return Base64StringofScreenshot +"||"+ sScreenShotPath;

		//ImageIO.write(s.getImage(),"PNG",new File("C:\\projectScreenshots\\fullPageScreenshot.png"));

	}

	public int getCount(String str, String find){
		String[] str_arr = null;
		int count=0;
		try{ 
			if (str.contains(find)){ 
				str_arr=str.split(find);
				count= str_arr.length-1;
			}
		}	
		catch(Exception e){
			System.out.println("Unable to get count :" +e.getMessage());
		}
		return count;

	}

	public void storeResultToTestSummary(String sStatus){

	}

	public void storeResultToMasterFile(String sStatus,String sStartTime,String sEndTime) throws Exception{

		//String columnHeaderName, sFoundCol ="N";
		String sTCid_Iteration = System.getProperty("testcaseid.iteration");
		String sTCid_Application = System.getProperty("testcaseid.app.module.submod.testdesc");

		String[] sTCid_Iteration_split = sTCid_Iteration.split("\\|\\|");
		String sTestcaseId=sTCid_Iteration_split[0];
		String sIteration=sTCid_Iteration_split[1];

		if (sIteration.equals("0"))
			sIteration="1";
		else
			sIteration = Integer.toString(Integer.parseInt(sIteration) +1);

		String[] sTCid_Application_split = sTCid_Application.split("\\|\\|");
		String sTestcaseID=sTCid_Application_split[0];
		String sApplication=sTCid_Application_split[1];
		int rowNo;

		if (sTestcaseId.equals(sTestcaseID)){
			er.checkAndCreateHeaderColumn(sMasterFilePath, sApplication, "ExecutionStatus_"+sIteration);
			List<Map<String, String>> tc_App_Data = er.getData(sMasterFilePath,sApplication);
			for(int iTCAppRow =0; iTCAppRow<=tc_App_Data.size()-1;iTCAppRow++){
				if((tc_App_Data.get(iTCAppRow).get("TC#")).equalsIgnoreCase(sTestcaseID)){
					rowNo = iTCAppRow+1;
					er.setValueInColumnforRow(sMasterFilePath, sApplication, "ExecutionStatus_"+sIteration, rowNo, sStatus);
					er.setValueInColumnforRow(sMasterFilePath, sApplication, "ExecutedBy", rowNo, System.getProperty("user.name"));
					er.setValueInColumnforRow(sMasterFilePath, sApplication, "ExecutionStart", rowNo, "'"+sStartTime);
					er.setValueInColumnforRow(sMasterFilePath, sApplication, "ExecutionEnd", rowNo, "'"+sEndTime);
					break;
				}
			}
		}
		/*Sheet sheet = er.getSheetByName(sMasterFilePath, sApplication);
		int totalColumn = sheet.getRow(sheet.getFirstRowNum()).getLastCellNum();

		for (int currentColumn = 0; currentColumn < totalColumn; currentColumn++) {
			columnHeaderName = sheet.getRow(sheet.getFirstRowNum()).getCell(currentColumn).getStringCellValue();
			if(columnHeaderName.equalsIgnoreCase("ExecutionStatus_"+sIteration)){
				sFoundCol ="Y";
			}
		}

		if(sFoundCol == "N"){
			row = er.getRow(sheet,sheet.getFirstRowNum());
			cell = row.createCell(row.getLastCellNum(),CellType.STRING);
			cell.setCellValue("ExecutionStatus_"+sIteration);
		}*/



	}



}


