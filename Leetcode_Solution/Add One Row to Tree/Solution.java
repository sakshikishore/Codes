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
    public TreeNode addOneRow(TreeNode root, int val, int depth) {
        if(depth==1)
        {
            TreeNode p=new TreeNode(val,null,null);
            p.left=root;
            root=p;
        }
        else
        {
        Queue<TreeNode> q=new LinkedList<TreeNode>();
        q.add(root);
        q.add(null);
        int i=1;
        while(q.size()!=0)
        {
             
            TreeNode temp=q.poll();
           
            if(temp!=null)
            {
            if(depth==i+1)
            {
                if(temp.left!=null)
                {
                    TreeNode p=new TreeNode(val,null,null);
                    TreeNode r=temp.left;
                    temp.left=p;
                    temp.left.left=r;
                    
                }
                else
                {
                    TreeNode p=new TreeNode(val,null,null);
                    temp.left=p;
                }
                if(temp.right!=null)
                {
                    TreeNode p=new TreeNode(val,null,null);
                    TreeNode r=temp.right;
                    temp.right=p;
                    temp.right.right=r;
                    
                }
                else
                {
                     TreeNode p=new TreeNode(val,null,null);
                    temp.right=p;
                }
            }
            else
            {
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
            else
            {
                i++;
                if(i==depth)
                {
                    break;
                }
                if(q.size()!=0)
                {
                    q.add(null);
                }
            }
            
        }
        }
        return root;
        
    }
}
