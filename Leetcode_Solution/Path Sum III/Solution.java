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
    public int pathSum(TreeNode root, int sum) {
        int result=0;
        if(root!=null)
        {
        HashSet<String> t=new HashSet<String>();
        HashMap<TreeNode,String> h=new HashMap<TreeNode,String>();
        Queue<TreeNode> q=new LinkedList<TreeNode>();
         q.add(root);
         h.put(root,Integer.toString(root.val));
         while(q.size()!=0)
         {
             TreeNode temp=q.poll();
             String p[]=h.get(temp).split(" ");
             if(p.length==1)
             {
                 int x=Integer.parseInt(p[0]);
                 if(x==sum)
                 {
                     result++;
                 }
             }
             else
             {
                 long total=0;
                 for(int i=0;i<p.length;i++)
                 {
                     total+=Integer.parseInt(p[i]);
                 }
                 if(total==sum)
                 {
                     result++;
                 }
                 for(int i=0;i<p.length-1;i++)
                 {
                     total=total-Integer.parseInt(p[i]);
                     if(total==sum)
                     {
                         result++;
                     }
                 }
             }
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
        
        return result;
        
    }
}
