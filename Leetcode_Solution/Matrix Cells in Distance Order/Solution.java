class Solution {
    public int[][] allCellsDistOrder(int rows, int cols, int rCenter, int cCenter) {
        int res[][]=new int[rows*cols][2];
        HashMap<Integer,String> h=new HashMap<Integer,String>();
        ArrayList<Integer> l=new ArrayList<Integer>();
        for(int i=0;i<rows;i++)
        {
            for(int j=0;j<cols;j++)
            {
              int p=Math.abs(i-rCenter)+Math.abs(j-cCenter);
              if(!l.contains(p))
              {
                  l.add(p);
              }
                if(!h.containsKey(p))
                {
                    h.put(p,Integer.toString(i)+" "+Integer.toString(j));
                }
                else
                {
                    h.put(p,h.get(p)+","+Integer.toString(i)+" "+Integer.toString(j));
                }
            }
        }
        
        Collections.sort(l);
        int r=0;
        for(int i=0;i<l.size();i++)
        {
            String str=h.get(l.get(i));
            if(str.contains(","))
            {
                String p[]=str.split(",");
                for(int j=0;j<p.length;j++)
                {
                    String t[]=p[j].split(" ");
                    res[r][0]=Integer.parseInt(t[0]);
                    res[r][1]=Integer.parseInt(t[1]);
                    r++;
                }
                
            }
            else
            {
                    String t[]=str.split(" ");
                    res[r][0]=Integer.parseInt(t[0]);
                    res[r][1]=Integer.parseInt(t[1]);
                    r++;
            }
        
        }
        
        return res;
        
    }
}
