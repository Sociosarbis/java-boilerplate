package addOperators;

import org.junit.Test;
import java.util.List;
import static org.junit.Assert.assertEquals;

class Suite {
    String num;
    int target;
    List<String> ret;
    Suite (String num, int target, List<String> ret) {
        this.num = num;
        this.target = target;
        this.ret = ret;
    }
}

public class Tests {
    @Test
    public void testResults() {
        Suite[] suites = new Suite[]{
            new Suite(
                "123",
                6,
                List.of("1*2*3","1+2+3")
            ),
            new Suite(
                "232",
                8,
                List.of("2*3+2","2+3*2")
            ),
            new Suite(
                "105",
                5,
                List.of("1*0+5","10-5")
            )
        };

        Solution s = new Solution();
        for (Suite su:suites) {
            assertEquals(su.ret, s.addOperators(su.num, su.target));
        }
    }
}
