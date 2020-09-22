class Solution {
    public int[] numberOfLines(int[] widths, String S) {
        int sum=0;
        int lines=0;
        for(int i=0;i<S.length();i++)
        {
            int p=widths[S.charAt(i)-'a'];
            if(sum+p==100)
            {
                lines=lines+1;
                sum=0;
            }
            else
            {
                if(sum+p>100)
                {
                     lines=lines+1;
                     sum=p;
                }
                else
                {
                    sum=sum+p;
                }
            }
        }
        
        int result[]=new int[2];
        if(sum!=0)
        {
            lines=lines+1;
        }        
        if(lines>0)
        {
           if(sum==0)
           {
               sum=100;
           }
            
        }
        
        
         result[1]=sum;
         result[0]=lines;
         return result;
        
    }
}
