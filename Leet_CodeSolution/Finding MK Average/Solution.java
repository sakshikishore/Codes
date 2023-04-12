class MKAverage {
    ArrayList<Integer> l=new ArrayList<Integer>();
    Queue<Integer> q=new LinkedList<Integer>();
    int m1=0,n1=0;
    int flag=0;
    public MKAverage(int m, int k) {
        m1=m;
        n1=k;
    }
    
    public void addElement(int num) {
        q.add(num);
        if(l.size()<m1)
        {
            l.add(num);
            if(l.size()==m1)
            {
                flag=1;
                Collections.sort(l);
            }
        }
        else
        {
           int x=q.poll();
           int low=0,high=m1-1;
           int index=0;
           while(low<=high)
           {
               int mid=(low+high)/2;
               if(l.get(mid)==x)
               {
                      l.remove(mid);
                      break;
               }
               else if(l.get(mid)<x)
               {
                   low=mid+1;
               }
               else
               {
                   high=mid-1;
               }
           }
           low=0;
           high=m1-2;
           while(low<=high)
           {
               int mid=(low+high)/2;
               if(l.get(mid)>num)
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
           l.add(index,num);
        }
    }
    
    public int calculateMKAverage() {
        if(flag==0)
        {
            return -1;
        }
        int sum=0;
        int count=0;
        for(int i=n1;i<m1-n1;i++)
        {
           sum+=l.get(i);
           count++;
        }
        return sum/count;
    }
}
