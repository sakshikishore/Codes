class Solution {
    public boolean carPooling(int[][] trips, int capacity) {
       HashMap<Integer,Integer> h=new HashMap<Integer,Integer>();
       for(int i=0;i<trips.length;i++)
       {
           int from=trips[i][1];
           int to=trips[i][2];
           for(int j=from;j<to;j++)
           {
              if(!h.containsKey(j))
              {
                  if(trips[i][0]>capacity)
                  {
                      return false;
                  }
                  h.put(j,trips[i][0]);
              }
              else
              {
                  h.put(j,h.get(j)+trips[i][0]);
                  if(h.get(j)>capacity)
                  {
                      return false;
                  }
              }
           }
       }
        
        return true;
    }
}
