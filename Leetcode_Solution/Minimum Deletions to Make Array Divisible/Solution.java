class Solution {
    public int minOperations(int[] nums, int[] numsDivide) {
        HashMap<Integer,Integer> h=new HashMap<Integer,Integer>();
        TreeSet<Integer> t=new TreeSet<Integer>();
        int result=0;
        for(int i=0;i<nums.length;i++)
        {
            t.add(nums[i]);
            if(!h.containsKey(nums[i]))
            {
                h.put(nums[i],1);
            }
            else
            {
                h.put(nums[i],h.get(nums[i])+1);
            }
        }
       Iterator<Integer> itr=t.iterator();
        while(itr.hasNext())
        {
            int n=itr.next();
            int flag=0;
            for(int j=0;j<numsDivide.length;j++)
            {
                if(numsDivide[j]%n!=0)
                {
                    flag=1;
                    break;
                }
            }
            if(flag==0)
            {
                break;
            }
            else
            {
                result+=h.get(n);
            }
        }
        if(result==nums.length)
        {
            result=-1;
        }
        
        return result;
    }
}
