class Solution {
    public int distanceBetweenBusStops(int[] distance, int start, int destination) {
        int l=0,r=0;
        if(start>destination)
        {
            int temp=start;
            start=destination;
            destination=temp;
        }
        for(int i=start;i<destination;i++)
        {
            l=l+distance[i];
        }
        int j=destination+1;
        int prev=destination;
        if(j==distance.length)
        {
              j=0;
        }
        while(j!=start)
        {                 
            r=r+distance[prev];
            prev=j;
            j++;
            if(j==distance.length)
            {
                j=0;
            }
        }
        r=r+distance[prev];
        
        return (int)Math.min(l,r);
        
    }
}
