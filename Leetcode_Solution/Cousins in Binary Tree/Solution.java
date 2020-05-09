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
    public boolean result=true;
    public  int g=-1,h=-1;
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
    public void level(TreeNode root,int l,int x,int y,int r)
    {
        if(root!=null)
        {
        if(l==0)
        {
           if(root.left!=null && root.right!=null)
           {
               int a=root.left.val;
               int b=root.right.val;
               if((a==x && b==y)||(a==y && b==x))
               {
                   System.out.println(root.val+" "+a+" "+b);
                   result=result && false;
               }
             
           }
              if(root.val==x)
               {
                   g=r;
               }
               if(root.val==y)
               {
                   h=r;
               }
        }
        else
        {
            level(root.left,l-1,x,y,r);
            level(root.right,l-1,x,y,r);
        }
        }
    }
    public boolean isCousins(TreeNode root, int x, int y) {
        boolean output=false;
        for(int i=0;i<height(root);i++)
        {
            level(root,i,x,y,i);
            if(g==i && h==i && result==true)
            {
                output=true;
                break;
            }
        }
        return output;
        
    }
}
