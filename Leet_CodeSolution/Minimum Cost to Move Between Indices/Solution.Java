class Solution {
    public int[] minCost(int[] nums, int[][] queries) {
        int arr[][] = new int[nums.length][2];
        int forward[] = new int[nums.length];
        int backward[] = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            if (i == 0) {
                arr[i][0] = 1;
                forward[i] = 1;
            } else if (i == nums.length - 1) {
                arr[i][1] = 1;
                forward[i] = forward[i - 1] + arr[i][0];
            } else {
                if (Math.abs(nums[i] - nums[i - 1]) > Math.abs(nums[i] - nums[i + 1])) {
                    arr[i][1] = Math.abs(nums[i] - nums[i - 1]);
                    arr[i][0] = 1;
                } else {
                    arr[i][1] = 1;
                    arr[i][0] = Math.abs(nums[i] - nums[i + 1]);
                }
                forward[i] = forward[i - 1] + arr[i][0];
            }
        }
        for (int i = nums.length - 1; i >= 0; i--) {
            if (i == nums.length - 1) {
                backward[i] = 1;
            } else {
                backward[i] = arr[i][1] + backward[i + 1];
            }
        }
        int result[] = new int[queries.length];
        for (int i = 0; i < queries.length; i++) {
            if (queries[i][0] == queries[i][1]) {
                result[i] = 0;
            } else if (queries[i][0] < queries[i][1]) {
                if (queries[i][0] == 0) {
                    result[i] = forward[queries[i][1] - 1];
                } else {
                    result[i] = forward[queries[i][1] - 1] - forward[queries[i][0] - 1];
                }
            } else {
                if (queries[i][0] == nums.length - 1) {
                    result[i] = backward[queries[i][1] + 1];
                } else {
                    result[i] = backward[queries[i][1] + 1] - backward[queries[i][0] + 1];
                }
            }
        }

        return result;
    }
}
