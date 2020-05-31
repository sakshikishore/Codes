class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> l=new ArrayList<List<Integer>>();
        for(int i=0;i<(1<<nums.length);i++)
        {
            ArrayList<Integer> p=new ArrayList<Integer>();
            for(int j=0;j<nums.length;j++)
            {
                if((i & (1<<j))>0)
                {
                    p.add(nums[j]);
                }
            }
            l.add(p);
        }
        return l;
    }
}
