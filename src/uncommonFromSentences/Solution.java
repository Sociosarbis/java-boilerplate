package uncommonFromSentences;

import java.util.HashMap;
import java.util.ArrayList;

public class Solution {
    public String[] uncommonFromSentences(String s1, String s2) {
        var m1 = new HashMap<String, Integer>();
        var m2 = new HashMap<String, Integer>();
        for (var s:s1.split(" ")) {
            if (m1.containsKey(s)) {
                m1.put(s, m1.get(s) + 1);
            } else {
                m1.put(s, 1);
            }
        }
        for (var s:s2.split(" ")) {
            if (m2.containsKey(s)) {
                m2.put(s, m2.get(s) + 1);
            } else {
                m2.put(s, 1);
            }
        }
        var ret = new ArrayList<String>();
        for (var entry:m1.entrySet()) {
            if (entry.getValue() == 1) {
                if (!m2.containsKey(entry.getKey())) {
                    ret.add(entry.getKey());
                }
            }
        }
        for (var entry:m2.entrySet()) {
            if (entry.getValue() == 1) {
                if (!m1.containsKey(entry.getKey())) {
                    ret.add(entry.getKey());
                }
            }
        }
        return ret.toArray(new String[ret.size()]);
    }
}
