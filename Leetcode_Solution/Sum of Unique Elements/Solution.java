class Solution {
    public int sumOfUnique(int[] nums) {
        int sum=0;
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
        for(int i=0;i<nums.length;i++)
        {
            if(h.get(nums[i])==1)
            {
                sum=sum+nums[i];
            }
        }
        
        return sum;
    }
}
