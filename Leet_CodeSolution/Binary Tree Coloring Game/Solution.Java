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
    HashMap<Integer,Integer> h=new HashMap<Integer,Integer>();
    boolean result=false;
    public void postOrder(TreeNode root, int n, int x)
    {
        if(root!=null)
        {
            postOrder(root.left,n,x);
            postOrder(root.right,n,x);
            if(root.left==null && root.right==null)
            {
                 h.put(root.val,1);
                 if(root.val==x)
                 {
                    result=true;
                 }
            }
            else
            {
                int c=1;
                if(root.left!=null)
                {
                    c+=h.get(root.left.val);
                }
                if(root.right!=null)
                {
                    c+=h.get(root.right.val);
                }

                h.put(root.val,c);
                if(root.val==x)
                {
                    if(root.left!=null)
                    {
                        if(h.get(root.left.val)>n-h.get(root.left.val))
                        {
                            result=true;
                        }
                    }
                    if(root.right!=null)
                    {
                        if(h.get(root.right.val)>n-h.get(root.right.val))
                        {
                            result=true;
                        } 
                    }
                    if(c<n-c)
                    {
                         result=true;
                    }
                }
            }

        }
    }
    public boolean btreeGameWinningMove(TreeNode root, int n, int x) {
        postOrder(root,n,x);
        return result;
    }
}
