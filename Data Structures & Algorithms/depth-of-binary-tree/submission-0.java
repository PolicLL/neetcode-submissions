/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */

class Solution {
    public int maxDepth(TreeNode root) {
        return size(root);
    }

    private int size(TreeNode root) {
        if (root == null) return 0;

        int left = 1 + size(root.left);
        int right = 1 + size(root.right);

        return left > right ? left : right;

    }
}
