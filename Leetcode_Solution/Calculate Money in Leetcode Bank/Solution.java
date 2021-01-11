class Solution {
    public int totalMoney(int n) {
        int i=1,total=0;
        int l=i;
        for(int j=0;j<n;j++)
        {
            if(j%7==0 && j!=0)
            {
                i++;
                l=i;
            }
            total+=l;
            l++;
        }
        return total;
        
    }
}
