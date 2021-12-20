class Solution {
    public String firstPalindrome(String[] words) {
String result="";
        for(int i=0;i<words.length;i++)
        {
            StringBuffer sb=new StringBuffer(words[i]);
            String str=new String(sb.reverse());
            if(str.equals(words[i]))
            {
                result=str;
                break;
            }
            
        }
        
        return result;
        
    }
}
