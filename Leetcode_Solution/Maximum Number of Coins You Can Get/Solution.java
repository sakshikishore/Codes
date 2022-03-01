class Solution {
    public int maxCoins(int[] piles) {
        Arrays.sort(piles);
        int result=0;
        int i=0;
        int p=piles.length-2;
        while(i<(piles.length/3))
        {
            result+=piles[p];
            i++;
            p=p-2;
        }
        
        return result;
    }
}
