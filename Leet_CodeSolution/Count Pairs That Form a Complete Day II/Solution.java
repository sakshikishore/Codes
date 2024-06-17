class Solution {
    public long countCompleteDayPairs(int[] hours) {
        HashMap<Integer,Integer> h=new HashMap<Integer,Integer>();
        long result=0;
        for(int i=0;i<hours.length;i++)
        {
            int p=hours[i]%24;
            if(!h.containsKey(p))
            {
                h.put(p,1);
            }
            else
            {
                h.put(p,h.get(p)+1);
            }
        }
        for(int i=0;i<=12;i++)
        {
            if(i==0 || i==12)
            {
                if(h.containsKey(i))
                {
                    long x=h.get(i);
                    result+=((x-1)*(x))/2;
                }
            }
            else
            {
               if(h.containsKey(i))
               {
                   if(h.containsKey(24-i))
                   {
                       long x=h.get(i);
                       long y=h.get(24-i);
                       result+=x*y;
                   }
               }
            }
            
        }
        
        return result;
    }
}
