class Solution {
    public int[] findErrorNums(int[] nums) {
        int result[]=new int[2];
        TreeSet<Integer> t=new TreeSet<Integer>();
        for(int i=0;i<nums.length;i++)
        {
            if(t.contains(nums[i]))
            {
                result[0]=nums[i];
            }
            else
            {
                t.add(nums[i]);
            }
        }
        
        Iterator<Integer> itr=t.iterator();
        int i=1;
        while(itr.hasNext())
        {
            int x=itr.next();
            if(x!=i)
            {
                result[1]=i;
                break;
            }
            i++;
        }
        if(result[1]==0)
        {
            result[1]=nums.length;
        }
        return result;
    }
}
