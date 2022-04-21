class TimeMap {
    HashMap<Integer,String> h;

    public TimeMap() {
        h=new HashMap<Integer,String>();
    }
    
    public void set(String key, String value, int timestamp) {
          h.put(timestamp,key+" "+value);
    }
    
    public String get(String key, int timestamp) {
        String value="";
        for(int i=timestamp;i>=1;i--)
        {
            if(h.containsKey(i))
            {
                String p[]=h.get(i).split(" ");
                if(p[0].equals(key))
                {
                    value=p[1];
                     break;
                }
            }
        }
         
        return value;
    }
}
