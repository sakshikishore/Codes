class Solution {
    public boolean hasGroupsSizeX(int[] deck) {
        HashMap<Integer,Integer> h=new HashMap<Integer,Integer>();
        boolean result=true;
        for(int i=0;i<deck.length;i++)
        {
            if(!h.containsKey(deck[i]))
            {
                h.put(deck[i],1);
            }
            else
            {
                h.put(deck[i],h.get(deck[i])+1);
            }
        }
        int count=0;
        int gcd=0;
          for(Map.Entry<Integer,Integer> m:h.entrySet())
        {
            if(count==0)
            {
                gcd=m.getValue();
            }
            else
            {
                int r1=gcd,r2=m.getValue();
                while(r2!=0)
                {
                    int r=r1%r2;
                    r1=r2;
                    r2=r;
                }
                if(r1==1)
                {
                    gcd=1;
                    break;
                }
                else
                {
                    gcd=r1;
                }
            }
              count++;
        
        }
        
        if(gcd==1)
        {
            result=false;
        }
        
           
        
        return result;
    }
}
