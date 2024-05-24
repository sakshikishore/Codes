class Solution {
    public long numberOfWeeks(int[] milestones) {
        Arrays.sort(milestones);
        long sum=0;
        for(int i=0;i<milestones.length;i++)
        {
            sum+=milestones[i];
        }
        if(milestones[milestones.length-1]*2<=sum)
        {
            return sum;
        }

        return (sum-milestones[milestones.length-1])*2+1;
    }
}
