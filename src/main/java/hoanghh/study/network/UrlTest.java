package hoanghh.study.network;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

public class UrlTest {

    public static void main(String[] args) {
        URL obj;
        try {
            obj = new URL("https://facebook.com/399595540235115");
            HttpURLConnection conn;
            try {
                conn = (HttpURLConnection) obj.openConnection();
                conn.setInstanceFollowRedirects(true); // you still need to handle redirect manully.
                HttpURLConnection.setFollowRedirects(true);
                System.out.println(conn);
            } catch (IOException e) {
                // log.error("unknown exception", e);
                e.printStackTrace();
            }
        } catch (MalformedURLException e1) {
            // log.error("unknown exception", e1);
            e1.printStackTrace();
        }

        
        URLConnection con;
        try {
            con = new URL( "https://graph.facebook.com/10204976855397226/picture" ).openConnection();
            System.out.println( "orignal url: " + con.getURL() );
            con.connect();
            System.out.println( "connected url: " + con.getURL() );
            InputStream is = con.getInputStream();
            
            System.out.println( "redirected url: " + con.getURL() );
            is.close();
        } catch (MalformedURLException e) {
            // log.error("unknown exception", e);
            e.printStackTrace();
        } catch (IOException e) {
            // log.error("unknown exception", e);
            e.printStackTrace();
        }
        
    }

}
