class Solution {
    public int minimumLevels(int[] possible) {
        int BobScore[]=new int[possible.length];
        int score=0;
        for(int i=possible.length-1;i>0;i--)
        {
            if(possible[i]==0)
            {
                score--;
            }
            else
            {
                score++;
            }
            BobScore[i]=score;
        }
        int DaneilScore=0;
        for(int i=0;i<possible.length-1;i++)
        {
            if(possible[i]==0)
            {
                DaneilScore--;
            }
            else
            {
                DaneilScore++;
            }
            if(DaneilScore>BobScore[i+1])
            {
                return i+1;
            }
        }
        
        return -1;
        
    }
}
