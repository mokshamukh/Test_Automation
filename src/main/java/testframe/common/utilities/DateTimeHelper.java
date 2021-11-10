package testframe.common.utilities;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Date;

public class DateTimeHelper {

	public String CurrentDateTime(){
		SimpleDateFormat formatter = new SimpleDateFormat("MMddyyyy-HHmmss");
		Date date = new Date();
		return formatter.format(date);

	}
	
	public String CurrentDateTime(String sFormat){
		SimpleDateFormat formatter = new SimpleDateFormat(sFormat);
		Date date = new Date();
		return formatter.format(date);

	}
	
	
	public Date Now(String sFormat) throws ParseException{
		SimpleDateFormat formatter = new SimpleDateFormat(sFormat);
		Date date = new Date();
		return formatter.parse(formatter.format(date));

	}
	
	public String getDateTime(Date dDate,String sFormat){
		SimpleDateFormat formatter = new SimpleDateFormat(sFormat);
		//Date date = new Date();
		return formatter.format(dDate);

	}
	
	public String getDateTime(String sDate, String sPattern,String sToFormat) throws Exception{
		DateFormat format = new SimpleDateFormat(sPattern);
		Date date = format.parse(sDate);
		SimpleDateFormat formatter = new SimpleDateFormat(sToFormat);
		return formatter.format(date);

	}


}
