package thirdMax;

class Solution {
    public int thirdMax(int[] nums) {
        int stack[] = new int[3];
        int i = 0;
        int len = 0;
        for (int num:nums) {
            for (i = 0;i <len;i++) {
                if (num > stack[i]) {
                    for (int j = 1;j >= i;j--) {
                        stack[j + 1] = stack[j];
                    }
                    stack[i] = num;
                    if (len < 3) {
                        len += 1;
                    }
                    break;
                } else if (num == stack[i]) break;
            }
            if (i >= len && i < 3) {
                stack[i] = num;
                len += 1;
            }
        }
        return len < 3 ? stack[0] : stack[2];
    }
}