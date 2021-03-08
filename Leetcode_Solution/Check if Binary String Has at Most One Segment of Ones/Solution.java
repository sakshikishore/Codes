class Solution {
    public boolean checkOnesSegment(String s) {
        int count=0,t=0;
        boolean result=false;
        for(int i=0;i<s.length();i++)
        {
            if(s.charAt(i)=='1')
            {
                if(t==1)
                {
                    result=false;
                    break;
                }
                count=1;
                result=true;
            }
            else
            {
                if(count==1)
                {
                    t=1;
                }
                count=0;
            }
        }
        
        return result;
        
    }
}
