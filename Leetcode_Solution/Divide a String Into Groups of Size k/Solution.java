class Solution {
    public String[] divideString(String s, int k, char fill) {
        int l=s.length()/k;
        if(l*k!=s.length())
        {
            l++;
        }
        String result[]=new String[l];
            int j=0;
        if(s.length()%k==0)
        {
            for(int i=0;i<s.length();i=i+k)
            {
                result[j]=s.substring(i,i+k);
                j++;
            }
        }
        else
        {
            int p=0;
            for(int i=0;i<s.length()/k;i++)
            {
                result[j]=s.substring(p,p+k);
                p=p+k;
                j++;
            }
            result[j]=s.substring(p);
            while(result[j].length()!=k)
            {
                result[j]+=Character.toString(fill);
            }
        }
        
        return result;
        
    }
}
