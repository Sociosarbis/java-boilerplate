package networkBecomesIdle;

import java.util.ArrayList;
import java.util.List;


public class Solution {
    public int networkBecomesIdle(int[][] edges, int[] patience) {
        var graph = new int[patience.length];
        var visited = new boolean[patience.length];
        var neighbors = new ArrayList<ArrayList<Integer>>(patience.length);
        for (var i = 0;i < edges.length + 1;i++) {
            neighbors.add(new ArrayList<Integer>());
        }
        for (var edge:edges) {
            neighbors.get(edge[0]).add(edge[1]);
            neighbors.get(edge[1]).add(edge[0]);
        }

        var dist = 0;

        List<Integer> bfs = new ArrayList<>();

        bfs.add(0);

        while (!bfs.isEmpty()) {
            var nextBfs = new ArrayList<Integer>();
            for (var item:bfs) {
                graph[item] = dist * 2;
                for (var to:neighbors.get(item)) {
                    if (!visited[to]) {
                        visited[to] = true;
                        nextBfs.add(to);
                    }
                }
            }
            dist++;
            bfs = nextBfs;
        }

        int max = 0;
        for (var i = 1;i < graph.length;i++) {
            var n = graph[i] / patience[i];
            if (graph[i] % patience[i] == 0) {
                n--;
            }

            var temp = n * patience[i] + graph[i] + 1;
            if (temp > max) {
                max = temp;
            } 
        }
        return max;
    }
}