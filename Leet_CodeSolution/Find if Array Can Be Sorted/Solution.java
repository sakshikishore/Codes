class Solution {
    public boolean canSortArray(int[] nums) {
        int arr[]=new int[nums.length];
        for(int i=0;i<nums.length;i++)
        {
            arr[i]=nums[i];
        }
        Arrays.sort(arr);
        int i=0;
        while(i<nums.length && arr[i]==nums[i])
        {
            i++;
        }
        if(i==nums.length)
        {
            return true;
        }
        int start=i;
        PriorityQueue<Integer> pq=new PriorityQueue<Integer>();
        pq.add(nums[start]);
        for(int j=i+1;j<nums.length;j++)
        {
           if(Integer.bitCount(nums[j])!=Integer.bitCount(nums[j-1]))
           {
                while(pq.size()>0)
                {
                    int x=pq.poll();
                    if(x!=arr[start])
                    {
                        return false;
                    }
                    start++;
                }
                pq=new PriorityQueue<Integer>();
           }
           else
           {
               pq.add(nums[j]);
           }
        }
        
        return true;
       
        
    }
}
