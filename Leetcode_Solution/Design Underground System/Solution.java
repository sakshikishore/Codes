class UndergroundSystem {
   HashMap<Integer,String> h;
   HashMap<String,String> k;
    public UndergroundSystem() {
        h=new HashMap<Integer,String>();
        k=new HashMap<String,String>();
    }
    
    public void checkIn(int id, String stationName, int t) {
        if(!h.containsKey(id))
        {
            h.put(id,stationName+" "+Integer.toString(t));
        }
        else
        {         
            h.put(id,h.get(id)+","+stationName+" "+Integer.toString(t));        
        }
    }
    
    public void checkOut(int id, String stationName, int t) {
        String p[]=h.get(id).split(",");
        for(int i=0;i<p.length;i++)
        {
            String q[]=p[i].split(" ");
            String str=q[0]+" "+stationName;
            int r=t-Integer.parseInt(q[1]);
            if(!k.containsKey(str))
            {
                k.put(str,Integer.toString(r));
            }
            else
            { 
                  k.put(str,k.get(str)+" "+Integer.toString(r));
                 
            }

            
        }
        h.remove(id);
    }
    
    public double getAverageTime(String startStation, String endStation) {
        double result=0.0;
        if(k.containsKey(startStation+" "+endStation))
        {
           String p[]=k.get(startStation+" "+endStation).split(" ");
            double totalSum=0.0;
            for(int i=0;i<p.length;i++)
            {
                totalSum+=Integer.parseInt(p[i]);
            }
            
            result=totalSum/p.length;
        }
        
        return result;
        
    }
}

/**
 * Your UndergroundSystem object will be instantiated and called as such:
 * UndergroundSystem obj = new UndergroundSystem();
 * obj.checkIn(id,stationName,t);
 * obj.checkOut(id,stationName,t);
 * double param_3 = obj.getAverageTime(startStation,endStation);
 */
