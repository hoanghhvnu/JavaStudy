package vn.com.datasection.word;

public class EnglishWordStatistic extends WordStatistic {

    @Override
    public String stemmerWord(String rawWord) {
        if (rawWord != null && ! rawWord.isEmpty()) {
            String word = rawWord;
            word = word.toLowerCase();
            word = word.replaceAll("[^a-z]", "");

            return word;
        }

        return null;
    }

}
