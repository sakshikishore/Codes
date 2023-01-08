class DataStream {
      int last=0,l=0,count=0,val=0;
    public DataStream(int value, int k) {
        val=value;
        l=k;
    }
    
    public boolean consec(int num) {
        if(last==0)
        {
            last=num;
            count++;
        }
        else
        {
            if(num==last)
            {
                count++;
            }
            else
            {
                last=num;
                count=1;
            }
        }
        
        if(last==val && count>=l)
        {
            return true;
        }
        
        return false;
    }
}
