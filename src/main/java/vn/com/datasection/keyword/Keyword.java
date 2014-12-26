package vn.com.datasection.keyword;

import java.io.File;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import vn.com.datasection.file.FileUtils;

public class Keyword {
    protected Set<String> keywords = new HashSet<>();
    
    public void put(String keyword) {
        keyword = keyword.trim();
        if (keyword.length() == 0) return;
        
        this.keywords.add(keyword);
    } // end method
    
    public boolean isExist(String keyword) {
        return this.keywords.contains(keyword);
    } // end method
    
    public String[] getKeywords() {
        return this.keywords.toArray(new String[this.keywords.size()]);
    }
    
    public void importKeywordFromFile(String path) {
        this.importKeywordFromFile(new File(path));
    } // end method
    
    public void importKeywordFromFile(File file) {
        List<String> keywords= new ArrayList<>();
        keywords = FileUtils.getContent(file);
        for (String keyword : keywords) {
            this.put(keyword);
        }
    } // end method
}
