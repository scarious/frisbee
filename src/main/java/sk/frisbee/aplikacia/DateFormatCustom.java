package sk.frisbee.aplikacia;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class DateFormatCustom {
	
	public static String dateForDB(Date date){
		DateFormat df = new SimpleDateFormat("EEE MMM dd HH:mm:ss zzz yyyy", Locale.ENGLISH);
		Date tmp = null;
		String prepared = "0000-00-00";
		if(date != null){
			try {
				tmp = df.parse(date.toString());
				df = new SimpleDateFormat("yyyy-MM-dd");
				prepared =  df.format(tmp);
			} catch (ParseException e) {
				e.printStackTrace();
			}
		}
		

		df = null;
		
		return prepared;
	}
	
	public static Date fromDB(String string){
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		Date date = new Date(0);
		if(string != null || string != ""){
			try {
				date = sdf.parse(string);
			} catch (ParseException | NullPointerException e) {
				
			}	
		}
		
		return date;
	}
}
