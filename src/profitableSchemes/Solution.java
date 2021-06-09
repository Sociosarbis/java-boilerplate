package profitableSchemes;

import java.util.List;
import java.util.ArrayList;

class Solution {
  public int profitableSchemes(int n, int minProfit, int[] group, int[] profit) {
      int[][] dp = new int[minProfit + 1][n + 1];
      dp[0][0] = 1;
      for (int i = 0;i < profit.length;i++) {
        int p = profit[i];
        int g = group[i];
        List<List<Integer>> updateList = new ArrayList<>();
        for (int j = 0;j <= minProfit;j++) {
          int[] costs = dp[j];
          for (int k = 0; k <= n - g;k++) {
            if (costs[k] != 0) {
              int ppp = p + j;
              if (ppp > minProfit) {
                ppp = minProfit;
              }
              updateList.add(List.of(ppp, k + g, costs[k]));
            }
          }
        }
  
        for (List<Integer> update:updateList) {
          int cost = update.get(1);
          int[] costs = dp[update.get(0)];
          int nextCount = costs[cost] + update.get(2);
          if (nextCount >= 1000000007) {
            nextCount %= 1000000007;
          }
          costs[cost] = nextCount;
        }
      }
      int ret = 0;
      int[] costs = dp[minProfit];
      for (int i = 0;i <= n;i++) {
        if (costs[i] != 0) {
          int nextRet = ret + costs[i];
          if (nextRet >= 1000000007) {
            nextRet %= 1000000007;
          }
          ret = nextRet;
        }
      }
      return ret;
  }
}