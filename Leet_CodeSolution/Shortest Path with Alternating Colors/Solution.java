class Node {
    int node, color, edgeCount;

    Node(int node, int color, int totalEdge) {
        this.node = node;
        this.color = color;
        this.edgeCount = totalEdge;
    }
}

class Solution {
    public int[] shortestAlternatingPaths(int n, int[][] redEdges, int[][] blueEdges) {
        int arr[][] = new int[n][2];
        arr[0][0] = 1;
        arr[0][1] = 1;
        HashMap<Integer, ArrayList<Integer>> h1 = new HashMap<Integer, ArrayList<Integer>>();
        HashMap<Integer, ArrayList<Integer>> h2 = new HashMap<Integer, ArrayList<Integer>>();
        for (int i = 0; i < redEdges.length; i++) {
            if (!h1.containsKey(redEdges[i][0])) {
                ArrayList<Integer> list = new ArrayList<Integer>();
                list.add(redEdges[i][1]);
                h1.put(redEdges[i][0], list);
            } else {
                ArrayList<Integer> list = h1.get(redEdges[i][0]);
                list.add(redEdges[i][1]);
                h1.put(redEdges[i][0], list);
            }
        }
        for (int i = 0; i < blueEdges.length; i++) {
            if (!h2.containsKey(blueEdges[i][0])) {
                ArrayList<Integer> list = new ArrayList<Integer>();
                list.add(blueEdges[i][1]);
                h2.put(blueEdges[i][0], list);
            } else {
                ArrayList<Integer> list = h2.get(blueEdges[i][0]);
                list.add(blueEdges[i][1]);
                h2.put(blueEdges[i][0], list);
            }
        }

        int result[] = new int[n];
        Arrays.fill(result, -1);
        result[0] = 0;
        Queue<Node> q = new LinkedList<Node>();
        q.add(new Node(0, -1, 0));
        while (q.size() > 0) {
            Node val = q.poll();
            if (val.color == -1) {
                if (h1.containsKey(val.node)) {
                    ArrayList<Integer> list = h1.get(val.node);
                    for (int i = 0; i < list.size(); i++) {
                        if (list.get(i) != 0) {
                            q.add(new Node(list.get(i), 1, 1));
                            result[list.get(i)] = 1;
                            arr[list.get(i)][0] = 1;
                        }
                    }
                }
                if (h2.containsKey(val.node)) {
                    ArrayList<Integer> list = h2.get(val.node);
                    for (int i = 0; i < list.size(); i++) {
                        if (list.get(i) != 0) {
                            q.add(new Node(list.get(i), 2, 1));
                            result[list.get(i)] = 1;
                            arr[list.get(i)][1] = 1;
                        }
                    }
                }
            } else {
                if (val.color == 1) {
                    if (h2.containsKey(val.node)) {
                        ArrayList<Integer> list = h2.get(val.node);
                        for (int i = 0; i < list.size(); i++) {
                            if (arr[list.get(i)][0] == 0 && arr[list.get(i)][1] == 0) {
                                result[list.get(i)] = val.edgeCount + 1;
                            }
                            if (arr[list.get(i)][1] == 0) {
                                q.add(new Node(list.get(i), 2, val.edgeCount + 1));
                                arr[list.get(i)][1] = 1;
                            }
                        }
                    }
                } else {
                    if (h1.containsKey(val.node)) {
                        ArrayList<Integer> list = h1.get(val.node);
                        for (int i = 0; i < list.size(); i++) {
                            if (arr[list.get(i)][0] == 0 && arr[list.get(i)][1] == 0) {
                                result[list.get(i)] = val.edgeCount + 1;
                            }
                            if (arr[list.get(i)][0] == 0) {
                                q.add(new Node(list.get(i), 1, val.edgeCount + 1));
                                arr[list.get(i)][0] = 1;
                            }
                        }
                    }
                }
            }
        }

        return result;
    }
}
