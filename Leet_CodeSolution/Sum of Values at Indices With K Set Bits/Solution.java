class Solution {
    public int sumIndicesWithKSetBits(List<Integer> nums, int k) {
        int sum=0;
        for(int i=0;i<nums.size();i++)
        {
            int bit=Integer.bitCount(i);
            if(bit==k)
            {
                sum+=nums.get(i);
            }
        }
        
        return sum;
    }
}
