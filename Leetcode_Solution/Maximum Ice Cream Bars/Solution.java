class Solution {
    public int maxIceCream(int[] costs, int coins) {
        Arrays.sort(costs);
        int total=0;
        for(int i=0;i<costs.length;i++)
        {
            if(coins>=costs[i])
            {
                total++;
                coins=coins-costs[i];
            }
            else
            {
                break;
            }
        }
        
        return total;
        
    }
}
