package outerTrees;

import java.util.ArrayList;

public class Solution {
    public int[][] outerTrees(int[][] trees) {
        var top = 0;
        var bottom = 100;

        var rows = new ArrayList<ArrayList<int[]>>(101);

        var added = new boolean[101][101];

        for (var i = 0;i < 100;i++) {
            rows.add(new ArrayList<>());
        }
        
        for (var tree:trees) {
            if (tree[1] > top) {
                top = tree[1];
            }

            if (tree[1] < bottom) {
                bottom = tree[1];
            }
        }
        
        var ret = new ArrayList<int[]>();

        for (var tree:trees) {
            if (tree[1] == top || tree[1] == bottom) {
                ret.add(tree);
            }
            var row = rows.get(tree[1]);
            if (row.isEmpty()) {
                row.add(tree);
            } else {
                if (row.get(0)[0] > tree[0]) {
                    row.add(0, tree);
                } else if (row.get(row.size() - 1)[0] < tree[0]) {
                    row.add(tree);
                }
                if (row.size() > 2) {
                    row.remove(1);
                }
            }
        }

        var temp = new ArrayList<int[]>();
        for (var i = top;i >= bottom;i--) {
            var row = rows.get(i);
            if (!row.isEmpty()) {
                var cur = row.get(0);
                while (temp.size() > 1) {
                    var pp = temp.get(temp.size() - 2);
                    var p = temp.get(temp.size() - 1);
                    var x1 = pp[0] - p[0];
                    var y1 = pp[1] - p[1];
                    var x2 = pp[0] - cur[0];
                    var y2 = pp[1] - cur[1];
                    var isReplace = false;
                    if (x1 < 0) {
                        if (x2 < 0) {
                            if (y1 * x2 > y2 * x1) {
                                isReplace = true;
                            }
                        } else {
                            isReplace = true;
                        }
                    } else {
                        if (x2 > 0) {
                            if (y1 * x2 > y2 * x1) {
                                isReplace = true;
                            }
                        }
                    }
                    if (isReplace) {
                        temp.remove(temp.size() - 1);
                    } else {
                        break;
                    }
                }
                temp.add(cur);
            }
        }

        for (var i = 1;i < temp.size() - 1;i++) {
            var item = temp.get(i);
            ret.add(item);
            added[item[0]][item[1]] = true;
        }
        temp.clear();
        for (var i = top;i >= bottom;i--) {
            var row = rows.get(i);
            if (!row.isEmpty()) {
                var cur = row.get(row.size() - 1);
                while (temp.size() > 1) {
                    var pp = temp.get(temp.size() - 2);
                    var p = temp.get(temp.size() - 1);
                    var x1 = pp[0] - p[0];
                    var y1 = pp[1] - p[1];
                    var x2 = pp[0] - cur[0];
                    var y2 = pp[1] - cur[1];
                    var isReplace = false;
                    if (x1 < 0) {
                        if (x2 < 0) {
                            if (y1 * x2 < y2 * x1) {
                                isReplace = true;
                            }
                        }
                    } else {
                        if (x2 >= 0) {
                            if (y1 * x2 < y2 * x1) {
                                isReplace = true;
                            }
                        } else {
                            isReplace = true;
                        }
                    }
                    if (isReplace) {
                        temp.remove(temp.size() - 1);
                    } else {
                        break;
                    }
                }
                temp.add(cur);
            }
        }

        for (var i = 1;i < temp.size() - 1;i++) {
            var item = temp.get(i);
            if (!added[item[0]][item[1]]) {
                ret.add(item);
            }
        }

        return ret.toArray(new int[ret.size()][]);
    }
}
