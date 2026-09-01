public class Node {
    int x, y, t;

    public Node(int r, int c, int time) {
        x = r;
        y = c;
        t = time;
    }
}

class Solution {
    public int minBishopMoves(int[] source, int[] target) {
        Queue<Node> que = new LinkedList<Node>();
        int arr[][] = new int[9][9];
        for (int i = 0; i < 9; i++) {
            Arrays.fill(arr[i], -1);
        }
        arr[source[0]][source[1]] = 0;
        que.add(new Node(source[0], source[1], 0));
        while (que.size() > 0) {
            int len = que.size();
            for (int i = 0; i < len; i++) {
                Node node = que.poll();
                if (node.x == target[0] && node.y == target[1]) {
                    return node.t;
                }
                int p = node.x, q = node.y;
                while (p - 1 >= 1 && q - 1 >= 1) {
                    if (arr[p - 1][q - 1] == -1 || arr[p - 1][q - 1] > node.t + 1) {
                        arr[p - 1][q - 1] = node.t + 1;
                        que.add(new Node(p - 1, q - 1, node.t + 1));
                    }
                    p--;
                    q--;
                }
                p = node.x;
                q = node.y;
                while (p - 1 >= 1 && q + 1 < 9) {
                    if (arr[p - 1][q + 1] == -1 || arr[p - 1][q + 1] > node.t + 1) {
                        arr[p - 1][q + 1] = node.t + 1;
                        que.add(new Node(p - 1, q + 1, node.t + 1));
                    }
                    p--;
                    q++;
                }
                p = node.x;
                q = node.y;
                while (p + 1 < 9 && q + 1 < 9) {
                    if (arr[p + 1][q + 1] == -1 || arr[p + 1][q + 1] > node.t + 1) {
                        arr[p + 1][q + 1] = node.t + 1;
                        que.add(new Node(p + 1, q + 1, node.t + 1));
                    }
                    p++;
                    q++;
                }

                p = node.x;
                q = node.y;
                while (p + 1 < 9 && q - 1 >= 1) {
                    if (arr[p + 1][q - 1] == -1 || arr[p + 1][q - 1] > node.t + 1) {
                        arr[p + 1][q - 1] = node.t + 1;
                        que.add(new Node(p + 1, q - 1, node.t + 1));
                    }
                    p++;
                    q--;
                }

            }
        }

        return -1;
    }
}
