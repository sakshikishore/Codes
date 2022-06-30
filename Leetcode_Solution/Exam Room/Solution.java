class ExamRoom {
    int arr[],m;
    ArrayList<Integer> l=new ArrayList<Integer>();
    public ExamRoom(int n) {
       l=new ArrayList<Integer>();
        m=n;
    }
    
    public int seat() {
        if(l.size()==0)
        {
            l.add(0);
            return 0;
        }
        else if(l.size()==1)
        {
            if(l.contains(0))
            {
                  l.add(m-1);
                  return m-1;
            }
            else
            {
                if(l.get(0)-0>=(m-1)-l.get(0))
                {
                    l.add(0);
                    return 0;
                }
                else
                {
                    l.add(m-1);
                    return m-1;
                }
            }
        }
        else
        {
            Collections.sort(l);
            int x=0,index=0;
            if(!l.contains(0))
            {
                x=l.get(0);
                index=0;
            }
            for(int i=1;i<l.size();i++)
            {
                int y=l.get(i)-l.get(i-1);
                y=y/2;
                if(y>x)
                {
                    x=y;
                    index=(l.get(i)+l.get(i-1))/2;
                }
            }
            if(index==0 && l.contains(0))
            {
                l.add(m-1);
                return m-1;
            }
            else
            {
              l.add(index);
              return index;
            }
        }
    }
    
    public void leave(int p) {
       l.remove(new Integer(p));
    }
}
