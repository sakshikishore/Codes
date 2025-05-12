import java.math.BigInteger;
class Solution {
    public int countWays(int[][] ranges) {
        PriorityQueue<Integer> pq =new PriorityQueue<Integer>();
        HashMap<Integer,Integer> h=new HashMap<Integer,Integer>();
        for(int i=0;i<ranges.length;i++)
        {
            if(!h.containsKey(ranges[i][0]))
            {
                pq.add(ranges[i][0]);
                h.put(ranges[i][0],ranges[i][1]);
            }
            else
            {
                if(h.get(ranges[i][0])<ranges[i][1])
                {
                    h.put(ranges[i][0],ranges[i][1]);
                }
            }
        }
        int end=-1;
        int count=0;
        while(pq.size()>0)
        {
            int x=pq.poll();
            if(count==0)
            {
                end=h.get(x);
                count=1;
            }
            else
            {
                if(x<=end)
                {
                    end=Math.max(end,h.get(x));
                }
                else
                {
                    count++;
                    end=h.get(x);
                }
            }
        }
        BigInteger ans=BigInteger.valueOf(2).modPow(BigInteger.valueOf(count),BigInteger.valueOf(1000000007));
        return ans.intValue();
    }
}
