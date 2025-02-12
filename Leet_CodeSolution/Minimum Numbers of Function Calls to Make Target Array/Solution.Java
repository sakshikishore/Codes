class Solution {
    public int minOperations(int[] nums) {
        int totalOnes=0,totalTwo=0;
        Arrays.sort(nums);
        if(nums[nums.length-1]==1)
        {
            for(int i=0;i<nums.length;i++)
            {
                if(nums[i]==1)
                {
                    totalOnes++;
                }
            }

            return totalOnes;
        }
        else
        {
            int x=nums[nums.length-1];
            if(x%2!=0)
            {
                totalOnes=1;
                x=x-1;
            }
            while(x/2>=1)
            {
               x=x/2;
               if(x%2!=0)
               {
                totalOnes++;
                x=x-1;
               }
               totalTwo++;
            }
            for(int i=0;i<nums.length-1;i++)
            {
               if(nums[i]==1)
               {
                totalOnes++;
               }
               else
               {
                    x=nums[i];
                    if(x%2!=0)
                    {
                        totalOnes+=1;
                        x=x-1;
                    }
                    while(x/2>=1)
                    {
                    x=x/2;
                    if(x%2!=0)
                    {
                        totalOnes++;
                        x=x-1;
                    }
                  }

               }
            }
        }

        return totalOnes+totalTwo;
    }
}
