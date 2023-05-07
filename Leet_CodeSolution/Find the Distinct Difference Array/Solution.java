class Solution {
    public int[] distinctDifferenceArray(int[] nums) {
        int prefix[]=new int[nums.length];
        HashSet<Integer> h1=new HashSet<Integer>();
        HashSet<Integer> h2=new HashSet<Integer>();
        for(int i=0;i<nums.length;i++)
        {
            h1.add(nums[i]);
            prefix[i]=h1.size();
        }
         int suffix[]=new int[nums.length];
        for(int i=nums.length-1;i>=0;i--)
        {
            h2.add(nums[i]);
            suffix[i]=h2.size();
        }
        int result[]=new int[nums.length];
        for(int i=0;i<result.length-1;i++)
        {
            result[i]=prefix[i]-suffix[i+1];
        }
        result[result.length-1]=prefix[prefix.length-1];
        return result;
    }
}
