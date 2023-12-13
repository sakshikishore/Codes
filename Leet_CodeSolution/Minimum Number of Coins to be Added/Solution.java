class Solution {
    public int minimumAddedCoins(int[] coins, int target) {
        Arrays.sort(coins);
        int i=0,count=0;
        int totalSum=0;
        int val=1;
        while(i<coins.length)
        {
            if(coins[i]>val)
            {
                totalSum+=val;
                count++;
                val=totalSum+1;
            }
            else
            {
                totalSum+=coins[i];
                val=totalSum+1;
                i++;
            }
            if(totalSum>target)
            {
                break;
            }
        }
        while(totalSum<target)
        {
               totalSum+=val;
                count++;
                val=totalSum+1;
        }

      return count;
        
    }
}
