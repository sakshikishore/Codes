import java.math.*;
class Solution {
    public boolean checkPowersOfThree(int n) {
        ArrayList<Integer> l=new ArrayList<Integer>();
        boolean result=true;
        int x=n;
        while(result && x!=0)
        {
            n=(int)(Math.log(x)/Math.log(3));
            x=x-((int)Math.pow(3,n));
            if(!l.contains(n))
            {
                l.add(n);
            }
            else
            {
                result=false;
            }
        }
        return result;
        
        
    }
}
