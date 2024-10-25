class Solution {
    public int closestMeetingNode(int[] edges, int node1, int node2) { 
        int min=Integer.MAX_VALUE;      
        Queue<Integer> q=new LinkedList<Integer>();
        HashMap<Integer,Integer> map=new HashMap<Integer,Integer>();
        q.add(node1);
        map.put(node1,0);
        int count=0;
        while(q.size()>0)
        {
            int x=q.poll();
            if(edges[x]!=-1 && !map.containsKey(edges[x]))
            {
                count++;
                map.put(edges[x],count);
                q.add(edges[x]);
            }
        }
        HashSet<Integer> hset=new  HashSet<Integer>();
        q=new LinkedList<Integer>();
        q.add(node2);
        hset.add(node2);
        count=-1;
        int ans=-1;
        while(q.size()>0)
        {
            int x=q.poll();
            count++;
            if(map.containsKey(x))
            {
                int dist=Math.max(map.get(x),count);
                if(dist<min)
                {
                    min=dist;
                    ans=x;
                }
                else if(dist==min)
                {
                    ans=Math.min(ans,x);
                }
            }
            if(edges[x]!=-1 &&!hset.contains(edges[x]))
            {
                q.add(edges[x]);
                hset.add(edges[x]);
            }
        }


        return ans;



    }
}
