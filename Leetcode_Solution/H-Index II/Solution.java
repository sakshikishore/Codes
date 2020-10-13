class Solution {
    public int hIndex(int[] citations) {
        int result=0;
        if(citations.length==0)
        {
            result=0;
        }
        else
        {
            for(int j=0;j<citations.length;j++)
            {
                if(citations[j]>=citations.length-j)
                {
                    result=citations.length-j;
                    break;
                }
            }
        }
        
        return result;
        
    }
}
