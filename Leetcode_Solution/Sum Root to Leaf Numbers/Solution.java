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
    public int sumNumbers(TreeNode root) {
        int sum=0;
        if(root!=null)
        {
         HashMap<TreeNode,Integer> h=new HashMap<TreeNode,Integer>();
         h.put(root,root.val);
         Queue<TreeNode> q=new LinkedList<TreeNode>();
         q.add(root);
         while(q.size()!=0)
         {
             TreeNode temp=q.poll();
             if(temp.left!=null)
             {
                 q.add(temp.left);
                 h.put(temp.left,(h.get(temp)*10)+temp.left.val);
             }
             if(temp.right!=null)
             {
                 q.add(temp.right);
                 h.put(temp.right,(h.get(temp)*10)+temp.right.val);
             }
             if(temp.left==null && temp.right==null)
             {
                   sum=sum+h.get(temp);
                   
             }
         }
        }
        
        return sum;
        
        
    }
}
