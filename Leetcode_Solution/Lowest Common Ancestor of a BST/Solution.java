/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     public int val;
 *     public TreeNode left;
 *     public TreeNode right;
 *     public TreeNode(int x) { val = x; }
 * }
 */
public class Solution {
    public TreeNode LowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        while(root!=null)
        {
            if(p.val>root.val && q.val>root.val)
            {
                root=root.right;
            }
            else if(p.val<root.val && q.val<root.val)
            {
                root=root.left;
            }
            else
            {
                break;
            }
        }
        return root;
        
    }
}
