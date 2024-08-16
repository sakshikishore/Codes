class Solution {
    public long minEnd(int n, int x) {
        if(n==1)
        {
            return x;
        }
        int min=x;
        String str=Integer.toBinaryString(min);
        char c[]=str.toCharArray();
        int len=0;
        for(int i=0;i<c.length;i++)
        {
            if(c[i]=='0')
            {
                len++;
            }
        }
        int p=(int)Math.pow(2,len);
        int l=0;
         while(p<n)
         {
            n=n-p;
            l++;
            if(l>1)
            {
                len++;
                p=(int)Math.pow(2,len);
            }
         }
         while(l>1)
         {
              str="0"+str;
              l--;
         }
         if(l==1)
         {
          str="1"+str;
         }
         String s=Integer.toBinaryString(n-1);
         int j=s.length()-1;
         long res=0;
         long k=0;
         for(int i=str.length()-1;i>=0;i--)
         {
            if(str.charAt(i)=='0')
            {
                if(j>=0)
                {
                res+=(long)Math.pow(2,k)*(s.charAt(j)-'0');
                j--;
                }
            }
            else
            {
                res+=(long)Math.pow(2,k)*(str.charAt(i)-'0');
            }
            k++;
         }
        
    return res;

    }
}
