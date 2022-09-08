class Solution {
    public double[] sampleStats(int[] count) {
        long sum=0;
        double result[]=new double[5];
        double min=-1.0;
        double max=-1.0;
        double maxFreq=0.0;
        int n=0;
        ArrayList<Integer> l=new ArrayList<Integer>();
        for(int i=0;i<256;i++)
        {
            long a=i;
            sum+=a*(count[i]);
            n=n+count[i];
            if(count[i]>maxFreq)
            {
                maxFreq=count[i];
                result[4]=i;
                
            }
            if(count[i]!=0)
            {
                if(min==-1.0)
                {
                    result[0]=i;
                    min=i;
                }
                
                result[1]=i;
            }
        }
        double k=n;
        result[2]=sum/k;
        if(n%2==0)
        {
            int m=0;
            double a=0.0,b=0.0;
            int mid=n/2;
            for(int i=0;i<256;i++)
            {
                m+=count[i];
                if(m>=mid+1)
                {
                   if(a==0 && b==0)
                   {
                       a=i;
                       b=i;
                       result[3]=(a+b)/2.0;
                       break;
                   }
                   else
                   {
                      
                       b=i;
                       result[3]=(a+b)/2.0;
                       break;
                   }
                }
                else if(m==mid)
                {
                    if(a==0)
                    {
                        a=i;
                    }
                }
            }
        }
        else
        {
            int mid=n/2;
            mid=mid+1;
            int m=0;
            for(int i=0;i<256;i++)
            {
                m+=count[i];
                if(m>=mid)
                {
                    result[3]=i;
                    break;
                }
            }
        }
        
        
        return result;
    }
}
