package uniqueMorseRepresentations;

import java.util.HashSet;

class Solution {
    String[] table = new String[]{
        ".-","-...","-.-.","-..",".","..-.","--.","....","..",".---","-.-",".-..","--","-.","---",".--.","--.-",".-.","...","-","..-","...-",".--","-..-","-.--","--.."
    };

    public int uniqueMorseRepresentations(String[] words) {
        var set = new HashSet<String>();
        for (var word : words) {
            var temp = new StringBuilder();
            for (var i = 0;i < word.length();i++) {
                temp.append(table[word.charAt(i) - 97]);
            }
            var s = temp.toString();
            if (!set.contains(s)) {
                set.add(s);
            }
        }
        return set.size();
    }
}