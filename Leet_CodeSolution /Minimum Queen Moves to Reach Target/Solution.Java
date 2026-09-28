public class Node {
    int x, y;

    public Node(int i, int j) {
        x = i;
        y = j;
    }
}

class Solution {
    public int minQueenMoves(int[] source, int[] target) {
        int ans = 64;
        int arr[][] = new int[9][9];
        for (int i = 0; i < arr.length; i++) {
            Arrays.fill(arr[i], -1);
        }
        int a[][] = new int[9][9];
        Queue<Node> q = new LinkedList<Node>();
        q.add(new Node(source[0], source[1]));
        a[source[0]][source[1]] = 1;
        arr[source[0]][source[1]] = 0;
        while (q.size() > 0) {
            Node p = q.poll();
            if (p.x == target[0] && p.y == target[1]) {
                ans = Math.min(ans, arr[p.x][p.y]);
            }
            a[p.x][p.y] = 0;
            int i = p.x - 1;
            while (i >= 0) {
                if (arr[i][p.y] == -1 || arr[i][p.y] > arr[p.x][p.y] + 1) {
                    arr[i][p.y] = arr[p.x][p.y] + 1;
                    if (a[i][p.y] == 0) {
                        q.add(new Node(i, p.y));
                        a[i][p.y] = 1;
                    }
                }
                i--;
            }
            i = p.x + 1;
            while (i <= 8) {
                if (arr[i][p.y] == -1 || arr[i][p.y] > arr[p.x][p.y] + 1) {
                    arr[i][p.y] = arr[p.x][p.y] + 1;
                    if (a[i][p.y] == 0) {
                        q.add(new Node(i, p.y));
                        a[i][p.y] = 1;
                    }
                }
                i++;
            }
            int j = p.y - 1;
            while (j > 0) {
                if (arr[p.x][j] == -1 || arr[p.x][j] > arr[p.x][p.y] + 1) {
                    arr[p.x][j] = arr[p.x][p.y] + 1;
                    if (a[p.x][j] == 0) {
                        q.add(new Node(p.x, j));
                        a[p.x][j] = 1;
                    }
                }
                j--;
            }
            j = p.y + 1;
            while (j <= 8) {
                if (arr[p.x][j] == -1 || arr[p.x][j] > arr[p.x][p.y] + 1) {
                    arr[p.x][j] = arr[p.x][p.y] + 1;
                    if (a[p.x][j] == 0) {
                        q.add(new Node(p.x, j));
                        a[p.x][j] = 1;
                    }
                }
                j++;
            }
            i = p.x + 1;
            j = p.y + 1;
            while (i <= 8 && j <= 8) {
                if (arr[i][j] == -1 || arr[i][j] > arr[p.x][p.y] + 1) {
                    arr[i][j] = arr[p.x][p.y] + 1;
                    if (a[i][j] == 0) {
                        q.add(new Node(i, j));
                        a[i][j] = 1;
                    }
                }
                j++;
                i++;
            }
            i = p.x - 1;
            j = p.y - 1;
            while (i > 0 && j > 0) {
                if (arr[i][j] == -1 || arr[i][j] > arr[p.x][p.y] + 1) {
                    arr[i][j] = arr[p.x][p.y] + 1;
                    if (a[i][j] == 0) {
                        q.add(new Node(i, j));
                        a[i][j] = 1;
                    }
                }
                j--;
                i--;
            }
            i = p.x - 1;
            j = p.y + 1;
            while (i > 0 && j <= 8) {
                if (arr[i][j] == -1 || arr[i][j] > arr[p.x][p.y] + 1) {
                    arr[i][j] = arr[p.x][p.y] + 1;
                    if (a[i][j] == 0) {
                        q.add(new Node(i, j));
                        a[i][j] = 1;
                    }
                }
                j++;
                i--;
            }
            i = p.x + 1;
            j = p.y - 1;
            while (i <= 8 && j > 0) {
                if (arr[i][j] == -1 || arr[i][j] > arr[p.x][p.y] + 1) {
                    arr[i][j] = arr[p.x][p.y] + 1;
                    if (a[i][j] == 0) {
                        q.add(new Node(i, j));
                        a[i][j] = 1;
                    }
                }
                j--;
                i++;
            }
        }

        return ans;
    }
}
//Another Solution
class Solution {
    public int minQueenMoves(int[] source, int[] target) {
        if(source[0]==target[0] && source[1]==target[1])
        {
            return 0;
        }
       if(source[0]==target[0] || source[1]==target[1] || Math.abs(source[0]-target[0])==Math.abs(source[1]-target[1])){return 1;} else {return 2;}
    }
}
