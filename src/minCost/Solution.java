package minCost;

import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;

public class Solution {
  public int minCost(int[] houses, int[][] cost, int m, int n, int target) {
    List<List<Map<Integer, Integer>>> dp = new ArrayList<List<Map<Integer, Integer>>>(2);
    for (int i = 0;i < 2;i++) {
      dp.add(new ArrayList<Map<Integer, Integer>>(n));
      List<Map<Integer, Integer>> subDp = dp.get(i);
      for (int j = 0;j < n;j++) {
        subDp.add(new HashMap<Integer, Integer>());
      }
    }
    for (int i = 0;i < m;i++) {
      List<Map<Integer, Integer>> subDp = dp.get(i % 2);
      int color = houses[i];
      for (int j = 0;j < n;j++) {
        int curCost = color == j + 1 ? 0 : cost[i][j];
        Map<Integer, Integer> curOptions = subDp.get(j);
        curOptions.clear();
        if (!(color != 0 && curCost != 0)) {
          if (i == 0) {
            subDp.get(j).put(0, curCost); 
          } else {
            List<Map<Integer, Integer>> prevDp = dp.get((i - 1) % 2);
            for (int k = 0;k < n;k++) {
              if (!prevDp.get(k).isEmpty()) {
                for (Map.Entry<Integer, Integer> entry: prevDp.get(k).entrySet()) {
                  int prevTarget = entry.getKey();
                  int prevCost = entry.getValue();
                  if (!(j != k && prevTarget + 1 == target)) {
                    int nextTarget = j != k ? prevTarget + 1 :prevTarget;
                    int nextValue = curCost + prevCost;
                    curOptions.put(nextTarget, curOptions.containsKey(nextTarget) ? Math.min(curOptions.get(nextTarget), nextValue) : nextValue);
                  }
                }
              }
            }
          }
        }
      }
    }
    int ret = -1;
    for (Map<Integer, Integer> options: dp.get((m - 1) % 2)) {
      if (options.containsKey(target - 1)) {
        int value = options.get(target - 1);
        if (value < ret || ret == -1) {
          ret = value;
        }
      }
    }
    return ret;
  }
}
