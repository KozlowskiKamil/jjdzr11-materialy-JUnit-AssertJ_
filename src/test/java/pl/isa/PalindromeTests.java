package pl.isa;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.List;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.*;

public class PalindromeTests {

    private static Stream<Arguments> provideTextsWithPalindromes() {
        return Stream.of(
                Arguments.of("Ala ma kota", List.of("Ala")),
                Arguments.of("level kamil kamyk maddam", List.of("level", "maddam"))
        );
    }

    @ParameterizedTest
    @ValueSource(strings = {"", " ", "   ", "\n", "\t"})
    public void getPalindromes_emptyString_returnsEmptyList(String text) {
        assertThat(Palindrome.getPalindromes(text)).hasSize(0);
    }

    @ParameterizedTest
    @ValueSource(strings = {"anna", "level", "maddam", "kajak"})
    public void getPalindromes_singlePalindromeWord_returnsListWithTheSameWord(String text) {
        assertThat(Palindrome.getPalindromes(text))
                .hasSize(1)
                .contains(text);
    }

    @ParameterizedTest
    @ValueSource(strings = {"kot", "kamil", "ślimak"})
    public void getPalindromes_singleNotPalindromeWord_returnsEmptyList(String text) {
        assertThat(Palindrome.getPalindromes(text)).hasSize(0);
    }

    @ParameterizedTest
    @MethodSource("provideTextsWithPalindromes")
    public void getPalindromes_textWithPalindromes_returnsListOfPalindromes(String text, List<String> expectedPalindromes) {
        assertThat(Palindrome.getPalindromes(text))
                .hasSize(expectedPalindromes.size())
                .containsAll(expectedPalindromes);
    }
}
