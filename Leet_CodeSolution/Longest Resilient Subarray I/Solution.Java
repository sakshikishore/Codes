class Solution {
    public int resilientSubarray(int[] nums, int k) {
        int ans = 1;
        int count = 1;
        int curr = nums[0] % k;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] % k == curr) {
                count++;
                int p = count % k;
                if (nums[i] % k == 0) {
                    ans = Math.max(ans, count);
                } else if (p == 1) {
                    ans = Math.max(ans, count);
                }
                else
                {
                   if(((p-1)*curr)%k==0)
                   {
                      ans = Math.max(ans, count);
                   }
                }
            } else {
                curr = nums[i] % k;
                count = 1;
            }
        }

        return ans;
    }
}
