package characterReplacement;

import java.util.ArrayList;
import java.util.List;

public class Solution {
  public int characterReplacement(String s, int k) {
    if (k >= s.length()) return s.length();
    List<List<Integer>> ranges = new ArrayList<List<Integer>>(26);
    for (int i = 0;i < 26;i++) {
      ranges.add(i, new ArrayList<Integer>());
    }
    int count = 1;
    int start = 0;
    char prevChar = s.charAt(0);
    for (int i = 1;i < s.length();i++) {
      char curChar = s.charAt(i);
      if (curChar == prevChar) {
        count++;
      } else {
        List<Integer> range = ranges.get(prevChar - 65);
        range.add(start);
        range.add(count);
        start = i;
        count = 1;
        prevChar = curChar;
      }
    }

    List<Integer> range = ranges.get(prevChar - 65);
    range.add(start);
    range.add(count);

    int ret = 0;
    for (int i = 0;i < 26;i++) {
      range = ranges.get(i);
      if (!range.isEmpty()) {
        int tmp = range.get(1);
        int remainK = k;
        List<Integer> tmpRanges = new ArrayList<Integer>();
        tmpRanges.add(range.get(0));
        tmpRanges.add(range.get(1));
        if (tmp + k > ret) {
          ret = tmp + k;
        }
        for (int j = 2;j < range.size();j+=2) {
          int prevStart = tmpRanges.get(tmpRanges.size() - 2);
          int prevCount = tmpRanges.get(tmpRanges.size() - 1);
          start = range.get(j);
          count = range.get(j + 1);
          while (remainK < start - prevStart - prevCount && !tmpRanges.isEmpty()) {
            int firstStart = tmpRanges.remove(0);
            int firstCount = tmpRanges.remove(0);
            tmp -= firstCount;
            if (!tmpRanges.isEmpty()) {
              remainK += tmpRanges.get(0) - firstStart - firstCount;
            } else {
              prevStart = start;
              prevCount = 0;
              remainK = k;
            }
          }
          tmp += count;
          remainK -= start - prevStart - prevCount;
          tmpRanges.add(start);
          tmpRanges.add(count);
          if (tmp + k > ret) {
            ret = tmp + k;
          }
        }
        if (ret >= s.length()) {
          return s.length();
        }
      }
    }

    return ret;
  }
}
