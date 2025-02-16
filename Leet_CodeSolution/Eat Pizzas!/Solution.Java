class Solution {
    public long maxWeight(int[] pizzas) {
        Arrays.sort(pizzas);
        long result=0;
        int n=pizzas.length/4;
        if(n==1)
        {
            return pizzas[3];
        }
        if(n%2==0)
        {
            int p=n/2;
            int i=pizzas.length-1;
              while(i>=0)
               {
                   result+=pizzas[i];
                   p--;
                   i--;
                   if(p==0)
                   {
                       break;
                   }       
               }
            p=n/2;
            while(i>=0)
                {
                    p--;
                    i--;
                    result+=pizzas[i];
                    i--;
                    if(p==0)
                    {
                        break;
                    }
                }
        }
        else
        {
            int p=n/2;
            int i=pizzas.length-1;
              while(i>=0)
               {
                   result+=pizzas[i];
                   p--;
                   i--;
                   if(p==-1)
                   {
                       break;
                   }       
               }
            p=n/2;
            while(i>=0)
                {
                    p--;
                    i--;
                    result+=pizzas[i];
                    i--;
                    if(p==0)
                    {
                        break;
                    }
                }
        }
           
            
            return result;

            
    }
}
