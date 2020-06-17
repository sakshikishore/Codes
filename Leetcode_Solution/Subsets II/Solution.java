class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> list=new ArrayList();
        for(int i=0;i<(1<<nums.length);i++)
        {
            ArrayList<Integer> l=new ArrayList<Integer>();
            for(int j=0;j<nums.length;j++)
            {
                if ((i & (1 << j)) > 0) 
                {
                    l.add(nums[j]);
                }
            }
            Collections.sort(l);
            if(!list.contains(l))
            {
            list.add(l);
            }
        }
        
        return list;
    }
}
