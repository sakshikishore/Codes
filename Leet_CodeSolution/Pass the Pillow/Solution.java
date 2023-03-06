class Solution {
    public int passThePillow(int n, int time) {
        int k=1;
        int flag=0;
        for(int i=1;i<=time;i++)
        {
            if(k==n)
            {
                flag=1;
            }
            else if(k==1)
            {
                flag=0;
            }
            if(flag==0)
            {
                k++;
            }
            else
            {
                k--;
            }
        }
        
        return k;
        
    }
}
