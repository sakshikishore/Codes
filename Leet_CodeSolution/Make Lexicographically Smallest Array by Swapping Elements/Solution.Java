class Solution {
    public int[] lexicographicallySmallestArray(int[] nums, int limit) {
        int result[] = new int[nums.length];
        ArrayList<Integer> alist = new ArrayList<Integer>();
        HashMap<Integer, ArrayList<Integer>> h = new HashMap<Integer, ArrayList<Integer>>();
        for (int i = 0; i < nums.length; i++) {
            if (!h.containsKey(nums[i])) {
                alist.add(nums[i]);
                ArrayList<Integer> l = new ArrayList<Integer>();
                l.add(i);
                h.put(nums[i], l);
            } else {
                ArrayList<Integer> l = h.get(nums[i]);
                l.add(i);
                h.put(nums[i], l);
            }
        }
        nums = new int[alist.size()];
        for (int i = 0; i < alist.size(); i++) {
            nums[i] = alist.get(i);
        }
        int z = 0;
        Arrays.sort(nums);
        while (z < nums.length) {
            Queue<Integer> q = new LinkedList<Integer>();
            q.add(nums[z]);
            ArrayList<Integer> al = new ArrayList<Integer>();
            PriorityQueue<Integer> pq = new PriorityQueue<Integer>();
            while (q.size() > 0) {
                int x = q.poll();
                ArrayList<Integer> l = h.get(x);
                for (int i = 0; i < l.size(); i++) {
                    al.add(x);
                    pq.add(l.get(i));
                }
                int max = limit + x;
                z++;
                while (z < nums.length && nums[z] <= max) {
                    q.add(nums[z]);
                    z++;
                }
                z = z - 1;
            }
            z++;
            int k = 0;
            while (pq.size() > 0) {
                result[pq.poll()] = al.get(k);
                k++;
            }
        }
        return result;
    }
}
