class Solution {
    public List<List<Integer>> findDisappearedNumbers(int[] nums, int lower, int upper) {
        List<List<Integer>> res = new ArrayList();
        int start = -1, end = -1;
        HashSet<Integer> hset = new HashSet<Integer>();
        for (int i = 0; i < nums.length; i++) {
            hset.add(nums[i]);
        }
        for (int i = lower; i <= upper; i++) {
            if (!hset.contains(i)) {
                if (start == -1) {
                    start = i;
                    end = i;
                } else {
                    end = i;
                }
            } else {
                if (start != -1) {
                    ArrayList<Integer> l = new ArrayList<Integer>();
                    l.add(start);
                    l.add(end);
                    res.add(l);
                    start = -1;
                }
            }
        }
        if (start != -1) {
            ArrayList<Integer> l = new ArrayList<Integer>();
            l.add(start);
            l.add(end);
            res.add(l);
        }

        return res;
    }
}
