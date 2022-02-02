package reversePrefix;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

class Suite {
    String word;
    char ch;
    String ret;
    Suite(String word, char ch, String ret) {
        this.word = word;
        this.ch = ch;
        this.ret = ret;
    }
}

public class Tests {
    @Test
    public void testResults() {
        var suites = new Suite[]{
            new Suite("abcdefd", 'd', "dcbaefd"),
            new Suite("xyxzxe", 'z', "zxyxxe"),
            new Suite("abcd", 'z', "abcd")
        };


        Solution s = new Solution();
        for (var su:suites) {
            assertEquals(su.ret, s.reversePrefix(su.word, su.ch));
        }
    }
}
