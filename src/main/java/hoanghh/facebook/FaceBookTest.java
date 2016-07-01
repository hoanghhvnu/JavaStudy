package hoanghh.facebook;

import java.util.Arrays;








import facebook4j.Event;
import facebook4j.Facebook;
import facebook4j.FacebookException;
import facebook4j.FacebookFactory;
import facebook4j.Page;
import facebook4j.ResponseList;
import facebook4j.User;
import facebook4j.auth.AccessToken;



public class FaceBookTest {

	public static void main(String[] args) throws FacebookException {
		// TODO Auto-generated method stub
		Facebook facebook = new FacebookFactory().getInstance();
		facebook.setOAuthAppId("1569356946673573", "acd08a42a95056a0b996a59c4cbf3011");
		facebook.setOAuthPermissions("email");
		facebook.setOAuthAccessToken(new AccessToken("1569356946673573|urY9wvSBWGJsgaV3q0pJxXDi7RE", null));
		
		Page page= facebook.getPage("fan24h");
		User user = facebook.getUser("me");
		System.out.println(user);
//		facebook.postStatusMessage("Hello World from Facebook4J.");
//		ResponseList<Event> results = facebook.searchEvents("conference");
//		for (Event e: results) {
//			System.out.println(e.getLocation());
//		}

		
	}

}
