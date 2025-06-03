class Solution {
    public int maxCandies(int[] status, int[] candies, int[][] keys, int[][] containedBoxes, int[] initialBoxes) {
        Queue<Integer> q = new LinkedList<Integer>();
        HashMap<Integer, Integer> h = new HashMap<Integer, Integer>();
        for (int i = 0; i < initialBoxes.length; i++) {
            q.add(initialBoxes[i]);
            h.put(initialBoxes[i], 1);
        }
        HashSet<Integer> hset = new HashSet<Integer>();
        int totalCandies = 0;
        while (q.size() > 0) {
            int len = q.size();
            int flag = 0;
            for (int i = 0; i < len; i++) {
                int x = q.poll();
                if (status[x] == 1) {
                    totalCandies += candies[x];
                    h.remove(x);
                    hset.add(x);

                    for (int j = 0; j < containedBoxes[x].length; j++) {
                        if (!h.containsKey(containedBoxes[x][j]) && !hset.contains(containedBoxes[x][j])) {

                            q.add(containedBoxes[x][j]);
                            h.put(containedBoxes[x][j], 1);
                            if (status[containedBoxes[x][j]] == 1) {
                                flag = 1;
                            }
                        }
                    }
                    for (int j = 0; j < keys[x].length; j++) {
                        if (!hset.contains(keys[x][j])) {
                            flag = 1;
                            status[keys[x][j]] = 1;
                        }
                    }

                } else {
                    q.add(x);
                }
            }
            if (flag == 0) {
                break;
            }
        }

        return totalCandies;
    }
}
