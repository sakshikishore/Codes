class Solution {
    public List<String> findHighAccessEmployees(List<List<String>> access_times) {
        HashMap<String,ArrayList<Integer>> h=new HashMap<String,ArrayList<Integer>>();
        ArrayList<String> result=new ArrayList<String>();
        for(int i=0;i<access_times.size();i++)
        {
            String user=access_times.get(i).get(0);
            int time=Integer.parseInt(access_times.get(i).get(1).substring(0,2))*60+Integer.parseInt(access_times.get(i).get(1).substring(2));
            if(!h.containsKey(user))
            {
                ArrayList<Integer> l=new ArrayList<Integer>();
                l.add(time);
                h.put(user,l);
            }
            else
            {
                ArrayList<Integer> l=h.get(user);
                l.add(time);
                h.put(user,l);  
            }
        }
        for(Map.Entry<String,ArrayList<Integer>> entry:h.entrySet())
        {
            ArrayList<Integer> list=entry.getValue();
            Collections.sort(list);
            for(int i=2;i<list.size();i++)
            {
                if(list.get(i)-list.get(i-2)<60)
                {
                    result.add(entry.getKey());
                    break;
                }
            }
        }
        
        return result;
    }
}
