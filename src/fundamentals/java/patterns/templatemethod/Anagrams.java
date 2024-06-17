package fundamentals.java.patterns.templatemethod;

import java.util.*;

public class Anagrams {

    public static void main(String[] args) {
        String phrase = "Words are a sword in our era.";
        List<String> anagrams = getAnagrams(phrase);

        anagrams.forEach(System.out::println);
    }

    public static List<String> getAnagrams(String text) {
        //build a list with split by space, ignore special chars, ignore single letters
        String [] words = text.split("\\s+");
        Map<String, List<String>> anagrams = new HashMap<>();

        for(String word : words){
              if(word.length()>1){
                String validateWord = cleanWord(word);
                String sortedWord = sortWord(validateWord);
                //find anagrams
                 anagrams.computeIfAbsent(sortedWord, k -> new ArrayList<>()).add(validateWord);
              }
        }

        //Build response list
        List<String> result = new ArrayList<>();
        for (List<String> group : anagrams.values()) {
            if (group.size() > 1) {
                result.addAll(group);
            }
        }

        //order desc alpha
        result.sort(Collections.reverseOrder());
        return result;
    }

    public static String sortWord(final String word){
        char[] chars = word.toCharArray();
        Arrays.sort(chars);
        return new String(chars);
    }

    private static String cleanWord(String word) {
        // Remove non-alphabetical characters and convert to lowercase
        return word.replaceAll("[^\\p{L}]", "").toLowerCase();
    }

}
