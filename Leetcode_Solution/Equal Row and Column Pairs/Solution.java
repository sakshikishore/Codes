class Solution {
    public int equalPairs(int[][] grid) {
 HashMap<ArrayList<Integer>,Integer> rowMap=new HashMap<ArrayList<Integer>,Integer>();
        int count=0;
        for(int i=0;i<grid.length;i++)
        {
            ArrayList<Integer> l=new ArrayList<Integer>();
            for(int j=0;j<grid[0].length;j++)
            {
                l.add(grid[i][j]);
            }
            if(!rowMap.containsKey(l))
            {
                rowMap.put(l,1);
            }
            else
            {
                rowMap.put(l,rowMap.get(l)+1);
            }
        }
/****************************************************************/
         for(int i=0;i<grid[0].length;i++)
        {
            ArrayList<Integer> l=new ArrayList<Integer>();
            for(int j=0;j<grid.length;j++)
            {
                l.add(grid[j][i]);
            }
            if(rowMap.containsKey(l))
            {
                count=count+rowMap.get(l);
            }
         }
        
        
   return count;
    }
}
