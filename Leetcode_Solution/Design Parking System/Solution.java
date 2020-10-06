class ParkingSystem {

    HashMap<Integer,Integer> h=new HashMap<Integer,Integer>();
    public ParkingSystem(int big, int medium, int small) {
        if(small>0)
        {
            h.put(3,small);
        }
         if(medium>0)
        {
            h.put(2,medium);
        }
         if(big>0)
        {
            h.put(1,big);
        }
        
    }
    
    public boolean addCar(int carType) {
        boolean result=false;
        if(h.containsKey(carType))
        {
            result=true;
            int p=h.get(carType);
            if(p-1==0)
            {
                h.remove(carType);
            }           
            else
            {
                h.put(carType,p-1);
            }
        }
        
        return result;
                           
    }
}

/**
 * Your ParkingSystem object will be instantiated and called as such:
 * ParkingSystem obj = new ParkingSystem(big, medium, small);
 * boolean param_1 = obj.addCar(carType);
 */
