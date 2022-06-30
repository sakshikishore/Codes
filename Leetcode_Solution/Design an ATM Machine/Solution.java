class ATM {
  HashMap<Integer,Long> h;
    int arr[]={20,50,100,200,500};
    public ATM() {
        h=new HashMap<Integer,Long>();
    }
    
    public void deposit(int[] banknotesCount) {
        for(int i=0;i<5;i++)
        {
            if(banknotesCount[i]!=0)
            {
                if(!h.containsKey(arr[i]))
                {
                    long x=banknotesCount[i];
                    h.put(arr[i],x);
                }
                else
                {
                    h.put(arr[i],h.get(arr[i])+banknotesCount[i]);
                }
            }
        }
    }
    
    public int[] withdraw(int amount) {
        int result[]=new int[5];
        long a[]=new long[5];
        for(int i=4;i>=0;i--)
        {
            if(h.containsKey(arr[i]))
            {
               if(arr[i]<=amount)
               {
                     int p=amount/arr[i];
                     if(p!=0)
                     {
                         long q=h.get(arr[i]);
                         a[i]=q;
                         if(q==p)
                         {
                             result[i]=p;
                             amount=amount-(p*arr[i]);
                             h.remove(arr[i]);
                         }
                         else if(q>p)
                         {
                             result[i]=p;
                             amount=amount-(p*arr[i]);
                             h.put(arr[i],q-p);
                         }
                         else
                         {
                             result[i]=(int)q;
                             long z=amount-(q*arr[i]);
                             amount=(int)z;
                             h.remove(arr[i]);
                         }
                     }
               }
          }
            if(amount==0)
            {
                break;
            }
        }
        if(amount!=0)
        {
             for(int i=0;i<5;i++)
                {
                    if(a[i]!=0)
                    {
                        h.put(arr[i],a[i]);
                    }
                }
            result=new int[1];
            result[0]=-1;
            return result;
        }
        else
        {
            return result;
        }
    }
}
