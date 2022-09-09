class Solution {
    public int minimumLength(String s) {
        int c[]=new int[s.length()];
        c[s.length()-1]=1;
        for(int i=s.length()-2;i>=0;i--)
        {
            if(s.charAt(i)==s.charAt(i+1))
            {
                c[i]=c[i+1]+1;
            }
            else
            {
                c[i]=1;
            }
        }
        int d[]=new int[s.length()];
        d[0]=1;
        for(int i=1;i<s.length();i++)
        {
            if(s.charAt(i)==s.charAt(i-1))
            {
               d[i]=d[i-1]+1; 
            }
            else
            {
                d[i]=1;
            }
        }
        int i=0,j=s.length()-1;
        while(i<j)
        {
            if(s.charAt(i)==s.charAt(j))
            {
                i=i+c[i];
                j=j-d[j];
            }
            else
            {
                break;
            }
        }
        if(i>j)
        {
            return 0;
        }
        else if(i==j)
        {
            return 1;
        }
        else
        {
            return j-i+1;
        }
    }
}
