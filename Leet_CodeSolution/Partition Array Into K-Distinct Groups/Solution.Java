class Solution {
    public boolean partitionArray(int[] nums, int k) {
        if (nums.length % k != 0) {
            return false;
        }
        int totalGroup = nums.length / k;
        HashMap<Integer, Integer> h = new HashMap<Integer, Integer>();
        for (int i = 0; i < nums.length; i++) {
            if (!h.containsKey(nums[i])) {
                h.put(nums[i], 1);
            } else {
                h.put(nums[i], h.get(nums[i]) + 1);
            }
            if (h.get(nums[i]) > totalGroup) {
                return false;
            }
        }

        return true;
    }
}
