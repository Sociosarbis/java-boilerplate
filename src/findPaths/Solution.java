package findPaths;

import java.util.ArrayList;
import java.util.List;
import java.util.Arrays;

class Solution {
    public int findPaths(int m, int n, int maxMove, int startRow, int startColumn) {
        int[][] dp = new int[m][n];
        int[][] dirs = { { 0, -1 }, { 1,0 }, { 0, 1 }, { -1, 0 }};
        int ret = 0;
        List<List<Integer>> queue = new ArrayList<>();
        queue.add(Arrays.asList(startRow, startColumn));
        dp[startRow][startColumn] = 1;
        for (int i = 0;i < maxMove;i++) {
            int[][] nextDp = new int[m][n];
            List<List<Integer>> nextQueue = new ArrayList<>();
            for (List<Integer> item:queue) {
                int x = item.get(0);
                int y = item.get(1);
                int prevCount = dp[x][y];
                for (int[] dir:dirs) {
                    int nextX = x + dir[0];
                    int nextY = y + dir[1];
                    if (nextX < 0 || nextX >= m || nextY < 0 || nextY >= n) {
                        ret = (ret + prevCount) % 1000000007;
                    } else {
                        int count = nextDp[nextX][nextY];
                        if (count == 0) {
                            nextQueue.add(Arrays.asList(nextX, nextY));
                        }
                        nextDp[nextX][nextY] = (prevCount + count) % 1000000007;
                    }
                }
            }
            queue = nextQueue;
            dp = nextDp;
        }
        return ret;
    }
}

