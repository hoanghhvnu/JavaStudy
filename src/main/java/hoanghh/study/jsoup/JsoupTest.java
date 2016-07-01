package hoanghh.study.jsoup;

import java.io.File;
import java.io.IOException;
import java.nio.charset.Charset;

import org.jsoup.Connection.Response;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class JsoupTest {

    public static void main(String[] args) throws IOException {
//    	Response res = Jsoup.connect("https://developers.facebook.com/docs/graph-api/reference/page").followRedirects(true).userAgent("Mozilla/5.0 (Windows NT 6.1; WOW64) AppleWebKit/535.2 (KHTML, like Gecko) Chrome/15.0.874.120 Safari/535.2").execute();
//    	Document doc = res.parse();
        Document doc = Jsoup.parse(new File("/home/hoanghh/Documents/fbReference.html"), "UTF-8");
    	Elements elements = doc.select("table._4-ss > tbody tr > td > p > span > code");
    	for (Element el : elements) {
    	    System.out.println(el.text());
    	}
//    	System.out.println(res.);
//        Document doc = Jsoup.connect("http://www.baodongnai.com.vn/tintuc/201503/cum-thi-dua-so-15-thuc-hien-4-phong-trao-thi-dua-lon-trong-nam-2015-2373791/").get();
//        System.out.println(doc.html());
//        
//        Elements rows = doc.select(".detail > tbody:nth-child(1) > tr");
//        System.out.println(rows.first().cssSelector());
//    	Document doc = Jsoup.parse(new File("hoang.html"), "UTF8");
//    	System.out.println(doc.html());
//    	Elements els = doc.select("div divo");
//    	System.out.println(els.size());
//        companyTable.get(0).text()
//        for (Element row : rows) {
//            Elements title = row.select("th");
//            Elements content = row.select("td");
//            System.out.printf("%s\t%s\n", title.get(0).text(), content.get(0).text());
//            
//        } // end for
        
    }

}
