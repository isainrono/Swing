package utilities;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Utilities {
	
	 public static String actualTimeString() {
	    	LocalDateTime now = LocalDateTime.now();
	    	DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yy HH:mm:ss");

	        String formatDateTime = now.format(formatter);
	        return formatDateTime;
	    }
}
