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
    int sum=0;
    public int height(TreeNode root)
    {
        if(root==null)
        {
            return 0;
        }
        else
        {
            int hleft=height(root.left);
            int hright=height(root.right);
            if(hleft>hright)
            {
                return hleft+1;
            }
            else
            {
                return hright+1;
            }
        }
    }
    
    public void levelOrder(TreeNode root, int level)
    {
        if(root!=null)
        {
            if(level==0)
            {
                if(root.val%2==0)
                {
                    if(root.left!=null)
                    {
                        if(root.left.left!=null)
                        {
                            sum=sum+root.left.left.val;
                        }
                         if(root.left.right!=null)
                        {
                            sum=sum+root.left.right.val;
                        }
                    }
                    if(root.right!=null)
                    {
                        if(root.right.left!=null)
                        {
                            sum=sum+root.right.left.val;
                        }
                        if(root.right.right!=null)
                        {
                            sum=sum+root.right.right.val;
                        }
                    }
                    
                }
            }
            else
            {
                levelOrder(root.left,level-1);
                levelOrder(root.right,level-1);
            }
        }
    }
    public int sumEvenGrandparent(TreeNode root) {
        
        for(int i=0;i<height(root)-2;i++)
        {
          levelOrder(root,i);
        }
        
        return sum;
        
    }
}
