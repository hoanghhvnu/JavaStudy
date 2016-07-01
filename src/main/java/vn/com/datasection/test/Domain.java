package vn.com.datasection.test;

import java.util.Collection;
import java.util.TreeSet;

import vn.com.datasection.file.FileUtils;

public class Domain {
    static String alpha = "qwertyuiopasdfghjklzxcvbnm";
    static String digit = "1234567890";
    static String domain = ".co";

    public static void main(String[] args) {



        int domainLength = 3;
        Collection<String> ok = extension(genDomain(domainLength), domain);
        FileUtils.writeSpecial(ok, "domain_" + domainLength + "_" + domain);
    }

    public static Collection<String> extension(Collection<String> l, String ext) {
        Collection<String> ret = new TreeSet<>();
        for (String s : l) {
            ret.add(s + ext);
        }
        
        return ret;
    }
    
    public static Collection<String> genDomain(int length) {
        if (length == 1) {
            return firtGen();
        }
        Collection<String> ret = firtGen();
        for (int i = 1; i < length; i++) {
            ret = append(ret);
        }

        return ret;
    }

    public static Collection<String> append(Collection<String> l) {
        Collection<String> ret = new TreeSet<>();
        for (String pre : l) {
            for (char c : alpha.toCharArray()) {
                ret.add(pre + c);
            }
        }

        return ret;
    }

    public static Collection<String> firtGen() {
        Collection<String> ret = new TreeSet<>();

        for (char c : alpha.toCharArray()) {
            ret.add(String.valueOf(c));
        }

        return ret;
    }

}
