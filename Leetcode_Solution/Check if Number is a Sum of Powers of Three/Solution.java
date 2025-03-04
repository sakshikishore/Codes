import java.math.*;
class Solution {
    boolean result=false;
    public void Solve(int i,int ans,int n)
    {
       
        if(ans>n)
        {
            return;
        }
        if(result)
        {
            return;
        }
        if(ans==n)
        {
            result=true;
            return;
        }
        if(i+1>25)
        {
            return ;
        }
        Solve(i+1,ans+(int)Math.pow(3,i),n);
        Solve(i+1,ans,n);

    }
    public boolean checkPowersOfThree(int n) {
          Solve(0,0,n); 
          return result; 
    }
}
