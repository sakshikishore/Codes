class Solution {
    public boolean checkValidCuts(int n, int[][] rectangles) {
        TreeMap<Integer, Integer> t = new TreeMap<Integer, Integer>();
        for (int i = 0; i < rectangles.length; i++) {
            if (!t.containsKey(rectangles[i][1])) {
                t.put(rectangles[i][1], rectangles[i][3]);
            } else {
                int x = t.get(rectangles[i][1]);
                t.put(rectangles[i][1], Math.max(rectangles[i][3], x));
            }
        }
        int end = -1, count = 0;
        for (Map.Entry<Integer, Integer> entry : t.entrySet()) {
            int key = entry.getKey();
            int val = entry.getValue();
            if (end == -1) {
                count = 1;
                end = val;
            } else {
                if (key >= end) {
                    end = val;
                    count++;
                } else {
                    if (val > end) {
                        end = val;
                    }
                }
            }
            if (count >= 3) {
                return true;
            }
        }
        t = new TreeMap<Integer, Integer>();
        for (int i = 0; i < rectangles.length; i++) {
            if (!t.containsKey(rectangles[i][0])) {
                t.put(rectangles[i][0], rectangles[i][2]);
            } else {
                int x = t.get(rectangles[i][0]);
                t.put(rectangles[i][0], Math.max(rectangles[i][2], x));
            }
        }
        end = -1;
        count = 0;
        for (Map.Entry<Integer, Integer> entry : t.entrySet()) {
            int key = entry.getKey();
            int val = entry.getValue();
            if (end == -1) {
                count = 1;
                end = val;
            } else {
                if (key >= end) {
                    end = val;
                    count++;
                } else {
                    if (val > end) {
                        end = val;
                    }
                }
            }
            if (count >= 3) {
                return true;
            }
        }

        return false;
    }
}
