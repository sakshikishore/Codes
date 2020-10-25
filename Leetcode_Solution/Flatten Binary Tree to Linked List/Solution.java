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
    ArrayList<Integer> l=new ArrayList<Integer>();
    public void PreOrder(TreeNode root)
    {
        if(root!=null)
        {
            l.add(root.val);
            PreOrder(root.left);         
            PreOrder(root.right);
        }
    }
    public void flatten(TreeNode root) {
        PreOrder(root);
        TreeNode head=null;
        int i=0; 
        TreeNode ptr=root;
        while(i<l.size())
        {
            TreeNode Node=new TreeNode(l.get(i),null,null);
            if(ptr.val!=Node.val)
            {
                ptr.val=Node.val;
            }
            if(ptr.left!=null)
            {
                ptr.left=null;
            }
            if(ptr.right!=null)
            {
                ptr=ptr.right;

            }
            else
            {
                if(i<l.size()-1)
                {
                 ptr.right=Node;
                 ptr=ptr.right;
                }
            }
            i++;
        }
                           
    }
}
