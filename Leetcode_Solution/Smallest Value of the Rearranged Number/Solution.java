class Solution {
    public long smallestNumber(long num) {
        int arr[]=new int[10];
        long x=num;
        long ans=0;
        if(x<0)
        {
            x=x*(-1);
        }
            while(x!=0)
            {
                long p=x%10;
                int r=(int)p;
                arr[r]++;
                x=x/10;
            }
        if(num<0)
        {
            for(int i=9;i>=0;i--)
            {
                if(arr[i]>0)
                {
                    for(int j=0;j<arr[i];j++)
                    {
                      ans=ans*10+i;
                    }
                }
            }
            ans=ans*-1;
        }
        else
        {
            if(arr[0]>0)
            {
                for(int i=1;i<=9;i++)
                {
                    if(arr[i]>0)
                    {
                        ans=ans*10+i;
                        arr[i]--;
                        break;
                    }
                }
                
                for(int i=0;i<=9;i++)
                {
                    for(int j=0;j<arr[i];j++)
                    {
                        ans=ans*10+i;
                    }
                }
            }
            else
            {
                for(int i=1;i<=9;i++)
                {
                    for(int j=0;j<arr[i];j++)
                    {
                        ans=ans*10+i;
                    }
                }
            }
        }
        
        
        return ans;
    }
}
