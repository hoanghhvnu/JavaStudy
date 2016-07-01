package hoanghh.study.network;

import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

public class FacebookUtils {
    public static String getUid(String scopeId) {
        String avatar = getRedirectedUrl("https://graph.facebook.com/" + scopeId + "/picture");
        String shortAvatar = avatar.split("\\?")[0];
        String remain = shortAvatar.substring(shortAvatar.lastIndexOf('/'));
        String albumId = remain.split("_")[1];
        String albumLink = getRedirectedUrl("https://facebook.com/" + albumId);
        String uid = albumLink.substring(albumLink.lastIndexOf('.') + 1).split("&")[0];

        return uid;
    }

    public static void main(String[] args) {
        String uid = NetworkUtils.getUid("298227093705294");
        System.out.println(uid);
    }

    private static String getRedirectedUrl(String url) {
        URLConnection con;
        try {
            con = new URL(url).openConnection();
            con.connect();
            @SuppressWarnings("resource")
            InputStream is = con.getInputStream();

            is.close();

            return con.getURL().toString();

        } catch (MalformedURLException e) {
            // log.error("unknown exception", e);
            e.printStackTrace();
        } catch (IOException e) {
            // log.error("unknown exception", e);
            e.printStackTrace();
        }

        return "";
    } // end method
}
