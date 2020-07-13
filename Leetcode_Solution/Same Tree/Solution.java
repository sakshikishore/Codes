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
    boolean result=true;
    void p_inorder(TreeNode p, TreeNode q)
    {
        if(p==null && q!=null)
        {
            result=result && false;
        }
       else if(p!=null)
        {
            if(q==null)
            {
                result=result && false;
            }
            else
            {
                p_inorder(p.left,q.left);      
                if(p.val != q.val)
                {
                    result=result && false;
                }
                p_inorder(p.right,q.right);
            }
        }
    }
  
   public boolean isSameTree(TreeNode p, TreeNode q) {
       if((p==null && q!=null) ||(q==null && p!=null))
       {
           result=false;
       }
       else
       {
         p_inorder(p,q);
       }
  
       
       return result;
        
    }
}
