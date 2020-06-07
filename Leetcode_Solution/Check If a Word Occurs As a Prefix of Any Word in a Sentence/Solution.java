class Solution {
    public int isPrefixOfWord(String sentence, String searchWord) {
        String str[]=sentence.split(" ");
        int result=-1;
        for(int i=0;i<str.length;i++)
        {
            if(str[i].length()>=searchWord.length())
            {
                if(str[i].substring(0,searchWord.length()).equals(searchWord))
                {
                    result=i+1;
                    break;
                }
            }
        }
        
        return result;
    }
}
