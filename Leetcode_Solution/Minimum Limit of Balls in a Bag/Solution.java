class Solution {
    public int minimumSize(int[] nums, int maxOperations) {
        int result=0;
        Arrays.sort(nums);
        int max=nums[nums.length-1];
        int min=1;
        while(min<=max)
        {
            int mid=(max+min)/2;
            double m=mid;
            double sum=0;
            int flag=0;
            for(int j=0;j<nums.length;j++)
            {
              if(nums[j]>mid)
              {
                  sum+=Math.ceil(nums[j]/m);
                  sum=sum-1;
                  if(sum>maxOperations)
                  {
                      flag=1;
                      break;
                  }
              }
            }
            if(flag==0)
            {
                result=mid;
                max=mid-1;
            }
            else
            {
                min=mid+1;
            }
        }
        
        return result;
    }
}
