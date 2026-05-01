class Node {
    int row, col;

    public Node(int r, int c) {
        row = r;
        col = c;
    }
}

class Node2 {
    int time, color, flag;

    public Node2(int t, int c, int f) {
        time = t;
        color = c;
        flag = f;
    }
}

class Solution {
    public int[][] colorGrid(int n, int m, int[][] sources) {
        Node2 grid[][] = new Node2[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                grid[i][j] = new Node2(0, 0, 0);
            }
        }
        Queue<Node> q = new LinkedList<Node>();
        for (int i = 0; i < sources.length; i++) {
            grid[sources[i][0]][sources[i][1]] = new Node2(0, sources[i][2], 1);
            q.add(new Node(sources[i][0], sources[i][1]));
        }
        while (q.size() > 0) {
            Node temp = q.poll();
            int row = temp.row;
            int col = temp.col;
            grid[row][col].flag = 0;
            if (row - 1 >= 0) {
                if (grid[row - 1][col].color == 0) {
                    if (grid[row - 1][col].flag == 0) {
                        q.add(new Node(row - 1, col));
                    }
                    grid[row - 1][col] = new Node2(grid[row][col].time + 1, grid[row][col].color, 1);
                } else {
                    if (grid[row - 1][col].color < grid[row][col].color
                            && grid[row - 1][col].time == grid[row][col].time + 1) {

                        if (grid[row - 1][col].flag == 0) {
                            q.add(new Node(row - 1, col));
                        }
                        grid[row - 1][col] = new Node2(grid[row][col].time + 1, grid[row][col].color, 1);
                    }
                }
            }
            if (col - 1 >= 0) {
                if (grid[row][col - 1].color == 0) {
                    if (grid[row][col - 1].flag == 0) {
                        q.add(new Node(row, col - 1));
                    }
                    grid[row][col - 1] = new Node2(grid[row][col].time + 1, grid[row][col].color, 1);
                } else {
                    if (grid[row][col - 1].color < grid[row][col].color
                            && grid[row][col - 1].time == grid[row][col].time + 1) {
                        if (grid[row][col - 1].flag == 0) {
                            q.add(new Node(row, col - 1));
                        }
                        grid[row][col - 1] = new Node2(grid[row][col].time + 1, grid[row][col].color, 1);
                    }
                }
            }
            if (row + 1 < n) {
                if (grid[row + 1][col].color == 0) {
                    if (grid[row + 1][col].flag == 0) {
                        q.add(new Node(row + 1, col));
                    }
                    grid[row + 1][col] = new Node2(grid[row][col].time + 1, grid[row][col].color, 1);
                } else {
                    if (grid[row + 1][col].color < grid[row][col].color
                            && grid[row + 1][col].time == grid[row][col].time + 1) {
                        if (grid[row + 1][col].flag == 0) {
                            q.add(new Node(row + 1, col));
                        }
                        grid[row + 1][col] = new Node2(grid[row][col].time + 1, grid[row][col].color, 1);
                    }
                }
            }
            if (col + 1 < m) {
                if (grid[row][col + 1].color == 0) {
                    if (grid[row][col + 1].flag == 0) {
                        q.add(new Node(row, col + 1));
                    }
                    grid[row][col + 1] = new Node2(grid[row][col].time + 1, grid[row][col].color, 1);
                } else {
                    if (grid[row][col + 1].color < grid[row][col].color
                            && grid[row][col + 1].time == grid[row][col].time + 1) {
                        if (grid[row][col + 1].flag == 0) {
                            q.add(new Node(row, col + 1));
                        }
                        grid[row][col + 1] = new Node2(grid[row][col].time + 1, grid[row][col].color, 1);
                    }
                }
            }

        }
        int result[][] = new int[n][m];
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                result[i][j] = grid[i][j].color;
            }
        }

        return result;
    }
}
