package shoppingOffers;

import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;

public class Solution {
    public int shoppingOffers(List<Integer> price, List<List<Integer>> special, List<Integer> needs) {
        HashMap<Integer, Integer> dp = new HashMap<>();
        int ret = -1;
        dp.put(0, 0);
        while (!dp.isEmpty()) {
            HashMap<Integer, Integer> nextDp = new HashMap<>();
            for (Map.Entry<Integer, Integer> entry:dp.entrySet()) {
                int hash = entry.getKey();
                int money = entry.getValue();
                List<Integer> counter = new ArrayList<>();
                int nextRet = money;
                int i;
                for (i = 0;i < needs.size();i++) {
                    int count = hash >> (i * 4) & 15;
                    counter.add(count);
                    nextRet += (needs.get(i) - count) * price.get(i);
                }
                if (ret == -1 || ret > nextRet) {
                    ret = nextRet;
                }

                for (List<Integer> option:special) {
                    for (i = 0;i < needs.size();i++) {
                        if (counter.get(i) + option.get(i) > needs.get(i)) break;
                    }
                    if (i == needs.size()) {
                        int key = 0;
                        for (i = 0;i < needs.size();i++) {
                            key |= (counter.get(i) + option.get(i)) << (i * 4);
                        }
                        int nextMoney = money + option.get(option.size() - 1);
                        if (!nextDp.containsKey(key)) {
                            nextDp.put(key, nextMoney);
                        } else if (nextDp.get(key) > nextMoney){
                            nextDp.put(key, nextMoney);
                        }
                    }
                }
            }
            dp = nextDp;
        }
        return ret;
    }
}
