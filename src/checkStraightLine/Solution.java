package checkStraightLine;

public class Solution {
  /** 叉乘判断直线 */
  public boolean checkStraightLine(int[][] coordinates) {
    if (coordinates.length == 2) return true;
    int[] origin = coordinates[0];
    int[] v1 = { coordinates[1][0] - origin[0], coordinates[1][1] - origin[1] };
    for (int i = 2;i < coordinates.length;i++) {
      int[] v2 = { coordinates[i][0] - origin[0], coordinates[i][1] - origin[1] };
      if (v1[0] * v2[1] - v1[1] * v2[0] != 0) {
        return false;
      }
    }
    return true;
  }
}
