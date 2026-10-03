class Solution {
    public int[] countTasks(int[] tasks, int[] shifts) {
        int ans[] = new int[shifts.length];
        long pref[] = new long[tasks.length];
        for (int i = 0; i < tasks.length; i++) {
            if (i == 0) {
                pref[i] = tasks[i] * 1l;
            } else {
                pref[i] = pref[i - 1] + tasks[i];
            }
        }

        long diff = 0;
        int start = 0;
        for (int i = 0; i < shifts.length; i++) {
            int low = start, high = tasks.length - 1;
            while (low <= high) {
                int mid = (low + high) / 2;
                if (pref[mid] - diff <= shifts[i]) {
                    low = mid + 1;
                } else {
                    high = mid - 1;
                }
            }
            if (low == start) {
                ans[i] = tasks.length - start;
                diff += shifts[i];
            } else {
                if (low == tasks.length) {
                    ans[i] = 0;
                    diff = 0;
                    start = 0;
                } else {
                    start = low;
                    ans[i] = tasks.length - low;
                    diff = shifts[i] - (pref[low - 1] - diff) + pref[start - 1];
                }

            }
        }

        return ans;
    }
}
