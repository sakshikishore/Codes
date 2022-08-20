class Solution {
    public int secondsToRemoveOccurrences(String s) {
        char c[]=s.toCharArray();
        int flag=0;
        int count=0;
        while(flag!=1)
        {
            flag=1;
            char ch[]=new char[s.length()];
            int i=1;
            for(int j=0;j<c.length;j++)
            {
                ch[j]=c[j];
            }
            while(i<s.length())
            {
                if(c[i-1]=='0' && c[i]=='1')
                {
                    flag=0;
                    ch[i]=c[i-1];
                    ch[i-1]=c[i];
                    i=i+2;
                }
                else
                {
                    i++;
                }
            }
            if(flag==0)
            {
                count++;
            }
            c=ch;
        }
        
        return count;
    }
}
