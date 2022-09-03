class Solution {
    public int minimumOperations(int[] nums, int start, int goal) {
        Queue<Integer> q=new LinkedList<Integer>();
        q.add(start);
        HashMap<Integer,Integer> h=new HashMap<Integer,Integer>();
        h.put(start,0);
        int min=Integer.MAX_VALUE;
        while(q.size()>0)
        {
            int x=q.poll();
            int n=h.get(x);
            for(int i=0;i<nums.length;i++)
            {
                int a=nums[i]+x;
                if(a==goal)
                {
                   if(min>n+1)
                   {
                       min=n+1;
                   }
                }
                if(a>=0 && a<=1000 && !h.containsKey(a))
                {
                    h.put(a,n+1);
                    q.add(a);
                }
                int b=x-nums[i];
                if(b==goal)
                {
                     if(min>n+1)
                   {
                       min=n+1;
                   }
                }
                if(b>=0 && b<=1000 && !h.containsKey(b))
                {
                    h.put(b,n+1);
                    q.add(b);
                }
                int c=x^nums[i];
                if(c==goal)
                {
                   if(min>n+1)
                   {
                       min=n+1;
                   }
                }
                if(c>=0 && c<=1000 && !h.containsKey(c))
                {
                    h.put(c,n+1);
                    q.add(c);
                }
            }
            
        }
        
        if(min==Integer.MAX_VALUE)
        {
            min=-1;
        }
        
        return min;
    }
}
