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
    public TreeNode solve(int pre[],int preStart,int preEnd, int post[], int postStart,int postEnd)
    {
        if(preStart>preEnd || postStart>postEnd)
        {
            return null;
        }
        TreeNode root=new TreeNode(pre[preStart]);
        if(preStart==preEnd)
        {
            return root;
        }
        if(preStart+1<pre.length)
        {
           int x=postStart;
           while(post[x]!=pre[preStart+1])
           {
               x++;
           }
           int totalElement=x+1-postStart;
        root.left=solve(pre,preStart+1,preStart+totalElement,post,postStart,x);
        root.right=solve(pre,preStart+totalElement+1,preEnd,post,x+1,postEnd-1);
        }
        return root;
    }
    public TreeNode constructFromPrePost(int[] preorder, int[] postorder) {
        return solve(preorder,0,preorder.length-1,postorder,0,postorder.length-1);
    }
}
