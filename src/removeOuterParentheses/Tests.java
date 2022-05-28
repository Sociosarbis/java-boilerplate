package removeOuterParentheses;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

class Suite {
    String s;
    String ret;
    Suite(String s, String ret) {
        this.s = s;
        this.ret = ret;
    }
}

public class Tests {
    @Test
    public void testResults() {
        var suites = new Suite[]{
            new Suite("(()())(())", "()()()"),
            new Suite("(()())(())(()(()))", "()()()()(())"),
            new Suite("()()", "")
        };

        var s = new Solution();
        for (var su:suites) {
            assertEquals(su.ret, s.removeOuterParentheses(su.s));
        }
    }
}
