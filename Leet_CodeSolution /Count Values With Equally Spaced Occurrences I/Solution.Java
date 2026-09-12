class Solution {
    public int countSpecialIntegers(int[] nums) {
        HashMap<Integer, ArrayList<Integer>> h = new HashMap<Integer, ArrayList<Integer>>();
        int result = 0;
        for (int i = 0; i < nums.length; i++) {
            if (!h.containsKey(nums[i])) {
                ArrayList<Integer> l = new ArrayList<Integer>();
                l.add(i);
                h.put(nums[i], l);
            } else {
                ArrayList<Integer> l = h.get(nums[i]);
                l.add(i);
                h.put(nums[i], l);
            }
        }
        for (Map.Entry<Integer, ArrayList<Integer>> entry : h.entrySet()) {
            ArrayList<Integer> l = entry.getValue();
            if (l.size() == 3) {
                if (l.get(1) - l.get(0) == l.get(2) - l.get(1)) {
                    result++;
                }
            }
        }

        return result;
    }
}
