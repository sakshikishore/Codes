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
     ArrayList<Integer> list=new ArrayList<Integer>();
    int count=0;
    public void InOrder(TreeNode root)
    {
        if(root!=null)
        {
            InOrder(root.left);
            if(list.get(count)!=root.val)
            {
                root.val=list.get(count);
            }
            count++;
            InOrder(root.right);
        }
    }
    public void recoverTree(TreeNode root)
    {
        Stack<TreeNode> stck=new Stack<TreeNode>();
        int flag=0;
        TreeNode current=root;
        while(flag!=1)
        {
            if(current!=null)
            {
                stck.push(current);
                current=current.left;
            }
            else
            {
                if(stck.empty())
                {
                    flag=1;
                }
                else
                {
                    current=stck.pop();
                    list.add(current.val);
                    current=current.right;
                }
            }
        }
        
        Collections.sort(list);
        InOrder(root);
       
       
    }
}
