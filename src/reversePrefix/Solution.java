package reversePrefix;

public class Solution {
    public String reversePrefix(String word, char ch) {
        var index = word.indexOf(ch);
        if (index != -1) {
            var builder = new StringBuilder();
            for (var i = 0;i < index + 1;i++) {
                builder.append(word.charAt(index - i));
            }
            if (index + 1 < word.length()) {
                builder.append(word.substring(index + 1));
            }
            return builder.toString();
        }
        return word;
    }
}
