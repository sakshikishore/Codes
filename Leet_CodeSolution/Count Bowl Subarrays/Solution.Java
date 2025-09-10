class Solution {
    public long bowlSubarrays(int[] nums) {
        long ans = 0;
        Stack<Integer> stck = new Stack<Integer>();
        stck.push(nums[0]);
        int arr1[] = new int[nums.length];
        arr1[0] = -1;
        for (int i = 1; i < nums.length; i++) {
            while (stck.size() > 0 && stck.peek() <= nums[i]) {
                stck.pop();
            }
            if (stck.size() == 0) {
                arr1[i] = -1;
            } else {
                arr1[i] = 1;
            }
            stck.push(nums[i]);
        }

        stck = new Stack<Integer>();
        stck.push(nums[nums.length - 1]);
        int arr2[] = new int[nums.length];
        arr2[arr1.length - 1] = -1;
        for (int i = nums.length - 2; i >= 0; i--) {
            while (stck.size() > 0 && stck.peek() <= nums[i]) {
                stck.pop();
            }
            if (stck.size() == 0) {
                arr2[i] = -1;
            } else {
                arr2[i] = 1;
            }
            stck.push(nums[i]);
        }

        for (int i = 1; i < nums.length - 1; i++) {
            if (arr1[i] == 1 && arr2[i] == 1) {
                ans++;
            }
        }

        return ans;
    }
}
