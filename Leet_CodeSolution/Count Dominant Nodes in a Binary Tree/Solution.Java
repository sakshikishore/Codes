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
    int count = 0;

    public void Solve(TreeNode root) {
        if (root != null) {
            Solve(root.left);
            Solve(root.right);
            if (root.left == null && root.right == null) {
                count++;
            } else if (root.left != null && root.right != null && root.left.val <= root.val
                    && root.right.val <= root.val) {
                count++;
            } else if (root.left == null) {
                if (root.right.val > root.val) {
                    root.val = root.right.val;
                } else {
                    count++;
                }
            } else if (root.right == null) {
                if (root.left.val > root.val) {
                    root.val = root.left.val;
                } else {
                    count++;
                }
            } else {
                int max = Math.max(root.left.val, root.right.val);
                root.val = max;
            }
        }
    }

    public int countDominantNodes(TreeNode root) {
        Solve(root);
        return count;
    }
}
