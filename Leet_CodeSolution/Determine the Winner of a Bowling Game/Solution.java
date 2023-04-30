class Solution {
    public int isWinner(int[] player1, int[] player2) {
       int score1=player1[0],score2=player2[0];
        
        for(int i=1;i<player1.length;i++)
        {
            if(i==1)
            {
                if(player1[0]==10)
                {
                    score1+=2*player1[i];
                }
                else
                {
                    score1+=player1[i];
                }
                if(player2[0]==10)
                {
                    score2+=2*player2[i];
                }
                else
                {
                    score2+=player2[i];
                }
            }
            else
            {
                if(player1[i-1]==10 || player1[i-2]==10)
                {
                    score1+=2*player1[i];
                }
                else
                {
                    score1+=player1[i];
                }
                if(player2[i-1]==10 || player2[i-2]==10)
                {
                    score2+=2*player2[i];
                }
                else
                {
                    score2+=player2[i];
                }
            }
        }
        
        if(score1>score2)
        {
            return 1;
        }
        else if(score1<score2)
        {
            return 2;
        }
        
        return 0;
    }
}
