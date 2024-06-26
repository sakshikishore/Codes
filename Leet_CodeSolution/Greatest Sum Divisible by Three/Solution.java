class Solution {
    public int maxSumDivThree(int[] nums) {
        ArrayList<Integer> l=new ArrayList<Integer>();
        ArrayList<Integer> m=new ArrayList<Integer>();
        int sum=0;
        for(int i=0;i<nums.length;i++)
        {
            sum+=nums[i];
            if(nums[i]%3==1)
            {
                l.add(nums[i]);
            }
            else if(nums[i]%3==2)
            {
                m.add(nums[i]);
            }
        }
        if(sum%3==0)
        {
            return sum;
        }
        else
        {
            Collections.sort(l);
            Collections.sort(m);
            if(sum%3==1)
            {
                if(l.size()==0)
                {
                    sum=sum-m.get(0)-m.get(1);
                }
                else if(m.size()>1)
                {
                    int p=Math.min(l.get(0),m.get(0)+m.get(1));
                    sum=sum-p;
                }
                else
                {
                    sum=sum-l.get(0);
                }
            }

            else
            {
                if(m.size()==0)
                {
                    sum=sum-l.get(0)-l.get(1);
                }
                else if(l.size()>1)
                {
                     int p=Math.min(m.get(0),l.get(0)+l.get(1));
                    sum=sum-p;
                }
                else
                {
                     sum=sum-m.get(0);
                }
            }
        }
          return sum;
    }
}
