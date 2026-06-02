package summary;

import java.util.*;

public class KeywordExtractor {

    public static List<String>
    extractKeywords(String text) {

        String[] words =
                text.split("\\s+");

        Set<String> keywords =
                new HashSet<>();

        for (String word : words) {

            word = word.toLowerCase()
                    .replaceAll("[^a-zA-Z]", "");

            if (word.length() > 5) {

                keywords.add(word);
            }
        }

        return new ArrayList<>(keywords);
    }
}