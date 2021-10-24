package shoppingOffers;

import static org.junit.Assert.assertEquals;

import java.util.List;
import org.junit.Test;

class Suite {
    List<Integer> price;
    List<List<Integer>> special;
    List<Integer> needs;
    int ret;

    Suite(List<Integer> price, List<List<Integer>> special, List<Integer> needs, int ret) {
        this.price = price;
        this.special = special;
        this.needs = needs;
        this.ret = ret;
    }
}

public class Tests {
    @Test
    public void testResults() {
        Suite[] suites = new Suite[] {
            new Suite(List.of(2, 5), List.of(List.of(3, 0, 5), List.of(1, 2, 10)), List.of(3, 2), 14),
            new Suite(List.of(2, 3, 4), List.of(List.of(1, 1, 0, 4), List.of(2, 2, 1, 9)), List.of(1, 2, 1), 11)
        };
        Solution s = new Solution();
        for (Suite su:suites) {
            assertEquals(su.ret, s.shoppingOffers(su.price, su.special, su.needs));
        }
        
    }
}
