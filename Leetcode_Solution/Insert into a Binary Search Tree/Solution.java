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
    public TreeNode insertIntoBST(TreeNode root, int val) {
        if(root!=null)
        {
           Queue<TreeNode> q=new LinkedList<TreeNode>();
            q.add(root);
            while(q.size()!=0)
            {
                TreeNode temp=q.poll();
                if(temp.val>val)
                {
                    if(temp.left!=null)
                    {
                        q.add(temp.left);
                    }
                    else
                    {
                        temp.left=new TreeNode(val,null,null);
                        break;
                    }
                }
                else
                {
                    if(temp.right!=null)
                    {
                        q.add(temp.right);
                    }
                    else
                    {
                        temp.right=new TreeNode(val,null,null);
                        break;
                    }
                }
            }
        }
        else
        {
            root=new TreeNode(val,null,null);
        }
        
        return root;
    }
}
