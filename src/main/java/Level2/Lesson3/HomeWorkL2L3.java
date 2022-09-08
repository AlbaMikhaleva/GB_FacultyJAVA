package Level2.Lesson3;


import java.util.*;

public class HomeWorkL2L3 {

    public static void main(String[] args) {
        List<String> words = new ArrayList<>();
        words.add("cat");
        words.add("duck");
        words.add("mouse");
        words.add("cat");
        words.add("monkey");
        words.add("duck");
        words.add("bear");
        words.add("duck");
        words.add("tiger");
        words.add("duck");
        words.add("mouse");
        words.add("duck");
        words.add("dog");
        words.add("lion");
        words.add("cat");

        listUniqueWords(words);

    }

    private static void listUniqueWords(List<String> words) {

        Set <String> uniqueWords = new HashSet<>(words);

        System.out.println("Список уникальных слов: " + uniqueWords);

        countWords(words, uniqueWords);

    }

    private static void countWords(List<String> words, Set<String> uniqueWords) {

        Iterator<String> itr = uniqueWords.iterator();
        int[] sum = new int[uniqueWords.size()];

        for (int i = 0; i < uniqueWords.size(); i++) {
            String wrd = itr.next();
            for (String word : words) {
                if (wrd.equals(word)) {
                    sum[i] += 1;
                }
            }
            System.out.printf("Слово %s встречается %d раз(а).", wrd, sum[i]);
            System.out.println();
        }

    }


}
