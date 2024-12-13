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
    int a,b; // a rob the house || b don't rob the house
    public Node(int x, int y)
    {
        a=x;
        b=y;
    }
 }
class Solution {
    HashMap<TreeNode,Node> h=new HashMap<TreeNode,Node>();
    public void postOrder(TreeNode root)
    {
        if(root!=null)
        {
            postOrder(root.left);
            postOrder(root.right);
            if(root.left==null && root.right==null)
            {
                h.put(root,new Node(root.val,0));
            }
            else
            {
                if(root.left!=null && root.right!=null)
                {
                    Node p=h.get(root.left);
                    Node q=h.get(root.right);
                    int sum=Math.max(p.a,p.b)+Math.max(q.a,q.b);
                    h.put(root,new Node(root.val+p.b+q.b,sum));
                }
                else if(root.left!=null)
                {
                     Node p=h.get(root.left);
                     int sum=Math.max(p.a,p.b);
                    h.put(root,new Node(root.val+p.b,sum));
                }
                else
                {

                    Node q=h.get(root.right);
                    int sum=Math.max(q.a,q.b);
                    h.put(root,new Node(root.val+q.b,sum));
                }
            }
        
        }
    }
    public int rob(TreeNode root) {
       postOrder(root); 

       return Math.max(h.get(root).a,h.get(root).b);
    }
}
