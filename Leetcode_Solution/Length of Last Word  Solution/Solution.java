class Solution {
    public int lengthOfLastWord(String s) {
        int result=0;
        if(s.length()>0)
        {
            String str[]=s.split("[ ]+");
            if(str.length>0)
            {
             result=str[str.length-1].length();
             }
        }
        
        return result;
        
    }
}
