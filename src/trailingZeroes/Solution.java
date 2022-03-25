package trailingZeroes;

public class Solution {
    public int trailingZeroes(int n) {
        var ret = 0;
        while (n != 0) {
            n /= 5;
            ret += n;
        }
        return ret;
    }
}
