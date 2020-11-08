class Solution {
    public int getMaximumGenerated(int n) {
         int max=0;
        int arr[]=new int[n+1];
        if(n==0)
        {
            max=0;
        }
        else if(n==1)
        {
            max=1;
        }
        else
        {
            arr[0]=0;
            arr[1]=1;
            for(int i=2;i<=n;i++)
            {
                if(i%2==0)
                {
                    arr[i]=arr[i/2];
                    if(arr[i]>max)
                    {
                        max=arr[i];
                    }
                }
                else
                {
                    int p=i/2;
                    arr[i]=arr[p]+arr[p+1];
                    if(arr[i]>max)
                    {
                        max=arr[i];
                    }
                }
            }
        }
        
        return max;
    
        
    }
}
