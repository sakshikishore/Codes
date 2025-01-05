class Solution {
    public boolean hasMatch(String s, String p) {
        if(p.length()==1)
        {
            return true;
        }
       int index=p.indexOf("*");
       if(index==0)
       {
           String str=p.substring(1);
           if(s.contains(str))
           {
               return true;
           }
           else
           {
               return false;
           }
       }
       else if(index==p.length()-1)
       {
          String str=p.substring(0,p.length()-1);
          if(s.contains(str))
           {
               return true;
           }
           else
           {
               return false;
           }
           
       }
       else
       {
           String str1=p.substring(0,index);
           String str2=p.substring(index+1);
           int a=s.indexOf(str1);
           int b=s.lastIndexOf(str2);
           if(a!=-1 && b!=-1)
           {
               if(a+str1.length()-1<b)
               {
                   return true;
               }
               
           }
       }

        return false;
    }
}
