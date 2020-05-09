class Solution {
    public boolean isHappy(int n) {
        boolean result=false;
        ArrayList<Integer> l=new ArrayList<Integer>();
        int flag=0;
        int s=n;
        while(flag!=1)
        {
            int sum=0;
            while(s>0)
            {
                int p=s%10;
                sum=sum+p*p;
                s=s/10;
            }
            if(sum==1)
            {
                result=true;
                flag=1;
            }
            else if(l.contains(sum))
            {
                result=false;
                flag=1;
            }
            else
            {
                s=sum;
                l.add(sum);
            }
        }
        return result;
        
    }
}
