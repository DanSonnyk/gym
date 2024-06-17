package fundamentals.java.generics.animals;

public class Printer <T extends Animals>{
    T toPrint;

    public Printer(T i) {
        this.toPrint = i;
    }

    void print(){
        toPrint.eat();
    }
}
