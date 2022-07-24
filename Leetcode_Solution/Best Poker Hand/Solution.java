class Solution {
    public String bestHand(int[] ranks, char[] suits) {
        String result="High Card";
        int flag=0;
        int max=1;
        HashMap<Integer,Integer> h=new HashMap<Integer,Integer>();
        for(int i=1;i<ranks.length;i++)
        {
            if(suits[i]!=suits[i-1])
            {
                flag=1;
            }
            if(!h.containsKey(ranks[i]))
            {
                h.put(ranks[i],1);
            }
            else
            {
                h.put(ranks[i],h.get(ranks[i])+1);
                if(h.get(ranks[i])>max)
                {
                    max=h.get(ranks[i]);
                }
            }
        }
        if(h.containsKey(ranks[0]))
        {
            h.put(ranks[0],h.get(ranks[0])+1);
                if(h.get(ranks[0])>max)
                {
                    max=h.get(ranks[0]);
                }
        }
        if(flag==0)
        {
            result="Flush";
        }
        else if(max>2)
        {
            result="Three of a Kind";
        }
        else if(max>1)
        {
            result="Pair";
        }
        
        return result;
    }
}
