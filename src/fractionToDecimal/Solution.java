package fractionToDecimal;
import java.util.ArrayList;
import java.util.HashMap;

class Solution {
    public String fractionToDecimal(int numerator, int denominator) {
        long n = (long) numerator / denominator;
        long remainder = (numerator % denominator) * 10;
        if (remainder < 0) {
            remainder = -remainder;
        }
        ArrayList<Integer> decimals = new ArrayList<>();
        HashMap<String, Integer> cache = new HashMap<>();
        int recurrBeginAt = -1;
        while (remainder != 0) {
            String key = remainder + " " + denominator;
            if (cache.containsKey(key)) {
                recurrBeginAt = cache.get(key);
                break;
            }
            cache.put(key, decimals.size());
            int num = (int) (remainder / denominator);
            decimals.add(num < 0 ? -num : num);
            remainder = (remainder % denominator) * 10;
        }
        StringBuilder builder = new StringBuilder();
        if (n == 0 && ((numerator > 0 && denominator < 0) || (numerator < 0 && denominator > 0))) {
            builder.append('-');
        }
        builder.append(Long.toString(n));
        if (!decimals.isEmpty()) {
            builder.append('.');
            for (int i = 0;i < decimals.size();i++) {
                if (i == recurrBeginAt) {
                    builder.append('(');
                }
                builder.append(Integer.toString(decimals.get(i)));
            }
            if (recurrBeginAt != -1) {
                builder.append(')');
            }
        }
        return builder.toString();
    }
}