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
    ArrayList<Integer> t=new ArrayList<Integer>();
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
    public void level(TreeNode root, int level)
    {
        if(root!=null)
        {
            if(level==0)
            {
                t.add(root.val);
            }
            else
            {
                level(root.left,level-1);
                level(root.right,level-1);
            }
        }
    }
    public int kthSmallest(TreeNode root, int k) {
        for(int i=0;i<height(root);i++)
        {
            level(root,i);
        }
        Collections.sort(t);
        
        return t.get(k-1);
        
    }
}
