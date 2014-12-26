package vn.com.datasection.test;

import java.io.File;

import vn.com.datasection.file.FileUtils;

public class Main {

    public static void main(String[] args) {
        for (File file : FileUtils.listFilesRecusive("/data/hoanghh/tmp/chientd/fujisu/3th/", "xz", true)) {
            System.out.println(file.getAbsolutePath());
        }

    }

}
