package vn.com.datasection.file;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class FileUtils {

    public static List<String> getContent(String path) {
        return getContent(new File(path));
    } // end method

    public static List<String> getContent(File file) {
        List<String> content = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(file))) {
            String line;
            while ((line = br.readLine()) != null) {
                content.add(line);
            } // end while
        } catch (IOException ioe) {
            ioe.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        } // end try

        return content;
    } // end method
    
    public static File[] listFiles(String directoryPath) {
        return listFiles(new File(directoryPath));
    }
    
    public static File[] listFiles(File directory) {
        return directory.listFiles();
    }
    
    public static void write(String[] data, String path) {
        write(data, new File(path));
    }
    
    public static void write(String[] data, File file) {
        try (FileWriter fw = new FileWriter(file)) {
            for (String line : data) {
                fw.write(line + "\n");
            }
            
        } catch(Exception e) {
            e.printStackTrace();
        }
    }
} // end class
