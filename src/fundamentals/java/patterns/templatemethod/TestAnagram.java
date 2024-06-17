package fundamentals.java.patterns.templatemethod;
import java.util.*;

public class TestAnagram {

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
                String validWord = validateWord(word);
                String sortedWord = sortWord(validWord);
                //find anagrams
                List<String> groups = anagrams.computeIfAbsent(sortedWord, X -> new ArrayList<>());
                groups.add(validWord);
            }
        }

        //Build response list
        List<String> pairs = new ArrayList<>();
        for(List<String> group : anagrams.values()){
            if (group.size() > 1){
                pairs.addAll(group);
            }
        }

        //order desc alpha
        Collections.sort(pairs, Collections.reverseOrder());
        return pairs;
    }

    public static String sortWord(String word){
        char[] chars = word.toCharArray();
        Arrays.sort(chars);
        return new String(chars);
    }

    public static String validateWord(String word){
        return word.replaceAll("[^\\p{L}]", "").toLowerCase();
    }

}
