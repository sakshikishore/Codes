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
    public String smallestFromLeaf(TreeNode root) {
        String result="";
        if(root!=null)
        {
            ArrayList<String> l=new ArrayList<String>();
            HashMap<TreeNode, String> h=new HashMap<TreeNode,String>();
            Queue<TreeNode> q=new LinkedList<TreeNode>();
            q.add(root);
            h.put(root,Integer.toString(root.val));
            while(q.size()!=0)
            {
                TreeNode temp=q.poll();
                if(temp.left==null && temp.right==null)
                {
                    l.add(h.get(temp));
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
        
            String str[]=new String[l.size()];
            for(int i=0;i<l.size();i++)
            {
                String p[]=l.get(i).split(" ");
                String s="";
                for(int j=0;j<p.length;j++)
                {
                  char c=(char)(97+Integer.parseInt(p[j]));
                  s=s+Character.toString(c);
                }
                StringBuffer sb=new StringBuffer(s);
                str[i]=new String(sb.reverse());
            }
        
        for(int i=0;i<str.length;i++)
        {
            for(int j=i+1;j<str.length;j++)
            {
                if(str[i].compareTo(str[j])>0)
                {
                    String t=str[i];
                    str[i]=str[j];
                    str[j]=t;
                }
            }
        }
        
      if(str.length>0)
      {
          result=str[0];
      }
   }
        return result;
        
    }
}
