class Solution {
    public int monotoneIncreasingDigits(int n) {
       String str=Integer.toString(n);
       char c[]=str.toCharArray();
       int p=c.length-1;
       for(int i=c.length-2;i>=0;i--)
       {
           if(c[i]>c[i+1])
           {
               int q=c[i]-'0';
               q--;
               c[i]=(char)(q+'0');
               for(int j=i+1;j<=p;j++)
               {
                   c[j]='9';
               }
               p=i;
           }
       }
        String s=new String(c);
        return Integer.parseInt(s);
    }
}
