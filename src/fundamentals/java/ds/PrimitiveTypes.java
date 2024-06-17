package fundamentals.java.ds;

public class PrimitiveTypes {
    public static void main(String[] args) {
        //Used to store small integer values ranging from -128 to 127. A real-world use case could be storing the age of a person, as age values typically fall within this range.
        byte age = 127;

        //Used to store small integer values ranging from -32,768 to 32,767. A real-world use case could be storing the number of students enrolled in a small class, as class sizes are often within this range.
        short athletes = 32767;

        //Used to store integer values ranging from -2^31 to 2^31 - 1. A real-world use case could be storing the quantity of items in an inventory, as inventory quantities are typically represented by whole numbers.
        int productQuantity = 999999999;

        //Used to store large integer values ranging from -2^63 to 2^63 - 1. A real-world use case could be storing timestamps representing dates far in the past or future, as timestamps require a wide range to accommodate various time intervals.
        long myLong = 1618922400000L;

        //Used to store single-precision floating-point numbers, providing approximately 6-7 significant decimal digits of precision. A real-world use case could be representing temperatures in Celsius or Fahrenheit, as temperature values can be accurately represented with single-precision floating-point numbers.
        float temperature = 9.12f;

        //Used to store double-precision floating-point numbers, providing approximately 15-16 significant decimal digits of precision. A real-world use case could be representing financial values such as currency amounts or stock prices, as financial calculations often require high precision.
        double budget = 11497321.12;

        //Used to store boolean values representing true or false. A real-world use case could be storing the state of a light switch, where true represents the switch being turned on and false represents the switch being turned off.
        boolean isTrue = false;

        //Used to store a single Unicode character. A real-world use case could be storing the gender of a person, where 'M' represents male and 'F' represents female.
        char gender = 'M';
    }


}
