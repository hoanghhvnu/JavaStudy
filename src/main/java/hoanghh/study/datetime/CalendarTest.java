package hoanghh.study.datetime;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class CalendarTest {

    public static void main(String[] args) throws ParseException {
        ;
        Calendar cal = Calendar.getInstance();
        String strDate = "05/02/2013 03:00:32 PM";
        SimpleDateFormat formater = new SimpleDateFormat("dd/MM/y hh:mm:ss aa");
        String oaeu;
        System.out.println(formater.format(formater.parse(strDate)));
        System.out.println(formater.format(cal.getTime()));
        System.out.println(cal.getTime().toString());
    } // end main

}
