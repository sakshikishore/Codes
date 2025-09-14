class Solution {
    public int earliestTime(int[][] tasks) {
        int result=Integer.MAX_VALUE;
        for(int i=0;i<tasks.length;i++)
        {
            int totalTime=tasks[i][0]+tasks[i][1];
            if(totalTime<result)
            {
                result=totalTime;
            }
        }

        return result;
    }
}
