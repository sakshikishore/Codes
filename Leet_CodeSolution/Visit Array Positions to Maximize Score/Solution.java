class Solution {
    public long maxScore(int[] nums, int x) {
        ArrayList<Long> l=new ArrayList<Long>();
        long p=nums[0];
        for(int i=1;i<nums.length;i++)
        {
            if((nums[i]%2==0 && nums[i-1]%2==0) || (nums[i]%2!=0 && nums[i-1]%2!=0))
            {
                p=p+nums[i];
            }
            else
            {
                l.add(p);
                p=nums[i];
            }
        }
        l.add(p);
        long result=0;
        long arr[]=new long[l.size()];
        arr[0]=l.get(0);
        for(int i=1;i<l.size();i++)
        {
            if(i==1)
            {
                long al=arr[i-1]+l.get(i)-x;
                arr[i]=al;
            }
            else
            {
                long a=l.get(i)+arr[i-2];
                long b=l.get(i)+arr[i-1]-x;
                arr[i]=(long)Math.max(a,b);
            }
        }
                        
                        if(arr.length==1)
                        { 
                           return arr[0];
                        }
                        else
                        {
                            return (long)Math.max(arr[arr.length-1],arr[arr.length-2]);
                        }
    }
}
