class Solution {
    public List<Integer> largestDivisibleSubset(int[] nums) {
        int max_size=1;
        int index=0;
        Arrays.sort(nums);
        List<ArrayList<Integer>> list=new ArrayList();
        ArrayList<Integer> l=new ArrayList<Integer>();
        l.add(nums[0]);
        list.add(l);
        for(int i=1;i<nums.length;i++)
        {
            int max=0;
            ArrayList<Integer> al=new ArrayList<Integer>();
            for(int j=i-1;j>=0;j--)
            {
                if(nums[i]%nums[j]==0)
                {
                    if(list.get(j).size()+1>max)
                    {
                        al=new ArrayList<Integer>();
                        max=list.get(j).size()+1;
                        ArrayList<Integer> p=list.get(j);
                        for(int k=0;k<p.size();k++)
                        {
                            al.add(p.get(k));
                        }
                        al.add(nums[i]);
                        
                    }
                }
            }
            if(al.size()==0)
            {
                al.add(nums[i]);
            }

            if(al.size()>max_size)
            {
                max_size=al.size();
                index=i;
            }
            list.add(al);
        }
        return list.get(index);
    }
}
