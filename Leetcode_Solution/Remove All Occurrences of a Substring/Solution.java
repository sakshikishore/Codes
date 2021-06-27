class Solution {
    public String removeOccurrences(String s, String part) {
        int flag=0;
         while(flag!=1)
        {
            if(s.contains(part))
            {
             s=s.replace(part,"");
            }
            else
            {
                flag=1;
            }
       }
        
        return s;
        
    }
}
