class Solution {
    public String smallestString(String s) {
        char c[]=s.toCharArray();
        int flag=0;
        for(int i=0;i<s.length();i++)
        {
            if(c[i]=='a')
            {
                if(flag==1)
                {
                break;
                }
            }
            else
            {
                flag=1;
                int p=c[i]-'a'-1;
                c[i]=(char)(97+p);
            }
        }
        if(flag==0)
        {
            c[c.length-1]='z';
        }
        
        return new String(c);
    }
}
