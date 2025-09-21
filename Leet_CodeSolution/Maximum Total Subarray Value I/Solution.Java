class Solution {
    public long maxTotalValue(int[] nums, int k) {
        Arrays.sort(nums);
        return k*1l*(nums[nums.length-1]-nums[0]);
    }
}
