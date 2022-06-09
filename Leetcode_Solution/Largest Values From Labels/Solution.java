class Solution {
    public int largestValsFromLabels(int[] values, int[] labels, int numWanted, int useLimit) {
        int limit[]=new int[20001];
        int result=0;
        for(int i=0;i<values.length;i++)
        {
            for(int j=i+1;j<values.length;j++)
            {
                if(values[i]<values[j])
                {
                    int temp=values[i];
                    values[i]=values[j];
                    values[j]=temp;
                    
                    temp=labels[i];
                    labels[i]=labels[j];
                    labels[j]=temp;
                }
            }
        }
        int count=0;
        for(int i=0;i<values.length;i++)
        {
            if(limit[labels[i]]<useLimit)
            {
                limit[labels[i]]++;
                result+=values[i];
                count++;
                if(count==numWanted)
                {
                    break;
                }
            }
        }
        
        return result;
    }
}
