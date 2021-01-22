class Solution {
    public int[][] diagonalSort(int[][] mat) {
        for(int i=0;i<mat[0].length;i++)
        {
            ArrayList<Integer> l=new ArrayList<Integer>();
            int p=0,q=i;
            
            while(p<mat.length && q<mat[0].length)
            {  
                l.add(mat[p][q]);
                p++;
                q++;
            }
            Collections.sort(l);
            p=0;q=i;
            while(p<mat.length && q<mat[0].length)
            {  
               mat[p][q]=l.get(p);
                p++;
                q++;
            }
        }
        
        for(int i=1;i<mat.length;i++)
        {
            int p=i,q=0;
            ArrayList<Integer> l=new ArrayList<Integer>();
            while(p<mat.length && q<mat[0].length)
            {
               l.add(mat[p][q]);
                p++;
                q++;
            }
            Collections.sort(l);
            p=i;
            q=0;
            while(p<mat.length && q<mat[0].length)
            {  
               mat[p][q]=l.get(q);
                p++;
                q++;
            }
            
        }
        
        return mat;
    }
}
