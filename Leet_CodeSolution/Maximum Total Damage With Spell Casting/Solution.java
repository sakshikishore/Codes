class Solution {
    public long maximumTotalDamage(int[] power) {
        HashMap<Integer,Long> h=new HashMap<Integer,Long>();
        ArrayList<Integer> l=new ArrayList<Integer>();
        for(int i=0;i<power.length;i++)
        {
            if(!h.containsKey(power[i]))
            {
                h.put(power[i],power[i]*1L);
                l.add(power[i]);
            }
            else
            {
                h.put(power[i],h.get(power[i])+power[i]);
            }
        }
        long dp[]=new long[l.size()];
        Collections.sort(l);
        dp[0]=h.get(l.get(0));
        long max=dp[0]*1l;
        for(int i=1;i<l.size();i++)
        {
           if(i==1)
           {
               if(l.get(i)-l.get(0)>2)
               {
                   dp[i]=dp[0]+h.get(l.get(i));
               }
               else
               {
                   dp[i]=h.get(l.get(i));
               }
           }
            else if(i==2)
            {
               if(l.get(i)-l.get(i-1)>2)
               {
                   dp[i]=Math.max(dp[0],dp[1])+h.get(l.get(i));
               }
               else if(l.get(i)-l.get(0)>2)
               {
                   dp[i]=dp[0]+h.get(l.get(i));
               }
               else
               {
                   dp[i]=h.get(l.get(i));
               }
            }
            else if(i==3)
            {
                if(l.get(i)-l.get(i-1)>2)
               {
                   dp[i]=Math.max(dp[2],dp[1]);
                  dp[i]=Math.max(dp[0],dp[i])+h.get(l.get(i));
               }
               else if(l.get(i)-l.get(i-2)>2)
               {
                   dp[i]=Math.max(dp[0],dp[1])+h.get(l.get(i));
               }
               else
               {
                   dp[i]=dp[0]+h.get(l.get(i));
               }
            }
            else
            {
                if(l.get(i)-l.get(i-1)>2)
               {
                   dp[i]=Math.max(dp[i-1],dp[i-2]);
                   dp[i]=Math.max(dp[i],dp[i-3])+h.get(l.get(i));
               }
               else if(l.get(i)-l.get(i-2)>2)
               {
                   dp[i]=Math.max(dp[i-2],dp[i-3]);
                       if(i-4>=0)
                       {
                           dp[i]=Math.max(dp[i],dp[i-4]);
                       }
                  dp[i]+=h.get(l.get(i));
               }
               else
               {
                   dp[i]=Math.max(dp[i-3],dp[i-4]);
                        if(i-5>=0)
                       {
                           dp[i]=Math.max(dp[i],dp[i-5]);
                       }
                  dp[i]+=h.get(l.get(i));
                    
               }
            }
            if(dp[i]>max)
            {
                max=dp[i];
            }

        }
        
        return max;
        
    }
}
