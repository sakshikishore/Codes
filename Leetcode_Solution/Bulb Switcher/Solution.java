class Solution {
    public int bulbSwitch(int n) {
        if(n==0)
        {
            return 0;
        }
        if(n==1 || n==2 || n==3)
        {
            return 1;
        }
        else
        {
            int result=1;
            for(int i=4;i<=n;i++)
            {
                 int x=(int)Math.sqrt(i);
                 if(x*x==i)
                 {
                     result++;
                 }
                
            }
            return result;
        }
        
    }
}
