package numUniqueEmails;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

class Suite {
    String[] emails;
    int ret;
    Suite(String[] emails, int ret) {
        this.emails = emails;
        this.ret = ret;
    }
}

public class Tests {
    @Test
    public void testResults() {
        var suites = new Suite[]{
            new Suite(new String[]{
                "test.email+alex@leetcode.com",
                "test.e.mail+bob.cathy@leetcode.com",
                "testemail+david@lee.tcode.com"
            }, 2),
            new Suite(new String[]{
                "a@leetcode.com","b@leetcode.com","c@leetcode.com"
            }, 3)
        };

        var s = new Solution();
        for (var su:suites) {
            assertEquals(su.ret, s.numUniqueEmails(su.emails));
        }
    }
}
