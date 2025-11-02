class Solution {
    public List<Integer> findMissingElements(int[] nums) {
        Arrays.sort(nums);
        List<Integer> result=new ArrayList<Integer>();
        int val=nums[0]+1,i=1;
        while(i<nums.length)
        {
            if(nums[i]!=val)
            {
                result.add(val);
                val=val+1;
            }
            else
            {
                i++;
                val++;
            }
        }

        return result;
    }
}
