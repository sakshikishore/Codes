/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
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
    ArrayList<Integer> l=new ArrayList<Integer>();
    
    public void levelOrder(TreeNode root,int level)
    {
        if(root!=null)
        {
        if(level==0)
        {
          
               
                l.add(root.val);
          
        }
        else
        {
            levelOrder(root.left,level-1);
             levelOrder(root.right,level-1);
        }
        }
    }
    
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        
        List<List<Integer>> ls = new ArrayList();
        for(int i=0;i<height(root);i++)
        {
          
            levelOrder(root,i);
            ls.add(l);
            
             l=new ArrayList<Integer>();
        }
        Collections.reverse(ls);
        return ls;
    }
}
