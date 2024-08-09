class Solution {
    public long minCost(int[] nums, int x) {
        HashMap<Integer,Integer> h=new HashMap<Integer,Integer>();  
        long total=0;
        for(int j=0;j<nums.length;j++)
        {
            h.put(j,nums[j]);
            total+=nums[j];
        }
      
       
        long result=total;
        for(int i=1;i<nums.length;i++)
        {
              total=total+x;
              for(int j=0;j<nums.length;j++)
              {
                int k=(j+i)%nums.length;
                if(nums[k]<h.get(j))
                {
                    total=total-h.get(j);
                    h.put(j,nums[k]);
                    total=total+nums[k];
                }
              }
              if(result>total)
              {
               result=total;
              }
        }

       
     
       return result;
    }
}
