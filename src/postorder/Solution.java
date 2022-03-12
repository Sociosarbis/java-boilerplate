package postorder;

import java.util.List;
import java.util.ArrayList;

class Node {
    public int val;
    public List<Node> children;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, List<Node> _children) {
        val = _val;
        children = _children;
    }
};


class Solution {
    public List<Integer> postorder(Node root) {
        if (root == null) return new ArrayList<>();
        var stack = new ArrayList<Node>();
        var ret = new ArrayList<Integer>();
        stack.add(root);
        while (!stack.isEmpty()) {
            var cur = stack.remove(stack.size() - 1);
            if (cur.children == null) {
                ret.add(cur.val);
            } else {
                stack.add(new Node(cur.val));
                for (var i = cur.children.size() - 1;i >= 0;i--) {
                    stack.add(cur.children.get(i));
                }
            }
        }
        return ret;
    }
}