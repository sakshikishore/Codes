class Solution {
    public int maxConsecutive(int bottom, int top, int[] special) {
        int max=0;
        Arrays.sort(special);
        for(int i=0;i<special.length;i++)
        {
            if(i==0)
            {
                max=special[i]-bottom;
            }
            else
            {
                if((special[i]-special[i-1])-1>max)
                {
                    max=special[i]-special[i-1]-1;
                }
            }
        }
        
        if(top-special[special.length-1]>max)
        {
            max=top-special[special.length-1];
        }
        return max;
        
    }
}
