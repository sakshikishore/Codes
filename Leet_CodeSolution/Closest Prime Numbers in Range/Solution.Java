class Solution {
    public int[] closestPrimes(int left, int right) {
        int a=-1,b=-1;
        int min=Integer.MAX_VALUE;
        int result[]={-1,-1};

        if(left==2)
        {
            a=2;
            left++;
        }
        else if(left%2==0)
        {
            left=left+1;
        }
        else if(left==1)
        {
           a=2;
           left=3;
        }
        while(left<=right)
        {
            int flag=0;
            for(int i=2;i*i<=left;i++)
            {
                if(left%i==0)
                {
                    flag=1;
                    break;
                }
            }
            if(flag==0)
            {
                if(a==-1)
                {
                    a=left;
                }
                else if(b==-1)
                {
                    b=left;
                    int p=b-a;
                    if(p<min)
                    {
                    min=p;
                    result[0]=a;
                    result[1]=b;
                    }
                    a=b;
                    b=-1;

                }
            }
            left=left+2;
        }

        return result;

    }
}
