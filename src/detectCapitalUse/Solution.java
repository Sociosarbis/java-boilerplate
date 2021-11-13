package detectCapitalUse;


class Solution {
    public boolean detectCapitalUse(String word) {
        boolean detectCapital = false;
        int detectFrom = 1;
        if (word.charAt(0) >= 'A' && word.charAt(0) <= 'Z') {
            if (word.length() > 1) {
                detectCapital = word.charAt(1) >= 'A' && word.charAt(1) <= 'Z';
                detectFrom++;
            }
        }
        for (int i = detectFrom;i < word.length();i++) {
            if (detectCapital != (word.charAt(i) >= 'A' && word.charAt(i) <= 'Z')) {
                return false;
            }
        }
        return true;
    }
}