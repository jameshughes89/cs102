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


    public static HuffmanCode fromString(String seed) {

        return null;
    }
    public static HuffmanCode fromFile(String seedFile) {
        try {
            return HuffmanCode.fromString(Files.readString(Paths.get(seedFile)));
        } catch (IOException e) {
            throw new UncheckedIOException(e);
        }
    }

    /**
     * Encode a given string based on the Huffman tree
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