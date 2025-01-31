class Solution {
    public int leastBricks(List<List<Integer>> wall) {
        HashMap<Long,Integer> map=new HashMap<Long,Integer>();
        for(int i=0;i<wall.size();i++)
        {
            long p=0;
            for(int j=0;j<wall.get(i).size()-1;j++)
            {
                 p=p+wall.get(i).get(j);
                 if(!map.containsKey(p))
                 {
                    map.put(p,1);
                 }
                 else
                 {
                    map.put(p,map.get(p)+1);
                 }
            }
        }
        if(map.size()==0)
        {
            return wall.size();
        }
        int min=wall.size();
        for(Map.Entry<Long,Integer> entry:map.entrySet())
        {
            int val=entry.getValue();
            if(wall.size()-val<min)
            {
                min=wall.size()-val;
            }
        }

        return min;
    }
}
