class Solution {
    public int minimumSubarrayLength(int[] nums, int k) {
        int min=55;
      for(int i=0;i<nums.length;i++)
      {
          int p=nums[i];
          if(p>=k)
          {
              min=1;
              break;
          }
          for(int j=i+1;j<nums.length;j++)
          {
              p=p | nums[j];
              if(p>=k)
              {
                  if(j-i+1<min)
                  {
                      min=j-i+1;
                  }
                  break;
              }
          }
      }
        
        if(min==55)
        {
            return -1;
        }
        
        return min;
    }
}
