package pl.isa;

import java.math.BigInteger;

public class Fibonacci {
    public static void main(String[] args) {
        System.out.println(getFibonacci(999));
    }


    public static BigInteger getFibonacci(int value) {
        BigInteger previous = BigInteger.ZERO;
        BigInteger current = BigInteger.ONE;
        BigInteger tmp;
        if (value < 0){
            throw new IllegalArgumentException("Wrong number");
        }
        if (value == 0) {
            return previous;
        }if (value == 1){
            return current;
        } else {
            for (int i = 2; i <= value; i++ ) {
                tmp = previous.add(current);
                previous = current;
                current = tmp;
            }
        }
        return current;
    }
}
