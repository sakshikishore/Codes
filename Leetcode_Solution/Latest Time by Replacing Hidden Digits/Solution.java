class Solution {
    public String maximumTime(String time) {
        String str="";
       if(time.charAt(0)=='?')
       {
           if(time.charAt(1)>='4' && time.charAt(1)!='?')
           {
               str=str+"1";
           }
           else
           {
           str=str+"2";
           }
       }
       else
       {
           str=str+time.substring(0,1);
       }
        if(str.charAt(0)!='2')
        {
            if(time.charAt(1)=='?')
            {
                str=str+"9";
            }
            else
            {
                str=str+time.substring(1,2);
            }
        }
        else
        {
            if(time.charAt(1)=='?')
            {
               str=str+"3";
               
            }
            else
            {
                str=str+time.substring(1,2);
            }
        }
        str=str+":";
        
        if(time.charAt(3)=='?')
        {
            str=str+"5";
        }
        else
        {
             str=str+time.substring(3,4);
        }
        
         if(time.charAt(4)=='?')
        {
            str=str+"9";
        }
        else
        {
             str=str+time.substring(4);
        }
        
        return str;
    }
}
