package hoanghh.study.string;

import java.util.Map;

public class StringUtils {
    public static String concat(final Iterable<String> arg) {
        String ret = "";
        for (String str : arg) {
            ret += str;
        }

        return ret;
    } // end method

    public static class HumanReadable {
        public static <K, V> String fromMap(Map<K, V> map) {
            StringBuilder sb = new StringBuilder();
            for (Map.Entry<K, V> entry : map.entrySet()) {
                if (sb.length() != 0) {
                    sb.append("\n");
                }
                sb.append(String.format("\"%s\": \"%s\"", entry.getKey(), entry.getValue()));
            }

            return sb.toString();
        } // end method
        
        public static <T> String fromIterable(Iterable<T> iterable) {
            StringBuilder sb = new StringBuilder();
            for (T el : iterable) {
                if (sb.length() != 0) {
                    sb.append("\n");
                }
                sb.append(el);
            }
            
            return sb.toString();
        } // end method
    } // end class HumanReadable
} // end class
