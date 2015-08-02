package se.tr1golf.misc;

import java.text.SimpleDateFormat;
import java.util.Calendar;

public class datehandler {

	public String get_todaydate() {
		Calendar cal = Calendar.getInstance();
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
		String date = df.format(cal.getTime());
		return date;
	}

}
