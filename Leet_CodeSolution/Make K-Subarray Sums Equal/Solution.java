class Solution {
    public long makeSubKSumEqual(int[] arr, int k) {
        long ans=0;
        if(k==arr.length)
        {
          return 0;
        }
        if(arr.length%2!=0)
        {
            Arrays.sort(arr);
            int mid=arr.length/2;
            for(int i=0;i<arr.length;i++)
            {
              ans+=Math.abs(arr[i]-arr[mid]);
            }

            return ans;
        }
        else
        { 
          HashSet<Integer> h=new HashSet<Integer>();
          for(int i=0;i<arr.length;i++)
          {
            if(!h.contains(i))
            {
              ArrayList<Integer> l=new ArrayList<Integer>();
              int j=i;
              while(!h.contains(j))
              {
                   h.add(j);
                   l.add(arr[j]);
                   j=(j+k)%arr.length;
              }
              Collections.sort(l);
              int mid=l.size()/2;
              for(int x=0;x<l.size();x++)
              {
                ans+=Math.abs(l.get(mid)-l.get(x));
              }
            }
            if(h.size()==arr.length)
            {
              break;
            }
          }

          return ans;

        }

    }
}
