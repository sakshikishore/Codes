class Solution {
    public int[][] cyclicShift(int n, int[][] grid, int[] rowShift, int[] colShift) {
        for (int i = 0; i < rowShift.length; i++) {
            int arr[] = new int[n];
            for (int j = 0; j < n; j++) {
                arr[(j - rowShift[i] + n) % n] = grid[i][j];
            }
            for (int j = 0; j < n; j++) {
                grid[i][j] = arr[j];
            }
        }
        for (int j = 0; j < colShift.length; j++) {
            int arr[] = new int[n];
            for (int i = 0; i < n; i++) {
                arr[(i - colShift[j] + n) % n] = grid[i][j];
            }
            for (int i = 0; i < n; i++) {
                grid[i][j] = arr[i];
            }
        }

        return grid;

    }
}
