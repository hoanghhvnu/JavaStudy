package vn.com.datasection.word;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public abstract class WordStatistic {
    private Map<String, Integer> wordMap;

    public WordStatistic() {
        this.wordMap = new HashMap<>();
    }

    /**
     * Add word to map
     * @param word
     * @return true if word valid to add (not empty), false otherwise
     */
    public boolean add(final String word) {
        String cleanWord = stemmerWord(word);
        if (cleanWord != null && !cleanWord.isEmpty()) {
            if (!this.wordMap.containsKey(cleanWord)) {
                this.wordMap.put(cleanWord, 1);
            } else {
                this.wordMap.put(cleanWord, this.wordMap.get(cleanWord) + 1);
            }

            return true;
        }

        return false;
    } // end add method

    public Map<String, Integer> getWordMap() {
        return this.wordMap;
    }

    public void writeToFile(final String path) {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(path));) {
            for (Map.Entry<String, Integer> entry : this.wordMap.entrySet()) {
                bw.write(entry.getKey() + "\t" + entry.getValue() + "\n");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public abstract String stemmerWord(final String rawWord);
}
