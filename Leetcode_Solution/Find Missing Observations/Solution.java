class Solution {
    public int[] missingRolls(int[] rolls, int mean, int n) {
        int sum=0;
        int result[];
        for(int i=0;i<rolls.length;i++)
        {
            sum=sum+rolls[i];
        }
        int m=n+rolls.length;
        int x=m*mean;
        x=x-sum;
        int p=x/n;
        if((x>=n && p<6) ||(p==6 && p*n==x))
        {
            result=new int[n];        
            for(int j=0;j<n;j++)
            {
                result[j]=p;
            }
            int total=x-(n*p);
            int l=0;
            if(total!=0)
            {
                while(total!=0)
                {
                    
                    result[l]+=1;
                    total--;
                    l++;
                    if(l==n)
                    {
                        l=0;
                    }
                }
            }
        }
        else
        {
            result=new int[0];
        }
        
        return result;
        
    }
}
