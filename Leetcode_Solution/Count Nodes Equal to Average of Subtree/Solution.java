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
    public int averageOfSubtree(TreeNode root) {
        Queue<TreeNode> q=new LinkedList<TreeNode>();
        q.add(root);
        int result=0;
        while(q.size()>0)
        {
            TreeNode temp=q.poll();
            Queue<TreeNode> qu=new LinkedList<TreeNode>();
            qu.add(temp);
            int count=0,sum=0;
            while(qu.size()>0)
            {
                TreeNode t=qu.poll();
                sum+=t.val;
                count++;
                if(t.left!=null)
                {
                    qu.add(t.left);
                }
                if(t.right!=null)
                {
                    qu.add(t.right);
                }
            }
            int p=sum/count;
            if(p==temp.val)
            {
                result++;
            }
            if(temp.left!=null)
            {
                q.add(temp.left);
            }
            if(temp.right!=null)
            {
                q.add(temp.right);
            }
        }
        
        return result;
    }
}
