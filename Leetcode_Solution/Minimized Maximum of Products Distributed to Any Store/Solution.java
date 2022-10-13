class Solution {
    public int minimizedMaximum(int n, int[] quantities) {
        Arrays.sort(quantities);
        int max=quantities[quantities.length-1];
        int min=1;
        int result=0;
        while(min<=max)
        {
            int mid=(min+max)/2;
            int i=0;
            int totalStores=0;
            while(i<quantities.length)
            {
               totalStores+=Math.ceil(quantities[i]/(1.0*mid));
                i++;
            }
            if(totalStores<=n)
            {
                max=mid-1;
                result=mid;
            }
            else
            {
                min=mid+1;
            }
        }
        
        return result;
    }
}
