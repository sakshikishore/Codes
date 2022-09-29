class Solution {
    public int maxProfitAssignment(int[] difficulty, int[] profit, int[] worker) {
        for(int i=0;i<difficulty.length;i++)
        {
            for(int j=i+1;j<difficulty.length;j++)
            {
               if(profit[i]<profit[j])
               {
                   int temp=profit[i];
                   profit[i]=profit[j];
                   profit[j]=temp;
                   
                   temp=difficulty[i];
                   difficulty[i]=difficulty[j];
                   difficulty[j]=temp;
                   
               }
                
            }
        }
        int result=0;
        for(int i=0;i<worker.length;i++)
        {
            int x=worker[i];
            for(int j=0;j<profit.length;j++)
            {
                if(difficulty[j]<=x)
                {
                    result+=profit[j];
                    break;
                }
            }
        }
        
        return result;
    }
    
}
