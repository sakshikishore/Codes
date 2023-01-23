class Solution {
    public int alternateDigitSum(int n) {
        ArrayList<Integer> l=new ArrayList<Integer>();
        int result=0;
        while(n>0)
        {
            int r=n%10;
            l.add(r);
            n=n/10;
        }
        int a=0;
        for(int i=l.size()-1;i>=0;i--)
        {
            if(a==0)
            {
                result+=l.get(i);
                a=1;
            }
            else
            {
                result=result-l.get(i);
                a=0;
            }
        }
        
        return result;
    }
}
