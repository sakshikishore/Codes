class Solution {
    public int minMaxSums(int[] nums, int k) {
        Arrays.sort(nums);
        long arr[][]=new long[nums.length][k+1];
        arr[nums.length-1][1]=1;
        long sum=0;
        sum+=nums[nums.length-1];
        for(int i=nums.length-2;i>=0;i--)
        {
           sum+=nums[i];
           arr[i][1]=1;
           for(int j=1;j<k;j++)
           {
                if(arr[i+1][j]!=0)
                {
                    arr[i][j+1]=arr[i+1][j];
                    sum+=nums[i]*(arr[i][j+1]);
                    sum=sum%(1000000007);
                }
           }

           for(int j=1;j<=k;j++)
           {
                if(arr[i+1][j]!=0)
                {
                    arr[i][j]+=arr[i+1][j];
                    arr[i][j]=arr[i][j]%(1000000007);
                }
           }
           
        }
        arr=new long[nums.length][k+1];
        arr[0][1]=1;
        sum+=nums[0];
        for(int i=1;i<nums.length;i++)
        {
            sum+=nums[i];
            arr[i][1]=1;
             for(int j=1;j<k;j++)
           {
                if(arr[i-1][j]!=0)
                {
                    arr[i][j+1]=arr[i-1][j];
                    sum+=nums[i]*(arr[i][j+1]);
                    sum=sum%(1000000007);
                }
           }

           for(int j=1;j<=k;j++)
           {
                if(arr[i-1][j]!=0)
                {
                    arr[i][j]+=arr[i-1][j];
                    arr[i][j]=arr[i][j]%(1000000007);
                }
           }
            
        }

        sum=sum%(1000000007);

        return (int)sum;

    }
}
