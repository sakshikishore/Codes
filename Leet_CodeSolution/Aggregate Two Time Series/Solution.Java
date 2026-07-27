class Solution {
    public List<List<Integer>> aggregateTimeSeries(int[][] series1, int[][] series2) {
        List<List<Integer>> result = new ArrayList();
        int i = 0, j = 0;
        while (i < series1.length && j < series2.length) {
            if (series1[i][0] > series2[j][0]) {
                ArrayList<Integer> list = new ArrayList<Integer>();
                list.add(series2[j][0]);
                list.add(series2[j][1] + series1[i][1]);
                result.add(list);
                j++;
            } else if (series1[i][0] < series2[j][0]) {
                ArrayList<Integer> list = new ArrayList<Integer>();
                list.add(series1[i][0]);
                list.add(series1[i][1] + series2[j][1]);
                result.add(list);
                i++;
            } else {
                ArrayList<Integer> list = new ArrayList<Integer>();
                list.add(series1[i][0]);
                list.add(series1[i][1] + series2[j][1]);
                result.add(list);
                i++;
                j++;
            }
        }
        while (i < series1.length) {
            ArrayList<Integer> list = new ArrayList<Integer>();
            list.add(series1[i][0]);
            list.add(series1[i][1]);
            result.add(list);
            i++;
        }
        while (j < series2.length) {
            ArrayList<Integer> list = new ArrayList<Integer>();
            list.add(series2[j][0]);
            list.add(series2[j][1]);
            result.add(list);
            j++;
        }

        return result;
    }
}
