package hoanghh.study.multithread;

public class NormalThread {

    public static void main(String[] args) {
        System.out.println(System.currentTimeMillis());
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            // log.error("unknown exception", e);
            e.printStackTrace();
        }
        System.out.println(System.currentTimeMillis());

    }

}
