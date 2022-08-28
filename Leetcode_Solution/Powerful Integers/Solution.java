class Solution {
    public List<Integer> powerfulIntegers(int x, int y, int bound) {
        int flagi=0;
        ArrayList<Integer> l=new ArrayList<Integer>();
        if(bound<2)
        {
            return l;
        }
        if(x==1 && y==1)
        {
            l.add(2);
            return l;
        }
        else if(x==1)
        {
            int flag=0;
            int i=0;
            while(flag!=1)
            {
                int p=(int)Math.pow(y,i)+1;
                if(p<=bound)
                {
                    l.add(p);
                }
                else
                {
                    break;
                }
                i++;
            }
            return l;
        }
        else if(y==1)
        {
            int flag=0;
            int i=0;
            while(flag!=1)
            {
                int p=(int)Math.pow(x,i)+1;
                if(p<=bound)
                {
                    l.add(p);
                }
                else
                {
                    break;
                }
                i++;
            }
            return l;
        }
        HashSet<Integer> h=new HashSet<Integer>();
        int i=0;
        while(flagi!=1)
        {
            int p=(int)Math.pow(x,i);
            if(p+1>bound)
            {
                break;
            }
            else
            {
                if(!h.contains(p+1))
                {
                  l.add(p+1);
                  h.add(p+1);
                }
            }
            int j=1;
            int flagj=1;
            while(flagj!=0)
            {
              int q=(int)Math.pow(y,j);
              if(p+q<=bound)
              {
                    if(!h.contains(p+q))
                    {
                      l.add(p+q);
                      h.add(p+q);
                    }
                  j++;
              } 
              else
              {
                  break;
              }
            }
            i++;
        }
        
        return l;
    }
}
