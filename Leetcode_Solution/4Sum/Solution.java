class Solution {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> list=new ArrayList();
        if(nums.length>3)
        {
            Arrays.sort(nums);
            for(int i=0;i<nums.length;i++)
            {
                for(int j=i+1;j<nums.length;j++)
                {
                    for(int k=j+1;k<nums.length;k++)
                    {
                        for(int l=k+1;l<nums.length;l++)
                        {
                            if((nums[i]+nums[j]+nums[k]+nums[l])==target)
                            {
                                    ArrayList<Integer> a=new ArrayList<Integer>();
                                    a.add(nums[i]);
                                    a.add(nums[j]);
                                    a.add(nums[k]);
                                    a.add(nums[l]);
                                
                                if(!list.contains(a))
                                {
                                    list.add(a);
                                }
                            }
                        }
                    }
                }
            }
        }
        return list;
        
    }
}
