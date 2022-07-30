class Solution {
    public List<String> wordSubsets(String[] words1, String[] words2) {
        ArrayList<String> res=new ArrayList<String>();
        int ch1[][]=new int[words1.length][26];
        for(int i=0;i<words1.length;i++)
        {
            for(int j=0;j<words1[i].length();j++)
            {
                ch1[i][words1[i].charAt(j)-'a']++;
            }
        }
        int ch2[]=new int[26];
        for(int i=0;i<words2.length;i++)
        {
            int c[]=new int[26];
            for(int j=0;j<words2[i].length();j++)
            {
                c[words2[i].charAt(j)-'a']++;
                if(c[words2[i].charAt(j)-'a']>ch2[words2[i].charAt(j)-'a'])
                {
                    ch2[words2[i].charAt(j)-'a']=c[words2[i].charAt(j)-'a'];
                }
            }
        }
        
        for(int i=0;i<words1.length;i++)
        {
            int flag=0;
            for(int j=0;j<26;j++)
            {
                if(ch1[i][j]<ch2[j])
                {
                    flag=1;
                    break;
                }
            }
            if(flag==0)
            {
                res.add(words1[i]);
            }
        }
        
        return res;
    }
}
