package hoanghh.study.datetime;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.TimeZone;

import vn.com.datasection.file.FileUtils;


public class CalendarTest {

    public static void main(String[] args) throws ParseException {
        List<String> listTime = new ArrayList<>();
            listTime = FileUtils.getContent("./input/timeinput.txt");
        for (String time : listTime) {
            System.out.println(time);
        } // end for
        
        Calendar cal = Calendar.getInstance();
        String strDate = "05/02/2013 03:00:32 PM";
        SimpleDateFormat formater = new SimpleDateFormat("EEE dd/MM/y hh:mm:ss aa");
        
        System.out.println(formater.format(formater.parse(strDate)));
        System.out.println(formater.format(cal.getTime()));
        System.out.println(cal.getTime().toString());
        cal.add(Calendar.DAY_OF_WEEK, 1);
//        cal.setFirstDayOfWeek(1);
        cal.setTimeZone(TimeZone.getTimeZone("Asia/Saigon"));
        System.out.println(cal.get(Calendar.DAY_OF_WEEK));
        
    } // end main

}
