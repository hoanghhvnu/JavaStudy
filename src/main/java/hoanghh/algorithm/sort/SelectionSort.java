package hoanghh.algorithm.sort;

import java.util.ArrayList;

public class SelectionSort {
    private ArrayList<Integer> rawList;
    private ArrayList<Integer> sortedList;
    
    public SelectionSort(Iterable<Integer> rawList) {
        this.rawList = new ArrayList<>();
        for (Integer el : rawList) {
            this.rawList.add(el);
        }
        
        this.sortedList = new ArrayList<>();
    }
    
    public void sort () {
        int smallest;
        int smallestIndex;
        for (int i = 0; i < this.rawList.size() - 1; i ++) {
            smallest = this.rawList.get(i);
            smallestIndex = i;
            for (int j = i + 1; j < this.rawList.size(); j ++) {
                if (this.rawList.get(j) < smallest) {
                    smallest = this.rawList.get(j);
                    smallestIndex = j;
                }
            }
            int tempValue = this.rawList.get(i);
            this.rawList.set(i, smallest);
            this.rawList.set(smallestIndex, tempValue);
//            this.sortedList.add(smallest);
            
        }
    }
    
    public void dump() {
//        for (int i = 0; i < this.sortedList.size(); i ++ ) {
//            System.out.println(this.sortedList.get(i));
//        }
        System.out.println(this.rawList);
    }
}
