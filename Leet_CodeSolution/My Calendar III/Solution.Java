class MyCalendarThree {
     TreeMap<Integer,Integer> map;
    public MyCalendarThree() {
        map=new TreeMap<Integer,Integer>(); 
    }
    
    public int book(int startTime, int endTime) {
        if(!map.containsKey(startTime))
        {
            map.put(startTime,1);
        }
        else
        {
            map.put(startTime,map.get(startTime)+1);
        }
         if(!map.containsKey(endTime))
        {
            map.put(endTime,-1);
        }
        else
        {
            map.put(endTime,map.get(endTime)-1);
        }
         int total=0,max=0;
        for(Map.Entry<Integer,Integer> entry:map.entrySet())
        {
           int x=entry.getValue();
           total=total+x;
           if(total>max)
           {
             max=total;
           }
        }

        return max;
    }
}

/**
 * Your MyCalendarThree object will be instantiated and called as such:
 * MyCalendarThree obj = new MyCalendarThree();
 * int param_1 = obj.book(startTime,endTime);
 */
