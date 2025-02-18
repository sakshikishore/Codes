class Solution {
    public int minZeroArray(int[] nums, int[][] queries) {
        int flag = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                flag = 1;
            }
        }
        if (flag == 0) {
            return 0;
        }
        int low = 0, high = queries.length - 1;
        int ans = -1;
        while (low <= high) {
            int mid = (low + high) / 2;
            int arr[] = new int[nums.length + 1];
            for (int j = 0; j <= mid; j++) {
                arr[queries[j][0]] += queries[j][2];
                arr[queries[j][1] + 1] -= queries[j][2];
            }
            flag = 0;
            for (int j = 1; j < arr.length - 1; j++) {
                arr[j] += arr[j - 1];
                if (arr[j] < nums[j]) {
                    flag = 1;
                    break;
                }
            }
            if (flag == 0) {
                if (arr[0] >= nums[0]) {
                    ans = mid + 1;
                    high = mid - 1;
                } else {
                    low = mid + 1;
                }
            } else {
                low = mid + 1;
            }
        }

        return ans;
    }
}
