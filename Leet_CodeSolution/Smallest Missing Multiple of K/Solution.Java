class Solution {
    public int missingMultiple(int[] nums, int k) {
        HashSet<Integer> hset=new HashSet<Integer>();
        for(int i=0;i<nums.length;i++)
        {
            hset.add(nums[i]);
        }
        int x=k;
        int i=1;
        while(true)
        {
            System.out.println(x);
            if(!hset.contains(x*i))
            {
                return x*i;
            }
            i++;
        }

    }
}
