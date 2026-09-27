class Solution {
    public int[] rearrangeArray(int[] nums) {
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
        int ans[] = new int[nums.length];
        ArrayList<Integer> l = new ArrayList<Integer>();
        Arrays.sort(nums);
        for (int i = 0; i < nums.length; i++) {
            if (!map.containsKey(nums[i])) {
                map.put(nums[i], 1);
                l.add(nums[i]);
            } else {
                map.put(nums[i], map.get(nums[i]) + 1);
            }
        }
        int i = 0;
        while (i < nums.length) {
            for (int j = 0; j < l.size(); j++) {
                if (map.containsKey(l.get(j))) {
                    ans[i] = l.get(j);
                    map.put(l.get(j), map.get(l.get(j)) - 1);
                    if (map.get(l.get(j)) == 0) {
                        map.remove(l.get(j));
                    }
                    i++;
                    if (i == nums.length) {
                        break;
                    }
                }
            }
        }

        return ans;

    }
}
