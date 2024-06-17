package fundamentals.java.generics.animals;

import java.util.ArrayList;
import java.util.List;

public class ExecuteGenericQuestionMark {
    public static void main(String[] args) {

        List<Cat> cats = new ArrayList<>();
        cats.add(new Cat());
        printList(cats);
    }

    private static void printList(List<?> myList){
        System.out.println(myList);
    }
}
