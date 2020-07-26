class Solution {
    public int addDigits(int num) {
        int sum=num;
        while(sum>=10)
        {
            int p=0;
            while(num!=0)
            {
                p=p+num%10;
                num=num/10;
            }
            
            sum=p;
            num=p;
        }
        
        return sum;
        
    }
}
