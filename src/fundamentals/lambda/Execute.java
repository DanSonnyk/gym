package fundamentals.lambda;

public class Execute {
    //Basics Lambda its pass the implementation of interface contract directly
    public static void main(String[] args) {
//        Cat brow = new Cat();
//        brow.print();

        Felines lambdaExec = (a, s) -> a+s;
        printSomething(lambdaExec);
    }

    public static void printSomething(Felines felines){
        System.out.println(felines.print("Cat ! ", " Meal"));
    }
}
