class Solution {
    public long sumOfLargestPrimes(String s) {
        PriorityQueue<Long> pq=new PriorityQueue<Long>();
        long sum=0;
        HashMap<Long,Integer> h=new HashMap<Long,Integer>();
        for(int i=0;i<s.length();i++)
            {
                long x=0;
                for(int j=i;j<s.length();j++)
                    {
                        x=x*10+s.charAt(j)-'0';
                        int flag=0;
                        if(x%2!=0 || x==2)
                        {
                         if(pq.size()<3 || pq.peek()<x)
                         {
                        for(long k=2;k<=Math.sqrt(x);k++)
                            {
                                if(x%k==0)
                                {
                                    flag=1;
                                    break;
                                }
                            }
                                if(flag==0 && x!=1)
                                {
                                    if(pq.size()<3)
                                    {
                                        if(!h.containsKey(x))
                                        {
                                            h.put(x,1);
                                            pq.add(x);
                                        }
                                    }
                                    else
                                    {
                                        if(pq.peek()<x && !h.containsKey(x))
                                        {
                                           long t= pq.poll();
                                            h.remove(t);
                                            h.put(x,1);
                                            pq.add(x);
                                        }
                                    }
                                }
                        }
                        }
                    }
            }

        while(pq.size()>0)
            {
                sum+=pq.poll();
            }
        return sum;
    }
}
