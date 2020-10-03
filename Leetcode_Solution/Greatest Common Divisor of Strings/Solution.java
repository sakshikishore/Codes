import java.util.regex.*;
class Solution {
    public String gcdOfStrings(String str1, String str2) {
        int a=str1.length();
        int b=str2.length();
        String result="";
        if(str1.equals(str2))
        {
            result=str1;
        }
        else 
        {
            if(a!=b)
            {
                while(b!=0)
                {
                    int r=a%b;
                    a=b;
                    b=r;
                }
            
           int gcd=a;
            String k=str1.substring(0,gcd);
            Pattern p=Pattern.compile(k);
            Matcher m=p.matcher(str1);
            int count=0;
            while(m.find())
            {
                count++;
            }
            if(k.length()*count==str1.length())
            {
                count=0;
                 Matcher t=p.matcher(str2);
                while(t.find())
                {
                    count++;
                }
               if(k.length()*count==str2.length())
               {
                   result=k;
               }
            }
           }
           
        }
        
        return result;
        
    }
}
