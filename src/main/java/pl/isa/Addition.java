package pl.isa;

public class Addition {
    public static int add(int... values) {
        int result = 0;
        for (int value : values) {
            if (value > 0 && result + value < result) {
                throw new UnsupportedOperationException("Numbers exceed max");
            }
            if (value < 0 && result + value > result) {
                throw new UnsupportedOperationException("Numbers exceed MIN");

            }else result += value;
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(Addition.add(Integer.MIN_VALUE, -2));
    }

}