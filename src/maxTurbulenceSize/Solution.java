package maxTurbulenceSize;

public class Solution {
  public int maxTurbulenceSize(int[] arr) {
    if (arr.length == 1) return 1;
    int diff = 0;
    int tmp = 1;
    int ret = tmp;
    for (int i = 1;i < arr.length;i++) {
      int nextDiff = arr[i] - arr[i - 1];
      if (nextDiff == 0) {
        tmp = 1;
      } else {
        if ((diff > 0 && nextDiff < 0) || (diff < 0 && nextDiff > 0)) {
          tmp += 1;
        } else {
          tmp = 2;
        }
      }
      if (tmp > ret) {
        ret = tmp;
      }
      diff = nextDiff;
    }
    return ret;
  }
}
