class Solution {
    public int countWays(List<Integer> nums) {
        Collections.sort(nums);
        int result=0;
        for(int i=0;i<nums.size()-1;i++)
        {
            if(i+1>nums.get(i) && i+1<nums.get(i+1))
            {
                result++;
            }
            
        }
        if(nums.get(0)>0)
        {
            result++;
        }
        if(nums.get(nums.size()-1)<nums.size())
        {
            result++;
        }
        
       
        return result;
        
       
        
   }
}
