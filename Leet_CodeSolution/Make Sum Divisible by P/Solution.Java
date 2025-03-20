class Solution {
    public int minSubarray(int[] nums, int p) {
        int result = Integer.MAX_VALUE;
        long pref[] = new long[nums.length];
        long sum = nums[0] % p;
        pref[0] = sum;
        if (sum == 0) {
            result = nums.length - 1;
        }
        for (int i = 1; i < nums.length; i++) {
            sum = sum + nums[i];
            sum = sum % p;
            pref[i] = sum;
            if (sum == 0) {
                result = nums.length - i - 1;
            }
        }
        HashMap<Long, ArrayList<Integer>> h = new HashMap<Long, ArrayList<Integer>>();
        sum = nums[nums.length - 1] % p;
        ArrayList<Integer> l = new ArrayList<Integer>();
        l.add(nums.length - 1);
        h.put(sum, l);
        int count = 1;
        if (sum == 0) {
            result = Math.min(result, nums.length - count);
        }
        for (int i = nums.length - 2; i >= 0; i--) {
            count++;
            sum = sum + nums[i];
            sum = sum % p;
            if (sum == 0) {
                result = Math.min(result, nums.length - count);
            }
            if (!h.containsKey(sum)) {
                l = new ArrayList<Integer>();
                l.add(i);
                h.put(sum, l);
            } else {
                l = h.get(sum);
                l.add(0,i);
                h.put(sum, l);
            }
        }
        for (int i = 0; i < nums.length; i++) {
            long t = p - pref[i];
            t = t % p;
            if (h.containsKey(t)) {
                ArrayList<Integer> al = h.get(t);
                int low = 0, high = al.size() - 1;
                while (low <= high) {
                    int mid = (low + high) / 2;
                    if (al.get(mid) > (i + 1)) {
                        high = mid - 1;
                    } else if (al.get(mid) == (i + 1)) {
                        low = mid;
                        break;
                    } else {
                        low = mid + 1;
                    }
                }
                if (low < al.size()) {
                    int size = al.get(low) - i - 1;
                    result = Math.min(result, size);
                }
            }
        }

        if (result == Integer.MAX_VALUE) {
            return -1;
        }

        return result;
    }
}
