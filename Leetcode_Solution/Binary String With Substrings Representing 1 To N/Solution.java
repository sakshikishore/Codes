class Solution {
    public boolean queryString(String S, int N) {
        boolean result=true;
        for(int i=1;i<=N;i++)
        {
           String p=Integer.toString(i,2);
            if(!S.contains(p))
            {
                result=false;
                break;
            }
        }
        
        return result;
        
    }
}
