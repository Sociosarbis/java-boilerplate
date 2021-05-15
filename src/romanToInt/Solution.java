package romanToInt;

public class Solution {
  public int romanToInt(String s) {
    int[] unit = {1, 4, 5, 9, 10, 40, 50, 90, 100, 400, 500, 900, 1000};
    String[] unitStr = {"I", "IV", "V", "IX", "X", "XL", "L", "XC", "C", "CD", "D", "CM", "M"};
    int ret = 0;
    for (int i = 0;i < s.length();i++) {
      int index = -1;
      int j = i;
      for (;j < s.length();j++) {
        int k = 0;
        String subString = s.substring(i, j + 1);
        for (;k < unitStr.length;k++) {
          if (subString.equals(unitStr[k])) {
            index = k;
            break;
          }
        }
        if (k == unitStr.length) break;
      }
      i = j - 1;
      ret += unit[index];
    }
    return ret;
  }
}
