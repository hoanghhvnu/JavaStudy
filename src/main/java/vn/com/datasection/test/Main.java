package vn.com.datasection.test;

import java.text.Normalizer;
import java.text.Normalizer.Form;
import java.util.Date;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;



public class Main {
    @SuppressWarnings("deprecation")
    public static void main(String[] args) {
        
        Date start = new Date();
        Date end = new Date();
        Period p = new Period(start, end);
        p.end().setYear(93);
        System.out.println(p);
        try {
            synchronized (p) {
                p.wait(12);
            }
            

            System.out.println(System.nanoTime());
            System.out.println(System.currentTimeMillis());
            ConcurrentMap<String, String> d = new ConcurrentHashMap<>();
        } catch (InterruptedException e) {
            // log.error("unknown exception", e);
            e.printStackTrace();
        }
    }
}
