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
    public boolean levelOrder(TreeNode root,TreeNode subRoot)
    {
        boolean result=true;
         Queue<TreeNode> q1=new LinkedList<TreeNode>();
         Queue<TreeNode> q2=new LinkedList<TreeNode>();
        q1.add(root);
        q2.add(subRoot);
        while(q1.size()>0 && q2.size()>0 && q1.size()==q2.size())
        {
            TreeNode temp1=q1.poll();
            TreeNode temp2=q2.poll();
            if(temp1.val!=temp2.val)
            {
                result=false;
                break;
            }
            if(temp1.left!=null && temp2.left!=null)
            {
                q1.add(temp1.left);
                q2.add(temp2.left);
            }
            else if((temp1.left==null && temp2.left!=null)||(temp1.left!=null && temp2.left==null))
            {
                result=false;
                break;
            }
            if(temp1.right!=null && temp2.right!=null)
            {
                q1.add(temp1.right);
                q2.add(temp2.right);
            }
            else if((temp1.right==null && temp2.right!=null)||(temp1.right!=null && temp2.right==null))
            {
                result=false;
                break;
            }
        }
        if(q1.size()!=q2.size())
        {
            result=false;
        }
        
        return result;
    }
    public boolean isSubtree(TreeNode root, TreeNode subRoot) {
        boolean result=false;
        Queue<TreeNode> q=new LinkedList<TreeNode>();
        q.add(root);
        while(q.size()>0)
        {
            TreeNode temp=q.poll();
           result=levelOrder(temp,subRoot);
            if(result)
            {
                break;
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
