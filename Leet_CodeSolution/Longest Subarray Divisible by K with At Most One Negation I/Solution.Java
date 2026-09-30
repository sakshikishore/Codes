class Solution {
    public int longestSubarray(int[] nums, int k) {
        int ans = 0;
        for (int i = 0; i < nums.length; i++) {
            int p = nums[i];
            nums[i] = (-1) * p;
            long sum = 0;
            HashMap<Long, Integer> h = new HashMap<Long, Integer>();
            for (int j = 0; j < nums.length; j++) {
                sum = (sum + nums[j]) % k;
                if (sum == 0) {
                    ans = Math.max(ans, j + 1);
                } else {
                    if(sum<0)
                    {
                        sum+=k;
                    }
                    if (!h.containsKey(sum)) {
                        h.put(sum, j);
                    } else {
                        ans = Math.max(ans, j - h.get(sum));
                    }
                }
            }
            nums[i] = p;
        }
        long sum = 0;
        HashMap<Long, Integer> h = new HashMap<Long, Integer>();
        for (int j = 0; j < nums.length; j++) {
            sum = (sum + nums[j]) % k;
            if (sum == 0) {
                ans = Math.max(ans, j + 1);
            } else {
                if(sum<0)
                {
                    sum=sum+k;
                }
                if (!h.containsKey(sum)) {
                    h.put(sum, j);
                } else {
                    ans = Math.max(ans, j - h.get(sum));
                }
            }
        }

        return ans;

    }
}
