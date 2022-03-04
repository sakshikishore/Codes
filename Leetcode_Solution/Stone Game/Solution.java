class Solution {
    public boolean stoneGame(int[] piles) {
        boolean result=true;
        ArrayList<Integer> l=new ArrayList<Integer>();
        int AliceScore=0,sum=0;
        for(int i=0;i<piles.length;i++)
        {
            l.add(piles[i]);
            sum=sum+piles[i];
        }
        int i=0;
        while(i<piles.length-1)
        {
            if(i%2==0)
            {
                if(l.get(0)>l.get(l.size()-1))
                {
                    AliceScore+=l.get(0);
                    l.remove(0);
                }
                else
                {
                    AliceScore+=l.get(l.size()-1);
                    l.remove(l.size()-1);
                }
            }
            else
            {
                if(l.get(0)>l.get(l.size()-1))
                {
                    l.remove(0);
                }
                else
                {
                    l.remove(l.size()-1);
                }
            }
            i++;
        }
        
        int BobScore=sum-AliceScore;
        
        if(BobScore<AliceScore)
        {
            result=true;
        }
        
        return result;
    }
}
