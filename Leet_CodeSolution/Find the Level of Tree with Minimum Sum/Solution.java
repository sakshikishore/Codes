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
    public int minimumLevel(TreeNode root) {
        Queue<TreeNode> q=new LinkedList<TreeNode>();
        q.add(root);
        long min=root.val;
        int res=1;
        int level=0;
        while(q.size()>0)
        {
            level++;
            int len=q.size();
            long sum=0;
            for(int i=0;i<len;i++)
            {
               TreeNode temp=q.poll();
               sum+=temp.val;
               if(temp.left!=null)
               {
                q.add(temp.left);
               }
               if(temp.right!=null)
               {
                q.add(temp.right);
               }
            }
            if(sum<min)
            {
                res=level;
                min=sum;
            }
        }

        return res;
    }
}
