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
    public List<TreeNode> generateBST(int start, int end)
    {
         ArrayList<TreeNode> list=new ArrayList<TreeNode>();
        if(start>end)
        {
            list.add(null);
            return list;
        }
        for(int i=start;i<=end;i++)
        {
            for(TreeNode left:generateBST(start,i-1))
            {
                for(TreeNode right : generateBST(i+1,end))
                {
                    TreeNode root=new TreeNode(i);
                    root.left=left;
                    root.right=right;
                    list.add(root);

                }
            }
        }

        return list;
    }
    public List<TreeNode> generateTrees(int n) {
        return generateBST(1,n);
    }
}
