class Solution {
    public int hIndex(int[] citations) {
       int result=0;
        if(citations.length>0)
        {
            Arrays.sort(citations);
            for(int i=0;i<citations.length;i++)
            {
                if(citations[i]>=citations.length-i)
                {
                    result=citations.length-i;
                    break;
                }
            }
        }
        return result;
    }
}
