class Solution {
    public boolean haveConflict(String[] event1, String[] event2) {
        int start1=Integer.parseInt(event1[0].substring(0,2))*60+Integer.parseInt(event1[0].substring(3));
        int end1=Integer.parseInt(event1[1].substring(0,2))*60+Integer.parseInt(event1[1].substring(3));
        
        int start2=Integer.parseInt(event2[0].substring(0,2))*60+Integer.parseInt(event2[0].substring(3));
        int end2=Integer.parseInt(event2[1].substring(0,2))*60+Integer.parseInt(event2[1].substring(3));
        
        if(start2>=start1 && start2<=end1)
        {
            return true;
        }
        if(end2>=start1 && end2<=end1)
        {
            return true;
        }
        if(start1>=start2 && start1<=end2)
        {
            return true;
        }
        if(end1>=start2 && end1<=end2)
        {
            return true;
        }
        if(start2==end1 || start2==start1 || end1==end2 || start1==end2)
        {
            return true;
        }
        
        return false;
    }
}
