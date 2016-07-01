package hoanghh.study.datetime;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TimeZone;

public class ConvertTimeZone {

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        DateFormat utcFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss'Z'");
        DateFormat hcmFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        utcFormat.setTimeZone(TimeZone.getTimeZone("UTC"));
        hcmFormat.setTimeZone(TimeZone.getTimeZone("Asia/Ho_Chi_Minh"));
        try {
            Date from = hcmFormat.parse("2015-01-08 00:00:00");
            System.out.println(utcFormat.format(from));
            
//            Calendar cal = Calendar.getInstance();
//            cal.setTime(from);
//            System.out.println(cal.set());
        } catch (ParseException e) {
            // log.error("unknown exception", e);
            e.printStackTrace();
        }
    }

}
