class Solution {
    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
        boolean result=false;
        ArrayList<Integer> l=new ArrayList<Integer>();
        l.add(0);
        for(int i=0;i<l.size();i++)
        {
            for(int j=0;j<rooms.get(l.get(i)).size();j++)
            {
                if(!l.contains(rooms.get(l.get(i)).get(j)))
                {
                    l.add(rooms.get(l.get(i)).get(j));
                }
            }
        }
        
        if(l.size()==rooms.size())
        {
            result=true;
        }
        
        return result;
        
    }
}
