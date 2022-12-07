package com.ace.blue.util.time;

import java.time.LocalDateTime;
import java.util.Date;

public class TimeConvertor {

	public static Date toDate(LocalDateTime localDateTime) {
		Date date = java.sql.Timestamp.valueOf(localDateTime);

		return date;

	}

}
