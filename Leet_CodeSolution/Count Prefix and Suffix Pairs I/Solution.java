class Solution {
    public int countPrefixSuffixPairs(String[] words) {
        int count=0;
        for(int i=0;i<words.length;i++)
        {
            for(int j=i+1;j<words.length;j++)
            {
                if(words[i].length()<=words[j].length())
                {
                    if(words[i].equals(words[j].substring(0,words[i].length())) && words[i].equals(words[j].substring(words[j].length()-words[i].length())))
                    {
                        count++;
                    }
                }
            }
        }
        
        return count;
    }
}
