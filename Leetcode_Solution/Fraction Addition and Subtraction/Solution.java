class Solution {
    public String fractionAddition(String expression) {
       Queue<Integer> q=new LinkedList<Integer>();
        ArrayList<Integer> l=new ArrayList<Integer>();
        int i=0;
        int flag=0;
        int lcm=0;
        while(i<expression.length())
        {
            if(expression.charAt(i)=='-')
            {
                int x=Integer.parseInt(expression.substring(i+1,i+2));
                i=i+2;
                if(x==1 && i<expression.length() && expression.charAt(i)=='0')
                {
                    x=10;
                    i++;
                }
                q.add(-1*x);

            }
            else if(expression.charAt(i)=='+')
            {
                int x=Integer.parseInt(expression.substring(i+1,i+2));
                i=i+2;
                if(x==1 && i<expression.length() && expression.charAt(i)=='0')
                {
                    x=10;
                    i++;
                }
                q.add(x);
            }
            else if(expression.charAt(i)=='/')
            {
                int x=Integer.parseInt(expression.substring(i+1,i+2));
                i=i+2;
                if(x==1 && i<expression.length() && expression.charAt(i)=='0')
                {
                    x=10;
                    i++;
                }
               l.add(x);
               if(flag==0)
               {
                  lcm=x;
                   flag=1;
               }
               else
               {
                   int prod=lcm*x;
                   int a=lcm,b=x;
                   while(b!=0)
                   {
                       int r=a%b;
                       a=b;
                       b=r;
                   }
                   
                   lcm=prod/a;
               }                
            }
            else
            {
                int x=Integer.parseInt(expression.substring(i,i+1));
                i++;
                if(x==1 && i<expression.length() && expression.charAt(i)=='0')
                {
                    x=10;
                    i++;
                }
                q.add(x);
            }
        }
        int numerator=0;
        int k=0;
        while(q.size()>0)
        {
            int x=q.poll();
            int p=l.get(k);
            int t=lcm/p;
            k++;
            numerator+=(x*t);
        }
        if(numerator==0)
        {
            return "0/1";
        }
        int a=numerator,b=lcm;
        if(a<0)
        {
            a=a*-1;
        }
        while(b!=0)
        {
            int r=a%b;
            a=b;
            b=r;
        }
        numerator=numerator/a;
        int denominator=lcm/a;
        return numerator+"/"+denominator;
        
    }
}
