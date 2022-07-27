class Solution {
    public long interchangeableRectangles(int[][] rectangles) {
        HashMap<Double,Long> h=new HashMap<Double,Long>();
        long res=0;
        for(int i=0;i<rectangles.length;i++)
        {
            double x=(rectangles[i][0])/(rectangles[i][1]*(1.0));
            if(!h.containsKey(x))
            {
                h.put(x,1L);
            }
            else
            {
                h.put(x,h.get(x)+1);
            }
        }
        for(Map.Entry<Double,Long> entry: h.entrySet())
        {
            long val=entry.getValue();
            if(val>1)
            {
                res=res+((val)*(val-1)/2);
            }
            
        }
        return res;
    }
}
