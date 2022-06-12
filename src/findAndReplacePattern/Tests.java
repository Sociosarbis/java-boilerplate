package findAndReplacePattern;

import org.junit.Test;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;

import java.util.List;

class Suite {
    String[] words;
    String pattern;
    List<String> ret;

    Suite(String[] words, String pattern, List<String> ret) {
        this.words = words;
        this.pattern = pattern;
        this.ret = ret;
    }
}

public class Tests {
    @Test
    public void testResults() {
        var suites = new Suite[] {
            new Suite(new String[] { "abc", "deq", "mee", "aqq", "dkd", "ccc" }, "abb", List.of("mee", "aqq")),
            new Suite(new String[] { "a", "b", "c" }, "a", List.of("a", "b", "c")),
        };

        var s = new Solution();
        for (var su:suites) {
            assertEquals(su.ret, s.findAndReplacePattern(su.words, su.pattern));
        }

    }
}
