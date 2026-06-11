class Solution {
    public long minArraySum(int[] nums, int k) {
        HashMap<Integer, Long> h = new HashMap<Integer, Long>();
        int prev = 0;
        long prevVal = 0;
        for (int i = 0; i < nums.length; i++) {
            if (i == 0) {
                if (nums[i] % k == 0) {
                    h.put(0, 0l);
                } else {
                    int r = nums[i] % k;
                    h.put(r, nums[i] * 1l);
                    prev = r;
                    prevVal = nums[i];
                }
            } else {
                int r = (nums[i] + prev) % k;
                prev=r;
                if(r==0)
                {
                    h.put(0,0l);
                    prevVal=0;
                }
                else
                {
                    if (h.containsKey(r)) {
                        long val = h.get(r);
                        long p = prevVal + nums[i];
                        long min = Math.min(val, p);
                        h.put(r, min);
                        prevVal = min;
                    } else {
                        h.put(r, nums[i] + prevVal);
                        prevVal = nums[i] + prevVal;
                    }
                }
            }
            if (i == nums.length - 1) {
                return prevVal;
            }
        }

        return 0;

    }
}
