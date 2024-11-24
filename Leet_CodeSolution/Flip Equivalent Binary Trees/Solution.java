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
 class Node
 {
    int leftChild,rightChild;
    public Node(int l,int r)
    {
        leftChild=l;
        rightChild=r;
    }
 }
class Solution {
    public boolean flipEquiv(TreeNode root1, TreeNode root2) {
        if(root1==null && root2==null)
        {
            return true;
        }
        if(root1==null || root2==null)
        {
            return false;
        }
        Queue<TreeNode> q=new LinkedList<TreeNode>();
        q.add(root1);
        HashMap<Integer,Integer> h=new HashMap<Integer,Integer>();
        HashMap<Integer,Node> map=new HashMap<Integer,Node>();
        h.put(root1.val,0);
        int level=0;
        while(q.size()>0)
        {
            int len=q.size();
            level++;
            for(int i=0;i<len;i++)
            {
                TreeNode temp=q.poll();
                int lChild=-1,rChild=-1;
                if(temp.left!=null)
                {
                    q.add(temp.left);
                    h.put(temp.left.val,level);
                    lChild=temp.left.val;
                }
                if(temp.right!=null)
                {
                    q.add(temp.right);
                    h.put(temp.right.val,level);
                    rChild=temp.right.val;
                }

                map.put(temp.val,new Node(lChild,rChild));
            }
        }
      q=new LinkedList<TreeNode>();
   level=0;
      q.add(root2);
      while(q.size()>0)
      {
        int len=q.size();
        for(int i=0;i<len;i++)
        {
            TreeNode temp=q.poll();
            if(!h.containsKey(temp.val) || h.get(temp.val)!=level)
            {
                return false;
            }
            int lChild=-1,rChild=-1;
                if(temp.left!=null)
                {
                    q.add(temp.left);
                    lChild=temp.left.val;
                }
                if(temp.right!=null)
                {
                    q.add(temp.right);
                    rChild=temp.right.val;
                }
                Node node=map.get(temp.val);
                int l=node.leftChild;
                int r=node.rightChild;
                if((l==lChild && r==rChild) || (l==rChild && r==lChild))
                {
                    // Do Nothing
                }
                else
                {
                     return false;
                }
        }
        level++;
      }

      return true;

    }
}
