class AuthenticationManager {
    HashMap<String,Integer> h=new HashMap<String,Integer>();
    int n=0;
    public AuthenticationManager(int timeToLive) {
        n=timeToLive;
    }
    
    public void generate(String tokenId, int currentTime) {
         h.put(tokenId,currentTime+n);
    }
    
    public void renew(String tokenId, int currentTime) {
        if(h.containsKey(tokenId))
        {
            int time=h.get(tokenId);
            if(time>currentTime)
            {
                h.put(tokenId,currentTime+n);
            }
        }
    }
    
    public int countUnexpiredTokens(int currentTime) {
        int count=0;
        for(Map.Entry<String,Integer> entry:h.entrySet())
        {
            int time=entry.getValue();
            if(currentTime<time)
            {
                count++;
            }

        }
        return count;
    }
}
