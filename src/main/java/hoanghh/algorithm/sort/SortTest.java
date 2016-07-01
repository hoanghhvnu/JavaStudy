package hoanghh.algorithm.sort;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.Random;

public class SortTest {

    public static void main(String[] args) {
        Random ran = new Random();
        List<Integer> randomList = new ArrayList<>();
        for (int i = 0; i < 100; i ++) {
            randomList.add(ran.nextInt(100));
        }

        System.out.println(randomList);
        int a = Collections.binarySearch(randomList, 12);
        System.out.println(a);
        Collections.sort(randomList);
        System.out.println(randomList);
    }

}
