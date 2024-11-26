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
    int total,max,min;
    public Node(int sum,int maxValue,int minValue)
    {
       total=sum;
       max=maxValue;
       min=minValue;
    }
 }
class Solution {
    int result=0;
     HashMap<TreeNode,Node> h=new HashMap<TreeNode,Node>();
     public void postOrder(TreeNode root)
     {
        if(root!=null)
        {
            postOrder(root.left);
            postOrder(root.right);
            int sum=root.val;
            int minimumValue=root.val,maximumValue=root.val;
            int flag=0;
            if(root.left!=null)
            {
               Node node=h.get(root.left);
               if(node.max==-100000)
               {
                flag=1;
               }
               else
               {
                if(node.max<root.val)
                {
                    sum+=node.total;
                    minimumValue=node.min;
                }
                else
                {
                    flag=1;
                }
               }
            }
            if(root.right!=null && flag==0)
            {
                Node node=h.get(root.right);
                if(node.max==-100000)
                {
                    flag=1;
                }
                else
                {
                    if(node.min>root.val)
                    {
                        sum+=node.total;
                        maximumValue=node.max;
                    }
                    else
                    {
                        flag=1;
                    }
                }
            }
            if(flag==1)
            {
                h.put(root,new Node(-1,-100000,-100000));
            }
            else
            {
                h.put(root,new Node(sum,maximumValue,minimumValue));
                if(sum>result)
                {
                 result=sum;
                }
            }
            
        }
     }

    public int maxSumBST(TreeNode root) {
        postOrder(root);
        return result;
    }
}
