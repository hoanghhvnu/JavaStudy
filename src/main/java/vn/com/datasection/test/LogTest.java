package vn.com.datasection.test;


import hoanghh.study.datetime.DateUtils;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


public class LogTest {

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        // static Logger logger = LoggerFactory.ge
        final Logger debugLog = LoggerFactory.getLogger("debugLogger");
        final Logger resultLog = LoggerFactory.getLogger("reportsLogger");
        debugLog.info("this log for dubeg");
        for (int i = 0; i < 1000; i++) {
            resultLog.info(DateUtils.currentTime());
        }
    }

}
