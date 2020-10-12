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
    HashMap<TreeNode,Integer> h=new HashMap<TreeNode,Integer>();
    int count=0;
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
       
    public void levelOrder(TreeNode root,int level,int g)
    {
       if(root!=null)
       {
           if(level==0)
           {
              if(g==0)
              {
                  count++;
                  if(root.left!=null)
                  {
                      if(root.left.val>=root.val)
                      {
                          h.put(root.left,root.left.val);
                          count++;
                      }
                      else
                      {
                          h.put(root.left,root.val);
                      }
                  }
                  if(root.right!=null)
                  {
                      if(root.right.val>=root.val)
                      {
                          h.put(root.right,root.right.val);
                          count++;
                      }
                      else
                      {
                          h.put(root.right,root.val);
                      }
                  }
              }
               else
               {
                   int max=h.get(root);
                    if(root.left!=null)
                  {
                      if(root.left.val>=max)
                      {
                          h.put(root.left,root.left.val);
                          count++;
                      }
                      else
                      {
                          h.put(root.left,max);
                      }
                  }
                  if(root.right!=null)
                  {
                      if(root.right.val>=max)
                      {
                          h.put(root.right,root.right.val);
                          count++;
                      }
                      else
                      {
                          h.put(root.right,max);
                      }
                  }
               }
              }
           else
           {
               levelOrder(root.left,level-1,g);
               levelOrder(root.right,level-1,g);
           }
           }
       }
    
    public int goodNodes(TreeNode root) {
        for(int i=0;i<height(root);i++)
        {
            levelOrder(root,i,i);
        }
        
        return count;
    }
}
