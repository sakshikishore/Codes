class Solution {
    public int[] minDifference(int[] nums, int[][] queries) {
        int c[][] = new int[nums.length][101];
        for (int i = 0; i < nums.length; i++) {
            if (i == 0) {
                c[i][nums[i]] = 1;
            } else {
                c[i][nums[i]] = 1;
                for (int j = 1; j <= 100; j++) {
                    c[i][j] += c[i - 1][j];
                }
            }
        }
        int result[] = new int[queries.length];
        for (int i = 0; i < queries.length; i++) {
            result[i] = -1;
            if (queries[i][0] == 0) {
                int prevIndex = -1;
                for (int j = 1; j <= 100; j++) {
                    if (c[queries[i][1]][j] != 0) {
                        if (prevIndex == -1) {
                            prevIndex = j;
                        } else {
                            if (result[i] == -1) {
                                result[i] = j - prevIndex;
                                prevIndex = j;
                            } else {
                                result[i] = Math.min(result[i], j - prevIndex);
                                prevIndex = j;
                            }

                        }
                    }
                }
            } else {
                int p[] = new int[101];
                int prevIndex = -1;
                for (int j = 1; j <= 100; j++) {
                    p[j] = c[queries[i][1]][j] - c[queries[i][0] - 1][j];
                    if (p[j] != 0) {
                        if (prevIndex == -1) {
                            prevIndex = j;
                        } else {
                            if (result[i] == -1) {
                                result[i] = j - prevIndex;
                                prevIndex = j;
                            } else {
                                result[i] = Math.min(result[i], j - prevIndex);
                                prevIndex = j;
                            }

                        }
                    }
                }

            }
        }

        return result;
    }
}
