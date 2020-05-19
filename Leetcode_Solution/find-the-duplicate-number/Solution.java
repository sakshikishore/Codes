class Solution {
    public int findDuplicate(int[] nums) {
        ArrayList<Integer> l=new ArrayList<Integer>();
        int result=0;
        for(int i=0;i<nums.length;i++)
        {
            if(l.contains(nums[i]))
            {
                result=nums[i];
                break;
            }
            else
            {
                l.add(nums[i]);
            }
        }
        
        return result;
    }
}
