class Solution {
    public int minLengthAfterRemovals(List<Integer> nums) {
        HashMap<Integer,Integer> h=new HashMap<Integer,Integer>();
        for(int i=0;i<nums.size();i++)
        {
            if(!h.containsKey(nums.get(i)))
            {
                h.put(nums.get(i),1);
            }
            else
            {
                h.put(nums.get(i),h.get(nums.get(i))+1);
            }
        }
        PriorityQueue<Integer> pq=new PriorityQueue<Integer>(Collections.reverseOrder());
        for(Map.Entry<Integer,Integer> entry:h.entrySet())
        {
            pq.add(entry.getValue());
        }
        while(pq.size()>1)
        {
            int x=pq.poll();
            int y=pq.poll();
            x--;
            y--;
            if(x!=0)
            {
                pq.add(x);
            }
            if(y!=0)
            {
                pq.add(y);
            }
            
        }
        
        if(pq.size()==0)
        {
            return 0;
        }
        
        return pq.peek();
        
    }
}
