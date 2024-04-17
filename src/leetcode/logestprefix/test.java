package leetcode.logestprefix;

public class test {
    public static void main(String[] args) {
        String s = "He is a very very good boy, isn't he?";
        String[] splited = s.split("[^a-zA-Z]+");

        for (String st : splited){
            System.out.println(st);
        }
    }
}
