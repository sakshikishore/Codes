class Solution {
    public int minMoves(int[] nums) {
        int result=0;
        Arrays.sort(nums);
        for(int i=nums.length-1;i>=1;i--){
            result+=nums[i]-nums[0];
        }

        return result;
    }
}
