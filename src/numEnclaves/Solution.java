package numEnclaves;

public class Solution {
    int[][] grid;
    public int numEnclaves(int[][] grid) {
        this.grid = grid;
        var ret = 0;
        for (var i = 0;i < grid.length;i++) {
            for (var j = 0;j < grid[0].length;j++) {
                var temp = dfs(i, j);
                if (temp > 0) {
                    ret += temp;
                }
            }
        }
        return ret;
    }

    int dfs(int i, int j) {
        if (i < 0 || i >= grid.length || j < 0 || j >= grid[0].length) {
            return -1;
        }
        if (grid[i][j] != 1) {
            return 0;
        }
        grid[i][j] = 2;
        var ret1 = dfs(i - 1, j);
        var ret2 = dfs(i + 1, j);
        var ret3 = dfs(i, j - 1);
        var ret4 = dfs(i, j + 1);
        if (ret1 == -1 || ret2 == -1 || ret3 == -1 || ret4 == -1) {
            return -1;
        }
        return 1 + ret1 + ret2 + ret3 + ret4;
    }
}
