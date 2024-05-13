class Solution {
    public int maximumEnergy(int[] energy, int k) {
        int result[]=new int[energy.length];
        int max=Integer.MIN_VALUE;
        for(int i=0;i<k;i++)
        {
            result[i]=energy[i];
            if(i+k>=energy.length)
            {
                if(result[i]>max)
                {
                    max=result[i];
                }
            }
        }
        
        for(int i=k;i<energy.length;i++)
        {
            int p=result[i-k];
            if(p+energy[i]>energy[i])
            {
                result[i]=p+energy[i];
            }
            else
            {
                result[i]=energy[i];
            }
            if(i+k>=energy.length)
            {
                if(result[i]>max)
                {
                    max=result[i];
                }
            }

        }
        
        return max;
    }
}
