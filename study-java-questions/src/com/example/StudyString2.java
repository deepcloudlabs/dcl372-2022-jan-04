package com.example;

import java.text.DecimalFormat;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import java.util.Locale;

public class StudyString2 {

	public static void main(String[] args) {
		// java -Duser.language=tr -Duser.country=TR -jar myapp.jar
		var city = "izmir";
		// Locale
		var tr = new Locale("tr", "TR");
		System.out.println(city.toUpperCase(tr));
		ZonedDateTime birthDate = ZonedDateTime.now();
		DateTimeFormatter dtf = DateTimeFormatter.ofLocalizedDateTime(FormatStyle.FULL)
				                                 .withLocale(Locale.GERMAN);
		System.out.println(dtf.format(birthDate));
		var money = 10_345_786.56;
		var df = DecimalFormat.getCurrencyInstance(Locale.KOREA);
		System.out.println(df.format(money));
	}

}
