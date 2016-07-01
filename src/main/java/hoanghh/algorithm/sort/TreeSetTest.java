package hoanghh.algorithm.sort;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import java.util.TreeSet;

import org.slf4j.*;

import facebook4j.internal.org.json.JSONException;
import facebook4j.internal.org.json.JSONObject;

public class TreeSetTest {
    public static Logger logger = LoggerFactory.getLogger(TreeSetTest.class);
    
    public static void main(String[] args) {
//        Map<String, String> userMap = new TreeMap<>();
        
//        Set<String> userSet = new TreeSet<>();
        List<String> list = new ArrayList<>();
        logger.info("Start read file");
        try (BufferedReader br = new BufferedReader(new FileReader(args[0]))) {
            String line;
            int counter = 0;
            while ((line = br.readLine()) != null) {
                try {
                    JSONObject jsonUser = new JSONObject(line);
                    String id = jsonUser.getString("id");
//                    userMap.put(id, line);
//                    userSet.add(id);
                    list.add(id);
                } catch (JSONException e) {
                    // log.error("unknown exception", e);
                    e.printStackTrace();
                }
                counter ++;
                if (counter % 100000 == 0) {
                    logger.info("Read Index: " + counter);
                }
//                if (counter == 10) {
//                    break;
//                }
            }
            
            

        } catch (IOException e) {
            e.printStackTrace();
        }
        
        
        logger.info("Finish read file");
        logger.info("Start sort");
        Collections.sort(list);
        logger.info("End sort");
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(args[1]))) {
            int counter = 0;
            Iterator<String> itor = list.iterator();
            while (itor.hasNext()) {
                bw.write(String.valueOf(itor.next()));
              counter ++;
              if (counter % 100000 == 0) {
                  logger.info("Write Index: " + counter);
              }
            }
//            for (Map.Entry<String, String> entry : userMap.entrySet()) {
//                bw.write(entry.getKey() + "\t" +  entry.getValue() + "\n");

////                if (counter == 10) {
////                    break;
////                }
//            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        logger.info("Finish write file");
    }

}
