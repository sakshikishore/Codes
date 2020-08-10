class Solution {
    public String licenseKeyFormatting(String S, int K) {
        S=S.toUpperCase();
        String str="";
        int count=0;
        for(int i=S.length()-1;i>=0;i--)
        {
            if(S.charAt(i)!='-')
            {
                count++;
                str=str+S.substring(i,i+1);
                if(count==K && i!=0)
                {
                    str=str+"-";
                    count=0;
                }
                
                
                
            }
        }
        
        
        StringBuffer sb=new StringBuffer(str);
        String p=new String(sb.reverse());
        for(int i=0;i<p.length();i++)
        {
            if(p.charAt(i)!='-')
            {
                p=p.substring(i);
                break;
            }
        }
        return p;
    }
}
