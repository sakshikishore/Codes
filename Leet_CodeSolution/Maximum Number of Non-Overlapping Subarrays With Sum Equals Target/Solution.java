class Solution {
    public int maxNonOverlapping(int[] nums, int target) {
        int sum=0,count=0;
        HashSet<Integer> hset=new HashSet<Integer>();
        for(int i=0;i<nums.length;i++)
        {
             sum=sum+nums[i];
             if(sum==target)
             {
                sum=0;
                count++;
                hset=new HashSet<Integer>();
             }
             else
             {
                int x=sum-target;
                if(hset.contains(x))
                {
                    sum=0;
                    count++;
                    hset=new HashSet<Integer>();
                }
                else
                {
                    hset.add(sum);
                }
             }
        }
        return count;
    }
}
