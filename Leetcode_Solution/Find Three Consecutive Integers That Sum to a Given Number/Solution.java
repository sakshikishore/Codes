class Solution {
    public long[] sumOfThree(long num) {
        long result[];
        if(num%3==0)
        {
            result=new long[3];
            long p=num/3;
            result[1]=p;
            result[0]=p-1;
            result[2]=p+1;
        }
        else
        {
            result=new long[0];
        }
        
        return result;
    }
}
