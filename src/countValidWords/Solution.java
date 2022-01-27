package countValidWords;

class Solution {
    boolean isLetter(char c) {
        return c >= 'a' && c <= 'z';
    }
    public int countValidWords(String sentence) {
        var words = sentence.trim().split("\\s+");
        var ret = 0;
        for (var word: words) {
            var isValid = true;
            var hasHyphen = false;
            for (int i = 0;i < word.length();i++) {
                var ch = word.charAt(i);
                switch (ch) {
                    case '!':
                    case '.':
                    case ',':
                        if (i + 1 != word.length()) {
                            isValid = false;
                        }
                        break;
                    case '-':
                        if (hasHyphen || (i == 0 || i + 1 == word.length() || !isLetter(word.charAt(i - 1)) || !isLetter(word.charAt(i + 1)))) {
                            isValid = false;
                        }
                        hasHyphen = true;
                        break;
                    default:
                        if (!isLetter(ch)) {
                            isValid = false;
                        }
                }
                if (!isValid) {
                    break;
                }
            }
            if (isValid) {
                ret++;
            }
        }
        return ret;
    }
}