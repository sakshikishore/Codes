class Solution {
    public boolean checkString(String s) {
        boolean result=true;
        int count=0;
        for(int i=0;i<s.length();i++)
        {
            if(s.charAt(i)=='a')
            {
               if(count>0)
               {
                   result=false;
                   break;
               }
            }
            else
            {
                count++;
            }
        }
               
               return result;
               
    }
}
