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
    public int maxAncestorDiff(TreeNode root) {
        HashMap<TreeNode,String> h=new HashMap<TreeNode,String>();
        int maxValue=0;
        Queue<TreeNode> q=new LinkedList<TreeNode>();
        if(root!=null)
        {
            q.add(root);
            h.put(root,Integer.toString(root.val));
            while(q.size()>0)
            {
                TreeNode temp=q.poll();
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
            
            for(Map.Entry<TreeNode,String> entry: h.entrySet())
            {
                String p[]=entry.getValue().split(" ");
                int arr[]=new int[p.length];
                for(int i=0;i<p.length;i++)
                {
                    arr[i]=Integer.parseInt(p[i]);
                }
                Arrays.sort(arr);
                if(arr[arr.length-1]-arr[0]>maxValue)
                {
                    maxValue=arr[arr.length-1]-arr[0];
                }
                
            }
        }
        
        return maxValue;
        
    }
}
