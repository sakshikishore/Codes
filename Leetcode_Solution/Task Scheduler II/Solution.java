class Solution {
    public long taskSchedulerII(int[] tasks, int space) {
        long day=0;
        HashMap<Integer,Long> h=new HashMap<Integer,Long>();
        for(int i=0;i<tasks.length;i++)    
        {
            day++;
            if(!h.containsKey(tasks[i]))
            {
                h.put(tasks[i],day+space);
            }
            else
            {
                if(h.get(tasks[i])<day)
                {
                     h.put(tasks[i],day+space);
                }
                else
                {
                    long x=h.get(tasks[i])-day;
                    day+=x+1;
                    h.put(tasks[i],day+space);
                }
            }
        }
       
        
        return day;
    }
}
