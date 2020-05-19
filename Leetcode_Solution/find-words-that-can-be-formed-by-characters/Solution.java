class Solution {
    public int countCharacters(String[] words, String chars) {
       
        int sum=0;
       
        for(int i=0;i<words.length;i++)
        {
            int count=0;
            int ch[]=new int[26];
            for(int t=0;t<chars.length();t++)
            {
              ch[chars.charAt(t)-'a']++;
            }
            for(int j=0;j<words[i].length();j++)
            {
                if(ch[words[i].charAt(j)-'a']==0)
                {
                    count=-1;
                    break;
                }
                else
                {
                    ch[words[i].charAt(j)-'a']--;
                }
            }
            if(count==0)
            {
                sum=sum+words[i].length();
            }
        }
        
        return sum;
    }
}
