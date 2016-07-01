package vn.com.datasection.test;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import vn.com.datasection.file.FileUtils;

public class Space160Test {
    public static void main(String[] args) {

            List<String> listId = FileUtils.getContent("/workspace/facebookcrawler/input/ids/temp.txt");
            // System.out.println(listId.size());
            long start = System.currentTimeMillis();
            Set<String> ids = new HashSet<>();
            int dup = 0;
            for (String id : listId) {
                if (!isValidId(id)) {
                    System.out.println(id);
                } else if (!ids.add(id)) {
                    dup++;
                }

            }
            long end = System.currentTimeMillis();
            System.out.println("dup: " + dup);
            System.out.println("Time: " + (end - start));
    }

    public static boolean isValidId(final String fanpageId) {
        String test = fanpageId.replaceAll("[0-9]+", "");

        return test.isEmpty();
    }

    /**
     * Add Offset of number by zero character
     * 
     * @param number
     *            origin number
     * @param goalLength
     *            length of string number want
     * @return String represent goal number
     */
    public static String prependZero(final int number, final int goalLength) {
        StringBuilder sb = new StringBuilder();
        String origin = String.valueOf(number);

        int offset = goalLength - origin.length();
        offset = offset < 0 ? 0 : offset;
        for (int i = 0; i < offset; i++) {
            sb.append("0");
        }
        sb.append(origin);

        return sb.toString();
    } // end method prependZero
}
