class Solution {
    public int numSpecialEquivGroups(String[] words) {
        int count=0;
        for(int i=0;i<words.length;i++)
        {
            if(!words[i].equals(""))
            {
                count++;
            int ch1[]=new int[26];
            int ch2[]=new int[26];
            for(int k=0;k<words[i].length();k++)
            {
                if(k%2!=0)
                {
                    ch1[words[i].charAt(k)-'a']++;
                }
                else
                {
                    ch2[words[i].charAt(k)-'a']++;
                }
            }
            words[i]="";
            for(int j=i+1;j<words.length;j++)
            {
                if(!words[j].equals(""))
                {
                     int c1[]=new int[26];
                     int c2[]=new int[26];
                     for(int k=0;k<words[j].length();k++)
                    {
                        if(k%2!=0)
                        {
                            c1[words[j].charAt(k)-'a']++;
                        }
                        else
                        {
                            c2[words[j].charAt(k)-'a']++;
                        }
                    }
                    int l=0;
                    for(int r=0;r<26;r++)
                    {
                        if(ch1[r]!=c1[r] || ch2[r] !=c2[r])
                        {
                            l++;
                            break;
                        }
                    }
                    if(l==0)
                    {
                        words[j]="";
                    }
                }
            }
         }
        }
        
        return count;
        
    }
}
