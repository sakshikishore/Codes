class Solution {
    public double averageWaitingTime(int[][] customers) {
        int a[]=new int[customers.length];
        int p=0;
        double sum=0.0;
        for(int i=0;i<customers.length;i++)
        {
            if(i==0)
            {
             p=customers[i][0]+customers[i][1];
             a[i]=p-customers[i][0];
            }
            else
            {
                if(p>=customers[i][0])
                {
                p=p+customers[i][1];
                a[i]=p-customers[i][0];
                }
                else
                {
                    p=customers[i][0]+customers[i][1];
                    a[i]=p-customers[i][0];
                }
            }
            sum=sum+a[i];
        }
        
        return sum/customers.length;
        
    }
}
