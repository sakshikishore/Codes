class Solution {
    public String getSmallestString(String s, int k) {
        if(k==0)
        {
            return s;
        }
        int count=0;
        char result[]=new char[s.length()];
        char c[]=s.toCharArray();
        for(int i=0;i<c.length;i++)
        {
            int flag=0;
            int x=c[i]-'a';
            for(int j=0;j<x;j++)
            {
                int m1=x-j;
                int m2=(26+j)-x;
                int min=Math.min(m1,m2);
                if(min+count<=k)
                {
                    count+=min;
                    result[i]=(char)(97+j);
                    flag=1;
                    break;
                }
            }
            if(flag==0)
            {
                result[i]=c[i];
            }
        }
        
        return new String(result);
    }
}
