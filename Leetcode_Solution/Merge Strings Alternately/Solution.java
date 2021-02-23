class Solution {
    public String mergeAlternately(String word1, String word2) {
        int i=0;
        String str="";
        while(i!=word1.length() && i!=word2.length())
        {
            str=str+word1.substring(i,i+1)+word2.substring(i,i+1);
            i++;
        }
        if(i<word1.length())
        {
            str=str+word1.substring(i);
        }
        if(i<word2.length())
        {
            str=str+word2.substring(i);
        }
        
        
        return str;
    }
}
