package pl.isa;

public class Addition {
    public static int add(int... values) {
        int result = 0;
        for (int value : values) {
            if (value > 0 && result + value < result) {
                throw new UnsupportedOperationException("Numbers exceed max value");
            }
            if (value < 0 && result + value > result) {
                throw new UnsupportedOperationException("Numbers exceed min value");
            }
            result += value;
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(Addition.add());
    }
}
