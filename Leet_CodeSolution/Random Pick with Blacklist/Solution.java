class Solution {
    Random rand=new Random();
    List<List<Integer>> list=new ArrayList();
    ArrayList<Integer> al=new ArrayList<Integer>();
    int m=0,k=0;
    public Solution(int n, int[] blacklist) {
        int p=0;
        k=n;
        m=n-blacklist.length;
        Arrays.sort(blacklist);
        int z=0;
        for(int i=0;i<blacklist.length;i++)
        {
           if(i==0)
           {
               if(blacklist[i]!=0)
               {
                   ArrayList<Integer> l=new ArrayList<Integer>();
                   l.add(0);
                   l.add(blacklist[i]);
                   z=z+blacklist[i];
                   al.add(z);
                   list.add(l);
                   p=blacklist[i]+1;
               }
               else
               {
                    p=1;
               }
           }
           else
           {
               int k=blacklist[i]-p;
               if(k==0)
               {
                   p=blacklist[i]+1;
               }
               else
               {
                   ArrayList<Integer> l=new ArrayList<Integer>();
                   l.add(p);
                   l.add(blacklist[i]);
                   z=z+(blacklist[i]-p);
                   al.add(z);
                   list.add(l);
                   p=blacklist[i]+1;
               }
           }
        }
        if(p!=n)
        {
             ArrayList<Integer> l=new ArrayList<Integer>();
                   l.add(p);
                   l.add(n);
                   z=z+n-p;
                   al.add(z);
                   list.add(l);
        }
    }
    
    public int pick() {
        System.out.println(list.size());
        int p=rand.nextInt(m);
        if(m==k)
        {
            return p;
        }
        int low=0,high=al.size()-1;
        int index=0;
        while(low<=high)
        {
            int mid=(low+high)/2;
            if(al.get(mid)>p)
            {
                index=mid;
                high=mid-1;
            }
            else
            {
                low=mid+1;
            }
        }
        if(index==0)
        {
            return list.get(0).get(0)+p;
        }
        else
        {
            int count=al.get(index-1);
            int x=p-count;
            return list.get(index).get(0)+x;

        }

    }
}
