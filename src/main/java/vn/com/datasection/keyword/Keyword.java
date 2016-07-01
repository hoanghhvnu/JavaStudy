package vn.com.datasection.keyword;

import java.io.File;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import vn.com.datasection.file.FileUtils;

public class Keyword {
    static Logger logger = LoggerFactory.getLogger(Keyword.class); 
    protected Set<String> keywords = new HashSet<>();
    
    public void put(String keyword) {
        keyword = keyword.trim();
        if (keyword.length() == 0) return;
        
        this.keywords.add(keyword);
        logger.info("add keyword success");
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
