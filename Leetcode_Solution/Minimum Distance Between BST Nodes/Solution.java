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
    
    public int minDiffInBST(TreeNode root) {
       int min=Integer.MAX_VALUE;
       Queue<TreeNode> q=new LinkedList<TreeNode>();
        ArrayList<Integer> l=new ArrayList<Integer>();
        q.add(root);
        while(q.size()!=0)
        {
            TreeNode temp=q.poll();
            l.add(temp.val);
            if(temp.left!=null)
            {
                q.offer(temp.left);
                
            }
            if(temp.right!=null)
            {
                q.offer(temp.right);
                
            }
        }
        Collections.sort(l);
        for(int i=1;i<l.size();i++)
        {
            if(l.get(i)-l.get(i-1)<min)
            {
                min=l.get(i)-l.get(i-1);
            }
        }
        
        return min;
        
        
    }
}
