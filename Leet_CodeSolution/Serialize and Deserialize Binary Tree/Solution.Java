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
    public void postOrder(TreeNode root,  HashMap<TreeNode, String> map)
    {
        if(root!=null)
        {
            postOrder(root.left,map);
            postOrder(root.right,map);
            if(root.left==null && root.right==null)
            {
                map.put(root,Integer.toString(root.val));
            }
            else
            {
                String str=Integer.toString(root.val);
                if(root.left!=null)
                {
                    str=str+"("+map.get(root.left)+")";
                }
                else
                {
                    str=str+"()";
                }
                if(root.right!=null)
                {
                     str=str+"("+map.get(root.right)+")";
                }
                 else
                {
                    str=str+"()";
                }
                map.put(root,str);
            }
        }
    }
    public TreeNode Solve(TreeNode root,String data)
    {
        if(data.length()==0)
        {
            return null;
        }
       int index=data.indexOf("(");
       if(index==-1)
       {
          int val=Integer.parseInt(data);
          root=new TreeNode(val,null,null);
          root.left=Solve(root,"");
          root.right=Solve(root,"");
       }
       else
       {
          int val=Integer.parseInt(data.substring(0,index));
          root=new TreeNode(val,null,null);
          Stack<Character> stck=new Stack<Character>();
          stck.push('(');
          int i=index+1;
          int lastIndex=-1;
          while(i<data.length())
          {
            if(data.charAt(i)==')')
            {
                stck.pop();
                if(stck.empty())
                {
                    lastIndex=i;
                    break;
                }
            }
            else if(data.charAt(i)=='(')
            {
                stck.push('(');
            }
            i++;
          }
          root.left=Solve(root,data.substring(index+1,lastIndex));
          stck=new Stack<Character>();
          index=lastIndex+1;
          if(index!=data.length())
          {
             i=index+1;
             lastIndex=-1;
              stck.push('(');
             while(i<data.length())
            {
                if(data.charAt(i)==')')
                {
                    stck.pop();
                    if(stck.empty())
                    {
                        lastIndex=i;
                        break;
                    }
                }
                else if(data.charAt(i)=='(')
                {
                    stck.push('(');
                }
                i++;
            }
            root.right=Solve(root,data.substring(index+1,lastIndex));
          }
       }

       return root;

    }
    public String serialize(TreeNode root) {
        HashMap<TreeNode, String> map=new HashMap<TreeNode,String>();
        if(root==null)
        {
            return "";
        }
       postOrder(root,map);

       return map.get(root);
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
       if(data.length()==0)
       {
        return null;
       }
        TreeNode root=null;
        return Solve(root,data);
    }
}

// Your Codec object will be instantiated and called as such:
// Codec ser = new Codec();
// Codec deser = new Codec();
// TreeNode ans = deser.deserialize(ser.serialize(root));
