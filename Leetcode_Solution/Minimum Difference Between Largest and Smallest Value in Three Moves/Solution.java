class Solution {
    public int minDifference(int[] nums) {
        int result=0;
        if(nums.length>=5)
        {
            int p=0;
            int min=Integer.MAX_VALUE;
            Arrays.sort(nums);
          for(int i=nums.length-1;i>=nums.length-4;i--)
          { 
              int k=nums[i]-nums[3-p];
             
                  if(k<min)
                  {
                      min=k;
                  }
              
              p++;
          }
            
            result=min;
            
        }
        
        return result;
    }
}
