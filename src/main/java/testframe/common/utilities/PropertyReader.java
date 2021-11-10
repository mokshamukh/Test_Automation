package testframe.common.utilities;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class PropertyReader {
	private  String frameworkpropertyFile = "src/main/resources/testdesign/globaldata/framework.properties";
	//private  String configpropertyFile = "src/main/resources/testdesign/globaldata/config.properties";
	//private  String appconfigpropertyFile = "src/main/resources/testdesign/globaldata/%s_config.properties";

	private  String strPathToMasterSheet;
	private  String strpathToApplicationTestDataFolder;
	private  String strpathToConfigProperties;
	private  String strpathToAppConfigPropFolder;
	private  String strpathToAppReportFolder;
	private  String strParamValue;

	private  String configpropertyFile_Path;

	public  String pathToMasterFromFrameworkPropFile() throws IOException {
		if (strPathToMasterSheet == null) {
			strPathToMasterSheet = readProperties(frameworkpropertyFile,"pathToMasterSheet");
		}
		return strPathToMasterSheet;
	}

	public  String pathToApplicationTestDataFolderFromFrameworkPropFile() throws IOException {
		if (strpathToApplicationTestDataFolder == null) {
			strpathToApplicationTestDataFolder = readProperties(frameworkpropertyFile,"pathToApplicationTestDataFolder");
		}
		return strpathToApplicationTestDataFolder;
	}

	public  String pathToConfigPropertiesFromFrameworkPropFile() throws IOException {
		if (strpathToConfigProperties == null) {
			strpathToConfigProperties = readProperties(frameworkpropertyFile,"pathToConfigProperties");
		}
		return strpathToConfigProperties;
	}

	public  String pathToAppConfigPropFolderFromFrameworkPropFile() throws IOException {
		if (strpathToAppConfigPropFolder == null) {
			strpathToAppConfigPropFolder = readProperties(frameworkpropertyFile,"pathToAppConfigPropFolder");
		}
		return strpathToAppConfigPropFolder;
	}
	
	public  String pathToAppReportFolderFromFrameworkPropFile() throws IOException {
		if (strpathToAppReportFolder == null) {
			strpathToAppReportFolder = readProperties(frameworkpropertyFile,"pathToAppReportFolder");
		}
		return strpathToAppReportFolder;
	}


	public  String getParamfromConfigProperties(String paramName) throws IOException {
		configpropertyFile_Path = pathToConfigPropertiesFromFrameworkPropFile();
		strParamValue = readProperties(configpropertyFile_Path,paramName);

		return strParamValue;

	}

	public  String readProperties(String propertyFile,String paramName) throws IOException {
		InputStream input;
		Properties prop;
		try{
			input = new FileInputStream(propertyFile);
			prop = new Properties();
			try {
				prop.load(input);
				input.close();
			} catch(IOException e){
				e.printStackTrace();
			}

		} catch(FileNotFoundException e){
			e.printStackTrace();
			throw new RuntimeException("Properties file not found : " +propertyFile);
		}
		if (prop.getProperty(paramName) != null)
			return prop.getProperty(paramName);
		else
			throw new RuntimeException("Parameter '" + paramName + "' not defined in property file-" +propertyFile);
	}

}
