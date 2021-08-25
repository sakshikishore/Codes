class Solution {
    public boolean canThreePartsEqualSum(int[] arr) {
        int p=0;
        int sum=0;
        boolean result=false;
        for(int i=0;i<arr.length;i++)
        {
            sum=sum+arr[i];
        }
        for(int i=0;i<arr.length;i++)
        {
            p=p+arr[i];
            sum=sum-arr[i];
            int x=sum;
            int l=0;
            for(int j=i+1;j<arr.length-1;j++)
            {
                l=l+arr[j];
                x=x-arr[j];
                if(x==l && l==p)
                {
                    result=true;
                    break;
                }
            }
            
            if(result==true)
            {
                break;
            }
        }
        
        return result;
    }
}
