class Solution {
    public long weightedSum(int[] parent, int[] nums) {
        HashMap<Integer, ArrayList<Integer>> parentChildrenMap = new HashMap<Integer, ArrayList<Integer>>();
        for (int i = 1; i < parent.length; i++) {
            if (!parentChildrenMap.containsKey(parent[i])) {
                ArrayList<Integer> l = new ArrayList<Integer>();
                l.add(i);
                parentChildrenMap.put(parent[i], l);
            } else {
                ArrayList<Integer> l = parentChildrenMap.get(parent[i]);
                l.add(i);
                parentChildrenMap.put(parent[i], l);
            }
        }
        Queue<Integer> q = new LinkedList<Integer>();
        q.add(0);
        int height = 0;
        while (q.size() > 0) {
            int len = q.size();
            height++;
            for (int i = 0; i < len; i++) {
                int p = q.poll();
                if (parentChildrenMap.containsKey(p)) {
                    ArrayList<Integer> childrenList = parentChildrenMap.get(p);
                    for (int j = 0; j < childrenList.size(); j++) {
                        q.add(childrenList.get(j));
                    }
                }
            }
        }
        q = new LinkedList<Integer>();
        q.add(0);
        int depth = 0;
        long weightedSum = 0;
        while (q.size() > 0) {
            int len = q.size();
            depth++;
            for (int i = 0; i < len; i++) {
                int p = q.poll();
                weightedSum += (nums[p] * (height - depth + 1l));
                if (parentChildrenMap.containsKey(p)) {
                    ArrayList<Integer> childrenList = parentChildrenMap.get(p);
                    for (int j = 0; j < childrenList.size(); j++) {
                        q.add(childrenList.get(j));
                    }
                }
            }
        }

        return weightedSum;

    }
}
