class Solution {
    public int findRadius(int[] houses, int[] heaters) {
        int max=0;
         HashSet<Integer> hset=new HashSet<Integer>();
         for(int i=0;i<heaters.length;i++)
         {
             hset.add(heaters[i]);
         }
        ArrayList<Integer> l=new ArrayList<Integer>();
        for(int i=0;i<houses.length;i++)
        {
            if(!hset.contains(houses[i]))
            {
                l.add(houses[i]);
            }
        }
        houses=new int[l.size()];
        int dp[]=new int[houses.length];
        for(int i=0;i<dp.length;i++)
        {
            dp[i]=Integer.MAX_VALUE;
        }
        for(int i=0;i<l.size();i++)
        {
            houses[i]=l.get(i);
        }
        for(int i=0;i<heaters.length;i++)
        {
            for(int j=0;j<houses.length;j++)
            {
                int distance=Math.abs(heaters[i]-houses[j]);
                if(distance<dp[j])
                {
                    dp[j]=distance;
                }
            }
        }
        for(int i=0;i<dp.length;i++)
        {
            if(dp[i]>max)
            {
                max=dp[i];
            }
        }
        
        return max;
        
    }
}
