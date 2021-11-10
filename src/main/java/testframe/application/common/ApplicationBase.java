package testframe.application.common;

import java.io.File;

import testframe.common.utilities.EncryptDecryptHelper;
import testframe.common.utilities.ExcelReader;
import testframe.common.utilities.FileInteractions;
import testframe.common.utilities.PropertyReader;

public class ApplicationBase {
	
	public PropertyReader pr =new PropertyReader();
	public ExcelReader er = new ExcelReader();
	//public BrowserFactory bf =new BrowserFactory();
	public EncryptDecryptHelper ed =new EncryptDecryptHelper();
	public FileInteractions fi =new FileInteractions();
	
	
	
}
