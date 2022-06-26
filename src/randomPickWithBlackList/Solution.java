package randomPickWithBlackList;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Random;

class Solution {
    boolean isNeg;
    HashSet<Integer> optionSet;
    ArrayList<Integer> optionList;
    int n;
    Random numGenerator;
    public Solution(int n, int[] blacklist) {
        this.n = n;
        numGenerator = new Random();
        if (blacklist.length > n >> 1) {
            isNeg = false;
            optionList = new ArrayList<>();
            Arrays.sort(blacklist);
            var i = 0;
            var j = 0;
            while (i < n) {
                if (j < blacklist.length) {
                    if (blacklist[j] <= i) {
                        j++;
                        continue;
                    }
                }
                optionList.add(i);
                i++;

            }
        } else {
            isNeg = true;
            optionSet = new HashSet<>();
            for (var item:blacklist) {
                optionSet.add(item);
            }
        }
    }
    
    public int pick() {
        if (isNeg) {
            int num;
            do {
                num = numGenerator.nextInt(n);
            } while (!optionSet.contains(num));
            return num;
        } else {
            return optionList.get(numGenerator.nextInt(optionList.size()));
        }
    }
}
