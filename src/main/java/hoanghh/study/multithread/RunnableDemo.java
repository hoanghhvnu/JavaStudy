package hoanghh.study.multithread;

import java.io.FileWriter;

class RunnableDemo implements Runnable {
    // class RunnableDemo extends Thread {
    private String threadName;
    private FileWriter fWriter;

    RunnableDemo(String name, FileWriter fWriter) {
        this.threadName = name;
        this.fWriter = fWriter;
    }

    @Override
    public void run() {
        // System.out.println("Running " + threadName );
        try {
            for (int i = 0; i < 10000000; i++) {
//                synchronized (this) {
                    this.fWriter.append(this.threadName + i + "\n");
                    this.fWriter.flush();
//                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
