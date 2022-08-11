package utils;

import java.util.Date;

public class TestUtils {

	
	
	
	public static String getUniqueEmail() {
		return "Test" + System.currentTimeMillis() + "@gmail.com";
	}

	
	
	public static String getUsernameFromEmail(String text) {
		String[] s = text.split("@");
		return s[0];
	}
	
	
	public static String uniqueTextGenerator(String text) {

		Date current = new Date();
		long unique = current.getTime();
		text = text +" "+ Long.toString(unique);
		return text;
	}
	
	
	public static String extractNumberFromString(String word) {

		return word.replaceAll("[^0-9?!\\.]", "");
	}
	
	
	
	
	
	
	
	
}
