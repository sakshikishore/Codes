class Solution {
    public String maskPII(String s) {
        String res="";
        if(s.contains("@"))
        {
            s=s.toLowerCase();
            int x=s.indexOf("@");
            res=s.substring(0,1)+"*****"+s.substring(x-1);
            return res;
        }
        else
        {
            String str="";
            for(int i=0;i<s.length();i++)
            {
                if(s.charAt(i)>='0' && s.charAt(i)<='9')
                {
                    str=str+s.substring(i,i+1);
                }
            }
            if(str.length()==10)
            {
                res="***-***-"+str.substring(str.length()-4);
            }
            else if(str.length()==11)
            {
                res="+*-***-***-"+str.substring(str.length()-4);
            }
            else if(str.length()==12)
            {
                res="+**-***-***-"+str.substring(str.length()-4);
            }
            else
            {
                res="+***-***-***-"+str.substring(str.length()-4);
            }
            
            return res;
        }
        
    }
}
