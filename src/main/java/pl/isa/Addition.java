package pl.isa;

public class Addition {
    public static int add(int... values) {
        int result = 0;
        for (int value : values) {
            result += value;
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(Addition.add(2, 2));
    }
}
