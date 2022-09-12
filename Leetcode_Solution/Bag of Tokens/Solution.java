class Solution {
    public int bagOfTokensScore(int[] tokens, int power) {
        if(tokens.length==0 || power==0)
        {
            return 0;
        }
        int totalTokens=0;
        for(int i=0;i<tokens.length;i++)
        {
            totalTokens+=tokens[i];
        }
        
        if(totalTokens<=power)
        {
            return tokens.length;
        }
        else
        {
            Arrays.sort(tokens);
            if(tokens[0]>power)
            {
                return 0; 
            }
            else
            {
                int i=0,j=tokens.length-1;
                int maxScore=0;
                while(i<j)
                {
                    if(maxScore==0)
                    {
                        power=power-tokens[0];
                        totalTokens=totalTokens-tokens[0];
                        maxScore=1;
                        i++;
                    }
                    else
                    {
                        if(totalTokens<=power)
                        {
                            maxScore+=j-i+1;
                            break;
                        }
                        else if(tokens[i]<=power)
                        {
                            maxScore+=1;
                            totalTokens=totalTokens-tokens[i];
                            power=power-tokens[i];
                            i++;
                        }
                        else
                        {
                           totalTokens=totalTokens-tokens[i]-tokens[j];
                           power+=tokens[j];
                           power=power-tokens[i];
                            i++;
                           j--;
                        }
                    }
                }
                if(i==j)
                {
                    if(power>=tokens[i])
                    {
                        maxScore++;
                    }
                }
                
                return maxScore;
            }
            
        }
    }
}
