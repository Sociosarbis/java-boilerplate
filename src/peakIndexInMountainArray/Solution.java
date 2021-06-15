package peakIndexInMountainArray;

public class Solution {
  public int peakIndexInMountainArray(int[] arr) {
    return dfs(arr, 0, arr.length - 1);
  }

  int dfs(int[] arr, int l, int r) {
    int ret = -1;
    if (l <= r) {
      int mid = (l + r) / 2;
      if (arr[mid] < arr[l]) {
        return dfs(arr, l, mid - 1);
      }

      if (arr[mid] < arr[r]) {
        return dfs(arr, mid + 1, r);
      }

      if (ret == -1 || arr[ret] < arr[mid]) {
        ret = mid;
      }
      int opt1 = dfs(arr, l, mid - 1);
      if (opt1 != -1 && arr[opt1] > arr[ret]) {
        ret = opt1;
      }
      int opt2 = dfs(arr, mid + 1, r);
      if (opt2 != -1 && arr[opt2] > arr[ret]) {
        ret = opt2;
      }
    }
    return ret;
  }
}
