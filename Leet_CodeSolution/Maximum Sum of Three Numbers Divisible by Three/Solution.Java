class Solution {
    public int maximumSum(int[] nums) {
        Arrays.sort(nums);
        int a1 = 0, a2 = 0, a3 = 0; // 0 remainder
        int b1 = 0, b2 = 0, b3 = 0; // 1 remainder
        int c1 = 0, c2 = 0, c3 = 0; // 2 remainder

        for (int i = nums.length - 1; i >= 0; i--) {
            if (nums[i] % 3 == 0) {
                if (a1 == 0) {
                    a1 = nums[i];
                } else if (a2 == 0) {
                    a2 = nums[i];
                } else if (a3 == 0) {
                    a3 = nums[i];
                }
            } else if (nums[i] % 3 == 1) {

                if (b1 == 0) {
                    b1 = nums[i];
                } else if (b2 == 0) {
                    b2 = nums[i];
                } else if (b3 == 0) {
                    b3 = nums[i];
                }
            } else {

                if (c1 == 0) {
                    c1 = nums[i];
                } else if (c2 == 0) {
                    c2 = nums[i];
                } else if (c3 == 0) {
                    c3 = nums[i];
                }
            }
        }

        int max = 0;
        if (a1 != 0 && a2 != 0 && a3 != 0) {
            max = a1 + a2 + a3;
        }
        if (b1 != 0 && b2 != 0 && b3 != 0) {
            max = Math.max(b1 + b2 + b3, max);
        }
        if (c1 != 0 && c2 != 0 && c3 != 0) {
            max = Math.max(c1 + c2 + c3, max);
        }
        if (a1 != 0 && b1 != 0 && c1 != 0) {
            max = Math.max(c1 + b1 + a1, max);
        }
        return max;
    }
}
