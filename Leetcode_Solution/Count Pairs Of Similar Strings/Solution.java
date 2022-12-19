class Solution {
    public int similarPairs(String[] words) {
        int c[][]=new int[words.length][26];
        for(int i=0;i<words.length;i++)
        {
            for(int j=0;j<words[i].length();j++)
            {
                if(c[i][words[i].charAt(j)-'a']==0)
                {
                  c[i][words[i].charAt(j)-'a']++;
                }
            }
        }
        int count=0;
        for(int i=0;i<words.length;i++)
        {
            for(int j=i+1;j<words.length;j++)
            {
                int flag=0;
                for(int k=0;k<26;k++)
                {
                    if(c[i][k]!=c[j][k])
                    {
                        flag=1;
                        break;
                    }
                }
                if(flag==0)
                {
                    count++;
                }
            }
        }
        
        return count;
        
    }
}
