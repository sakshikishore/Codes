class Solution {
    public long maxPairStrength(int[] nums) {
        long ans = 0;
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                int a = nums[i], b = nums[j];
                while (b > 0) {
                    int r = a % b;
                    a = b;
                    b = r;
                }
                long p = nums[i] * 1l;
                p = p * nums[j];
                p = p / (a * a);
                if(p>ans)
                {
                    ans=p;
                }
            }
        }

        return ans;
    }
}
