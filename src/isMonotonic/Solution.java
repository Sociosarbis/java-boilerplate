package isMonotonic;

class Solution {
  public boolean isMonotonic(int[] A) {
    int diff = 0;
    for (int i = 1;i < A.length;i++) {
      int curDiff = A[i] - A[i - 1];
      if (curDiff != 0) {
        if (curDiff > 0) {
          if (diff < 0) return false;
          if (diff == 0) {
            diff = curDiff;
          }
        } else {
          if (diff > 0) return false;
          if (diff == 0) {
            diff = curDiff;
          }
        }
      }
    }
    return true;
  }
}