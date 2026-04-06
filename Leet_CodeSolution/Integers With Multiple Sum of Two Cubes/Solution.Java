class Solution {
    public List<Integer> findGoodIntegers(int n) {
     ArrayList<Integer> result=new ArrayList<Integer>();
     HashMap<Integer,Integer> h=new HashMap<Integer,Integer>();
     HashSet<Integer> hset=new HashSet<Integer>();
     double p=Math.cbrt(n);
     int cbrt=(int)Math.ceil(p);
     for(int i=1;i<cbrt; i++)
     {
        for(int j=i+1;j<cbrt;j++)
        {
               int x=i*i*i;
               int y=j*j*j;
               if(!h.containsKey(x+y) && x+y<=n)
               {
                  h.put(x+y,1);
               }
               else if(h.containsKey(x+y))
               {
                if(!hset.contains(x+y))
                {
                    hset.add(x+y);
                result.add(x+y);
                }
               }
               else
               {
                 break;
               }
            }
     }

      Collections.sort(result);

        return result;
    }
}
