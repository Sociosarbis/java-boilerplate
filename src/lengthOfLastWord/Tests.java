package lengthOfLastWord;

import static org.junit.Assert.assertEquals;

import org.junit.Test; 

class Suite {
    String s;
    int ret;
    Suite(String s, int ret) {
        this.s = s;
        this.ret = ret;
    }
}

public class Tests {
    @Test
    public void testResults() {
        Suite[] suites = new Suite[]{
            new Suite("Hello World", 5),
            new Suite("   fly me   to   the moon  ", 4),
            new Suite("luffy is still joyboy", 6),
        };

        Solution s = new Solution();
        for (Suite su:suites) {
            assertEquals(su.ret, s.lengthOfLastWord(su.s));
        }
    }
}
