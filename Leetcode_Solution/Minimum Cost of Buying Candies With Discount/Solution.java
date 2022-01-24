class Solution {
    public int minimumCost(int[] cost) {
        int result=0;
        if(cost.length<3)
        {
            for(int i=0;i<cost.length;i++)
            {
                result+=cost[i];
            }
        }
        else
        {
          Arrays.sort(cost);
            int l=1;
            for(int i=cost.length-1;i>=0;i--)
            {
               if(l%3!=0)
               {
                    result+=cost[i];
                }
                l++;
            }
        }
        
        return result;
    }
}
