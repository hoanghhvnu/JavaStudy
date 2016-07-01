package hoanghh.study.string;

import java.util.ArrayList;
import java.util.List;

import vn.com.datasection.file.FileUtils;

public class VietnamesePeopleName {

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        List<String> fname = FileUtils.getContent("input/vn_firstname.txt");
        List<String> lname = FileUtils.getContent("input/vn_lastname.txt");
        List<String> cfname = FileUtils.getContent("input/vn_firstname_compoud.txt");
        
        List<String> ret = new ArrayList<>();
        try {
            for (String lastRaw : lname) {
                String last = lastRaw.split("\t")[0];
                for (String firstRaw : fname) {
                    String[] arr = firstRaw.split("\t");
                    String first = arr[0];
                    if (arr.length < 3) {
                        System.out.println(firstRaw);
                    }
                    String gender = arr[2];
                    if (gender.compareTo("M") == 0) {
                        ret.add(last + " Văn " + first);
                    } else if (gender.compareTo("F") == 0) {
                        ret.add(last + " Thị " + first);
                    } else {
                        ret.add(last + " Văn " + first);
                        ret.add(last + " Thị " + first);
                    }
                }
            }
            
            FileUtils.write(ret, "VietnamesePeopleName.txt");
        } catch (ArrayIndexOutOfBoundsException e) {
            e.printStackTrace();
            
        }
        
    }

}
