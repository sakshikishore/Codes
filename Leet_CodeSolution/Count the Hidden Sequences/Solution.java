class Solution {
    public int numberOfArrays(int[] differences, int lower, int upper) {
        int pref[]=new int[differences.length]; 
        // b=a+differences[0], c=a+differences[0]+differences[1],...
        for(int i=0;i<differences.length;i++)
        {
            if(i==0)
            {
                pref[i]=differences[i];
            }
            else
            {
                pref[i]=pref[i-1]+differences[i];
            }
        }
        int rangeCount=0;
        int x=Integer.MIN_VALUE,y=Integer.MAX_VALUE;
        for(int i=0;i<pref.length;i++)
        {
            int low=lower-pref[i];
            int high=upper-pref[i];
            if(low>upper)
            {
                return 0;
            }
            if(low<lower)
            {
                low=lower;
            }
            if(upper<high)
            {
                high=upper;
            }
            if(low>x)
            {
                x=low;
            }
            if(high<y)
            {
                y=high;
            }  
            if(y<x)
            {
                return 0;
            }          
        }

        return y-x+1;
    }
}
