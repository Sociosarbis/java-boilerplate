package minKBitFlips;

import java.util.List;
import java.util.ArrayList;

public class Solution {
  public int minKBitFlips(int[] A, int K) {
    int n = A.length;
    /**
     * window 保存每次翻转开始的位置
     */
    List<Integer> window = new ArrayList<Integer>();
    int j = 0;
    int ret = 0;
    for (int i = 0;i < n;i++) {
      /**
       * 因为i前K-1之前的位置与判断i此时是0或1无关，所以将它们排除
       */
      while (j < window.size() && window.get(j) + K <= i) {
        j++;
      }
      /**
       * 当前窗口的大小表示此前经过了几次翻转。假如是偶次翻转，初始A[i] == 0；奇次翻转，初始A[i] == 1，都会使此时A[i] == 0,
       * 因此需要在当前位置进行翻转
       */
      if (A[i] == ((window.size() - j) & 1)) {
        if (i + K > n) return -1;
        window.add(i);
        ret++;
      }
    }
    return ret;
  }
}
