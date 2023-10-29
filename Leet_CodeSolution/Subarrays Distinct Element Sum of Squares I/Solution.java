class Solution {
    public int sumCounts(List<Integer> nums) {
        int sum=0;
        for(int i=0;i<nums.size();i++)
        {
            HashSet<Integer> hset=new HashSet<Integer>();
            for(int j=i;j<nums.size();j++)
            {
                hset.add(nums.get(j));
                sum+=hset.size()*hset.size();
            }
        }
        
        return sum;
    }
}
