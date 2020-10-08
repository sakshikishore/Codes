class Solution {
    public int maxProduct(String[] words) {
        int max=0;
        for(int i=0;i<words.length;i++)
        {
            for(int j=i+1;j<words.length;j++)
            {
                if(words[i].length()*words[j].length()>max)
                {
                    int count=0;
                    for(int t=0;t<words[i].length();t++)
                    {
                if(words[j].contains(words[i].substring(t,t+1)))
                        {
                            count++;
                            break;
                        }
                    }
                    if(count==0)
                    {
                        max=words[i].length()*words[j].length();
                    }
                }
            }
        }
                             
                             
        return max;
    }
}
