class Solution {
    public int maximumUnits(int[][] boxTypes, int truckSize) {
        for(int i=0;i<boxTypes.length;i++)
        {
            for(int j=i+1;j<boxTypes.length;j++)
            {
                if(boxTypes[i][1]<boxTypes[j][1])
                {
                    int temp=boxTypes[i][1];
                    boxTypes[i][1]=boxTypes[j][1];
                    boxTypes[j][1]=temp;
                    
                    temp=boxTypes[i][0];
                    boxTypes[i][0]=boxTypes[j][0];
                    boxTypes[j][0]=temp;
                }
            }
        }
        
        int maxUnits=0;
        int p=0,k=0;
        while(p<truckSize && k<boxTypes.length)
        {
            if(boxTypes[k][0]<=truckSize-p)
            {
                maxUnits=maxUnits+(boxTypes[k][0]*boxTypes[k][1]);
                p+=boxTypes[k][0];
                k++;
            }
            else
            {
                maxUnits=maxUnits+((truckSize-p)*boxTypes[k][1]);
                p=truckSize;
            }
        }
        
        return maxUnits;
    }
}
