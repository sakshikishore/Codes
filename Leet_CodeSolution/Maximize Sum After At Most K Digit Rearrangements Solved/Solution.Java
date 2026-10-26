class Solution {
    public long maximizeSum(int[] nums, int k) { 
        long result = 0;
        PriorityQueue<Long> pq = new PriorityQueue<Long>(Collections.reverseOrder());
        for (int i = 0; i < nums.length; i++) {
            result += nums[i];
            int n = nums[i];
            int arr[] = new int[10];
            while (n > 0) {
                int r = n % 10;
                arr[r]++;
                n = n / 10;
            }
            long val = 0;
            for (int j = 9; j >= 0; j--) {
                while (arr[j] > 0) {
                    val = val * 10 + j;
                    arr[j]--;
                }
            }
            pq.add(val - nums[i]);
        }
        int j = 0;
        while (pq.size() > 0 && j < k) {
            result += pq.poll();
            j++;
        }

        return result;
    }
}
