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
    public int widthOfBinaryTree(TreeNode root) {
        HashMap<TreeNode,Integer> h=new HashMap<TreeNode,Integer>();
        Queue<TreeNode> q=new LinkedList<TreeNode>();
        q.add(root);
        h.put(root,0);
        int ans=1;
        while(q.size()>0)
        {
            int len=q.size();
            int min=-1,max=-1;
            for(int i=0;i<len;i++)
            {
                TreeNode temp=q.poll();
                if(min==-1)
                {
                    min=h.get(temp);
                }
                else
                {
                    max=h.get(temp);
                }
                if(temp.left!=null)
                {
                    q.add(temp.left);
                    h.put(temp.left,2*h.get(temp)+1);
                }
                if(temp.right!=null)
                {
                    q.add(temp.right);
                    h.put(temp.right,2*h.get(temp)+2);
                }
            }

            if(max!=-1)
            {
                ans=Math.max(ans,max-min+1);
            }
        }

        return ans;
    }
}
