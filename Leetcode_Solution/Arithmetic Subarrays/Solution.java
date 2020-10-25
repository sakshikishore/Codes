class Solution {
    public List<Boolean> checkArithmeticSubarrays(int[] nums, int[] l, int[] r) {
         ArrayList<Boolean> output=new ArrayList<Boolean>();
        for(int i=0;i<l.length;i++)
        {
            ArrayList<Integer> list=new ArrayList<Integer>();
            boolean result=true;
            for(int j=l[i];j<=r[i];j++)
            {
                list.add(nums[j]);
            }
            Collections.sort(list);
            int p=list.get(1)-list.get(0);
            for(int j=2;j<list.size();j++)
            {
                if(list.get(j)-list.get(j-1)!=p)
                {
                    result=false;
                    break;
                }
            }
            output.add(result);
        }
        return output;
        
    }
}
