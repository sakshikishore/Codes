class Solution {
    public long kthLargestLevelSum(TreeNode root, int k) {
        Queue<TreeNode> q=new LinkedList<TreeNode>();
        q.add(root);
        q.add(null);
        ArrayList<Long> l=new ArrayList<Long>();
        long sum=0;
        while(q.size()>0)
        {
            TreeNode temp=q.poll();
            if(temp==null)
            {
                 l.add(sum);
                if(q.size()>0)
                {
                    q.add(null);
                   
                    sum=0;
                }
            }
            else
            {
                sum+=temp.val;
                if(temp.left!=null)
                {
                    q.add(temp.left);
                }
                if(temp.right!=null)
                {
                    q.add(temp.right);
                }
            }
        }
        
        if(l.size()<k)
        {
            return -1;
        }
        Collections.sort(l);
        int n=l.size();
        return l.get(n-k);
        
    }
}
