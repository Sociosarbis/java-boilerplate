package findJudge;

public class Solution {
    public int findJudge(int n, int[][] trust) {
        int[] trustedCount = new int[n+1];
        boolean[] hasTrust = new boolean[n+1];
        for (int[] item:trust) {
            trustedCount[item[1]] += 1;
            if (!hasTrust[item[0]]) {
                hasTrust[item[0]] = true;
            }
        }
        for (int i = 1;i < trustedCount.length;i++) {
            if (trustedCount[i] + 1 == n && !hasTrust[i]) {
                return i;
            }
        }
        return -1;
    }
}
