class Solution {
    public int countLargestGroup(int n) {
        int ans=0;
        if(n<10)
        {            
            ans=n;
        }
        else
        {
            String k=Integer.toString(n);
            int arr[]=new int[9*k.length()+1];
            int max=1;
            for(int i=1;i<=n;i++)
            {
                if(i<10)
                {
                    arr[i]++;
                }
                else
                {
                    int p=i;
                    int sum=0;
                    while(p!=0)
                    {
                        sum=sum+p%10;
                        p=p/10;
                    }
                    arr[sum]++;
                    if(arr[sum]>max)
                    {
                        max=arr[sum];
                    }
                }
            }
            
            for(int i=1;i<=9*k.length();i++)
            {
                if(arr[i]==max)
                {
                    ans++;
                }
            }
        }
        
        return ans;
        
    }
}
