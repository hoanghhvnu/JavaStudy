package hoanghh.study.datetime;

import hoanghh.study.string.StringUtils;

public class ParseTime {
    protected String timeString;

    public ParseTime() {

    } // end method

    public ParseTime(String timeString) {
        this.timeString = timeString;
    } // end method

//    public int translateDateString(String dateString) {
//        dateString = StringUtils.truncateSpace(dateString);
//        dateString = dateString.toLowerCase();
//        switch (dateString) {
//            case "today":
//                return 0;
//            case "yesterday":
//                return -1;
//            case "tomorrow":
//                return 1;
//            case "the day before yesterday":
//                return -2;
//            case "the day after tomorrow":
//                return 2;
//            case "sunday":
//            case "monday":
//            case "tuesday":
//            case "wednesday":
//            case "thursday":
//            case "friday":
//            case "saturday":
//            default:
//                return 0;
//        } // end switch
//    } // end method
} // end class
