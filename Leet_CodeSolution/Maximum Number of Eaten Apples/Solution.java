class Solution {
    public int eatenApples(int[] apples, int[] days) {
        int result=0;
        TreeMap<Integer,Integer> tmap=new TreeMap<Integer,Integer>();
        for(int i=0;i<apples.length;i++)
        {
            if(days[i]!=0)
            {
               int rottenday=i+1+days[i];
               if(tmap.containsKey(rottenday))
               {
                   tmap.put(rottenday,tmap.get(rottenday)+apples[i]);
               }
               else
               {
                   tmap.put(rottenday,apples[i]);
               }
            }
             while(tmap.size()>0)
               {
                    int x=tmap.firstKey();
                    int val=tmap.get(x);
                    int p=x-(i+1);
                    if(p>0)
                    {
                        result++;
                        val=val-1;
                        if(val==0)
                        {
                            tmap.remove(x);
                        }
                        else
                        {
                            tmap.put(x,val);
                        }
                        break;
                    }
                    else
                    {
                        tmap.remove(x);
                    }
               }
        }
        int day=apples.length;
        for(Map.Entry<Integer,Integer> entry:tmap.entrySet())
        {
            int rottenday=entry.getKey();
            int totalApples=entry.getValue();
            int p=Math.min(totalApples,rottenday-(day+1));
            day=day+p;
            result+=p;

        }

        return result;

    }
}
