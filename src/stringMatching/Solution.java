package stringMatching;

import java.util.List;
import java.util.ArrayList;

public class Solution {
    public List<String> stringMatching(String[] words) {
        var ret = new ArrayList<String>();

        for (var i = 0;i < words.length;i++) {
            var a = words[i];
            loop1:for (var j = 0;j < words.length;j++) {
                if (a.length() < words[j].length()) {
                    var b = words[j];
                    var options = b.length() - a.length();
                    loop2: for (var k = 0;k <= options;k++) {
                        var l = 0;
                        while (l < a.length()) {
                            if (a.charAt(l) == b.charAt(k + l)) {
                                l++;
                            } else {
                                continue loop2;
                            }
                        }
                        ret.add(a);
                        break loop1;
                    }
            
                }
            }
        }
        return ret;
    }
}
