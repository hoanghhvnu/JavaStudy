package vn.com.datasection.word;

import java.io.File;

import vn.com.datasection.file.FileUtils;

public class ReadText {

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        WordStatistic ws = new VietnameseWordStatistic();
        
        for (File f : FileUtils.listFiles(args[0])) {
            for (String line : FileUtils.getContent(f)) {
                for (String word : line.split("\\s+")) {
                    ws.add(word);
                }
            }
        }
        
        ws.writeToFile("wordStatistic.txt");
    }
    
    

}
