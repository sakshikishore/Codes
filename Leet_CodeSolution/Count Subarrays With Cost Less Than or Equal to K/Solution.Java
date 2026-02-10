class Solution {
    public long countSubarrays(int[] nums, long k) {
        long count = 0;
        ArrayList<Integer> l = new ArrayList<Integer>();
        int index = 0;
        for (int i = 0; i < nums.length; i++) {
            if (l.size() == 0) {
                l.add(nums[0]);
                count++;
            } else {
                int low = 0, high = l.size() - 1;
                while (low <= high) {
                    int mid = (low + high) / 2;
                    if (l.get(mid) > nums[i]) {
                        high = mid - 1;
                    } else {
                        low = mid + 1;
                    }
                }
                l.add(low, nums[i]);
                long max = l.get(l.size() - 1);
                long min = l.get(0);
                while ((max - min) * l.size() > k) {
                    low = 0;
                    high = l.size() - 1;
                    while (low <= high) {
                        int mid = (low + high) / 2;
                        if (l.get(mid) == nums[index]) {
                            l.remove(mid);
                            break;
                        } else if (l.get(mid) > nums[index]) {
                            high = mid - 1;
                        } else {
                            low = mid + 1;
                        }
                    }
                    index++;
                    max = l.get(l.size() - 1);
                    min = l.get(0);
                }
                count += l.size();
            }
        }

        return count;
    }
}
