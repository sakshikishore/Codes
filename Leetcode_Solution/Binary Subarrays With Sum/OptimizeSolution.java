class Solution {
    public int numSubarraysWithSum(int[] nums, int goal) {

        if (goal == 0) {
            int count = 0, result = 0;
            for (int i = 0; i < nums.length; i++) {
                if (nums[i] == 0) {
                    count++;
                } else {
                    result += ((count) * (count + 1)) / 2;
                    count = 0;
                }
            }

            result += ((count) * (count + 1)) / 2;

            return result;
        }
        int flag = 0, result = 0;
        int prev = 0;
        ArrayList<Integer> l = new ArrayList<Integer>();
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 1 && flag == 0) {
                l.add(i);
                if (l.size() == goal) {
                    result = l.get(0) + 1;
                    prev = result;
                    flag = 1;
                }
            } else if (nums[i] == 1) {
                int p = l.remove(0);
                if (l.size() == 0) {
                    result += i - p;
                    prev = i - p;
                } else {
                    int x = l.get(0);
                    result += x - p;
                    prev = x - p;
                }
                l.add(i);
            } else if (flag == 1) {
                result += prev;
            }

        }

        return result;
    }
}
