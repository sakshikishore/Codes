class Solution {
    public boolean isPrefixString(String s, String[] words) {
        String str="";
        boolean result=false;
        for(int i=0;i<words.length;i++)
        {
            str=str+words[i];
            if(str.length()==s.length())
            {
                if(str.equals(s))
                {
                    result=true;
                    break;
                }
            }
            else if(str.length()>s.length())
            {
                break;
            }
        }
     
        return result;
    }
}
