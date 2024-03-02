class Solution {
    public int minOperations(int[] nums, int k) {
        PriorityQueue<Long> pq=new PriorityQueue<Long>();
        for(int i=0;i<nums.length;i++)
        {
            pq.add(nums[i]*1L);
        }
        int count=0;
        while(pq.peek()<k)
        {
            long a=pq.poll();
            long b=pq.poll();
            long min=Math.min(a,b);
            long max=Math.max(a,b);
            pq.add(min*2+max);
            count++;
        }
        
        return count;
    }
}
