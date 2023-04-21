class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int totalGas=0,totalCost=0;
        for(int i=0;i<cost.length;i++)
        {
            totalCost+=cost[i];
            totalGas+=gas[i];
        }
        if(totalGas<totalCost)
        {
            return -1;
        }    
           int index=0,val=0;  
            for(int i=0;i<gas.length;i++)
            {
                val+=gas[i]-cost[i];
                if(val<0)
                {
                   index=i+1;
                   val=0;
                }

            }

        return index;
    }
}
