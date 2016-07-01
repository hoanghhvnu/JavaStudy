package vn.com.datasection.word;

public class VietnameseWordStatistic extends WordStatistic {

    @Override
    public String stemmerWord(String rawWord) {
        String word = rawWord;
        word = word.toLowerCase();
        word = word.replaceAll("[^a-zúùủũụứừửữựưéèẻẽẹếềểễệêóòỏõọớờởỡợơốồổỗộôáàảãạấầẩẫậâắằẳẵặăíìỉĩịýỳỷỹỵđ]", "");

        return word;
    }
    

}
