public class Node {
    int x, y;

    public Node(int a, int b) {
        x = a;
        y = b;
    }
}

class Solution {
    public int maxSubarray(int[] nums) {
        int ans = 0;
        if (nums.length <= 2) {
            return nums.length;
        }
        int index = 0;
        HashMap<Integer, Node> h = new HashMap<Integer, Node>();
        h.put(nums[0], new Node(-1, 0));
        if (h.containsKey(nums[1])) {
            h.put(nums[1], new Node(0, 1));
        } else {
            h.put(nums[1], new Node(-1, 1));
        }

        for (int i = 2; i < nums.length; i++) {
            for (int j = 1; j <= nums[i] / 2; j++) {
                int a = j;
                int b = nums[i] - j;
                if (a == b) {
                    if (h.containsKey(a)) {
                        if (h.get(a).x != -1) {
                            if (h.get(a).x >= index) {
                                ans = Math.max(ans, i - index);
                                index = h.get(a).x + 1;
                                int p = h.get(a).y;
                                h.put(a, new Node(-1, p));
                            }
                        }
                    }
                } else {
                    if (h.containsKey(a) && h.containsKey(b)) {
                        int p = h.get(a).y;
                        int q = h.get(b).y;
                        if (p < q) {
                            if (p >= index) {
                                h.remove(a);
                                ans = Math.max(ans, i - index);
                                index = p + 1;
                            }
                        } else {
                            if (q >= index) {
                                h.remove(b);
                                ans = Math.max(ans, i - index);
                                index = q + 1;
                            }
                        }
                    }
                }
            }
            for (int j = 1; j <= 500 - nums[i]; j++) {
                int a = j;
                int b = nums[i] + j;
                if (a == b) {
                    if (h.containsKey(a)) {
                        if (h.get(a).x != -1) {
                            if (h.get(a).x >= index) {
                                ans = Math.max(ans, i - index);
                                index = h.get(a).x + 1;
                                int p = h.get(a).y;
                                h.put(a, new Node(-1, p));
                            }
                        }
                    }
                } else {
                    if (h.containsKey(a) && h.containsKey(b)) {
                        int p = h.get(a).y;
                        int q = h.get(b).y;
                        if (p < q) {
                            if (p >= index) {
                                h.remove(a);
                                ans = Math.max(ans, i - index);
                                index = p + 1;
                            }
                        } else {
                            if (q >= index) {
                                h.remove(b);
                                ans = Math.max(ans, i - index);
                                index = q + 1;
                            }
                        }
                    }
                }
            }
            if (h.containsKey(nums[i])) {
                int z = h.get(nums[i]).y;
                if (z >= index) {
                    h.put(nums[i], new Node(z, i));
                } else {
                    h.put(nums[i], new Node(-1, i));
                }
            } else {
                h.put(nums[i], new Node(-1, i));
            }
        }

        ans = Math.max(ans, nums.length - index);

        return ans;

    }
}
