package serverData;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;
import java.time.format.DateTimeFormatter;
import java.time.LocalDate;

public class DateData {
	
	static Calendar cal = Calendar.getInstance(); 
    static LocalDate now = LocalDate.now();
    // 포맷 정의
    static DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
    // 포맷 적용
 	static String formatedNow = now.format(formatter);

    static DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
    static Date date = null;
    
    static {
    	try {
            date = df.parse(formatedNow);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        cal.setTime(date);
    }
	
    public Calendar getDate() {    
        //System.out.println("current: " + df.format(cal.getTime()));
        //System.out.println("after: " + df.format(cal.getTime()));
        return cal;
    }
    
   public Calendar addTime(int year, int month, int date) {
    	Calendar calen = cal;
	   	calen.add(Calendar.YEAR, year);
        calen.add(Calendar.MONTH, month);
        calen.add(Calendar.DATE, date);
        return calen;
    }
}
