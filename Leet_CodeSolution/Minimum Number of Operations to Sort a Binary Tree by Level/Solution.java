class Solution {
    public int minimumOperations(TreeNode root) {
        int count=0;
        Queue<TreeNode> q=new LinkedList<TreeNode>();
        HashMap<Integer,Integer> h=new HashMap<Integer,Integer>();
        HashMap<Integer,Integer> map=new HashMap<Integer,Integer>();
        int i=0;
        q.add(root);
        q.add(null);
        PriorityQueue<Integer> pq=new PriorityQueue<Integer>();
        int level=0;
        while(q.size()>0)
        {
            TreeNode temp=q.poll();
            if(temp==null)
            {
                int j=0;
                while(pq.size()!=0)
                {
                     int x=pq.poll();
                     int r=h.get(x);
                     if(r!=j)
                     {
                         count++;
                         System.out.println(level);
                          int t=map.get(j);
                          h.put(t,r);
                          h.put(x,j);
                          map.put(j,x);
                          map.put(r,t);

                     }
                     j++;
                }
                if(q.size()>0)
                {
                    level++;
                    q.add(null);
                    h=new HashMap<Integer,Integer>();
                    pq=new PriorityQueue<Integer>();
                    map=new HashMap<Integer,Integer>();
                    i=0;
                }
            }
            else
            {
                h.put(temp.val,i);
                map.put(i,temp.val);
                pq.add(temp.val);
                i++;
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
        
        return count;
    }
}
