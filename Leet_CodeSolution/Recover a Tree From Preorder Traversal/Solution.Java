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
    public TreeNode Solve(String str, TreeNode root,int count, String st[])
    {
        if(str.length()==0)
        {
            return null;
        }
        int index=str.indexOf("-");
        if(index==-1)
        {
             root=new TreeNode(Integer.parseInt(str),null,null);
        }
        else
        {
           root=new TreeNode(Integer.parseInt(str.substring(0,index)),null,null);    
           int p=index+count;
           int flag=0;
           String s="";
           for(int i=0;i<count;i++)
           {
              s=s+"-";
           }
           for(int i=0;i<=9;i++)
           {
                for(int j=0;j<=9;j++)
                {
                    String temp=st[i]+s+st[j];
                    int r=str.lastIndexOf(temp);
                    if(r+1!=index && r!=-1)
                    {
                       flag=1;
                       root.left=Solve(str.substring(p,r+1),root,count+1,st);
                       root.right=Solve(str.substring(r+1+count),root,count+1,st);
                       break;
                    }
                }
                if(flag==1)
                {
                    break;
                }
           }

           if(flag==0)
           {
            root.left=Solve(str.substring(p),root,count+1,st);
           }
        }

        return root;
    }
    public TreeNode recoverFromPreorder(String traversal) {
        TreeNode root=null;
        String s1[]={"0","1","2","3","4","5","6","7","8","9"};
        return Solve(traversal,root,1,s1);
    }
}
