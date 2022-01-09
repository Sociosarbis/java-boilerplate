package slowestKey;

public class Solution {
    public char slowestKey(int[] releaseTimes, String keysPressed) {
        var ret = (int) keysPressed.charAt(0);
        var max = releaseTimes[0];
        var chars = keysPressed.chars().skip(1).iterator();
        for (int i = 1;i < releaseTimes.length;i++) {
            var c = chars.next().intValue();
            var time = releaseTimes[i] - releaseTimes[i - 1];
            if (time >= max) {
                if (time == max && c < ret) continue;
                max = time;
                ret = c;
            }
        }
        return (char) ret;
    }
}
