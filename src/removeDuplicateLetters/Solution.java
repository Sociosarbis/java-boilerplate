package removeDuplicateLetters;

class Solution {
  public String removeDuplicateLetters(String s) {
      int[] counter = new int[26];
      boolean[] mark = new boolean[26];
      for (int i = 0;i < s.length();i++) {
        counter[s.charAt(i) - 97]++;
      }
      StringBuilder builder = new StringBuilder();
      for (int i = 0;i < s.length();i++) {
        char cur = s.charAt(i);
        if (!mark[cur - 97]) {
          while (builder.length() != 0) {
            char lastChar = builder.charAt(builder.length() - 1);
            // 当lastChar大于当前字符且后面还会出现该字符时出栈
            if (lastChar > cur && counter[lastChar - 97] >= 1) {
              builder.deleteCharAt(builder.length() - 1);
              mark[lastChar - 97] = false;
            } else {
              break;
            }
          }
          builder.append(cur);
          mark[cur - 97] = true;
        }
        counter[cur - 97]--;
      }
      return builder.toString();
  }
}
