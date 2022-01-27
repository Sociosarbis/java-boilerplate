package countValidWords;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

class Suite {
    String sentence;
    int ret;
    Suite(String sentence, int ret) {
        this.sentence = sentence;
        this.ret = ret;
    }
}

public class Tests {
    @Test
    public void testResults() {
        Suite[] suites = new Suite[]{
            new Suite("cat and  dog", 3),
            new Suite("!this  1-s b8d!", 0),
            new Suite("alice and  bob are playing stone-game10", 5)
        };

        Solution s = new Solution();
        for (Suite su:suites) {
            assertEquals(su.ret, s.countValidWords(su.sentence));
        }
    }    
}
