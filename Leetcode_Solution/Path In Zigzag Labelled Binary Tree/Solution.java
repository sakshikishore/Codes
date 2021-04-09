class Solution {
    public List<Integer> pathInZigZagTree(int label) {
        ArrayList<Integer> l=new ArrayList<Integer>();
        int p= (int)(Math.log(label)/Math.log(2));
        int result[]=new int[p+1];
        result[0]=1;
        result[p]=label;  
        int x=label;
        for(int j=p-1;j>0;j--)
        {
            int a=(int)Math.pow(2,j+1);
            int b= (int)Math.pow(2,j);
             
                int q=a;
               for(int k=q-1;k>=b;k--)
               {
                  if(a==x || (a+1)==x)
                  {
                      result[j]=k;
                      x=k;
                      break;
                  }
                   else
                   {
                       a=a+2;
                   }
               }
        }
        for(int i=0;i<result.length;i++)
        {
            l.add(result[i]);
        }
        return l;
        
    }
}
