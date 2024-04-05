class Solution {
    public long countSubarrays(int[] nums, int minK, int maxK) {
        int min=Integer.MAX_VALUE;
        int max=Integer.MIN_VALUE;
        int start=0,endMin=-1,endMax=-1;
        long result=0;
        for(int i=0;i<nums.length;i++)
        {
           if(nums[i]<min)
           {
             min=nums[i];
           }
           if(nums[i]>max)
           {
              max=nums[i];
           }
           if(nums[i]==minK)
           {
            endMin=i;
           }
           if(nums[i]==maxK)
           {
            endMax=i;
           }
           if(min==minK && max==maxK)
           {
            
            int m=Math.min(endMin,endMax);
            result+=m-start+1;
           }
           else if(min<minK || max>maxK)
           {
             start=i+1;
             endMin=-1;
             endMax=-1;
             min=Integer.MAX_VALUE;
             max=Integer.MIN_VALUE;
           }
        }

        return result;
        
    }
}
