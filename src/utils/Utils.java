package utils;

import java.util.List;

public class Utils {
    public static <T> int binarySearch(List<? extends Comparable<? super T>> nums, T target, boolean isInsert) {
        if (nums.isEmpty()) {
          return isInsert ? 0 : -1;
        }
    
        int l = 0;
        int r = nums.size() - 1;
        while (l <= r) {
          int mid  = (l + r) / 2;
          if (nums.get(mid).compareTo(target) < 0) {
            l = mid + 1;
            if (l > r) {
              return isInsert ? l : -1;
            }
          } else if (nums.get(mid).compareTo(target) > 0) {
            if (mid == 0 || mid - 1 < l) {
              return isInsert ? mid : -1;
            }
            r = mid - 1;
          } else {
            return mid;
          }
        }
        return 0;
      }
}
