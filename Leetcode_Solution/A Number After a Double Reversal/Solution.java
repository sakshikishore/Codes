class Solution {
    public boolean isSameAfterReversals(int num) {
        boolean result=true;
       
        if(num!=0 && num%10==0)
        {
            result=false;
        }
        
        return result;
    }
}
