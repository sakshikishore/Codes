class Solution {
    public int maxEqualAdjacentPairs(int[] nums) {
        HashMap<Integer, HashMap<Integer, Integer>> h = new HashMap<Integer, HashMap<Integer, Integer>>();
        int ans = 0;
        int p=0;
        for (int i = 0; i < nums.length - 1; i++) {
            if (nums[i] == nums[i + 1]) {
                ans++;
                continue;
            }
            int x = Math.min(nums[i], nums[i + 1]);
            int y = Math.max(nums[i], nums[i + 1]);
            if (!h.containsKey(x)) {
                HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
                map.put(y, 1);
                h.put(x, map);
            } else {
                HashMap<Integer, Integer> map = h.get(x);
                if (!map.containsKey(y)) {
                    map.put(y, 1);
                } else {
                    map.put(y, map.get(y) + 1);
                }
                h.put(x, map);
            }
            p=Math.max(p,h.get(x).get(y));
        }


        return ans+p;
    }
}
