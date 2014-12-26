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

    public static List<File> listFiles(String directoryPath) {
        return listFiles(new File(directoryPath));
    }

    public static List<File> listFiles(File directory) {
        List<File> files = new ArrayList<>();
        for (File file : directory.listFiles()) {
            if (file.isFile() && !file.isHidden()) {
                files.add(file);
            } // end if
        } // end for

        return files;
    } // end method

    /**
     * List all file in directory with special extension
     * 
     * @param directoryPath
     * @param fileExtension
     * @return Array of file satisfy
     */
    public static List<File> listFiles(String directoryPath, String fileExtension) {
        return listFiles(new File(directoryPath), fileExtension);
    }

    /**
     * List all file in directory with special extension
     * 
     * @param directory
     * @param fileExtension
     * @return Array of file satisfy
     */
    public static List<File> listFiles(File directory, String fileExtension) {
        List<File> files = new ArrayList<>();
        for (File file : directory.listFiles()) {
            if (file.isFile() && !file.isHidden() && file.getName().endsWith(fileExtension)) {
                files.add(file);
            } // end if
        } // end for

        return files;
    } // end method

    /**
     * List all file in directory with specify extension
     * 
     * @param directoryPath
     * @param fileExtension
     * @param isInvert
     *            return only file no have specify extension
     * @return
     */
    public static List<File> listFiles(String directoryPath, String fileExtension, boolean isInvert) {
        return listFiles(new File(directoryPath), fileExtension, isInvert);
    } // end method

    /**
     * List all file with specify extension
     * 
     * @param directory
     * @param fileExtension
     * @param isInvert
     *            return all file not have specify extension
     * @return
     */
    public static List<File> listFiles(File directory, String fileExtension, boolean isInvert) {
        if (isInvert == false)
            return listFiles(directory, fileExtension);

        List<File> files = new ArrayList<>();
        for (File file : directory.listFiles()) {
            if (file.isFile() && !file.isHidden() && file.getName().endsWith(fileExtension)) {
                continue;
            } // end if
            files.add(file);
        } // end for

        return files;
    } // end method

    /**
     * List all file inside directory recursive
     * 
     * @param directoryPath
     * @return list file
     */
    public static List<File> listFilesRecusive(String directoryPath) {
        return listFilesRecusive(new File(directoryPath));
    } // end method

    /**
     * List all file inside directory recursive
     * 
     * @param directory
     * @return
     */
    public static List<File> listFilesRecusive(File directory) {
        List<File> files = new ArrayList<>();
        for (File file : directory.listFiles()) {
            if (file.isFile() && !file.isHidden()) {
                files.add(file);
            } else if (file.isDirectory() && !file.isHidden()) {
                files.addAll(listFilesRecusive(file));
            } // end if
        } // end for

        return files;
    } // end method

    /**
     * List all file in directory with specify extension
     * 
     * @param directoryPath
     * @param fileExtension
     * @return
     */
    public static List<File> listFilesRecusive(String directoryPath, String fileExtension) {
        return listFilesRecusive(new File(directoryPath), fileExtension);
    } // end method

    /**
     * List all file in directory with specify extension
     * 
     * @param directory
     * @param fileExtension
     * @return List file
     */
    public static List<File> listFilesRecusive(File directory, String fileExtension) {
        List<File> files = new ArrayList<>();
        for (File file : directory.listFiles()) {
            if (file.isFile() && !file.isHidden() && file.getName().endsWith(fileExtension)) {
                files.add(file);
            } else if (file.isDirectory() && !file.isHidden()) {
                files.addAll(listFilesRecusive(file, fileExtension));
            } // end if
        } // end for

        return files;
    } // end method

    /**
     * List all file in directory with specify extension
     * 
     * @param directoryPath
     * @param fileExtension
     * @param isInvert
     *            return all file not have specify extension
     * @return
     */
    public static List<File> listFilesRecusive(String directoryPath, String fileExtension, boolean isInvert) {
        return listFilesRecusive(new File(directoryPath), fileExtension, isInvert);
    } // end method

    /**
     * List all file in directory with specify extension
     * 
     * @param directory
     * @param fileExtension
     * @param isInvert
     *            return all file not have specify extension
     * @return
     */
    public static List<File> listFilesRecusive(File directory, String fileExtension, boolean isInvert) {
        if (isInvert == false)
            listFilesRecusive(directory, fileExtension);

        List<File> files = new ArrayList<>();
        for (File file : directory.listFiles()) {
            if (file.isFile() && !file.isHidden()) {
                if (file.getName().endsWith(fileExtension)) {
                    continue;
                } else {
                    files.add(file);
                } // end if check extension
            } else if (file.isDirectory() && !file.isHidden()) {
                files.addAll(listFilesRecusive(file, fileExtension, isInvert));
            } // end if
        } // end for

        return files;
    } // end method

    /**
     * write String array to file
     * 
     * @param data
     * @param path
     */
    public static void write(String[] data, String path) {
        write(data, new File(path));
    } // end method

    /**
     * Write string to file
     * 
     * @param data
     * @param file
     */
    public static void write(String[] data, File file) {
        try (FileWriter fw = new FileWriter(file)) {
            for (String line : data) {
                fw.write(line + "\n");
            } // end for
        } catch (Exception e) {
            e.printStackTrace();
        } // end try
    } // end method
} // end class
