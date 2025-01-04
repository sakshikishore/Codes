class Solution {
    public int minimumOperations(int[][] grid) {
        int arr[][] = new int[grid[0].length][10];
        for (int i = 0; i < grid[0].length; i++) {
            int c[] = new int[10];
            for (int j = 0; j < grid.length; j++) {
                int p = grid[j][i];
                c[p]++;
            }
            if (i == 0) {
                for (int j = 0; j < 10; j++) {
                    arr[i][j] = grid.length - c[j];
                }
            } else {
                for (int j = 0; j < 10; j++) {
                    int x = grid.length - c[j];
                    int flag = 0;
                    int min = 0;
                    for (int k = 0; k < 10; k++) {
                        if (k != j) {
                            if (flag == 0) {
                                min = arr[i - 1][k];
                                flag = 1;
                            } else {
                                min = Math.min(min, arr[i - 1][k]);
                            }

                        }
                    }
                    arr[i][j] = x + min;
                }
            }
        }
        int result = Integer.MAX_VALUE;
        for (int i = 0; i < 10; i++) {
            if (arr[grid[0].length - 1][i] < result) {
                result = arr[grid[0].length - 1][i];
            }
        }

        return result;
    }
}
