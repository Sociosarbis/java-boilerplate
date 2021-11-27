package flip;
import java.util.HashMap;
import java.util.Random;
import java.util.ArrayList;
import java.util.List;

public class Solution {
    ArrayList<List<Integer>> unflipped = new ArrayList<>();
    Random random = new Random();
    int count;
    int m;
    int n;
    public Solution(int m, int n) {
        count = m * n;
        this.m = m;
        this.n = n;
        unflipped.add(List.of(0, count));
    }
    
    public int[] flip() {
        int i = random.nextInt(count);
        count -= 1;
        int ret = 0;
        for (int j = 0;j < unflipped.size();j++) {
            List<Integer> range = unflipped.get(j);
            int len = range.get(1);
            if (i < len) {
                unflipped.remove(j);
                int start = range.get(0);
                ret = start + i;
                if (ret + 1 != start + len) {
                    unflipped.add(j, List.of(ret + 1, start + len - ret - 1));
                }
                if (i != 0) {
                    unflipped.add(j, List.of(start, i));
                }
                break;
            } else {
                i -= len;
            }
        }
        return new int[]{ ret / n,  ret % n };
    }
    
    public void reset() {
        count = m * n;
        unflipped.clear();
        unflipped.add(List.of(0, count));
    }
}

class SolutionBest {
    HashMap<Integer, Integer> unflipped = new HashMap<>();
    Random random = new Random();
    int count;
    int m;
    int n;
    public SolutionBest(int m, int n) {
        count = m * n;
        this.m = m;
        this.n = n;
    }
    
    public int[] flip() {
        int i = random.nextInt(count);
        count -= 1;
        int ret = unflipped.getOrDefault(i, i);
        unflipped.put(i, unflipped.getOrDefault(count, count));
        return new int[]{ ret / n,  ret % n };
    }
    
    public void reset() {
        count = m * n;
        unflipped.clear();
    }
}