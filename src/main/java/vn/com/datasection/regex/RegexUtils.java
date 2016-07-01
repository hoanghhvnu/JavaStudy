package vn.com.datasection.regex;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegexUtils {

    /**
     * Search if pattern found in content string
     * 
     * @param content String need to search
     * @param pattern to search in content string
     * @return true if found and false otherwise
     */
    public static boolean searchRegex(String content, String pattern) {
        Pattern p = Pattern.compile(pattern);
        Matcher m = p.matcher(content);

        return m.find();
    } // end method
} // end class
