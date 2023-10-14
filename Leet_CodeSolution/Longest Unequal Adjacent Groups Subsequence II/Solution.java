class Solution {
    public List<String> getWordsInLongestSubsequence(int n, String[] words, int[] groups) {
        int dp[]=new int[n];
        dp[0]=1;
        List<List<Integer>> list=new ArrayList();
        int idx[]=new int[n];
        idx[0]=0;
        for(int i=1;i<groups.length;i++)
        {
            dp[i]=1;
            idx[i]=i;
            for(int j=i-1;j>=0;j--)
            {
                if(groups[j]!=groups[i] && words[i].length()==words[j].length())
                {
                    int hammingDistance=0;
                    for(int k=0;k<words[i].length();k++)
                    {
                        if(words[i].charAt(k)!=words[j].charAt(k))
                        {
                            hammingDistance++;
                        }
                    }
                    
                    if(hammingDistance==1)
                    {
                    
                            if(dp[i]<dp[j]+1)
                            {
                                dp[i]=dp[j]+1;
                                idx[i]=j;
                            }
                    }
                }
            }
        }
       
        int index=0,max=0;
        for(int i=0;i<dp.length;i++)
        {
            if(dp[i]>max)
            {
                max=dp[i];
                index=i;
            }
        }
      ArrayList<String> result=new ArrayList<String>();
        Stack<String> stck=new Stack<String>();
        int i=1;
        stck.push(words[index]);
        while(i<max)
        {
            int j=idx[index];
            index=j;
            stck.push(words[j]);
            i++;
        }
        
        while(stck.size()>0)
        {
            result.add(stck.pop());
        }
        
        return result;
        
    }
}
