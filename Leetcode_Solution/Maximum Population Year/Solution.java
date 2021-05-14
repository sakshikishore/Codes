class Solution {
    public int maximumPopulation(int[][] logs) {
        int max=2050;
        int maxCount=0;
        HashMap<Integer,Integer> h=new HashMap<Integer,Integer>();
        for(int i=0;i<logs.length;i++)
        {
            for(int j=logs[i][0];j<logs[i][1];j++)
            {
                if(!h.containsKey(j))
                {
                    h.put(j,1);
                    if(max>j && 1>=maxCount)
                    {
                        max=j;
                        maxCount=1;
                    }
                }
                else
                {
                    h.put(j,h.get(j)+1);
                    if(h.get(j)>maxCount)
                    {
                        max=j;
                        maxCount=h.get(j);
                    }
                    else if(h.get(j)==maxCount)
                    {
                        if(max>j)
                        {
                            max=j;
                        }

                    }
                     
                }
            }
        }
        return max;
        
    }
}
