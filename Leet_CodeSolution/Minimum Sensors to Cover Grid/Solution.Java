class Solution {
    public int minSensors(int n, int m, int k) {
        int i = k, j = k;
        int count = 0;
        if (i >= n) {
            if (j >= m) {
                return 1;
            } else {
                while (j < m) {
                    count++;
                    j = j + k;
                    if (j < m && j + 1 + k < m) {
                        j = j + 1 + k;
                    } else if (j < m - 1) {
                        count++;
                        j = m;
                    }
                }
            }
        }
        if(j>=m)
        {
            while (i < n) {
            count++;
                 i = i + k;
            if (i < n && i + k + 1 < n) {
                i = i + 1 + k;
            } else if (i < n - 1) {
                i = n - 1;
            } else {
                break;
            }
            }

            return count;
        }
        while (i < n) {
            while (j < m) {
                count++;
                j = j + k;
                if (j < m && j + 1 + k < m) {
                    j = j + 1 + k;
                } else if (j < m - 1) {
                    count++;
                    j = m;
                } else {
                    break;
                }
            }
            j = k;
            i = i + k;
            if (i < n && i + k + 1 < n) {
                i = i + 1 + k;
            } else if (i < n - 1) {
                i = n - 1;
            } else {
                break;
            }
        }
        if (count == 0) {
            return 1;
        }
        return count;
    }
}
