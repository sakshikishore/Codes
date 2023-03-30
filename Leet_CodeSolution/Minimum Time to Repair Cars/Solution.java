class Solution {
    public long repairCars(int[] ranks, int cars) {
        int n=ranks.length-1;
        Arrays.sort(ranks);
        long min=1,max=1;
         max=ranks[0]*(max*cars*cars);
         long result=0;
        while(min<=max)
        {
            long mid=(min+max)/2;
            long total=0;
            for(int j=0;j<=n;j++)
            {
                long r=mid/ranks[j];
                total+=Math.sqrt(r);
            }
            if(total>=cars)
            {
                result=mid;
                max=mid-1;
            }
            else
            {
                min=mid+1;
            }
        }

        return result;
    }
}
