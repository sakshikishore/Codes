public class Node {
    int r, c, h;

    public Node(int i, int j, int health) {
        r = i;
        c = j;
        h = health;
    }

}

class Solution {
    public boolean findSafeWalk(List<List<Integer>> grid, int health) {
        Queue<Node> q = new LinkedList<Node>();
        int visited[][] = new int[grid.size()][grid.get(0).size()];
        if (grid.get(0).get(0) == 0) {
            q.add(new Node(0, 0, health));
            visited[0][0] = health;
        } else {
            q.add(new Node(0, 0, health - 1));
            visited[0][0] = health - 1;
        }

        while (q.size() > 0) {
            Node node = q.poll();
            int i = node.r;
            int j = node.c;
            if (i == visited.length - 1 && j == visited[0].length - 1) {
                return true;
            }
            if (i - 1 >= 0) {
                if (grid.get(i - 1).get(j) == 0) {
                    if (visited[i - 1][j] < node.h) {
                        visited[i - 1][j] = node.h;
                        q.add(new Node(i - 1, j, node.h));
                    }
                } else if (visited[i - 1][j] < node.h - 1) {
                    visited[i - 1][j] = node.h - 1;
                    q.add(new Node(i - 1, j, node.h - 1));
                }

            }
            if (j - 1 >= 0) {
                if (grid.get(i).get(j - 1) == 0) {
                    if (visited[i][j - 1] < node.h) {
                        visited[i][j - 1] = node.h;
                        q.add(new Node(i, j - 1, node.h));
                    }
                } else if (visited[i][j - 1] < node.h - 1) {
                    visited[i][j - 1] = node.h - 1;
                    q.add(new Node(i, j - 1, node.h - 1));
                }

            }
            if (i + 1 < visited.length) {
                if (grid.get(i + 1).get(j) == 0) {
                    if (visited[i + 1][j] < node.h) {
                        visited[i + 1][j] = node.h;
                        q.add(new Node(i + 1, j, node.h));
                    }
                } else if (visited[i + 1][j] < node.h - 1) {
                    visited[i + 1][j] = node.h - 1;
                    q.add(new Node(i + 1, j, node.h - 1));
                }

            }
            if (j + 1 < visited[0].length) {
                if (grid.get(i).get(j + 1) == 0) {
                    if (visited[i][j + 1] < node.h) {
                        visited[i][j + 1] = node.h;
                        q.add(new Node(i, j + 1, node.h));
                    }
                } else if (visited[i][j + 1] < node.h - 1) {
                    visited[i][j + 1] = node.h - 1;
                    q.add(new Node(i, j + 1, node.h - 1));
                }

            }

        }

        return false;
    }
}
