class Solution {
    public int minSumOfLengths(int[] arr, int target) {
        int sum=0,start=0;
        int min=Integer.MAX_VALUE;
        HashMap<Integer,Integer> h=new HashMap<Integer,Integer>();
        ArrayList<Integer> l=new ArrayList<Integer>();
        for(int i=0;i<arr.length;i++)
        {
            sum+=arr[i];
            if(sum==target)
            {
                h.put(start,i);
                l.add(start);
                sum=sum-arr[start];
                start++;
            }
            else if(sum>target)
            {
                while(sum>target && start<=i)
                {
                    sum=sum-arr[start];
                    start++;
                }
                if(sum==target)
                {
                    h.put(start,i);
                    l.add(start);
                    sum=sum-arr[start];
                    start++;
                }
            }

        }
        if(l.size()<2)
        {
            return -1;
        }
        int pref[]=new int[l.size()];
        pref[l.size()-1]=h.get(l.get(l.size()-1))-l.get(l.size()-1)+1;
        for(int i=l.size()-2;i>=0;i--)
        {
            int p=h.get(l.get(i))-l.get(i)+1;
            if(p<pref[i+1])
            {
                pref[i]=p;
            }
            else
            {
                pref[i]=pref[i+1];
            }
        }
      
        for(int i=0;i<l.size()-1;i++)
        {
             int p=h.get(l.get(i));
             int low=i+1,high=l.size()-1,index=0;
             while(low<=high)
             {
                int mid=(low+high)/2;
                if(l.get(mid)>p)
                {
                    index=mid;
                    high=mid-1;
                }
                else
                {
                    index=mid+1;
                    low=mid+1;
                }
             }
             if(index<l.size())
             {
                  int x=p-l.get(i)+1;
                  if(x+pref[index]<min)
                  {
                    min=x+pref[index];
                  }
             }
        }
        if(min==Integer.MAX_VALUE)
        {
            return -1;
        }
        return min;
    }
}
