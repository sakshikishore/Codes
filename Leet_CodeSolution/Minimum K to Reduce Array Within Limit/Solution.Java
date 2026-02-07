class Solution {
    public int minimumK(int[] nums) {
        long result=0;
        Arrays.sort(nums);
        long high=nums[nums.length-1]*1l;
        high=high*nums.length;
        if(high>100000)
        {
            high=100000;
        }
        long low=1;
        while(low<=high)
        {
            long mid=(low+high)/2;
             long count=0;
             for(int i=0;i<nums.length;i++)
             {
                  if(nums[i]%mid==0)
                  {
                     count+=(nums[i]/mid);
                  }
                  else
                  {
                    count+=1+(nums[i]/mid);
                  }
                  if(count>(mid*mid))
                    {
                        break;
                    }  
                  
             }
             if(count<=(mid*mid))
             {
                result=mid;
                high=mid-1;
             }
             else
             {
                low=mid+1;
             }
        }

        return (int)(result);
    }
}
