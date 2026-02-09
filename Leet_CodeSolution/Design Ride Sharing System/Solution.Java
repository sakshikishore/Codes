public class rideDetails{
    int id,key;
    public rideDetails(int i, int k)
    {
        id=i;
        key=k;
    }
}
class RideSharingSystem {
   Queue<Integer> driver;
   HashMap<Integer,Integer> riderKey; 
   ArrayList<rideDetails> list=new ArrayList<rideDetails>();
   int count=0;
    public RideSharingSystem() {
        driver=new LinkedList<Integer>();
        riderKey=new HashMap<Integer,Integer>();
    }
    
    public void addRider(int riderId) {
        count++;
        riderKey.put(riderId,count);
        list.add(new rideDetails(riderId,count));
    }
    
    public void addDriver(int driverId) {
        driver.add(driverId);
    }
    
    public int[] matchDriverWithRider() {
        int result[]={-1,-1};
        if(list.size()==0 || driver.size()==0)
        {
            return result;
        }
        result[0]=driver.poll();
        result[1]=list.get(0).id;
        riderKey.remove(list.get(0).id);
        list.remove(0);
        return result;
    }
    
    public void cancelRider(int riderId) {
        if(riderKey.containsKey(riderId))
        {
            int id=riderKey.get(riderId);
            riderKey.remove(riderId);
            int low=0,high=list.size()-1;
            while(low<=high)
            {
                int mid=(low+high)/2;
                if(list.get(mid).key==id)
                {
                    list.remove(mid);
                    break;
                }
                else if(list.get(mid).key>id)
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
}

