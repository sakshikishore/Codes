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
    int sum=0;
    ArrayList<Integer> l;
    public void Inorder(TreeNode root)
    {
        if(root!=null)
        {
            Inorder(root.left);
            sum+=root.val;
            l.add(root.val);
            Inorder(root.right);
        }
    }
    public TreeNode convertBST(TreeNode root) {
        l=new ArrayList<Integer>();
        HashMap<Integer,Integer> h=new HashMap<Integer,Integer>();
        Inorder(root);
        for(int i=0;i<l.size();i++)
        {
            if(i==0)
            {
             h.put(l.get(i),sum);
            }
            else
            {
                sum=sum-l.get(i-1);
                h.put(l.get(i),sum);
            }
        }
        
        if(root!=null)
        {
            Queue<TreeNode> q=new LinkedList<TreeNode>();
            q.add(root);
            while(q.size()>0)
            {
                TreeNode temp=q.poll();
                temp.val=h.get(temp.val);
                if(temp.left!=null)
                {
                    q.add(temp.left);
                }
                if(temp.right!=null)
                {
                    q.add(temp.right);
                }
            }
        }
        
        return root;
        
    }
}
