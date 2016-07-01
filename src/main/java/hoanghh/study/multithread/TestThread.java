package hoanghh.study.multithread;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class TestThread {
    public static void main(String args[]) {
//        ExecutorService executor = Executors.newFixedThreadPool(10);
//        FileWriter fWriter;
//        try {
//            fWriter = new FileWriter("output/multithread_output.txt", true);
//            for (int i = 0; i < 10; i ++) {
//                Runnable thread = new RunnableDemo("Thread " + i + ": ", fWriter);
//                executor.execute(thread);
//            }
//            executor.shutdown();
//        } catch (IOException e1) {
//            // log.error("unknown exception", e1);
//            e1.printStackTrace();
//        }

        Map<String, String> mapGlobal = new HashMap<>();
        try (BufferedReader br = new BufferedReader(new FileReader("/home/hoanghh/Skype Download/mm.txt"));
               BufferedWriter bw = new BufferedWriter(new FileWriter("cocacola_update_global.txt"));
                BufferedReader rr = new BufferedReader(new FileReader("/data/hoanghh/workspace/JavaStudy/input/coca_update.txt"))){
            String line;
            while((line = br.readLine()) != null) {
                String global = line.substring(0, line.indexOf("-"));
                String els[] = line.substring(line.indexOf("-") + 1).split("\\-");
                for (String id : els) {
//                    bw.write(id + "\n");
                    mapGlobal.put(id, global);
                }
            }
            try {
                Thread.sleep(10*1000);
            } catch (InterruptedException e) {
                // log.error("unknown exception", e);
                e.printStackTrace();
            }
            while((line = rr.readLine()) != null) {
                bw.write(mapGlobal.get(line.split("\t")[2]) + "\n");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }   
 }