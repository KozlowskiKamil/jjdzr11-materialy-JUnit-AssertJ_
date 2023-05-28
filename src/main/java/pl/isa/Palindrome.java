package pl.isa;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Palindrome {
    public static List<String> getPalindromes(String text) {
        if (text.isBlank()) {
            return new ArrayList<>();
        }

        List<String> palindromes = new ArrayList<>();
        Arrays.stream(text.split(" ")).forEach(word -> {
                    StringBuilder reversed = new StringBuilder(word.toLowerCase());
                    if (word.equalsIgnoreCase(reversed.reverse().toString())) {
                        palindromes.add(word);
                    }
                }
        );

        return palindromes;
    }
}
