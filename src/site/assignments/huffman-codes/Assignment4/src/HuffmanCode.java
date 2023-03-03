import java.io.IOException;
import java.io.UncheckedIOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

import static java.util.function.UnaryOperator.identity;
import static java.util.stream.Collectors.*;

public class HuffmanCode {

    /**
     * Generate the Huffman tree that can be used for encoding a String. The Huffman Tree is generated based on some
     * seed string. Ideally this string is large enough and real-ish enough to represent a good encoding for a given
     * message.
     *
     * @param seed Some seed string to use for generating the Huffman Tree
     * @return A HuffmanNode that is the root of the Huffman Tree
     */
    public static HuffmanCode fromString(String seed) {

        return null;
    }

    /**
     * Create a HuffmanCompression from a string within a text file.
     *
     * @param seedFile Filename of seed to load
     * @return A new HuffmanCompression object based on the seed file
     * @throws UncheckedIOException Any general UncheckedIOException
     */
    public static HuffmanCode fromFile(String seedFile) {
        try {
            return HuffmanCode.fromString(Files.readString(Paths.get(seedFile)));
        } catch (IOException e) {
            throw new UncheckedIOException(e);
        }
    }

    /**
     * Encode a given string based on the Huffman tree.
     *
     * @param string String to be encoded
     * @return Bitstring representing the encoded string
     */
    public String encode(String string) {
        return null;
    }

    public String decode(String bits) {
        return null;
    }
}