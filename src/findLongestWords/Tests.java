package findLongestWords;

import java.util.List;
import org.junit.Test;
import static org.junit.Assert.assertEquals;

class Suite {
    String s;
    List<String> dictionary;
    String ret;
    Suite(String s, List<String> dictionary, String ret) {
        this.s = s;
        this.dictionary = dictionary;
        this.ret = ret;
    }
}

public class Tests {
    @Test
    public void testResults() {
        Suite suites[] = {
            new Suite("abpcplea", List.of("ale","apple","monkey","plea"), "apple"),
            new Suite("abpcplea", List.of("a","b","c"), "a"),
        };

        Solution s = new Solution();
        for (Suite su:suites) {
            assertEquals(su.ret, s.findLongestWord(su.s, su.dictionary));
        }
    }
}
