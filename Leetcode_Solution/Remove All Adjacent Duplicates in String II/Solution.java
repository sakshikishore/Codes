class Solution {
    public String removeDuplicates(String s, int k) {
        int ch[]=new int[s.length()];
        StringBuffer sb=new StringBuffer(s);
        for(int i=0;i<sb.length();i++)
        {
            if(i==0)
            {
                ch[0]=1;
            }
            else
            {
                if(sb.charAt(i)==sb.charAt(i-1))
                {
                    ch[i]=ch[i-1]+1;
                    if(ch[i]==k)
                    {
                        sb.delete(i-k+1,i+1);
                        i=i-k;
                    }
                }
                else
                {
                    ch[i]=1;
                }
           }
        }
        
        return sb.toString();
        
    }
}
