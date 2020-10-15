class MapSum {

    /** Initialize your data structure here. */
    HashMap<String,Integer> h;
    public MapSum() {
        h=new HashMap<String,Integer>();
    }
    
    public void insert(String key, int val) {
        
              h.put(key,val);            
    }
    
    public int sum(String prefix) {
        int result=0;
        for(Map.Entry<String,Integer> m:h.entrySet())
        {
            String str=m.getKey();
            if(str.length()>=prefix.length())
            {
                if(str.substring(0,prefix.length()).equals(prefix))
                {
                    result=result+m.getValue();
                }
            }
        }
               
        return result;
        
    }
}

/**
 * Your MapSum object will be instantiated and called as such:
 * MapSum obj = new MapSum();
 * obj.insert(key,val);
 * int param_2 = obj.sum(prefix);
 */
