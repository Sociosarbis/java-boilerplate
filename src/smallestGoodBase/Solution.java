package smallestGoodBase;

import java.lang.Math;

public class Solution {
  public String smallestGoodBase(String n) {
    long target = Long.parseLong(n);
    long cur = Long.parseLong(n) - 1;
    int level = 2;
    long ret = cur;
    long nextCur = (long) (Math.pow(target, (double) 1 / (double) level));
    while (cur >= 2) {
      cur = nextCur;
      nextCur = (long) Math.pow(target, (double) 1 / (double) (level + 1));
      long left = nextCur < 2 ? 2 : nextCur;
      long right = cur;
      while (left <= right) {
        long mid = (left + right) / 2;
        int j = 1;
        long acc = 1;
        long b = 1;
        while (j <= level) {
          b *= mid;
          acc += b;
          j += 1;
        }
        if (acc == target) {
          ret = mid;
          break;
        } else if (acc < target) {
          left = mid + 1;
        } else {
          right = mid - 1;
        }
      }
      level += 1;
    }
    return String.valueOf(ret);
  }
}
