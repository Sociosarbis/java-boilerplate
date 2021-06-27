package snakesAndLadders;

import java.util.List;
import java.util.ArrayList;

public class Solution {
  public int snakesAndLadders(int[][] board) {
    int m = board.length;
    int target = m * m;
    boolean[] visited = new boolean[target];
    visited[0] = true;
    List<Integer> queue = new ArrayList<>();
    queue.add(1);
    int step = 0;
    while (!queue.isEmpty()) {
      step++;
      int l = queue.size();
      for (int i = 0;i < l;i++) {
        int num = queue.get(i);
        int[] pos = numToPos(num, m);
        for (int j = 1;j < 7;j++) {
          int nextNum = num + j;
          if (nextNum <= target) {
            if (nextNum == target) return step;
            pos = numToPos(nextNum, m);
            if (board[pos[0]][pos[1]] != -1) {
              nextNum = board[pos[0]][pos[1]];
              if (nextNum == target) return step;
            }
            if (!visited[nextNum - 1]) {
              visited[nextNum - 1] = true;
              queue.add(nextNum);
            }
          }
        }
      }
      queue.subList(0, l).clear();
    }
    return -1;
  }

  int[] numToPos(int num, int m) {
    int l = (num - 1) / m;
    int i = m - 1 - l;
    int j = ((l & 1) == 0 ? (num - 1) % m : m - 1 - (num - 1) % m);
    return new int[]{ i, j };
  }
}
