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
    TreeNode root1=null;
    TreeNode k=null;
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
                l.add(root.val);
            }
            else
            {
                levelOrder(root.left,level-1);
                levelOrder(root.right,level-1);
            }
        }
    }
    public TreeNode increasingBST(TreeNode root) {
        for(int i=0;i<height(root);i++)
        {
            levelOrder(root,i);
        }
        Collections.sort(l);
        
        int i=0;
        while(i<l.size())
        {
            TreeNode p=new TreeNode(l.get(i),null,null);
            if(root1==null)
            {
                
                root1=p;
                k=root1;
            }
            else
            {
                k.right=p;
                k=k.right;
            }
            i++;
        }
        
        return root1;
        
    }
}
