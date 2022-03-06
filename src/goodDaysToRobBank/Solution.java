package goodDaysToRobBank;

import java.util.List;
import java.util.ArrayList;

public class Solution {
    public List<Integer> goodDaysToRobBank(int[] security, int time) {
        var ret = new ArrayList<Integer>();
        var j = time;
        var k = time;
        for (var i = time;i + time < security.length;i++) {
            if (i != j && security[i - 1] < security[i]) {
                j = i;
            }

            if (k < i) {
                k = i;
            }

            while (i - j < time && j - 1 >= 0 && security[j - 1] >= security[j]) {
                j -= 1;
            }

            while (k - i < time && k + 1 < security.length && security[k + 1] >= security[k]) {
                k += 1;
            }

            if (i - j >= time && k - i >= time) {
                ret.add(i);
            }
        }
        return ret;
    }
}
