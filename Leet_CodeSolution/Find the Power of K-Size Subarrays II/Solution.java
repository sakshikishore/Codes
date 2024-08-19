class Solution {
    public int[] resultsArray(int[] nums, int k) {
        int result[]=new int[nums.length-k+1];
        if(k==1)
        {
            return nums;
        }
        int j=0;
        int start=0,count=1;
        for(int i=1;i<nums.length;i++)
        {
            if(nums[i]!=nums[i-1]+1)
            {
                count=1;
               while(start<i && start+k<nums.length)
               {
                result[j]=-1;
                j++;
                start++;
               }
               if(j==result.length)
               {
                break;
               }
            }
            else
            {
                count++;
                if(count==k)
                {
                    start++;
                    result[j]=nums[i];
                    j++;
                    count--;
                }
            }
        }
        if(result[result.length-1]==0)
        {
            result[result.length-1]=-1;
        }

        return result;
    }
}
