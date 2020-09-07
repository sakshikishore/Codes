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
    ArrayList<Integer> l=new ArrayList<Integer>();
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
                l.add(root.val);
            }
            else
            {
                levelOrder(root.left,level-1);
                levelOrder(root.right,level-1);
            }
        }
    }
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> list = new ArrayList<>();
        for(int i=0;i<height(root);i++)
        {
            levelOrder(root,i);
            if(i%2==0)
            {
                list.add(l);
            }
            else
            {
                ArrayList<Integer> k=new ArrayList<Integer>();
                for(int j=l.size()-1;j>=0;j--)
                {
                    k.add(l.get(j));
                }
                list.add(k);
            }
             l=new ArrayList<Integer>();
        }
        
        return list;
        
        
    }
}
