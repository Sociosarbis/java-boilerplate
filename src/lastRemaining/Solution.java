package lastRemaining;

public class Solution {
    public int lastRemaining(int n) {
        if (n == 1) return n;
        int round = 0;
        int temp = n;
        while (temp > 1) {
            temp >>= 1;
            round++;
        }
        int left = 1;
        int right = n;
        for (int i = 0;i < round;i++) {
            if ((i & 1) == 0) {
                right = (right - left) % (1 << (i + 1)) == 0 ? right - (1 << i) : right;
                left += 1 << i;
            } else {
                left = (right - left) % (1 << (i + 1)) == 0 ? left + (1 << i) : left;
                right -= 1 << i;
            }
        }
        return left;
    }
}
