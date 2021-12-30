class Solution {
    public int[] fairCandySwap(int[] aliceSizes, int[] bobSizes) {
        int result[]=new int[2];
        ArrayList<Integer> l=new ArrayList<Integer>();
        int sum1=0;
        int sum2=0;
        int sum=0;
        for(int i=0;i<aliceSizes.length;i++)
        {
            l.add(aliceSizes[i]);
            sum1=sum1+aliceSizes[i];         
        }
        for(int i=0;i<bobSizes.length;i++)
        {
            sum2=sum2+bobSizes[i];         
        }
        sum=sum1+sum2;
        int half=sum/2;
        for(int i=0;i<bobSizes.length;i++)
        {
            int p=sum2-bobSizes[i];
            int k=half-p;
            if(l.contains(k) && (sum1-k+bobSizes[i])==half)
            {
                result[0]=k;
                result[1]=bobSizes[i];
                break;
            }
        }
        
        return result;
    }
}
