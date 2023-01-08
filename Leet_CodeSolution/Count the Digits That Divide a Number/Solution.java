class Solution {
    public int countDigits(int num) {
        int x=num;
        int result=0;
        while(x>0)
        {
            int r=x%10;
            if(num%r==0)
            {
                result++;
            }
            x=x/10;
        }
        
        return result;
    }
}
