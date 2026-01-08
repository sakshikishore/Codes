class Solution {
    public int[] minOperations(int[] nums) {
        int result[]=new int[nums.length];
        Arrays.fill(result,-1);
        ArrayList<Integer> l=new ArrayList<Integer>();
        for(int i=1;i<=8191;i++) // binary of 8191 = "1111111111111"(maximum palindrome number) as total nums[i] limit is 5000(length= 13) 
        {
            String str=Integer.toBinaryString(i);
            StringBuffer sb=new StringBuffer(str);
            String p=new String(sb.reverse());
            if(p.equals(str))
            {
                l.add(i);
            }
        }
        for(int i=0;i<nums.length;i++)
        {
  int low=1,high=l.size()-1;
  while(low<=high)
  {
    int mid=(low+high)/2;
    if(l.get(mid)==nums[i])
    {
       result[i]=0;
       break;
    }
    if(l.get(mid)>nums[i])
    {
        high=mid-1;
    }
    else
    {
        low=mid+1;
    }
  }
  if(result[i]==-1)
  {
        if(low==0)
        {
           result[i]= l.get(0)-nums[i];
        }
        else if(low==l.size())
        {
            result[i]= nums[i]-l.size();
        }
        else
        {

          result[i]=Math.min(nums[i]-l.get(low-1), l.get(low)-nums[i]);
        }
  }
        }

        return result;
    }
}
