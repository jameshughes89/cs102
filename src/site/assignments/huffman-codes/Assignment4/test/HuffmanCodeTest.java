import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Map;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class HuffmanCodeTest {

    static final Map<String, String> SIMPLE_PREFIX = Map.ofEntries(Map.entry("a", "1"),
            Map.entry("b", "01"),
            Map.entry("c", "00"));
    // Took example from https://en.wikipedia.org/wiki/Huffman_coding
    // Still needed tinkering with prefix values as the order of things
    // with same priority was different.
    private static final String WIKI_SEED = "this is an example of a huffman tree";
    private static final String WIKI_ENCODED = "100101100111100011101111000111000010111100110111000010010100110000011111100111011110001110110101101101110101000000101111100110101001001";
    private static final Map<String, String> WIKI_PREFIX = Map.ofEntries(Map.entry(" ", "111"),
            Map.entry("a", "000"),
            Map.entry("e", "001"),
            Map.entry("f", "1101"),
            Map.entry("h", "0110"),
            Map.entry("i", "0111"),
            Map.entry("m", "0100"),
            Map.entry("n", "0101"),
            Map.entry("s", "1000"),
            Map.entry("t", "1001"),
            Map.entry("l", "11000"),
            Map.entry("o", "11001"),
            Map.entry("p", "10100"),
            Map.entry("r", "10101"),
            Map.entry("u", "10110"),
            Map.entry("x", "10111"));
    /*
         Should produce this tree
                o
               / \
              o   a
             / \
            c   b
     */
    private static final String SIMPLE_SEED = "aaaabbc";
    private static final String SIMPLE_MESSAGE = "abccba";
    private static final String SIMPLE_ENCODED = "1010000011";

    private HuffmanCode classUnderTest;

    @Test
    void fromString_emptyString_throwsIllegalArgumentException() {

    }

    @Nested
    class SimpleString {

        static Stream<String> sourceKeysSimple() {
            return SIMPLE_PREFIX.keySet().stream();
        }

        @BeforeEach
        void create_HuffmanCode() {
            classUnderTest = HuffmanCode.fromString(SIMPLE_SEED);
        }

        @ParameterizedTest
        @MethodSource("sourceKeysSimple")
        void encode_specificLetter_returnsLetterCode(String letter) {

        }

        @Test
        void encode_exampleString_returnsEncodedString() {

        }

        @Test
        void decode_encodedString_returnsOriginalString() {

        }

    }

    @Nested
    class WikiString {

        static Stream<String> sourceKeysWiki() {
            return WIKI_PREFIX.keySet().stream();
        }

        @BeforeEach
        void create_HuffmanCode() {
            classUnderTest = HuffmanCode.fromString(WIKI_SEED);
        }

        @ParameterizedTest
        @MethodSource("sourceKeysWiki")
        void encode_specificLetter_returnsLetterCode(String letter) {

        }

        @Test
        void encode_exampleString_returnsEncodedString() {

        }


        @Test
        void fromFile_encoding_sameAsFromStringEncoding() {

        }
    }
}