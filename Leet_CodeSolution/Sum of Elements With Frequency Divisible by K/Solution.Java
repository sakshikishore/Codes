class Solution {
    public int sumDivisibleByK(int[] nums, int k) {
        HashMap<Integer,Integer> h=new HashMap<Integer,Integer>();
        int sum=0;
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
        for(Map.Entry<Integer,Integer> entry:h.entrySet())
        {
            int freq=entry.getValue();
            if(freq%k==0)
            {
                sum+=(entry.getKey()*freq);
            }
        }

        return sum;
    }
}
