class Solution {
    public long maxKelements(int[] nums, int k) {
        long result=0;
        PriorityQueue<Integer> pq=new PriorityQueue<Integer>(Collections.reverseOrder());
        for(int i=0;i<nums.length;i++)
        {
            pq.add(nums[i]);
        }
        int count=0;
        while(pq.size()>0 && count<k)
        {
            count++;
            int x=pq.poll();
            result+=x;
            int r=(int)Math.ceil(x/3.0);
            pq.add(r);
            
        }
        
        return result;
    }
}
