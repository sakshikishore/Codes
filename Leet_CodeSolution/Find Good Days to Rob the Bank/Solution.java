class Solution {
    public List<Integer> goodDaysToRobBank(int[] security, int time) {
        ArrayList<Integer> result=new ArrayList<Integer>();
        // Non Decreasing value
        int prefix[]=new int[security.length];
        prefix[0]=1;
        for(int i=1;i<security.length;i++)
        {
            if(security[i]<=security[i-1])
            {
                prefix[i]=prefix[i-1]+1;
            }
            else
            {
                prefix[i]=1;
            }
        }
        // Non Increasing value
        int suffix[]=new int[security.length];
        suffix[suffix.length-1]=1;
        for(int i=security.length-2;i>=0;i--)
        {
            if(security[i]<=security[i+1])
            {
                suffix[i]=suffix[i+1]+1;
            }
            else
            {
                suffix[i]=1;
            }
        }
        for(int i=time;i<security.length-time;i++)
        {
            if(prefix[i]>time && suffix[i]>time)
            {
                result.add(i);
            }
        }
        
        return result;

    }
}
