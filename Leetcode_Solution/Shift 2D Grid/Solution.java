class Solution {
    public List<List<Integer>> shiftGrid(int[][] grid, int k) {
        List<List<Integer>> list=new ArrayList();
        int p=grid.length;
        int q=grid[0].length;
        int arr[][]=new int[p][q];
        for(int i=0;i<p;i++)
        {         
            for(int j=0;j<q;j++)
            {
                int r=(j+k)/q;
                r=(r+i)%p;
                arr[r][(j+k)%q]=grid[i][j];
            }
        }
        
         for(int i=0;i<p;i++)
          {   
                ArrayList<Integer> l=new ArrayList<Integer>();
                for(int j=0;j<q;j++)
                {
                    l.add(arr[i][j]);
                }
             list.add(l);
          }
        return list;
        
    }
}
