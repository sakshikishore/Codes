class Solution {
    public int hardestWorker(int n, int[][] logs) {
        int start=0;
        int max=0,id=-1;
        for(int i=0;i<logs.length;i++)
        {
            int x=logs[i][1]-start;
            if(x>max)
            {
                max=x;
                id=logs[i][0];
            }
            else if(x==max)
            {
                if(logs[i][0]<id)
                {
                    id=logs[i][0];
                }
            }
            
            start=logs[i][1];
        }
        
        return id;
    }
}
