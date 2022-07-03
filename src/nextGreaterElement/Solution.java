package nextGreaterElement;

import java.util.ArrayList;
import java.util.Arrays;

public class Solution {
    public int nextGreaterElement(int n) {
        if (n < 12) {
            return -1;
        }
        var temp = n;
        var digits = new ArrayList<Integer>();
        while (temp != 0) {
            digits.add(temp % 10);
            temp /= 10;
        }
        for (var i = 1;i < digits.size();i++) {
            var digit = digits.get(i);
            if (digit < digits.get(i - 1)) {
                for (var j = i - 1;j >= 0;j--) {
                    if (!(j > 0 && digit < digits.get(j - 1))) {
                        digits.set(i, digits.get(j));
                        digits.set(j, digit);
                        break;
                    }
                }
                var tempList = new int[i];
                for (var j = 0;j < i;j++) {
                    tempList[j] = digits.get(j);
                }
                Arrays.sort(tempList);
                for (var j = 0;j < i;j++) {
                    digits.set(i - 1 - j, tempList[j]);
                }
                var ret = 0;
                var base = 1;
                var max = 2147483647;
                for (var j = 0;j < digits.size();j++) {
                    temp = max - ret;
                    if (temp / base < digits.get(j)) {
                        return -1;
                    }
                    ret += base * digits.get(j);
                    if (j < 9) {
                        base *= 10;
                    }
                }
                break;
            }
        }
        return -1;
    }
}
