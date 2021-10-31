package findWords;

import java.util.ArrayList;


class Solution {
    static int[] mapping = {1,2,2,1,0,1,1,1,0,1,1,1,2,2,0,0,0,0,1,0,0,2,0,2,0,2};
    public String[] findWords(String[] words) {
        ArrayList<String> ret = new ArrayList<>();
        for (String word:words) {
            int group = mapping[Character.toLowerCase(word.charAt(0)) - 97];
            for (int i = 1;i < word.length();i++) {
                if (mapping[Character.toLowerCase(word.charAt(i)) - 97] != group) {
                    group = -1;
                    break;
                }
            }
            if (group != -1) {
                ret.add(word);
            }
        }
        return ret.toArray(new String[ret.size()]);
    }
}