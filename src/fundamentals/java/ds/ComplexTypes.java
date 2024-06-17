package fundamentals.java.ds;

import java.math.BigDecimal;
import java.math.BigInteger;

public class ComplexTypes {
    public static void main(String[] args) {
        //Represents a sequence of characters, commonly used for text manipulation and storage.
        String message = "Hello, world!";
        message.strip();

        //Represents an arbitrary-precision decimal number, useful for accurate financial calculations where precision is important.
        BigDecimal amount = new BigDecimal("100.50");

        //Represents an arbitrary-precision integer, useful for calculations involving very large integers.
        BigInteger bigNumber = new BigInteger("12345678901234567890");

        //Represents a 32-bit signed integer, widely used for most integer values.
        Integer quantity = 10;

        //Represents a 64-bit signed integer, typically used for large integer values or when more precision is needed.
        Long population = 1000000000L;

        //Represents a double-precision 64-bit floating point, commonly used for most floating-point calculations.
        Double piValue = 3.141592653589793;

        //Represents a single-precision 32-bit floating point, used for decimal values requiring less precision.
        Float temperature = 25.5f;

        //Represents a boolean value (true or false), used for logical operations and conditions.
        Boolean isRaining = true;
    }
}
