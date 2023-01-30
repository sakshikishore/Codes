class Solution {
    public int distinctIntegers(int n) {
        HashSet<Integer> h=new HashSet<Integer>();
        Queue<Integer> q=new LinkedList<Integer>();
            q.add(n);
            h.add(n);
            while(q.size()!=0)
            {
                int x=q.poll();
                for(int i=2;i<x;i++)
                {
                    if(x%i==1)
                    {
                        if(!h.contains(i))
                        {
                            h.add(i);
                            q.add(i);
                        }
                    }
                }
            }
        
        return h.size();
        
    }
}
