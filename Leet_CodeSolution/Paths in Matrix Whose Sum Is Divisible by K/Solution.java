class Solution {
    public int numberOfPaths(int[][] grid, int k) {
        HashMap<Integer, long[]> h = new HashMap<Integer, long[]>();
        for (int i = grid.length - 1; i >= 0; i--) {
            int p = grid[0].length * i;
            for (int j = grid[0].length - 1; j >= 0; j--) {
                if (i == grid.length - 1) {
                    if (j == grid[0].length - 1) {
                        long arr[] = new long[k];
                        int val = grid[i][j] % k;
                        arr[val]++;
                        h.put(p + j, arr);
                    } else {
                        long a[] = h.get(p + j + 1);
                        long arr[] = new long[k];
                        for (int l = 0; l < k; l++) {
                            if (a[l] != 0) {
                                int sum = (l + grid[i][j]) % k;
                                arr[sum] = a[l];
                                arr[sum] = arr[sum] % (1000000007);
                                break;
                            }
                        }
                        h.put(p + j, arr);
                    }
                } else if (j == grid[0].length - 1) {

                    long a[] = h.get(((i + 1) * grid[0].length) + j);
                    long arr[] = new long[k];
                    for (int l = 0; l < k; l++) {
                        if (a[l] != 0) {
                            int sum = (l + grid[i][j]) % k;
                            arr[sum] = a[l];
                            arr[sum] = arr[sum] % (1000000007);
                            break;
                        }
                    }
                    h.put(p + j, arr);
                } else {
                    long a[] = h.get(p + j + 1);
                    long arr[] = new long[k];
                    for (int l = 0; l < k; l++) {
                        if (a[l] != 0) {
                            int sum = (l + grid[i][j]) % k;
                            arr[sum] += a[l];
                            arr[sum] = arr[sum] % (1000000007);
                        }
                    }
                    long a2[] = h.get(((i + 1) * grid[0].length) + j);
                    for (int l = 0; l < k; l++) {
                        if (a2[l] != 0) {
                            int sum = (l + grid[i][j]) % k;
                            arr[sum] += a2[l];
                            arr[sum] = arr[sum] % (1000000007);
                        }
                    }
                    h.put(p + j, arr);
                }
            }
        }
        long a[] = h.get(0);
        return (int) (a[0] % (1000000007));
    }
}
