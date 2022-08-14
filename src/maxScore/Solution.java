package maxScore;

public class Solution {
    public int maxScore(String s) {
        var temp = 0;
        for (var i = 0;i < s.length();i++) {
            if (s.charAt(i) == '1') {
                temp++;
            }
        }
        var ret = 0;
        for (var i = 0;i + 1 < s.length();i++) {
            if (s.charAt(i) == '1') {
                temp--;
            } else {
                temp++;
            }
            if (temp > ret) {
                ret = temp;
            }
        }
        return ret;
    }
}
