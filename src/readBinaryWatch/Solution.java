package readBinaryWatch;

import java.util.List;
import java.util.ArrayList;

public class Solution {
  public List<String> readBinaryWatch(int turnedOn) {
    List<String> ret = new ArrayList<>();
    dfs(ret, 0, turnedOn, 0);
    return ret;
  }

  private void dfs(List<String> ret, int acc, int turnedOn, int i) {
    if (turnedOn == 0) {
      int hour = acc >> 6;
      int minute = acc & 63;
      if (hour < 12 && minute < 60) {
        StringBuilder b = new StringBuilder();
        b.append(hour);
        b.append(":");
        if (minute < 10) {
          b.append("0");
        }
        b.append(minute);
        ret.add(b.toString());
      }
      return;
    };
    if (i >= 10) return;
    int bit = 1 << i;
    dfs(ret, acc | bit, turnedOn - 1, i + 1);
    dfs(ret, acc, turnedOn, i + 1);
  }
}
