/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Codec {
    
    // Encodes a tree to a single string.
    String str="";
   
    public String serialize(TreeNode root) {
       if(root!=null)
       {
        str=str+Integer.toString(root.val)+",";
        serialize(root.left);
        serialize(root.right);
       }
        
      if(str.length()==0)
      {
          return str;
      }
      else
      {
          return str.substring(0,str.length()-1);
      }
    }
    
    public TreeNode createBST(TreeNode x,TreeNode root)
    {
       if(root==null)
       {
           return x;
       }
       if(root.val<x.val)
       {
         root.right= createBST(x,root.right);
       }
       else
       {
        root.left=createBST(x,root.left);
       }
        
        return root;
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        TreeNode root=null;
        if(data.length()!=0)
        {
            String input[]=data.split(",");
            for(int i=0;i<input.length;i++)
            {
                TreeNode ptr=new TreeNode(Integer.parseInt(input[i]));
                ptr.left=null;
                ptr.right=null;
                root= createBST(ptr,root);
            }
        }
        return root;
    }
}
