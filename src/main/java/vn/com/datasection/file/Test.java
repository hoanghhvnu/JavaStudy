package vn.com.datasection.file;

import java.io.IOException;

public class Test {

    public static void main(String[] args) {
        try {
            FileHelper.append("test", "test_FileHelper.txt");
        } catch (IOException e) {
            // log.error("unknown exception", e);
            e.printStackTrace();
        }
    }

}
