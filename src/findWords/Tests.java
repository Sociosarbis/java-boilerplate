package findWords;

import static org.junit.Assert.assertArrayEquals;

import org.junit.Test;

class Suite {
    String[] words;
    String[] ret;
    Suite(String[] words, String[] ret) {
        this.words = words;
        this.ret = ret;
    }
}

public class Tests {
    @Test
    public void testResults() {
        Suite[] suites = new Suite[]{
            new Suite(new String[]{"Hello","Alaska","Dad","Peace"}, new String[]{"Alaska","Dad"}),
            new Suite(new String[]{"omk"}, new String[]{}),
            new Suite(new String[]{"adsdf","sfd"}, new String[]{"adsdf","sfd"}),
        };

        Solution s = new Solution();
        for (Suite su:suites) {
            assertArrayEquals(su.ret, s.findWords(su.words));
        }
    }
}
