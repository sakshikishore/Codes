class AuctionSystem {
    HashMap<Integer, TreeMap<Integer, ArrayList<Integer>>> itemPriceUsers;
    HashMap<Integer,HashMap<Integer,Integer>> userItemPrice;

    public AuctionSystem() {
        itemPriceUsers = new HashMap<Integer, TreeMap<Integer, ArrayList<Integer>>>();
        userItemPrice=new HashMap<Integer,HashMap<Integer,Integer>>();
    }

    public void addBid(int userId, int itemId, int bidAmount) {
        int flag=0;
      if(!userItemPrice.containsKey(userId))
      {
        HashMap<Integer,Integer> h=new HashMap<Integer,Integer>();
        h.put(itemId,bidAmount);
        userItemPrice.put(userId,h);
      }
      else
      {
        HashMap<Integer,Integer> h=userItemPrice.get(userId);
        if(h.containsKey(itemId))
        {
            flag=1;
            updateBid(userId,itemId,bidAmount);
        }
        else
        {
            h.put(itemId,bidAmount);
            userItemPrice.put(userId,h);
        }
      }
      if(flag==0)
      {
      if(!itemPriceUsers.containsKey(itemId))
      {
        TreeMap<Integer, ArrayList<Integer>> t=new TreeMap<Integer, ArrayList<Integer>>();
        ArrayList<Integer> list=new ArrayList<Integer>();
        list.add(userId);
        t.put(bidAmount,list);
        itemPriceUsers.put(itemId,t);
      }
      else
      {
        TreeMap<Integer, ArrayList<Integer>> t=itemPriceUsers.get(itemId);
        if(t.containsKey(bidAmount))
        {
            ArrayList<Integer> list=t.get(bidAmount);
            int low=0,high=list.size()-1;
            while(low<=high)
            {
                int mid=(low+high)/2;
                if(list.get(mid)>userId)
                {
                    high=mid-1;
                }
                else
                {
                    low=mid+1;
                }
            }
            list.add(low,userId);
            t.put(bidAmount,list);
            itemPriceUsers.put(itemId,t);
        }
        else
        {
            ArrayList<Integer> list=new ArrayList<Integer>();
            list.add(userId);
            t.put(bidAmount,list);
            itemPriceUsers.put(itemId,t);
        }
      }
      }

    }

    public void updateBid(int userId, int itemId, int newAmount) {
        HashMap<Integer,Integer> h=userItemPrice.get(userId);
        int prevPrice=h.get(itemId);
        h.put(itemId,newAmount);
        TreeMap<Integer, ArrayList<Integer>> t=itemPriceUsers.get(itemId);
        ArrayList<Integer> list=t.get(prevPrice);
        if(list.size()==1)
        {
            t.remove(prevPrice);
        }
        else
        {
            int low=0,high=list.size()-1;
            while(low<=high)
            {
                int mid=(low+high)/2;
                if(list.get(mid)==userId)
                {
                    list.remove(mid);
                    break;
                }
                else if(list.get(mid)>userId)
                {
                    high=mid-1;
                }
                else
                {
                    low=mid+1;
                }
            }
        }
        if(t.containsKey(newAmount))
        {
             list=t.get(newAmount);
            int low=0,high=list.size()-1;
            while(low<=high)
            {
                int mid=(low+high)/2;
                if(list.get(mid)>userId)
                {
                    high=mid-1;
                }
                else
                {
                    low=mid+1;
                }
            }
            list.add(low,userId);
            t.put(newAmount,list);
            itemPriceUsers.put(itemId,t);
        }
        else
        {
             list=new ArrayList<Integer>();
            list.add(userId);
            t.put(newAmount,list);
            itemPriceUsers.put(itemId,t);
        }

    }

    public void removeBid(int userId, int itemId) {
       HashMap<Integer,Integer> h=userItemPrice.get(userId);
        int price=h.get(itemId);
        h.remove(itemId);
        TreeMap<Integer, ArrayList<Integer>> t=itemPriceUsers.get(itemId);
        ArrayList<Integer> list=t.get(price);
        if(list.size()==1)
        {
            t.remove(price);
            if(t.size()==0)
            {
                itemPriceUsers.remove(itemId);
            }
        }
        else
        {
            int low=0,high=list.size()-1;
            while(low<=high)
            {
                int mid=(low+high)/2;
                if(list.get(mid)==userId)
                {
                    list.remove(mid);
                    break;
                }
                else if(list.get(mid)>userId)
                {
                    high=mid-1;
                }
                else
                {
                    low=mid+1;
                }
            }
        }
    }

    public int getHighestBidder(int itemId) {
        if (itemPriceUsers.containsKey(itemId)) {
            TreeMap<Integer, ArrayList<Integer>> priceUsers = itemPriceUsers.get(itemId);
            int maxPrice = priceUsers.lastKey();
            ArrayList<Integer> users = priceUsers.get(maxPrice);

            return users.get(users.size()-1);
        }

        return -1;
    }
}

/**
 * Your AuctionSystem object will be instantiated and called as such:
 * AuctionSystem obj = new AuctionSystem();
 * obj.addBid(userId,itemId,bidAmount);
 * obj.updateBid(userId,itemId,newAmount);
 * obj.removeBid(userId,itemId);
 * int param_4 = obj.getHighestBidder(itemId);
 */
