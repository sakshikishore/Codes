class Solution {
    public boolean isNStraightHand(int[] hand, int groupSize) {
        boolean result=true;
        if(hand.length%groupSize==0)
        {
            HashMap<Integer,Integer> h=new HashMap<Integer,Integer>();
            TreeSet<Integer> t=new TreeSet<Integer>();
            for(int i=0;i<hand.length;i++)
            {
                t.add(hand[i]);
                if(!h.containsKey(hand[i]))
                {
                    h.put(hand[i],1);
                }
                else
                {
                    h.put(hand[i],h.get(hand[i])+1);
                }
            }
            Iterator<Integer> itr=t.iterator();
            while(itr.hasNext())
            {
                int p=itr.next();
                if(h.containsKey(p))
                {
                    int x=h.get(p);
                    h.remove(p);
                    int k=p+1;
                    for(int j=1;j<groupSize;j++)
                    {
                        if(!h.containsKey(k))
                        {
                            result=false;
                            break;
                        }
                        else if(h.get(k)<x)
                        {
                            result=false;
                            break;
                        }
                        else
                        {
                            if(h.get(k)==x)
                            {
                              h.remove(k);   
                            }
                            else
                            {
                                h.put(k,h.get(k)-x);
                            }
                        }
                        k++;
                    }
                    if(!result)
                    {
                        break;
                    }
                }
            }
        }
        else
        {
            result=false;
        }
        
        return result;
    }
}
