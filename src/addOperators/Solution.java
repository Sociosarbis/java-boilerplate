package addOperators;

import java.util.List;
import java.util.ArrayList;

public class Solution {
    private String num;
    private StringBuilder temp = new StringBuilder();
    private int target;
    private ArrayList<String> ret;
    public List<String> addOperators(String num, int target) {
        ret = new ArrayList<>();
        this.num = num;
        this.target = target;
        dfs(0, 0, 0);
        return ret;
    }

    private void dfs(int i, long lastNum, long value) {
        if (i >= num.length()) {
            if (value + lastNum == target) {
                ret.add(temp.toString());
            }
            return;
        }
        int oldLength = temp.length();
        for (int j = i;j < num.length();j++) {
            if (j != i && num.charAt(i) == '0') break;
            String cur = num.substring(i, j + 1);
            long curNum = Long.parseLong(cur);
            if (temp.length() != 0) {
                temp.append("*");
                temp.append(cur);
                dfs(j + 1, lastNum * curNum, value);
                temp.setLength(oldLength);
                temp.append("+");
                temp.append(cur);
                dfs(j + 1, curNum, value + lastNum);
                temp.setLength(oldLength);
                temp.append("-");
                temp.append(cur);
                dfs(j + 1, -curNum, value + lastNum);
                temp.setLength(oldLength);
            } else {
                temp.append(cur);
                dfs(j + 1, curNum, value);
                temp.setLength(oldLength);
            }
        }
    }
}
