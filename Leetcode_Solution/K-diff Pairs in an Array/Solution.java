class Solution {
    public int findPairs(int[] nums, int k) {
        Arrays.sort(nums);
        HashSet<String> h=new HashSet<String>();
        for(int i=0;i<nums.length;i++)
        {
            for(int j=i+1;j<nums.length;j++)
            {
                if(Math.abs(nums[i]-nums[j])==k)
                {
                    String str=Integer.toString(nums[i])+" "+Integer.toString(nums[j]);
                    
                     h.add(str);           
                }     
            }
        }
        
        return h.size();
    }
}
