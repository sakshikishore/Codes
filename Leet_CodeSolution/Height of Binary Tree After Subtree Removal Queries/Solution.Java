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
 public class Node
 {
    int lvl,height;
    public Node(int l, int h)
    {
        lvl=l;
        height=h;
    }
 }
class Solution {
    HashMap<Integer,Node> h=new HashMap<Integer,Node>();
    List<List<Integer>> list=new ArrayList();
    public void postOrder(TreeNode root,int level)
    {
        if(root!=null)
        {
            postOrder(root.left,level+1);
            postOrder(root.right,level+1);
            if(root.left==null && root.right==null)
            {
                h.put(root.val,new Node(level,0));
                list.get(level).add(0);
            }
            else
            {
                if(root.left!=null && root.right!=null)
                {
                    int max=Math.max(h.get(root.left.val).height,h.get(root.right.val).height);
                    h.put(root.val,new Node(level,max+1));
                    list.get(level).add(max+1);
                }
                else if(root.left!=null)
                {
                    h.put(root.val,new Node(level,h.get(root.left.val).height+1));
                    list.get(level).add(h.get(root.left.val).height+1);
                }
                else if(root.right!=null)
                {
                    h.put(root.val,new Node(level,h.get(root.right.val).height+1));
                    list.get(level).add(h.get(root.right.val).height+1);
                }
            }
        }
    }
    public int maxHeight(TreeNode root)
    {
        if(root==null)
        {
            return 0;
        }
        int hleft=maxHeight(root.left);
        int hright=maxHeight(root.right);
        if(hleft>hright)
        {
            return hleft+1;
        }
        return hright+1;
    }
    public int[] treeQueries(TreeNode root, int[] queries) {
       int mxheight=maxHeight(root);
       for(int i=0;i<mxheight;i++)
       {
        ArrayList<Integer> l=new ArrayList<Integer>();
        list.add(l);
       }
       postOrder(root,0); 
       for(int i=0;i<mxheight;i++)
       {
         List<Integer> l=list.get(i);
         Collections.sort(l);
       }
       int result[]=new int[queries.length];
       for(int i=0;i<queries.length;i++)
       {
         Node node=h.get(queries[i]);
         int level=node.lvl;
         if(list.get(level).size()==1)
         {
           result[i]= level-1;
         }
         else
         {
            List<Integer> al=list.get(level);
             if(al.get(al.size()-1)==node.height)
             {
                result[i]=level+al.get(al.size()-2);
             }
             else
             {
                result[i]=level+al.get(al.size()-1);
             }
         }
       }
       return result;

    }
}
