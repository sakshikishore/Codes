class Solution {
    public int computeArea(int ax1, int ay1, int ax2, int ay2, int bx1, int by1, int bx2, int by2) {
        HashSet<Integer> hx=new HashSet<Integer>();
        HashSet<Integer> hy=new HashSet<Integer>();
        for(int i=ax1;i<=ax2;i++)
        {
            hx.add(i);
        }
        for(int i=ay1;i<=ay2;i++)
        {
            hy.add(i);
        }
       int Area=(hx.size()-1)*(hy.size()-1);
       Area+=((bx2-bx1)*(by2-by1));

       // Common Area
       int a=0,b=0;
        for(int i=bx1;i<=bx2;i++)
        {
            if(hx.contains(i))
            {
                a++;
            }
        }
        for(int i=by1;i<=by2;i++)
        {
            if(hy.contains(i))
            {
                b++;
            }
        }
        if(a!=0 && b!=0)
        {
            int commonArea=(a-1)*(b-1);
            return Area-commonArea;
        }

        return Area;

    }
}
