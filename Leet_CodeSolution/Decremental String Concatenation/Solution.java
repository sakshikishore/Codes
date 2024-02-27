class Solution {
    int min=Integer.MAX_VALUE;
    public void Solve(String words[], int len, char first,char last,int i,int dp[][][])
    {
        if(len>=min)
        {
            return;
        }
        if(i==words.length)
        {
           if(len<min)
           {
               min=len;
           }
           return;
        }
        if(dp[i][first-'a'][last-'a']!=0)
        {
            if(dp[i][first-'a'][last-'a']<=len)
            {
                return;
            }
        }
       
        dp[i][first-'a'][last-'a']=len;
       if(last==words[i].charAt(0))
       {
         Solve(words,len+words[i].length()-1,first,words[i].charAt(words[i].length()-1),i+1,dp);
       }
       else
       {
           Solve(words,len+words[i].length(),first,words[i].charAt(words[i].length()-1),i+1,dp);
       }
         if(first==words[i].charAt(words[i].length()-1))
       {
        
         Solve(words,len+words[i].length()-1,words[i].charAt(0),last,i+1,dp);
       }
       else
       {
      
           Solve(words,len+words[i].length(),words[i].charAt(0),last,i+1,dp);
       }


    }
    public int minimizeConcatenatedLength(String[] words) {
       int dp[][][]=new int[1001][26][26];
        Solve(words,words[0].length(),words[0].charAt(0),words[0].charAt(words[0].length()-1),1,dp);
        return min;
    }
}
