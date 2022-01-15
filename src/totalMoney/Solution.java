package totalMoney;

public class Solution {
    public int totalMoney(int n) {
        var weeks = n / 7;
        var restDays = n % 7;
        return (28 * weeks) + (weeks - 1) * weeks * 7 / 2 + (1 + restDays + 2 * weeks) * restDays / 2;
    }
}
