package detectCapitalUse;

import static org.junit.Assert.assertEquals;

import org.junit.Test;


class Suite {
    String word;
    Boolean ret;
    Suite(String word, Boolean ret) {
        this.word = word;
        this.ret = ret;
    }
}

public class Tests {
    @Test
    public void testResults() {
        Suite[] suites = new Suite[]{
            new Suite("USA", true),
            new Suite("FlaG", false)
        };

        Solution s = new Solution();
        for (Suite su:suites) {
            assertEquals(su.ret, s.detectCapitalUse(su.word));
        }
    }
}
