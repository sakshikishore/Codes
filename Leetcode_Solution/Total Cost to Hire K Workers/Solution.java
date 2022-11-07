class Solution {
    public long totalCost(int[] costs, int k, int candidates) {
        long sum=0;
        HashSet<Integer> h=new HashSet<Integer>();
        PriorityQueue<Integer> pq1=new PriorityQueue<Integer>();
        int l=0;
        for(int i=0;i<costs.length;i++)
        {
            if(l<candidates)
            {
                h.add(i);
                pq1.add(costs[i]);
                l++;
            }
            else
            {
               break;
            }
        }
        PriorityQueue<Integer> pq2=new PriorityQueue<Integer>();
        int j=0;
        for(int i=costs.length-1;i>=0;i--)
        {
            if(j<candidates)
            {
                if(!h.contains(i))
                {
                    h.add(i);
                    pq2.add(costs[i]);
                    j++;
                }
            }
            else
            {
                j=i;
               break;
            }
        }
        for(int i=0;i<k;i++)
        {
            if(pq2.size()==0)
            {
                 sum+=pq1.poll(); 
                for(int x=l;x<=j;x++)
                {
                    if(!h.contains(x))
                    {
                        h.add(x);
                        pq1.add(costs[x]);
                        l=x+1;
                        break;
                    }
                }
            }
            else if(pq1.size()==0)
            {
                sum+=pq2.poll();
                for(int x=j;x>=l;x--)
                {
                    if(!h.contains(x))
                    {
                        h.add(x);
                        pq2.add(costs[x]);
                        j=x--;
                        break;
                    }
                }
            }
            else if(pq1.peek()<=pq2.peek())
            {
                sum+=pq1.poll(); 
                for(int x=l;x<=j;x++)
                {
                    if(!h.contains(x))
                    {
                        h.add(x);
                        pq1.add(costs[x]);
                        l=x+1;
                        break;
                    }
                }
            }
            else
            {
                sum+=pq2.poll();
                for(int x=j;x>=l;x--)
                {
                    if(!h.contains(x))
                    {
                        h.add(x);
                        pq2.add(costs[x]);
                        j=x--;
                        break;
                    }
                }
            }
        }
        
        return sum;
        
    }
}
