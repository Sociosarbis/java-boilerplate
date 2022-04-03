package nextGreatestLetter;

public class Solution {
    public char nextGreatestLetter(char[] letters, char target) {
        var l = 0;
        var r = letters.length - 1;
        while (l <= r) {
            var mid = (l + r) >> 1;
            if (letters[mid] <= target) {
                l = mid + 1;
            } else {
                if (mid > 0 && letters[mid - 1] > target) {
                    r = mid - 1;
                } else {
                    l = mid;
                    break;
                }
            }
        }
        return letters[l % letters.length];
    }
}
