class Solution {
    public long maximumHappinessSum(int[] happiness, int k) {
        long sum=0;
        Arrays.sort(happiness);
        int count=0;
        for(int i=happiness.length-1;i>=0;i--)
        {
            sum+=happiness[i]-count>=0?happiness[i]-count:0;
            count++;
            if(count==k)
            {
                break;
            }
        }
        
        return sum;
    }
}
