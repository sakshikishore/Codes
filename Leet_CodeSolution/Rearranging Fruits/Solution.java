class Solution {
    public long minCost(int[] basket1, int[] basket2) {
        HashMap<Integer,Integer> h1=new HashMap<Integer,Integer>();
        HashMap<Integer,Integer> h2=new HashMap<Integer,Integer>();
        HashMap<Integer,Long> h=new HashMap<Integer,Long>();
        ArrayList<Integer> l1=new ArrayList<Integer>();
        ArrayList<Integer> l2=new ArrayList<Integer>();
        for(int i=0;i<basket1.length;i++)
        {
            if(!h1.containsKey(basket1[i]))
            {
                h1.put(basket1[i],1);
            }
            else
            {
                h1.put(basket1[i],h1.get(basket1[i])+1);
            }
            if(!h2.containsKey(basket2[i]))
            {
                h2.put(basket2[i],1);
            }
            else
            {
                h2.put(basket2[i],h2.get(basket2[i])+1);
            }
            if(!h.containsKey(basket1[i]))
            {
                h.put(basket1[i],1L);
            }
            else
            {
                h.put(basket1[i],h.get(basket1[i])+1);
            }
             if(!h.containsKey(basket2[i]))
            {
                h.put(basket2[i],1L);
            }
            else
            {
                h.put(basket2[i],h.get(basket2[i])+1);
            }
        }
        for(Map.Entry<Integer,Long> entry:h.entrySet())
        {
            long val=entry.getValue();
            int key=entry.getKey();
            if(val%2!=0)
            {
                return -1;
            }
            long p=val/2;
            if(!h1.containsKey(key))
            {
                for(long i=0;i<p;i++)
                {
                    l1.add(key);
                }
            }
            else
            {
                int x=h1.get(key);
                if(x<p)
                {
                    long y=p-x;
                    for(long i=0;i<y;i++)
                    {
                        l1.add(key);
                    }
                }
            }
            if(!h2.containsKey(key))
            {
                for(long i=0;i<p;i++)
                {
                    l2.add(key);
                }
            }
            else
            {
                int x=h2.get(key);
                if(x<p)
                {
                    long y=p-x;
                    for(long i=0;i<y;i++)
                    {
                        l2.add(key);
                    }
                }
            }
        }
        if(l1.size()==0)
        {
            return 0;
        }
        else
        {
            long result=0;
            Collections.sort(l1);
            Collections.sort(l2);
            Arrays.sort(basket1);
            Arrays.sort(basket2);
            int min=Math.min(basket1[0],basket2[0]);
            int i=0,j=l2.size()-1;
            while(i<l1.size() && j>=0)
            {
                int p=Math.min(l1.get(i),l2.get(j));
                if(min*2<p)
                {
                    result+=min*2;
                }
                else
                {
                    result+=p;
                }
                i++;
                j--;
            }

            return result;
        }
    }
}
