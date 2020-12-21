class Solution {
    public String reformatNumber(String number) {
        String str="";
        for(int i=0;i<number.length();i++)
        {
            if(number.charAt(i)>='0' && number.charAt(i)<='9')
            {
                str=str+number.substring(i,i+1);
            }
        }
        
        int p=str.length();
        String result="";
        int i=0;
        while(p!=0)
        {
            int n=p-3;
            if(n>=2)
            {
                result=result+str.substring(i,i+3)+"-";
                i=i+3;
                p=n;
            }
            else
            {
                n=p-2;
                if(n>=2)
                {
                     result=result+str.substring(i,i+2)+"-";
                     i=i+2;
                     p=n;
                }
                else
                {
                    result=result+str.substring(i,i+p);
                    p=0;
                }
            }
        }
        
        return result;
        
    }
}
