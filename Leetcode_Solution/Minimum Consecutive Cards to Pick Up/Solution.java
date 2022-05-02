class Solution {
    public int minimumCardPickup(int[] cards) {
        HashMap<Integer,Integer> h=new HashMap<Integer,Integer>();
        int result=-1;
        int min=1000000;
        for(int i=0;i<cards.length;i++)
        {
            if(!h.containsKey(cards[i]))
            {
                h.put(cards[i],i);
            }
            else
            {
                if(i-h.get(cards[i])<min)
                {
                    min=i-h.get(cards[i]);
                    result=min+1;
                }
                h.put(cards[i],i);
            }
        }
        
        return result;
        
    }
}
