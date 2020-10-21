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
    int count=0,j=0,p=0;
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
                if(j==0)
                {
                 count++;
                }
                else
                {
                    p=-1;
                }
            }
            else
            {
                levelOrder(root.left,level-1);
                levelOrder(root.right,level-1);
                
            }
        }
        else
        {
            j++;
        }
    }
    public boolean isCompleteTree(TreeNode root) {
        int treeHeight=height(root);
        boolean result=false;
      for(int i=0;i<treeHeight;i++)
      {
          levelOrder(root,i);
          if(count!=(int)Math.pow(2,i) && i!=treeHeight-1)
          {
              break;
          }
          else
          {
              if(i==treeHeight-1)
              {
                  if(p==0)
                  {
                      result=true;
                  }
                  
              }
          }
          
          count=0;
          j=0;
          p=0;
          
      }
        
        return result;
        
    }
}
