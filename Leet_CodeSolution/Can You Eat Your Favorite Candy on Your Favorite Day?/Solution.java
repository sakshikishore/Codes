class Solution {
    public boolean[] canEat(int[] candiesCount, int[][] queries) {
        long pref[]=new long[candiesCount.length];
        boolean result[]=new boolean[queries.length];
        pref[0]=candiesCount[0];
        for(int i=1;i<candiesCount.length;i++)
        {
            pref[i]=pref[i-1]+candiesCount[i];
        }

        for(int i=0;i<queries.length;i++)
        {
            int day=queries[i][1];
            int type=queries[i][0];
            int cap=queries[i][2];
            if(type==0)
            {
                if(pref[0]>day)
                {
                    result[i]=true;
                }
                else
                {
                    result[i]=false;
                }
            }
            else
            {
                long x=pref[type-1];
                long t=0;
                t=x/cap;
                if(t>day)
                {
                    result[i]=false;
                }
                else if(pref[type]>day)
                {
                    result[i]=true;
                }
                
            }
        }
    
        return result;
    }
}
