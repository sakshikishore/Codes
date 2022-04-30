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
    public TreeNode lcaDeepestLeaves(TreeNode root) {
        TreeNode result=null;
        int totalLeafNode=0;
        int h=height(root);
        ArrayList<TreeNode> l=new ArrayList<TreeNode>();
        if(root!=null)
        {
            Queue<TreeNode> q=new LinkedList<TreeNode>();
            q.add(root);
            q.add(null);
            int count=1;
            while(q.size()>0)
            {
                TreeNode temp=q.poll();
                if(count==h && temp!=null)
                {
                    l.add(temp);
                }
                if(temp==null)
                {
                    count++;
                    if(q.size()>0)
                    {
                        q.add(null);
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
            q.add(root);
            while(q.size()>0)
            {
                  TreeNode temp=q.poll();
                   h=height(temp);  
                   count=1;
                   Queue<TreeNode> queue=new LinkedList<TreeNode>();
                   queue.add(temp);
                   queue.add(null);
                   int flag=1;
                   ArrayList<TreeNode> p=new ArrayList<TreeNode>();
                   while(queue.size()>0)
                   {
                       TreeNode t=queue.poll();
                       if(t==null)
                       {
                           count++;
                           if(queue.size()>0)
                           {
                               queue.add(null);
                           }
                       }
                       else
                       {
                           if(count==h)
                           {
                               p.add(t);
                           }
                           if(t.left!=null)
                           {
                               queue.add(t.left);
                           }
                           if(t.right!=null)
                           {
                               queue.add(t.right);
                           }
                       }
                   }
                 if(p.size()==l.size())
                 {
                     for(int i=0;i<p.size();i++)
                     {
                         if(l.get(i).val!=p.get(i).val)
                         {
                             flag=0;
                             break;
                         }
                     }
                     
                     if(flag==1)
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
                
                
            }
        
    
    
    return result;
        
        
        
        
    }
}
