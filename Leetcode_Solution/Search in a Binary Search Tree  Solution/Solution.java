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
    TreeNode result=null;
    public int height(TreeNode root)
    {
        if(root==null)
        {
            return 0;
        }
        else
        {
           int hleft= height(root.left);
           int hright= height(root.right);
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
    public void levelorder(TreeNode root,int level, int val)
    {
        if(root!=null)
        {
            if(level==0)
            {
                if(root.left!=null)
                {
                    if(root.left.val==val)
                    {
                        result=root.left;
                        root.left=null;
                        root.right=null;
                    }
                }
                if(root.right!=null)
                {
                    if(root.right.val==val)
                    {
                        result=root.right;
                        root.left=null;
                        root.right=null;
                    }
                }
            }
            else
            {
                levelorder(root.left,level-1,val);
                levelorder(root.right,level-1,val);
            }
            
            
        }
    }
    public TreeNode searchBST(TreeNode root, int val) {
        if(root.val==val)
        {
            result=root;
        }
        else
        {
        for(int i=0;i<height(root);i++)
        {
            if(result!=null)
            {
                break;
            }
            levelorder(root,i,val);
        }
        }
        
        return result;
        
        
    }
}
