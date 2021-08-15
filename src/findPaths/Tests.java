package findPaths;

import static org.junit.Assert.assertEquals;
import org.junit.Test;

class Suite {
    int m;
    int n;
    int maxMove;
    int startRow;
    int startColumn;
    int ret;
    Suite(int m, int n, int maxMove, int startRow, int startColumn, int ret) {
        this.m = m;
        this.n = n;
        this.maxMove = maxMove;
        this.startRow = startRow;
        this.startColumn = startColumn;
        this.ret = ret;
    }
}

public class Tests {
    @Test
    public void testResults() {
        Suite[] suites = new Suite[]{
            new Suite(2,2,2,0,0,6),
            new Suite(1,3,3,0,1,12),
            new Suite(50,50,50,0,0,678188903)
        };

        Solution s = new Solution();
        for (Suite su:suites) {
            assertEquals(su.ret, s.findPaths(su.m, su.n, su.maxMove, su.startRow, su.startColumn));
        }
    } 
}
