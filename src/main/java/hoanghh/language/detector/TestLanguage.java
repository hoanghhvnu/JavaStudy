package hoanghh.language.detector;

import java.io.IOException;
import java.util.List;

import vn.com.datasection.file.FileUtils;

import com.google.common.base.Optional;
import com.optimaize.langdetect.LanguageDetector;
import com.optimaize.langdetect.LanguageDetectorBuilder;
import com.optimaize.langdetect.i18n.LdLocale;
import com.optimaize.langdetect.ngram.NgramExtractors;
import com.optimaize.langdetect.profiles.LanguageProfile;
import com.optimaize.langdetect.profiles.LanguageProfileReader;
import com.optimaize.langdetect.text.CommonTextObjectFactories;
import com.optimaize.langdetect.text.TextObject;
import com.optimaize.langdetect.text.TextObjectFactory;

public class TestLanguage {

    public static void main(String[] args) {
        // load all languages:
        List<LanguageProfile> languageProfiles;
        try {
            languageProfiles = new LanguageProfileReader().readAll();
            // build language detector:
            LanguageDetector languageDetector = LanguageDetectorBuilder.create(NgramExtractors.standard())
                    .withProfiles(languageProfiles)
                    .build();

            // create a text object factory
            TextObjectFactory textObjectFactory = CommonTextObjectFactories.forDetectingOnLargeText();

            // query:
            for (String line : FileUtils.getContent("/workspace/facebookcrawler/live-fanpage.txt")) {
                String name = line.split("\t")[2];
                TextObject textObject = textObjectFactory
                        .forText(name);
                Optional<LdLocale> lang = languageDetector.detect(textObject);
                try {
                    String langStr = lang.get().getLanguage();
                    FileUtils.append(line + "\t" + langStr, "output/fanpage-lang.txt");
                } catch (IllegalStateException e) {
                    FileUtils.append(line + "\t" + "FAIL", "output/fanpage-lang.txt");
                    e.printStackTrace();
                }

            }

            // System.out.println(textObject);

        } catch (IOException e) {
            // log.error("unknown exception", e);
            e.printStackTrace();
        }

    }

}
