class Solution {
    public int countSegments(String s) {
        
        int length=0;
         if(s.equals(""))
         {
            length=0;
         }
        else
        {
            String str[]=s.trim().split("[ ]+");
            if(str.length==1 && str[0].equals(""))
            {
                length=0;
            }
            else
            {
            length=str.length;
            }
        }
        return length;
    }
}
