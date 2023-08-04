class Solution {
    public List<List<Integer>> reconstructMatrix(int upper, int lower, int[] colsum) {
        int count=0,sum=0;
        int flag=0;
        List<List<Integer>> result=new ArrayList();
        for(int i=0;i<colsum.length;i++)
        {
            if(colsum[i]==2)
            {
                count++;
            }
            sum+=colsum[i];
        }
        if(sum!=(upper+lower))
        {
            return result;
        }
        else if(count>lower || count>upper)
        {
            return result;
        }
        else
        {
            upper=upper-count;
            lower=lower-count;
            ArrayList<Integer> row1=new ArrayList<Integer>();
            ArrayList<Integer> row2=new ArrayList<Integer>();
            for(int i=0;i<colsum.length;i++)
            {
                 if(colsum[i]==2)
                 {
                     row1.add(1);
                     row2.add(1);
                 }
                 else if(colsum[i]==1)
                 {
                     if(upper==0 && lower==0)
                     {
                         flag=1;
                         break;
                     }
                     if(upper!=0)
                     {
                         row1.add(1);
                         row2.add(0);
                         upper--;
                     }
                     else
                     {
                         row2.add(1);
                         row1.add(0); 
                         lower--;
                     }
                 }
                 else
                 {
                     row1.add(0);
                     row2.add(0);
                 }
            }
            if(flag==0)
            {
                result.add(row1);
                result.add(row2);
            }

            return result;
        }
    }
}
