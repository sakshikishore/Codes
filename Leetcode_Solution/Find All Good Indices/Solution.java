class Solution {
    public List<Integer> goodIndices(int[] nums, int k) {
        ArrayList<Integer> result=new ArrayList<Integer>();
        int left[]=new int[nums.length];
        left[0]=1;
        for(int i=1;i<nums.length;i++)
        {
            left[i]=1;
            if(nums[i]<=nums[i-1])
            {
                left[i]=left[i-1]+1;
            }
        }
        int right[]=new int[nums.length];
        right[nums.length-1]=1;
        for(int i=nums.length-2;i>=0;i--)
        {
            right[i]=1;
            if(nums[i]<=nums[i+1])
            {
                right[i]=right[i+1]+1;
            }
        }
        for(int i=1;i<nums.length-1;i++)
        {
            if(left[i-1]>=k && right[i+1]>=k)
            {
                result.add(i);
            }
        }
        
        return result;
    }
}
