class Solution {
    public int findMaxK(int[] nums) {
        int result=-1;
        HashSet<Integer> h=new HashSet<Integer>();
        for(int i=0;i<nums.length;i++)
        {
            h.add(nums[i]);
        }
        Arrays.sort(nums);
        for(int i=nums.length-1;i>=0;i--)
        {
            if(nums[i]<0)
            {
                break;
            }
            else
            {
                int x=nums[i]*-1;
                if(h.contains(x))
                {
                    return nums[i];
                }
            }
        }
        
       return result;
    }
}
