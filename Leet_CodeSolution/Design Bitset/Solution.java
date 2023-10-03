class Bitset {
    char c[];
    int flip=0;
    int count_0=0,count_1=0;
    public Bitset(int size) {
        c=new char[size];
        for(int i=0;i<c.length;i++)
        {
            c[i]='0';
        }
        count_0=size;
    }
    
    public void fix(int idx) {
        if(flip==0)
        {
            if(c[idx]=='0')
            {
                c[idx]='1';
                count_1++;
                count_0--;
            }
        }
        else
        {
            if(c[idx]=='1')
            {
                c[idx]='0';
                count_1++;
                count_0--;
            }
        }
    }
    
    public void unfix(int idx) {
        if(flip==0)
        {
            if(c[idx]=='1')
            {
                c[idx]='0';
                count_1--;
                count_0++;
            }
        }
        else
        {
            if(c[idx]=='0')
            {
                c[idx]='1';
                count_1--;
                count_0++;
            }
        }
    }
    
    public void flip() {
       flip++;
       flip=flip%2;
       int temp=count_1;
       count_1=count_0;
       count_0=temp;
    }
    
    public boolean all() {
       if(count_0==0)
       {
        return true;
       }

       return false;
    }
    
    public boolean one() {
        if(count_1>0)
        {
            return true;
        }

        return false;
    }
    
    public int count() {
       
        return count_1;
    }
    
    public String toString() {
        if(flip==1)
        {
            for(int i=0;i<c.length;i++)
            {
                if(c[i]=='1')
                {
                    c[i]='0';
                }
                else
                {
                    c[i]='1';
                }
            }
        }

        flip=0;
        return new String(c);
    }
}
