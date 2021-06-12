package largestNumber;

import java.util.List;
import java.util.HashMap;
import java.util.Map;
import java.util.ArrayList;
import java.util.Collections;

public class Solution {
  public String largestNumber(int[] cost, int target) {
    List<ArrayList<Integer>> dp = new ArrayList<>(target + 1);
    dp.add(new ArrayList<Integer>());
    Map<Integer, Integer> costToNum = new HashMap<>();
    for (int i = 0;i < 9;i++) {
      costToNum.put(cost[i], i + 1);
    }
    for (int i = 1;i <= target;i++) {
      dp.add(null);
      for (Map.Entry<Integer, Integer> entry:costToNum.entrySet()) {
        int c = entry.getKey();
        int num = entry.getValue();
        if (c <= i && dp.get(i - c) != null) {
          ArrayList<Integer> list = new ArrayList<>(dp.get(i - c));
          int index = Collections.binarySearch(list, num);
          if (index < 0) {
            index = -(index + 1);
          }
          if (index == list.size()) {
            list.add(num);
          } else {
            list.add(index, num);
          }
          ArrayList<Integer> oldList = dp.get(i);
          if (oldList != null) {
            if (oldList.size() > list.size()) continue;
            if (oldList.size() == list.size()) {
              int n = oldList.size();
              boolean shouldReplaced = false;
              for (int j = n - 1;j >= 0;j--) {
                int digit1 = list.get(j);
                int digit2 = oldList.get(j);
                if (digit1 != digit2) {
                  if (digit1 > digit2) {
                    shouldReplaced = true;
                  }
                  break;
                }
              }
              if (!shouldReplaced)  continue;
            }
          }
          dp.set(i, list);
        }
      }
    }
    List<Integer> ret = dp.get(target);
    if (ret == null) {
      return "0";
    }
    StringBuilder sb = new StringBuilder();
    for (int i = ret.size() - 1;i >= 0;i--) {
      sb.append(ret.get(i));
    }
    return sb.toString();
  }
}
