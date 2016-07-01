package vn.com.datasection.file;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

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
        } catch (IOException e) {
            e.printStackTrace();
        }

        return content;
    } // end method

    public static File[] listFiles(String directoryPath) {
        return listFiles(new File(directoryPath));
    }

    public static File[] listFiles(File directory) {
        return directory.listFiles();
    }

    public static List<File> listFileRecursive(String path) {
        return listFileRecursive(new File(path));
    }

    public static List<File> listFileRecursive(File directory) {
        List<File> result = new ArrayList<>();
        File[] listFileLevel0 = directory.listFiles();
        for (File file : listFileLevel0) {
            if (file.isFile()) {
                result.add(file);
            } else if (file.isDirectory()) {
                result.addAll(listFileRecursive(file));
            } // end if
        } // end for

        return result;
    } // end method

    public static Set<File> listFileRecursiveToSet(String path) {
        return listFileRecursiveToSet(new File(path));
    }

    public static Set<File> listFileRecursiveToSet(File directory) {
        Set<File> result = new TreeSet<>();
        File[] listFileLevel0 = directory.listFiles();
        for (File file : listFileLevel0) {
            if (file.isFile()) {
                result.add(file);
            } else if (file.isDirectory()) {
                result.addAll(listFileRecursiveToSet(file));
            } // end if
        } // end for

        return result;
    } // end method
    
    public static Set<File> listFileRecursiveToSet(String path, String endWith) {
        return listFileRecursiveToSet(new File(path), endWith);
    }

    public static Set<File> listFileRecursiveToSet(File directory, String endWith) {
        Set<File> result = new TreeSet<>();
        File[] listFileLevel0 = directory.listFiles();
        for (File file : listFileLevel0) {
            if (file.isFile() && file.getName().endsWith(endWith)) {
                result.add(file);
            } else if (file.isDirectory()) {
                result.addAll(listFileRecursiveToSet(file));
            } // end if
        } // end for

        return result;
    } // end method

    public static List<File> listFileRecursive(String path, String pattern) {
        return listFileRecursive(new File(path), pattern);
    } // end method

    public static List<File> listFileRecursive(File directory, String pattern) {
        List<File> result = new ArrayList<>();
        File[] listFileLevel0 = directory.listFiles();
        for (File file : listFileLevel0) {
            if (file.isFile() && file.getName().endsWith(pattern)) {
                result.add(file);
            } else if (file.isDirectory()) {
                result.addAll(listFileRecursive(file));
            } // end if
        } // end for

        return result;
    } // end method

    public static void write(String[] data, String path) {
        write(data, new File(path));
    }

    public static void write(String[] data, File file) {
        try (FileWriter fw = new FileWriter(file)) {
            for (String line : data) {
                fw.write(line + "\n");
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void write(Collection<String> data, String path) {
        write(data, new File(path));
    }

    public static void write(Collection<String> data, File file) {
        try (FileWriter fw = new FileWriter(file)) {
            for (String line : data) {
                fw.write(line + "\n");
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    public static void writeSpecial(Collection<String> data, String file) {
        Collection<String> sub = new ArrayList<>();
        int i = 0;
        for (String s : data) {
            sub.add(s);
            
            if (sub.size() == 500 || i == data.size() - 1) {
                write(sub, file + "." + String.valueOf(i / 500));
                sub = null;
                sub = new ArrayList<>();
            }
            i++;
        }
        
    }

    public static void write(Set<String> data, String path) {
        write(data, new File(path));
    }

    public static void write(Set<String> data, File file) {
        try (FileWriter fw = new FileWriter(file)) {
            for (String line : data) {
                fw.write(line + "\n");
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void append(String data, String path) {
        try (FileWriter fw = new FileWriter(path, true)) {
            fw.append(data + "\n");
        } catch (Exception e) {
            e.printStackTrace();
        }
    } // end append

    public static boolean mkdirs(String path) {
        File dir = new File(path);

        return dir.mkdirs();
    } // end method
} // end class
