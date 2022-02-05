package getMaximumGold;

public class Solution {
    int m;
    int n;
    int[][] grid;
    boolean[][] visited;
    public int getMaximumGold(int[][] grid) {
        this.grid = grid;
        this.m = grid.length;
        this.n = grid[0].length;
        this.visited = new boolean[m][n];

        var ret = 0;
        for (var i = 0;i < m;i++) {
            for (var j = 0;j < n;j++) {
                var temp = dfs(i, j);
                if (temp > ret) {
                    ret = temp;
                }
            }
        }
        return ret;
    }

    int dfs(int i, int j) {
        if (i >= 0
            && i < grid.length
            && j >= 0
            && j < grid[0].length
            && !visited[i][j]
            && grid[i][j] != 0) {
                visited[i][j] = true;
                var max = 0;
                var options = new int[]{
                    dfs(i - 1, j),
                    dfs(i + 1, j),
                    dfs(i, j - 1),
                    dfs(i, j + 1)
                };
                for (var option:options) {
                    if (option > max) {
                        max = option;
                    }
                }
                visited[i][j] = false;
                return grid[i][j] + max;
        }
        return 0;
    }
}
