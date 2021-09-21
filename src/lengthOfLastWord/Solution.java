package lengthOfLastWord;


class Solution {
    public int lengthOfLastWord(String s) {
        int temp = 0;
        int ret = 0;
        for (int i = 0;i < s.length();i++) {
            if (s.charAt(i) == ' ') {
                if (temp != 0) {
                    ret = temp;
                    temp = 0;
                }
            } else {
                temp += 1;
            }
        }
        if (temp > 0) {
            ret = temp;
        }
        return ret;
    }
}

