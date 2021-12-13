package maxIncreaseKeepingSkyline;

class Solution {
    public int maxIncreaseKeepingSkyline(int[][] grid) {
        int[] rowMax = new int[grid.length];
        int[] colMax = new int[grid[0].length];
        for (int i = 0;i < grid.length;i++) {
            int[] row = grid[i];
            int max = 0;
            for (int cell:row) {
                if (cell > max) {
                    max = cell;
                }
            }
            rowMax[i] = max;
        }
        for (int i = 0;i < grid[0].length;i++) {
            int max = 0;
            for (int j = 0;j < grid.length;j++) {
                int cell = grid[j][i];
                if (cell > max) {
                    max = cell;
                }
            }
            colMax[i] = max;
        }
        int ret = 0;
        for (int i = 0;i < grid.length;i++) {
            for (int j = 0;j < grid[0].length;j++) {
                int cell = grid[i][j];
                ret += Math.min(rowMax[i], colMax[j]) - cell;   
            }
        }
        return ret;
    }
}