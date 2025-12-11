class Solution {
    public long maxPoints(int[] technique1, int[] technique2, int k) {
        long ans=0;
        HashSet<Integer> hset=new HashSet<Integer>();
        HashMap<Integer,ArrayList<Integer>> h=new HashMap<Integer,ArrayList<Integer>>();
        PriorityQueue<Integer> pq=new PriorityQueue<Integer>();
        for(int i=0;i<technique1.length;i++)
        {
            if(technique1[i]>=technique2[i])
            {
                ans+=technique1[i];
                hset.add(i);
                k--;
            }
            else if(k<=0)
            {
                ans+=technique2[i];
                hset.add(i);
            }
            else
            {
                int x=technique2[i]-technique1[i];
                if(!h.containsKey(x))
                {
                    pq.add(x);
                    ArrayList<Integer> l=new ArrayList<Integer>();
                    l.add(i);
                    h.put(x,l);
                }
                else
                {
                    ArrayList<Integer> l=h.get(x);
                    l.add(i);
                    h.put(x,l);
                }
             
            }
        }
        while(k>0)
        {
            int x=pq.poll();
            ArrayList<Integer> l=h.get(x);
            for(int i=0;i<l.size();i++)
            {
                ans+=technique1[l.get(i)];
                hset.add(l.get(i));
                k--;
                if(k==0)
                {
                    break;
                }
            }
        }
        if(k<=0)
        {
            for(int i=0;i<technique2.length;i++)
            {
                if(!hset.contains(i))
                {
                    ans+=technique2[i];
                }
            }
        }

        return ans;
    }
}
