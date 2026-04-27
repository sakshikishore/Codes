class Solution {
    public List<Integer> findValidElements(int[] nums) {
        ArrayList<Integer> result = new ArrayList<Integer>();
        HashSet<Integer> hset = new HashSet<Integer>();
        int max = nums[0];
        hset.add(0);
        hset.add(nums.length - 1);
        for (int i = 1; i < nums.length - 1; i++) {
            if (nums[i] > max) {
                hset.add(i);
                max = nums[i];
            }
        }
        max = nums[nums.length - 1];
        for (int i = nums.length - 2; i >= 0; i--) {
            if (nums[i] > max) {
                hset.add(i);
                max = nums[i];
            }
        }
        for (int i = 0; i < nums.length; i++) {
            if (hset.contains(i)) {
                result.add(nums[i]);
            }
        }

        return result;
    }
}
