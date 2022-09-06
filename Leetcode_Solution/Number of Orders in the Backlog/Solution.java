class Solution {
    public int getNumberOfBacklogOrders(int[][] orders) {
        HashMap<Integer,Integer> buy=new HashMap<Integer,Integer>();
        HashMap<Integer,Integer> sell=new HashMap<Integer,Integer>();
        PriorityQueue<Integer> b=new PriorityQueue<Integer>(Collections.reverseOrder());
        PriorityQueue<Integer> s=new PriorityQueue<Integer>();
        for(int i=0;i<orders.length;i++)
        {
            int price=orders[i][0];
            int amount=orders[i][1];
            if(orders[i][2]==0)
            {
                   while(s.size()>0 && s.peek()<=price && amount!=0)
                   {
                       int x=sell.get(s.peek());
                       if(x>amount)
                       {
                           x=x-amount;
                           amount=0;
                           sell.put(s.peek(),x);
                       }
                       else if(x==amount)
                       {
                           amount=0;
                           sell.remove(s.peek());
                           s.poll();
                       }
                       else
                       {
                           amount=amount-x;
                           sell.remove(s.peek());
                           s.poll();
                       }
                       
                   }
                   if(amount!=0)
                   {
                       if(!buy.containsKey(price))
                       {
                           b.add(price);
                           buy.put(price,amount);
                       }
                       else
                       {
                           buy.put(price,buy.get(price)+amount);
                       }

                   }
            }
            else
            {
                    while(b.size()>0 && b.peek()>=price && amount!=0)
                    {
                        int x=buy.get(b.peek());
                        if(x>amount)
                        {
                            x=x-amount;
                            amount=0;
                            buy.put(b.peek(),x);
                        }
                       else if(x==amount)
                        {
                            amount=0;
                            buy.remove(b.peek());
                            b.poll();
                        }
                        else
                        {
                            amount=amount-x;
                           System.out.println(x);
                            buy.remove(b.peek());
                            b.poll();
                        }

                    }
                    if(amount!=0)
                    {

                       if(!sell.containsKey(price))
                       {
                           s.add(price);
                           sell.put(price,amount);
                       }
                       else
                       {
                           sell.put(price,sell.get(price)+amount);
                       }
                    }
            }
        }
        long result=0;
        for(Map.Entry<Integer,Integer> entry:sell.entrySet())
        {
            result=result+entry.getValue();
            result=result%(1000000007);
        }
         for(Map.Entry<Integer,Integer> entry:buy.entrySet())
        {
            result=result+entry.getValue();
            result=result%(1000000007);
        }
        
        return (int)result;
    }
}
