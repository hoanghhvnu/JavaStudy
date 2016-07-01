package vn.com.datasection.test;

import hoanghh.study.multithread.ListFileMultiThread;

import java.io.File;
import java.util.ArrayList;
import java.util.List;


public class ListFileMultiThreadTest {

    public static void main(String[] args) {
        String dir = "/data/hoanghh/workspace/jar/";
        File dirFile = new File(dir);
        int threadNumer = 0;
        List<ListFileMultiThread> listThread = new ArrayList<>();
        for (File f : dirFile.listFiles()) {
            ++threadNumer;
            if (f.isDirectory()) {
//                System.out.println(FileUtils.listFileRecursiveToSet(f));
                listThread.add(new ListFileMultiThread(f, "Thread " + threadNumer));
            }
        }
        for (ListFileMultiThread th : listThread) {
            th.start();
        }
    }


}
