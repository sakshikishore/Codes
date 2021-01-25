class Solution {
    public int largestAltitude(int[] gain) {
        int p=0;
        int max=0;
        for(int i=0;i<gain.length;i++)
        {
            p=gain[i]+p;
            if(p>max)
            {
                max=p;
            }
        }
        
        return max;
    }
}
