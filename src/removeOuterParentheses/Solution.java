package removeOuterParentheses;

public class Solution {
    public String removeOuterParentheses(String s) {
        var count = 0;
        var start = 0;
        var builder = new StringBuilder(s);
        for (var i = s.length() - 1;i >= 0;i--) {
            if (s.charAt(i) == ')') {
                count++;
                if (count == 1) {
                    start = i;
                }
            } else {
                count--;
                if (count == 0) {
                    builder.deleteCharAt(start);
                    builder.deleteCharAt(i);
                }
            }
        }
        return builder.toString();
    }
}
