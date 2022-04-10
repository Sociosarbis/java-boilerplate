package uniqueMorseRepresentations;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

class Suite {
    String[] words;
    int ret;
    Suite(String[] words, int ret) {
        this.words = words;
        this.ret = ret;
    }
}

public class Tests {
    @Test
    public void testResults() {
        var suites = new Suite[]{
            new Suite(new String[]{"gin","zen","gig","msg"}, 2),
            new Suite(new String[]{"a"}, 1),
        };

        var s = new Solution();
        for (var su:suites) {
            assertEquals(su.ret, s.uniqueMorseRepresentations(su.words));
        }
    }
}
