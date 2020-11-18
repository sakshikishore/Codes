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
    public void InOrder(TreeNode root, ArrayList<Integer> list)
    {
        if(root!=null)
        {
            InOrder(root.left,list);
            if(root.left==null && root.right==null)
            {
                list.add(root.val);
            }
            InOrder(root.right,list);         
        }
    }
    public boolean leafSimilar(TreeNode root1, TreeNode root2) {
        boolean result=true;
        if(root1==null && root2==null)
        {
            result=true;
        }
        else if(root1==null || root2==null)
        {
            result=false;
        }
        else
        {
            ArrayList<Integer> l=new ArrayList<Integer>();
            ArrayList<Integer> m=new ArrayList<Integer>();
            InOrder(root1, l);
            InOrder(root2,m);
            if(l.size()!=m.size())
            {
                result=false;
            }
            else
            {
                for(int i=0;i<l.size();i++)
                {
                    if(l.get(i)!=m.get(i))
                    {
                        result=false;
                        break;
                    }
                }
            }
        }
        
        
        return result;
        
    }
}
