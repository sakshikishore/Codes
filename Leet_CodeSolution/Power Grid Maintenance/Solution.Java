class Solution {
    public int[] processQueries(int c, int[][] connections, int[][] queries) {
        ArrayList<Integer> res = new ArrayList<Integer>();
        HashSet<Integer> offline = new HashSet<Integer>();
        HashSet<Integer> hset = new HashSet<Integer>();
        HashMap<Integer, ArrayList<Integer>> h = new HashMap<Integer, ArrayList<Integer>>();
        HashMap<Integer, ArrayList<Integer>> map = new HashMap<Integer, ArrayList<Integer>>();
        for (int i = 0; i < connections.length; i++) {
            if (!h.containsKey(connections[i][0])) {
                ArrayList<Integer> l = new ArrayList<Integer>();
                l.add(connections[i][1]);
                h.put(connections[i][0], l);
            } else {
                ArrayList<Integer> l = h.get(connections[i][0]);
                l.add(connections[i][1]);
                h.put(connections[i][0], l);
            }
            if (!h.containsKey(connections[i][1])) {
                ArrayList<Integer> l = new ArrayList<Integer>();
                l.add(connections[i][0]);
                h.put(connections[i][1], l);
            } else {
                ArrayList<Integer> l = h.get(connections[i][1]);
                l.add(connections[i][0]);
                h.put(connections[i][1], l);
            }
        }
        HashMap<Integer, Integer> hMap = new HashMap<Integer, Integer>();
        for (int i = 1; i <= c; i++) {
            if (!hset.contains(i)) {
                hset.add(i);
                hMap.put(i, i);
                Queue<Integer> q = new LinkedList<Integer>();
                q.add(i);
                while (q.size() > 0) {
                    int x = q.poll();
                    if (!map.containsKey(i)) {
                        ArrayList<Integer> l = new ArrayList<Integer>();
                        l.add(x);
                        map.put(i, l);
                    } else {
                        ArrayList<Integer> l = map.get(i);
                        int low = 0, high = l.size() - 1;
                        while (low <= high) {
                            int mid = (low + high) / 2;
                            if (l.get(mid) >= x) {
                                high = mid - 1;
                            } else {
                                low = mid + 1;
                            }
                        }
                        l.add(low, x);
                        map.put(i, l);
                    }
                    if (h.containsKey(x)) {
                        ArrayList<Integer> al = h.get(x);
                        for (int j = 0; j < al.size(); j++) {
                            if (!hset.contains(al.get(j))) {
                                hset.add(al.get(j));
                                hMap.put(al.get(j), i);
                                q.add(al.get(j));
                            }
                        }
                    }
                }
            }
        }

        for (int i = 0; i < queries.length; i++) {
            if (queries[i][0] == 1) {
                if (!offline.contains(queries[i][1])) {
                    res.add(queries[i][1]);
                } else {
                    int x = hMap.get(queries[i][1]);
                    if (map.containsKey(x)) {
                        res.add(map.get(x).get(0));
                    } else {
                        res.add(-1);
                    }
                }
            } else {
                if (!offline.contains(queries[i][1])) {
                    int x = hMap.get(queries[i][1]);
                    offline.add(queries[i][1]);
                    ArrayList<Integer> al = map.get(x);
                    int low = 0, high = al.size() - 1;
                    while (low <= high) {
                        int mid = (low + high) / 2;
                        if (al.get(mid) == queries[i][1]) {
                            al.remove(mid);
                            break;
                        } else if (al.get(mid) > queries[i][1]) {
                            high = mid - 1;
                        } else {
                            low = mid + 1;
                        }
                    }
                    if (al.size() == 0) {
                        map.remove(x);
                    } else {
                        map.put(x, al);
                    }
                }

            }
        }

        int result[] = new int[res.size()];
        for (int i = 0; i < res.size(); i++) {
            result[i] = res.get(i);
        }

        return result;
    }
}
