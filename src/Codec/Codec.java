package Codec;

class TreeNode {
  int val;
  TreeNode left;
  TreeNode right;
  TreeNode(int x) { val = x; }
}

public class Codec {
    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
      StringBuilder str = new StringBuilder();
      if (root == null) {
          str.append("-");
      } else {
          str.append(root.val);
          str.append(' ').append(serialize(root.left));
          str.append(' ').append(serialize(root.right));   
      }
      return str.toString();
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
      TreeNode root = new TreeNode(0);
      deserializeDFS(data, 0, root);
      return root.left;
    }

    int deserializeDFS(String data, int i, TreeNode node) {
      if (i < data.length()) {
          while (i < data.length() && data.charAt(i) == ' ') {
              i++;
          }
          int j = i + 1;
          while (j < data.length() && data.charAt(j) != ' ') {
              j++;
          }
          
          if (!(j == i + 1 && data.charAt(i) == '-')) {
            int num = Integer.parseInt(data.substring(i, j));
            node.left = new TreeNode(num);
            j = deserializeDFS(data, j, node.left);
          }
          i = j;
          if (i < data.length()) {
              while (i < data.length() && data.charAt(i) == ' ') {
                  i++;
              }
              j = i + 1;
              while (j < data.length() && data.charAt(j) != ' ') {
                  j++;
              }
              if (!(j == i + 1 && data.charAt(i) == '-')) {
                int num = Integer.parseInt(data.substring(i, j));
                node.right = new TreeNode(num);
                j = deserializeDFS(data, j, node.right);
              }
          }
          return j;
      }
      return i;
  }
}
