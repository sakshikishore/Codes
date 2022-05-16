class Solution {
    public List<String> removeAnagrams(String[] words) {
        ArrayList<String> result=new ArrayList<String>();
        int i=0;
        int j=1;
        int ch1[]=new int[26];
        for(int l=0;l<words[0].length();l++)
        {
            ch1[words[i].charAt(l)-'a']++;
        }
        result.add(words[0]);
        while(i<words.length && j<words.length)
        {
            if(words[i].length()==words[j].length())
            {
                int ch2[]=new int[26];
                 for(int l=0;l<words[j].length();l++)
                 {
                    ch2[words[j].charAt(l)-'a']++;
                 }
                int flag=0;
                for(int k=0;k<26;k++)
                {
                    if(ch1[k]!=ch2[k])
                    {
                        flag=1;
                        break;
                    }
                }
                
                if(flag==0)
                {
                    j++;
                }
                else
                {
                    result.add(words[j]);
                i=j;
                ch1=new int[26];
                for(int l=0;l<words[i].length();l++)
                {
                    ch1[words[i].charAt(l)-'a']++;
                }
                j++;
                }
            }
            else
            {
                result.add(words[j]);
                i=j;
                ch1=new int[26];
                for(int l=0;l<words[i].length();l++)
                {
                    ch1[words[i].charAt(l)-'a']++;
                }
                j++;
            }
        
        }
            
        
        return result;
        
    }
}
