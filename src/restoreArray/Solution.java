package restoreArray;

import java.util.HashMap;
import java.util.Map;
import java.util.ArrayList;

class Solution {
    public int[] restoreArray(int[][] adjacentPairs) {
        HashMap<Integer, ArrayList<Integer>> numToSiblings = new HashMap<>();
        for (int[] pair:adjacentPairs) {
            if (!numToSiblings.containsKey(pair[0])) {
                numToSiblings.put(pair[0], new ArrayList<Integer>());
            }
            if (!numToSiblings.containsKey(pair[1])) {
                numToSiblings.put(pair[1], new ArrayList<Integer>());
            }
            numToSiblings.get(pair[0]).add(pair[1]);
            numToSiblings.get(pair[1]).add(pair[0]);
        }
        int[] ret = new int[adjacentPairs.length + 1];
        int i = 0;
        for (Map.Entry<Integer, ArrayList<Integer>> pair :numToSiblings.entrySet()) {
            if (pair.getValue().size() == 1) {
                int key = pair.getKey();
                ArrayList<Integer> options = numToSiblings.get(key);
                while (options.size() != 0) {
                    int value = options.get(0);
                    options.clear();
                    ret[i++] = key;
                    ArrayList<Integer> nextOptions = numToSiblings.get(value);
                    nextOptions.remove(nextOptions.indexOf(key));
                    key = value;
                    options = nextOptions;
                }
                ret[i++] = key;
                break;
            }
        }
        return ret;
    }
}