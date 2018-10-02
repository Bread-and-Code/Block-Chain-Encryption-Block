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
    static String gettime(){
        String now = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy/MM/dd-HH:mm:ss.SSS"));
        return now;
    }
    static String getdate(){
        String date = LocalDate.now().format(DateTimeFormatter.ofPattern("yyyy/MM/dd"));
        return date;
    }
    static String gettimeonly(){
        String time = LocalTime.now().format(DateTimeFormatter.ofPattern("HH:mm:ss.SSS"));
        return time;
    }
    /*static void gethouronly(){
        LocalDate time = LocalDate.now();
        System.out.println(time.getDayOfWeek());
        System.out.println(time.getMonth());
        //prebuild hash can be added with it . Have to check this :)
        System.out.println(time.hashCode());
    }*/
    public static void main(String[] args) {
        getdate();
        gettime();
        gettimeonly();
        //gethouronly();
        // Added to encrypt the time
        // StringUtil new1 = new StringUtils(dtf.format(now));
        // System.out.println(new1);
    }

}
