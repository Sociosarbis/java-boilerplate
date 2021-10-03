package fractionToDecimal;

import static org.junit.Assert.assertEquals;

import org.junit.Test;


class Suite {
    int numerator;
    int denominator;
    String ret;
    Suite(int numerator, int denominator, String ret) {
        this.numerator = numerator;
        this.denominator = denominator;
        this.ret = ret;
    }
}

public class Tests {
    @Test
    public void testResults() {
        Suite[] suites = new Suite[]{
            new Suite(1, 2,  "0.5"),
            new Suite(2, 1,  "2"),
            new Suite(2, 3,  "0.(6)"),
            new Suite(4, 333,  "0.(012)"),
            new Suite(1, 5,  "0.2"),
            new Suite(-50, 9, "-5.(5)"),
            new Suite(7, -12, "-0.58(3)"),
            new Suite(0, -5, "0"),
            new Suite(-1, -2147483648, "0.0000000004656612873077392578125"),
            new Suite(-2147483648, -1, "2147483648")
        };

        Solution s = new Solution();

        for (Suite su:suites) {
            assertEquals(su.ret, s.fractionToDecimal(su.numerator, su.denominator));
        }
    }
}
