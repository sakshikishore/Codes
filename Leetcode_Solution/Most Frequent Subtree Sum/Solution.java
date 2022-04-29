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
    public int[] findFrequentTreeSum(TreeNode root) {
        HashMap<Integer,Integer> h=new HashMap<Integer,Integer>();
        ArrayList<Integer> l=new ArrayList<Integer>();
        int max=0;
        if(root!=null)
        {
            Queue<TreeNode> q=new LinkedList<TreeNode>();
            q.add(root);
            while(q.size()>0)
            {
                TreeNode temp=q.poll();
                TreeNode ptr=temp;
                if(ptr!=null)
                {
                     Queue<TreeNode> queue=new LinkedList<TreeNode>();
                     queue.add(ptr);
                     int sum=0;
                     while(queue.size()>0)
                     {
                         TreeNode t=queue.poll();
                         sum+=t.val;
                         if(t.left!=null)
                         {
                             queue.add(t.left);
                         }
                         if(t.right!=null)
                         {
                             queue.add(t.right);
                         }
                         
                     }
                     
                    if(!h.containsKey(sum))
                    {
                        h.put(sum,1);
                    }
                    else
                    {
                        h.put(sum,h.get(sum)+1);
                    }
                    
                    if(h.get(sum)>max)
                    {
                        max=h.get(sum);
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
        
        for(Map.Entry<Integer,Integer> entry: h.entrySet())
        {
            if(entry.getValue()==max)
            {
                l.add(entry.getKey());
            }
        }
        
        int arr[]=new int[l.size()];
        for(int i=0;i<arr.length;i++)
        {
            arr[i]=l.get(i);
        }
    
        return arr;
    }
}
