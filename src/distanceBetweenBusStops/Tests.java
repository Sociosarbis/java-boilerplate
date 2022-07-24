package distanceBetweenBusStops;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

class Suite {
    int[] distance;
    int start;
    int destination;
    int ret;
    Suite(int[] distance, int start, int destination, int ret) {
        this.distance = distance;
        this.start = start;
        this.destination = destination;
        this.ret = ret;
    }
}

public class Tests {
    @Test
    public void testResults() {
        var suites = new Suite[]{
            new Suite(
                new int[]{1,2,3,4},
                0,
                1,
                1
            ),
            new Suite(
                new int[]{1,2,3,4},
                0,
                2,
                3
            ),
            new Suite(
                new int[]{1,2,3,4},
                0,
                3,
                4
            )
        };

        Solution s = new Solution();
        for (var su:suites) {
            assertEquals(su.ret, s.distanceBetweenBusStops(su.distance, su.start, su.destination));
        }
    }
}
