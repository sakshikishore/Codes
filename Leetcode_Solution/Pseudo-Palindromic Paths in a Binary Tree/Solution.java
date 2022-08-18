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
    public int pseudoPalindromicPaths (TreeNode root) {
        Queue<TreeNode> q=new LinkedList<TreeNode>();
        q.add(root);
        HashMap<TreeNode,int []> h=new HashMap<TreeNode,int []>();
        int ch[]=new int[10];
        ch[root.val]++; 
        h.put(root,ch);
        int result=0;
         while(q.size()>0)
         {
             TreeNode temp=q.poll();
             if(temp.left==null && temp.right==null)
             {
                int arr[]=h.get(temp);
                 int count=0;
                for(int i=1;i<=9;i++)
                {
                    if(arr[i]%2!=0)
                    {
                        count++;
                        if(count>1)
                        {
                            break;
                        }
                    }
                }
                 
                if(count<2)
                {
                    result++;
                }
             }
             else
             {
                 if(temp.left!=null)
                 {
                     int arr[]=h.get(temp);
                     int c[]=new int[10];
                     for(int i=1;i<=9;i++)
                     {
                         c[i]=arr[i];
                     }
                     c[temp.left.val]++;
                     h.put(temp.left,c);
                     q.add(temp.left);
                 }
                 if(temp.right!=null)
                 {
                     int arr[]=h.get(temp);
                     int c[]=new int[10];
                     for(int i=1;i<=9;i++)
                     {
                         c[i]=arr[i];
                     }
                     c[temp.right.val]++;
                     h.put(temp.right,c);
                     q.add(temp.right);
                 }
             }
         }
        
        return result;
    }
}
