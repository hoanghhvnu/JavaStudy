package vn.com.datasection.config;

import java.util.List;

/**
 * this class contain configure for project, to easy customize although run via
 * jar file
 * 
 * @author hoanghh
 *
 */
public class Config {
    protected String         dataDirectoryPath;
    protected String         keywordFilePath;
    protected String         statisticFilePath;
    protected String         searchDataFilePath;
    protected String         separateFieldSign;
    protected String         lineFeedSign;
    protected List<GroupKeyword> groupKeyword;

    public String getSeparateFieldSign() {
        return separateFieldSign;
    }

    public String getLineFeedSign() {
        return lineFeedSign;
    }

    public void setSeparateFieldSign(String separateFieldSign) {
        this.separateFieldSign = separateFieldSign;
    }

    public void setLineFeedSign(String lineFeedSign) {
        this.lineFeedSign = lineFeedSign;
    }

    public String getDataDirectoryPath() {
        return dataDirectoryPath;
    }

    public String getKeywordFilePath() {
        return keywordFilePath;
    }

    public String getStatisticFilePath() {
        return statisticFilePath;
    }

    public String getSearchDataFilePath() {
        return searchDataFilePath;
    }

    public List<GroupKeyword> getGroupKeyword() {
        return groupKeyword;
    }

    public void setDataDirectoryPath(String dataDirectoryPath) {
        this.dataDirectoryPath = dataDirectoryPath;
    }

    public void setKeywordFilePath(String keywordFilePath) {
        this.keywordFilePath = keywordFilePath;
    }

    public void setStatisticFilePath(String statisticFilePath) {
        this.statisticFilePath = statisticFilePath;
    }

    public void setSearchDataFilePath(String searchDataFilePath) {
        this.searchDataFilePath = searchDataFilePath;
    }

    public void setGroupKeyword(List<GroupKeyword> groupKeyword) {
        this.groupKeyword = groupKeyword;
    }

} // end class
