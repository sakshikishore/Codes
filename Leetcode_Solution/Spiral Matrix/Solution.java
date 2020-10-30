class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        ArrayList<Integer> list=new ArrayList<Integer>();
        if(matrix.length>0)
        {
        int totalElement=matrix[0].length*matrix.length;
        int j=0,count=0,p=0;
        while(j<totalElement)
        {
            if(p%4==0)
            {
                for(int i=count;i<matrix[0].length-count;i++)
                {
                    list.add(matrix[count][i]);
                    j++;
                }
                p++;
            }
            if(p%4==1)
            {
                for(int i=count+1;i<matrix.length-count;i++)
                {
                    list.add(matrix[i][matrix[0].length-count-1]);
                    j++;
                }
                p++;
            }
            if(p%4==2)
            {
                if((matrix.length-count-1)!=count)
                {
                    for(int i=matrix[0].length-count-2;i>=count;i--)
                    {
                        list.add(matrix[matrix.length-count-1][i]);
                        j++;
                    }
                }
                p++;
            }
            if(p%4==3)
            {
                if((matrix[0].length-count-1)!=count)
                     {
                        for(int i=matrix.length-count-2;i>=count+1;i--)
                        {
                            list.add(matrix[i][count]);
                            j++;
                        }
                     }
                p++;
            }
            count++;
        }
       }
        
        return list;
    }
}
