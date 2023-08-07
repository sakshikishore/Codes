class Solution {
    int target=0;
    int flag=0;
    public void Solve(int arr[],int index,ArrayList<Long> list,long sum,HashSet<Long> h)
    {
        if(index==arr.length)
        {
            if(!h.contains(sum))
            {
                h.add(sum);
                list.add(sum);
                if(sum==target)
                {
                    flag=1;
                }
            }
            return;
        }
        Solve(arr,index+1,list,sum+arr[index],h);
        Solve(arr,index+1,list,sum,h);
        
    }
    public int minAbsDifference(int[] nums, int goal) {
        target=goal;
        ArrayList<Long> l=new ArrayList<Long>();
        ArrayList<Long> m=new ArrayList<Long>();
        HashSet<Long> h=new HashSet<Long>();
        if(nums.length==1)
        {
            return (int)Math.min(Math.abs(0-goal),Math.abs(nums[0]-goal));
        }
        int mid=nums.length/2;
        int arr1[]=new int[mid];
        int arr2[]=new int[nums.length-mid];
        for(int i=0;i<mid;i++)
        {
            arr1[i]=nums[i];
        }
        int j=0;
        for(int i=mid;i<nums.length;i++)
        {
            arr2[j]=nums[i];
            j++;
        }
        Solve(arr1,0,l,0,h);
        h=new HashSet<Long>();
        Solve(arr2,0,m,0,h);
        if(flag==1)
        {
            return 0;
        }

        long min=Long.MAX_VALUE;
        Collections.sort(m);
        Collections.sort(l);
        int a=0,b=m.size()-1;
        while(a<l.size() && b>=0)
        {
            long sum=l.get(a)+m.get(b);
            min=(long)Math.min(min,Math.abs(sum-goal));
            if(sum>goal)
            {
                b--;
            }
            else if(sum==goal)
            {
                return 0;
            }
            else
            {
                a++;
            }
        }

        return (int)min;

    }
}
