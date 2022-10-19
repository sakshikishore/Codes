class Solution {
    public boolean isPalindrome(int x) {
        if(x>=0)
        {
            int n=x;
            int revNum=0;
            while(n!=0)
            {
                int r=n%10;
                revNum=revNum*10+r;
                n=n/10;
            }

            if(x==revNum)
            {
                return true;
            }
        }
        
        return false;
    }
}
