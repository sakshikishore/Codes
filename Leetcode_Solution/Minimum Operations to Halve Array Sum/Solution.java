class Solution {
    public int halveArray(int[] nums) {
       PriorityQueue<Double> queue = new PriorityQueue<>(nums.length, Collections.reverseOrder());
        double sum=0.0;
        int count=0;
        for(int i=0;i<nums.length;i++)
        {
            double num=nums[i];
            queue.add(num);
            sum+=num;
        }
        double hsum=sum;
        while(hsum>sum/2)
        {
            double maxElement=queue.poll();
            maxElement=maxElement/2;
            count++;
            hsum-=maxElement;
            queue.add(maxElement);
        }
        
        
        
        return count;
        
    }
}
