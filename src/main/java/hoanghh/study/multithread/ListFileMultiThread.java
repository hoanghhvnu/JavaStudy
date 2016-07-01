package hoanghh.study.multithread;

import java.io.File;
import java.util.Set;
import java.util.TreeSet;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import vn.com.datasection.file.FileUtils;


public class ListFileMultiThread extends Thread {
    static Logger       logger = LoggerFactory.getLogger(ListFileMultiThread.class);
    protected String threadName;
    protected Set<File> files;

    public ListFileMultiThread(File path, String threadName) {
        this.files = new TreeSet<>();
        this.files.addAll(FileUtils.listFileRecursiveToSet(path));
        this.threadName = threadName;
    } // end method
    
    ListFileMultiThread(Iterable<File> files, String threadName) {
        this.threadName = threadName;
        for (File file : files) {
            this.files.add(file);
        }
    } // end method

    @Override
    public void run() {
        logger.info(this.threadName + " start!");
        try {
            for (File f : this.files) {
                System.out.println(f.getName());
                sleep(50);
            }
        } catch (InterruptedException e) {
            logger.warn("interupt",e);
        }

        
        logger.info(this.threadName + " finish!");
    } // end method
} // end class
