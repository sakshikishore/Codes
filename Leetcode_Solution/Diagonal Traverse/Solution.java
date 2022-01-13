class Solution {
    public int[] findDiagonalOrder(int[][] mat) {
        int arr[]=new int[mat.length*mat[0].length];
        int count=0;
        for(int i=0;i<mat[0].length;i++)
        {
            if(i%2!=0)
            {
                int p=0;
                int q=i;
                while(p<mat.length && q>=0)
                {
                    arr[count]=mat[p][q];
                    p++;
                    q--;
                    count++;
                }  
            }
                
            else
            {
               
                ArrayList<Integer> l=new ArrayList<Integer>();
                int p=0;
                int q=i;
                while(p<mat.length && q>=0)
                {
                    l.add(mat[p][q]);
                    p++;
                    q--;
                }  
                Collections.reverse(l);
                for(int j=0;j<l.size();j++)
                {
                    arr[count]=l.get(j);
                    count++;
                }
            }
        }
        int flag=0;
        if(mat[0].length%2!=0)
        {
            flag=1;
        }
        for(int i=1;i<mat.length;i++)       
        {
            if(flag==1)
            {
                int p=i;
                int q=mat[0].length-1;
                while(p<mat.length && q>=0)
                {
                    arr[count]=mat[p][q];
                    p++;
                    q--;
                    count++;
                }
                flag=0;
            }
            else
            {
                ArrayList<Integer> l=new ArrayList<Integer>();
                int p=i;
                int q=mat[0].length-1;
                while(p<mat.length && q>=0)
                {
                    l.add(mat[p][q]);
                    p++;
                    q--;
                }  
                Collections.reverse(l);
                for(int j=0;j<l.size();j++)
                {
                    arr[count]=l.get(j);
                    count++;
                }
                flag=1;
            }
        }
        
        return arr;
        
        
    }
}
