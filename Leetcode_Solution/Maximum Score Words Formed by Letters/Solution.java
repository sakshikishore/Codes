class Solution {
    public int findMax(String[] words, int freq[], int[] score, int index)
    {
        if(index>=words.length)
        {
            return 0;
        }
            int a=findMax(words,freq,score,index+1);
            String str=words[index];
            int flag=1;
            int wordScore=0;
            for(int i=0;i<str.length();i++)
            {
                if(freq[str.charAt(i)-'a']==0)
                {
                    flag=0;
                }
                freq[str.charAt(i)-'a']--;
                wordScore+=score[str.charAt(i)-'a'];
            }
            int b=0;
            if(flag==1)
            {
                b=wordScore+findMax(words,freq,score,index+1);
            }
            for(int i=0;i<str.length();i++)
            {
                freq[str.charAt(i)-'a']++;
            }
            
            return Math.max(a,b);
    }
    public int maxScoreWords(String[] words, char[] letters, int[] score) {
        int freq[]=new int[26];
        for(int i=0;i<letters.length;i++)
        {
            freq[letters[i]-'a']++;
        }
        
        return findMax(words,freq,score,0);
    }
}
