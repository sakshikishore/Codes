class Solution {
    public int bestClosingTime(String customers) {
        int noCustomerLeft[]=new int[customers.length()];
        int max=0;
        for(int i=0;i<customers.length();i++)
        {
            if(customers.charAt(i)=='N')
            {
                max++;
            }
            noCustomerLeft[i]=max;
        }
        if(max==0)
        {
            return customers.length();
        }
        int customerRight[]=new int[customers.length()];
        max=0;
        for(int i=customers.length()-1;i>=0;i--)
        {
            if(customers.charAt(i)=='Y')
            {
                max++;
            }
            customerRight[i]=max;
        }
        int minPenalty=100001;
        int hour=0;
        for(int i=0;i<customers.length();i++)
        {
            if(i==0)
            {
                minPenalty=customerRight[i];
            }
            else
            {
                if(noCustomerLeft[i-1]+customerRight[i]<minPenalty)
                {
                    minPenalty=noCustomerLeft[i-1]+customerRight[i];
                    hour=i;
                }
            }
        }
       if(noCustomerLeft[customers.length()-1]<minPenalty)
       {
            hour=customers.length();
       }

        return hour;

    }
}
