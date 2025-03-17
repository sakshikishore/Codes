public class Node {
    int x, y;

    public Node(int i, int j) {
        x = i;
        y = j;
    }
}

class Solution {
    public int minimumObstacles(int[][] grid) {
        int result=Integer.MAX_VALUE;
        int visited[][] = new int[grid.length][grid[0].length];
        int arr[][] = new int[grid.length][grid[0].length];
        Queue<Node> q = new LinkedList<Node>();
        q.add(new Node(0, 0));
        arr[0][0] = 1;
        visited[0][0]=1;
        while (q.size() > 0) {
            Node node = q.poll();
            int i = node.x;
            int j = node.y;
            arr[i][j] = 0;
            if(i==grid.length-1 && j==grid[0].length-1)
            {
                result=Math.min(visited[i][j],result);
                continue;
            }
            if (i - 1 >= 0) {
                if (grid[i - 1][j] == 1) {
                    if (visited[i - 1][j] == 0) {
                        visited[i - 1][j] = visited[i][j] + 1;
                        if (arr[i - 1][j] == 0) {
                            q.add(new Node(i - 1, j));
                            arr[i - 1][j] = 1;
                        }
                    } else if (visited[i - 1][j] > visited[i][j] + 1) {
                        visited[i - 1][j] = visited[i][j] + 1;
                        if (arr[i - 1][j] == 0) {
                            q.add(new Node(i - 1, j));
                            arr[i - 1][j] = 1;
                        }
                    }

                } else {
                    if (visited[i - 1][j] == 0) {
                         visited[i-1][j]=visited[i][j];
                        if (arr[i - 1][j] == 0) {
                            q.add(new Node(i - 1, j));
                            arr[i - 1][j] = 1;
                        }
                    } else if (visited[i - 1][j] > visited[i][j]) {
                        visited[i - 1][j] = visited[i][j];
                        if (arr[i - 1][j] == 0) {
                            q.add(new Node(i - 1, j));
                            arr[i - 1][j] = 1;
                        }
                    }
                }
            }
             if (i + 1 <grid.length) {
                if (grid[i+1][j] == 1) {
                    if (visited[i+1][j] == 0) {
                        visited[i+1][j] = visited[i][j] + 1;
                        if (arr[i+1][j] == 0) {
                            q.add(new Node(i+1, j));
                            arr[i+1][j] = 1;
                        }
                    } else if (visited[i+1][j] > visited[i][j] + 1) {
                        visited[i+1][j] = visited[i][j] + 1;
                        if (arr[i+1][j] == 0) {
                            q.add(new Node(i+1, j));
                            arr[i+1][j] = 1;
                        }
                    }

                } else {
                    if (visited[i+1][j] == 0) {
                        visited[i+1][j]=visited[i][j];
                        if (arr[i+1][j] == 0) {
                            q.add(new Node(i+1, j));
                            arr[i+1][j] = 1;
                        }
                    } else if (visited[i+1][j] > visited[i][j]) {
                        visited[i+1][j] = visited[i][j];
                        if (arr[i+1][j] == 0) {
                            q.add(new Node(i+1, j));
                            arr[i+1][j] = 1;
                        }
                    }
                }
            }
             if (j - 1 >= 0) {
                if (grid[i][j-1] == 1) {
                    if (visited[i][j-1] == 0) {
                        visited[i][j-1] = visited[i][j] + 1;
                        if (arr[i][j-1] == 0) {
                            q.add(new Node(i, j-1));
                            arr[i][j-1] = 1;
                        }
                    } else if (visited[i][j-1] > visited[i][j] + 1) {
                        visited[i][j-1] = visited[i][j] + 1;
                        if (arr[i][j-1] == 0) {
                            q.add(new Node(i, j-1));
                            arr[i][j-1] = 1;
                        }
                    }

                } else {
                    if (visited[i][j-1] == 0) {
                        visited[i][j-1]=visited[i][j];
                        if (arr[i][j-1] == 0) {
                            q.add(new Node(i, j-1));
                            arr[i][j-1] = 1;
                        }
                    } else if (visited[i][j-1] > visited[i][j]) {
                        visited[i][j-1] = visited[i][j];
                        if (arr[i][j-1] == 0) {
                            q.add(new Node(i, j-1));
                            arr[i][j-1] = 1;
                        }
                    }
                }
            }
             if (j+1 <grid[0].length) {
                if (grid[i][j+1] == 1) {
                    if (visited[i][j+1] == 0) {
                        visited[i][j+1] = visited[i][j] + 1;
                        if (arr[i][j+1] == 0) {
                            q.add(new Node(i, j+1));
                            arr[i][j+1] = 1;
                        }
                    } else if (visited[i][j+1] > visited[i][j] + 1) {
                        visited[i][j+1] = visited[i][j] + 1;
                        if (arr[i][j+1] == 0) {
                            q.add(new Node(i, j+1));
                            arr[i][j+1] = 1;
                        }
                    }

                } else {
                    if (visited[i][j+1] == 0) {
                        visited[i][j+1]=visited[i][j];
                        if (arr[i][j+1] == 0) {
                            q.add(new Node(i, j+1));
                            arr[i][j+1] = 1;
                        }
                    } else if (visited[i][j+1] > visited[i][j]) {
                        visited[i][j+1] = visited[i][j];
                        if (arr[i][j+1] == 0) {
                            q.add(new Node(i, j+1));
                            arr[i][j+1] = 1;
                        }
                    }
                }
            }
        }

        return result-1;
    }
}
