package maximizeXor;

class Node {
  Node left = null;
  Node right = null;
}

class Solution {
  public int[] maximizeXor(int[] nums, int[][] queries) {
    int min = 1 << 30;
    int max_bit = min >> 1;
    Node root = new Node();
    for (int num:nums) {
      if (num < min) {
        min = num;
      }
      int bit = max_bit;
      Node node = root;
      while (bit != 0) {
        if ((bit & num) != 0) {
          if (node.right == null) {
            node.right = new Node();
          }
          node = node.right;
        } else {
          if (node.left == null) {
            node.left = new Node();
          }
          node = node.left;
        }
        bit >>= 1;
      }
    }
    int[] ret = new int[queries.length];
    int i = 0;
    for (int[] pair:queries) {
      int num = pair[0];
      int max = pair[1];
      if (max < min) {
        ret[i] = -1;
      } else {
        int res = dfs(num, max, max_bit, root, 0, 0);
        ret[i] = res;
      }
      i++;
    }
    return ret;
  }

  int dfs(int num, int max, int bit, Node node, int res, int numXOR) {
    if (bit == 0) return res;
    if ((bit & num) != 0) {
      if (node.left == null) {
        if ((numXOR | bit) > max) return -1;
        else return dfs(num, max, bit >> 1, node.right, res, numXOR | bit);
      } else {
        return dfs(num, max, bit >> 1, node.left, res | bit, numXOR);
      }
    } else {
      if ((numXOR | bit) > max && node.left == null) return -1;
      if (node.right == null || (numXOR | bit) > max) {
        return dfs(num, max, bit >> 1, node.left, res, numXOR);
      } else {
        int result = dfs(num, max, bit >> 1, node.right, res | bit, numXOR | bit);
        return result == -1 ? node.left != null ? dfs(num, max, bit >> 1, node.left, res, numXOR) : -1 : result;
      }
    }
  }
}


