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
    public List<Integer> inorderTraversal(TreeNode root) {
        ArrayList<Integer> res=new ArrayList<Integer>();
        Stack<TreeNode> stck=new Stack<TreeNode>();
        int flag=0;
        TreeNode currentNode=root;
        while(flag!=1)
        {
            if(currentNode!=null)
            {
                stck.push(currentNode);
                currentNode=currentNode.left;
            }
            else
            {
                if(stck.empty())
                {
                    flag=1;
                    break;
                }
                else
                {
                    TreeNode temp=stck.pop();
                    res.add(temp.val);
                    if(temp.right!=null)
                    {
                        currentNode=temp.right;
                    }
                }
            }
        }
      return res;
        
    }
}
