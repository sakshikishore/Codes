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
    int mindepth=1;
    public int minDepth(TreeNode root) {
        if(root==null)
        {
            return 0;
        }
        else
        {
            Queue<TreeNode> q=new LinkedList<TreeNode>();
            q.add(root);
            q.add(null);
            while(q.size()>0)
            {
                TreeNode temp=q.poll();
                if(temp!=null)
                {
                    if(temp.left==null && temp.right==null)
                    {
                        break;
                    }
                    else
                    {
                        if(temp.left!=null)
                        {
                            q.add(temp.left);
                        }
                        if(temp.right!=null)
                        {
                            q.add(temp.right);
                        }
                    }
                }
                else
                {
                    if(q.size()>0)
                    {
                        mindepth++;
                        q.add(null);
                    }
                }
            }
        }
        
        return mindepth;
    }
}
