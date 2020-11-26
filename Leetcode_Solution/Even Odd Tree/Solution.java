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
    public boolean isEvenOddTree(TreeNode root) {
        boolean result=true;
        if(root!=null)
        {
            if(root.val%2==0)
            {
                result=false;
            }
            else
            {
                 int min=-1;
                 int max=1000001;
                Queue<TreeNode> q=new LinkedList<TreeNode>();
                q.add(root);
                q.add(null);
                int i=0;
                ArrayList<Integer> l=new ArrayList<Integer>();
                while(q.size()!=0)
                {
                    TreeNode temp=q.poll();
                    if(temp!=null)
                    {
                        if(temp.left!=null)
                        {
                            if(i%2==0)
                            {
                                if(temp.left.val%2!=0 || temp.left.val>=max)
                                {
                                    result=false;
                                    break;
                                }
                                else
                                {
                                    max=temp.left.val;
                                }
                            }
                            else
                            {
                                if(temp.left.val%2==0 || temp.left.val<=min)
                                {
                                    result=false;
                                    break;
                                }
                                else
                                {
                                    min=temp.left.val;
                                }
                            }
                            q.add(temp.left);
                        }
                        if(temp.right!=null)
                        {
                              if(i%2==0)
                            {
                                if(temp.right.val%2!=0 || temp.right.val>=max)
                                {
                                    result=false;
                                    break;
                                }
                                else
                                {
                                    max=temp.right.val;
                                }
                            }
                            else
                            {
                                if(temp.right.val%2==0 || temp.right.val<=min)
                                {
                                    result=false;
                                    break;
                                }
                                else
                                {
                                    min=temp.right.val;
                                }
                            }
                            q.add(temp.right);
                        }
                    }
                    else
                    {
                        if(q.size()!=0)
                        {
                            i++;
                            min=-1;
                            max=1000001;
                            q.add(null);
                        }
                    }
                }
            }
        }
        
        return result;
        
    }
}
