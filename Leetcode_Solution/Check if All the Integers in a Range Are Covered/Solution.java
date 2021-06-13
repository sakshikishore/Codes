class Solution {
    public boolean isCovered(int[][] ranges, int left, int right) {
        int count=0;
        boolean result=false;
        for(int i=left;i<=right;i++)
        {
            for(int j=0;j<ranges.length;j++)
            {
                if(ranges[j][0]==i || ranges[j][1]==i || ((ranges[j][0]<i) && (ranges[j][1]>i)))
                {
                    count++;
                    break;
                }
            }
        }
        
        if(count==right-left+1)
        {
            result=true;
        }
        
        return result;
    }
}
