class Solution {
    public int maxFrequency(int[] nums, int k) {
        int pref[] = new int[nums.length];
        int sum = 0;
        HashSet<Integer> hset = new HashSet<Integer>();
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == k) {
                sum += 1;
            } else {
                hset.add(nums[i]);
            }
            pref[i] = sum;
        }
        if (sum == nums.length) {
            return sum;
        }
        int max = sum + 1;
        Iterator<Integer> itr = hset.iterator();
        while (itr.hasNext()) {
            int x = itr.next();
            int j = 0;
            while (nums[j] != x) {
                j++;
            }
            Queue<Integer> q = new LinkedList<Integer>();
            q.add(j);
            j++;
            while (j < nums.length) {
                if (nums[j] == x) {
                    if (q.peek() == 0) {
                        if (pref[j] >= q.size() + 1) {
                            q.poll();
                            if (q.size() > 0) {
                                int t = q.peek();
                                while (q.size() > 0 && pref[j] - pref[t - 1] >= q.size() + 1) {
                                    q.poll();
                                    if (q.size() > 0) {
                                        t = q.peek();
                                    }
                                }
                                q.add(j);

                                if (q.size() + sum - (pref[j] - pref[t - 1]) > max) {
                                    max = q.size() + sum - (pref[j] - pref[t - 1]);
                                }

                            } else {
                                q.add(j);
                            }
                        } else {
                            q.add(j);
                            if (q.size() + sum - pref[j] > max) {
                                max = q.size() + sum - pref[j];
                            }
                        }
                    } else {
                        int t = q.peek();
                        while (q.size() > 0 && pref[j] - pref[t - 1] >= q.size() + 1) {
                            q.poll();
                            if (q.size() > 0) {
                                t = q.peek();
                            }
                        }
                        q.add(j);
                        if (q.size() + sum - (pref[j] - pref[t - 1]) > max) {
                            max = q.size() + sum - (pref[j] - pref[t - 1]);
                        }

                    }
                }
                j++;
            }
        }

        return max;

    }
}
