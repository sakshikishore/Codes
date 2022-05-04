/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
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
    public boolean isSubPath(ListNode head, TreeNode root) {
        boolean result=false;
        HashMap<TreeNode,String> h=new HashMap<TreeNode,String>();
        HashMap<TreeNode,String> m=new HashMap<TreeNode,String>();
        Queue<TreeNode> q=new LinkedList<TreeNode>();
        q.add(root);
        h.put(root,Integer.toString(root.val));
        while(q.size()>0)
        {
            TreeNode temp=q.poll();
            if(temp.left==null && temp.right==null)
            {
                m.put(temp,h.get(temp));
            }
            else
            {
                if(temp.left!=null)
                {
                    q.add(temp.left);
                    h.put(temp.left,h.get(temp)+" "+Integer.toString(temp.left.val));
                }
                if(temp.right!=null)
                {
                    q.add(temp.right);
                    h.put(temp.right,h.get(temp)+" "+Integer.toString(temp.right.val));
                }
            }
        }
        
        ArrayList<Integer> l=new ArrayList<Integer>();
        while(head!=null)
        {
            l.add(head.val);
            head=head.next;
        }
        
        for(Map.Entry<TreeNode,String> entry:m.entrySet())
        {
            ArrayList<Integer> index=new ArrayList<Integer>();
            String p[]=entry.getValue().split(" ");
            for(int i=0;i<p.length;i++)
            {
                if(Integer.parseInt(p[i])==l.get(0))
                {
                    index.add(i);
                }
            }
            
            for(int i=0;i<index.size();i++)
            {
                if(p.length-index.get(i)>=l.size())
                {
                    int r=0,flag=0;
                    for(int j=index.get(i);j<=p.length;j++)
                    {
                        if(l.get(r)!=Integer.parseInt(p[j]))
                        {
                            flag=1;
                            break;
                        }
                        else
                        {
                            r++;
                            if(r==l.size())
                            {
                                break;
                            }
                        }
                    }
                    if(flag==0)
                    {
                        result=true;
                    }
                }
                else
                {
                    break;
                }
                if(result)
                {
                    break;
                }
            }
             if(result)
                {
                    break;
                }
        }
        
        
        return result;
        
        
    }
}
