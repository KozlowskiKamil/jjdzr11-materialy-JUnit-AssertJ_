package pl.isa;

import java.math.BigInteger;

public class Fibonacci {
    public static BigInteger getElement(int element) {
        if (element == 0) {
            return BigInteger.ZERO;
        }
        if (element == 1) {
            return BigInteger.ONE;
        }
        if (element < 0 || element > 100) {
            throw new IllegalArgumentException("element should be in 0-100 range");
        }

        BigInteger previous = BigInteger.ZERO;
        BigInteger current = BigInteger.ONE;
        BigInteger temp;

        for (int i = 2; i <= element; i++) {
            temp = previous.add(current);
            previous = current;
            current = temp;
        }

        return current;
    }
}
