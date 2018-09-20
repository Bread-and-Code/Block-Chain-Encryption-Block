import java.text.DateFormat;
import java.time.*;
import java.time.format.DateTimeFormatter;

// import com.sun.xml.internal.ws.spi.db.TypeInfo;

// import com.sun.glass.ui.Pixels.Format;

// import com.sun.xml.internal.ws.util.StringUtils;

import java.time.LocalDateTime;



/**
 * time_encrypto
 */
public class time_encrypto {
    static void gettime(){
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
        LocalDateTime now = LocalDateTime.now();
        System.out.println(dtf.format(now));
    }
    static void getdate(){
        LocalDate date = LocalDate.now();
        System.out.println(date);
        // System.out.println(TypeInfo(date));

    }
    static void gettimeonly(){
        LocalTime time = LocalTime.now();
        System.out.println(time);
    }
    static void gethouronly(){
        LocalDate time = LocalDate.now();
        System.out.println(time.getDayOfWeek());
        System.out.println(time.getMonth());
    }
    public static void main(String[] args) {
        getdate();
        gettime();
        gettimeonly();
        gethouronly();
        // Added to encrypt the time
        // StringUtil new1 = new StringUtils(dtf.format(now));
        // System.out.println(new1);
    }
}
