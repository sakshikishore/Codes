class Solution {
    public int smallestAbsent(int[] nums) {
        double sum=0;
        Arrays.sort(nums);
        HashSet<Integer> hset=new HashSet<Integer>();
        if(nums[nums.length-1]<1)
        {
            return 1;
        }
        for(int i=0;i<nums.length;i++)
        {
            hset.add(nums[i]);
            sum+=nums[i];
        }
        double avg=sum/nums.length;
        if(avg<1)
        {
            avg=0;
        }
        int a=(int)(avg);
        for(int i=a+1;i<=101;i++)
        {
            if(!hset.contains(i))
            {
                return i;
            }
        }


        return -1;
    }
}
