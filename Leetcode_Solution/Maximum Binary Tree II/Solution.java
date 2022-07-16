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
     ArrayList<Integer> l=new ArrayList<Integer>();
    public TreeNode Construct(ArrayList<Integer> l, int start,int end)
    {
        if(start>end)
        {
            return null;
        }
        int max=0;
        int index=0;
        for(int i=start;i<=end;i++)
        {
            if(l.get(i)>max)
            {
                max=l.get(i);
                index=i;
            }
        }
        TreeNode root=new TreeNode(l.get(index),null,null);
        root.left=Construct(l,start,index-1);
        root.right=Construct(l,index+1,end);
        
        return root;
    }
    public void InOrder(TreeNode root)
    {
        if(root!=null)
        {
            InOrder(root.left);
            l.add(root.val);
            InOrder(root.right);
        }
    }
    public TreeNode insertIntoMaxTree(TreeNode root, int val) {
        InOrder(root); 
        l.add(val);
       return Construct(l,0,l.size()-1);
    }
}
