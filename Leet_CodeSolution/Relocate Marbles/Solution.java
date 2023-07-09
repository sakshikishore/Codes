class Solution {
    public List<Integer> relocateMarbles(int[] nums, int[] moveFrom, int[] moveTo) {
        HashMap<Integer,Integer> h=new HashMap<Integer,Integer>();
        for(int i=0;i<nums.length;i++)
        {
            if(!h.containsKey(nums[i]))
            {
                h.put(nums[i],1);
            }
            else
            {
                h.put(nums[i],h.get(nums[i])+1);
            }
        }
        for(int i=0;i<moveFrom.length;i++)
        {
            if(h.containsKey(moveFrom[i]))
            {
                int val=h.get(moveFrom[i]);
                h.remove(moveFrom[i]);
                if(h.containsKey(moveTo[i]))
                {
                    h.put(moveTo[i],h.get(moveTo[i])+val);
                }
                else
                {
                    h.put(moveTo[i],val);
                }
            }
        }
        ArrayList<Integer> result=new ArrayList<Integer>();
        PriorityQueue<Integer> pq=new PriorityQueue<Integer>();
        for(Map.Entry<Integer,Integer> entry:h.entrySet())
        {
            pq.add(entry.getKey());
        }
        
        while(pq.size()>0)
        {
            result.add(pq.poll());
        }
        
        
        return result;
       
    }
}
