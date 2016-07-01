package hoanghh.study.multithread;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import vn.com.datasection.file.FileUtils;

public class CrawlerMain {

    public static void main(String[] args) {
        BufferedWriter writer;
        BufferedWriter failWriter;
        try {
            writer = new BufferedWriter(new FileWriter("ouput.txt"));
            File temp = File.createTempFile("java_temp", null);
            failWriter = new BufferedWriter(new FileWriter(temp));
            ExecutorService executor = Executors.newFixedThreadPool(10);
            List<Integer> ids = new ArrayList<>();
            for (int i = 0; i < 100; i ++) {
                ids.add(i);
                if (ids.size() == 10) {
                    List<Integer> wrapIds = new ArrayList<>();
                    wrapIds.addAll(ids);
                    ids.clear();
                    
                    Runnable worker = new Crawler(wrapIds, writer, failWriter);
                    executor.execute(worker);
                } // end
            } // end 
            executor.shutdown();
            
            while(!executor.isTerminated()) {
                try {
                    Thread.sleep(1 * 1000);
                } catch (InterruptedException e) {
                    // log.error("unknown exception", e);
                    e.printStackTrace();
                }
            }
            failWriter.flush();
            List<String> failList = FileUtils.getContent(temp);
            System.out.println(failList);
            
            List<Integer> list = new ArrayList<>();
            for (String id : failList) {
                list.add(Integer.parseInt(id.substring(id.lastIndexOf("\t") + 1)));
            }
            System.out.println(list);
            executor = Executors.newFixedThreadPool(10);
            Runnable worker = new Crawler(list, writer, failWriter);
            executor.execute(worker);
            executor.shutdown();
            while(!executor.isTerminated()) {
                try {
                    Thread.sleep(1 * 1000);
                } catch (InterruptedException e) {
                    // log.error("unknown exception", e);
                    e.printStackTrace();
                }
            }
            try {
                writer.close();
                failWriter.close();
            } catch (IOException e) {
                // log.error("unknown exception", e);
                e.printStackTrace();
            }
        } catch (IOException e1) {
            // log.error("unknown exception", e1);
            e1.printStackTrace();
        }
        
    }

}
