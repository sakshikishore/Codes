class Solution {
    public int smallestRangeII(int[] nums, int k) {
      Arrays.sort(nums);
      int arr1[]=new int[nums.length]; // nums[i]+k
      int arr2[]=new int[nums.length]; // nums[i]-k
      for(int i=0;i<nums.length;i++)
      {
          arr1[i]=nums[i]+k;
          arr2[i]=nums[i]-k;
      } 
      int i=nums.length-1,j=nums.length-1;
      int res=0;
      while(i>=0)
      {
          if(i==nums.length-1)
          {
               res=arr1[i]-arr1[0];
               i--;
          }
          else
          {
              if(arr1[i]<arr2[j])
              {
                  int min=arr1[0];
                  if(j!=i+1)
                  {
                       if(arr2[i+1]<min)
                       {
                           min=arr2[i+1];
                       }
                  }
                  int val=arr2[j]-min;
                  if(val<res)
                  {
                      res=val;
                  }
                  break;
              }
              else
              {
                  if(arr1[0]<arr2[i+1])
                  {
                       int val=arr1[i]-arr1[0];
                        if(val<res)
                        {
                            res=val;
                        }
                        i--;
                  }
                  else
                  {
                       int val=arr1[i]-arr2[i+1];
                        if(val<res)
                        {
                            res=val;
                        }
                        i--;
                  }
              }
          }
           System.out.println(res+" "+i);
      }
    
           return res;

    }
}
