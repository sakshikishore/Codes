class Solution {
    public String reverseStr(String s, int k) {
        String str="";
        int j=0;
        if(s.length()>1)
        {   
        while(str.length()<s.length())
        {
            StringBuffer sb;
            if(j+k<=s.length())
            {
             sb=new StringBuffer(s.substring(j,j+k));
            }
            else
            {
                sb=new StringBuffer(s.substring(j,s.length()));
            }
            String t=new String(sb.reverse());
            
            if(j+(2*k)<=s.length())
            {
                
             str=str+t+s.substring(j+k,j+2*k);
            }
            else
            {
                if(j+k<=s.length())
                {
                
                str=str+t+s.substring(j+k, s.length());
                }
                else
                {
                     str=str+t;
                }
            }
            
            j=j+2*k;
            
        }
        }
        else
        {
            str=s;
        }
        
        return str;
    }
}
