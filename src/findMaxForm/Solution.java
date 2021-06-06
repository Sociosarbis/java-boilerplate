package findMaxForm;

import java.util.List;
import java.util.ArrayList;

public class Solution {
  public int findMaxForm(String[] strs, int m, int n) {
    int[][] dp = new int[101][101];
    List<List<Integer>> options = new ArrayList<>(List.of(List.of(0,0,0)));
    int ret = 0; 
    for (String s:strs) {
      int zeros = 0;
      int ones = 0;
      for (char c:s.toCharArray()) {
        if (c == '0') {
          zeros += 1;
        } else {
          ones += 1;
        }
      }
      List<List<Integer>> nextOptions = new ArrayList<>();
      for (List<Integer> opt:options) {
        int nextZeros = opt.get(0) + zeros;
        int nextOnes = opt.get(1) + ones;
        int newCount = opt.get(2) + 1;
        if (nextZeros <= m && nextOnes <= n && dp[nextZeros][nextOnes] < newCount) {
          nextOptions.add(List.of(nextZeros, nextOnes, newCount));
          if (newCount > ret) {
            ret = newCount;
          }
        }
      }
      for (List<Integer> opt:nextOptions) {
        dp[opt.get(0)][opt.get(1)] = opt.get(2);
      }
      for (List<Integer> opt:options) {
        if (dp[opt.get(0)][opt.get(1)] <= opt.get(2)) {
          nextOptions.add(opt);
        }
      }
      options = nextOptions;
    }
    return ret;
  }
}
