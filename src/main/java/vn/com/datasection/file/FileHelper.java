package vn.com.datasection.file;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

import com.google.common.base.Charsets;
import com.google.common.io.Files;

public class FileHelper {

    public static List<File> getAllFileInFolder(String folderPath) {
        File folder = new File(folderPath);
        List<File> result = new ArrayList<>();
        for (File f : Files.fileTreeTraverser().postOrderTraversal(folder)) {
            if (f.isFile() && !f.isHidden())
                result.add(f);
        }
        return result;
    }

    public static Set<File> getSetFileFolder(String folderPath) {
        File folder = new File(folderPath);
        Set<File> result = new LinkedHashSet<>();
        for (File f : Files.fileTreeTraverser().postOrderTraversal(folder)) {
            if (f.isFile() && !f.isHidden())
                result.add(f);
        }
        return result;
    }

    public static Set<File> getSortedSetFileFolder(String folderPath) {
        File folder = new File(folderPath);
        Set<File> result = new TreeSet<>();
        for (File f : Files.fileTreeTraverser().postOrderTraversal(folder)) {
            if (f.isFile() && !f.isHidden())
                result.add(f);
        }
        return result;
    }

    public static String getFileContent(String path) {
        String content = null;
        try {
            content = Files.toString(new File(path), Charsets.UTF_8);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return content;
    }

    public static void append(String content, String path) throws IOException {
        File file = new File(path);
        if (file.getParentFile() != null)
            file.getParentFile().mkdirs();

        Files.append(content, file, Charsets.UTF_8);
    } // end method

}
