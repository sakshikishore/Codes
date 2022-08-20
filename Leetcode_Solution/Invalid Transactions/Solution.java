class Solution {
    public List<String> invalidTransactions(String[] transactions) {
        HashMap<String,ArrayList<Integer>> h=new HashMap<String,ArrayList<Integer>>();
        ArrayList<String> result=new ArrayList<String>();
        HashMap<String,Integer> h1=new HashMap<String,Integer>();
        for(int i=0;i<transactions.length;i++)
        {
            if(!h1.containsKey(transactions[i]))
            {
                h1.put(transactions[i],1);
            }
            else
            {
                h1.put(transactions[i],h1.get(transactions[i])+1);
            }
            String str[]=transactions[i].split(",");
            int amount=Integer.parseInt(str[2]);
            if(amount>1000)
            {
                result.add(transactions[i]);
            }
                if(!h.containsKey(str[0]))
                {
                    ArrayList<Integer> l=new ArrayList<Integer>();
                    l.add(i);
                    h.put(str[0],l);
                }
                else
                {
                    ArrayList<Integer> l=h.get(str[0]);
                    l.add(i);
                    h.put(str[0],l);
                }
        }
        HashSet<String> hset=new HashSet<String>();
        for(int i=0;i<transactions.length;i++)
        {
                String s=transactions[i];
                String str[]=s.split(",");
                int time=Integer.parseInt(str[1]);
               int amount1=Integer.parseInt(str[2]);
                int x=time+60;
                ArrayList<Integer> l=h.get(str[0]);
                int flag=0;
                for(int j=0;j<l.size();j++)
                {
                    if(l.get(j)!=i)
                    {
                        String p[]=transactions[l.get(j)].split(",");
                        if(!p[3].equals(str[3]))
                        {
                            int t=Integer.parseInt(p[1]);
                            if(t>=time && t<=x)
                            {
                                int amount2=Integer.parseInt(p[2]);
                                if(amount1<=1000)
                                {
                                     hset.add(s);
                                }
                                if(amount2<=1000)
                                {
                                  hset.add(transactions[l.get(j)]);
                                }
                            }
                        }
                    }
                }
        }
        Iterator<String> itr=hset.iterator();
        while(itr.hasNext())
        {
            String s=itr.next();
            for(int j=0;j<h1.get(s);j++)
            {
                result.add(s);
            }
        }
        return result;
    }
}
