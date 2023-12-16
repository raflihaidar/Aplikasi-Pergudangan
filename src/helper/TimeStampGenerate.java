package helper;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;

public class TimeStampGenerate {
     private static final SimpleDateFormat sdf3 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
     public static String generateTimeStamp(){
        Timestamp timestamp = new Timestamp(System.currentTimeMillis());
        String result = sdf3.format(timestamp);
        return result;
     }
}
