package Management;

import java.text.SimpleDateFormat;
import java.util.Calendar;

class JFrameDate{
	public static final String DATE_FORMAT_NOW = "yyyy-MM-dd HH:mm:ss";
	 
	//this method gets the date and time now. you can modify the
	//date format to not show the time
	 
	public static String timeNow() {
	     Calendar cal = Calendar.getInstance();
	     SimpleDateFormat sdf = new SimpleDateFormat(DATE_FORMAT_NOW);
	     return sdf.format(cal.getTime());
	}
}
