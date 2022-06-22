class Solution {
    public int numPairsDivisibleBy60(int[] time) {
        HashMap<Integer,Integer> h=new HashMap<Integer,Integer>();
        int count=0;
        for(int i=0;i<time.length;i++)
        {
            if(time[i]<=60)
            {
                if(!h.containsKey(time[i]))
                {
                    h.put(time[i],1);
                }
                else
                {
                    h.put(time[i],h.get(time[i])+1);
                }
            }
            else
            {
                int p=time[i]/60;
                p=time[i]-p*60;
                if(p==0)
                {
                    p=60;
                }
                if(!h.containsKey(p))
                {
                    h.put(p,1);
                }
                else
                {
                    h.put(p,h.get(p)+1);
                }
            }
        }
        
         for(int i=0;i<time.length;i++)
         {
             int x=time[i];
             if(x>60)
             {
                 x=x/60;
                 x=time[i]-(x*60);
             }
             if(x==0)
             {
                 x=60;
             }
             if(h.containsKey(x))
             {
                 int value=h.get(x);
                 if(x==60 || x==30)
                 {
                     if(value>1)
                     {
                         if(value%2==0)
                         {
                         count=count+((value/2)*(value-1));
                         }
                         else
                         {
                              count=count+(((value-1)/2)*(value));
                         }
                     }
                     h.remove(x);
                 }
                 else
                 {
                     int y=60-x;
                     if(h.containsKey(y))
                     {
                         int val=h.get(y);
                         count=count+val*value;
                         h.remove(y);
                     }
                     h.remove(x);

                 }
             }
         }
       
        return count;
    }
}
