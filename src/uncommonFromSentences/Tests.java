package uncommonFromSentences;

import static org.junit.Assert.assertArrayEquals;

import org.junit.Test;

class Suite {
    String s1;
    String s2;
    String[] ret;
    Suite(String s1, String s2, String[] ret) {
        this.s1 = s1;
        this.s2 = s2;
        this.ret = ret;
    }
}

public class Tests {
    @Test
    public void testResults() {
        var suites = new Suite[]{
            new Suite("this apple is sweet", "this apple is sour", new String[]{"sweet","sour"}),
            new Suite("apple apple", "banana", new String[]{"banana"}),
        };

        var s = new Solution();
        for (var su: suites) {
            assertArrayEquals(su.ret, s.uncommonFromSentences(su.s1, su.s2));
        }
    }    
}
