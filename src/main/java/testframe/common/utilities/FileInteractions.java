package testframe.common.utilities;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import org.apache.commons.io.FileUtils;

public class FileInteractions {
	public void createFolder(String folderPath) throws IOException{
		File file = new File(folderPath);
		if(file.getAbsoluteFile().exists()){
			FileUtils.forceDelete(file);
			file.mkdir();
			return;
		}
		file.mkdir();
	}
	
	public void checkAndCreateFolder(String folderPath) throws IOException{
		File file = new File(folderPath);
		if(!file.getAbsoluteFile().exists()){
			file.mkdir();
		}
		
	}


	public void createFile(String filePath) throws IOException{
		File file = new File(filePath);
		if(file.getAbsoluteFile().exists()){
			FileUtils.forceDelete(file);
			file.getAbsoluteFile().createNewFile();
		}
		file.getAbsoluteFile().createNewFile();
	}

	public void writeALineToFile(String fileName, String line) throws IOException{
		FileWriter fileWriter = new FileWriter(fileName, true);
		fileWriter.append(line);
		fileWriter.append("\n");
		fileWriter.close();
	}
}
