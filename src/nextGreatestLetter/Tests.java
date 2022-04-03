package nextGreatestLetter;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

class Suite {
    char[] letters;
    char target;
    char ret;
    Suite(char[] letters, char target, char ret) {
        this.letters = letters;
        this.target = target;
        this.ret = ret;
    }
}

public class Tests {
    @Test
    public void testResults() {
        var suites = new Suite[]{
            new Suite(new char[]{'c', 'f', 'j'}, 'a', 'c'),
            new Suite(new char[]{'c', 'f', 'j'}, 'a', 'c'),
            new Suite(new char[]{'c', 'f', 'j'}, 'd', 'f'),
        };

        var s = new Solution();
        
        for (var su:suites) {
            assertEquals(su.ret, s.nextGreatestLetter(su.letters, su.target));
        }
    }
}
