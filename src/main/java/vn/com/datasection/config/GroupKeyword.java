package vn.com.datasection.config;


import com.fasterxml.jackson.annotation.JsonTypeName;

@JsonTypeName
public class GroupKeyword {
    protected String title;
    protected String groupKeywordFilePath;
    
    public GroupKeyword(String title, String groupKywordFilePath) {
        this.title = title;
        this.groupKeywordFilePath = groupKywordFilePath;
    } // end method
    
    public String getTitle() {
        return title;
    }
    public String getGroupKeywordFilePath() {
        return groupKeywordFilePath;
    }
    public void setTitle(String title) {
        this.title = title;
    }
    public void setGroupKeywordFilePath(String groupKeywordFilePath) {
        this.groupKeywordFilePath = groupKeywordFilePath;
    }
} // end class
