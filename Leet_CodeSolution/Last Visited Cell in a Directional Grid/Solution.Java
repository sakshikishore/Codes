class Solution {
    public int[] lastVisitedCell(char[][] grid) {
        int r = 0, c = 0;
        int result[] = new int[2];
        while (true) {
            char ch = grid[r][c];
            grid[r][c] = '0';
            if (ch == 'U') {
                if (r - 1 < 0 || grid[r - 1][c] == '0') {
                    result[0] = r;
                    result[1] = c;
                    return result;
                } else {
                    r = r - 1;
                }
            } else if (ch == 'D') {
                if (r + 1 == grid.length || grid[r + 1][c] == '0') {
                    result[0] = r;
                    result[1] = c;
                    return result;
                } else {
                    r = r + 1;
                }
            } else if (ch == 'L') {
                if (c - 1 < 0 || grid[r][c - 1] == '0') {
                    result[0] = r;
                    result[1] = c;
                    return result;
                } else {
                    c = c - 1;
                }
            } else if (c + 1 == grid[0].length || grid[r][c + 1] == '0') {
                result[0] = r;
                result[1] = c;
                return result;
            } else {
                c = c + 1;
            }
        }

    }
}
