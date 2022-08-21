class Solution {
    public long maximumImportance(int n, int[][] roads) {
        HashMap<Integer,Integer> h=new HashMap<Integer,Integer>();
        for(int i=0;i<roads.length;i++)
        {
            if(!h.containsKey(roads[i][0]))
            {
                h.put(roads[i][0],1);
            }
            else
            {
                h.put(roads[i][0],h.get(roads[i][0])+1);
            }
            if(!h.containsKey(roads[i][1]))
            {
                h.put(roads[i][1],1);
            }
            else
            {
                h.put(roads[i][1],h.get(roads[i][1])+1);
            }
        }
        PriorityQueue<Integer> pq=new PriorityQueue<Integer>(Collections.reverseOrder());
        for(Map.Entry<Integer,Integer> entry:h.entrySet())
        {
            pq.add(entry.getValue());
        }
        long i=n;
        long result=0;
        while(pq.size()>0)
        {
            result+=(pq.poll()*i);
            i--;
        }
        
        return result;
    }
}
