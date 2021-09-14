package findLongestWords;

import java.util.List;
import java.util.ArrayList;
import java.util.HashMap;
import utils.Utils;

public class Solution {
    public String findLongestWord(String s, List<String> dictionary) {
        HashMap<Character, List<Integer>> charToPos = new HashMap<>();
        for (int i = 0;i < s.length();i++) {
            char c = s.charAt(i);
            if (!charToPos.containsKey(c)) {
                charToPos.put(c, new ArrayList<>());
            }
            charToPos.get(c).add(i);
        }
        String ret = "";
        for (String word:dictionary) {
            if (word.length() > ret.length() || (word.length() == ret.length() && word.compareTo(ret) < 0)) {
                int index = 0;
                for (int i = 0;i < word.length();i++) {
                    char c = word.charAt(i);
                    if (!charToPos.containsKey(c)) break;
                    List<Integer> list = charToPos.get(c);
                    int nextIndex = Utils.binarySearch(list, index, true);
                    if (nextIndex >= list.size()) break;
                    index = list.get(nextIndex) + 1;
                    if (i == word.length() - 1) {
                        ret = word;
                    }
                }
            }
        }
        return ret;
    }
}
