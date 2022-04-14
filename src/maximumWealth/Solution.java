package maximumWealth;

class Solution {
    public int maximumWealth(int[][] accounts) {
        var ret = 0;
        for (var account:accounts) {
            var temp = 0;
            for (var bank:account) {
                temp += bank;
            }
            if (temp > ret) {
                ret = temp;
            }
        }
        return ret;
    }
}