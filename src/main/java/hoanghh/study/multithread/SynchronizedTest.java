package hoanghh.study.multithread;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class SynchronizedTest implements Runnable {
    private String threadName;
    private static Set<String> share;
    
    static {
        share = Collections.synchronizedSet(new HashSet<String>());
//        share = new HashSet<>();
    }
    
    public SynchronizedTest(String threadName) {
        this.threadName = threadName;
    }
    
    





    @Override
    public void run() {
//        Random rand = new Random();
        for (int i = 0; i < 10; i ++) {
            share.add(this.threadName + ": " + i);
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                // log.error("unknown exception", e);
                e.printStackTrace();
            }
//            synchronized (share){
                if (share.size() > 0) {
                    String text = share.iterator().next();
                    share.remove(text);
                    System.out.println(this.threadName + " Win with: "+ text);
//                    share.clear();
                }
//            }
            
        }
    }
    
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        ExecutorService es = Executors.newFixedThreadPool(50);
        for (int i = 0; i < 5; i ++) {
            Runnable run = new SynchronizedTest("Thread " + i);
            es.execute(run);
        }
        es.shutdown();
    }

}
