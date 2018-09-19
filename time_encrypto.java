import java.time.*;
import java.time.format.DateTimeFormatter;

// import com.sun.xml.internal.ws.util.StringUtils;

import java.time.LocalDateTime;



/**
 * time_encrypto
 */
public class time_encrypto {
    public static void main(String[] args) {
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");  
        LocalDateTime now = LocalDateTime.now();  
        System.out.println(dtf.format(now));  
        StringUtil new1 = new StringUtils(dtf.format(now));  
        System.out.println(new1);
    }   
}
