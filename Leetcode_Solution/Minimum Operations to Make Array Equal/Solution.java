class Solution {
    public int minOperations(int n) {
        int result=0;
        int mid=n/2;
        mid=mid+1;
        int midValue=1+((mid-1)*2);
        if(midValue==n)
        {
            int p=n-mid;
            result=p*(1+p);           
        }
        else if(midValue>n)
        {
            int a=midValue-n;
            int p=(n-mid)+1;
            result=p*(a+p-1);
        }
        
        return result;
    }
}
