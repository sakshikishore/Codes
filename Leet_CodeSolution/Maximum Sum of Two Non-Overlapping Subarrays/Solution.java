class Solution {
    public int maxSumTwoNoOverlap(int[] nums, int firstLen, int secondLen) {
        ArrayList<Integer> l=new ArrayList<Integer>();
        ArrayList<Integer> m=new ArrayList<Integer>();
        int sum=0;
        for(int i=0;i<firstLen;i++)
        {
           sum+=nums[i];
        }
        l.add(sum);
        int p=0;
        for(int i=firstLen;i<nums.length;i++)
        {
            sum=sum-nums[p];
            sum=sum+nums[i];
            l.add(sum);
            p++;
        }
        sum=0;
        for(int i=0;i<secondLen;i++)
        {
           sum+=nums[i];
        }
        m.add(sum);
        p=0;
        for(int i=secondLen;i<nums.length;i++)
        {
            sum=sum-nums[p];
            sum=sum+nums[i];
            m.add(sum);
            p++;
        }
        int a=0,b=firstLen-1;
        int max=0;
        for(int i=0;i<l.size();i++)
        {
            int c=0,d=secondLen-1;
            int val=l.get(i);
           for(int k=0;k<m.size();k++)
           {
               if((c<a && d<a) || (c>b && d>b))
               {
                    sum=val+m.get(k);
                    if(sum>max)
                    {
                        max=sum;
                    }
               }
                c++;
                d++;
           }
           a++;
           b++;
        }

        return max;


    }
}
