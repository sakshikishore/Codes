class Solution {
    public String baseNeg2(int N) {
        String result="";
        if(N==0)
        {
            result="0";
        }
        else
        {
        while(N!=0)
        {
            int r=N%(-2);
            N=N/(-2);
            if(r<0)
            {
                r=2+r;
                N=N+1;
            }
            result=Integer.toString(r)+result;
        }
        
        }
        return result;
    }
}
