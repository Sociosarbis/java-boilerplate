package findAndReplacePattern;

import java.util.List;
import java.util.ArrayList;
import java.util.HashMap;

class Solution {
    public List<String> findAndReplacePattern(String[] words, String pattern) {
        var tempMap = new HashMap<Character, Character>();
        var normalizedPattern = "";
        var ret = new ArrayList<String>();
        for (var i = 0;i < pattern.length();i++) {
            if (!tempMap.containsKey(pattern.charAt(i))) {
                tempMap.put(pattern.charAt(i), (char)('a' + tempMap.size()));
            }
            normalizedPattern += tempMap.get(pattern.charAt(i));
        }
        outer:
        for (var word:words) {
            tempMap.clear();
            for (var i = 0;i < word.length();i++) {
                if (!tempMap.containsKey(word.charAt(i))) {
                    tempMap.put(word.charAt(i), (char)('a' + tempMap.size()));
                }
                if (tempMap.get(word.charAt(i)) != normalizedPattern.charAt(i)) {
                    continue outer;
                }
            }
            ret.add(word);
        }
        return ret;
    }
}
