class Solution {
    public String largestMerge(String word1, String word2) {
        int i=0,j=0;
        char c[]=new char[word1.length()+word2.length()];
        int k=0;
        while(i<word1.length() && j<word2.length())
        {
            if(word1.charAt(i)>word2.charAt(j))
            {
                c[k]=word1.charAt(i);
                i++;
            }
            else if(word1.charAt(i)<word2.charAt(j))
            {
                c[k]=word2.charAt(j);
                j++;
            }
            else
            {
                String str1=word1.substring(i);
                String str2=word2.substring(j);
                if(str1.compareTo(str2)>0)
                {
                     c[k]=word1.charAt(i);
                     i++;
                }
                else
                {
                     c[k]=word2.charAt(j);
                      j++;
                }
            }
            
            k++;
        }
        if(i==word1.length() && j!=word2.length())
        {
            for(int x=j;x<word2.length();x++)
            {
                c[k]=word2.charAt(x);
                k++;
            }
        }
        if(i!=word1.length() && j==word2.length())
        {
            for(int x=i;x<word1.length();x++)
            {
                c[k]=word1.charAt(x);
                k++;
            }
        }
        
        return new String(c);
    }
}
