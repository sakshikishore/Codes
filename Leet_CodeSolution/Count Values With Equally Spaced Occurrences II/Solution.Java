class Solution {
    public int countSpecialIntegers(int[] nums) {
        HashMap<Integer, ArrayList<Integer>> h = new HashMap<Integer, ArrayList<Integer>>();
        int ans = 0;
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
            ArrayList<Integer> list = entry.getValue();
            int flag = 0;
            if (list.size() >= 3) {
                int diff = list.get(1) - list.get(0);
                for (int j = 2; j < list.size(); j++) {
                    if (list.get(j) - list.get(j - 1) != diff) {
                        flag = 1;
                    }
                }

                if (flag == 0) {
                    ans++;
                }
            }
        }

        return ans;
    }
}
