class Solution {
    public int maxJump(int[] stones) {
        int max=0;
        int p=0;
        for(int i=2;i<stones.length;i=i+2)
        {
            if(stones[i]-stones[p]>max)
            {
                max=stones[i]-stones[p];
            }
            p=i;
        }
        if(p!=stones.length-1)
        {
            if(stones[stones.length-1]-stones[p]>max)
            {
                max=stones[stones.length-1]-stones[p];
            }
        }
        p=0;
        for(int i=1;i<stones.length;i=i+2)
        {
            if(stones[i]-stones[p]>max)
            {
                max=stones[i]-stones[p];
            }
            p=i;
        }
        if(p!=stones.length-1)
        {
            if(stones[stones.length-1]-stones[p]>max)
            {
                max=stones[stones.length-1]-stones[p];
            }
        }

        return max;

    }
}
