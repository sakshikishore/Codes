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
class FindElements {
   ArrayList<Integer> l=new ArrayList<Integer>();
    public FindElements(TreeNode root) {
        if(root!=null)
        {
            root.val=0;
            Queue<TreeNode> q=new LinkedList<TreeNode>();
            q.add(root);
            l.add(0);
            while(q.size()!=0)
            {
                TreeNode temp=q.poll();
                if(temp.left!=null)
                {
                    temp.left.val=(temp.val*2)+1;
                    l.add(temp.left.val);
                    q.add(temp.left);
                    
                }
                if(temp.right!=null)
                {
                    temp.right.val=(temp.val*2)+2;
                    l.add(temp.right.val);
                    q.add(temp.right);
                }
            }

        }
        }
    
    public boolean find(int target) {
        boolean result=false;
        if(l.contains(target))
        {
            result=true;
        }
        
        return result;
    }
}

/**
 * Your FindElements object will be instantiated and called as such:
 * FindElements obj = new FindElements(root);
 * boolean param_1 = obj.find(target);
 */
