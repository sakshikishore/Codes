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
    public TreeNode removeLeafNodes(TreeNode root, int target) {
        int flag=0;
        while(flag!=1)
        {
            flag=1;
            if(root!=null)
            {            
                if(root.left==null && root.right==null && root.val==target)
                {
                    root=null;
                    flag=1;
                }
                else
                {
                    Queue<TreeNode> q=new LinkedList<TreeNode>();
                    q.add(root);
                    while(q.size()!=0)
                    {
                        TreeNode temp=q.poll();
                        if(temp.left!=null)
                        {
                           if(temp.left.left==null && temp.left.right==null && temp.left.val==target)
                           {
                               temp.left=null;
                               flag=0;
                           }
                            else
                            {
                                q.add(temp.left);
                            }
                            
                        }
                        if(temp.right!=null)
                        {
                           if(temp.right.left==null && temp.right.right==null && temp.right.val==target)
                           {
                               temp.right=null;
                               flag=0;
                           }
                            else
                            {
                                q.add(temp.right);
                            }
                            
                        }
                    }
                }
            }
        }
        
        return root;
        
    }
}
