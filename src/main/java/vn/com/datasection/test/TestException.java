package vn.com.datasection.test;

public class TestException {
    public static void main(String[] args) {
        try {
            for (int i = 0; i < 10; i ++) {
                if (i == 5) {
                    throw new IllegalArgumentException("bang 5");
                }
                System.out.println(i);
            }
        } catch (IllegalArgumentException e) {
            System.out.println(e);
        } finally {
            System.out.println("this is final");
        }

    }
}
