class Solution {
    public int findLengthOfShortestSubarray(int[] arr) {
        int min=arr.length-1;
        ArrayList<Integer> l1=new ArrayList<Integer>();
        HashSet<Integer> hset=new HashSet<Integer>();
        l1.add(0);
        for(int i=1;i<arr.length;i++)
        {
            if(arr[i]>=arr[i-1])
            {
                hset.add(i);
                l1.add(i);
            }
            else
            {
                break;
            }
        }
         min=arr.length-l1.size();
        ArrayList<Integer> l2=new ArrayList<Integer>();
        l2.add(arr.length-1);
        for(int i=arr.length-2;i>=0;i--)
        {
            if(hset.contains(i))
            {
                break;
            }
            if(arr[i]<=arr[i+1])
            {  
              l2.add(i);
            }
            else
            {
                break;
            }
        }

      for(int j=0;j<l2.size();j++)
      {
        int p=arr[l2.get(j)];
        int low=0,high=l1.size()-1;
            int index=0;
        while(low<=high)
        {
            int mid=(low+high)/2;
            if(arr[l1.get(mid)]>p)
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
        int n=index+(arr.length-l2.get(j));
        if(arr.length-n<min)
        {
            min=arr.length-n;
        }

      }
      if(min<=0)
      {
        return 0;
      }
      return min;

    }
}
