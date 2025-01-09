class Solution {
    public int minTime(int n, int[][] edges, List<Boolean> hasApple) {
        if(n==1)
        {
            return 0;
        }
        int children[] = new int[n];
        int score[] = new int[n];
        Arrays.fill(score, -1);
        HashMap<Integer, ArrayList<Integer>> h2 = new HashMap<Integer, ArrayList<Integer>>();
        HashMap<Integer, ArrayList<Integer>> h1 = new HashMap<Integer, ArrayList<Integer>>();
        HashMap<Integer, Integer> childParent = new HashMap<Integer, Integer>();
        for (int i = 0; i < edges.length; i++) {
            if (!h2.containsKey(edges[i][0])) {
                ArrayList<Integer> l1 = new ArrayList<Integer>();
                l1.add(edges[i][1]);
                h2.put(edges[i][0], l1);
            } else {
                ArrayList<Integer> l1 = h2.get(edges[i][0]);
                l1.add(edges[i][1]);
                h2.put(edges[i][0], l1);
            }
            if (!h2.containsKey(edges[i][1])) {
                ArrayList<Integer> l1 = new ArrayList<Integer>();
                l1.add(edges[i][0]);
                h2.put(edges[i][1], l1);
            } else {
                ArrayList<Integer> l1 = h2.get(edges[i][1]);
                l1.add(edges[i][0]);
                h2.put(edges[i][1], l1);
            }

        }
        
        Queue<Integer> q = new LinkedList<Integer>();
        HashSet<Integer> hset=new HashSet<Integer>();
        q.add(0);
        hset.add(0);
        while(q.size()>0)
        {
            int x=q.poll();
            ArrayList<Integer> l=h2.get(x);
            ArrayList<Integer> list=new ArrayList<Integer>();
            for(int i=0;i<l.size();i++)
            {
                if(!hset.contains(l.get(i)))
                {
                    childParent.put(l.get(i),x);
                    hset.add(l.get(i));
                    list.add(l.get(i));
                    q.add(l.get(i));
                }
            }
            if(list.size()>0)
            {
            h1.put(x,list);
            }
        }
        
        for (int i = 0; i < n; i++) {
            if (!h1.containsKey(i)) {
                q.add(i);
            }
        }
        while (q.size() > 0) {
            int x = q.poll();
            int sc = 0;
            if (h1.containsKey(x)) {
                ArrayList<Integer> list = h1.get(x);
                for (int i = 0; i < list.size(); i++) {
                    int y = list.get(i);
                    if (score[y] != -1) {
                        sc += 2 + score[y];
                    }
                }

            }
            if (sc == 0) {
                if (hasApple.get(x)) {

                    score[x] = 0;
                }
            } else {
                score[x] = sc;
            }
            if (x == 0) {
                break;
            } else {
                int p = childParent.get(x);
                children[p] += 1;
                if (children[p] == h1.get(p).size()) {
                    q.add(p);
                }
            }
        }

        return score[0] == -1 ? 0 : score[0];
    }
}
