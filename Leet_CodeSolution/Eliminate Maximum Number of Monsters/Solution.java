class Solution {
    public int eliminateMaximum(int[] dist, int[] speed) {
        TreeMap<Double,ArrayList<Integer>> map=new TreeMap<Double,ArrayList<Integer>>();
        for(int i=0;i<dist.length;i++)
        {
            double time=(dist[i]*1.0)/speed[i];
            if(!map.containsKey(time))
            {
                ArrayList<Integer> list=new ArrayList<Integer>();
                list.add(i);
                map.put(time,list);
            }
            else
            {
                ArrayList<Integer> list=map.get(time);
                list.add(i);
                map.put(time,list);
            }
        }
        int result=0;
        while(map.size()>0)
        {
            double key=map.firstKey();
            ArrayList<Integer> list=map.get(key);
            int index=list.get(0);
            list.remove(0);
            if(list.size()==0)
            {
                map.remove(key);
            }
            else
            {
                map.put(key,list);
            }

            int p=result*speed[index];
            int x=dist[index]-p;
            if(x<=0)
            {
                break;
            }
            else
            {
                result++;
            }
        }
    
       return result;
    }
}
