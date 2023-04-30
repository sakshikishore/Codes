class Solution {
    public int maximizeSum(int[] nums, int k) {
        Arrays.sort(nums);
        int maxElement=nums[nums.length-1];
        int result=maxElement;
        int x=1;
        while(x<k)
        {
            maxElement++;
            result+=maxElement;
            x++;
        }
        
        return result;
        
    }
}
