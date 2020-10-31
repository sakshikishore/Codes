class MyCalendar {

    HashMap<Integer,Integer> h;
    public MyCalendar() {
        h=new HashMap<Integer,Integer>();
    }
    
    public boolean book(int start, int end) {
        boolean result=true;
        for(Map.Entry<Integer,Integer> m: h.entrySet())
        {
            int p=m.getKey();
            int q=m.getValue();
            if((start>p && start<q)||(start<p && end>p))
               {
                   result=false;
                   break;
               }
               else if(start==p && end==q)
               {
                   result=false;
                   break;
               }
               else if(start==p)
               {
                   result=false;
                   break;
               }
        }
               if(result==true)
               {
                   h.put(start,end);
                   
               }
        return result;
    }
}

/**
 * Your MyCalendar object will be instantiated and called as such:
 * MyCalendar obj = new MyCalendar();
 * boolean param_1 = obj.book(start,end);
 */
