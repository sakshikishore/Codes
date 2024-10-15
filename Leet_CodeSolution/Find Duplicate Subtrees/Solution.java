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
    HashSet<String> hset1=new HashSet<String>();
    HashSet<String> hset2=new HashSet<String>();
    HashMap<TreeNode,String> map=new HashMap<TreeNode,String>();
    List<TreeNode> result=new ArrayList<TreeNode>();
    public void postOrder(TreeNode root)
    {
        if(root!=null)
        {
            postOrder(root.left);
            postOrder(root.right);
            String p=Integer.toString(root.val);
            if(root.left!=null)
            {
                
                p=p+"L"+map.get(root.left);
            }
            else
            {
                p=p+"L";
            }
            if(root.right!=null)
            {
                 p=p+"R"+map.get(root.right);
            }
            else
            {
                p=p+"R";
            }
            map.put(root,p);
            if(hset1.contains(p))
            {
                if(!hset2.contains(p))
                {
                    result.add(root);
                    hset2.add(p);
                }
            }
            else
            {
                hset1.add(p);
            }
        }
    }
    public List<TreeNode> findDuplicateSubtrees(TreeNode root) {
        postOrder(root);
        return result;
    }
}
