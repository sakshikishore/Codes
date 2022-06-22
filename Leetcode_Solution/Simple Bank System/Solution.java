class Bank {
   HashMap<Integer,Long> h;
     int n=0;
    public Bank(long[] balance) {
       h=new HashMap<Integer,Long>();
            for(int i=0;i<balance.length;i++)
            {
                h.put(i+1,balance[i]);
            }
         n=balance.length;
        }
    
    public boolean transfer(int account1, int account2, long money) {
        if(account1<=n && account2<=n)
        {
            long availableAmount=h.get(account1);
            if(money<=availableAmount)
            {
                h.put(account1,availableAmount-money);
                h.put(account2,h.get(account2)+money);
                return true;
            }
            else
            {
                return false;
            }
        }
        else
        {
            return false;
        }
    }
    
    public boolean deposit(int account, long money) {
        if(account<=n)
        {
            h.put(account,h.get(account)+money);
            return true;
        }
        else
        {
            return false;
        }
        
    }
    
    public boolean withdraw(int account, long money) {
        if(account<=n)
        {
            long availableAmount=h.get(account);
            if(availableAmount>=money)
            {
                h.put(account,h.get(account)-money);
                return true;
            }
            else
            {
               return false;
            }
        }
        else
        {
             return false;
        }
    }
}
