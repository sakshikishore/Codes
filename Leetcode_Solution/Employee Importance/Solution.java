class Solution {
    public int getImportance(List<Employee> employees, int id) {
        HashMap<Integer,ArrayList<Integer>> h=new HashMap<Integer,ArrayList<Integer>>();
        for(int i=0;i<employees.size();i++)
        {
            ArrayList<Integer> l=new ArrayList<Integer>();
            l.add(employees.get(i).importance);
            for(int j=0;j<employees.get(i).subordinates.size();j++)
            {
                l.add(employees.get(i).subordinates.get(j));
            }
            h.put(employees.get(i).id,l);
        }
        
        Queue<Integer> q=new LinkedList<Integer>();
        q.add(id);
        int total_importance=0;
        while(q.size()!=0)
        {
            int x=q.poll();
            ArrayList<Integer> l=h.get(x);
            total_importance+=l.get(0);
            for(int j=1;j<l.size();j++)
            {
                q.add(l.get(j));
            }
            
        }
         return total_importance;
    }
}
