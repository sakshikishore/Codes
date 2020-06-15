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
    int max=Integer.MIN_VALUE;
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
    
    public void levelOrder(TreeNode root,int level)
    {
        if(root!=null)
        {
            if(level==0)
            {
                if(root.val>max)
                {
                    max=root.val;
                    
                }
            }
            else
            {
                levelOrder(root.left,level-1);
                levelOrder(root.right,level-1);
                
            }
        }
        
      
            
    }
    
    public List<Integer> largestValues(TreeNode root) {
        ArrayList<Integer> l=new ArrayList<Integer>();
        for(int i=0;i<height(root);i++)
        {
            levelOrder(root,i);
            
            l.add(max);
            max=Integer.MIN_VALUE;
           
        }
        
        return l;
        
    }
}
