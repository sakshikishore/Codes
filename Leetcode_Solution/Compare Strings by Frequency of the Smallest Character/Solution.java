class Solution {
    public int[] numSmallerByFrequency(String[] queries, String[] words) {
        int result[]=new int[queries.length];
        int c[]=new int[words.length];
        for(int i=0;i<words.length;i++)
        {
            int ch[]=new int[26];
            char min=words[i].charAt(0);
            ch[words[i].charAt(0)-'a']++;
            for(int j=1;j<words[i].length();j++)
            {
                if(words[i].charAt(j)<min)
                {
                    min=words[i].charAt(j);
                }
                ch[words[i].charAt(j)-'a']++;
            }
            
            c[i]=ch[min-'a'];
        }
        int d[]=new int[queries.length];
        for(int i=0;i<queries.length;i++)
        {
            int ch[]=new int[26];
            char min=queries[i].charAt(0);
            ch[queries[i].charAt(0)-'a']++;
            for(int j=1;j<queries[i].length();j++)
            {
                if(queries[i].charAt(j)<min)
                {
                    min=queries[i].charAt(j);
                }
                ch[queries[i].charAt(j)-'a']++;
            }
            
            d[i]=ch[min-'a'];
        }
        
        for(int i=0;i<queries.length;i++)
        {
            int count=0;
            for(int j=0;j<words.length;j++)
            {
                if(d[i]<c[j])
                {
                    count++;
                }
            }
            
            result[i]=count;
        }
        
        return result;
        
        
    }
}
