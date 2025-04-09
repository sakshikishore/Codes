class Solution {
    public double maxAverageRatio(int[][] classes, int extraStudents) {
        PriorityQueue<Double> pq = new PriorityQueue<Double>(Collections.reverseOrder());
        HashMap<Double, ArrayList<Integer>> h = new HashMap<Double, ArrayList<Integer>>();
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
        for (int i = 0; i < classes.length; i++) {
            double x = (classes[i][0] + 1) / ((classes[i][1] + 1) * 1.0);
            x = x - (classes[i][0]) / ((classes[i][1]) * 1.0);
            pq.add(x);
            if (!h.containsKey(x)) {
                ArrayList<Integer> l = new ArrayList<Integer>();
                l.add(i);
                h.put(x, l);
            } else {
                ArrayList<Integer> l = h.get(x);
                l.add(i);
                h.put(x, l);
            }
        }
        for (int i = 0; i < extraStudents; i++) {
            double x = pq.poll();
            ArrayList<Integer> l = h.get(x);
            int index = l.get(0);
            l.remove(0);
            if (l.size() == 0) {
                h.remove(x);
            }
            else
            {
                h.put(x,l);
            }
            if (!map.containsKey(index)) {
                map.put(index, 1);
            } else {
                map.put(index, map.get(index) + 1);
            }
            int p = map.get(index);
            x = (classes[index][0] + 1 + p) / ((classes[index][1] + 1 + p) * 1.0);
            x = x - (classes[index][0] + p) / ((classes[index][1] + p) * 1.0);
            pq.add(x);
            if (!h.containsKey(x)) {
                l = new ArrayList<Integer>();
                l.add(index);
                h.put(x, l);
            } else {
                l = h.get(x);
                l.add(index);
                h.put(x, l);
            }
        }
        double result = 0.0;
        for (int i = 0; i < classes.length; i++) {
            if (map.containsKey(i)) {
                int k = map.get(i);
                result += (classes[i][0] + k) / ((classes[i][1] + k) * 1.0);
            } else {
                result += classes[i][0] / (classes[i][1] * 1.0);
            }
        }

        result = result / classes.length;

        return result;
    }
}
