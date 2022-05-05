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
    public int height(TreeNode root)
    {
        if(root==null)
        {
            return 0;
        }
        else
        {
            int hleft=height(root.left);
            int hright=height(root.right);
            if(hleft>hright)
            {
                return hleft+1;
            }
            else
            {
                return hright+1;
            }
        }
    }
    public TreeNode subtreeWithAllDeepest(TreeNode root) {
        TreeNode result=null;
        Queue<TreeNode> q=new LinkedList<TreeNode>();
        int h=height(root);
        q.add(root);
        q.add(null);
        ArrayList<TreeNode> l=new ArrayList<TreeNode>();
        int i=1;
        while(q.size()>0)
        {
            TreeNode temp=q.poll();
            if(temp==null)
            {
                i++;
                if(q.size()>0)
                {
                    q.add(null);
                }
            }
            else
            {
                 if(i==h)
                 {
                    l.add(temp);
                  }
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
        
        q.add(root);
        while(q.size()>0)
        {
            TreeNode temp=q.poll();
            Queue<TreeNode> q1=new LinkedList<TreeNode>();
            h=height(temp);
            q1.add(temp);
            q1.add(null);
            ArrayList<TreeNode> l1=new ArrayList<TreeNode>();
            i=1;
            while(q1.size()>0)
           {
            TreeNode temp1=q1.poll();
            if(temp1==null)
            {
                i++;
                if(q1.size()>0)
                {
                    q1.add(null);
                }
            }
            else
            {
                if(i==h)
                {
                    l1.add(temp1);
                }
                if(temp1.left!=null)
                {
                    q1.add(temp1.left);
                }
                if(temp1.right!=null)
                {
                    q1.add(temp1.right);
                }
            }
            
         }
            boolean flag=true;
            if(l.size()==l1.size())
            {
                for(int j=0;j<l.size();j++)
                {
                    if(l.get(j).val!=l1.get(j).val)
                    {
                        flag=false;
                        break;
                    }
                }
                if(flag)
                {
                    result=temp;
                }
            }
            
            
            if(temp.left!=null)
                {
                    q.add(temp.left);
                }
                if(temp.right!=null)
                {
                    q.add(temp.right);
                }
            
        }
        
        return result;
    }
}
