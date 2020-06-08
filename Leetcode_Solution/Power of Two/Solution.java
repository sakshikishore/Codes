class Solution {
    public boolean isPowerOfTwo(int n) {
        String str=Integer.toString(n,2);
        boolean result=false;
        int count=0;
        if(n>0)
        {       
        while(n!=0)
        {
            count+=n&1;
            n>>=1;
        }
        if(count==1)
        {
            result=true;
        }
        }
        
        return result;
        
    }
}
