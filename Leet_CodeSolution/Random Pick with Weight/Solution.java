class Solution {
   ArrayList<Integer> l=new ArrayList<Integer>();
   int sum=0;
    public Solution(int[] w) {
        sum=w[0];
        l.add(sum);
        for(int i=1;i<w.length;i++)
        {
          sum+=w[i];
          l.add(sum);
        }

    }
    
    public int pickIndex() {
        Random rand=new Random();
        int x=rand.nextInt(sum);
        x=x+1;
        int low=0,high=l.size()-1,index=0;
        while(low<=high)
        {
          int mid=(low+high)/2;
          if(l.get(mid)>x)
          {
            index=mid;
            high=mid-1;
          }
          else if(l.get(mid)==x)
          {
             index=mid;
             break;
          }
          else
          {
            index=mid+1;
            low=mid+1;
          }
        }
        return index;

    }
}
