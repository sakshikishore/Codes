class Solution {
    public int[] decrypt(int[] code, int k) {
        int result[]=new int[code.length];
        if(k==0)
        {
            for(int i=0;i<code.length;i++)
            {
                result[i]=0;
            }
        }
        if(k>0)
        {
            for(int i=0;i<code.length;i++)
            {
                int sum=0;
                for(int j=i+1;j<=i+k;j++)
                {
                    sum=sum+code[j%code.length];
                }
                result[i]=sum;
            }
        }
        if(k<0)
        {
             for(int i=0;i<code.length;i++)
             {
                int sum=0;
                int count=k;
                int p=i-1;
                 while(count<0)
                 {                    
                     sum=sum+code[(p+code.length)%code.length];
                     p--;
                     count++;
                 }
                 result[i]=sum;
             }
        }
        
        return result;
    }
}
