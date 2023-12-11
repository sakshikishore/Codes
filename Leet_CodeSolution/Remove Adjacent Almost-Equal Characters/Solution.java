class Solution {
    public int removeAlmostEqualCharacters(String word) {
        int i=1,result=0;
        while(i<word.length())
        {
            if(word.charAt(i)==word.charAt(i-1) || Math.abs((word.charAt(i)-'a') - (word.charAt(i-1)-'a'))==1)
            {
                result++;
                i=i+2;
            }
            else
            {
                i++;
            }
        }
        
        return result;
    }
}
