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
            return -1;
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
    public List<List<String>> printTree(TreeNode root) {
        List<List<String>> list=new ArrayList<>();
        if(root!=null)
        {
        HashMap<TreeNode,Integer> h=new HashMap<TreeNode,Integer>();
        int ht=height(root);
        int c=(int)Math.pow(2,ht+1);
        String res[][]=new String[ht+1][c-1];
        Queue<TreeNode> q=new LinkedList<TreeNode>();
        q.add(root);
        q.add(null);
        res[0][(c-1)/2]=Integer.toString(root.val);
        h.put(root,(c-1)/2);
        int i=0;
        while(q.size()!=0)
        {
            TreeNode temp=q.poll();
            if(temp!=null)
            {
                int m=h.get(temp);
                int p=(int)Math.pow(2,(ht-i-1));
                if(temp.left!=null)
                {
                    
                    q.add(temp.left);
                   res[i+1][m-p]=Integer.toString(temp.left.val);
                    h.put(temp.left,m-p);
                }
                if(temp.right!=null)
                {
                    q.add(temp.right);
                    res[i+1][m+p]=Integer.toString(temp.right.val);
                    h.put(temp.right,m+p);
                }
            }
            else
            {
                ArrayList<String> l=new ArrayList<String>();
                for(int j=0;j<c-1;j++)
                {
                    if(res[i][j]==null)
                    {
                         l.add("");
                    }
                    else
                    {
                    l.add(res[i][j]);
                    }
                }
                list.add(l);
                i++;
                if(q.size()!=0)
                {
                    q.add(null);
                }
            }
        }
       
       }
        
        return list;
        
    }
}
