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
    public List<TreeNode> allPossibleFBT(int n) {
        if(n==1)
        {
            ArrayList<TreeNode> l=new ArrayList<TreeNode>();
            l.add(new TreeNode(0,null,null));
            return l;
        }
        ArrayList<TreeNode> list=new ArrayList<TreeNode>();
        for(int k=1;k<n;k=k+2)
        {
            List<TreeNode> left=allPossibleFBT(k);
            List<TreeNode> right=allPossibleFBT(n-k-1);
            for(int i=0;i<left.size();i++)
            {
                for(int j=0;j<right.size();j++)
                {
                    TreeNode root=new TreeNode(0,null,null);
                    root.left=left.get(i);
                    root.right=right.get(j);
                    list.add(root);
                }
            }
        }
        
        return list;
        
    }
}
