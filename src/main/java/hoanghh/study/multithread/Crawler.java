package hoanghh.study.multithread;

import java.io.IOException;
import java.io.Writer;
import java.util.List;

public class Crawler implements Runnable {
    private List<Integer> ids;
    private Writer writer;
    private Writer failWriter;

    public Crawler(List<Integer> ids, Writer writer, Writer failWriter) {
        this.ids = ids;
        this.writer = writer;
        this.failWriter = failWriter;
    }
    
    @Override
    public void run() {
        // TODO Auto-generated method stub
        int j = 0;
        for (int i : this.ids) {
            if (j++ == 2) {
                synchronized (this.failWriter) {
                    try {
                        this.failWriter.write(Thread.currentThread().getName() + "\t" + i + "\n");
                    } catch (IOException e) {
                        // log.error("unknown exception", e);
                        e.printStackTrace();
                    }
                }
            } else {
                synchronized(this.writer) {
                    try {
                        this.writer.write(Thread.currentThread().getName() + "\t" + i + "\n");
                    } catch (IOException e) {
                        // log.error("unknown exception", e);
                        e.printStackTrace();
                    }
                } // end synchori
            }
            
        } // end for
    } // end method

}
