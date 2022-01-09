package slowestKey;

import static org.junit.Assert.assertEquals;

import org.junit.Test;


class Suite {
    int[] releaseTimes;
    String keysPressed;
    char ret;
    Suite(int[] releaseTimes, String keysPressed, char ret) {
        this.releaseTimes = releaseTimes;
        this.keysPressed = keysPressed;
        this.ret = ret;
    }
}

public class Tests {
    @Test
    public void testResults() {
        Suite[] suites = new Suite[]{
            new Suite(
                new int[]{9,29,49,50},
                "cbcd",
                'c'
            ),
            new Suite(
                new int[]{12,23,36,46,62},
                "spuda",
                'a'
            )
        };

        Solution s = new Solution();
        for (Suite su:suites) {
            assertEquals(su.ret, s.slowestKey(su.releaseTimes, su.keysPressed));
        }
    }
}
