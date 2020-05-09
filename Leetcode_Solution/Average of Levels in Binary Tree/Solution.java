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
    public ArrayList<Double> l=new ArrayList<Double>();
     double sum=0.0;
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
    public void levelOrder(TreeNode root,int level)
    {
        if(root!=null)
        {
        if(level==0)
        {
            sum=sum+root.val;
            count++;
        }
        else
        {
            levelOrder(root.left,level-1);
            levelOrder(root.right,level-1);
        }
        }
    }
    public List<Double> averageOfLevels(TreeNode root) {
     
        for(int i=0;i<height(root);i++)
        {
           
            levelOrder(root,i);
            l.add(sum/count);
            sum=0.0;
            count=0;
        }
    
        return l;
    }
}
