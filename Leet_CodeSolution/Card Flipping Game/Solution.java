class Solution {
    public int flipgame(int[] fronts, int[] backs) {
        int min=Integer.MAX_VALUE;
        for(int i=0;i<fronts.length;i++)
        {
            if(fronts[i]==backs[i])
             {
                continue;
             }
             int flag=0;
            for(int j=0;j<fronts.length;j++)
            {
                if(i!=j)
                {
                    if(fronts[j]==backs[i] && backs[j]==backs[i])
                    {
                        flag=1;
                        break;
                    }
                }
            }
            if(flag==0)
                {
                    if(backs[i]<min)
                    {
                        min=backs[i];
                    }
                }
            flag=0;
            for(int j=0;j<fronts.length;j++)
            {
                if(i!=j)
                {
                    if(fronts[j]==fronts[i] && backs[j]==fronts[i])
                    {
                        flag=1;
                        break;
                    }
                }
            }
            if(flag==0)
                {
                    if(fronts[i]<min)
                    {
                        min=fronts[i];
                    }
                }
        }
        if(min==Integer.MAX_VALUE)
        {
            return 0;
        }

        return min;
    }
}
