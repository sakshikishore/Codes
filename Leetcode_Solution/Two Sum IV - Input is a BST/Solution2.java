class Solution {
    public boolean findTarget(TreeNode root, int k) {
       HashSet<Integer> h=new HashSet<Integer>();
        Queue<TreeNode> q=new LinkedList<TreeNode>();
        q.add(root);
        while(q.size()>0)
        {
            TreeNode temp=q.poll();
            int x=k-temp.val;
            if(h.contains(x))
            {
                return true;
            }
            h.add(temp.val);
            if(temp.left!=null)
            {
                q.add(temp.left);
            }
            if(temp.right!=null)
            {
                q.add(temp.right);
            }
        }
        
        return false;
    }
}
